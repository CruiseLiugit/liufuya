package com.seaway.liufuya.mvc.login.model;

import java.io.Serializable;
import java.util.Date;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 用户角色实体类
 * @author miaohanbin
 *
 */
@Table("sys_user_role")
public class UserRole implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id ;//唯一ID    
	
	@Column("user_code")
	private String userCode= " ";  //用户编码，关联用户表USER_CODE

	@Column("role_code")  
	private String roleCode= " ";//关联角色表ROLE_CODE

	@Column("create_date")  
	private Date createDate;//   创建时间
	  
	@Column("status")  
	private String status= "1";//  状态

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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