package com.seaway.liufuya.mvc.crm.exchangeproduct.dao;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.crm.exchangeproduct.data.EXProductBean;
import com.seaway.liufuya.mvc.crm.exchangeproduct.service.EXProductService;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;

public class LazyLoadEXProductContainer extends BeanContainer {

	private static final long serialVersionUID = 1L;
	private EXProductManager manager = null;
	private EXProductService service = null;
	private static final Log log = Logs.get();
   
//	public LazyLoadEXProductContainer(Class type) {
//		super(type);
//	}

	public LazyLoadEXProductContainer(Class type,EXProductManager manager) {
		super(type);
		service = new EXProductService(manager);
	}
	
	@Override
    public int size() {
        return service.productSize();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((EXProductBean) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
    		log.info("startIndex: " + startIndex + ", numberOfIds: " + numberOfIds);
        List<EXProductBean> list = service.getExProductByPage(startIndex, numberOfIds);
        return list;
    }
	
}
