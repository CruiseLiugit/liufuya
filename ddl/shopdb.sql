-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2014-06-03 11:53:37
-- 服务器版本： 5.6.16
-- PHP Version: 5.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `shopdb`
--

-- --------------------------------------------------------

--
-- 表的结构 `lfyshop_product`
--

CREATE TABLE IF NOT EXISTS `lfyshop_product` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `productCode` varchar(50) NOT NULL,
  `category_code` varchar(50) DEFAULT NULL,
  `productName` varchar(100) DEFAULT NULL,
  `productDesc` text,
  `pic` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `cheapPrice` int(11) DEFAULT NULL,
  `stockNumber` int(11) DEFAULT NULL,
  `unit` int(11) DEFAULT NULL COMMENT '单位 0无 1份 2普通装 3标准杯 4其他',
  `otherUnit` varchar(255) DEFAULT NULL COMMENT '在unit 为4时 这边提供填写',
  `create_date` datetime DEFAULT NULL,
  `isNew` varchar(255) DEFAULT NULL COMMENT '是否新品 0否 1是',
  `status` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_recommend` varchar(10) DEFAULT '0' COMMENT '是否推荐 1是 0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `lfyshop_product`
--

INSERT INTO `lfyshop_product` (`id`, `productCode`, `category_code`, `productName`, `productDesc`, `pic`, `price`, `cheapPrice`, `stockNumber`, `unit`, `otherUnit`, `create_date`, `isNew`, `status`, `update_date`, `is_recommend`) VALUES
(1, '13974777092814', '32842c97-7063-453e-a5c9-3b25670a7190', '鲜肉酥饼(1只装)', '精选猪肉调制入味，包入酥皮中，烘焙后层层香酥，丰腴的肉汁慢慢渗入酥皮，香味扑鼻，口口满足！', '13974777091193.jpg', 500, 500, 5656, 1, '', '2014-04-14 20:15:09', '0', '1', '2014-04-14 20:15:09', '0'),
(2, '13974777436875', '32842c97-7063-453e-a5c9-3b25670a7190', '德式盐烤猪肘比萨', '精选鲜咸多汁的德式猪肘丁和香葱风味香肠，口感鲜香浓郁，并辅以微辣的南美风味莎莎酱，再搭配青红椒等蔬菜，带给你独特创意的欧式美味。', '13974777436175.jpg', 4500, 4500, 5678, 2, '', '2014-04-14 20:15:43', '0', '1', '2014-04-14 20:15:43', '1'),
(3, '13974777838911', '32842c97-7063-453e-a5c9-3b25670a7190', '板栗炖鸡饭', '精挑糯香板栗和去骨鸡肉一起炖煮，让板栗的香甜渗入鸡肉当中，香气浓郁四溢，沁人心脾。更烩入蔬菜，让整体色泽鲜艳丰富，让人一见就食欲大开。（400g）', '13974777838795.jpg', 3400, 3400, 567, 1, '', '2014-04-14 20:16:23', '0', '1', '2014-04-14 20:16:23', '1'),
(4, '13974778184495', '32842c97-7063-453e-a5c9-3b25670a7190', '丰盛比萨套餐', '1份德式盐烤猪肘比萨或其他指定至尊系列比萨（小装）；1份 板栗炖鸡饭/经典意式热辣培根面/瑶柱海鲜饭；1份 新奥尔良风味鸡翅（2块）；1份 骨肉相连（2串）；1份 美式香酥薯格（50克）；2份指定冰饮或汤（椰趣玛瑙石榴汁饮料/芒果香橙汁饮料/巧克力熔岩爆珠奶茶/虫草花鸡汤）', '13974778184320.jpg', 4500, 4500, 56, 1, '', '2014-04-14 20:16:58', '0', '1', '2014-04-14 20:16:58', '0'),
(5, '13974778694592', '32842c97-7063-453e-a5c9-3b25670a7190', '意式培根卷大虾比萨 ', '鲜嫩弹滑的大虾经意式风味罗勒青酱精心调味后卷上鲜香培根，让你一次尝尽海陆两种美味，带你感受浪漫意式风情。 *温馨提示：意式培根卷大虾比萨中的虾尾带壳烹饪，儿童请在家长监护下食用。', '13974778694331.jpg', 4500, 4500, 45, 1, '', '2014-04-14 20:17:49', '0', '1', '2014-04-14 20:17:49', '1'),
(6, '13974779016240', 'bbd0415f-22bb-4204-bcad-4ed8c064f679', '新奥尔良风情烤肉比萨 ', '浓郁的新奥尔良鸡肉和鲜香培根，辅以金黄香浓的车打芝士酱和蘑菇等烤制，美味口中尽享。', '13974779016062.jpg', 4500, 4500, 45, 1, '', '2014-04-14 20:18:21', '0', '1', '2014-04-14 20:18:21', '0'),
(7, '13974779327985', 'bbd0415f-22bb-4204-bcad-4ed8c064f679', '意式经典肉酱比萨', '意式风味经典肉酱和鲜香腊肉肠的完美结合，每一口都满足！', '13974779327852.jpg', 4500, 4500, 45, 1, '', '2014-04-14 20:18:52', '0', '1', '2014-04-14 20:18:52', '1'),
(8, '13974779661493', '2e3c4997-624c-409e-9e2d-d267d99b630a', '夏威夷风光比萨', '肉香满满的火腿配上酸甜可口的菠萝，融入浓浓芝士，热力四射的夏威夷风情尽在口中。', '13974779661022.jpg', 4500, 4500, 45, 1, '', '2014-04-14 20:19:26', '0', '1', '2014-04-14 20:19:26', '1');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_category`
--

CREATE TABLE IF NOT EXISTS `lfy_category` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(50) NOT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `category_pcode` varchar(50) NOT NULL DEFAULT '0' COMMENT '节点父',
  `create_date` datetime DEFAULT NULL,
  `create_opid` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `categoryOrder` int(10) DEFAULT NULL,
  `show_name` varchar(100) DEFAULT NULL,
  `categoryType` varchar(10) DEFAULT '备留字段',
  `category_rootcode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=19 ;

--
-- 转存表中的数据 `lfy_category`
--

INSERT INTO `lfy_category` (`id`, `category_code`, `category_name`, `category_pcode`, `create_date`, `create_opid`, `status`, `categoryOrder`, `show_name`, `categoryType`, `category_rootcode`) VALUES
(10, 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '菜单', '-1', '2014-04-09 21:39:42', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 0, '菜单', NULL, 'a943cdd3-5a80-4cdf-ba86-a681c981a174'),
(11, '32842c97-7063-453e-a5c9-3b25670a7190', '当季特选', 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '2014-04-09 21:40:20', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 0, '当季特选', NULL, '32842c97-7063-453e-a5c9-3b25670a7190'),
(12, '34b6caed-97a4-41da-b7e4-6ad3f26ef372', '披萨', 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '2014-04-09 21:40:54', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 1, '披萨', NULL, '34b6caed-97a4-41da-b7e4-6ad3f26ef372'),
(13, 'd10db273-f25f-4a75-92cb-789a3db44af8', '饭食', 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '2014-04-09 21:41:26', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 2, '饭食', NULL, 'd10db273-f25f-4a75-92cb-789a3db44af8'),
(14, 'bbd0415f-22bb-4204-bcad-4ed8c064f679', '米线', 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '2014-04-09 21:41:51', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 3, '米线', NULL, 'bbd0415f-22bb-4204-bcad-4ed8c064f679'),
(15, '03fc52c0-3d8c-4963-ad5b-f4bf36ee50e2', '优惠直通车', '-1', '2014-04-09 21:42:19', '8532aa11-08ae-444d-bb72-801f4f9997b6', '0', 1, '超值套餐', NULL, '03fc52c0-3d8c-4963-ad5b-f4bf36ee50e2'),
(16, '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', '优惠直通车', '-1', '2014-04-09 21:42:46', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 1, '优惠直通车', NULL, '7046b025-dec8-46bb-a8f4-c8c1e46af2fa'),
(17, '2e3c4997-624c-409e-9e2d-d267d99b630a', '超值套餐', '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', '2014-04-09 21:42:59', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 0, '超值套餐', NULL, '2e3c4997-624c-409e-9e2d-d267d99b630a'),
(18, '2d2fbc3f-b772-45ab-baa9-fea5ef5cc390', '散装系列', '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', '2014-04-09 21:43:30', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 1, '散装系列', NULL, '2d2fbc3f-b772-45ab-baa9-fea5ef5cc390');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_categoryproperty`
--

CREATE TABLE IF NOT EXISTS `lfy_categoryproperty` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `categoryProperty_code` varchar(50) NOT NULL,
  `category_code` varchar(50) NOT NULL,
  `property_code` varchar(50) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_opid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `lfy_categorypropertyvalue`
--

CREATE TABLE IF NOT EXISTS `lfy_categorypropertyvalue` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `pv_code` varchar(50) NOT NULL,
  `categoryProperty_code` varchar(50) NOT NULL COMMENT '类目属性 外键',
  `PV_name` varchar(100) DEFAULT NULL COMMENT '性值属名称',
  `show_name` varchar(100) DEFAULT NULL COMMENT '般一和属性值名称相等',
  `PV_type` varchar(10) DEFAULT NULL COMMENT '属性值类型 1字符串 2价格区间',
  `PV_order` int(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `lfy_citypart`
--

CREATE TABLE IF NOT EXISTS `lfy_citypart` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(50) DEFAULT NULL,
  `address_desc` varchar(200) DEFAULT NULL,
  `address_parent` bigint(10) DEFAULT NULL COMMENT '节点父id 顶级为-1',
  `status` varchar(10) DEFAULT NULL COMMENT '状态 1正常 0删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `lfy_citypart`
--

INSERT INTO `lfy_citypart` (`id`, `address_name`, `address_desc`, `address_parent`, `status`) VALUES
(1, '上海', '上海', -1, '1'),
(2, '闵行区', '闵行区', 1, '1'),
(3, '浦东新区', '普通新区', 1, '1'),
(4, '徐汇区', '徐汇区', 1, '1'),
(5, '苏州', '苏州', -1, '1'),
(6, '吴中区', '吴中区', 5, '1'),
(7, '高新区', '高新区', 5, '1'),
(8, '世纪大道', '世纪大道', 3, '1');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_member`
--

CREATE TABLE IF NOT EXISTS `lfy_member` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL,
  `user_type` varchar(10) DEFAULT NULL COMMENT '1.实体卡 2.网站注册 3.微信注册 4.后台注册',
  `loginName` varchar(50) DEFAULT NULL,
  `loginPwd` varchar(50) DEFAULT NULL,
  `realName` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL COMMENT '1.男 0女',
  `birthday` date DEFAULT NULL,
  `card_number` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `telphone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `entityCardNumber` varchar(50) DEFAULT NULL COMMENT '实体卡卡号',
  `entityCardStatus` varchar(50) DEFAULT NULL COMMENT '实体卡状态1已开卡2已使用3已作废',
  `memberCard_balance` int(11) DEFAULT NULL COMMENT '会员卡余额 精确到分',
  `memberCard_score` int(11) DEFAULT NULL COMMENT '会员卡总积分',
  `create_date` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL COMMENT '1正常 0删除 2拉黑',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `lfy_member`
--

INSERT INTO `lfy_member` (`id`, `user_code`, `user_type`, `loginName`, `loginPwd`, `realName`, `sex`, `birthday`, `card_number`, `city`, `telphone`, `email`, `entityCardNumber`, `entityCardStatus`, `memberCard_balance`, `memberCard_score`, `create_date`, `status`) VALUES
(2, '1399474476189722', '2', '18951106637', 'E10ADC3949BA59ABBE56E057F20F883E', '缪汉斌', '1', NULL, NULL, '重庆', '18951106637', '1149412346@qq.com', NULL, NULL, 0, 0, '2014-05-07 22:54:36', '1'),
(3, '1399907314774933', '2', '18914023646', '96E79218965EB72C92A549DD5A330112', '缪汉斌', '1', NULL, NULL, '上海', '18914023646', NULL, NULL, NULL, 0, 0, '2014-05-12 23:08:34', '1'),
(4, '1399907675367683', '2', '18068338576', '96E79218965EB72C92A549DD5A330112', '缪汉斌', '1', NULL, NULL, '上海', '18068338576', NULL, NULL, NULL, 0, 0, '2014-05-12 23:14:35', '1'),
(5, '1399907742766384', '2', '18068338575', '7FA8282AD93047A4D6FE6111C93B308A', '缪汉斌', '1', NULL, NULL, '苏州', '18068338575', NULL, NULL, NULL, 0, 0, '2014-05-12 23:16:19', '1'),
(6, '1399908089387694', '2', '18068338571', '96E79218965EB72C92A549DD5A330112', '缪汉斌', '1', NULL, NULL, '上海', '18068338571', NULL, NULL, NULL, 0, 0, '2014-05-12 23:21:33', '1'),
(7, '1399996157763131', '2', '18951106636', '96E79218965EB72C92A549DD5A330112', '缪汉斌', NULL, NULL, NULL, '上海', '18951106636', NULL, NULL, NULL, 0, 0, '2014-05-13 23:49:17', '1'),
(8, '1400766758626930', '2', '18964187252', '96E79218965EB72C92A549DD5A330112', '缪汉斌', NULL, NULL, NULL, '上海', '18964187252', NULL, NULL, NULL, 0, 0, '2014-05-22 21:52:38', '1'),
(9, '1400768532269179', '2', '18951106666', '96E79218965EB72C92A549DD5A330112', '缪汉斌', NULL, NULL, NULL, '上海', '18951106666', NULL, NULL, NULL, 0, 0, '2014-05-22 22:22:12', '1');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_member_address`
--

CREATE TABLE IF NOT EXISTS `lfy_member_address` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `address_code` varchar(50) DEFAULT NULL,
  `user_code` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `address_keywords` varchar(200) DEFAULT NULL,
  `gps_long` varchar(50) DEFAULT NULL,
  `gps_lat` varchar(50) DEFAULT NULL,
  `bmaps_info` varchar(200) DEFAULT NULL  COMMENT '百度地图信息暂为NULL',
  `available_shops` varchar(500) DEFAULT NULL COMMENT '周边配送符合配送条件的门店编号(Null表示无门店可以配送,有多家门店可以外送存入JSON对象{"n1":"门店编号","n2":"门店编号"})',
  `create_date` date DEFAULT NULL,
  `is_default` varchar(10) DEFAULT NULL COMMENT '是否是默认(0 不是 1 是)',
  `status` varchar(255) DEFAULT NULL COMMENT '状态(1 正常 0 被删除 )',
  `is_available` varchar(10) DEFAULT '0' COMMENT '是否可以配送 1可以 0不可以',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `lfy_member_address`
--

INSERT INTO `lfy_member_address` (`id`, `address_code`, `user_code`, `city`, `area`, `address_keywords`, `gps_long`, `gps_lat`, `bmaps_info`, `available_shops`, `create_date`, `is_default`, `status`, `is_available`) VALUES
(1, '1399907675408111', '1399907314774933', '上海', '徐汇区', '金桥路', NULL, NULL, NULL, NULL, '2014-05-12', '0', '0', '0'),
(2, '1399907675408193', '1399907314774933', '上海', '嘉定区', '金桥路', NULL, NULL, NULL, NULL, '2014-05-12', '0', '0', '0'),
(3, '1399907779123834', '1399907314774933', '苏州', '吴中区', '金桥路', NULL, NULL, NULL, NULL, '2014-05-12', '0', '0', '0'),
(4, '1399908093233388', '1399907314774933', '苏州', '高新区', '苏州科技学院天平校区', NULL, NULL, NULL, NULL, '2014-05-12', '1', '1', '1'),
(5, '1399996157864719', '1399907314774933', '上海', '闵行区', '金桥路123号', NULL, NULL, NULL, NULL, '2014-05-13', '0', '1', '0'),
(7, '1400158053008551', '1399907314774933', '上海', '闵行区', '爱博家园1100号', NULL, NULL, NULL, NULL, '2014-05-15', '0', '1', '0'),
(8, '1400603986277329', '1399907314774933', '上海', '浦东新区', '金桥路1155弄', NULL, NULL, NULL, NULL, '2014-05-21', '0', '1', '0'),
(9, '1400766758715858', '1400766758626930', '上海', '浦东新区', '金桥路1055弄', NULL, NULL, NULL, NULL, '2014-05-22', '1', '1', '0'),
(10, '1400768532310591', '1400768532269179', '上海', '徐汇区', '漕河泾开发区', NULL, NULL, NULL, NULL, '2014-05-22', '1', '1', '0'),
(11, '1400938512401413', '1399907314774933', '上海', '闵行区', '九亭镇绿庭尚城', NULL, NULL, NULL, NULL, '2014-05-24', '0', '1', '0');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_order`
--

CREATE TABLE IF NOT EXISTS `lfy_order` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(50) NOT NULL,
  `orderMoney` int(11) DEFAULT NULL COMMENT '订单总价',
  `orderTotalMoney` int(11) DEFAULT NULL COMMENT '订单实际购买价格',
  `couponMoney` int(11) DEFAULT NULL COMMENT '订单优惠价格',
  `orderStatus` varchar(255) DEFAULT NULL COMMENT '订单状态 1待支付 2已支付 3已关闭',
  `create_date` datetime DEFAULT NULL,
  `orderPayType` varchar(255) DEFAULT NULL COMMENT '1.网上支付 2货到现金支付',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  `userCode` varchar(255) DEFAULT NULL COMMENT '订单用户',
  `status` varchar(255) DEFAULT NULL COMMENT '状态 1正常 0删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=23 ;

--
-- 转存表中的数据 `lfy_order`
--

INSERT INTO `lfy_order` (`id`, `orderNo`, `orderMoney`, `orderTotalMoney`, `couponMoney`, `orderStatus`, `create_date`, `orderPayType`, `pay_date`, `userCode`, `status`) VALUES
(1, '13976607597263', 500, 500, 0, '1', '2014-04-16 23:05:59', '1', NULL, '3333333333333333', '1'),
(2, '13976608425400', 0, 0, 0, '1', '2014-04-16 23:07:22', '1', NULL, '3333333333333333', '1'),
(3, '13976610231383', 0, 0, 0, '1', '2014-04-16 23:10:23', '1', NULL, '3333333333333333', '1'),
(4, '13976610465180', 0, 0, 0, '1', '2014-04-16 23:10:46', '1', NULL, '3333333333333333', '1'),
(5, '13976612436762', 0, 0, 0, '1', '2014-04-16 23:14:03', '1', NULL, '3333333333333333', '1'),
(6, '13976615755981', 15800, 15800, 0, '1', '2014-04-16 23:19:35', '1', NULL, '3333333333333333', '1'),
(7, '13976615912960', 4500, 4500, 0, '1', '2014-04-16 23:19:51', '1', NULL, '3333333333333333', '1'),
(8, '13976616809133', 13500, 13500, 0, '1', '2014-04-16 23:21:20', '1', NULL, '3333333333333333', '1'),
(9, '13976617168832', 41700, 41700, 0, '1', '2014-04-16 23:21:56', '1', NULL, '3333333333333333', '1'),
(10, '13976620297835', 500, 500, 0, '1', '2014-04-16 23:27:09', '1', NULL, '3333333333333333', '1'),
(11, '13979096097694', 14600, 14600, 0, '1', '2014-04-19 20:13:29', '1', NULL, '3333333333333333', '1'),
(12, '13979096779361', 0, 0, 0, '1', '2014-04-19 20:14:37', '1', NULL, '3333333333333333', '1'),
(13, '1399553642274410', 1000, 1000, 0, '1', '2014-05-08 20:54:02', '1', NULL, '3333333333333333', '1'),
(14, '1399553726318472', 500, 500, 0, '1', '2014-05-08 20:55:26', '1', NULL, '3333333333333333', '1'),
(15, '1399559570436878', 4500, 4500, 0, '1', '2014-05-08 22:32:50', '1', NULL, '3333333333333333', '1'),
(16, '1399560912343527', 11700, 11700, 0, '1', '2014-05-08 22:55:12', '1', NULL, '3333333333333333', '1'),
(17, '1399789206753167', 23000, 23000, 0, '1', '2014-05-11 14:20:06', '1', NULL, '3333333333333333', '1'),
(18, '1399789860964142', 18000, 18000, 0, '1', '2014-05-11 14:31:00', '1', NULL, '3333333333333333', '1'),
(20, '1400166066973628', 53400, 53400, 0, '1', '2014-05-15 23:01:06', '1', NULL, '3333333333333333', '1'),
(21, '1400166172628291', 56800, 56800, 0, '1', '2014-05-15 23:02:52', '1', NULL, '3333333333333333', '1'),
(22, '1400167281163387', 40500, 40500, 0, '1', '2014-05-15 23:21:21', '1', NULL, '3333333333333333', '1');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_order_content`
--

CREATE TABLE IF NOT EXISTS `lfy_order_content` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(50) DEFAULT NULL,
  `productCode` varchar(50) DEFAULT NULL COMMENT '商品编码 type=0 产品 type=1 套餐',
  `productName` varchar(100) DEFAULT NULL,
  `goodsBuyPrice` int(11) DEFAULT NULL COMMENT '商品实际价格',
  `goodsBuyQrt` int(11) DEFAULT NULL COMMENT '商品购买数量',
  `status` varchar(255) DEFAULT NULL COMMENT '状态 1正常 0删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=38 ;

--
-- 转存表中的数据 `lfy_order_content`
--

INSERT INTO `lfy_order_content` (`id`, `orderNo`, `productCode`, `productName`, `goodsBuyPrice`, `goodsBuyQrt`, `status`) VALUES
(1, '13976607597263', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(2, '13976615755981', '13974777838911', '板栗炖鸡饭', 3400, 2, '1'),
(3, '13976615755981', '13974779327985', '意式经典肉酱比萨(纯珍)', 4500, 1, '1'),
(4, '13976615755981', '13974778184495', '丰盛比萨套餐', 4500, 1, '1'),
(5, '13976615912960', '13974778694592', '意式培根卷大虾比萨 (纯珍)', 4500, 1, '1'),
(6, '13976616809133', '13974777436875', '德式盐烤猪肘比萨(纯珍)', 4500, 1, '1'),
(7, '13976616809133', '13974778184495', '丰盛比萨套餐', 4500, 1, '1'),
(8, '13976616809133', '13974778694592', '意式培根卷大虾比萨 (纯珍)', 4500, 1, '1'),
(9, '13976617168832', '13974777838911', '板栗炖鸡饭', 3400, 3, '1'),
(10, '13976617168832', '13974778184495', '丰盛比萨套餐', 4500, 2, '1'),
(11, '13976617168832', '13974779327985', '意式经典肉酱比萨(纯珍)', 4500, 2, '1'),
(12, '13976617168832', '13974779661493', '夏威夷风光比萨(纯珍)', 4500, 3, '1'),
(13, '13976620297835', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(14, '13979096097694', '13974777092814', '鲜肉酥饼(1只装)', 500, 2, '1'),
(15, '13979096097694', '13974777838911', '板栗炖鸡饭', 3400, 4, '1'),
(16, '1399553642274410', '13974777092814', '鲜肉酥饼(1只装)', 500, 2, '1'),
(17, '1399553726318472', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(18, '1399559570436878', '13974779016240', '新奥尔良风情烤肉比萨 (纯珍)', 4500, 1, '1'),
(19, '1399560912343527', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(20, '1399560912343527', '13974778694592', '意式培根卷大虾比萨 (纯珍)', 4500, 1, '1'),
(21, '1399560912343527', '13974781689800', '板栗炖鸡饭套餐', 6700, 1, '1'),
(22, '1399789206753167', '13974778694592', '意式培根卷大虾比萨 (纯珍)', 4500, 5, '1'),
(23, '1399789206753167', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(24, '1399789860964142', '13974777436875', '德式盐烤猪肘比萨(纯珍)', 4500, 1, '1'),
(25, '1399789860964142', '13974778184495', '丰盛比萨套餐', 4500, 2, '1'),
(26, '1399789860964142', '13974779016240', '新奥尔良风情烤肉比萨 (纯珍)', 4500, 1, '1'),
(27, '1400166066973628', '13974778694592', '意式培根卷大虾比萨 (纯珍)', 4500, 8, '1'),
(28, '1400166066973628', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(29, '1400166066973628', '13974777436875', '德式盐烤猪肘比萨(纯珍)', 4500, 2, '1'),
(30, '1400166066973628', '13974779661493', '夏威夷风光比萨(纯珍)', 4500, 1, '1'),
(31, '1400166066973628', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(32, '1400166172628291', '13974778694592', '意式培根卷大虾比萨 (纯珍)', 4500, 8, '1'),
(33, '1400166172628291', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(34, '1400166172628291', '13974777436875', '德式盐烤猪肘比萨(纯珍)', 4500, 2, '1'),
(35, '1400166172628291', '13974779661493', '夏威夷风光比萨(纯珍)', 4500, 1, '1'),
(36, '1400166172628291', '13974777838911', '板栗炖鸡饭', 3400, 2, '1'),
(37, '1400167281163387', '13974778184495', '丰盛比萨套餐', 4500, 9, '1');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_property`
--

CREATE TABLE IF NOT EXISTS `lfy_property` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `property_code` varchar(50) NOT NULL,
  `property_name` varchar(50) DEFAULT NULL,
  `property_type` varchar(10) DEFAULT NULL COMMENT '类别 保留字段',
  `property_order` int(10) DEFAULT NULL,
  `show_name` varchar(50) DEFAULT NULL COMMENT '展示名字 一般和perperty_name相同',
  `status` varchar(10) DEFAULT NULL,
  `choose_status` varchar(10) DEFAULT NULL COMMENT '选择状态 1单选 2多选',
  `create_date` datetime DEFAULT NULL,
  `create_opid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `lfy_property`
--

INSERT INTO `lfy_property` (`id`, `property_code`, `property_name`, `property_type`, `property_order`, `show_name`, `status`, `choose_status`, `create_date`, `create_opid`) VALUES
(1, '9999bfbc-9d31-4d70-b8e8-36e05b1166fa', '品牌', '1', 2, '品牌', '1', '2', '2014-03-06 22:12:49', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa'),
(2, '0c7d8bbd-b954-4cce-b2b7-6cc9ea9228a4', '价格区间', '2', 4, '价格区间', '1', '2', '2014-03-06 23:11:15', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa');

-- --------------------------------------------------------

--
-- 表的结构 `phome_enewsdolog`
--

CREATE TABLE IF NOT EXISTS `phome_enewsdolog` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `logip` varchar(20) NOT NULL,
  `logtime` datetime NOT NULL,
  `preUserCode` varchar(50) DEFAULT NULL,
  `enews` varchar(50) DEFAULT NULL,
  `doing` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `phome_enewsgroup`
--

CREATE TABLE IF NOT EXISTS `phome_enewsgroup` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `groupname` varchar(50) NOT NULL,
  `dopublic` tinyint(4) DEFAULT '1' COMMENT '1 有权限 0无权限',
  `groupCode` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `phome_enewslog`
--

CREATE TABLE IF NOT EXISTS `phome_enewslog` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `logintime` datetime DEFAULT NULL,
  `loginip` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL COMMENT '1登录成功 0登录失败',
  `password` varchar(50) DEFAULT NULL COMMENT '尝试错误密码',
  `loginauth` varchar(10) DEFAULT NULL COMMENT '认证码 1成功 0失败',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `phome_enewsloginfail`
--

CREATE TABLE IF NOT EXISTS `phome_enewsloginfail` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `num` int(10) DEFAULT '0',
  `lasttime` datetime DEFAULT NULL,
  `ip` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `phome_enewsuser`
--

CREATE TABLE IF NOT EXISTS `phome_enewsuser` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `preUserCode` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `phome_enewsuser`
--

INSERT INTO `phome_enewsuser` (`id`, `preUserCode`, `username`, `password`, `create_date`, `status`) VALUES
(1, '004b5595-8b13-4865-9647-e3640660b59f', '海角七号18', 'F59BD65F7EDAFB087A81D4DCA06C4910', '2014-02-19 14:48:44', '1');

-- --------------------------------------------------------

--
-- 表的结构 `phome_enewsuseradd`
--

CREATE TABLE IF NOT EXISTS `phome_enewsuseradd` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `questionCode` varchar(50) NOT NULL,
  `equestion` varchar(200) DEFAULT NULL,
  `eanswer` varchar(500) DEFAULT NULL,
  `preUserCode` varchar(50) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `phome_enewsuseradd`
--

INSERT INTO `phome_enewsuseradd` (`id`, `questionCode`, `equestion`, `eanswer`, `preUserCode`, `status`, `create_date`) VALUES
(1, '2345', 'how are you', 'i am fine', 'dfd', '1', '2014-02-19 22:57:10');

-- --------------------------------------------------------

--
-- 表的结构 `phome_enewsuserclass`
--

CREATE TABLE IF NOT EXISTS `phome_enewsuserclass` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `classCode` varchar(50) NOT NULL,
  `classname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `sys_authorities`
--

CREATE TABLE IF NOT EXISTS `sys_authorities` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `auth_code` varchar(50) NOT NULL,
  `is_menu` varchar(10) DEFAULT NULL COMMENT '是否是子菜单',
  `model_code` varchar(50) DEFAULT NULL,
  `menu_code` varchar(50) NOT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=100 ;

--
-- 转存表中的数据 `sys_authorities`
--

INSERT INTO `sys_authorities` (`id`, `auth_code`, `is_menu`, `model_code`, `menu_code`, `create_date`, `status`) VALUES
(1, 'k14f35f8-2246-41h2-34f2-4cg56ad75ead', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', '2014-02-14', '1'),
(2, 'k24f35f8-2246-41h2-34f2-4cg56ad75ead', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-14', '1'),
(3, '855a5476-0d8d-4ccd-ac64-54ab2eef1fc7', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1'),
(4, 'fc9d19ee-3e51-4a1d-86b8-a043ec48b0a3', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1'),
(5, '26439706-7e39-4f8d-89f4-4f12aa2f8bda', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1'),
(6, '46b26d66-948f-4010-8e73-d87b99442d78', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1'),
(7, '632f97e9-e013-48ae-8171-5d15b7106f29', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1'),
(8, 'e498230e-bed9-41b4-8df4-2a96b128934a', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1'),
(9, 'h2df30b8-2df6-41d2-84f2-4cd56bb75ecc', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-15', '1'),
(10, 'a3455654-dfdf-2345-sdfg-asdfghjdfger', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1'),
(11, 'bd455654-dfdf-2345-sdfg-asdfghjdfger', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1'),
(12, '34555654-dfdf-2345-sdfg-asdfghjdfger', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1'),
(13, '09895654-dfdf-2345-sdfg-asdfghjdfger', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1'),
(14, 'ijkl5654-dfdf-2345-sdfg-asdfghjdfger', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1'),
(15, 'ol055654-dfdf-2345-sdfg-asdfghjdfger', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1'),
(16, '33335654-dfdf-2345-sdfg-asdfghjdfger', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1'),
(17, 'dfdfdfdf-2343-dfdf-dfdf-234325343', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1'),
(18, '7bh87y3-f34f-dfd3er-efre-3rf3r3r', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1'),
(19, 'wgtf4t4-dgrghrg-dgfrh5r-try4hy54y', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1'),
(20, 'dfdfefr4-4g4g4y-f4rt-t4-t4-t4t4t4t', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1'),
(21, 'cergr0-32-r3r-34t4gt54gy-3er4gt4r', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1'),
(22, 'dfdgfe4-grgrhth-34g4rht5rh5ju-f4g', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1'),
(23, 'dg9jf4gt4-f4gt4gy0f4gt-f4g45h54hy', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1'),
(31, '4a65d7c4-9b87-440e-9fd6-821d0d24c916', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f251ebe3-d143-4826-a18c-5e055242b8a2', '2014-02-16', '1'),
(32, '3a9c90a6-1ce7-4867-90ce-e08a8a12a35c', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f251ebe3-d143-4826-a18c-5e055242b8a2', '2014-02-16', '1'),
(33, '7b39cc3c-dfbb-4c4d-a52c-d28290b01815', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f251ebe3-d143-4826-a18c-5e055242b8a2', '2014-02-16', '1'),
(34, '487bc775-363e-4d26-bcb1-5bf95f398ef1', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '365c7266-8c4e-4d87-8dd6-09e46832349c', '2014-02-18', '1'),
(35, 'ab6fbf22-f158-4c71-bd6b-9566050122f6', '0', '0', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(36, '555423be-7abd-4b8b-b5e3-1c3b9ddba4fd', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(37, '31e17456-7f48-426e-94dc-e3eca629731f', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(38, '43a92bde-cf19-46cb-9c65-32b3453f51bb', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(39, '50085cee-e582-4370-9395-5a0b148b6afb', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(40, '65ca29a2-9bcd-4496-a5ec-6ff92f68e20e', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(41, 'fd8c0d74-b303-4fc4-885c-62da789dba66', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(42, 'ffc8b8e6-8d72-410d-8414-8eae9a2322c1', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1'),
(43, 'bf03339b-e927-4ccc-9cc3-dc16c8ef3e44', '0', '0', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(44, '12af47fd-1d80-47ff-b481-22d74dafd3c5', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(45, '7e068109-1093-4763-ac05-bf4978a2938d', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(46, 'ba56a7c4-13d7-449d-be25-c4822e711f6d', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(47, '13f5f078-2e6a-4a60-9a06-a6014a8cc48c', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(48, '38414380-a4da-4688-bb69-5675a4f88889', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(49, '962dff78-1329-48a2-a47d-8db4398df46e', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(50, 'dacda700-6f42-45fc-850a-4b61a6419e0b', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1'),
(51, 'a5f3940b-0ae1-4839-b527-4f29251c3def', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', '2014-03-04', '1'),
(52, '20db17fa-25c0-422c-8d61-a07042c25ed1', '0', '0', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(53, 'cd31fa99-01cc-4585-a746-f078dc238def', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(54, '026f9c3b-8196-496b-b554-419fc8f00567', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(55, '666fc5d2-8031-4d3f-9793-b286b4ddb249', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(56, '710cb246-5163-4d0a-9442-4e88b9db5d9d', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(57, 'd314d14b-9942-48a1-8d61-75553dea2d6f', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(58, 'f3287f28-8127-4b55-91fc-62985fe718eb', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(59, '870da044-eb6c-4108-9eec-dcf798e9f164', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1'),
(60, '5b8fd092-4abc-4433-bc0e-f7d385e38f87', '0', '0', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(61, 'eae3e9d9-2343-4677-b417-733081eaf226', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(62, 'be169ed2-7837-4bfc-88df-0248e7b0bd79', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(63, 'b8cff796-4664-4c44-bed9-5cf0aea0d38a', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(64, '8143832e-62d5-408f-986f-5b17f1ed5b67', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(65, 'd215bf61-365a-48c8-988a-143019aa6a54', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(66, 'b6765370-fdf9-4db1-95cb-f0e6383e6750', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(67, 'c6631983-c3fc-44e6-b290-93c4f920fced', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1'),
(68, '3e6c81cf-d422-4574-8898-e86a3b4c4473', '0', '0', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(69, '4c369013-8e6e-41b7-9438-9d0ee2774b0e', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(70, '82a79ff8-2ab7-4183-a2b2-3cd010785114', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(71, 'ced6ec40-5e52-4e53-ba64-0c938833996b', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(72, '31bf4960-da25-4304-98dd-e1baf89975cd', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(73, '9277ca06-0c5d-41a2-b5bd-ffbe17134806', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(74, 'e2456be5-af0b-4517-aa9a-f6c0cf9b1197', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(75, '2e2e620a-56fe-484f-9968-76fb5e99e110', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1'),
(76, 'c95b0f76-e7b6-414d-8779-9d7fa7064b27', '0', '0', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(77, 'f9c1f807-f071-4903-9728-91b0b1f41e7e', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(78, '65e0bfab-6204-4511-957e-35ca526cb720', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(79, '84cb8f41-0bc3-41e0-a719-52aeb6ef2c2d', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(80, 'aa18448f-4f7b-4888-90cf-f92a3a9439c3', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(81, '6207d26c-260f-4d2e-8ac0-efe1f7a64fb2', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(82, '4f276290-4f5e-436d-a824-e9c398334824', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(83, '1f37fb56-2078-411f-8720-0da3aeaf456e', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '2014-03-09', '1'),
(84, '42649efd-2c2f-47d3-9e87-af3139db7095', '0', '0', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(85, '447a47e9-4878-43ac-81a5-a424921429c9', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(86, '3459aa0a-6f12-461a-a03c-e243f6f8017c', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(87, '6f0f4854-22cc-418a-8101-c5c94701c916', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(88, '3f52fc5c-c980-4b23-8f0d-1d6e4967f8a5', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(89, '0e2c495b-4cf1-4a5d-a6aa-b7a33b0f661b', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(90, '8eaba513-795e-464f-9615-808f78bcec79', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(91, 'bdfa1b70-6182-45c2-8df5-f247a9860bab', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '2014-04-09', '1'),
(92, '604b05f1-358c-4f6d-9ade-e5a16e43adbf', '0', '0', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(93, '7c8f0e44-af9b-4dc8-acf9-e9970d248fe9', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(94, '7960e76b-6737-437f-b445-8412dd68561c', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(95, '849c612b-5951-427a-9a3b-682c7c6c4961', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(96, '1a123e02-8461-4c64-bb1c-7934929d5070', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(97, '4b982499-a1a4-43c3-a17e-3073c95a46c3', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(98, '02052887-6c92-4a25-a595-c8c5230c9ccc', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(99, '2d19a0c1-5063-4fb5-a4e3-fc7083005ab9', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1');

-- --------------------------------------------------------

--
-- 表的结构 `sys_menus`
--

CREATE TABLE IF NOT EXISTS `sys_menus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(50) NOT NULL,
  `menu_name` varchar(50) NOT NULL,
  `levelid` varchar(50) NOT NULL,
  `fmenu_code` varchar(50) DEFAULT NULL,
  `engname` varchar(50) DEFAULT NULL,
  `menu_url` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `sortValue` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `sys_menus`
--

INSERT INTO `sys_menus` (`id`, `menu_code`, `menu_name`, `levelid`, `fmenu_code`, `engname`, `menu_url`, `create_date`, `status`, `sortValue`) VALUES
(1, 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', '系统功能', '1', '0', 'A_SYSTEM', NULL, '2014-02-14', '1', 0),
(2, 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', '权限管理', '10', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', 'A_PRIVILEGE', NULL, '2014-02-14', '1', 0),
(3, 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '用户管理', '101', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_USERMANAGE', '/jsp/user/sysUserList.jsp', '2014-02-14', '1', 1),
(4, 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '角色管理', '102', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_ROLEMANGE', '/jsp/role/role.jsp', '2014-02-16', '1', 2),
(5, 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '菜单管理', '103', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_MENUMANGE', '/jsp/menus/menus.jsp', '2014-02-16', '1', 3),
(6, '365c7266-8c4e-4d87-8dd6-09e46832349c', '用户模块管理', '2', '0', 'A_USERMODELMANAGE', '', '2014-02-18', '1', 1),
(7, '170e9076-07df-448e-ad1a-a522756147be', '用户问题管理', '21', '365c7266-8c4e-4d87-8dd6-09e46832349c', 'A_USERQUESTIONMANAGE', '/jsp/questions/questions.jsp', '2014-02-18', '1', 0),
(8, 'c7693b2e-dea6-4aab-801f-6bc24903d801', '用户管理', '22', '365c7266-8c4e-4d87-8dd6-09e46832349c', 'A_PREUSERMANAGE', '/jsp/preUser/preUsers.jsp', '2014-02-18', '1', 0),
(9, '3916cde4-a656-4e4c-91cc-fd0ba76060c9', '产品模块管理', '3', '0', 'A_PRODUCTMANAGE', '', '2014-03-04', '1', 3),
(10, 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '类目管理', '31', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_CATEGORYMANAGE', '/jsp/category/category.jsp', '2014-03-04', '1', 2),
(11, 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '属性管理', '32', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_PROPERTYMANAGE', '/jsp/property/property.jsp', '2014-03-06', '1', 3),
(12, 'ef47dca1-b953-4455-8a0a-88027bd2b617', '类目属性管理', '33', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_CPMANAGE', '/jsp/property/categoryProperty.jsp', '2014-03-07', '1', 4),
(13, 'b4aadc9e-2777-4016-a530-8de2ec3c7de6', '属性值管理', '34', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_PROPERTYVALUEMANAGE', '/jsp/property/propertyValues.jsp', '2014-03-09', '1', 5),
(14, 'ab0a9d21-6ac0-46c8-8f3a-10d7f4d74995', '产品管理', '35', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_PRODUCTMANAGE', '/jsp/product/product.jsp', '2014-04-09', '1', 0),
(15, '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '套餐管理', '36', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_PRODUCTGROUPMANAGE', '/jsp/product/productGroup.jsp', '2014-04-13', '1', 1);

-- --------------------------------------------------------

--
-- 表的结构 `sys_model`
--

CREATE TABLE IF NOT EXISTS `sys_model` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `model_code` varchar(50) NOT NULL,
  `model_name` varchar(50) NOT NULL,
  `imgname` varchar(50) DEFAULT NULL,
  `model_title` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `sortValue` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `sys_model`
--

INSERT INTO `sys_model` (`id`, `model_code`, `model_name`, `imgname`, `model_title`, `create_date`, `status`, `sortValue`) VALUES
(1, 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '查找', 'icon-search', 'OpensearchWin', '2014-02-14', '1', 4),
(2, 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '所有', 'icon-search', 'showAll', '2014-02-13', '1', 6),
(3, 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '详情', 'icon-search', 'view', '2014-02-14', '1', 5),
(4, 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '新增', 'icon-add', 'add', '2014-02-14', '1', 1),
(5, 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '修改', 'icon-edit', 'edit', '2014-02-14', '1', 2),
(6, 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '删除', 'icon-remove', 'del', '2014-02-14', '1', 7),
(7, 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '运行', NULL, NULL, '2014-02-14', '1', 0);

-- --------------------------------------------------------

--
-- 表的结构 `sys_role`
--

CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `is_system` varchar(10) DEFAULT '0' COMMENT '否是是系统产生的，0否 1是 系统产生不能删除',
  `type` varchar(10) DEFAULT '0' COMMENT '0菜单角色 1数据角色',
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=2 ;

--
-- 转存表中的数据 `sys_role`
--

INSERT INTO `sys_role` (`id`, `role_code`, `role_name`, `description`, `is_system`, `type`, `create_date`, `status`) VALUES
(1, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '系统管理员', '系统管理员', '1', '0', '2014-02-14', '1');

-- --------------------------------------------------------

--
-- 表的结构 `sys_roles_authorities`
--

CREATE TABLE IF NOT EXISTS `sys_roles_authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `auth_code` varchar(50) NOT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=123 ;

--
-- 转存表中的数据 `sys_roles_authorities`
--

INSERT INTO `sys_roles_authorities` (`id`, `role_code`, `auth_code`, `create_date`, `status`) VALUES
(1, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'k14f35f8-2246-41h2-34f2-4cg56ad75ead  ', '2014-02-14', '1'),
(2, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'k24f35f8-2246-41h2-34f2-4cg56ad75ead', '2014-02-14', '1'),
(3, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '855a5476-0d8d-4ccd-ac64-54ab2eef1fc7', '2014-02-14', '1'),
(4, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fc9d19ee-3e51-4a1d-86b8-a043ec48b0a3', '2014-02-14', '1'),
(5, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '26439706-7e39-4f8d-89f4-4f12aa2f8bda', '2014-02-14', '1'),
(6, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '46b26d66-948f-4010-8e73-d87b99442d78', '2014-02-14', '1'),
(7, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '632f97e9-e013-48ae-8171-5d15b7106f29', '2014-02-14', '1'),
(8, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e498230e-bed9-41b4-8df4-2a96b128934a', '2014-02-14', '1'),
(9, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'h2df30b8-2df6-41d2-84f2-4cd56bb75ecc', '2014-02-15', '1'),
(10, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a3455654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1'),
(11, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bd455654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1'),
(12, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '34555654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1'),
(13, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '09895654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1'),
(14, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ijkl5654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1'),
(15, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ol055654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1'),
(16, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '33335654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1'),
(34, '2ffba9aa-af3f-4729-8826-221febc712cf', 'k14f35f8-2246-41h2-34f2-4cg56ad75ead', '2014-02-16', '1'),
(35, '2ffba9aa-af3f-4729-8826-221febc712cf', 'k24f35f8-2246-41h2-34f2-4cg56ad75ead', '2014-02-16', '1'),
(36, '2ffba9aa-af3f-4729-8826-221febc712cf', '26439706-7e39-4f8d-89f4-4f12aa2f8bda', '2014-02-16', '1'),
(37, '2ffba9aa-af3f-4729-8826-221febc712cf', '855a5476-0d8d-4ccd-ac64-54ab2eef1fc7', '2014-02-16', '1'),
(38, '2ffba9aa-af3f-4729-8826-221febc712cf', 'fc9d19ee-3e51-4a1d-86b8-a043ec48b0a3', '2014-02-16', '1'),
(39, '2ffba9aa-af3f-4729-8826-221febc712cf', '46b26d66-948f-4010-8e73-d87b99442d78', '2014-02-16', '1'),
(40, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dfdfdfdf-2343-dfdf-dfdf-234325343', '2014-02-16', '1'),
(41, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7bh87y3-f34f-dfd3er-efre-3rf3r3r', '2014-02-16', '1'),
(42, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'wgtf4t4-dgrghrg-dgfrh5r-try4hy54y', '2014-02-16', '1'),
(43, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dfdfefr4-4g4g4y-f4rt-t4-t4-t4t4t4t', '2014-02-16', '1'),
(44, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cergr0-32-r3r-34t4gt54gy-3er4gt4r', '2014-02-16', '1'),
(45, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dfdgfe4-grgrhth-34g4rht5rh5ju-f4g', '2014-02-16', '1'),
(46, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dg9jf4gt4-f4gt4gy0f4gt-f4g45h54hy', '2014-02-16', '1'),
(54, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4a65d7c4-9b87-440e-9fd6-821d0d24c916', '2014-02-16', '1'),
(55, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3a9c90a6-1ce7-4867-90ce-e08a8a12a35c', '2014-02-16', '1'),
(56, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7b39cc3c-dfbb-4c4d-a52c-d28290b01815', '2014-02-16', '1'),
(57, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '487bc775-363e-4d26-bcb1-5bf95f398ef1', '2014-02-18', '1'),
(58, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ab6fbf22-f158-4c71-bd6b-9566050122f6', '2014-02-18', '1'),
(59, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '555423be-7abd-4b8b-b5e3-1c3b9ddba4fd', '2014-02-18', '1'),
(60, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '31e17456-7f48-426e-94dc-e3eca629731f', '2014-02-18', '1'),
(61, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '43a92bde-cf19-46cb-9c65-32b3453f51bb', '2014-02-18', '1'),
(62, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '50085cee-e582-4370-9395-5a0b148b6afb', '2014-02-18', '1'),
(63, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '65ca29a2-9bcd-4496-a5ec-6ff92f68e20e', '2014-02-18', '1'),
(64, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fd8c0d74-b303-4fc4-885c-62da789dba66', '2014-02-18', '1'),
(65, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ffc8b8e6-8d72-410d-8414-8eae9a2322c1', '2014-02-18', '1'),
(66, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bf03339b-e927-4ccc-9cc3-dc16c8ef3e44', '2014-02-18', '1'),
(67, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '12af47fd-1d80-47ff-b481-22d74dafd3c5', '2014-02-18', '1'),
(68, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7e068109-1093-4763-ac05-bf4978a2938d', '2014-02-18', '1'),
(69, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ba56a7c4-13d7-449d-be25-c4822e711f6d', '2014-02-18', '1'),
(70, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '13f5f078-2e6a-4a60-9a06-a6014a8cc48c', '2014-02-18', '1'),
(71, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '38414380-a4da-4688-bb69-5675a4f88889', '2014-02-18', '1'),
(72, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '962dff78-1329-48a2-a47d-8db4398df46e', '2014-02-18', '1'),
(73, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dacda700-6f42-45fc-850a-4b61a6419e0b', '2014-02-18', '1'),
(74, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a5f3940b-0ae1-4839-b527-4f29251c3def', '2014-03-04', '1'),
(75, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '20db17fa-25c0-422c-8d61-a07042c25ed1', '2014-03-04', '1'),
(76, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cd31fa99-01cc-4585-a746-f078dc238def', '2014-03-04', '1'),
(77, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '026f9c3b-8196-496b-b554-419fc8f00567', '2014-03-04', '1'),
(78, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '666fc5d2-8031-4d3f-9793-b286b4ddb249', '2014-03-04', '1'),
(79, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '710cb246-5163-4d0a-9442-4e88b9db5d9d', '2014-03-04', '1'),
(80, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd314d14b-9942-48a1-8d61-75553dea2d6f', '2014-03-04', '1'),
(81, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f3287f28-8127-4b55-91fc-62985fe718eb', '2014-03-04', '1'),
(82, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '870da044-eb6c-4108-9eec-dcf798e9f164', '2014-03-04', '1'),
(83, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5b8fd092-4abc-4433-bc0e-f7d385e38f87', '2014-03-06', '1'),
(84, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'eae3e9d9-2343-4677-b417-733081eaf226', '2014-03-06', '1'),
(85, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'be169ed2-7837-4bfc-88df-0248e7b0bd79', '2014-03-06', '1'),
(86, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b8cff796-4664-4c44-bed9-5cf0aea0d38a', '2014-03-06', '1'),
(87, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8143832e-62d5-408f-986f-5b17f1ed5b67', '2014-03-06', '1'),
(88, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd215bf61-365a-48c8-988a-143019aa6a54', '2014-03-06', '1'),
(89, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b6765370-fdf9-4db1-95cb-f0e6383e6750', '2014-03-06', '1'),
(90, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c6631983-c3fc-44e6-b290-93c4f920fced', '2014-03-06', '1'),
(91, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3e6c81cf-d422-4574-8898-e86a3b4c4473', '2014-03-07', '1'),
(92, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4c369013-8e6e-41b7-9438-9d0ee2774b0e', '2014-03-07', '1'),
(93, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '82a79ff8-2ab7-4183-a2b2-3cd010785114', '2014-03-07', '1'),
(94, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ced6ec40-5e52-4e53-ba64-0c938833996b', '2014-03-07', '1'),
(95, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '31bf4960-da25-4304-98dd-e1baf89975cd', '2014-03-07', '1'),
(96, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9277ca06-0c5d-41a2-b5bd-ffbe17134806', '2014-03-07', '1'),
(97, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e2456be5-af0b-4517-aa9a-f6c0cf9b1197', '2014-03-07', '1'),
(98, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2e2e620a-56fe-484f-9968-76fb5e99e110', '2014-03-07', '1'),
(99, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c95b0f76-e7b6-414d-8779-9d7fa7064b27', '2014-03-09', '1'),
(100, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f9c1f807-f071-4903-9728-91b0b1f41e7e', '2014-03-09', '1'),
(101, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '65e0bfab-6204-4511-957e-35ca526cb720', '2014-03-09', '1'),
(102, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '84cb8f41-0bc3-41e0-a719-52aeb6ef2c2d', '2014-03-09', '1'),
(103, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'aa18448f-4f7b-4888-90cf-f92a3a9439c3', '2014-03-09', '1'),
(104, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6207d26c-260f-4d2e-8ac0-efe1f7a64fb2', '2014-03-09', '1'),
(105, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4f276290-4f5e-436d-a824-e9c398334824', '2014-03-09', '1'),
(106, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1f37fb56-2078-411f-8720-0da3aeaf456e', '2014-03-09', '1'),
(107, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '42649efd-2c2f-47d3-9e87-af3139db7095', '2014-04-09', '1'),
(108, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '447a47e9-4878-43ac-81a5-a424921429c9', '2014-04-09', '1'),
(109, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3459aa0a-6f12-461a-a03c-e243f6f8017c', '2014-04-09', '1'),
(110, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6f0f4854-22cc-418a-8101-c5c94701c916', '2014-04-09', '1'),
(111, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3f52fc5c-c980-4b23-8f0d-1d6e4967f8a5', '2014-04-09', '1'),
(112, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0e2c495b-4cf1-4a5d-a6aa-b7a33b0f661b', '2014-04-09', '1'),
(113, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8eaba513-795e-464f-9615-808f78bcec79', '2014-04-09', '1'),
(114, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bdfa1b70-6182-45c2-8df5-f247a9860bab', '2014-04-09', '1'),
(115, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '604b05f1-358c-4f6d-9ade-e5a16e43adbf', '2014-04-13', '1'),
(116, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7c8f0e44-af9b-4dc8-acf9-e9970d248fe9', '2014-04-13', '1'),
(117, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7960e76b-6737-437f-b445-8412dd68561c', '2014-04-13', '1'),
(118, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '849c612b-5951-427a-9a3b-682c7c6c4961', '2014-04-13', '1'),
(119, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1a123e02-8461-4c64-bb1c-7934929d5070', '2014-04-13', '1'),
(120, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4b982499-a1a4-43c3-a17e-3073c95a46c3', '2014-04-13', '1'),
(121, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '02052887-6c92-4a25-a595-c8c5230c9ccc', '2014-04-13', '1'),
(122, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2d19a0c1-5063-4fb5-a4e3-fc7083005ab9', '2014-04-13', '1');

-- --------------------------------------------------------

--
-- 表的结构 `sys_user`
--

CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL,
  `login_name` varchar(50) NOT NULL,
  `log_pwd` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_phone` varchar(50) DEFAULT NULL,
  `user_type` varchar(10) DEFAULT NULL COMMENT '用户类型,1：系统内部用户，2：商家用户，3：其他',
  `seller_code` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `sys_user`
--

INSERT INTO `sys_user` (`id`, `user_code`, `login_name`, `log_pwd`, `user_name`, `email`, `user_phone`, `user_type`, `seller_code`, `create_date`, `status`) VALUES
(1, '8532aa11-08ae-444d-bb72-801f4f9997b6', 'admin', '21232F297A57A5A743894A0E4A801FC3', '刘立立', '1149412346@qq.com', '18951106637', NULL, NULL, '2014-02-14', '1'),
(2, 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa', 'test1', '5A105E8B9D40E1329780D62EA2265D8A', '缪汉斌', '2345678@qq.com', '18914023646', NULL, NULL, '2014-02-15', '1');

-- --------------------------------------------------------

--
-- 表的结构 `sys_user_role`
--

CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL,
  `role_code` varchar(50) NOT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `sys_user_role`
--

INSERT INTO `sys_user_role` (`id`, `user_code`, `role_code`, `create_date`, `status`) VALUES
(4, '8532aa11-08ae-444d-bb72-801f4f9997b6', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2014-02-15', '1'),
(8, 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2014-02-15', '1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
