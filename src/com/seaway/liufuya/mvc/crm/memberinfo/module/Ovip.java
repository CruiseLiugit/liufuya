package com.seaway.liufuya.mvc.crm.memberinfo.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员卡类型对象实体类
 * 
 * @author 刘立立
 * 
 */
public class Ovip implements Serializable {
	private static final long serialVersionUID = 1L;

	public String birthDayA; // 编号
	public String abbCode; // 姓名缩写
	public String birthPlace; // 出生地
	public String birthDay; // 出生年月
	public String sex; // 性别
	public String mobile1; // 手机号码 18901899775
	public String pubTime; // 注册日期
	public String memo; // ?
	public String name; // 诸翠红 ，会员姓名
	public int cardEntry; // 卡片编码" : 1012,
	public String mobile2; //
	public String iDCard; //
	public String email; //
	public String pwd; //
	public String phone; //
	public String pubEmp1; //
	public String birthMon; //
	public String age; //
	public int cancel; // 0
	public String qq; // " : "",
	public String pubEmp2; // " : "",
	public String createDate; // " : "2013-06-19 17:17:28"

	private int docEntry; // 关联主键
	private String cardID; // 卡号
	private int typeID; // 卡片类型编码
	private String typeName; // 卡片类型
	private int shpEntry; // 店铺编码
	private Date pubDate; // 发卡日期
	private int pubFlag; // 发卡标志
	private Date regDate; // 注册日期
	private Date dateStart; // 生效日期
	private Date dateEnd; // 过期日期
	private String priceMode; // 折扣模式
	private int priceList; // 价格清单
	private String status; // 状态
	private int point; // 积分
	private double balance; // 余额
	private String maker; // 制卡人
	private String ss; // <校验码>
	private String password; // 密码

	public String getBirthDayA() {
		return birthDayA;
	}

	public void setBirthDayA(String birthDayA) {
		this.birthDayA = birthDayA;
	}

	public String getAbbCode() {
		return abbCode;
	}

	public void setAbbCode(String abbCode) {
		this.abbCode = abbCode;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCardEntry() {
		return cardEntry;
	}

	public void setCardEntry(int cardEntry) {
		this.cardEntry = cardEntry;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getiDCard() {
		return iDCard;
	}

	public void setiDCard(String iDCard) {
		this.iDCard = iDCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPubEmp1() {
		return pubEmp1;
	}

	public void setPubEmp1(String pubEmp1) {
		this.pubEmp1 = pubEmp1;
	}

	public String getBirthMon() {
		return birthMon;
	}

	public void setBirthMon(String birthMon) {
		this.birthMon = birthMon;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPubEmp2() {
		return pubEmp2;
	}

	public void setPubEmp2(String pubEmp2) {
		this.pubEmp2 = pubEmp2;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getDocEntry() {
		return docEntry;
	}

	public void setDocEntry(int docEntry) {
		this.docEntry = docEntry;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getShpEntry() {
		return shpEntry;
	}

	public void setShpEntry(int shpEntry) {
		this.shpEntry = shpEntry;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public int getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(int pubFlag) {
		this.pubFlag = pubFlag;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
