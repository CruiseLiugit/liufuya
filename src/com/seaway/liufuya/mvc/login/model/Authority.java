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
 * 权限表
 * @author miaohanbin
 *
 */
@Table("sys_authorities")
public class Authority implements Serializable{
	
	private static final long serialVersionUID = 879047567257454110L;
	
	@Id
	private long id;//  唯一id
	
	@Name
	@Column("auth_code")
	private String authCode;//   权限编码	 
	
	@Column("is_menu")
	private String isMenu;//  是否是子菜单	
	
	@Column("model_code")
	private String menuCode;//  资源编码	
	
	@Column("menu_code")
	private String modelCode;//  模型编码
	
	@Column("create_date")
	private Date   createDate;//   创建时间
	
	@Column("status")
	private String status="1";// 状态
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(String isMenu) {
		this.isMenu = isMenu;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
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
	 
}
