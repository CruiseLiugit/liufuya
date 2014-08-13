package com.seaway.liufuya.mvc.weixinstore.product.dao;

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
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.mvc.weixinstore.category.data.Category;
import com.seaway.liufuya.mvc.weixinstore.product.data.CategoryBean;
import com.seaway.liufuya.mvc.weixinstore.product.data.WXProduct;
import com.seaway.liufuya.mvc.weixinstore.product.data.WXProductBean;

/**
 * 微信产品表，数据库操作类
 * 
 * @author lililiu
 * 
 */
@IocBean
public class WXProductManager extends BasicDao implements Serializable {

	private static final Log log = Logs.get();
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	public WXProductManager() {
	}

	public WXProductManager(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	/**
	 * 获得所有总数目
	 */
	public int getAllProductCount() {
		Cnd condtion = Cnd.where("status", "=", 1);
		return this.searchCount(WXProduct.class, condtion);
	}

	/**
	 * 分页查询产品
	 */
	public List<WXProductBean> getAllProductByPage(int startNum, int pageRow) {
		Cnd condtion = Cnd.where("status", "=", 1);
		Pager page = dao.createPager(startNum, pageRow);
		// 根据条件 查询出总共条数 并且赋值给Pager
		page.setRecordCount(this.dao.count(WXProduct.class, condtion));
		// 分页查询出所有符合条件的记录
		List<WXProduct> list = dao.query(WXProduct.class, condtion, page);

		// 转换为需要显示的bean
		List<WXProductBean> beanList = new LinkedList<WXProductBean>();
		for (WXProduct product : list) {
			WXProductBean bean = ex(product);
			beanList.add(bean);
		}
		return beanList;
	}

	/**
	 * 获取所有的产品记录
	 */
	public List<WXProductBean> getAllProduct() {
		Cnd condtion = Cnd.where("status", "=", 1);
		List<WXProduct> list = dao.query(WXProduct.class, condtion);

		// 转换为需要显示的bean
		List<WXProductBean> beanList = new LinkedList<WXProductBean>();
		for (WXProduct product : list) {
			WXProductBean bean = ex(product);
			beanList.add(bean);
		}
		return beanList;
	}

	/**
	 * 更新产品资料
	 * 
	 * @author zg
	 * **/
	public void updateEXProduct(WXProduct product) {
		// SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		// 这里调用工具类 把时间转换一下格式
		product.setUpdate_date(DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss",
				new Date()));
		// product.setUpdate_date(new Date());
		WXProduct[] products = new WXProduct[] { product };
		Sql sql = Sqls.create("update lfywx_product set productName='"
				+ product.getProductName() + "',productDesc ='"
				+ product.getProductDesc() + "', pic='" + product.getPic()
				+ "', price=" + product.getPrice() + ",cheapPrice="
				+ product.getCheapPrice() + ",stockNumber="
				+ product.getStockNumber() + ",unit=" + product.getUnit()
				+ ",otherUnit='" + product.getOtherUnit() + "',status ='"
				+ product.getStatus() + "',create_date='"
				+ product.getCreate_date() + "',update_date ='"
				+ product.getUpdate_date() + "' ,package ='"
				+ product.getPackage_type() + "' ,taste='" + product.getTaste()
				+ "' where productCode='" + product.getProductCode() + "'");
		dao.execute(sql);
	}

	/**
	 * 添加产品
	 */
	public void addEXProduct(WXProduct product) {
		// product.setCreate_date(new Date());
		product.setCreate_date(DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss",
				new Date()));
		// product.setProductCode("12124234323");
		dao.insert(product);
	}

	/**
	 * 查找所有的 产品类别名称 和code
	 */
	public List<CategoryBean> findAllExRuleCodeAndName() {
		Sql sqls = Sqls
				.create("Select category_code as code,category_name as name from lfy_category where status = '1'");
		sqls.setCallback(new SqlCallback() {

			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<CategoryBean> list = new LinkedList<CategoryBean>();
				while (rs.next()) {
					CategoryBean bean = new CategoryBean();
					bean.setCode(rs.getString("code"));
					bean.setName(rs.getString("name"));
					list.add(bean);
				}
				return list;
			}
		});
		dao.execute(sqls);
		return sqls.getList(CategoryBean.class);
	}

	/**
	 * 通过 产品类别名称 查出产品类别代码
	 */
	public List<String> findAllCatagoryCodeByName(String catagoryName) {
		Sql sqls = Sqls
				.create("Select category_code as code from lfy_category where status = '1' and category_name = '"
						+ catagoryName + "'");
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
	 */
	public List<String> findAllCategoryNameByCode(String ruleCode) {
		Sql sqls = Sqls
				.create("Select category_name as name from lfy_category where status = '1' and category_code = '"
						+ ruleCode + "'");
		sqls.setCallback(new SqlCallback() {

			@Override
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<String> list = new LinkedList<String>();
				while (rs.next()) {
					list.add(rs.getString("name"));
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

	private WXProductBean ex(WXProduct product) {
		WXProductBean bean = new WXProductBean();

		bean.setProductCode(product.getProductCode());
		bean.setProductDesc(product.getProductDesc());
		bean.setProductName(product.getProductName());
		bean.setCategory_code(this.findAllCategoryNameByCode(
				product.getCategory_code()).get(0));
		bean.setPic(product.getPic());
		bean.setPrice(product.getPrice());
		bean.setCreate_date(product.getCreate_date());
		
		//根据界面需要增加
//		bean.setUpdate_date(product.getUpdate_date());
		
//		switch (product.getUnit()) {
//		case 0:
//			bean.setUnit("无");
//			break;
//		case 1:
//			bean.setUnit("份");
//			break;
//		case 2:
//			bean.setUnit("普通装");
//			break;
//		case 3:
//			bean.setUnit("双人份");
//			break;
//		case 4:
//			bean.setUnit("盒");
//			break;
//		default:
//			bean.setUnit("其他");
//			break;
//		}
		
		bean.setPackage_type(product.getPackage_type());
		bean.setTaste(product.getTaste());
		
		//bean.setIs_recommend(product.getIs_recommend().equals("1") ? "是" : "否");
		//bean.setIsNew(product.getIsNew().equals("1") ? "是" : "否");
		bean.setStatus(product.getStatus().equals("1") ? "是" : "否");

		return bean;
	}

}
