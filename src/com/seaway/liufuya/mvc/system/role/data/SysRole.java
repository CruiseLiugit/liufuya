package com.seaway.liufuya.mvc.system.role.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 系统角色表对应的实体类
 * 
 * @author liulili
 * 
 */
@Table("sys_role")
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column("role_code")
	private String role_code;// 角色编号

	@Column("role_name")
	private String role_name;//

	@Column("description")
	private String description;//

	@Column("is_system")
	private String is_system;// 否是是系统产生的，0否 1是 系统产生不能删除

	@Column("type")
	private String type;// 0菜单角色 1数据角色

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

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIs_system() {
		return is_system;
	}

	public void setIs_system(String is_system) {
		this.is_system = is_system;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
