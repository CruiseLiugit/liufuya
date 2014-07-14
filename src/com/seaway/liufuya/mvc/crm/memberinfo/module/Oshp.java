package com.seaway.liufuya.mvc.crm.memberinfo.module;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 门店数据表实体类
 * 
 * @author 刘立立
 * 
 */
public class Oshp implements Serializable {
	private static final long serialVersionUID = 1L;

	private int docEntry; // 关联主键

	private String shpCode; // 店号
	private String shpName; // 店名
	private String shpType; // 经营类型
	private String abbCode; // 店铺助记码
	private String control; // 负库存控制
	private String shpClass; // 店铺类型
	private String empDutyID; // 大区经理工号
	private String empID; // 片区主管工号
	private String payment; // 收银方式
	private int stdListNum; // 价格清单
	private int listNum; // 价格清单
	private String listNums; // 价格清单
	private int depEntry; // 部门键值
	private String tel1; // 主管及电话
	private String tel2; // 店员及电话
	private String fax; // 传真
	private String address; // 地址及电话
	private String area; // 大区
	private String province; // 省份
	private String city; // 城市
	private String cityArea; // 县市/城区
	private String brandList; // 经营品牌
	private String businessArea; // 口岸类型
	private String businessLevel; // 销售等级
	private String transLine; // 配送线路
	private String bank; // 缴款银行
	private String accountNO; // 银行账号
	private int boxCount; // 柜台数量
	private int stdPeple; // 人员编制
	private int stock1; // 库存金额上限预警
	private int stock2; // 商品品种数上限预警
	private int financeRate; // 折率
	private int discountLimit; // 折扣限制
	private double reductRate; // 折率下限
	private double size; // 营业面积
	private int cusEntry; // 所属客户键值
	private int isInvalid; // POS改价
	private int remoteStart; // 远程启动
	private Date startDate; // 开店日期
	private Date startTime; // 每日开铺
	private Date endTime; // 每日闭铺
	private String assignCode; // 分配编号
	private int freePrice; // 零价
	private Date createDate; // 建立日期
	private String maker; // 制作人
	private String lastIP; // 店铺IP
	private Date lastUpDate; // 同步时间
	private String showChart; // 顾客显示屏
	private String powerEntry; // 店铺权限键值
	private String assignTime; // 校验码

	public int getDocEntry() {
		return docEntry;
	}

	public void setDocEntry(int docEntry) {
		this.docEntry = docEntry;
	}

	public String getShpCode() {
		return shpCode;
	}

	public void setShpCode(String shpCode) {
		this.shpCode = shpCode;
	}

	public String getShpName() {
		return shpName;
	}

	public void setShpName(String shpName) {
		this.shpName = shpName;
	}

	public String getShpType() {
		return shpType;
	}

	public void setShpType(String shpType) {
		this.shpType = shpType;
	}

	public String getAbbCode() {
		return abbCode;
	}

	public void setAbbCode(String abbCode) {
		this.abbCode = abbCode;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getShpClass() {
		return shpClass;
	}

	public void setShpClass(String shpClass) {
		this.shpClass = shpClass;
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

	public int getStdListNum() {
		return stdListNum;
	}

	public void setStdListNum(int stdListNum) {
		this.stdListNum = stdListNum;
	}

	public int getListNum() {
		return listNum;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public String getListNums() {
		return listNums;
	}

	public void setListNums(String listNums) {
		this.listNums = listNums;
	}

	public int getDepEntry() {
		return depEntry;
	}

	public void setDepEntry(int depEntry) {
		this.depEntry = depEntry;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCityArea() {
		return cityArea;
	}

	public void setCityArea(String cityArea) {
		this.cityArea = cityArea;
	}

	public String getBrandList() {
		return brandList;
	}

	public void setBrandList(String brandList) {
		this.brandList = brandList;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getBusinessLevel() {
		return businessLevel;
	}

	public void setBusinessLevel(String businessLevel) {
		this.businessLevel = businessLevel;
	}

	public String getTransLine() {
		return transLine;
	}

	public void setTransLine(String transLine) {
		this.transLine = transLine;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountNO() {
		return accountNO;
	}

	public void setAccountNO(String accountNO) {
		this.accountNO = accountNO;
	}

	public int getBoxCount() {
		return boxCount;
	}

	public void setBoxCount(int boxCount) {
		this.boxCount = boxCount;
	}

	public int getStdPeple() {
		return stdPeple;
	}

	public void setStdPeple(int stdPeple) {
		this.stdPeple = stdPeple;
	}

	public int getStock1() {
		return stock1;
	}

	public void setStock1(int stock1) {
		this.stock1 = stock1;
	}

	public int getStock2() {
		return stock2;
	}

	public void setStock2(int stock2) {
		this.stock2 = stock2;
	}

	public int getFinanceRate() {
		return financeRate;
	}

	public void setFinanceRate(int financeRate) {
		this.financeRate = financeRate;
	}

	public int getDiscountLimit() {
		return discountLimit;
	}

	public void setDiscountLimit(int discountLimit) {
		this.discountLimit = discountLimit;
	}

	public double getReductRate() {
		return reductRate;
	}

	public void setReductRate(double reductRate) {
		this.reductRate = reductRate;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getCusEntry() {
		return cusEntry;
	}

	public void setCusEntry(int cusEntry) {
		this.cusEntry = cusEntry;
	}

	public int getIsInvalid() {
		return isInvalid;
	}

	public void setIsInvalid(int isInvalid) {
		this.isInvalid = isInvalid;
	}

	public int getRemoteStart() {
		return remoteStart;
	}

	public void setRemoteStart(int remoteStart) {
		this.remoteStart = remoteStart;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAssignCode() {
		return assignCode;
	}

	public void setAssignCode(String assignCode) {
		this.assignCode = assignCode;
	}

	public int getFreePrice() {
		return freePrice;
	}

	public void setFreePrice(int freePrice) {
		this.freePrice = freePrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getLastIP() {
		return lastIP;
	}

	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}

	public Date getLastUpDate() {
		return lastUpDate;
	}

	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}

	public String getShowChart() {
		return showChart;
	}

	public void setShowChart(String showChart) {
		this.showChart = showChart;
	}

	public String getPowerEntry() {
		return powerEntry;
	}

	public void setPowerEntry(String powerEntry) {
		this.powerEntry = powerEntry;
	}

	public String getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(String assignTime) {
		this.assignTime = assignTime;
	}

}
