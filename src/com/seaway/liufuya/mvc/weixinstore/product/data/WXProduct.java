package com.seaway.liufuya.mvc.weixinstore.product.data;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 产品类目 对象实体类
 * 
 * @author 刘立立
 * 
 */
@Table("lfywx_product")
public class WXProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column("productCode")
	private String productCode = ""; // 产品编码，界面显示

	@Column("category_code")
	private String category_code = ""; // 产品所属类别编码

	@Column("productName")
	private String productName = ""; // 产品名称

	@Column("productDesc")
	private String productDesc = ""; // 产品描述

	@Column("pic")
	private String pic = ""; // 产品图片路径,表格中不显示该字段

	@Column("price")
	private int price = 0; // 产品价格，界面文本框输入，默认值 0

	@Column("cheapPrice")
	private int cheapPrice = 0; // 打折价格，界面文本框输入，默认值 0,表格中不显示该字段

	@Column("stockNumber")
	private int stockNumber = 0; // 库存数量，界面文本框输入，默认值 0,表格中不显示该字段

	@Column("unit")
	private int unit = 0; // 单位 0无 1份 2普通装 3标准杯 4盒 5其他，页面用下拉框展示,表格中不显示该字段

	@Column("otherUnit")
	private String otherUnit = ""; // 在unit 为 5 时 这边提供填写,表格中不显示该字段

	@Column("create_date")
	private String create_date = ""; // 创建时间

	@Column("isNew")
	private String isNew = ""; // 是否新品 0否 1是

	@Column("status")
	private String status = ""; // 0 表示删除，1 表示正常

	@Column("update_date")
	private String update_date = ""; // 产品更新时间，每次都是最新时间

	@Column("is_recommend")
	private String is_recommend = ""; // 是否推荐 1是 0否

	@Column("package")
	private String package_type = ""; // 包装，目前只有一种包装类型，后面可能多种

	@Column("taste")
	private String taste = ""; // 口味,每种产品，多种口味，看作多种产品
    // 如鸭脖：微辣鸭脖、中辣鸭脖、麻辣鸭脖、等。
	//每种口味都往产品表里面插入一条记录，当作一个独立商品

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
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

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
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

	public String getIs_recommend() {
		return is_recommend;
	}

	public void setIs_recommend(String is_recommend) {
		this.is_recommend = is_recommend;
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
