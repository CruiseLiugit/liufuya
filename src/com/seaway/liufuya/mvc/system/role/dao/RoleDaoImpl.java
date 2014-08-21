package com.seaway.liufuya.mvc.system.role.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
import com.seaway.liufuya.mvc.system.role.data.SysRole;

/**
 * 角色数据表 dao类
 * 
 * @author 刘立
 * 
 */
@IocBean
public class RoleDaoImpl extends BasicDao implements Serializable {
	private static final Log log = Logs.get();
	private static final long serialVersionUID = 1L;

	private Dao dao = null;

	public RoleDaoImpl() {
	}

	public RoleDaoImpl(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	
	/**
	 * 获得所有总数目
	 * **/
	public int  getAllSysRoleCount(){
		//Cnd condtion = Cnd.where("status","=",1);
		Cnd condtion = null;
		return this.searchCount(SysRole.class,condtion);
	}
	
	
	/**
	 * 分页查询门店
	 */
	public List<SysRole> getAllstoreByPage(int startNum,int pageRow){
		log.info("==================>1 分页查询门店 startIndex: " + startNum + ", numberOfIds: " + pageRow);
		//Cnd condtion = Cnd.where("status","=",1);
		//根据条件  查询出总共条数   并且赋值给Pager
		int totalCount = this.dao.count(SysRole.class);
		//根据 startNum 判断出当前是第几页
		Page pageTool = new Page(totalCount,pageRow);
		int pageNumber = pageTool.getNowpage();
		log.info("==================>2 当前页面  pageNumber = "+pageNumber);
		Cnd condtion =null;
		Pager page = dao.createPager(pageNumber, Constants.PAGE_SIZE);
		
		//log.info("==================>查询数据库里面所有的数据条数为 :"+totalCount);
		page.setRecordCount(totalCount);
		//分页查询出所有符合条件的记录
		List<SysRole> list = dao.query(SysRole.class,condtion, page);
		log.info("==================>3 分页查询 :结果 list ="+list.size());
		
		//转换为需要显示的bean
		List<SysRole> beanList = new LinkedList<SysRole>();
		for(SysRole store:list){
			SysRole bean =ex(store);
			beanList.add(bean);
		}	
		return beanList;
	}
	
	/**
	 * 获取所有的门店记录  
	 */
	public List<SysRole> getAllStore(){
		//Cnd condtion = Cnd.where("status","=",1);
		Cnd condtion = null;  //全部查询
		List<SysRole> list = dao.query(SysRole.class,condtion);
		
		
		
		//转换为需要显示的bean
		List<SysRole> beanList = new LinkedList<SysRole>();
		for(SysRole product:list){
			SysRole bean =ex(product);
			//bean.setStatus(store.getStatus().equals("1")?"正常":"删除");  // 状态
			//bean.setStartDate(DateUtil.convertDateToString(store.getStartDate())); //datetime 开店日期'
			beanList.add(bean);
		}	
		return beanList;
	}
	
	
	/**
	 * 更新门店资料
	 */
	public void updateStore(SysRole product){
		this.dao.update(product);
	}
	

	/**
	 * 新增 门店数据，前，判断门店是否已经存在 不存在，返回 true
	 * 
	 * @param memberlevel
	 */
	public boolean checkStoreByStoreCode(String store_code) {
		boolean flag = false;
		Cnd condition = Cnd.where("store_code", "=", store_code);
		SysRole store = findByCondition(SysRole.class, condition);
		if (store == null) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据 门店 编码，查询门店对象
	 * @param store_code
	 * @return
	 */
	public SysRole findStoreByStoreCode(String store_code) {
		Cnd condition = Cnd.where("store_code", "=", store_code);
		SysRole store = findByCondition(SysRole.class, condition);
		
		return store;
	}
	
	

	/**
	 * 插入前，查询门店名称是否存在
	 * 
	 * @param store_name
	 * @return
	 */
	public boolean findStoreByStoreName(String store_name) {
		boolean flag = false;
		Cnd condition = Cnd.where("store_name", "=", store_name);
		SysRole store = findByCondition(SysRole.class, condition);
		if (store == null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 新增 门店数据
	 * 
	 * @param memberlevel
	 */
	public void saveStoreAddress(SysRole memberlevel) {
		//product.setCreate_date(DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", new Date()));
		this.save(memberlevel);
	}
	
	/**
	 * 根据编号，查询某个门店的所有数据
	 * @param store_code
	 * @return
	 */
	public SysRole findStoreByCode(String store_code) {
		boolean flag = false;
		Cnd condition = Cnd.where("store_code", "=", store_code);
		SysRole store = findByCondition(SysRole.class, condition);
		return store;
	}
	
	
	/**
	 * pojo 和前段itemBean之间的转换
	 */
	private SysRole ex(SysRole store){
		
		//bean.setStatus(store.getStatus().equals("1")?"正常":"删除");  // 状态
		//bean.setStartDate(DateUtil.convertDateToString(store.getStartDate())); //datetime 开店日期'
		
		return store;
	} 
	
	
}
