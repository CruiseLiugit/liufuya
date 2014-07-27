-- --------------------------------------------------------
-- 2014-07-23 补充数据库表格 会员投诉类别、投诉处理、预设短信内容、
-- 兑奖规则、
-- --------------------------------------------------------

--
-- 会员投诉类别 表的结构 `lfy_member_complain_type`
--

CREATE TABLE IF NOT EXISTS `lfy_member_complain_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeCode`  varchar(100) DEFAULT NULL COMMENT '随机数编码',
  `typeName` varchar(30) DEFAULT NULL COMMENT '投诉类型名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `createDate` datetime DEFAULT NULL COMMENT '设置日期',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '设置管理员名称',
  `status` varchar(50) DEFAULT NULL COMMENT '0表示 删除 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


--
-- 会员投诉信息表 表的结构 `lfy_member_complain`
--

CREATE TABLE IF NOT EXISTS `lfy_member_complain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complainCode`  varchar(100) DEFAULT NULL COMMENT '投诉编号 cp+随机数编码',
  `typeCode`  varchar(50) DEFAULT NULL COMMENT '诉求类别编码',
  `userCode` varchar(50) NOT NULL COMMENT '会员编码，谁投诉了',
  `complainContent` varchar(500) DEFAULT NULL COMMENT '投诉内容',
  `createDate` datetime DEFAULT NULL COMMENT '投诉时间',
  `adminPerson` varchar(50) DEFAULT NULL COMMENT '回复的管理员名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `updateDate` datetime DEFAULT NULL COMMENT '回复时间',
  `isOk` varchar(50) DEFAULT NULL COMMENT '0表示 已经解决   1 表示未解决',
  `status` varchar(50) DEFAULT NULL COMMENT '0表示 删除 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;



--
-- 系统短信 内容 表的结构 `lfy_member_sms`
--

CREATE TABLE IF NOT EXISTS `lfy_member_sms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `smsCode`  varchar(50) DEFAULT NULL COMMENT '随机数编码',
  `smsType` varchar(50) DEFAULT NULL COMMENT '0表示 注册时发送的短信、1 表示找回密码时发送的短信、2表示订购成功时发送的短信、3表示付款成功，积分生成时发送的短信',
  `smsFor` varchar(50) DEFAULT NULL COMMENT '0表示 为订单系统、1 表示为后台管理系统 不同类型用户使用的短信',
  `smsContent` varchar(500) DEFAULT NULL COMMENT '短信内容',
  `createDate` datetime DEFAULT NULL COMMENT '设置时间',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `status` varchar(50) DEFAULT NULL COMMENT '0表示 删除 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;



-- --------------------------------------------------------
--  积分模块表格 crm_ 开头

--
-- 兑奖规则信息表的结构 `crm_exchange_rule`
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
--

CREATE TABLE IF NOT EXISTS `crm_exchange_product` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `productCode` varchar(50) NOT NULL COMMENT '产品编码，随机数',
  `exchangeRuleCode` varchar(50) DEFAULT NULL COMMENT '积分兑换规则类别',
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
--

CREATE TABLE IF NOT EXISTS `crm_consume_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruleCode`  varchar(100) DEFAULT NULL COMMENT '随机数编码',
  `ruleName` char(30) DEFAULT NULL COMMENT '消费积分规则名称',
  `ruleNumber` int DEFAULT NULL COMMENT '折算成积分的数值',
  `rulePrice` int DEFAULT NULL COMMENT '消费金额数值',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `startDate` datetime DEFAULT NULL COMMENT '设置日期',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '设置管理员名称',
  `status` varchar(50) DEFAULT NULL COMMENT '0表示 删除 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;



--
-- 会员积分兑换 管理 的结构 `crm_consume_exchange`
-- 所有兑换过产品的会员信息表
--

CREATE TABLE IF NOT EXISTS `crm_consume_exchange` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `userCode` varchar(50) NOT NULL COMMENT '会员编码，谁做了兑换',
  `productCode` varchar(50) NOT NULL COMMENT '产品编码，兑换了什么东西，关联crm_exchange_product',
  `exchangeDate` datetime DEFAULT NULL  COMMENT '兑换时间，什么时间兑换的',
  `productName` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `exchangeNumber` varchar(50) DEFAULT NULL COMMENT '兑换积分数目',
  `isSend` varchar(255) DEFAULT NULL COMMENT '是否发货   0否 1是',
  `sendPerson` varchar(50) DEFAULT NULL COMMENT '发货人姓名',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;



-- --------------------------------------------------------
-- 2014-07-24 补充数据库表格 微信端、最新活动、优惠券  以 lfywx_ 开头
-- --------------------------------------------------------

-- 最新活动 发布管理 的结构 `lfywx_campaign`
-- 所有发布的活动，记录在该表中，用户参加活动，奖品如果是积分，修改会员积分表
-- 奖品如果是优惠券，修改 会员优惠券表，增加一条优惠券领取记录。
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
  `campaignToalPrize` int(11) DEFAULT NULL COMMENT '活动奖品总额，如 50000，如果不设置，认为总额无限',
  `campaignPrize` int(11) DEFAULT NULL COMMENT '活动奖品单份，可以是积分、优惠券',
  `prizeType` varchar(255) DEFAULT NULL COMMENT '活动奖品类型    1是 送积分 2 表示送优惠券',
  `isNew` varchar(255) DEFAULT NULL COMMENT '是否最新   0否 1是 最近 10条为最新',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '发布人姓名',
  `status` varchar(255) DEFAULT NULL COMMENT '0 表示删除, 1 表示积分  2 表示优惠券',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


-- 优惠券 管理 的结构 `lfywx_coupon`
-- 所有发放的优惠券，都记录在该表中
--
CREATE TABLE IF NOT EXISTS `lfywx_coupon` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `couponCode` varchar(50) NOT NULL COMMENT '优惠券编码，随机数',
  `couponName` varchar(100) NOT NULL COMMENT '优惠券名称',
  `couponType` varchar(100) NOT NULL COMMENT '优惠券类型，1兑换券(用积分换)、2代金券(免费发放)',
  `couponImage` varchar(100) NOT NULL COMMENT '图片路径',
  `startDate` datetime DEFAULT NULL  COMMENT '活动开始时间',
  `endDate` datetime DEFAULT NULL  COMMENT '活动截止时间',
  `avtiveTime` varchar(100) DEFAULT NULL COMMENT '有效期，下载后7天内有效',
  `couponTotals` int(11) DEFAULT NULL COMMENT '优惠券总数',
  `couponExchanges` int(11) DEFAULT NULL COMMENT '优惠券已下载数目',
  `couponDesc` varchar(50) DEFAULT NULL COMMENT '优惠券详情',
  `isNew` varchar(255) DEFAULT NULL COMMENT '是否最新   0否 1是 最近 10条为最新',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '发布人姓名',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


-- 会员领取优惠券 统计表 的结构 `lfywx_member_coupon`
-- 优惠券下载后，还有一个使用的过程，与后台 优惠券使用挂钩。
-- 该表要根据优惠券使用情况做数据的改动
--
CREATE TABLE IF NOT EXISTS `lfywx_member_coupon` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `memCouponcode` varchar(50) NOT NULL COMMENT '编码，随机数',
  `userCode` varchar(50) NOT NULL COMMENT '会员编码，跟 会员表关联',
  `couponCode` varchar(50) NOT NULL COMMENT '优惠券编码，跟 优惠券表关联',
  `downloadDate` datetime DEFAULT NULL  COMMENT '优惠券下载时间',
  `disableDate` datetime DEFAULT NULL  COMMENT '优惠券失效时间，下载时间加7天',
  `isActive` varchar(100) NOT NULL COMMENT '该优惠券是否有效',
  `isUsed` varchar(100) NOT NULL COMMENT '该优惠券是否使用',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

-- 记录会员参加活动 统计表 的结构 `lfywx_member_campaign`
-- 纯粹记录信息
--
CREATE TABLE IF NOT EXISTS `lfywx_member_campaign` (
   `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `memCampaigncode` varchar(50) NOT NULL COMMENT '编码，随机数',
  `userCode` varchar(50) NOT NULL COMMENT '会员编码，跟 会员表关联',
  `campaignCode` varchar(50) NOT NULL COMMENT '活动编码，跟 活动表关联',
  `getDate` datetime DEFAULT NULL  COMMENT '参与活动开始时间',
  `status` varchar(255) DEFAULT NULL  COMMENT '0 表示删除, 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;


