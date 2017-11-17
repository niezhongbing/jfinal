package com.jfinal.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.volidator.LoginValidator;

public class ProductController extends Controller{
	
	public void index(){
		render("/product/product_list.html");
	}
	
	public void product_list(){
		String sql = "select a.*,b.* from product a left join gifts b on a.prodId = b.proId ";
		List<Object> query = Db.query(sql);
		renderJson(query);
	}
}
