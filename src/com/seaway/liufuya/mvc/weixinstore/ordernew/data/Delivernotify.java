package com.seaway.liufuya.mvc.weixinstore.ordernew.data;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 付款成功，返回数据表格
 * 
 * @author lililiu
 * 
 */
@Table("lfy_delivernotify")
public class Delivernotify implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column("sign_type")
	private String sign_type; // '签名方法取值MD5 RSA',

	@Column("input_charset")
	private String input_charset; // '字符编码取值GBK UTF-8',

	@Column("sign")
	private String sign; // '签名',

	@Column("trade_mode")
	private int trade_mode; // '交易模式 1即时到账',

	@Column("trade_state")
	private int trade_state; // '支付结果 0 成功',

	@Column("partner")
	private String partner; // '商户号之前partnerid 10位整数',

	@Column("bank_type")
	private String bank_type; // '付款银行 WX',

	@Column("bank_billno")
	private String bank_billno; // '银行订单号',

	@Column("total_fee")
	private int total_fee; // '总金额分 discount有值 相加',

	@Column("fee_type")
	private int fee_type; // '支付币种 1人民币',

	@Column("notify_id")
	private String notify_id; // '通知ID商户据此查询交易结果',

	@Column("transaction_id")
	private String transaction_id; // 微信交易单号

	@Column("out_trade_no")
	private String out_trade_no; // 第三方订单号
	@Column("attach")
	private String attach; // 商户数据包原样返回空参数不传
	@Column("time_end")
	private String time_end; // 支付完成时间
	@Column("transport_fee")
	private int transport_fee; // 物流费用
	@Column("product_fee")
	private int product_fee; // 物品费用
	@Column("discount")
	private int discount; // 折扣价格

	@Column("appid")
	private String appid; // 公众平台账户的 AppId
	@Column("openid")
	private String openid; // 购买用户的 OpenId
	@Column("issubscribe")
	private String issubscribe; // 是否关注公众号 1
	@Column("time_stamp")
	private String time_stamp; // 时间戳
	@Column("nonce_str")
	private String nonce_str; // 商户生成随机字符串
	@Column("app_signature")
	private String app_signature; // 根据支付签名( paySign)生成方法中所讲的签名方式生成的
	@Column("sign_method")
	private String sign_method; // 签名方法 SHA1

	@Column("deliver_timestamp")
	private String deliver_timestamp; // 发货时间戳,这里指的是 Linux 时间戳
	@Column("deliver_status")
	private String deliver_status; // 发货状态1成功,0失败
	@Column("deliver_msg")
	private String deliver_msg; // 发货状态信息 UTF8

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getInput_charset() {
		return input_charset;
	}

	public void setInput_charset(String input_charset) {
		this.input_charset = input_charset;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getTrade_mode() {
		return trade_mode;
	}

	public void setTrade_mode(int trade_mode) {
		this.trade_mode = trade_mode;
	}

	public int getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(int trade_state) {
		this.trade_state = trade_state;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getBank_billno() {
		return bank_billno;
	}

	public void setBank_billno(String bank_billno) {
		this.bank_billno = bank_billno;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public int getFee_type() {
		return fee_type;
	}

	public void setFee_type(int fee_type) {
		this.fee_type = fee_type;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public int getTransport_fee() {
		return transport_fee;
	}

	public void setTransport_fee(int transport_fee) {
		this.transport_fee = transport_fee;
	}

	public int getProduct_fee() {
		return product_fee;
	}

	public void setProduct_fee(int product_fee) {
		this.product_fee = product_fee;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIssubscribe() {
		return issubscribe;
	}

	public void setIssubscribe(String issubscribe) {
		this.issubscribe = issubscribe;
	}

	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getApp_signature() {
		return app_signature;
	}

	public void setApp_signature(String app_signature) {
		this.app_signature = app_signature;
	}

	public String getSign_method() {
		return sign_method;
	}

	public void setSign_method(String sign_method) {
		this.sign_method = sign_method;
	}

	public String getDeliver_timestamp() {
		return deliver_timestamp;
	}

	public void setDeliver_timestamp(String deliver_timestamp) {
		this.deliver_timestamp = deliver_timestamp;
	}

	public String getDeliver_status() {
		return deliver_status;
	}

	public void setDeliver_status(String deliver_status) {
		this.deliver_status = deliver_status;
	}

	public String getDeliver_msg() {
		return deliver_msg;
	}

	public void setDeliver_msg(String deliver_msg) {
		this.deliver_msg = deliver_msg;
	}

}
