package com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo;

/**
 * 用于会员扩展信息 ， 封装页面显示数据的 Bean
 * 
 * @author lililiu
 * 
 */
public class MemberAddressBean {
	private String city; // 城市
	private String area; // 区域
	private String address_keywords; // 地址
	private String gps_long; // 经度
	private String gps_lat; // 纬度
	private String is_default; // 默认地址
	private String is_available; // 能否配送
	private String create_date; // 创建日期

	public MemberAddressBean() {
		// TODO Auto-generated constructor stub
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

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

}
