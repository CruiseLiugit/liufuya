package com.seaway.liufuya.mvc.system.storeaddress.dao;

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
import com.seaway.liufuya.mvc.crm.exchangeproduct.dao.EXRuleBean;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProduct;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProductBean;
import com.seaway.liufuya.mvc.system.storeaddress.data.Citypart;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreAddress;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreBean;

/**
 * 门店数据表 dao类
 * 
 * @author 刘立
 * 
 */
@IocBean
public class StoreDaoImpl extends BasicDao implements Serializable {
	private static final Log log = Logs.get();
	private static final long serialVersionUID = 1L;

	private Dao dao = null;

	public StoreDaoImpl() {
	}

	public StoreDaoImpl(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	
	/**
	 * 获得所有总数目
	 * **/
	public int  getAllStoreAddressCount(){
		//Cnd condtion = Cnd.where("status","=",1);
		Cnd condtion = null;
		return this.searchCount(StoreAddress.class,condtion);
	}
	
	
	/**
	 * 分页查询门店
	 */
	public List<StoreBean> getAllstoreByPage(int startNum,int pageRow){
		log.info("==================>1 分页查询门店 startIndex: " + startNum + ", numberOfIds: " + pageRow);
		//Cnd condtion = Cnd.where("status","=",1);
		//根据条件  查询出总共条数   并且赋值给Pager
		int totalCount = this.dao.count(StoreAddress.class);
		//根据 startNum 判断出当前是第几页
		Page pageTool = new Page(totalCount,pageRow);
		int pageNumber = pageTool.getNowpage();
		log.info("==================>2 当前页面  pageNumber = "+pageNumber);
		Cnd condtion =null;
		Pager page = dao.createPager(pageNumber, Constants.PAGE_SIZE);
		
		//log.info("==================>查询数据库里面所有的数据条数为 :"+totalCount);
		page.setRecordCount(totalCount);
		//分页查询出所有符合条件的记录
		List<StoreAddress> list = dao.query(StoreAddress.class,condtion, page);
		log.info("==================>3 分页查询 :结果 list ="+list.size());
		
		
		//转换为需要显示的bean
		List<StoreBean> beanList = new LinkedList<StoreBean>();
		for(StoreAddress store:list){
			StoreBean bean =ex(store);
			beanList.add(bean);
		}	
		return beanList;
	}
	
	/**
	 * 获取所有的门店记录  
	 */
	public List<StoreBean> getAllStore(){
		//Cnd condtion = Cnd.where("status","=",1);
		Cnd condtion = null;  //全部查询
		List<StoreAddress> list = dao.query(StoreAddress.class,condtion);
		
		//转换为需要显示的bean
		List<StoreBean> beanList = new LinkedList<StoreBean>();
		for(StoreAddress product:list){
			StoreBean bean =ex(product);
			beanList.add(bean);
		}	
		return beanList;
	}
	
	
	/**
	 * 更新门店资料
	 */
	public void updateStore(StoreAddress product){
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
		StoreAddress store = findByCondition(StoreAddress.class, condition);
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
	public StoreAddress findStoreByStoreCode(String store_code) {
		Cnd condition = Cnd.where("store_code", "=", store_code);
		StoreAddress store = findByCondition(StoreAddress.class, condition);
		
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
		StoreAddress store = findByCondition(StoreAddress.class, condition);
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
	public void saveStoreAddress(StoreAddress memberlevel) {
		//product.setCreate_date(DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", new Date()));
		this.save(memberlevel);
	}
	
	/**
	 * 根据编号，查询某个门店的所有数据
	 * @param store_code
	 * @return
	 */
	public StoreAddress findStoreByCode(String store_code) {
		boolean flag = false;
		Cnd condition = Cnd.where("store_code", "=", store_code);
		StoreAddress store = findByCondition(StoreAddress.class, condition);
		return store;
	}
	
	
	/**
	 * pojo 和前段itemBean之间的转换
	 */
	private StoreBean ex(StoreAddress store){
		StoreBean bean = new StoreBean();
		
		bean.setStore_code(store.getStore_code());  // "020003",店号
		bean.setStore_name(store.getStore_name());  // "宝山区电台路店",店名
		bean.setManage_type(store.getManage_type());// 经营类型
		bean.setStore_type(store.getStore_type());  // 店铺类型
		bean.setArea(store.getArea());  // 所属大区
		bean.setProvince(store.getProvince()); // 省份
		bean.setCity(store.getCity());  // 城市 
		bean.setCity_part(store.getCity_part()); // 城区
		//private int city_id; // 城市id,暂时不做
		bean.setStore_address(store.getStore_address()); // 门店地址
		bean.setStore_director(store.getStore_director()); // 主管姓名 
		bean.setStore_directorphone(store.getStore_directorphone());// 主管电话
		bean.setStore_assistant(store.getStore_assistant()); // 店员姓名
		bean.setStore_assistantphone(store.getStore_assistantphone());// 店员电话
		bean.setGps_lng(store.getGps_lng());   // 经度
		bean.setGps_lat(store.getGps_lat());   // 纬度
		//bean.setCreate_date(store.getCreate_date()); // datetime 创建时间
		bean.setStatus(store.getStatus().equals("1")?"正常":"删除");  // 状态
		bean.setStartDate(DateUtil.convertDateToString(store.getStartDate())); //datetime 开店日期'
		// empDutyID` varchar(255) DEFAULT NULL COMMENT '大区经理工号',
		// empID` varchar(255) DEFAULT NULL COMMENT '片区主管工号',
		// Payment` varchar(255) DEFAULT NULL COMMENT '收银方式',
		//store.getIs_recommend().equals("1")?"是":"否"
		
		//bean.setExchangeRuleCode(this.findAllExRuleNameByCode(store.getExchangeRuleCode()).get(0));
		return bean;
	} 
	
	//-----------------------------------------------------------------
	//跟城市相关的方法
	/**
	 * 查找所有城市列表
	 */
	public  List<Citypart> findAllCityCodeAndName(){
		Cnd condition = Cnd.where("status", "=", "1");
		List<Citypart> list = dao.query(Citypart.class, condition);
		return list;
	}
	
	/**
	 * 根据城市名称，判断数据库中是否有该城市
	 */
	public Citypart findByCityName(String cityName) {
		Cnd condition = Cnd.where("addressName", "=", cityName).and("status",
				"=", "1");
		return findByCondition(Citypart.class, condition);
	}

	/**
	 * 新增 城市，全部是没有父节点的一级城市
	 * 
	 * @param memberlevel
	 */
	public void saveCitypart(Citypart city) {
		this.save(city);
	}

}
