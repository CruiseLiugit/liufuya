package com.seaway.liufuya.mvc.weixinstore.product.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.seaway.liufuya.common.uuid.RandomCode;
import com.seaway.liufuya.mvc.weixinstore.product.dao.WXProductManager;
import com.seaway.liufuya.mvc.weixinstore.product.data.CategoryBean;
import com.seaway.liufuya.mvc.weixinstore.product.data.WXProduct;

public class WXProductService {

	private WXProductManager manager;
	public WXProductService(WXProductManager manager){
		this.manager = manager;
	}
	
	/**
	 * 获得所有商品类别
	 * 
	 * @author zg
	 * */
	public List<CategoryBean> getAllCategory(){
		return manager.findAllExRuleCodeAndName();
	}
	
	/**
	 * 获得所有产品
	 * 
	 * @author zg
	 * **/
	public List<WXProduct> getAllProduct(){
		return manager.getAllProduct();
	}
	
	/**
	 * 新增一个产品
	 * 
	 * @author zg
	 * **/
	public   void addProduct(WXProduct product){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
		product.setCreate_date(sf.format(new Date()));
		product.setProductCode(new RandomCode().generateNumberString("PC", 4));
		product.setUpdate_date(sf.format(new Date()));
		manager.addEXProduct(product);
	}
	
	/**
	 * 更新一个product
	 * 
	 * @author zg
	 * **/
	public void updateProduct(WXProduct product){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
		product.setUpdate_date(sf.format(new Date()));
		manager.updateEXProduct(product);
	}
	/**
	 * 通过产品类型code获得产品名
	 * 
	 * @author zg
	 * **/
	public String getCategoryName(String code){
		return manager.getCategoryName(code).get(0);
	}
	
	/**
	 * 通过产品类型名获得产品code
	 * 
	 * @author zg
	 * **/
	public String getCategoryCode(String name){
		return manager.getCategoryCode(name).get(0);
	}
	
}
