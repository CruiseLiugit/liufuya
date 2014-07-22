package com.seaway.liufuya.mvc.crm.memberaddressinfo.service;

import java.util.ArrayList;
import java.util.List;

import com.seaway.liufuya.mvc.crm.memberaddressinfo.dao.MemberAddressBeanDao;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddress;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddressBean;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.crm.memberinfo.data.MemberBean;

/**
 * 服务层
 * @author lililiu
 *
 */
public class MemberAddressService {


    private MemberAddressBeanDao addressDao = null;
	
	public MemberAddressService() {
	}
	
	public MemberAddressService(MemberAddressBeanDao dao) {
		addressDao = dao;
	}

	public int memberSize() {
        return addressDao.getMemberTotalCount();
    }

	/**
	 * 分页从数据库获取数据
	 * @param startIndex 开始记录索引
	 * @param pageRows   每页显示条数
	 * @return
	 */
    public List<MemberBean> getMemberByPager(int startIndex, int pageRows) {
        List<MemberBean> users = addressDao.getMemberByPager(startIndex, pageRows);
        return users;
    }
	
    
    public int memberAddressSize() {
        return addressDao.getMemberAddressTotalCount();
    }
	
	/**
	 * 分页从数据库获取数据
	 * @param startIndex 开始记录索引
	 * @param pageRows   每页显示条数
	 * @return
	 */
    public List<MemberAddressBean> memberAddressList(int startIndex, int pageRows,String user_code) {
        List<MemberAddressBean> users = addressDao.getMemberAddressByUserCode(user_code);
        return users;
    }
    
    
    //-----------------------------------------------------
    //取出数据后，在页面表格中显示的数据转换
    
    
    
    
	
}
