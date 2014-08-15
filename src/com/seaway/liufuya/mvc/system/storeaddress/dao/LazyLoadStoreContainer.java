package com.seaway.liufuya.mvc.system.storeaddress.dao;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.system.storeaddress.data.StoreBean;
import com.seaway.liufuya.mvc.system.storeaddress.service.StoreAddressService;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;

public class LazyLoadStoreContainer extends BeanContainer {

	private static final long serialVersionUID = 1L;
	private StoreDaoImpl manager = null;
	private StoreAddressService service = null;
	private static final Log log = Logs.get();
   
	public LazyLoadStoreContainer(Class type) {
		super(type);
	}

	public LazyLoadStoreContainer(Class type,StoreDaoImpl manager) {
		super(type);
		service = new StoreAddressService(manager);
	}
	
	@Override
    public int size() {
        return service.productSize();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((StoreBean) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
    		log.info("==================>startIndex: " + startIndex + ", numberOfIds: " + numberOfIds);
        List<StoreBean> list = service.getStoreAddressByPage(startIndex, numberOfIds);
        return list;
    }
	
}
