package com.seaway.liufuya.mvc.crm.exchangeproduct.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 积分兑换商品资料管理  映射pojo
 * 
 * @author zg
 * **/
@Table("crm_exchange_product")
public class EXProduct  implements Serializable {

	@Id
	private long id;
	
	@Column("productCode")
	private String productCode;
	
	@Column("exchangeRuleCode")//积分规则代码
	private String exchangeRuleCode;
	
	@Column("productName")//   产品名称
	private String productName;
	
	@Column("productDesc")//产品描述
	private String productDesc;
	
	@Column("exchangeNumber")//兑换数目
	private String exchangeNumber;
	
	@Column("stockNumber")//库存数目
	private int stockNumber ;
	
	@Column("isNew")//是否新品 1是  0否
	private String isNew;
	
	@Column("status")
	private String status;
	
	@Column("is_recommend")//是否推荐  1是 0否
	private String is_recommend;
	
	@Column("update_date")
	private Date update_date ;
	
	@Column("create_date")
	private Date create_date;

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

	public String getExchangeRuleCode() {
		return exchangeRuleCode;
	}

	public void setExchangeRuleCode(String exchangeRuleCode) {
		this.exchangeRuleCode = exchangeRuleCode;
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

	public String getExchangeNumber() {
		return exchangeNumber;
	}

	public void setExchangeNumber(String exchangeNumber) {
		this.exchangeNumber = exchangeNumber;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
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

	public String getIs_recommend() {
		return is_recommend;
	}

	public void setIs_recommend(String is_recommend) {
		this.is_recommend = is_recommend;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}


}
