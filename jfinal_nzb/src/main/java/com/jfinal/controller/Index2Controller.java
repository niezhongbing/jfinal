package com.jfinal.controller;

import com.jfinal.core.Controller;

public class Index2Controller extends Controller {

	public void index(){
		setAttr("msg", "我是indexController2");
		renderTemplate("index.html");
	}
}
