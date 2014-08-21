package com.seaway.liufuya.mvc.weixinstore.generatingcoupon.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("lfywx_coupon")
public class Coupon implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@Column("couponCode")
	private String  couponCode;
	@Column("couponName")
	private String couponName;
	@Column("couponType")
	private String  couponType= "";
	@Column("couponImage")
	private String couponImage = "";
	@Column("startDate")
	private Date startDate;
	@Column("endDate")
	private Date endDate;
	@Column("avtiveTime")
	private String avtiveTime = "";
	@Column("couponTotals")
	private String couponTotals;
	@Column("couponExchanges")
	private String couponExchanges;
	@Column("couponDesc")
	private String couponDesc = "";
	@Column("isNew")
	private String isNew = "";
	@Column("createPerson")
	private String createPerson = "";
	@Column("status")
	private String status = "";
	@Column("couponValue")
	private String couponValue;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCouponType() {
		return couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
	public String getCouponImage() {
		return couponImage;
	}
	public void setCouponImage(String couponImage) {
		this.couponImage = couponImage;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAvtiveTime() {
		return avtiveTime;
	}
	public void setAvtiveTime(String avtiveTime) {
		this.avtiveTime = avtiveTime;
	}
	public String getCouponTotals() {
		return couponTotals;
	}
	public void setCouponTotals(String couponTotals) {
		this.couponTotals = couponTotals;
	}
	public String getCouponExchanges() {
		return couponExchanges;
	}
	public void setCouponExchanges(String couponExchanges) {
		this.couponExchanges = couponExchanges;
	}
	public String getCouponDesc() {
		return couponDesc;
	}
	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCouponValue() {
		return couponValue;
	}
	public void setCouponValue(String couponValue) {
		this.couponValue = String.valueOf(couponValue);
	}
	
	
}
