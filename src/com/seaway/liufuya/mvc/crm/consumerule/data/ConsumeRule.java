package com.seaway.liufuya.mvc.crm.consumerule.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("crm_consume_rule")
public class ConsumeRule  implements Serializable{

	@Id
	private long Id;
	@Column("ruleCode")
	private String ruleCode;
	@Column("ruleName")
	private String ruleName;
	@Column("ruleType")
	private int ruleType;
	@Column("rulePrice")
	private Double rulePrice;
	@Column("rulePercent")
	private Double rulePercent;
	@Column("remark")
	private String remark;
	@Column("startDate")
	private Date startDate;
	@Column("createPerson")
	private String createPerson;
	@Column("status")
	private String status;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public int getRuleType() {
		return ruleType;
	}
	public void setRuleType(int ruleType) {
		this.ruleType = ruleType;
	}
	public Double getRulePrice() {
		return rulePrice;
	}
	public void setRulePrice(Double rulePrice) {
		this.rulePrice = rulePrice;
	}
	public Double getRulePercent() {
		return rulePercent;
	}
	public void setRulePercent(Double rulePercent) {
		this.rulePercent = rulePercent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	


	
}
