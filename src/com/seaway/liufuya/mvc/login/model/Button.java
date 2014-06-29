package com.seaway.liufuya.mvc.login.model;

import java.io.Serializable;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 按钮功能实体类
 * @author miaohanbin
 *
 */
@Table("sys_model")
public class Button implements java.io.Serializable{
	
	private static final long serialVersionUID = 879047567257454120L;
	
	@Id
	private long  id	;	
	
	//@Name
	@Column("model_code")
	private String  modelCode;    //功能编码	
	
	@Column("model_name")
	private String 	modelName;	 //功能名称
	
	@Column("imgname")
	private String 	imgName;	     //是否有图标
	
	@Column("model_title")
	private String 	modelTitle;	 //功能标题
	
	@Column("create_date")
	private String 	createDate;	 //创建时间
	
	@Column("status")
	private String 	status="1";
	
	@Column("sortValue")
	private int sortValue;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getModelTitle() {
		return modelTitle;
	}
	public void setModelTitle(String modelTitle) {
		this.modelTitle = modelTitle;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSortValue() {
		return sortValue;
	}
	public void setSortValue(int sortValue) {
		this.sortValue = sortValue;
	}	
	
}
