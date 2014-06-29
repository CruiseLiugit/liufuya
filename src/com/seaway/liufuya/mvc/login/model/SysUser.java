package com.seaway.liufuya.mvc.login.model;

import java.io.Serializable;
import java.util.Date;


import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;


/**
 * 系统用户实体类
 * @author miaohanbin
 *
 */
@Table("sys_user")
public class SysUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;//用户ID，唯一编号,系统自动增长
	
	@Column("user_code")
	private String userCode;//用户唯一编码，编码唯一

	@Column("login_name")
	private String loginName;

	@Column("log_pwd")
	private String logPwd;

	@Column("user_name")
	private String userName;   //真实姓名

	@Column("email")
	private String email;

	@Column("user_phone")
	private String userPhone;

	//用户类型，1系统用户 2 卖家用户
	@Column("user_type")
	private String userType;

	//卖家编码
	@Column("seller_code")
	private String sellerCode;

	@Column("create_date")
	private Date createDate;

	@Column("status")
	private String status;
	
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLogPwd() {
		return logPwd;
	}
	public void setLogPwd(String logPwd) {
		this.logPwd = logPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSellerCode() {
		return sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
