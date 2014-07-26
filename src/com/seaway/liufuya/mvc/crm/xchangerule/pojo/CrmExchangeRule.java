package com.seaway.liufuya.mvc.crm.xchangerule.pojo;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("crm_exchange_rule")
public class CrmExchangeRule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	private Long id;
	
	@Column("ruleCode")
	private Long ruleCode;
	
	@Column("ruleName")
	private String ruleName;
	
	@Column("ruleNumberBegin")
	private Long ruleNumberBegin;
	
	@Column("ruleNumberEnd")
	private Long ruleNumberEnd;
	
	@Column("remark")
	private String remark;
	
	@Column("startDate")
	private Date startDate;
	
	@Column("createPerson")
	private String createPerson;
	
	@Column("status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(Long ruleCode) {
		this.ruleCode = ruleCode;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Long getRuleNumberBegin() {
		return ruleNumberBegin;
	}

	public void setRuleNumberBegin(Long ruleNumberBegin) {
		this.ruleNumberBegin = ruleNumberBegin;
	}

	public Long getRuleNumberEnd() {
		return ruleNumberEnd;
	}

	public void setRuleNumberEnd(Long ruleNumberEnd) {
		this.ruleNumberEnd = ruleNumberEnd;
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
