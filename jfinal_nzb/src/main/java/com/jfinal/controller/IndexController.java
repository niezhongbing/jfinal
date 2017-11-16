package com.jfinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.interceptor.Ainterceptor;
import com.jfinal.interceptor.BInterceptor;
import com.jfinal.interceptor.ClassControllerInterceptort;
import com.jfinal.interceptor.MethodIntercept;
import com.jfinal.kit.Kv;
import com.jfinal.model.Blog;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
@Before(ClassControllerInterceptort.class)
public class IndexController extends Controller{
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	
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
	
	@Before(CacheInterceptor.class)
	@CacheName("testEhcache")
	public void query(){
		String sql = "select * from blog";
		List<Object> query = Db.query(sql);
		//分页
		// Page<Blog> paginate = Blog.dao.paginate(1, 2,"select *","from blog group by title");
		
		 //如果为true就取去除重复之后，false就取相同的
		//Page<Blog> paginate = Blog.dao.paginate(1, 2,true,"select *","from blog group by title");
		
		 //第一条sql查数据的总数，第二条查询数据。查询条件要一样，查询的条数以第一条sql为主
		// Page<Blog> paginate = Blog.dao.paginateByFullSql(1, 7,"select count(*) from blog where id != 1","select * from blog where id != 1");
		 
		renderJson(query);
	}
	
	@Before(EvictInterceptor.class)
	@CacheName("testEhcache")
	public void updateEhcache(){
		getModel(Blog.class).update();
		renderJson("更新缓存成功!!!!");
		renderJson("更新缓存失败!!!");
		
	}
	
	//声明式事务，只要在这个里面有报错通通回滚所修改的
	@Before(Tx.class)
	public void update() throws Exception{
		Record record = new Record();
		Blog b1 = new Blog();
		b1.setContent("1");
		b1.setId(1);
		b1.setTitle("222");
		
		Blog b2 = new Blog();
		b2.setContent("2");
		b2.setId(null);
		b2.setTitle("2");
		
		List<Blog> list = new ArrayList<Blog>();
		list.add(b1);
		list.add(b2);
		Blog blog = getModel(Blog.class);
		int[] batchUpdate = Db.batchUpdate(list, list.size());
		//throw new Exception();
		for (int i = 0; i < batchUpdate.length; i++) {
			logger.info("batchUpdate {}",batchUpdate[i]);
		}
		render("index.html");
	}
	
	//动态生成sql
	public void sqlManager(){
		SqlPara sql = Db.getSqlPara("test1",1);
		List<Record> find = Db.find(sql);
		
		Kv cond = Kv.by("title", "3");
		SqlPara sqlPara = Db.getSqlPara("test2", cond);
		List<Record> find2 = Db.find(sqlPara);
		renderJson(find2);
	}
}
