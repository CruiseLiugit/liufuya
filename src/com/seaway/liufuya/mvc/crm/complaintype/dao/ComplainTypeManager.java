package com.seaway.liufuya.mvc.crm.complaintype.dao;

import java.util.List;

import com.seaway.liufuya.mvc.crm.complaintype.date.ComplainTypeDtilBean;


/**
 * 会员诉求管理
 * 
 * @author  zg
 * 
 * **/
public interface ComplainTypeManager {

	/**
	 * 获取诉求类别名   用于tree
	 * 
	 * @author zg
	 * **/
	public  List<String>  getComplainType();
	
	/**
	 * 获取去求类别内容   用于table显示
	 * **/
	public List<ComplainTypeDtilBean> getComplainTypeDtil(String complainType);
	
	/**
	 * 保存
	 * */
	public String save(String[] agrs);
	/**
	 * 更新
	 * **/
	public void update(String[] args);
	
	/**
	 * 删除
	 * **/
	public void delete(String[] args);
}
