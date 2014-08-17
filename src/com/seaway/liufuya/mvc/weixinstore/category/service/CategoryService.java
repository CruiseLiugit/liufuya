package com.seaway.liufuya.mvc.weixinstore.category.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.seaway.liufuya.common.uuid.RandomCode;
import com.seaway.liufuya.mvc.weixinstore.category.dao.CategoryManager;
import com.seaway.liufuya.mvc.weixinstore.category.data.Category;

/**
 * 商品类目管理 service
 * 
 * @author zg
 * **/

public class CategoryService {

	private CategoryManager manager = null;
	public CategoryService(){
		
	}
	public CategoryService(CategoryManager manager){
		this.manager = manager;
	}
	
	/**
	 * 分页从数据库获取数据
	 * @param startIndex 开始记录索引
	 * @param pageRows   每页显示条数
	 * @return
	 */
    public List<Category> getMemberByPager(int startIndex, int pageRows) {
        List<Category> list = manager.getAllCategoryByPagr(startIndex, pageRows);
        return list;
    }
	
    
    public int exchangeSize() {
        return manager.getTotalCount();
    }
	
	/**
	 * 分页从数据库获取数据
	 * @param startIndex 开始记录索引
	 * @param pageRows   每页显示条数
	 * @return
	 */
    public List<Category> exchangeRuleList(int startIndex, int pageRows) {
        List<Category> list = manager.getAllCategoryByPagr(startIndex, pageRows);
        return list;
    }
    
    /**
     * 添加 
     * 
     * @author zg
     * **/
    public void addCategroy(Category categroy){
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM--dd hh:mm:ss");
    	categroy.setCreate_date(sf.format(new Date()));
    	categroy.setCategory_code(new RandomCode().generateNumberString("CA", 4));
    	categroy.setCategoryOrder("2");
    	manager.addCategory(categroy);
    }
    
    /**
     * 修改
     * 
     * @author zg
     * **/
    public void updateCategroy(Category categroy){
    	//通过 先找出相应的 categroy
    	List<Category> categroyBeans =manager.getCategory(categroy.getCategory_code());
    	Category categroyBean = categroyBeans.get(0);
    	categroyBean.setCategory_name(categroy.getCategory_name());
    	categroyBean.setShow_name(categroy.getShow_name());
    	categroyBean.setStatus(categroy.getStatus());
    	
    	manager.updateRule(categroyBean);
    }
   
}
