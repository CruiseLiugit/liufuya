package com.seaway.liufuya.mvc.login.model;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 菜单对象实体类
 * @author miaohanbin
 *
 */
@Table("sys_menus")
public class Menus implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@Column("menu_code")
	private String menuCode;
	
	@Column("menu_name")
	private String menuName;

	@Column("levelid")
	private String levelId;

	@Column("fmenu_code")
	private String fmenuCode;

	@Column("engname")
	private String engName;

	@Column("menu_url")
	private String menuUrl;

	@Column("create_date")
	private Date createDate;

	//1 正常，0 被删除
	@Column("status")
	private String status;

	@Column("sortValue")
	private int sortValue;  //排序字段
	
	
	private String authCode;
	

	public Menus() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getLevelId() {
		return levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	public String getFmenuCode() {
		return fmenuCode;
	}
	public void setFmenuCode(String fmenuCode) {
		this.fmenuCode = fmenuCode;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSortValue() {
		return sortValue;
	}
	public void setSortValue(int sortValue) {
		this.sortValue = sortValue;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	
	
}
