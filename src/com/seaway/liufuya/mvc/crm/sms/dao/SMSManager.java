package com.seaway.liufuya.mvc.crm.sms.dao;

import java.util.List;

import com.seaway.liufuya.mvc.crm.sms.date.SMSBean;

/**
 * crm短信管理
 * 
 * @author zg
 * 
 * */
public interface SMSManager {


	/**
	 * 获得该类型下的所有短信
	 * 
	 * @author zg
	 * **/
	public  List<SMSBean> getSMSByType(String smsType);
	
	/**
	 * 修改短息状态
	 * 
	 * @author zg
	 * **/
	public String  updateSMSStatus(String []args);
	
	/**
	 * 增加短信
	 * 
	 * @author zg
	 * **/
	public String addSMS(String[] args);
	
	/**
	 * 删除短信
	 * 
	 * @author zg
	 * **/
	public boolean delSMS();
}
