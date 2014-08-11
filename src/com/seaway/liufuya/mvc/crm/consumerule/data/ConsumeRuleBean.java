package com.seaway.liufuya.mvc.crm.consumerule.data;

import java.io.Serializable;
import java.util.Date;

public class ConsumeRuleBean  implements Serializable{

	private String ruleCode;//兑换代码
	private String ruleName;//兑换名称
	private String ruleType;//积分来源
	private String rulePercent;//兑换比例
	private String remark;//备注
	private String startDate;//创建时间
	private String createPerson;//创建人
	private String status;//状态 0表示 无效 1 表示 有效
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
	public String getRuleType() {
		return ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public String getRulePercent() {
		return rulePercent;
	}
	public void setRulePercent(String rulePercent) {
		this.rulePercent = rulePercent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
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
