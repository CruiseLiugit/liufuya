package com.seaway.liufuya.common;


public class Constants {

	// 页面字符串
	/**
	 * MyLoginForm.java 登录页面文字
	 */
	public static final String lunaLoginLeft = "欢迎使用";
	public static final String lunaLoginRight = "留夫鸭电商核心管理系统";
	public static final String lunaLoginUsername = "账户名";
	public static final String lunaLoginPassword = "密码";
	
	//页面高度
	public static final int PAGE_HEIGHT = 900;

	/**
	 * 当前登录用户Session常量
	 */
	public static final String CURRENT_LOGIN_NAME = "CURRENT_LOGIN_NAME";
	public static final String CURRENT_LOGIN_USER = "CURRENT_LOGIN_USER";
	/**
	 * 登录验证码Session常量
	 */
	public static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";

	// 存入验证码的 Session Name
	public static final String VALIDATION_CODE = "validation_code";

	// --------------------------------------------------------------------------
	// 分页，页面最大显示数据条数
	public static final int PAGE_SIZE = 80; // CRM管理,会员扩张信息管理页面最大显示条数

	// -----------------------------------------------------------
	// http://developer.baidu.com/map/webservice-placeapi.htm

	// 百度地图Place API服务地址
	// 5.Place区域检索POI服务 Place POI
	// http://api.map.baidu.com/place/v2/search?ak=您的密钥&output=json&query=银行&page_size=10&page_num=0&scope=1&region=北京

	// 3）圆形区域检索参数
	// 圆形区域检索示例(返回xml数据)：
	// http://api.map.baidu.com/place/v2/search?&query=银行&location=39.915,116.404&radius=2000&output=xml&ak=66K99NkKszXrvpuhQWctW0o1
	// http://api.map.baidu.com/place/v2/search?&query=银行&location=39.915,116.404&radius=2000&output=json&ak=66K99NkKszXrvpuhQWctW0o1
	public static final String RADIUSSEARCH_URL = "http://api.map.baidu.com/place/v2/search";
	public static final String RADIUS = "3000"; // 默认搜索半径 3公里

	// -----------------------------------------------------------
	// 百度地图Geocoding API
	// 通用接口参数
	// 百度地图Geocoding API服务地址
	public static final String GEBASEURL = "http://api.map.baidu.com/geocoder/v2/";
	// output 非必须，默认 xml, json或xml 输出格式为json或者xml
	public static final String OUTPUT = "json";
	// ak 必须，用户申请注册的key，自v2开始参数修改为“ak”，之前版本参数为“key”
	public static final String AK = "66K99NkKszXrvpuhQWctW0o1";

	// 地理编码服务，需要用户从页面输入，不能定位常量
	// 参数 是否必须 默认值 格式举例 含义
	// address 是 无 北京市海淀区上地十街10号 根据指定地址进行坐标的反定向解析
	// city 否 “北京市” “广州市” 地址所在的城市名

	// 设置 IP 白名单，可以不需要 sn callback 参数
	// 0.0.0.0/0
	// http://api.map.baidu.com/geocoder/v2/?ak=您的密钥&callback=renderOption&output=json&address=百度大厦&city=北京市
	// 无回调函数
	public static final String GEURL = GEBASEURL + "?ak=" + AK + "&output="
			+ OUTPUT + "&";

	// -----------------------------------------------------------
	// Route Matrix API是一套以HTTP形式提供的批量线路查询接口，用于返回多个起点和多个终点间的线路距离和行驶时间
	// 该接口适用于仅获取线路距离和时间，无需获取详细线路信息或者需要同时获取多起点、多终点线路距离等的情况。
	// 如根据用户输入地址为唯一起点，获取周边 留夫鸭门店 为多个终点的，线路信息
	// 使用限制
	// 起终点个数最多为5个，即每个请求串最多能查询25条线路信息；
	// 每个ak每天最多查询10万次。
	// http://api.map.baidu.com/direction/v1/routematrix
	// http://api.map.baidu.com/direction/v1/routematrix?output=json&origins=起点1|起点2&destinations=终点1|终点2&ak=E4805d16520de693a3fe707cdc962045
	// origins=origin1|orgin2为请求的起点，destinations=destination1|destination2为请求的终点：
	// 起点、终点使用名称
	// http://api.map.baidu.com/direction/v1/routematrix?output=json&origins=上海东方明珠&destinations=上海南京东路|上海中山公园&ak=66K99NkKszXrvpuhQWctW0o1
	// 起点、终点使用经纬度坐标
	// http://api.map.baidu.com/direction/v1/routematrix?output=json&origins=40.056878,116.30815&destinations=39.915285,116.403857&ak=66K99NkKszXrvpuhQWctW0o1

	/*
	 * { "status" : 0, "message" : "ok", "info" : { "copyright" : { "text" :
	 * "@2014 Baidu - Data", "imageUrl" :
	 * "http:\/\/api.map.baidu.com\/images\/copyright_logo.png" } }, "result" :
	 * { "elements" : [ { "distance" : { "value" : 6247, "text" : "6.2公里" },
	 * "duration" : { "value" : 1106, "text" : "18分钟" } }, { "distance" : {
	 * "value" : 12170, "text" : "12.2公里" }, "duration" : { "value" : 1562,
	 * "text" : "26分钟" } } ] } }
	 */
	public static final String RouteMatrixUrl = "http://api.map.baidu.com/direction/v1/routematrix?output=json";

	// -----------------------------------------------------------
	// IP定位 API是一个根据IP返回对应位置信息的http形式位置服务接口,支持多种语言调用，如C#
	// 、C++、Java等，即通过发送http请求，返回json格式的位置数据（包括坐标值、省份、城市、百度城市代码等）。
	// 1.获取指定IP的位置信息：指定IP值，返回该IP对应的位置信息；
	// 以城市为分类的应用或网站：根据用户当前IP来提供对应城市的服务
	// 限制
	// 每个key每天支持100万次调用，超过限制不返回数据。
	// IP定位的结果精度较差，主要应用获取省份或者城市的位置信息
	// URL：http://api.map.baidu.com/location/ip
	// 实例
	// http://api.map.baidu.com/location/ip?ak=E4805d16520de693a3fe707cdc962045&
	// ip=202.198.16.3&
	// coor=bd09ll
	// 返回值
	/*
	 * { "address" : "CN|吉林|长春|None|CERNET|1|None", "content" : { "address" :
	 * "吉林省长春市", "point" : { "x" : "125.31364243", "y" : "43.89833761" },
	 * "address_detail" : { "district" : "", "street_number" : "", "province" :
	 * "吉林省", "city" : "长春市", "city_code" : 53, "street" : "" } }, "status" : 0
	 * }
	 */
	// ip ip地址 string 可选，ip不出现，或者出现且为空字符串的情况下，会使用当前访问者的IP地址作为定位参数
	// ak 用户密钥 string 必选，在lbs云官网注册的access key，作为访问的依据
	// sn 用户的权限签名 string 可选，若用户所用ak的校验方式为sn校验时该参数必须。（sn生成算法）
	// coor 输出的坐标格式 string 可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标
	public static final String IPURL = "http://api.map.baidu.com/location/ip";
	// output 非必须，默认 xml, json或xml 输出格式为json或者xml
	// 输出坐标格式，才有 百度经纬度坐标
	public static final String COOR = "bd09ll";

	// 接口
	// http://localhost:8080/demolib/map/searchByIP?ip=202.198.16.3

	// -----------------------------------------------------------
	// 百度地图 Place suggestion API ，后台增加门店时使用
	// Place suggestion API
	// 是一套以HTTP形式提供的匹配用户输入关键字辅助信息、提示接口，可返回json或xml格式的一组建议词条的数据。
	// 配合Place API使用：使用本接口请求，可调出匹配用户输入的关键字的建议列表，用户选择列表中确定的一条，结合Place API返回查询的结果。

	// ---------------------------------------------------------------------------
	// 会员管理界面，左侧树状菜单 节点值
	public static final String[] CRM_MENUS_TREE1 = { "会员资料", "扩展资料", "会员等级",
			"会员黑名单", "诉求类别", "会员诉求", "短信发送" }; //
	// 积分管理
	// public static final String[] CRM_MENUS_TREE2 = { "兑奖规则信息管理", "兑换奖品资料管理",
	// "消费积分规则管理", "会员积分兑换管理" }; // "会员积分调整", "会员积分清除", "会员积分补录"
	public static final String[] CRM_MENUS_TREE2 = { "积分商品类别管理", "积分商品明细管理",
			"积分兑换比例管理", "会员积分兑换明细" }; // "会员积分调整", "会员积分清除", "会员积分补录"

	// 所有将会被点击到的 菜单值数组，用于在 CrmManageScreen.java 中 itemClick(ItemClickEvent
	// event) 方法中调用
	public static final String[] CRM_MENUS_ITEMCLICK = { "会员资料", "扩展资料",
			"会员等级", "会员黑名单", "诉求类别", "会员诉求", "短信发送", "积分商品类别管理", "积分商品明细管理",
			"积分兑换比例管理", "会员积分兑换明细" }; // , "会员积分调整", "会员积分清除",
										// "会员积分补录"

	public static final Object[][] CRM_MENUS_TREE = new Object[][] {
			new Object[] { "会员管理", "会员资料", "扩展资料", "会员等级", "会员黑名单", "诉求类别",
					"会员诉求", "短信发送" },
			new Object[] { "积分管理", "积分商品类别管理", "积分商品明细管理", "积分兑换比例管理",
					"会员积分兑换明细" } };// , "会员积分调整", "会员积分清除", "会员积分补录"

	// -----------------------------------20140812----------------------------------------
	// 微信商店界面，左侧树状菜单 节点值
	// PanelWeixinStore.java 中三个 Tree 中的节点名称
	public static final String[] WEIXIN_MENUS_TREE1 = { "商品类目管理", "商品资料管理" };
	public static final String[] WEIXIN_MENUS_TREE2 = { "当天订单管理", "历史订单查询" };
	public static final String[] WEIXIN_MENUS_TREE3 = { "优惠券生成", "会员优惠券查询" };

	// WeixinStoreScreen.java 中，左侧菜单，二位数组
	public static final Object[][] WEIXIN_MENUS_TREE = new Object[][] {
			new Object[] { "商品管理", "商品类目管理", "商品资料管理" },
			new Object[] { "订单管理", "未处理订单", "历史订单查询" },
			new Object[] { "电子优惠券管理", "优惠券生成", "会员优惠券查询" } };
	// WeixinStoreScreen.java 中，左侧菜单，选中的节点名称
	public static final String[] WEIXIN_MENUS_ITEMCLICK = { "商品类目管理", "商品资料管理",
			"未处理订单", "历史订单查询", "优惠券生成", "会员优惠券查询" };

	// -----------------------------------20140814----------------------------------------
	// 系统设置 界面，左侧树状菜单 节点值
	// SystemScreen.java
	// PanelSystemManager.java 中三个 Tree 中的节点名称
	public static final String[] SYSTEM_MENUS_TREE1 = { "已开门店管理" };
	// public static final String[] SYSTEM_MENUS_TREE2 = { "内容类别管理",
	// "内容发布管理","图片发布管理" };
	public static final String[] SYSTEM_MENUS_TREE3 = { "角色管理", "用户管理" };
	// SystemScreen.java 中，左侧菜单，二位数组
	public static final Object[][] SYSTEM_MENUS_TREE = new Object[][] {
			new Object[] { "门店管理", "已开门店管理" },
			new Object[] { "系统权限管理", "角色管理", "用户管理" } };
	// SystemScreen.java 中，左侧菜单，选中的节点名称
	public static final String[] SYSTEM_MENUS_ITEMCLICK = { "已开门店管理", "角色管理",
			"用户管理" };

	// ---------------------------------------------------------------------------
	// 从留夫鸭现有 POS 数据库中获取会员信息、门店信息的接口
	// 根 URL
	public static final String POSOUT_BASEURL = "http://115.29.12.128:8080/posout/";
	// 获取留夫鸭数据库中三个表中的数据条数
	public static final String CRDS_COUNT_URL = "getCrdsCount";
	public static final String VIP_COUNT_URL = "getVipCount";
	public static final String SHOP_COUNT_URL = "getShopCount";
	// 获取留夫鸭数据库中三个表中的详细数据列表
	public static final String CRDS_LIST_URL = "getCrdsList";
	public static final String VIP_LIST_URL = "getVipList";
	public static final String SHOP_LIST_URL = "getShopList";

	// ---------------------------------------------------------------------------
	// 会员管理模块，第一个子菜单选中后，右侧表格显示数据的条数
	// com.seaway.liufuya.mvc.crm.memberinfo.layout.MemberInfoListView
	/**
	 * Natural property order for Person bean. Used in tables and forms.
	 */
	public static final Object[] MEMEBER_COL_ORDER = new String[] {
			"loginname", "realname", "usersex", "usertype", "city", "cardid",
			"cardscore", "cardbalance", "createdate" };
	/**
	 * "表头列名" captions for properties in same order as in NATURAL_COL_ORDER.
	 */
	public static final String[] MEMEBER_COL_HEADERS_CHINESE = new String[] {
			"手机号码", "名称", "性别", "类型", "城市", "实体卡号", "积分", "余额", "注册日期" };

	// 会员表单中的固定下拉菜单的值
	public static final String[] MEMBER_AGE_AREAS = new String[] { "60前",
			"60后", "70后", "80后", "90后", "00后", "10后" }; // 年龄段
	public static final String[] MEMBER_WORK_TYPES = new String[] { "科研人员",
			"律师/法务/合规", "教师", "医院/医疗/护理", "公务员", "在校学生", "翻译", "建筑", "行政/后勤",
			"互联网/电子商务/网游", "销售人员", "采购", "公关/媒介", "酒店/旅游", "计算机软件", "物流/仓储",
			"人力资源", "艺术/设计", "其他" }; // 工作类型
	public static final String[] MEMBER_FAMILY_MONEY = new String[] { "1000以下",
			"1000-3000", "3000-5000", "10000-20000", "20000-50000", "50000以上" }; // 家庭收入
	public static final String[] MEMBER_ENTITY_CARD_STATUS = new String[] {
			"已开卡", "已使用", "已作废" }; // 实体卡状态
	public static final String[] MEMBER_REG_TYPES = new String[] { "实体卡注册",
			"网站注册", "微信注册", "后台注册" }; // 会员注册类型

	// ---------------------------------------------------------------------------
	// 会员黑名单管理模块，第一个子菜单选中后，右侧表格显示数据的条数
	// com.seaway.liufuya.mvc.crm.memberinfo.layout.MemberInfoListView
	/**
	 * Natural property order for Person bean. Used in tables and forms.
	 */
	public static final Object[] MEMEBER_DEL_COL_ORDER = new String[] {
			"loginname", "realname", "usersex", "usertype", "city", "cardid",
			"cardscore", "cardbalance", "createdate", "status" };
	/**
	 * "表头列名" captions for properties in same order as in NATURAL_COL_ORDER.
	 */
	public static final String[] MEMEBER_DEL_COL_HEADERS_CHINESE = new String[] {
			"手机号码", "名称", "性别", "类型", "城市", "实体卡号", "积分", "余额", "注册日期", "状态" };

	// ---------------------------------------------------------------------------
	// 会员扩展资料，
	public static final Object[] MEMEBER_ADD_COL_ORDER = new String[] {
			"loginname", "realname", "usersex", "usertype", "city", "cardid" };
	// "表头列名" captions for properties in same order as in NATURAL_COL_ORDER.
	public static final String[] MEMEBER_ADD_COL_HEADERS_CHINESE = new String[] {
			"手机号码", "名称", "性别", "类型", "城市", "实体卡号" };

	public static final Object[] MEMEBER_ADDRESS_COL_ORDER = new String[] {
			"city", "area", "address_keywords", "gps_long", "gps_lat",
			"is_default", "is_available", "create_date" };
	// "表头列名" captions for properties in same order as in NATURAL_COL_ORDER.
	public static final String[] MEMEBER_ADDRESS_COL_HEADERS_CHINESE = new String[] {
			"城市", "区域", "地址", "经度", "纬度", "默认地址", "能否配送", "创建日期" };

	// ---------------------------------------------------------------------------
	// 会员等级列表
	public static final Object[] MEMEBER_LEVEL_ORDER = new String[] {
			"levelName", "levelBegin", "levelEnd", "createTime", "createPerson" };
	// "表头列名" captions for properties in same order as in NATURAL_COL_ORDER.
	public static final String[] MEMEBER_LEVEL_CHINESE = new String[] { "等级名称",
			"起始积分", "结束积分", "创建时间", "创建人" };

	// ---------------------------------------------------------------------------
	// 会员扩展资料，
	public static final Object[] EXCHANGE_RULE_TABLE_COL = new String[] {
			"ruleCode", "ruleName", "ruleNumberBegin", "ruleNumberEnd",
			"remark", "startDate", "createPerson", "status" };

	public static final String[] EXCHANGE_RULE_TABLE_COL_HEADERS_CHINESE = new String[] {
			"规则代码", "规则名称", "规则起始", "规则结束", "备注", "开始时间", "创建人", "状态" };

	// ----------------------------------------------------------------------------
	// 诉求类别
	// 诉求类型
	public static final Object[] COMPLAIN_TYPE_COL = new String[] { "typeName",
			"createDate", "createPerson", "status", "remark" };
	// 表明列头
	public static final String[] COMPLAIN_TYPE_COL_HEADERS_CHINESE = new String[] {
			"诉求类型", "创建时间", "创建人", "状态", "备注" };

	// ----------------------------------------------------------------------------
	// 诉求
	// 诉求
	public static final Object[] COMPLAIN_COL = new String[] { "complainCode",
			"typeName", "relName", "telPhone", "createTime", "adminPerson",
			"isOk", "remark", "complainContent", "updateDate" };
	// 表明列头
	public static final String[] COMPLAIN_COL_HEADERS_CHINESE = new String[] {
			"诉求编码", "诉求类型", "会员", "会员电话", "投诉时间", "处理人", "诉求状态", "处理意见",
			"投诉内容", "回复时间" };

	// --------------------------------------------------------------------------
	// 短信模块
	public static final Object[] SMS_COL = new String[] { "smsCode", "smsType",
			"smsFor", "smsContent", "createDate", "createPerson", "remark",
			"status" };
	// 表明列头
	public static final String[] SMS_COL_HEADERS_CHINESE = new String[] {
			"短信编码", "短信类型", "订单系统", "短信内容", "创建时间", "创建人", "备注", "状态" };
	// ----------------------------------------------------------------------------
	// 积分兑换商品
	// 积分兑换商品
	public static final Object[] EXPRODUCT_COL = new String[] { "productCode",
			"exchangeRuleCode", "productName", "productDesc", "exchangeNumber",
			"stockNumber", "isNew", "status", "update_date", "is_recommend" };
	// 表明列头
	public static final String[] EXPRODUCT_COL_HEADERS_CHINESE = new String[] {
			"产品编码", "兑换类别", "产品名称", "产品描述", "兑换积分", "库存数目", "新品", "状态", "更新时间",
			"推荐" };

	// ---------------------------------------------------------------------------
	// 报表模块，主界面 树状菜单 值
	public static final String REPORT_TREE3_T1[] = { "会员诉求情况查询报表",
			"会员诉求情况汇总查询(类别)报表", "会员诉求情况汇总查询(项目)报表" };
	public static final String REPORT_TREE3_T2[] = { "会员积分查询报表",
			"会员积分兑奖汇总查询报表", "会员积分兑奖明晰查询报表" };
	public static final String REPORT_TREE3_T3[] = { "会员积分报表", "会员清单报表",
			"会员消费报表", "会员月消费报表", "会员积分兑奖详情报表", "会员消费汇总查询报表", "会员消耗积分分析报表",
			"会员卡总积分分析报表", "会员来源情况分析报表", "消费会员数情况分析", "会员每日卡内总积分分析",
			"会员年龄端消费情况分析", "会员消费单数情况分析", "会员消费金额情况分析", "会员分时段消费情况分析",
			"会员来源区域消费情况分析" };

	// 会员管理模块，第一个子菜单选中后，右侧表格显示数据的条数
	// com.seaway.liufuya.mvc.crm.memberinfo.layout.MemberInfoListView
	/**
	 * Natural property order for Person bean. Used in tables and forms.
	 */
	public static final String[] MEMEBER_COL_REPORT = new String[] {
			"realName", "user_type", "loginName", "sex", "birthday",
			"work_type", "city", "entityCardNumber", "memberCard_score",
			"memberCard_balance", "create_date", "status" };
	/**
	 * "表头列名" captions for properties in same order as in NATURAL_COL_ORDER.
	 */
	public static final String[] MEMEBER_COL_REPORT_CHINESE = new String[] {
			"用户名", "用户类型", "手机号", "性别", "生日", "工作", "城市", "实体卡号", "积分", "余额",
			"注册日期", "状态" };

	// 报表模块，界面左侧菜单，可点击 菜单项
	public static final String[] CRM_REPORT_ITEMCLICK = { "会员查询报表", "会员诉求报表",
			"门店统计报表", "门店销量报表", "当天销售情况报表", "历史销售情况报表", "自定义格式报表" };

	// 报表模块，界面左侧菜单，全部选项值
	public static final Object[][] CRM_REPORT_TREE = new Object[][] {
			new Object[] { "会员报表", "会员查询报表", "会员诉求报表" },
			new Object[] { "门店报表", "门店统计报表", "门店销量报表" },
			new Object[] { "销售报表", "当天销售情况报表", "历史销售情况报表", "自定义格式报表" } };

	// -----------------------------------------------积分对话规则
	// 积分规则类型
	public static final String[] CONSUMERULE_COL_HEADERS = { "规则代码", "规则名称",
			"积分类型", "兑换比例", "备注", "创建时间", "创建人", "状态" };
	public static final String[] CONSUMERULE_COL = { "ruleCode", "ruleName",
			"ruleType", "rulePercent", "remark", "startDate", "createPerson",
			"status" };

	// ------------------------------------------------微信商品类目管理
	public static final String[] WX_CATEGORY_COL_HEADERS = { "类目名称", "子类目名称",
			"状态", "类别编码" };
	public static final String[] WX_CATEGORY_COL = { "category_name",
			"show_name", "status", "category_code" };
	// 包装单位
	public static final String[] unit_code = { "0", "1", "2", "3", "4", "5" };
	public static final String[] unit_name = { "无", "份", "普通装", "标准杯", "盒",
			"其他" };

	// ------------------------------------------------微信商品管理
	public static final String[] WX_PRODUCT_COL_HEADERS = { "产品编码", "类别", "名称",
			"价格", "打折价", "库存", "创建时间", "状态", "更新时间", "包装类型", "口味" };
	public static final String[] WX_PRODUCT_COL = { "productCode",
			"category_code", "productName", "price", "cheapPrice",
			"stockNumber", "create_date", "status", "update_date",
			"package_type", "taste" };

	// ----------------------------------------------- 积分兑换记录类型
	// 会员
	public static final String[] CONSUME_MEMBER_COL_HEADERS = { "会员代码", "会员名",
			"实体卡号", "会员卡余额", "总积分" };
	public static final String[] CONSUME_MEMBER_COL = { "userCode", "realname",
			"cardid", "cardbalance", "cardscore" };
	// 记录
	public static final String[] CONSUME_COL_HEADERS = { "兑换日期", "兑换产品",
			"消费积分", "发货状态", "发货人", "创建人" };
	public static final String[] CONSUME_COL = { "exchangeDate", "productName",
			"exchangeNumber", "isSend", "sendPerson", "createPerson" };

	// ----------------------------------------------------------------------------
	// 门店管理
	public static final Object[] STOREADDRESS_COL = new String[] {
			"store_code", "store_name", "manage_type", "store_type", "area",
			"province", "city", "city_part", "startDate", "status" };
	// 表明列头
	public static final String[] STOREADDRESS_COL_HEADERS_CHINESE = new String[] {
			"门店编码", "门店名称", "经营类型", "店铺类型", "大区", "省份", "城市", "城区", "开店时间",
			"状态" };

	// ----------------------------------------------------------------------------
	// 订单管理,当日订单和历史订单公用一个表头,使用关联查询获得两个数据库表中信息 lfy_order lfy_order_content
	//去掉优惠价格  "couponMoney", 
	public static final Object[] ORDER_COL = new String[] { "orderNo",
			"orderTotalMoney", "orderStatus", "create_date",
			"user_name", "user_tel", "city", "area", "user_address",
			"productName" };
	// 表明列头
	//去掉优惠价格 "订单优惠价格", 
	public static final String[] ORDER_COL_HEADERS_CHINESE = new String[] {
			"订单编码", "订单价格", "支付状态", "创建时间", "用户名", "手机号码", "城市",
			"城区", "收货地址", "订单产品" };

	// ------------------------------------------------------------------------------电子优惠券
	// 优惠券生成
	public static final Object[] COUPON_COL = new String[] { "couponCode",
			"couponName", "couponType", "startDate", "endDate", "avtiveTime",
			"couponTotals", "couponExchanges", "couponDesc", "isNew", "status",
			"couponValue" };

	public static final String[] COUPON_COL_HEADERS_CHINESE = new String[] {
			"优惠券编码", "优惠券名称", "类型", "有效期从", "有效期到", "有效时长", "优惠券总数", "已使用",
			"优惠券描述", "最新", "状态", "单张金额" };

	public static final String[] COUPON_TYPE_ID = new String[] { "0", "1" };
	public static final String[] COUPON_TYPE_NAME = new String[] { "微信活动",
			"普通活动" };

	// ------------------------------------------------------------------------------电子优惠券
	// 优惠券兑换记录
	public static final Object[] EXCOUPON_COL = new String[] { "memCouponcode",
			"couponPageCode", "downloadDate", "disableDate", "isActive",
			"isUsed", "status" };

	public static final String[] EXCOUPON_COL_HEADERS_CHINESE = new String[] {
			"优惠券批次", "此优惠券编码", "优惠券下载时间", "失效时间", "是否有效", "是否使用", "状态" };

	// 会员
	public static final String[] EXCOUPON_MEMBER_COL_HEADERS = { "会员代码", "会员名",
			"实体卡号", "会员卡余额", "总积分" };
	public static final String[] EXCOUPON_MEMBER_COL = { "user_code",
			"realName", "entityCardNumber", "memberCard_balance",
			"memberCard_score" };

	// ----------------------------------------------------------------------------权限管理
	// 角色管理
	public static final Object[] SYSROLE_COL = new String[] { "roleCode",
			"roleName", "type", "createDate", "status" };
	// 表名列头
	public static final String[] SYSROLE_COL_HEADERS_CHINESE = new String[] {
			"角色编码", "角色名称", "权限类型", "创建时间","状态" };

	// ----------------------------------------------------------------------------权限管理
	// 用户管理
	public static final Object[] SYSUSER_COL = new String[] { "userCode",
			"loginName", "userName","roleName", "userType",
			"createDate", "status" };
	// 表名列头
	public static final String[] SYSUSER_COL_HEADERS_CHINESE = new String[] {
			"用户编码", "登录名称", "用户姓名", "角色类型",  "用户类型","创建时间",
			"状态" };
	
	
	
	
	

}
