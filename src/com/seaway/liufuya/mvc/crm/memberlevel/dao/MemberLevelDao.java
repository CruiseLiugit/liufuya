package com.seaway.liufuya.mvc.crm.memberlevel.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.common.util.Page;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.MemberInfoManager;
import com.seaway.liufuya.mvc.crm.memberlevel.pojo.MemberLevel;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreAddress;
import com.vaadin.data.util.BeanItemContainer;

@IocBean
public class MemberLevelDao extends BasicDao implements Serializable {
	private static final Log log = Logs.get();
	private Dao dao = null;

	private static final long serialVersionUID = 1L;

	public MemberLevelDao() {
		// TODO Auto-generated constructor stub
	}

	public MemberLevelDao(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	
	/**
	 * 新增 用户等级
	 * 
	 * @param memberlevel
	 */
	public void saveMemberLevel(MemberLevel memberlevel) {
		this.save(memberlevel);
	}
	
	/**
	 * 修改用户等级
	 * 
	 * @param memberlevel
	 * @return
	 */
	public boolean updateMemberLevel(MemberLevel memberlevel) {
		return this.update(memberlevel);
	}
	
	
	/**
	 * 根据id查询用户
	 * 
	 * @param sysUserId
	 * @return
	 */
	public List<MemberLevel> getMemberLevelById(String level_code) {
		Cnd condition = Cnd.where("level_code", "=", level_code).and("status",
				"=", "1");
		return search(MemberLevel.class, condition);
	}

	/**
	 * 查询表中，正常数据 数量
	 * 
	 * @return
	 */
	public int getTotalCount() {
		Cnd condition = Cnd.where("status", "=", 1);
		return this.searchCount(MemberLevel.class, condition);
	}

	/**
	 * 分页查询系统用户
	 */
	public List<MemberLevel> getAllMemberLevelPageList(int startNum, int rows) {
		Pager pager = null;
		if (rows != 0) {
			//根据条件  查询出总共条数   并且赋值给Pager
			int totalCount = this.dao.count(StoreAddress.class);
			//根据 startNum 判断出当前是第几页
			Page pageTool = new Page(totalCount,startNum);
			int pageNumber = pageTool.getNowpage();
			
			pager = dao.createPager(pageNumber, Constants.PAGE_SIZE);
			// 设置一共可以查询的条数
			pager.setRecordCount(dao.count(MemberLevel.class,
					Cnd.where("status", "=", 1)));
			
		}
		
		List<MemberLevel> users = dao.query(MemberLevel.class,
				Cnd.where("status", "=", 1), pager);
		return users;
	}

	

	/**
	 * 根据 等级名称，查询等级数据
	 * 
	 * @param map
	 * @return
	 */
	public MemberLevel findByLevelName(String levelName) {
		Cnd condition = Cnd.where("levelName", "=", levelName)
				.and("status", "=", "1");
		return findByCondition(MemberLevel.class, condition);
	}

	
	
	
}
