package com.jfinal.controller;

import java.util.List;

import org.junit.BeforeClass;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.interceptor.Ainterceptor;
import com.jfinal.interceptor.BInterceptor;
import com.jfinal.interceptor.ClassControllerInterceptort;
import com.jfinal.interceptor.MethodIntercept;
import com.jfinal.model.Blog;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
@Before(ClassControllerInterceptort.class)
public class IndexController extends Controller{

	@Before(MethodIntercept.class)
	public void index(){
		String id = getPara("msg","default");
		setAttr("msg", "欢迎访问jfinal---->" + id);
		getModel(Blog.class);
		renderTemplate("index.html");
	}
	
	public void add(){
		renderTemplate("add.html");
	}
	
	public void doAdd(){
		Blog blog = getModel(Blog.class,"b");
		
		/*第一种操作数据库方法
		 * blog.save();*/
		
		//第二种操作数据库方法
		Record record = new Record();
		record.setColumns(blog);
		Db.save("blog", record);
		
		renderText("提交成功");
	}
	
	@Before({Ainterceptor.class,BInterceptor.class})
	public void testInterceptorStack(){
		render("index.html");
	}
	
	public void query(){
		 Page<Blog> paginate = Blog.dao.paginate(1, 2,  "select *","from blog");
		renderJson(paginate);
	}
	public void update(){
		
	}
}
