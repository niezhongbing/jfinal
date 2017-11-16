package com.jfinal.volidator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {
	
	protected void validate(Controller c) {
		validateRequiredString("title", "title", "请输入标题");
		validateRequiredString("content", "content", "请输入内容");
		
	}

	protected void handleError(Controller c) {
		if(!c.getPara("title").equals(""))
			c.keepPara("title");
		if(!c.getPara("content").equals(""))
			c.keepPara("content");
		c.render("login.html");
	}
}
