package com.jfinal.controller;

import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.jfinal.interceptor.InjectInterceptor;
import com.jfinal.service.ServiceImpl1;
import com.jfinal.service.ServiceImpl2;

public class InjectController extends Controller {

	public void index(){
		ServiceImpl1 service1 = Duang.duang(ServiceImpl1.class);
		service1.common();
		service1.testInject();
		
		
		ServiceImpl2 service2 = Duang.duang(ServiceImpl2.class,InjectInterceptor.class);
		service2.common();
		service2.testInject();
		render("inject.html");
	}
}
