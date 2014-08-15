package com.seaway.liufuya.mvc.system.storeaddress.data;
import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 门店表对应的实体类
 * 
 * @author liulili
 * 
 */
@Table("lfy_store_address")
public class StoreAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column("store_code")
	private String store_code;// 门店编号

	@Column("store_name")
	private String store_name;// 门店名称

	@Column("manage_type")
	private String manage_type;// 经营类型

	@Column("store_type")
	private String store_type;// 店铺类型

	@Column("depart_own")
	private String depart_own;// 所属部门

	@Column("area")
	private String area;// 所属大区

	@Column("province")
	private String province;// 省份

	@Column("city")
	private String city;// 城市

	@Column("city_part")
	private String city_part;// 城区

	@Column("city_id")
	private int city_id;// 城市id

	@Column("store_address")
	private String store_address;// 门店地址

	@Column("store_director")
	private String store_director;// 主管姓名

	@Column("store_directorphone")
	private String store_directorphone;// 主管电话

	@Column("store_assistant")
	private String store_assistant;// 店员姓名

	@Column("store_assistantphone")
	private String store_assistantphone;// 店员电话

	@Column("gps_lng")
	private String gps_lng;// 经度

	@Column("gps_lat")
	private String gps_lat;// 纬度

	@Column("create_date")
	private Date create_date;// 创建时间

	// 1 正常，0 被删除
	@Column("status")
	private String status;

	// -----------------------------------
	// 与 POS 系统对接，新增字段
	//大区经理工号
	@Column("empDutyID")
	private String empDutyID;
	//片区主管工号
	@Column("empID")
	private String empID;
	//收银方式
	@Column("Payment")
	private String payment;
	//开店日期
	@Column("StartDate")
	private Date startDate;

	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getEmpDutyID() {
		return empDutyID;
	}

	public void setEmpDutyID(String empDutyID) {
		this.empDutyID = empDutyID;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
