package com.jfinal.service;

import com.jfinal.aop.Before;
import com.jfinal.interceptor.InjectInterceptor;

@Before(InjectInterceptor.class)
public class ServiceImpl1 {

	public void testInject(){
		System.out.println("ServiceImpl1 testInject....");
	}
	
	public void common(){
		System.out.println(" ServiceImpl1 common");
	}
}
