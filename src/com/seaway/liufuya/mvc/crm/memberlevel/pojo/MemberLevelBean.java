package com.seaway.liufuya.mvc.crm.memberlevel.pojo;

/**
 * 客户等级，页面显示数据
 * 
 * @author lililiu
 * 
 */
public class MemberLevelBean {
	private String levelName = ""; // 等级名称
	private String levelBegin = "";// 起始值
	private String levelEnd = "";// 终止值
	private String createTime = "";// 创建时间
	private String createPerson = "";// 创建人

	public MemberLevelBean() {
		// TODO Auto-generated constructor stub
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelBegin() {
		return levelBegin;
	}

	public void setLevelBegin(String levelBegin) {
		this.levelBegin = levelBegin;
	}

	public String getLevelEnd() {
		return levelEnd;
	}

	public void setLevelEnd(String levelEnd) {
		this.levelEnd = levelEnd;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

}
