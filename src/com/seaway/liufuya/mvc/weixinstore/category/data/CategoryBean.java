package com.seaway.liufuya.mvc.weixinstore.category.data;

public class CategoryBean {

	private String category_code = ""; // 类别编码，界面显示
	private String category_name = "";// 类别名称，界面显示
	private String create_date = ""; // 创建时间，界面显示
	private String create_opid = ""; // 创建人姓名，界面显示
	private String show_name = ""; // 显示的名称，子名称，界面显示
	private String status = "";  //界面显示
	
	
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
	public String getShow_name() {
		return show_name;
	}
	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
