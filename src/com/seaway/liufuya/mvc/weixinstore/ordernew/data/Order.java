package com.seaway.liufuya.mvc.weixinstore.ordernew.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 -- 下面两个表，我们双方共同维护。
-- 1、在线订单生成，由我来负责插入
-- 2、POS系统 按照常规间隔时间(如:5分钟)按照时间查询一下 lfy_order 表，如果有新数据，只在 storeCode 对应门店界面显示提示
-- 3、对门店店员有要求，及时看在线的订单，如果超过一定时间(如:40分钟)那么外送的订单，可能别人会不要，所以POS界面要做一个功能
--    提醒用户有新的订单，要及时查看
-- 4、外送和自取的订单都要走收款流程，
--  (1)正常收款完成，外送和自取都修改同样的字段
--          `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
--          `status` varchar(255) DEFAULT NULL COMMENT '状态 1默认未付款 0删除 2已付款 3 外送超时 4 自取超时 5 外送退货 6 未外送 7未自取',
--          `orderStatus` varchar(255) DEFAULT NULL COMMENT '订单状态 1默认待支付 2已支付 3已关闭',
--  (2)正常收款，但是超时
--     时间标准参考下面两个字段，这两个字段只做判断条件，不改动
--   自取   `pickUpTime` datetime DEFAULT NULL COMMENT '自取时间 当delivery为1 pickUpTime必填',
--   外送   `create_date` datetime DEFAULT NULL  COMMENT '外送时间 当delivery为2 超过 1 小时 status 修改为 3',
--   自取订单，超时后，status        修改为   4  自取超时
--                  orderStatus   修改为   2  已支付 
--   外送订单，超时后，status        修改为   3  外送超时
--                  orderStatus   修改为   2  已支付
--   (3)不正常收款
--   自取订单，客户未自取   当天结束后(每晚10:00)后，把今天所有自取类型客户(delivery    1)
--               订单信息修改为 status 修改为  7  未自取
--                       orderStatus 修改为  3  已关闭
--   外送订单，店员未外送   当天结束后，把今天所有外送类型客户(delivery  2)
--               订单信息修改为 status 修改为  6 未外送
--                       orderStatus 修改为  3  已关闭  
--   外送订单，店员外送被退货(这里POS 系统提供操作按钮)，订单信息修改为
--                            status 修改为  5 外送退货
--                       orderStatus 修改为  3  已关闭
 * @author lililiu
 * 
 */
@Table("lfy_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column("orderNo")
	private String orderNo;  //订单编号

	@Column("orderMoney")
	private int orderMoney;// '订单总价',

	@Column("orderTotalMoney")
	private int orderTotalMoney;// '订单实际购买价格',

	@Column("couponMoney")
	private int couponMoney;// '订单优惠价格',

	@Column("delivery")
	private String delivery;// '2外送 1自取 3 顺丰',

	@Column("storeCode")
	private String storeCode;// '门店编码 当delivery为1 storeCode必填',

	@Column("addressCode")
	private String addressCode;//

	@Column("pickUpTime")
	private Date pickUpTime;// '自取时间 当delivery为1 pickUpTime必填',

	@Column("user_tel")
	private String user_tel;// '用户联系电话 当delivery为2时必填',

	@Column("orderStatus")
	private String orderStatus;// '订单状态 1默认待支付 2已支付 3已关闭',

	@Column("create_date")
	private Date create_date;// '外送时间 当delivery为2 超过 1 小时 status 修改为 3',

	@Column("orderPayType")
	private String orderPayType;// '1.网上支付 2货到现金支付',

	@Column("pay_date")
	private Date pay_date;// '支付时间',

	@Column("userCode")
	private String userCode;// '订单用户',

	@Column("status")
	private String status;// '状态 1默认未付款 0删除 2已付款 3 外送超时 4 自取超时 5 外送退货 6 未外送
							// 7未自取',

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}

	public int getOrderTotalMoney() {
		return orderTotalMoney;
	}

	public void setOrderTotalMoney(int orderTotalMoney) {
		this.orderTotalMoney = orderTotalMoney;
	}

	public int getCouponMoney() {
		return couponMoney;
	}

	public void setCouponMoney(int couponMoney) {
		this.couponMoney = couponMoney;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public Date getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getOrderPayType() {
		return orderPayType;
	}

	public void setOrderPayType(String orderPayType) {
		this.orderPayType = orderPayType;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
