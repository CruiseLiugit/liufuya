package com.seaway.liufuya.common;

/**
 * 积分管理
 * @author lililiu
 * {"兑换奖品资料管理","消费积分规则管理","兑奖规则信息管理","会员积分兑换管理","会员积分调整","会员积分清除","会员积分补录"}
 */
public enum CrmMenusTree2 {
	POINTS_INFO1("兑换奖品资料管理"),POINTS_INFO2("消费积分规则管理"),POINTS_INFO3("兑奖规则信息管理"),POINTS_INFO4("会员积分兑换管理"),POINTS_INFO5("会员积分调整"),POINTS_INFO6("会员积分清除"),POINTS_INFO7("会员积分补录");
	private CrmMenusTree2(String tp) {
		this.type = tp;
	}

	public String toString() { // 覆盖了父类Enum的toString()
		return super.toString() + type;
	}

	private String type; // 自定义数据域，private为了封装。

}
