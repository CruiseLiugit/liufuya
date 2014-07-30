package com.seaway.liufuya.mvc.crm.complain.dao;

import java.util.List;

import com.seaway.liufuya.mvc.crm.complain.data.ComplainBean;

/**
 * 诉求管理
 * 
 * @author zg
 * **/

public interface ComplainManager {

	/**
	 * 获得有效的诉求类型
	 * 
	 * @author zg
	 * **/
	public List<String> getComplainTyep();
	
	
	/**
	 * 获得当前诉求类型下的所有 诉求
	 * 
	 * @author zg
	 * */
	public List<ComplainBean> getComplains(String typecode);
	
	
	/**
	 * 回复诉求
	 * 
	 * @author zg
	 * **/
	public void isOk(String[] args);
}
