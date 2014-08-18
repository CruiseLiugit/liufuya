package com.seaway.liufuya.mvc.weixinstore.ordernew.data;

import java.io.Serializable;

/**
 * 表格中显示的 订单 item 对象
 * 
 * @author lililiu
 * 
 */
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderNo = ""; // 订单编码
	private String orderTotalMoney = ""; // 订单价格
	private String couponMoney = "";// 订单优惠价格
	private String orderStatus = "";// 支付状态
	private String create_date = "";// 创建时间
	private String user_name = "";// 用户名
	private String user_tel = "";// 手机号码
	private String city = "";// 城市
	private String area = "";// 城区
	private String user_address = "";// 收货地址
	private String productName = "";// 产品名称
	private String goodsBuyQrt = "";// 产品数量

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderTotalMoney() {
		return orderTotalMoney;
	}

	public void setOrderTotalMoney(String orderTotalMoney) {
		this.orderTotalMoney = orderTotalMoney;
	}

	public String getCouponMoney() {
		return couponMoney;
	}

	public void setCouponMoney(String couponMoney) {
		this.couponMoney = couponMoney;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getGoodsBuyQrt() {
		return goodsBuyQrt;
	}

	public void setGoodsBuyQrt(String goodsBuyQrt) {
		this.goodsBuyQrt = goodsBuyQrt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
