package com.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.volidator.LoginValidator;

public class LoginController extends Controller{
	
	
	public void index(){
		render("login.html");

	}
	@Before(LoginValidator.class)
	public void login(){
		render("/index.html");
	}
}
