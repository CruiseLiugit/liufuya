package com.seaway.liufuya.mvc.crm.consumeexchange.data;

import java.util.Date;

/**
 * 积分兑换显示bean
 * 
 * @author zg
 * **/
public class ConsumeExchangeBean {

	//private String exchangeCode;
	//private String productCode;
	private String exchangeDate;//兑换日期
	private String productName;//兑换产品名称
	private String exchangeNumber;//兑换积分数目
	private String isSend;//是否发货
	private String sendPerson;//发货人
	//private String status;//状态
//	public String getExchangeCode() {
//		return exchangeCode;
//	}
//	public void setExchangeCode(String exchangeCode) {
//		this.exchangeCode = exchangeCode;
//	}
	public String getExchangeDate() {
		return exchangeDate;
	}
	public void setExchangeDate(String exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getExchangeNumber() {
		return exchangeNumber;
	}
	public void setExchangeNumber(String exchangeNumber) {
		this.exchangeNumber = exchangeNumber;
	}
	public String getIsSend() {
		return isSend;
	}
	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
	public String getSendPerson() {
		return sendPerson;
	}
	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	
	
}
