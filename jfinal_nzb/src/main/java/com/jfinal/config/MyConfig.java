package com.jfinal.config;

import com.jfinal.Engine.Method;
import com.jfinal.Engine.SharedObject;
import com.jfinal.Engine.StaticMethodS;
import com.jfinal.Rotue.AdminRoute;
import com.jfinal.Rotue.FrontRoute;
import com.jfinal.controller.InjectController;
import com.jfinal.controller.LoginController;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.interceptor.GlobalInterceptor;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.model._MappingKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig{

	//读取配置文件
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);
		PropKit.use("a_little_config.txt");
	}

	//路由配置路径
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/login", LoginController.class);
		/*me.add("/inject", InjectController.class);
		me.add(new FrontRoute());
		me.add(new AdminRoute());*/
	}
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
	
	//定义公共模板
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		me.setBaseTemplatePath(PathKit.getWebRootPath());
		me.addSharedFunction("/front/common.html");
		
		//将某个类的方法共享出来
		me.addSharedStaticMethod(StaticMethodS.class);
		me.addSharedMethod(Method.class);
		me.addSharedObject("sm", new SharedObject());
	}

	//配置插件
	@Override
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		
		//通过SQL文件读取SQL
		arp.setBaseSqlTemplatePath(PathKit.getWebRootPath()+"/WEB-INF");
		arp.addSqlTemplate("sql/jfinal.sql");
		
		// 所有映射在 MappingKit 中自动化搞定
		_MappingKit.mapping(arp);
		me.add(arp);
		
		
		//缓存
		me.add(new EhCachePlugin());
		
		
		//任务调度
		Cron4jPlugin cron = new Cron4jPlugin(PropKit.use("cron.txt"));
		me.add(cron);
	}

	//配置拦截器
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new GlobalInterceptor());
		//me.addGlobalServiceInterceptor(new InjectInterceptor());
	}

	//接管所有 web 请求，并对应用拥有完全的控制权
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new ContextPathHandler("ctx"));
	}
	
	
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 8091, "/", 5);

	}
}
