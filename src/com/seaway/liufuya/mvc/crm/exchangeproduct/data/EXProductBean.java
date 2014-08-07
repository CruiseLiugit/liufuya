package com.seaway.liufuya.mvc.crm.exchangeproduct.data;

import java.util.Date;

/**
 * bean  用于显示item
 * 
 * @author zg
 * **/

public class EXProductBean {

	//底层没有创建人
	
	private String productCode;//产品代码
	private String productName;//产品名称
	private String productDesc;//产品描述
	private String exchangeRuleCode;//兑换积分规则
	private String exchangeNumber;//兑换积分数目
	private int stockNumber;//库存数目
	private Date create_date;
	private Date update_date;
	private String isNew;//是否新品
	private String is_recommend;//是否推荐
	private String status;//状态
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getExchangeNumber() {
		return exchangeNumber;
	}
	public void setExchangeNumber(String exchangeNumber) {
		this.exchangeNumber = exchangeNumber;
	}
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getIs_recommend() {
		return is_recommend;
	}
	public void setIs_recommend(String is_recommend) {
		this.is_recommend = is_recommend;
	}
	public String getExchangeRuleCode() {
		return exchangeRuleCode;
	}
	public void setExchangeRuleCode(String exchangeRuleCode) {
		this.exchangeRuleCode = exchangeRuleCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
