package com.seaway.liufuya.mvc.crm.complaintype.date;

import java.util.Date;

/**
 * 会员诉求内容   用于显示在table
 * 
 * **/
public class ComplainTypeDtilBean {
	private String typeName;//诉求类别名称
    private  Date createDate;//创建日期
    private String createPerson;//创建人
    private String status;
    private String remark;
    
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
    
    
}
