package com.seaway.liufuya.mvc.crm.memberlevel.pojo;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 会员等级 对象实体类
 * 
 * @author 刘立立
 * 
 */
@Table("lfyshop_memberlevel")
public class MemberLevel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column("level_code")
	private String level_code = "";

	// 等级名称
	@Column("levelName")
	private String levelName = "";

	// 起始值
	@Column("levelBegin")
	private int levelBegin = 0;

	// 终止值
	@Column("levelEnd")
	private int levelEnd = 0;

	// 创建人
	@Column("createPerson")
	private String createPerson = "";

	@Column("create_date")
	private Date create_date;

	// 1正常 0删除
	@Column("status")
	private String status = "";

	public MemberLevel() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLevel_code() {
		return level_code;
	}

	public void setLevel_code(String level_code) {
		this.level_code = level_code;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getLevelBegin() {
		return levelBegin;
	}

	public void setLevelBegin(int levelBegin) {
		this.levelBegin = levelBegin;
	}

	public int getLevelEnd() {
		return levelEnd;
	}

	public void setLevelEnd(int levelEnd) {
		this.levelEnd = levelEnd;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
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

}
