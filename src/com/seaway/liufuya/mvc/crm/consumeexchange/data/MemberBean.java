package com.seaway.liufuya.mvc.crm.consumeexchange.data;

public class MemberBean {

	private String userCode; // 会员编码(随机数字)
	private String realname; // 真实姓名
	private String cardid; // 实体卡号
	private int cardbalance; // 会员卡余额
	private int cardscore; // 会员卡总积分
	
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
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
