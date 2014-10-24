package com.seaway.liufuya.mvc.system.user.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 系统用户实体类
 * 
 * @author miaohanbin
 * 
 */
@Table("sys_user_role")
public class SysUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;// 用户ID，唯一编号,系统自动增长

	@Column("user_code")
	private String user_code;//

	@Column("role_code")
	private String role_code;//

	@Column("create_date")
	private Date create_date;//

	@Column("status")
	private String status;//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
