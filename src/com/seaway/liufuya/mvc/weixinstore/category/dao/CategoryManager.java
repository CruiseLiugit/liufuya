package com.seaway.liufuya.mvc.weixinstore.category.dao;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.mvc.weixinstore.category.data.Category;

/**
 * 微信商品类别  manager
 * 
 *  @author liulili
 * **/
@IocBean
public class CategoryManager extends BasicDao implements Serializable{
	private static final long serialVersionUID = 1L;
	private Dao dao = null;
	
	public CategoryManager() {}
	
	public CategoryManager(Dao dao){
		this.dao = dao;
		super.dao = dao;
	}
	
	/**
	 * 获取所有 类别 条数
	 */
	public int getTotalCount(){
		return this.searchCount(Category.class);
	}
	
	/**
	 * 获取所有 产品类别
	 * 不分页
	 */
	public List<Category> getAllCategory(){	
		return this.dao.query(Category.class, null);
	}
	
	/**
	 * 分页 获取产品类别
	 */
	public List<Category> getAllCategoryByPagr(int startNum, int pageRows){
		Cnd condition = null; //查询所有
		Pager pager = dao.createPager(startNum, pageRows);
		pager.setRecordCount(dao.count(Category.class, condition));
		List<Category> menus = dao.query(Category.class, condition, pager);
		return menus;
	}
	
	/**
	 * 新增 产品类别
	 */
	public  Category addCategory(Category rule){
	return this.dao.insert(rule);	
	}
	
	/**
	 * 更新积分兑换规则
	 */
	public void updateRule(Category cate){
		Sql sql =Sqls.create("update lfy_category set category_name='"+cate.getCategory_name()+"',category_pcode ='"+cate.getCategory_pcode()+"', create_date='"+cate.getCreate_date()+"', create_opid='"+cate.getCreate_opid()+"',categoryOrder ='"+cate.getCategoryOrder()+"',show_name='"+cate.getShow_name()+"',image='"+cate.getImage()+"',status='"+cate.getStatus()+"' where category_code='"+cate.getCategory_code()+"'");
		dao.execute(sql);
	}
	
	
	
	
}
