package com.seaway.liufuya.mvc.weixinstore.ordernew.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.BasicDao;
import com.seaway.liufuya.common.util.DateUtil;
import com.seaway.liufuya.mvc.crm.memberaddressinfo.pojo.MemberAddress;
import com.seaway.liufuya.mvc.crm.memberinfo.data.Member;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.Order;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.OrderBean;
import com.seaway.liufuya.mvc.weixinstore.ordernew.data.OrderContent;

/**
 * 订单数据表 dao类
 * 
 * @author 刘立
 * 
 */
@IocBean
public class OrderDao extends BasicDao implements Serializable {
	private static final Log log = Logs.get();
	private static final long serialVersionUID = 1L;

	private Dao dao = null;

	public OrderDao() {
		// TODO Auto-generated constructor stub
	}

	public OrderDao(Dao dao) {
		this.dao = dao;
		super.dao = dao;
	}

	/**
	 * 根据 条件 ，查询所有 满足条件的 总数目
	 * 
	 * @param delivery
	 *            订单出货方式， 2外送 1自取 3 顺丰
	 * @param orderStatus
	 *            ; '订单状态 1默认待支付 2已支付 3已关闭',
	 * @param status
	 *            '状态 1默认未付款 0删除 2已付款 3 外送超时 4 自取超时 5 外送退货 6 未外送 7未自取',
	 * 
	 * 
	 *            微信功能 当日订单，传递参数 delivery=3,orderStatus=2,status=2 
	 *            历史订单，传递参数
	 *            delivery=3,orderStatus=3,status=2
	 * 
	 */
	public int getAllOrderCount(String delivery, String orderStatus,
			String status) {
		Cnd condtion = Cnd.where("delivery", "=", delivery)
				.and("orderStatus", "=", orderStatus)
				.and("status", "=", status);
		return this.searchCount(Order.class, condtion);
	}

	/**
	 * 获取所有的订单记录 微信功能 当日订单，传递参数 delivery=3,orderStatus=2,status=2 历史订单，传递参数
	 * delivery=3,orderStatus=3,status=2
	 * 
	 */
	public List<OrderBean> getAllOrder(String delivery, String orderStatus,
			String status) {
		Cnd condtion = Cnd.where("delivery", "=", delivery)
				.and("orderStatus", "=", orderStatus)
				.and("status", "=", status);
		List<Order> list = dao.query(Order.class, condtion);

		// 转换为需要显示的bean
		List<OrderBean> beanList = new LinkedList<OrderBean>();
		for (Order ord : list) {
			OrderBean bean = ex(ord);
			beanList.add(bean);
		}
		return beanList;
	}

	/**
	 * 更新门店资料
	 */
	public void updateStore(Order product) {
		this.dao.update(product);
	}

	/**
	 * 根据 门店 编码，查询门店对象
	 * 
	 * @param store_code
	 * @return
	 */
	public Order findStoreByOrderNo(String orderNo) {
		Cnd condition = Cnd.where("orderNo", "=", orderNo);
		Order store = findByCondition(Order.class, condition);
		return store;
	}

	// 根据会员编码查询当前用户信息
	public Member getMemeberByUserCode(String user_code) {
		Cnd condition = Cnd.where("user_code", "=", user_code).and("status",
				"=", "1");
		return findByCondition(Member.class, condition);
	}

	// 根据地址编码查询当前用户地址
	public MemberAddress getMemeberAddressByUserCode(String address_code,
			String user_code) {
		Cnd condition = Cnd.where("address_code", "=", address_code)
				.and("user_code", "=", user_code);//.and("status", "=", "1");
		return findByCondition(MemberAddress.class, condition);
	}

	// 根据订单编号，查询 订单对应的产品明细
	public List<OrderContent> findAllOrderContentByOrderNum(String orderNo) {
		Cnd condition = Cnd.where("orderNo", "=", orderNo).and("status", "=",
				"1");
		List<OrderContent> list = dao.query(OrderContent.class, condition);
		return list;
	}

	// ---------------------------------------------------
	/**
	 * pojo 和前段itemBean之间的转换
	 */
	public OrderBean ex(Order order) {
		OrderBean bean = new OrderBean();
		bean.setOrderNo(order.getOrderNo());// 订单编码
		bean.setOrderTotalMoney("" + order.getOrderTotalMoney());// 订单价格
		bean.setCouponMoney("" + order.getCouponMoney());// 订单优惠价格
		// 支付状态
		String orderStatus = "";
		int ordStatus = 0;
		if (order.getOrderStatus() != null) {
			orderStatus = order.getOrderStatus();
			ordStatus = Integer.parseInt(orderStatus.trim());
		}

		switch (ordStatus) {
		case 1:
			bean.setOrderStatus("未支付");
			break;
		case 2:
			bean.setOrderStatus("已支付");
			break;
		case 3:
			bean.setOrderStatus("已关闭");
			break;
		default:
			bean.setOrderStatus("空状态");
			break;
		}
		bean.setCreate_date(DateUtil.convertDateToString(order.getCreate_date()));// 创建时间

		// 查询用户信息，姓名
		String user_code = order.getUserCode();
		Member mbe = this.getMemeberByUserCode(user_code);
		bean.setUser_name(mbe.getRealName()); // 用户名

		String address_code = order.getAddressCode();
		MemberAddress address = this.getMemeberAddressByUserCode(address_code,
				user_code);
		bean.setCity(address.getCity());
		bean.setArea(address.getArea());
		bean.setUser_address(address.getAddress_keywords()); // 收货地址

		// 这里可能出错，如果没有插入用户电话
		String user_tel = "";
		if (order.getUser_tel() != null) {
			user_tel = order.getUser_tel();
		} else {
			user_tel = mbe.getLoginName();
		}
		bean.setUser_tel(order.getUser_tel());// 手机号码
		// 关联 lfy_order_content
		List<OrderContent> list =this.findAllOrderContentByOrderNum(order.getOrderNo());
		StringBuffer sb = new StringBuffer("");
		for (OrderContent orderContent : list) {
			sb.append(orderContent.getProductName()+orderContent.getGoodsBuyQrt()+"份,");
		}

		bean.setProductName(sb.toString());
		

		// * delivery 订单出货方式， 2外送 1自取 3 顺丰
		// * @param orderStatus; '订单状态 1默认待支付 2已支付 3已关闭',
		// * @param status '状态 1默认未付款 0删除 2已付款 3 外送超时 4 自取超时 5 外送退货 6 未外送 7未自取',
		return bean;
	}

}
