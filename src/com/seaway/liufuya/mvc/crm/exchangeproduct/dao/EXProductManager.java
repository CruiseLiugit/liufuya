package com.seaway.liufuya.mvc.crm.exchangeproduct.dao;

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

import com.ibm.icu.text.SimpleDateFormat;
import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.Constants;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.common.util.Page;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProduct;
import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProductBean;
import com.seaway.liufuya.mvc.system.storeaddress.data.StoreAddress;

/**
 * 产品兑换资料管理
 * 
 * @author zg
 * **/
@IocBean
public class EXProductManager extends BasicDao implements Serializable {

	private static final Log log = Logs.get();
	private static final long serialVersionUID = 1L;

	private Dao dao = null;

	public EXProductManager(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	/**
	 * 获得所有总数目
	 * 
	 * @author zg
	 * **/
	public int getAllProductCount() {
		Cnd condtion = Cnd.where("status", "=", 1);
		return this.searchCount(EXProduct.class, condtion);
	}

	/**
	 * 分页查询产品
	 * 
	 * @author zg
	 * **/
	public List<EXProductBean> getAllProductByPage(int startNum, int pageRow) {
		Cnd condtion = Cnd.where("status", "=", 1);
		// 根据条件 查询出总共条数 并且赋值给Pager
		int totalCount = this.dao.count(StoreAddress.class);
		// 根据 startNum 判断出当前是第几页
		Page pageTool = new Page(totalCount, startNum);
		int pageNumber = pageTool.getNowpage();
		
		Pager page = dao.createPager(pageNumber, Constants.PAGE_SIZE);
		// 根据条件 查询出总共条数 并且赋值给Pager
		page.setRecordCount(this.dao.count(EXProduct.class, condtion));
		// 分页查询出所有符合条件的记录
		List<EXProduct> list = dao.query(EXProduct.class, condtion, page);

		// 转换为需要显示的bean
		List<EXProductBean> beanList = new LinkedList<EXProductBean>();
		for (EXProduct product : list) {
			EXProductBean bean = ex(product);
			beanList.add(bean);
		}
		return beanList;
	}

	/**
	 * 获取所有的产品记录
	 * 
	 * @author zg
	 * **/
	public List<EXProductBean> getAllProduct() {
		Cnd condtion = Cnd.where("status", "=", 1);
		// Pager page = dao.createPager(startNum, pageRow);
		// 根据条件 查询出总共条数 并且赋值给Pager
		// page.setRecordCount(this.dao.count(EXProduct.class,condtion));
		// 分页查询出所有符合条件的记录
		List<EXProduct> list = dao.query(EXProduct.class, condtion);

		// 转换为需要显示的bean
		List<EXProductBean> beanList = new LinkedList<EXProductBean>();
		for (EXProduct product : list) {
			EXProductBean bean = ex(product);
			beanList.add(bean);
		}
		return beanList;
	}

	/**
	 * 更新产品资料
	 * 
	 * @author zg
	 * **/
	public void updateEXProduct(EXProduct product) {
		// SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		// 这里调用工具类 把时间转换一下格式
		product.setUpdate_date(DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss",
				new Date()));
		// product.setUpdate_date(new Date());
		EXProduct[] products = new EXProduct[] { product };
		Sql sql = Sqls.create("update crm_exchange_product set productName='"
				+ product.getProductName() + "',productDesc ='"
				+ product.getProductDesc() + "', exchangeNumber='"
				+ product.getExchangeNumber() + "', stockNumber='"
				+ product.getStockNumber() + "',status ='"
				+ product.getStatus() + "' ,isNew ='" + product.getIsNew()
				+ "' ,is_recommend ='" + product.getIs_recommend()
				+ "' ,update_date='" + product.getUpdate_date()
				+ "' where productCode='" + product.getProductCode() + "'");
		dao.execute(sql);
	}

	/**
	 * 添加产品
	 * 
	 * @author zg
	 * **/
	public void addEXProduct(EXProduct product) {
		// product.setCreate_date(new Date());
		product.setCreate_date(DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss",
				new Date()));
		product.setProductCode("12124234323");
		dao.insert(product);
	}

	/**
	 * 查找所有的积分兑换规则名称 和code
	 * 
	 * @author zg
	 * **/
	public List<EXRuleBean> findAllExRuleCodeAndName() {
		Sql sqls = Sqls
				.create("Select ruleCode as code,ruleName as name from crm_exchange_rule where status = '1'");
		sqls.setCallback(new SqlCallback() {

			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<EXRuleBean> list = new LinkedList<EXRuleBean>();
				while (rs.next()) {
					EXRuleBean bean = new EXRuleBean();
					bean.setCode(rs.getString("code"));
					bean.setName(rs.getString("name"));
					list.add(bean);
				}
				return list;
			}
		});
		dao.execute(sqls);
		return sqls.getList(EXRuleBean.class);
	}

	/**
	 * 通过积分对话规则名 查出兑换代码
	 * 
	 * @author zg
	 * **/
	public List<String> findAllExRuleCodeByName(String ruleName) {
		Sql sqls = Sqls
				.create("Select ruleCode as code from crm_exchange_rule where status = '1' and ruleName = '"
						+ ruleName + "'");
		sqls.setCallback(new SqlCallback() {

			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<String> list = new LinkedList<String>();
				while (rs.next()) {
					list.add(rs.getString("code"));
				}
				return list;
			}
		});
		dao.execute(sqls);
		return sqls.getList(String.class);
	}

	/**
	 * 通过积分对话规则code 查出兑换名称
	 * 
	 * @author zg
	 * **/
	public List<String> findAllExRuleNameByCode(String ruleCode) {
		Sql sqls = Sqls
				.create("Select ruleName as code from crm_exchange_rule where status = '1' and ruleCode = '"
						+ ruleCode + "'");
		sqls.setCallback(new SqlCallback() {

			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<String> list = new LinkedList<String>();
				while (rs.next()) {
					list.add(rs.getString("code"));
				}
				return list;
			}
		});
		dao.execute(sqls);
		return sqls.getList(String.class);
	}

	/**
	 * pojo 和前段itemBean之间的转换
	 * 
	 * **/

	private EXProductBean ex(EXProduct product) {
		EXProductBean bean = new EXProductBean();
		bean.setCreate_date(product.getCreate_date());
		bean.setUpdate_date(product.getUpdate_date());
		bean.setExchangeNumber(product.getExchangeNumber());
		bean.setIs_recommend(product.getIs_recommend().equals("1") ? "是" : "否");
		bean.setIsNew(product.getIsNew().equals("1") ? "是" : "否");
		bean.setStatus(product.getStatus().equals("1") ? "是" : "否");
		bean.setProductCode(product.getProductCode());
		bean.setProductDesc(product.getProductDesc());
		bean.setProductName(product.getProductName());
		bean.setStockNumber(String.valueOf(product.getStockNumber()));
		bean.setExchangeRuleCode(this.findAllExRuleNameByCode(
				product.getExchangeRuleCode()).get(0));
		return bean;
	}

}
