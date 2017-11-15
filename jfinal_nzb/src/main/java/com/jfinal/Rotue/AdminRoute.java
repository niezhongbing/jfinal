package com.jfinal.Rotue;

import com.jfinal.config.Routes;
import com.jfinal.controller.Index2Controller;
import com.jfinal.interceptor.AdminRouteInterceptor;

/**
 * 后端路由控制
 * @author Administrator
 *
 */
public class AdminRoute extends Routes{

	@Override
	public void config() {
		// TODO Auto-generated method stub
		setBaseViewPath("/WEB-INF");
		addInterceptor(new AdminRouteInterceptor());
		add("/s",Index2Controller.class,"/admin/s");
	}

}
