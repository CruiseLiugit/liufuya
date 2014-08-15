package com.seaway.liufuya.mvc.system.storeaddress.service;

import java.util.List;

import com.seaway.liufuya.mvc.crm.exchangeproduct.dao.EXProductManager;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProductBean;
import com.seaway.liufuya.mvc.system.storeaddress.dao.StoreDaoImpl;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreBean;

public class StoreAddressService {

	private StoreDaoImpl expManager = null;
	
	public StoreAddressService(){
		
	}
	
	public StoreAddressService(StoreDaoImpl manager){
		expManager = manager;
	}
	
	/**
	 * 获取总数据的条数
	 */
	public int productSize() {
        return expManager.getAllStoreAddressCount();
    }
	
	/**
	 * 分页获取产品记录
	 */
	public List<StoreBean> getStoreAddressByPage(int start,int pagerRows){
		List<StoreBean> beans=expManager.getAllstoreByPage(start, pagerRows);
		return beans;
	}
}
