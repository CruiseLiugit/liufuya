package com.seaway.liufuya.mvc.system.storeaddress.data;

import java.io.Serializable;

/**
 * 封装从留夫鸭 POS 系统中，获取的数据，并写入到 shopdb.sql 数据库中
 * 
 * @author lililiu
 * 
 */
public class StoreBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String store_code; // "020003",店号
	private String store_name; // "宝山区电台路店",店名
	private String manage_type;// 经营类型
	private String store_type; // 店铺类型
	private String depart_own;// 所属部门.不显示
	private String area; // 所属大区
	private String province; // 省份
	private String city; // 城市
	private String city_part; // 城区
	private int city_id; // 城市id,暂时不做
	private String store_address;// 门店地址
	private String store_director; // 主管姓名
	private String store_directorphone;// 主管电话
	private String store_assistant;// 店员姓名
	private String store_assistantphone;// 店员电话
	private String gps_lng;// 经度
	private String gps_lat;// 纬度
	private String create_date;// datetime 创建时间
	private String status;// 状态
	// empDutyID` varchar(255) DEFAULT NULL COMMENT '大区经理工号',
	// empID` varchar(255) DEFAULT NULL COMMENT '片区主管工号',
	// Payment` varchar(255) DEFAULT NULL COMMENT '收银方式',
	private String startDate;// datetime 开店日期',

	public String getStore_code() {
		return store_code;
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getManage_type() {
		return manage_type;
	}

	public void setManage_type(String manage_type) {
		this.manage_type = manage_type;
	}

	public String getStore_type() {
		return store_type;
	}

	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}

	public String getDepart_own() {
		return depart_own;
	}

	public void setDepart_own(String depart_own) {
		this.depart_own = depart_own;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_part() {
		return city_part;
	}

	public void setCity_part(String city_part) {
		this.city_part = city_part;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public String getStore_director() {
		return store_director;
	}

	public void setStore_director(String store_director) {
		this.store_director = store_director;
	}

	public String getStore_directorphone() {
		return store_directorphone;
	}

	public void setStore_directorphone(String store_directorphone) {
		this.store_directorphone = store_directorphone;
	}

	public String getStore_assistant() {
		return store_assistant;
	}

	public void setStore_assistant(String store_assistant) {
		this.store_assistant = store_assistant;
	}

	public String getStore_assistantphone() {
		return store_assistantphone;
	}

	public void setStore_assistantphone(String store_assistantphone) {
		this.store_assistantphone = store_assistantphone;
	}

	public String getGps_lng() {
		return gps_lng;
	}

	public void setGps_lng(String gps_lng) {
		this.gps_lng = gps_lng;
	}

	public String getGps_lat() {
		return gps_lat;
	}

	public void setGps_lat(String gps_lat) {
		this.gps_lat = gps_lat;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
