package com.seaway.liufuya.mvc.system.storeaddress.data;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 系统城市表，会员、门店会用到
 * @author miaohanbin
 *
 */
@Table("lfy_citypart")
public class Citypart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;//用户ID，唯一编号,系统自动增长
	
	@Column("address_name")
	private String addressName;//用户唯一编码，编码唯一

	@Column("address_desc")
	private String addressDesc;
	
	/**
	 * 节点父id 顶级为-1
	 */
	@Column("address_Parent")
	private int addressParent=-1;
	
	/**
	 * 状态 1正常 0删除
	 */
	@Column("status")
	private String status;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public int getAddressParent() {
		return addressParent;
	}

	public void setAddressParent(int addressParent) {
		this.addressParent = addressParent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
