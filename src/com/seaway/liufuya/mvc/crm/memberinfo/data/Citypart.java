package com.seaway.liufuya.mvc.crm.memberinfo.data;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 城市表
 * 
 * @author lililiu
 * 
 */
@Table("lfy_citypart")
public class Citypart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column("address_name")
	private String address_name = "";
	@Column("address_desc")
	private String address_desc = "";
	@Column("address_parent")
	private int address_parent; // 节点父id 顶级为-1
	@Column("status")
	private String status = "1";// '状态 1正常 0删除',

	public Citypart() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getAddress_desc() {
		return address_desc;
	}

	public void setAddress_desc(String address_desc) {
		this.address_desc = address_desc;
	}

	public int getAddress_parent() {
		return address_parent;
	}

	public void setAddress_parent(int address_parent) {
		this.address_parent = address_parent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
