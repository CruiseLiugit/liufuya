package com.seaway.liufuya.mvc.weixinstore.category.dao;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.weixinstore.category.data.Category;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;


/**
 * 懒加载 类别数据的 Container
 * @author lililiu
 *
 */
public class LazyLoadCategoryContainer extends BeanContainer{
	private static final long serialVersionUID = 1L;
	private static final Log log = Logs.get();

	private CategoryManager categoryDao = null; //数据库操作类
	
	public LazyLoadCategoryContainer(Class<? super Category> type) {
		super(type);
	}
	
	public LazyLoadCategoryContainer(Class<? super Category> type,CategoryManager categoryDao) {
		super(type);
		categoryDao = categoryDao;
	}

	@Override
    public int size() {
        return categoryDao.getTotalCount();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((Category) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
    		log.info("startIndex: " + startIndex + ", numberOfIds: " + numberOfIds);
        List<Category> list = categoryDao.getAllCategoryByPagr(startIndex, numberOfIds);
        return list;
    }
}
