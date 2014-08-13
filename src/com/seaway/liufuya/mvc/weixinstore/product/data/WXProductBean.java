package com.seaway.liufuya.mvc.weixinstore.product.data;

import org.nutz.dao.entity.annotation.Column;

/**
 * 页面表格使用的
 * 
 * @author lililiu
 * 
 */
public class WXProductBean {

	private String productCode = ""; // 产品编码，界面显示
	private String category_code = ""; // 产品所属类别编码，这里要转换为类别名称
	private String productName = ""; // 产品名称

	private String productDesc = ""; // 产品描述 这个表格不用显示。表单显示
	private String pic = ""; // 产品图片路径,表格中不显示该字段

	private int price = 0; // 产品价格，界面文本框输入，默认值 0
	private int cheapPrice = 0; // 打折价格，界面文本框输入，默认值 0,表格中不显示该字段
	private int stockNumber = 0; // 库存数量，界面文本框输入，默认值 0,表格中不显示该字段
	private String unit = ""; // 单位 0无 1份 2普通装 3标准杯 4盒 5其他，页面用下拉框展示,表格中不显示该字段

	private String otherUnit = ""; // 在unit 为 5 时 这边提供填写,表格中不显示该字段
	private String create_date = ""; // 创建时间

	// 这里两列暂时不用
	// private String isNew = ""; // 是否新品 0否 1是
	// private String is_recommend = ""; // 是否推荐 1是 0否

	private String status = ""; // 0 表示删除，1 表示正常
	private String update_date = ""; // 产品更新时间，每次都是最新时间
	private String package_type = ""; // 包装，目前只有一种包装类型，后面可能多种，表单中用下拉框
	private String taste = ""; // 口味,每种产品，多种口味，看作多种产品

	// 如鸭脖：微辣鸭脖、中辣鸭脖、麻辣鸭脖、等。
	// 每种口味都往产品表里面插入一条记录，当作一个独立商品
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCheapPrice() {
		return cheapPrice;
	}

	public void setCheapPrice(int cheapPrice) {
		this.cheapPrice = cheapPrice;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getOtherUnit() {
		return otherUnit;
	}

	public void setOtherUnit(String otherUnit) {
		this.otherUnit = otherUnit;
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

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getPackage_type() {
		return package_type;
	}

	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

}
