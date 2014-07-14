package com.seaway.liufuya.mvc.crm.memberinfo.module;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 会员卡类型对象实体类
 * 
 * @author 刘立立
 * 
 */
public class Crdt implements Serializable {
	private static final long serialVersionUID = 1L;

	private int typeID; // 卡片编码

	private String typeName; // 卡片名称
	private String medium; // 卡片类型
	private String priceMode; // 折扣模式
	private int priceList; // 价格清单
	private double required; // 办卡费用
	private double reissueFee; // 补办工本费
	private double discount; // 折率
	private String memo; // 备注
	private String maker; // 制卡人
	private Date createDate; // 创建时间

	
	
	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getPriceMode() {
		return priceMode;
	}

	public void setPriceMode(String priceMode) {
		this.priceMode = priceMode;
	}

	public int getPriceList() {
		return priceList;
	}

	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}

	public double getRequired() {
		return required;
	}

	public void setRequired(double required) {
		this.required = required;
	}

	public double getReissueFee() {
		return reissueFee;
	}

	public void setReissueFee(double reissueFee) {
		this.reissueFee = reissueFee;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}