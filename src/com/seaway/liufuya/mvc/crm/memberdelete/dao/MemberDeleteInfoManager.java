package com.seaway.liufuya.mvc.crm.memberdelete.dao;

import java.util.List;
import com.seaway.liufuya.mvc.crm.memberdelete.data.MemberDeleteInfoBean;

/**
 * 黑名单那管理
 * 
 * @author zhougang
 * **/
public interface MemberDeleteInfoManager {

	/**
	 * 显示所有黑名单会员信息
	 * 
	 * **/
	public List<MemberDeleteInfoBean> getMemberDeleteInfoBeanList();
	
	
	/**
	 * 把会员从黑名单中移除
	 * **/
	public void removeMemberDeleteInfoBean(String userCode,String loginName);
	
	/**
	 * 添加黑名单**/
	public void addMemberDeleteInfoBeanList(MemberDeleteInfoBean memberDeleteInfo);
	
}
