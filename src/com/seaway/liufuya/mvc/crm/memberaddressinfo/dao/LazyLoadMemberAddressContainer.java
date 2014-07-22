package com.seaway.liufuya.mvc.crm.memberaddressinfo.dao;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddress;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddressBean;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.service.MemberAddressService;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;

public class LazyLoadMemberAddressContainer extends BeanContainer {
	private static final long serialVersionUID = 1L;
	private static final Log log = Logs.get();

	private MemberAddressBeanDao addressDao = null; //数据库操作类
	private MemberAddressService service = null;//数据处理类
	private String user_code = "" ; //要查询的会员对象

	public LazyLoadMemberAddressContainer(Class type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public LazyLoadMemberAddressContainer(Class type,MemberAddressBeanDao addressDao,String user_code  ) {
		super(type);
		service = new MemberAddressService(addressDao);
		this.user_code = user_code;
	}
	
	@Override
    public int size() {
        return service.memberAddressSize();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((MemberAddressBean) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
    		log.info("startIndex: " + startIndex + ", numberOfIds: " + numberOfIds+" , user_code ="+user_code);
        List<MemberAddressBean> list = service.memberAddressList(startIndex, numberOfIds,user_code);
        return list;
    }
	
	
	

}
