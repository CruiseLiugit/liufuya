package com.seaway.liufuya.mvc.crm.memberinfo.dao;

import java.util.List;

import com.seaway.liufuya.mvc.crm.memberinfo.data.Citypart;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.vaadin.data.util.BeanItemContainer;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;


public interface MemberInfoManager {

	/**
	 * 查询所有 会员列表显示的数据
	 * @param queryMetaData
	 * @param propertyNames
	 * @return
	 */
	//public List<MemberInfoReference> getMemberBeanReferences(QueryMetaData queryMetaData, String... propertyNames);
    
    //单纯从数据库获取满足条件的所有会员信息对象列表
	public List<MemberBean> getMemberBeanList();
	
	//------------------------------
	//2014-07-12 新增。查询数据库城市表格 lfy_citypart
	//方法一 查询顶级城市
	public List<Citypart> getTopCityList();
	//方法二 根据顶级城市 id 查询二级区域
	public List<Citypart> getSecondCityList(int topid);
	
	//根据会员登录名(手机号码)查询所有信息
	public Member getMemeberByLoginname(String loginname);
	
	//报表模块使用
	public List<Member> getMemberList();

}
