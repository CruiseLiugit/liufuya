package com.seaway.liufuya.mvc.crm.memberinfo.data;

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
 * 会员地址对象实体类
 * 
 * @author 刘立立
 * 
 */
@Table("lfy_member_address")
public class MemberAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	//地址随机编码
	@Column("address_code")
	private String address_code;

	//会员随机编码，会员与地址关系 1:m
	@Column("user_code")
	private String user_code;

	//------------------------
	//所在城市、区域、经纬度。每条一个，如果修改地址，需要同步更新
	//所在城市
	@Column("city")
	private String city;

	//所在区域
	@Column("area")
	private String area;

	// 真实姓名
	@Column("address_keywords")
	private String address_keywords;

	// 默认地址经度
	@Column("gps_long")
	private String gps_long;

	//默认地址纬度
	@Column("gps_lat")
	private String gps_lat;

	@Column("bmaps_info")
	private String bmaps_info;

	// 周边配送符合配送条件的门店编号(Null表示无门店可以配送,有多家门店可以外送
	//存入JSON对象{"n1":"门店编号","n2":"门店编号"})
	@Column("available_shops")
	private String available_shops;

	// 地址创建时间
	@Column("create_date")
	private Date create_date;

	// 是否是默认(0 不是 1 是)
	@Column("is_default")
	private String is_default;

	// 是否可以配送 1可以 0不可以
	@Column("is_available")
	private String is_available;

	// 状态(1 正常 0 被删除 )
	@Column("status")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress_code() {
		return address_code;
	}

	public void setAddress_code(String address_code) {
		this.address_code = address_code;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress_keywords() {
		return address_keywords;
	}

	public void setAddress_keywords(String address_keywords) {
		this.address_keywords = address_keywords;
	}

	public String getGps_long() {
		return gps_long;
	}

	public void setGps_long(String gps_long) {
		this.gps_long = gps_long;
	}

	public String getGps_lat() {
		return gps_lat;
	}

	public void setGps_lat(String gps_lat) {
		this.gps_lat = gps_lat;
	}

	public String getBmaps_info() {
		return bmaps_info;
	}

	public void setBmaps_info(String bmaps_info) {
		this.bmaps_info = bmaps_info;
	}

	public String getAvailable_shops() {
		return available_shops;
	}

	public void setAvailable_shops(String available_shops) {
		this.available_shops = available_shops;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getIs_default() {
		return is_default;
	}

	public void setIs_default(String is_default) {
		this.is_default = is_default;
	}

	public String getIs_available() {
		return is_available;
	}

	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
