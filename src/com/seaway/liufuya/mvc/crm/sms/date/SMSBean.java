package com.seaway.liufuya.mvc.crm.sms.date;

import java.util.Date;

/**
 * 短信bean
 * 
 * @author zg
 * **/
public class SMSBean {

	
	 private String smsCode;//短信编码
	 private String smsType;//`0表示 注册时发送的短信、1 表示找回密码时发送的短信、2表示订购成功时发送的短信、3表示付款成功，积分生成时发送的短信',
	 private String smsFor;// '0表示 为订单系统、1 表示为后台管理系统 不同类型用户使用的短信',
	 private String smsContent;//`'短信内容',
	 private  Date createDate;//'设置时间',
	 private String  createPerson;// '管理员名称',
	 private String  remark;//`  '备注',
	 private String  status;//  '0表示 删除 1 表示正常',
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	public String getSmsFor() {
		return smsFor;
	}
	public void setSmsFor(String smsFor) {
		this.smsFor = smsFor;
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	 
}
