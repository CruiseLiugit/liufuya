package com.seaway.liufuya.mvc.crm.memberdelete.data;

/**
 * 用于显示会员黑名单
 * 
 * @author  zhougang
 * * */
public class MemberDeleteInfoBean {

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
	private String memberStat;//黑名单
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getMemberStat() {
		return memberStat;
	}
	public void setMemberStat(String memberStat) {
		this.memberStat = memberStat;
	}
}
