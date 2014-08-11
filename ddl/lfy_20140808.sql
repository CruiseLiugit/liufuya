-- --------------------------------------------------------
-- 2014-08-08 修改跟积分、优惠券有关的几个表格
-- --------------------------------------------------------

-- 20140808 新增，保存生成的短信验证码
CREATE TABLE `lfy_identify_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL COMMENT '验证码编码 ',
  `checkCode` varchar(255) DEFAULT NULL COMMENT '验证码 随机数',
  `userCode` varchar(255) DEFAULT NULL COMMENT '用户 注册时就存储sessionId',
  `codeType` varchar(255) DEFAULT NULL COMMENT '0微信注册 1微信忘记密码 2网站注册',
  `create_time` datetime DEFAULT NULL COMMENT '入插时间',
  `status` varchar(255) DEFAULT NULL COMMENT '态状 0无效 1有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- 兑奖规则信息表的结构 `crm_exchange_rule`
-- 20140807 这里修改一下名称，积分商品类别。专门为积分兑换商城提供类别设置的
--

CREATE TABLE IF NOT EXISTS `crm_exchange_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruleCode` int(11) DEFAULT NULL COMMENT '随机数编码',
  `ruleName` char(30) DEFAULT NULL COMMENT '积分兑换规则名称',
  `ruleNumberBegin` int DEFAULT NULL COMMENT '兑换起始数值',
  `ruleNumberEnd` int DEFAULT NULL COMMENT '兑换结束数值',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `startDate` datetime DEFAULT NULL COMMENT '设置日期',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '设置管理员名称',
  `status` varchar(50) DEFAULT NULL COMMENT '0表示 删除 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


--
-- 兑奖奖品资料管理 的结构 `crm_exchange_product`
-- 20140807 这里修改一下名称 , 积分商品明细。专门为积分兑换商城提供每条兑换商品的信息
--

CREATE TABLE IF NOT EXISTS `crm_exchange_product` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `productCode` varchar(50) NOT NULL COMMENT '产品编码，随机数',
  `exchangeRuleCode` varchar(50) DEFAULT NULL COMMENT '积分商品类别',
  `productName` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `productDesc` text COMMENT '产品描述',
  `exchangeNumber` varchar(50) DEFAULT NULL COMMENT '兑换积分数目',
  `stockNumber` int(11) DEFAULT NULL COMMENT '库存数目',
  `create_date` datetime DEFAULT NULL  COMMENT '创建时间',
  `isNew` varchar(255) DEFAULT NULL COMMENT '是否新品 0否 1是',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  `update_date` datetime DEFAULT NULL,
  `is_recommend` varchar(10) DEFAULT '0' COMMENT '是否推荐 1是 0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;



--
-- 消费积分规则信息表的结构 `crm_consume_rule`
-- 同一时间，只能一个兑换规则生效
-- 20140807 这里修改一下，修改为，积分兑换比例，
-- 增加 兑换比例 0.00-1.00 之间的小数，代表百分比 计算公式 消费金额*比例=积分
-- 积分四舍五入，保留整数
-- 去掉 ruleNumber 字段。
-- 增加字段 ruleType 积分来源 1 消费金额折算；2 表示会员活动赠送(目前不做，但是要有这个类别)
--

CREATE TABLE IF NOT EXISTS `crm_consume_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruleCode`  varchar(100) DEFAULT NULL COMMENT '随机数编码',
  `ruleName` char(30) DEFAULT NULL COMMENT '消费积分规则名称',
  `ruleType` int DEFAULT NULL COMMENT '积分来源 1 消费金额折算 2 表示会员活动赠送 ',
  `rulePrice` double DEFAULT NULL COMMENT '消费金额数值 目前保留小数点后两位',
  `rulePercent` double DEFAULT NULL COMMENT '兑换比例0.00-1.00之间小数小数点后两位',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `startDate` datetime DEFAULT NULL COMMENT '设置日期',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '设置管理员名称',
  `status` varchar(50) DEFAULT NULL COMMENT '0表示 无效 1 表示 有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;




-- --------------------------------------------------------
-- 2014-07-24 补充数据库表格 微信端、最新活动、优惠券  以 lfywx_ 开头
-- 2014-08-07 修改，后台发布的活动，目前通过微信端领取，所以前缀名称 lfywx_
-- 参加活动，是会员获得积分的一种方式，另外的方式是通过订单付款
-- --------------------------------------------------------

-- 最新活动 发布管理 的结构 `lfywx_campaign`
-- 注意：活动当作一种特殊的商品来进行管理，与上面积分兑换商品一样理解
-- 1、为方便后台发布活动，后台只需要填写一张表格，根据 活动预计参与人数，在 lfywx_campaign_pages 里面插入对应数量的记录
-- 2、1人一份，预先存入，lfywx_campaign_pages，一个会员参加，就从 lfywx_campaign_pages 中领取一条记录，isDown＝1
-- 3、把一个活动按最小单位记录，当作一件商品
-- 4、所有发布的活动，记录在该表中，用户参加活动，奖品如果是积分，修改会员积分表
-- 5、去掉 isNew 字段
-- 6、进入该模块后，遍历所有 数据，当前时间 超过 活动截止时间的，status=0
--
CREATE TABLE IF NOT EXISTS `lfywx_campaign` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `campaignCode` varchar(50) NOT NULL COMMENT '活动编码，随机数',
  `campaignName` varchar(100) NOT NULL COMMENT '活动名称',
  `campaignImage` varchar(100) NOT NULL COMMENT '活动图片路径',
  `startDate` datetime DEFAULT NULL COMMENT '活动开始时间',
  `endDate` datetime DEFAULT NULL COMMENT '活动截止时间',
  `takePartin` varchar(100) DEFAULT NULL COMMENT '参与方式，如留夫鸭上海区域所有门店',
  `campaignDesc` varchar(50) DEFAULT NULL COMMENT '活动详情',
  `campaignToalNumber` int(11) DEFAULT NULL COMMENT '活动奖品总份数',
  `campaignPrize` int(11) DEFAULT NULL COMMENT '活动奖品单份金额',
  `prizeType` varchar(255) DEFAULT NULL COMMENT '活动奖品类型 1是 送积分 默认 1',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '发布人姓名',
  `status` varchar(255) DEFAULT NULL COMMENT '0 表示过期 1 表示有效活动 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--  该表记录一份活动预先创建好的每一份 活动，用户按照顺序领取，isDown=1
--
CREATE TABLE IF NOT EXISTS `lfywx_campaign_pages` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `campaignPageCode` varchar(50) NOT NULL COMMENT '单个活动编码，随机数',
  `campaignCode` varchar(50) NOT NULL COMMENT '总发布活动编码，随机数',
  `campaignPrize` int(11) DEFAULT NULL COMMENT '活动奖品单份，积分',
  `isDown` varchar(255) DEFAULT NULL COMMENT '是否被领取   0否 1是',
  `status` varchar(255) DEFAULT NULL COMMENT '0 表示过期 1 表示有效活动 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- 会员积分兑换 管理 的结构 `crm_consume_exchange`
-- 该表记录每个会员，所有跟积分相关操作的数据: 消费金额折算积分、活动领取积分、积分商品兑换
-- 1、消费金额折算产品积分 (收获积分，标 + 号)
-- (1)通过 orderNo 关联 lfy_order 表，  订单状态为已付款，往该表插入一条记录
--  userCode、orderNo、exchangeDate、productName(订单商品名1条)、exchangeNumber、remark、status 不为空。
--  其中 exchangeNumber 插入 '+积分数字'积分数字前加 加号，remark 为  交易获得
-- 2、参加活动领取积分    (收获积分，标 + 号)
-- (1)通过 campaignPageCode 关联 lfywx_campaign_pages 表，用户参加一次活动，往该表插入一条记录
-- userCode、campaignPageCode、exchangeDate、productName(活动名称)、exchangeNumber、remark、status 不为空。
--  其中 exchangeNumber 插入 '+积分数字'积分数字前加 加号，remark 为  活动领取
-- 3、积分商城兑换       (消耗积分，标 － 号)
-- (1)当用户在 后续，订餐网站上面，兑换了商品，这里插入数据
-- (2)通过 productCode 字段，关联crm_exchange_product 表。当用户兑换一件商品，在该表插入一行数据
-- userCode、productCode、exchangeDate、productName(活动名称)、exchangeNumber、remark、isSend、sendPerson、status 不为空。
--  其中 exchangeNumber 插入 '-积分数字'积分数字前加 减号，remark 为  积分兑换
-- 
-- 使用说明：
-- userCode 每次插入数据，不能为空
-- campaignPageCode、productCode、orderNo 三个字段作为外键，对应上面三种情况插入，否则为 null
-- 

CREATE TABLE IF NOT EXISTS `crm_consume_exchange` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `userCode` varchar(50) NOT NULL COMMENT '会员编码，谁做了兑换 每条必填',
  `campaignPageCode`  varchar(100) DEFAULT NULL COMMENT '会员活动表主键 参加活动领取积分必填',
  `productCode` varchar(50) NOT NULL COMMENT '产品编码，兑换了什么东西，关联crm_exchange_product 积分兑换商品必填',
  `orderNo` varchar(50) NOT NULL COMMENT '订单编码 金额折算获取积分时必填',
  `exchangeDate` datetime DEFAULT NULL  COMMENT '兑换时间，什么时间兑换的',
  `productName` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `exchangeNumber` varchar(50) DEFAULT NULL COMMENT '兑换积分数目',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注，如 交易获得 活动获得',
  `isSend` varchar(255) DEFAULT NULL COMMENT '是否发货   0否 1是 这里可编辑 productCode 不为空必填',
  `sendPerson` varchar(50) DEFAULT NULL COMMENT '发货人姓名',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


-- 记录会员参加活动 统计表 的结构 `lfywx_member_campaign`
-- 纯粹记录信息。这个表考虑到没有实际用途，合并到上一个表中
--
-- CREATE TABLE IF NOT EXISTS `lfywx_member_campaign` (
--    `id` bigint(10) NOT NULL AUTO_INCREMENT,
--   `memCampaigncode` varchar(50) NOT NULL COMMENT '编码，随机数',
--   `userCode` varchar(50) NOT NULL COMMENT '会员编码，跟 会员表关联',
--   `campaignCode` varchar(50) NOT NULL COMMENT '活动编码，跟 活动表关联',
--   `getDate` datetime DEFAULT NULL  COMMENT '参与活动开始时间',
--   `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;




-- 优惠券 管理 的结构 `lfywx_coupon`
-- 表示发放一次优惠券的总信息，都记录在该表中，
-- 后台优惠券管理模块，编辑好优惠券基本信息:名称、类型、图片、起止时间、总数、单张金额、详情后
-- 点击按钮<生成优惠券>，然后在 'lfywx_coupon_pages' 表中生成单张的优惠券记录
-- 微信端，点击"优惠券"看到的列表是，这个表里面的总信息。
-- 但是用户领取的是 'lfywx_coupon_pages'里面的单张优惠券
--
-- 20140808 增加 couponValue 字段，表示单张优惠券的金额
--

CREATE TABLE IF NOT EXISTS `lfywx_coupon` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `couponCode` varchar(50) NOT NULL COMMENT '优惠券发放活动总编码，随机数',
  `couponName` varchar(100) NOT NULL COMMENT '优惠券名称',
  `couponType` varchar(100) NOT NULL COMMENT '优惠券类型，1兑换券(用积分换)、2代金券(免费发放)',
  `couponImage` varchar(100) NOT NULL COMMENT '图片路径',
  `startDate` datetime DEFAULT NULL  COMMENT '活动开始时间',
  `endDate` datetime DEFAULT NULL  COMMENT '活动截止时间',
  `avtiveTime` varchar(100) DEFAULT NULL COMMENT '有效期，下载后7天内有效',
  `couponTotals` int(11) DEFAULT NULL COMMENT '优惠券总数',
  `couponValue` int(11) DEFAULT NULL COMMENT '优惠券单张金额',
  `couponExchanges` int(11) DEFAULT NULL COMMENT '优惠券已下载数目',
  `couponDesc` varchar(50) DEFAULT NULL COMMENT '优惠券详情',
  `isNew` varchar(255) DEFAULT NULL COMMENT '是否最新   0否 1是 最近 10条为最新',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '发布人姓名',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


-- 20140808 新增表格，表示每次发放的单张优惠券记录表
-- 如果上面表里面 优惠券总数，一次发放 10 张，基本信息填写完毕，这个表会插入10条记录
-- 用户领取一张，这里的记录 下载状态就修改一条 
--  isDown 字段，用户下载一张优惠券的同时，修改 isDown=1 同时，修改lfywx_coupon已下载数量 couponExchanges+1
--
CREATE TABLE IF NOT EXISTS `lfywx_coupon_pages` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `couponPageCode` varchar(50) NOT NULL COMMENT '单张优惠券编码，随机数',
  `couponCode` varchar(50) NOT NULL COMMENT '优惠券发放活动总编码，随机数',
  `couponValue` int(11) DEFAULT NULL COMMENT '优惠券单张金额',
  `isDown` varchar(255) DEFAULT NULL COMMENT '是否被下载   0否 1是',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示过期 1 表示有效活动 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


-- 会员领取优惠券 统计表 的结构 `lfywx_member_coupon`
-- 优惠券下载后，还有一个使用的过程，与后台 优惠券使用挂钩。
-- 该表要根据优惠券使用情况做数据的改动
-- 20140808 修改，把  `couponCode` varchar(50) NOT NULL COMMENT '优惠券编码，跟 优惠券表关联',
-- 修改为 单张优惠券的编码  `couponPageCode` varchar(50) NOT NULL COMMENT '单张优惠券编码',
--
CREATE TABLE IF NOT EXISTS `lfywx_member_coupon` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `memCouponcode` varchar(50) NOT NULL COMMENT '编码，随机数',
  `userCode` varchar(50) NOT NULL COMMENT '会员编码，跟 会员表关联',
  `couponPageCode` varchar(50) NOT NULL COMMENT '单张优惠券编码',
  `downloadDate` datetime DEFAULT NULL  COMMENT '优惠券下载时间',
  `disableDate` datetime DEFAULT NULL  COMMENT '优惠券失效时间，下载时间加7天',
  `isActive` varchar(100) NOT NULL COMMENT '该优惠券是否有效',
  `isUsed` varchar(100) NOT NULL COMMENT '该优惠券是否使用',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;
