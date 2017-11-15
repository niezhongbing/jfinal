package com.jfinal.Rotue;

import com.jfinal.config.Routes;
import com.jfinal.controller.IndexController;
import com.jfinal.interceptor.AdminRouteInterceptor;
import com.jfinal.interceptor.FrontRouteInterceptor;

/**
 * 前端路由控制
 * @author Administrator
 *
 */
public class FrontRoute extends Routes{

	@Override
	public void config() {
		setBaseViewPath("/front");
		addInterceptor(new FrontRouteInterceptor());
		add("/",IndexController.class);

	}

}
