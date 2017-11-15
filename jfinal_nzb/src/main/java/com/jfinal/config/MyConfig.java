package com.jfinal.config;

import com.jfinal.Rotue.AdminRoute;
import com.jfinal.Rotue.FrontRoute;
import com.jfinal.controller.InjectController;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.interceptor.GlobalInterceptor;
import com.jfinal.interceptor.InjectInterceptor;
import com.jfinal.kit.PropKit;
import com.jfinal.model._MappingKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);
		PropKit.use("a_little_config.txt");
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/inject", InjectController.class);
		me.add(new FrontRoute());
		me.add(new AdminRoute());
	}
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
	}

	@Override
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 所有映射在 MappingKit 中自动化搞定
		_MappingKit.mapping(arp);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new GlobalInterceptor());
		//me.addGlobalServiceInterceptor(new InjectInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new ContextPathHandler("ctx"));
	}
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 8091, "/", 5);

	}
}
