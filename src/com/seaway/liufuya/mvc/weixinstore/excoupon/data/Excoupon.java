package com.seaway.liufuya.mvc.weixinstore.excoupon.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 优惠券兑换记录实体类
 * 
 * @author zg
 * **/
@Table("lfywx_member_coupon")
public class Excoupon implements Serializable{

	@Id
	private long id;
	
	@Column("memCouponcode")
	private String memCouponcode = "";
	
	@Column("userCode")
	private String  userCode= "";
	
	@Column("couponPageCode")
	private String  couponPageCode= "";
	
	@Column("downloadDate")
	private Date downloadDate;
	
	@Column("disableDate")
	private Date disableDate;
	
	@Column("isActive")
	private String isActive = "";
	
	@Column("isUsed")
	private String isUsed = "";
	
	@Column("status")
	private String  status= "";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMemCouponcode() {
		return memCouponcode;
	}

	public void setMemCouponcode(String memCouponcode) {
		this.memCouponcode = memCouponcode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCouponPageCode() {
		return couponPageCode;
	}

	public void setCouponPageCode(String couponPageCode) {
		this.couponPageCode = couponPageCode;
	}

	public Date getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	public Date getDisableDate() {
		return disableDate;
	}

	public void setDisableDate(Date disableDate) {
		this.disableDate = disableDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
