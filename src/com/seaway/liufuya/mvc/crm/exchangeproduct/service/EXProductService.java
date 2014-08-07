package com.seaway.liufuya.mvc.crm.exchangeproduct.service;

import java.util.List;

import com.seaway.liufuya.mvc.crm.exchangeproduct.dao.EXProductManager;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProductBean;

public class EXProductService {

	private EXProductManager expManager = null;
	
	public EXProductService(){
		
	}
	
	public EXProductService(EXProductManager manager){
		expManager = manager;
	}
	
	/**
	 * 获取总数据的条数
	 * 
	 * @author zg
	 * **/
	public int productSize() {
        return expManager.getAllProductCount();
    }
	
	/**
	 * 分页获取产品记录
	 * 
	 * @author zg
	 * **/
	public List<EXProductBean> getExProductByPage(int start,int pagerRows){
		List<EXProductBean> beans=expManager.getAllProductByPage(start, pagerRows);
		return beans;
	}
}
