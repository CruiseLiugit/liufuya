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
 * 会员对象实体类
 * 
 * @author 刘立立
 * 
 */
@Table("lfy_member")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column("user_code")
	private String user_code="";

	// 1.实体卡 2.网站注册 3.微信注册 4.后台注册
	@Column("user_type")
	private String user_type="";

	// 必须是手机
	@Column("loginName")
	private String loginName="";

	@Column("loginPwd")
	private String loginPwd="";

	// 真实姓名
	@Column("realName")
	private String realName="";

	// 1.男 0女
	@Column("sex")
	private String sex="";

	@Column("birthday")
	private Date birthday;

	// 身份证号
	@Column("card_number")
	private String card_number="";

	// 所在城市
	@Column("city")
	private String city="";

	// 手机号码
	@Column("telphone")
	private String telphone="";

	@Column("email")
	private String email="";

	// 工作类型
	@Column("work_type")
	private String work_type="";
	// 家庭收入
	@Column("family_money")
	private String family_money="";
	// 年龄段
	@Column("age_area")
	private String age_area="";

	// 实体卡卡号
	@Column("entityCardNumber")
	private String entityCardNumber="";

	// 实体卡状态
	// 1 已开卡 2 已使用 3 已作废
	@Column("entityCardStatus")
	private String entityCardStatus="";

	//余额、积分 实体卡从 crds 表获取，根据 关联 id 一一获取
	// 会员卡余额 精确到分
	@Column("memberCard_balance")
	private int memberCard_balance=0;

	// 会员卡总积分
	@Column("memberCard_score")
	private int memberCard_score=0;

	// 创建时间
	@Column("create_date")
	private Date create_date;

	// 1正常 0删除 2拉黑
	@Column("status")
	private String status="";

	private String city_part=""; // 城区
	private String default_address=""; // 地址

	// -----------------------------------
	// 与 POS 系统对接，新增字段
	// 年龄
	@Column("age")
	private String age;
	// 注册日期
	@Column("regDate")
	private Date regDate;
	
	//--下面这些目前没有用处
	// 生效日期
	@Column("DateStart")
	private Date dateStart;
	// 过期日期
	@Column("DateEnd")
	private Date dateEnd;
	// 折扣模式
	@Column("PriceMode")
	private String priceMode;
	// 价格清单
	@Column("PriceList")
	private int priceList;
	// 发卡店铺编码
	@Column("shpEntry")
	private int shpEntry;

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

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntityCardNumber() {
		return entityCardNumber;
	}

	public void setEntityCardNumber(String entityCardNumber) {
		this.entityCardNumber = entityCardNumber;
	}

	public String getEntityCardStatus() {
		return entityCardStatus;
	}

	public void setEntityCardStatus(String entityCardStatus) {
		this.entityCardStatus = entityCardStatus;
	}

	public int getMemberCard_balance() {
		return memberCard_balance;
	}

	public void setMemberCard_balance(int memberCard_balance) {
		this.memberCard_balance = memberCard_balance;
	}

	public int getMemberCard_score() {
		return memberCard_score;
	}

	public void setMemberCard_score(int memberCard_score) {
		this.memberCard_score = memberCard_score;
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

	public String getDefault_address() {
		return default_address;
	}

	public void setDefault_address(String default_address) {
		this.default_address = default_address;
	}

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}

	public String getFamily_money() {
		return family_money;
	}

	public void setFamily_money(String family_money) {
		this.family_money = family_money;
	}

	public String getAge_area() {
		return age_area;
	}

	public void setAge_area(String age_area) {
		this.age_area = age_area;
	}

	public String getCity_part() {
		return city_part;
	}

	public void setCity_part(String city_part) {
		this.city_part = city_part;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getPriceMode() {
		return priceMode;
	}

	public void setPriceMode(String priceMode) {
		this.priceMode = priceMode;
	}

	public int getPriceList() {
		return priceList;
	}

	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}

	public int getShpEntry() {
		return shpEntry;
	}

	public void setShpEntry(int shpEntry) {
		this.shpEntry = shpEntry;
	}

}
