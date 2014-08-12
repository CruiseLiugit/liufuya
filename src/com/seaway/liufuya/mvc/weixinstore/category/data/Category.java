package com.seaway.liufuya.mvc.weixinstore.category.data;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 产品类目 对象实体类
 * 
 * @author 刘立立
 * 
 */
@Table("lfy_category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column("category_code")
	private String category_code = ""; // 类别编码

	@Column("category_name")
	private String category_name = "";// 类别名称

	// 父节点.订餐网站，所有父节点为 -1。微信父节点 -2
	@Column("category_pcode")
	private String category_pcode = "";// 类别父节点编码

	@Column("create_date")
	private String create_date = ""; // 创建时间

	@Column("create_opid")
	private String create_opid = ""; // 创建人姓名

	// 按照数组下标索引，从 0 开始排序
	@Column("categoryOrder")
	private String categoryOrder = "";// 分类排序字段

	@Column("show_name")
	private String show_name = ""; // 显示的名称，子名称

	@Column("categoryType")
	private String categoryType = ""; // 备用字段，不用

	@Column("category_rootcode")
	private String category_rootcode = "";// 根节点

	@Column("image")
	private String image = ""; // 产品图片路径，目前暂时不做。

	@Column("status")
	private String status = "";

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_pcode() {
		return category_pcode;
	}

	public void setCategory_pcode(String category_pcode) {
		this.category_pcode = category_pcode;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getCreate_opid() {
		return create_opid;
	}

	public void setCreate_opid(String create_opid) {
		this.create_opid = create_opid;
	}

	public String getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(String categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategory_rootcode() {
		return category_rootcode;
	}

	public void setCategory_rootcode(String category_rootcode) {
		this.category_rootcode = category_rootcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
