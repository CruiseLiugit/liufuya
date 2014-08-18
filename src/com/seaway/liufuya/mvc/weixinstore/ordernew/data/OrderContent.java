package com.seaway.liufuya.mvc.weixinstore.ordernew.data;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 
 * @author lililiu
 *
 */
@Table("lfy_order_content")
public class OrderContent  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column("orderNo")
	private String orderNo; // 编码
	
	@Column("productCode")
	private String productCode;// 商品编码 type=0 产品 type=1 套餐',
	
	@Column("productName")
	private String productName;// 产品名称
	
	@Column("goodsBuyPrice")
	private int goodsBuyPrice;// 商品实际价格',
	
	@Column("goodsBuyQrt")
	private int goodsBuyQrt;// 商品购买数量',
	
	@Column("status")
	private String status;// 状态 1正常 0删除',
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getGoodsBuyPrice() {
		return goodsBuyPrice;
	}

	public void setGoodsBuyPrice(int goodsBuyPrice) {
		this.goodsBuyPrice = goodsBuyPrice;
	}

	public int getGoodsBuyQrt() {
		return goodsBuyQrt;
	}

	public void setGoodsBuyQrt(int goodsBuyQrt) {
		this.goodsBuyQrt = goodsBuyQrt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
