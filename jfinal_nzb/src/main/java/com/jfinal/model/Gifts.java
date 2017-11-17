package com.jfinal.model;

import com.jfinal.base.model.BaseBlog;
import com.jfinal.plugin.activerecord.Model;

public class Gifts extends Model<Product>  {
	private Integer giftsId;
	private Integer proId;
	private String giftsName;
	public Integer getGiftsId() {
		return giftsId;
	}
	public void setGiftsId(Integer giftsId) {
		this.giftsId = giftsId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getGiftsName() {
		return giftsName;
	}
	public void setGiftsName(String giftsName) {
		this.giftsName = giftsName;
	}
	
	
 }
