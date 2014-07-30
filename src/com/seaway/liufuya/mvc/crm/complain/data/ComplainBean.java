package com.seaway.liufuya.mvc.crm.complain.data;

import java.util.Date;

/**
 * 诉求Bean
 * 
 * @author zg
 * */
public class ComplainBean {
	
	private String complainCode;//诉求代码
	private String typeName;//诉求类型代码
	private String relName;//会员代码
	private String telPhone;//会员电话
	private Date createTime;//诉求时间
	private String adminPerson;//处理人
	private String complainContent;//诉求内容
	private String isOk;//回复状态  0回复完毕  1未回复
	private String remark;//回复内容
	private Date updateDate;//处理时间
	
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getComplainCode() {
		return complainCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public void setComplainCode(String complainCode) {
		this.complainCode = complainCode;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAdminPerson() {
		return adminPerson;
	}
	public void setAdminPerson(String adminPerson) {
		this.adminPerson = adminPerson;
	}
	public String getComplainContent() {
		return complainContent;
	}
	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}
	public String getIsOk() {
		return isOk;
	}
	public void setIsOk(String isOk) {
		this.isOk = isOk;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
