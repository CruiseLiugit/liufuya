package com.seaway.liufuya.mvc.crm.memberaddressinfo.dao;

import java.util.List;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.mvc.crm.memberaddressinfo.service.MemberAddressService;
import com.seaway.liufuya.mvc.crm.memberinfo.dao.impl.MemberInfoMemberBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;

/**
 * 懒加载左侧会员数据的 Container
 * @author lililiu
 *
 */
public class LazyLoadMemberContainer extends BeanContainer {
	private static final long serialVersionUID = 1L;
	private static final Log log = Logs.get();

	private MemberAddressBeanDao addressDao = null; //数据库操作类
	private MemberAddressService service = null;//数据处理类
	
	public LazyLoadMemberContainer(Class<? super MemberBean> type) {
		super(type);
	}
	
	public LazyLoadMemberContainer(Class<? super MemberBean> type,MemberAddressBeanDao memberManager) {
		super(type);
		// TODO Auto-generated constructor stub
		service = new MemberAddressService(memberManager);
	}

	@Override
    public int size() {
        return service.memberSize();
    }

    @Override
    public BeanItem getItem(Object itemId) {
        return new BeanItem((MemberBean) itemId);
    }

    @Override
    public List getItemIds(int startIndex, int numberOfIds) {
    		log.info("startIndex: " + startIndex + ", numberOfIds: " + numberOfIds);
        List<MemberBean> list = service.getMemberByPager(startIndex, numberOfIds);
        return list;
    }
	

}
