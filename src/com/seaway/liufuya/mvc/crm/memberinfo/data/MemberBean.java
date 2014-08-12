package com.seaway.liufuya.mvc.crm.memberinfo.data;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;

import com.seaway.liufuya.common.NotNull;
import com.seaway.liufuya.common.SelectBox;
import com.vaadin.data.fieldgroup.Caption;

/**
 * 用于封装 WEB-INF/jsp/5member/memberInfoList.jsp 页面中要显示的数据
 * 
 * @author lililiu
 * 
 */
@SuppressWarnings("serial")
public class MemberBean {

	// "手机号码","名称", "性别", "类型","城市","实体卡号","积分","余额","注册日期"
	private int id;
	private String usercode; // 会员编码(随机数字)

	private String loginname; // 会员手机号码，登录名
	private String realname; // 真实姓名
	private String usersex; // 性别
	private String usertype; // 会员注册类型
	private String city; // 所在城市
	private String createdate; // 注册日期

	private String cardid; // 实体卡号
	private int cardbalance; // 会员卡余额
	private int cardscore; // 会员卡总积分

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public int getCardbalance() {
		return cardbalance;
	}

	public void setCardbalance(int cardbalance) {
		this.cardbalance = cardbalance;
	}

	public int getCardscore() {
		return cardscore;
	}

	public void setCardscore(int cardscore) {
		this.cardscore = cardscore;
	}

}
