-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2014-07-21 16:26:12
-- 服务器版本： 5.6.16
-- PHP Version: 5.5.9

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
-- 表的结构 `lfyshop_memberlevel`
--

CREATE TABLE IF NOT EXISTS `lfyshop_memberlevel` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `level_code` varchar(50) DEFAULT NULL COMMENT '等级编码',
  `levelName` varchar(100) DEFAULT NULL COMMENT '等级名称',
  `levelBegin` int(11) DEFAULT NULL COMMENT '起始值',
  `levelEnd` int(11) DEFAULT NULL COMMENT '终止值',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `createPerson` varchar(255) DEFAULT NULL COMMENT '创建人',
  `status` varchar(255) DEFAULT NULL COMMENT '1 正常 0 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `lfyshop_memberlevel`
--

INSERT INTO `lfyshop_memberlevel` (`id`, `level_code`, `levelName`, `levelBegin`, `levelEnd`, `create_date`, `createPerson`, `status`) VALUES
(1, '7d4fe163-e5d9-4faf-b3a7-b77ac90e5389', '一级会员', 0, 1000, '2014-07-15 18:35:50', '刘立立', '1'),
(2, '82a93f57-4d3c-4f81-91ad-dfe8977cfb14', '二级会员', 1001, 5000, '2014-07-15 21:30:33', '刘立立', '1'),
(3, '41d7eaf5-4d5b-46ba-99d5-65f8f8fa751a', '三级会员', 5001, 10000, '2014-07-15 21:34:16', '刘立立', '1');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `lfy_citypart`
--

INSERT INTO `lfy_citypart` (`id`, `address_name`, `address_desc`, `address_parent`, `status`) VALUES
(1, '上海市', '上海', -1, '1'),
(2, '闵行区', '闵行区', 1, '1'),
(3, '浦东新区', '普通新区', 1, '1'),
(4, '徐汇区', '徐汇区', 1, '1'),
(5, '苏州市', '苏州', -1, '1'),
(6, '吴中区', '吴中区', 5, '1'),
(7, '高新区', '高新区', 5, '1'),
(8, '世纪大道', '世纪大道', 3, '1'),
(9, '闸北区', '', 1, '1'),
(10, '常州市', '常州', -1, '1'),
(11, '新北区', '新北区', 10, '1'),
(12, '长宁区', '长宁区', -1, '1');

-- --------------------------------------------------------

--
-- 表的结构 `lfy_member`
--

CREATE TABLE IF NOT EXISTS `lfy_member` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL,
  `user_type` varchar(10) DEFAULT NULL COMMENT '1.实体卡 2.网站注册 3.微信注册 4.app注册',
  `loginName` varchar(50) DEFAULT NULL,
  `loginPwd` varchar(50) DEFAULT NULL,
  `realName` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL COMMENT '1.男 0女',
  `birthday` date DEFAULT NULL,
  `card_number` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `telphone` varchar(50) DEFAULT NULL,
  `work_type` varchar(255) DEFAULT NULL,
  `family_money` varchar(255) DEFAULT NULL,
  `age_area` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `entityCardNumber` varchar(50) DEFAULT NULL COMMENT '实体卡卡号',
  `entityCardStatus` varchar(50) DEFAULT NULL,
  `memberCard_balance` int(11) DEFAULT NULL COMMENT '会员卡余额 精确到分',
  `memberCard_score` int(11) DEFAULT NULL COMMENT '会员卡总积分',
  `create_date` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL COMMENT '1正常 0删除 2拉黑',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `regDate` datetime DEFAULT NULL COMMENT '注册日期',
  `DateStart` datetime DEFAULT NULL COMMENT '生效日期',
  `DateEnd` datetime DEFAULT NULL COMMENT '过期日期',
  `PriceMode` varchar(255) DEFAULT NULL COMMENT '折扣模式',
  `PriceList` int(11) DEFAULT NULL COMMENT '价格清单',
  `shpEntry` int(11) DEFAULT NULL COMMENT '发卡店铺编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `lfy_member`
--

INSERT INTO `lfy_member` (`id`, `user_code`, `user_type`, `loginName`, `loginPwd`, `realName`, `sex`, `birthday`, `card_number`, `city`, `telphone`, `work_type`, `family_money`, `age_area`, `email`, `entityCardNumber`, `entityCardStatus`, `memberCard_balance`, `memberCard_score`, `create_date`, `status`, `age`, `regDate`, `DateStart`, `DateEnd`, `PriceMode`, `PriceList`, `shpEntry`) VALUES
(2, '1399474476189722', '2', '18951106637', 'E10ADC3949BA59ABBE56E057F20F883E', '缪汉斌', '1', '1982-02-03', NULL, '重庆', '18951106637', NULL, NULL, NULL, '1149412346@qq.com', NULL, NULL, 0, 0, '2014-05-07 22:54:36', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, '1399907314774933', '2', '18914023646', '96E79218965EB72C92A549DD5A330112', '张小美', '0', '2014-05-02', NULL, '上海', '18914023646', '物流/仓储', '5000-10000', '70后', '1149412346@qq.com', NULL, '2', 0, 0, '2014-05-12 23:08:34', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, '1399907675367683', '2', '18068338576', '96E79218965EB72C92A549DD5A330112', '赵莉', '0', '1984-04-21', NULL, '上海', '18068338576', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, '2014-05-12 23:14:35', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, '1399907742766384', '2', '18068338575', '7FA8282AD93047A4D6FE6111C93B308A', '李小雨', '1', '1990-06-20', NULL, '苏州', '18068338575', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, '2014-05-12 23:16:19', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, '1399908089387694', '2', '18068338571', '96E79218965EB72C92A549DD5A330112', '张晓卿', '1', '1988-02-10', NULL, '上海', '18068338571', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, '2014-05-12 23:21:33', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, '1399996157763131', '2', '18951106636', '96E79218965EB72C92A549DD5A330112', '张俞', '0', '1991-10-20', NULL, '上海', '18951106636', NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, '2014-05-13 23:49:17', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, '1400766758626930', '2', '18964187252', '96E79218965EB72C92A549DD5A330112', '何锋', '1', '1984-12-20', NULL, '上海', '18964187252', '艺术/设计', '10000-20000', '80后', 'asdf@32.com', '', '1', 0, 0, '2014-05-22 21:52:38', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, '1400768532269179', '2', '18951106666', '96E79218965EB72C92A549DD5A330112', '肖山', '1', '1993-09-25', NULL, '上海', '18951106666', '行政/后勤', '3000-5000', '90后', 'aaaa@qq.com', '23134134', '2', 0, 0, '2014-05-22 22:22:12', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'd59238ae-7e50-414d-86c4-218c6c89fc57', '4', '15362537465', 'E10ADC3949BA59ABBE56E057F20F883E', '小明', '1', '1980-06-17', '324545234524323', '上海市', '15362537465', '计算机软件', '5000-10000', '80后', '23424@32.com', '', '1', 0, 0, '2014-06-08 13:26:25', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'c9272357-4b64-4545-8670-57c07a773a30', '4', '18544395540', 'E10ADC3949BA59ABBE56E057F20F883E', '周瑜', '1', '1987-06-18', '7897983724987298347', '上海市', '18544395540', '公务员', '5000-10000', '80后', 'zhouyu@sina.com', '', '2', 0, 0, '2014-06-11 14:55:04', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, '2dd2c0c1-e9c1-4844-b4a9-0f79acc72156', '4', '18933428394', 'E10ADC3949BA59ABBE56E057F20F883E', '张锋', '1', '1992-06-17', '23424234234324', '上海市', '18933428394', '在校学生', '1000-3000', '90后', 'zhangfeng@32.com', '', '1', 0, 0, '2014-06-11 15:13:58', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
  `bmaps_info` varchar(200) DEFAULT NULL,
  `available_shops` varchar(500) DEFAULT NULL COMMENT '周边配送符合配送条件的门店编号(Null表示无门店可以配送,有多家门店可以外送存入JSON对象{"n1":"门店编号","n2":"门店编号"})',
  `create_date` date DEFAULT NULL,
  `is_default` varchar(10) DEFAULT NULL COMMENT '是否是默认(0 不是 1 是)',
  `status` varchar(255) DEFAULT NULL COMMENT '状态(1 正常 0 被删除 )',
  `is_available` varchar(10) DEFAULT '0' COMMENT '是否可以配送 1可以 0不可以',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=15 ;

--
-- 转存表中的数据 `lfy_member_address`
--

INSERT INTO `lfy_member_address` (`id`, `address_code`, `user_code`, `city`, `area`, `address_keywords`, `gps_long`, `gps_lat`, `bmaps_info`, `available_shops`, `create_date`, `is_default`, `status`, `is_available`) VALUES
(1, '1399907675408111', '1399907314774933', '上海', '徐汇区', '金桥路', NULL, NULL, NULL, NULL, '2014-05-12', '0', '0', '0'),
(2, '1399907675408193', '1399907314774933', '上海', '嘉定区', '金桥路', NULL, NULL, NULL, NULL, '2014-05-12', '0', '0', '0'),
(3, '1399907779123834', '1399907314774933', '苏州', '吴中区', '金桥路', NULL, NULL, NULL, NULL, '2014-05-12', '0', '0', '0'),
(4, '1399908093233388', '1399907314774933', '苏州', '高新区', '苏州科技学院天平校区', NULL, NULL, NULL, NULL, '2014-05-12', '0', '1', '1'),
(5, '1399996157864719', '1399907314774933', '上海', '闵行区', '金桥路123号', '121.575676', '31.274332', NULL, '[{\n   "storecode" :"020199",\n   "storename" :"沧源路店"\n}]', '2014-05-13', '0', '1', '1'),
(7, '1400158053008551', '1399907314774933', '上海', '闵行区', '爱博家园1100号', NULL, NULL, NULL, NULL, '2014-05-15', '0', '1', '0'),
(8, '1400603986277329', '1399907314774933', '上海', '浦东新区', '金桥路1155弄', NULL, NULL, NULL, NULL, '2014-05-21', '0', '1', '0'),
(9, '1400766758715858', '1400766758626930', '上海', '浦东新区', '金桥路1055弄', NULL, NULL, NULL, NULL, '2014-05-22', '1', '1', '0'),
(10, '1400768532310591', '1400768532269179', '上海', '徐汇区', '漕河泾开发区', NULL, NULL, NULL, NULL, '2014-05-22', '1', '1', '0'),
(11, '1400938512401413', '1399907314774933', '上海市', '闵行区', '九亭镇绿庭尚城', '121.321144', '31.152279', NULL, '[{\n   "storecode" :"020199",\n   "storename" :"沧源路店"\n}]', '2014-05-24', '1', '1', '1'),
(12, 'fca6d3c8-b1b7-4321-a4ff-203101d388d8', 'd59238ae-7e50-414d-86c4-218c6c89fc57', '上海市', NULL, '上海市联航路1588号', NULL, NULL, NULL, NULL, '2014-06-08', '1', '1', '0'),
(13, '43ee065f-85d7-4ef1-bb04-20ee796fa73b', 'c9272357-4b64-4545-8670-57c07a773a30', '上海市', '闸北区', '上海市闸北区延长中路快乐家苑', '121.45785', '31.276382', NULL, '[{\n   "storecode" :"10191",\n   "storename" :"延长中路2店"\n}, {\n   "storecode" :"020119",\n   "storename" :"平型关路店"\n}]', '2014-06-11', '1', '1', '1'),
(14, '5689c384-35a8-4048-b1c5-0a625ebba87a', '2dd2c0c1-e9c1-4844-b4a9-0f79acc72156', '上海市', '长宁区', '上海市长宁区仙霞西路500弄', '121.3706', '31.214626', NULL, NULL, '2014-06-11', '1', '1', '0');

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
  `delivery` varchar(10) DEFAULT NULL COMMENT '2外送 1自取',
  `storeCode` varchar(50) DEFAULT NULL COMMENT '当delivery为1 storeCode必填',
  `addressCode` varchar(50) DEFAULT NULL,
  `pickUpTime` datetime DEFAULT NULL COMMENT '当delivery为1 pickUpTime必填',
  `user_tel` varchar(20) DEFAULT NULL COMMENT '用户联系电话 当delivery为2时必填',
  `orderStatus` varchar(255) DEFAULT NULL COMMENT '订单状态 1待支付 2已支付 3已关闭',
  `create_date` datetime DEFAULT NULL,
  `orderPayType` varchar(255) DEFAULT NULL COMMENT '1.网上支付 2货到现金支付',
  `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
  `userCode` varchar(255) DEFAULT NULL COMMENT '订单用户',
  `status` varchar(255) DEFAULT NULL COMMENT '状态 1正常 0删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=31 ;

--
-- 转存表中的数据 `lfy_order`
--

INSERT INTO `lfy_order` (`id`, `orderNo`, `orderMoney`, `orderTotalMoney`, `couponMoney`, `delivery`, `storeCode`, `addressCode`, `pickUpTime`, `user_tel`, `orderStatus`, `create_date`, `orderPayType`, `pay_date`, `userCode`, `status`) VALUES
(1, '13976607597263', 500, 500, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:05:59', '1', NULL, '3333333333333333', '1'),
(2, '13976608425400', 0, 0, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:07:22', '1', NULL, '3333333333333333', '1'),
(3, '13976610231383', 0, 0, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:10:23', '1', NULL, '3333333333333333', '1'),
(4, '13976610465180', 0, 0, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:10:46', '1', NULL, '3333333333333333', '1'),
(5, '13976612436762', 0, 0, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:14:03', '1', NULL, '3333333333333333', '1'),
(6, '13976615755981', 15800, 15800, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:19:35', '1', NULL, '3333333333333333', '1'),
(7, '13976615912960', 4500, 4500, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:19:51', '1', NULL, '3333333333333333', '1'),
(8, '13976616809133', 13500, 13500, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:21:20', '1', NULL, '3333333333333333', '1'),
(9, '13976617168832', 41700, 41700, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:21:56', '1', NULL, '3333333333333333', '1'),
(10, '13976620297835', 500, 500, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-16 23:27:09', '1', NULL, '3333333333333333', '1'),
(11, '13979096097694', 14600, 14600, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-19 20:13:29', '1', NULL, '3333333333333333', '1'),
(12, '13979096779361', 0, 0, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-04-19 20:14:37', '1', NULL, '3333333333333333', '1'),
(13, '1399553642274410', 1000, 1000, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-08 20:54:02', '1', NULL, '3333333333333333', '1'),
(14, '1399553726318472', 500, 500, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-08 20:55:26', '1', NULL, '3333333333333333', '1'),
(15, '1399559570436878', 4500, 4500, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-08 22:32:50', '1', NULL, '3333333333333333', '1'),
(16, '1399560912343527', 11700, 11700, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-08 22:55:12', '1', NULL, '3333333333333333', '1'),
(17, '1399789206753167', 23000, 23000, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-11 14:20:06', '1', NULL, '3333333333333333', '1'),
(18, '1399789860964142', 18000, 18000, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-11 14:31:00', '1', NULL, '3333333333333333', '1'),
(20, '1400166066973628', 53400, 53400, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-15 23:01:06', '1', NULL, '3333333333333333', '1'),
(21, '1400166172628291', 56800, 56800, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-15 23:02:52', '1', NULL, '3333333333333333', '1'),
(22, '1400167281163387', 40500, 40500, 0, NULL, NULL, NULL, NULL, NULL, '1', '2014-05-15 23:21:21', '1', NULL, '3333333333333333', '1'),
(23, '1401710023061491', 3400, 3400, 0, '2', NULL, '1399908093233388', NULL, '18914023646', '1', '2014-06-02 19:53:43', '2', NULL, '1399907314774933', '1'),
(24, '1401710082011178', 3400, 3400, 0, '1', '1234567', NULL, '2014-06-02 00:00:00', NULL, '1', '2014-06-02 19:54:42', '2', NULL, '1399907314774933', '1'),
(25, '1401712394051397', 3400, 3400, 0, '2', NULL, '1399908093233388', '2014-06-02 21:03:14', '18914023646', '1', '2014-06-02 20:33:14', '2', NULL, '1399907314774933', '1'),
(26, '1401712613114483', 3400, 3400, 0, '2', NULL, '1399908093233388', NULL, '18914023646', '1', '2014-06-02 20:36:53', '2', NULL, '1399907314774933', '1'),
(27, '1401712675360332', 3400, 3400, 0, '1', '2134567', NULL, '2014-06-02 20:50:00', '18914023646', '1', '2014-06-02 20:37:55', '2', NULL, '1399907314774933', '1'),
(28, '1401893490204286', 16300, 16300, 0, '2', NULL, '1399908093233388', NULL, '18914023646', '1', '2014-06-04 22:51:30', '2', NULL, '1399907314774933', '1'),
(29, '1401893664474409', 3900, 3900, 0, '1', '2134567', NULL, '2014-06-04 00:00:00', '18914023646', '1', '2014-06-04 22:54:24', '2', NULL, '1399907314774933', '1'),
(30, '1401895085533555', 7900, 7900, 0, '2', NULL, '1399908093233388', NULL, '18914023646', '1', '2014-06-04 23:18:05', '2', NULL, '1399907314774933', '1');

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
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=51 ;

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
(37, '1400167281163387', '13974778184495', '丰盛比萨套餐', 4500, 9, '1'),
(38, '1401710023061491', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(39, '1401710082011178', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(40, '1401712394051397', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(41, '1401712613114483', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(42, '1401712675360332', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(43, '1401893490204286', '13974778184495', '丰盛比萨套餐', 4500, 1, '1'),
(44, '1401893490204286', '13974777838911', '板栗炖鸡饭', 3400, 2, '1'),
(45, '1401893490204286', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(46, '1401893490204286', '13974777436875', '德式盐烤猪肘比萨', 4500, 1, '1'),
(47, '1401893664474409', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(48, '1401893664474409', '13974777092814', '鲜肉酥饼(1只装)', 500, 1, '1'),
(49, '1401895085533555', '13974777838911', '板栗炖鸡饭', 3400, 1, '1'),
(50, '1401895085533555', '13974778184495', '丰盛比萨套餐', 4500, 1, '1');

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
-- 表的结构 `lfy_store_address`
--

CREATE TABLE IF NOT EXISTS `lfy_store_address` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `store_code` varchar(100) NOT NULL COMMENT '门店编号',
  `store_name` varchar(100) NOT NULL COMMENT '门店名称',
  `manage_type` varchar(100) NOT NULL COMMENT '经营类型',
  `store_type` varchar(100) NOT NULL COMMENT '店铺类型',
  `depart_own` varchar(100) NOT NULL COMMENT '所属部门',
  `area` varchar(100) NOT NULL COMMENT '所属大区',
  `province` varchar(100) NOT NULL COMMENT '省份',
  `city` varchar(100) NOT NULL COMMENT '城市',
  `city_part` varchar(100) NOT NULL COMMENT '城区',
  `city_id` int(10) NOT NULL COMMENT '城市id',
  `store_address` varchar(100) NOT NULL COMMENT '门店地址',
  `store_director` varchar(100) DEFAULT NULL COMMENT '主管姓名',
  `store_directorphone` varchar(100) DEFAULT NULL COMMENT '主管电话',
  `store_assistant` varchar(100) DEFAULT NULL COMMENT '店员姓名',
  `store_assistantphone` varchar(100) DEFAULT NULL COMMENT '店员电话',
  `gps_lng` varchar(100) NOT NULL COMMENT '经度',
  `gps_lat` varchar(100) NOT NULL COMMENT '纬度',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(10) DEFAULT NULL,
  `empDutyID` varchar(255) DEFAULT NULL COMMENT '大区经理工号',
  `empID` varchar(255) DEFAULT NULL COMMENT '片区主管工号',
  `Payment` varchar(255) DEFAULT NULL COMMENT '收银方式',
  `StartDate` datetime DEFAULT NULL COMMENT '开店日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `lfy_store_address`
--

INSERT INTO `lfy_store_address` (`id`, `store_code`, `store_name`, `manage_type`, `store_type`, `depart_own`, `area`, `province`, `city`, `city_part`, `city_id`, `store_address`, `store_director`, `store_directorphone`, `store_assistant`, `store_assistantphone`, `gps_lng`, `gps_lat`, `create_date`, `status`, `empDutyID`, `empID`, `Payment`, `StartDate`) VALUES
(1, '020083', '凯旋路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '徐汇区', 4, '上海徐汇区凯旋路1451号', '主管名', '18701756005', '张晨', '18701800787', '121.42744617251', '31.202383576095', '2014-06-09 21:48:59', '1', NULL, NULL, NULL, NULL),
(2, '020079', '罗秀路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '徐汇区', 4, '上海徐汇区长桥镇罗秀路258号', '主管名', '64761650', '罗建强', '13817046975', '121.45160839224', '31.139963420445', '2014-06-09 21:51:47', '1', NULL, NULL, NULL, NULL),
(3, '020199', '沧源路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '闵行区', 2, '上海市闵行沧源路781号', '主管名', '15800672908', '党闯', '15800672908', '121.43526677773', '31.020861008409', '2014-06-09 21:54:20', '1', NULL, NULL, NULL, NULL),
(4, '020314', '仙霞西路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '长宁区', 12, '上海市长宁区仙霞西路87号', '主管名', '13524034382', '吴桂玲', '18217565463', '121.37401123517', '31.213989930474', '2014-06-09 21:57:09', '1', NULL, NULL, NULL, NULL),
(5, '020607', '虹鑫广场', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '长宁区', 12, '上海市长宁区天山路762号', '主管名', '15052820887', '蒋传金', '13321968293', '121.40851227523', '31.217520882513 ', '2014-06-09 21:58:53', '1', NULL, NULL, NULL, NULL),
(6, '020011', '北渔路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '长宁区', 12, '上海长宁区北渔路84号', '主管名', '52179100', '马立霞', '13681800544', '121.37919212237', '31.221748538479 ', '2014-06-09 22:00:46', '1', NULL, NULL, NULL, NULL),
(7, '10191', '延长中路2店', '直营', '商社型', '营运', '华东', '上海市', '上海市', '闸北区', 9, '上海市闸北区延长中路453号', '主管名', '18221463733', '王建琴', '15000460869', '121.45848932262', '31.27662116549 ', '2014-06-09 22:04:07', '1', NULL, NULL, NULL, NULL),
(8, '020119', '平型关路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '闸北区', 9, '上海闸北平型关路577号', '主管名', '13818518984', '张应增', '13816819797', '121.46783870671', '31.280707117986 ', '2014-06-09 22:07:22', '1', NULL, NULL, NULL, NULL);


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
  `typeName` char(30) DEFAULT NULL COMMENT '投书类型名称',
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
  `typeCode`  varchar(50) DEFAULT NULL COMMENT '随机数编码',
  `userCode` varchar(50) NOT NULL COMMENT '会员编码，谁投诉了',
  `complainContent` char(500) DEFAULT NULL COMMENT '投诉内容',
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
  `smsContent` char(500) DEFAULT NULL COMMENT '短信内容',
  `createDate` datetime DEFAULT NULL COMMENT '设置时间',
  `createPerson` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `status` varchar(50) DEFAULT NULL COMMENT '0表示 删除 1 表示正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

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


-- --------------------------------------------------------
--  积分模块表格 crm_ 开头

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



-- =========================================================
-- --------------------------------------------------------
-- 测试表格

--
-- 表的结构 `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `firstName` char(30) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(50) DEFAULT NULL,
  `streetAddress` varchar(50) DEFAULT NULL,
  `postalCode` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- 转存表中的数据 `person`
--

INSERT INTO `person` (`id`, `version`, `firstName`, `lastName`, `email`, `phoneNumber`, `streetAddress`, `postalCode`, `city`) VALUES
(1, 11, '刘', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '北京'),
(2, 11, '王', '小宝', 'wangb@32.com', '15099239948', '北京市朝阳区xx路132号', '11092', '北京'),
(3, 11, '李', '鹏飞', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '苏州'),
(4, 11, '章', '东东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '武汉'),
(5, 11, '张', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '南京'),
(6, 11, '张', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '郑州'),
(7, 11, '杨', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '杭州'),
(8, 11, '柳', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '襄阳'),
(9, 11, '余', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '宜昌'),
(10, 11, '郑', '杰', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '保定'),
(11, 11, '钱', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '哈尔滨'),
(12, 11, '陈', '钱', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '大连'),
(13, 11, '黎', '东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '青岛'),
(14, 11, '田', '亮', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '扬州'),
(15, 11, '孙', '源', '88736222@qq.com', '1893254473', '上海市黄浦区河南路329号', '11092', '上海'),
(16, 11, '董', '嫣嫣', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '广州'),
(17, 11, '赵', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '深圳'),
(18, 11, '朱', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '南昌'),
(19, 11, '邹', '强东', 'liu@32.com', '18933726648', '北京市海淀区中山路113号', '11092', '昆明');

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
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=961 ;

--
-- 转存表中的数据 `sys_authorities`
--

INSERT INTO `sys_authorities` (`id`, `auth_code`, `is_menu`, `model_code`, `menu_code`, `create_date`, `status`) VALUES
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
(99, '2d19a0c1-5063-4fb5-a4e3-fc7083005ab9', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '35e0a2eb-ede5-4a35-94c1-365fe3f1e16d', '2014-04-13', '1'),
(132, '484df61b-c417-40c0-9b3f-cd580153e4a9', '0', '0', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(133, '53383002-ccb8-40b6-a3ce-9fb91aad31a6', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(134, '193f230a-aa7b-4e98-8232-a4a064388714', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(135, '0c812621-f207-40a3-b878-129cb6f69526', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(136, '4e6651c6-0eaa-4871-af42-4967773b75e6', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(137, 'f4203876-dd59-488f-aca5-dcbe62da0b02', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(138, 'dd352572-3885-4abc-a035-29576638a8e1', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(139, 'a2df42f2-086b-4bcc-9292-5920eb4c585e', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '67177641-4931-4dd2-ad6c-ef039cbfb86d', '2014-06-12', '1'),
(500, 'e7b98c38-0709-46e4-bf24-671ad70e9641', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', '2014-06-12', '1'),
(501, '92ad4c87-3f31-4a14-a42d-fd628c93e99a', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(502, '185f0b6a-513f-4b21-935d-3a21cb93a918', '0', '0', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(503, '2fa171ef-ced6-4578-a9b2-bb0dc9f42cef', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(504, '68e91e33-afd7-4b67-903c-e69413439f85', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(505, 'a7e6e71d-49e8-474e-be37-2e9f791dd8ab', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(506, 'a764812f-e52c-4884-b8bf-58b724b1934e', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(507, 'b3b1b421-9329-4f74-9502-36e8dfe45e04', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(508, 'f2de900b-3d31-4075-8d2f-85ff440d7db2', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(509, '69bcf67d-9fc9-4ab3-81f4-8ebefa7e6d8a', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(510, 'e6a5607f-50c5-487d-a89e-bddc5e60c66c', '0', '0', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(511, '697bfdc8-529a-46cd-aef2-18d6a2a5eba3', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(512, '16045136-7140-4920-8485-ae9288cbea28', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(513, '8b2f5b0f-97d1-473f-9684-8c3e190b40bb', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(514, '676ce443-699a-46ea-8b91-220eec994d47', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(515, '58a710f7-fcf8-4df2-8037-fc9d24382acb', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(516, 'b6fd798b-2823-42ad-b921-16a74ceb1c46', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(517, '6df9fc0b-8ed6-4f09-96f2-4c1f5bc927d3', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-06-12', '1'),
(518, 'e734e5ac-148b-41a1-bf90-c5740c5284fb', '0', '0', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(519, 'ea72bedc-bc44-47d2-8d7f-2224ff415fdb', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(520, '2134cd4b-17bf-412b-b7da-cb01f023573b', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(521, '8097d258-1ba4-4c8b-8703-28136b02f186', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(522, 'c5a333c4-8891-401d-8ebe-471420c7b1ea', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(523, '01448d27-a59c-4a6d-a034-b89c4ea2e626', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(524, '7b43bab4-d378-40c2-acdf-6e7a35383fb0', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(525, 'fa92c519-b777-4b2a-b53f-47aa903d3e91', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-06-12', '1'),
(526, '764546f3-a1b8-4f52-9a7b-99ae84802183', '0', '0', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(527, 'bff4a8ed-dd26-4182-8b29-32fbff48ff7a', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(528, '30c81dd6-bf83-4c18-b970-495adbad5dbf', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(529, '23d52797-6b53-4dae-9bab-f63f35269bc5', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(530, '17ede6d5-4ecc-4ba8-aa7e-b6c466378dac', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(531, '6801cb85-a07c-408e-83ab-db63adcd50f2', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(532, '2cb33ec3-95d4-4b44-abfe-ef3e11670e43', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(533, '00b32538-08b0-4115-8d9e-7c8635e02998', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '0b47540b-cbd8-453d-93f9-60f3365e200e', '2014-06-12', '1'),
(534, 'daacaa7a-7e25-4df2-986f-2daf409ebc03', '0', '0', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(535, 'bebcb1f9-fa2e-47cf-9256-3fa78b64cb3f', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(536, 'a7195f98-78a8-4bc8-a11c-84a4e66d8c50', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(537, 'bd4ad8b3-2298-447b-ba97-c601155401f6', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(538, '56d9f756-3f4b-492b-93f5-e2fe280db9d1', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(539, 'bc1264b3-2286-470e-9a9e-28d4cf4c542d', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(540, '443c47c0-8d21-4de4-b62c-f33e955e35e0', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(541, '62c88082-d5c9-4531-9cd3-98ba7e105d15', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '3992e26c-1409-48ae-909d-9315a365c960', '2014-06-12', '1'),
(542, '8b370dd6-c969-448f-90b3-aab4734066de', '0', '0', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(543, '0503b823-5a9d-4113-a13d-3d8e3658e346', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(544, 'd3eb40ef-d2c7-4ffd-a929-ad3bfa85278b', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(545, '347dbb13-bdd6-41e3-bbd5-08349bdbe237', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(546, '93946193-8b9f-40dd-96ce-f7c4bf2943e0', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(547, 'b6637bba-fb4d-442a-a63e-a60c705a247c', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(548, '9ebac23b-c613-49a5-8b68-d442a3df70a4', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(549, 'de0b6803-de19-441b-ae44-7fc130fd9bb5', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '2014-06-12', '1'),
(550, 'f15a7c77-1f46-4fca-9174-be431d61bba9', '0', '0', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(551, '51657646-0e42-44a2-aea9-b448f5e66db7', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(552, 'ea4b8f90-3229-4040-a4fc-c938a9438a5e', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(553, 'c39b9fe9-dac8-4f87-b147-2016e531a4a5', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(554, '92a70ec4-939c-4b0b-b0f0-b78f95b0a197', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(555, '9dd03429-04f8-4733-a909-ecd019ab68ea', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(556, 'a5da800b-e506-40f0-b46a-6738223236b3', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(557, '3a9b5b1a-26e3-4ad9-8b45-c1610f0b6dbe', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '2014-06-12', '1'),
(558, 'fa1d0b9e-ad7f-4277-8a83-341e1d9403bb', '0', '0', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(559, '80467c4f-0f91-4685-a2fa-4d9ca0d5c5e5', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(560, '410a1164-f879-47ea-8ede-7cf5e934bfb1', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(561, '00b5520c-367c-4c7f-a061-827ac5f409fd', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(562, '797c358f-1d50-43ea-88c7-b334115c97c4', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(563, '21c7eefc-e3d0-4755-ad96-cb56714e6f5f', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(564, '906ed241-a2fb-42e8-9c33-5619faea6791', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(565, '58aabed1-3201-446d-be1f-f11ddef0e51d', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '2014-06-12', '1'),
(566, '50929c0d-04d3-4e92-8976-3a74bff05608', '0', '0', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(567, '6dbc2cc9-ad86-4628-ad4a-5199304a32e0', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(568, 'e8784dcd-70ac-4e48-9942-73560096b980', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(569, 'ebeffd8e-0a5f-4348-8906-ae67ff7b4aa7', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(570, '6baa9909-2ca1-4bab-8e6a-bcdc38e2b826', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(571, 'a47e68a0-b032-4430-a455-46994f176453', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(572, '43aa41fd-ba89-40d0-b0bc-ab3b5cd35e5a', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(573, '54189914-27aa-4dce-8233-4cd5151e7cf1', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '2014-06-12', '1'),
(574, '3b66afc3-1f7f-41c0-abd9-0280e0846bb2', '0', '0', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(575, '03274edf-ae2a-4bcb-86d8-ee8d8c9ff947', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(576, '599eb9bd-a512-46c8-9dad-21f52781eaef', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(577, '314786a3-141e-4a2c-ae2b-6a485ebb8544', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(578, '34942a82-dc35-4f36-8381-93f5ef2ae8d1', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(579, '75dd73e2-55d5-4d2d-9a81-c271c96677c5', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(580, 'b95b3665-58e6-4afd-98a6-e8ba7cbe4a0c', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(581, '08612477-0a5a-4ec7-854d-84be74fefb64', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '2014-06-12', '1'),
(582, 'bcbbb89e-19d4-4439-b742-43110e61393c', '0', '0', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(583, '469ff074-8312-44a8-80a9-e5d36807ee02', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(584, 'ce64c314-0978-4b0f-9d29-1a30ef4ee337', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(585, 'a729b222-136a-46b6-a1bb-695675c8bf95', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(586, '91629999-e80c-4267-b378-5bee20537249', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(587, 'cfc97c3e-4276-4691-9d01-e7be48d66cb4', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(588, '093387ae-9117-4c5c-bca8-b4a6b910233c', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(589, 'c6cae329-3e2f-4011-bc3a-e011cf06b226', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '5b8e5342-5ef2-4e6c-9044-478ea042532d', '2014-06-12', '1'),
(590, 'f51eb7c0-e350-46b1-8f9f-c7f8f6406183', '0', '0', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(591, 'e428bccb-42aa-4b46-8a26-3ee094758967', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(592, 'b8289227-bc16-40a6-bfab-a85f5e95b158', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(593, '459c1122-3d27-419f-911f-827ccb444ee6', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(594, 'c318f266-9dca-4a62-ae4a-1438eef50fe8', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(595, '1815ac3c-99c0-4425-9d24-1a0c06cdaca1', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(596, 'b3a92d50-b803-44a1-8642-e8e2759c6f5e', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(597, '62db04ee-cc0b-4506-8f05-9ba056a493fb', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '2014-06-12', '1'),
(598, 'b0f592e4-6189-41dd-ba89-e23ea229e45a', '0', '0', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(599, '20628678-7f7c-434a-a804-19133c1a18ee', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(600, 'a485a1f8-6644-4f23-8286-53989069e381', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(601, '7df33a00-fd6b-4fd5-9e28-dfe7e9edda2b', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(602, 'c0f015cb-2b00-41f6-87ee-6f3d7667e642', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(603, '6c872bfe-ad38-44f0-bfd1-21ee8e7c3248', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(604, '85da3690-2da5-4463-a0d2-59395cab270d', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(605, '47a509a0-8b69-447a-af70-eda282bba6a2', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'c51a6ee9-2733-485a-b938-a19510db2baa', '2014-06-12', '1'),
(606, '0d8a202f-c42e-4f49-be20-6c8995e7e4a9', '0', '0', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(607, 'b96bd0ed-70a7-4d5d-a506-0eeb50e6292d', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(608, '91c6aea8-3289-4cd1-8c74-3d9a06bc1863', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(609, '68c082ed-d86a-4841-bbb7-5dd04c3a48cd', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(610, '22c3950d-8387-48fd-9591-7c0e5eee5c1d', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(611, '99a8776a-b0ae-4404-8c10-72fb724e54c0', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(612, 'e0b609f3-fdfe-4776-a027-9829ec80fb4d', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(613, '814dfcd1-5b99-41e5-9abf-101d96e9f0e3', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '2014-06-12', '1'),
(614, '3aa0de2b-d9b1-478a-8b90-bec5bc3cd4f5', '0', '0', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(615, 'd2798c92-9dca-4e26-8136-4f0f89c1efcc', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(616, '55552230-3f2a-411d-a890-b3ac14737828', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(617, 'd121c573-5342-43ac-80b4-3bf41b320cb2', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(618, '7bdac04d-e506-4416-b4ea-0ab1b9d5bc8d', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(619, '1b558127-b367-4ab1-a3a4-0d39608b85a7', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(620, 'a860921c-3f25-4391-b3b1-1a966f55b2b4', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(621, 'af5aba57-768e-466e-8926-06d16960f18a', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '2014-06-12', '1'),
(622, 'd176ba28-c6b3-4d09-8275-3b8eb20327b7', '0', '0', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(623, '86ae14ad-0fa6-4ff4-ae5b-a764b21a1f86', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(624, 'de1f2b3a-3c84-4fec-ac64-2af02333545b', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(625, 'a69747d1-dd95-487e-bc5a-f9b81dee11cb', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(626, '827a1ba3-5f84-4671-8632-e3062d2a1bcf', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(627, '61e7c471-db09-479f-8ab8-f3f7a42b99c6', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(628, '9e0205d1-e257-470d-93e0-4f30f51251c7', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(629, '5ae66193-2721-4b75-9974-59ec31638b63', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '8404bc74-6c68-462f-9f1a-98624ec32885', '2014-06-12', '1'),
(630, '2962849f-fc4b-461d-bd00-1e1b0b22abc2', '0', '0', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(631, '65f287cf-65a6-46fc-9c92-7672b5e37ebe', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(632, 'f02452b2-9958-445e-a67d-15cb309bc007', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(633, 'cc8ebe6e-50c4-444c-af3e-6db90e6f30f8', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(634, 'c3b4d98f-c8af-435c-a1a6-8aca914ec3f9', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(635, '1954e720-a219-47be-a772-d3ca7ac79071', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(636, 'de767f41-6e20-4f6f-b27f-c34416dfcc7a', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(637, '80f22979-838e-45ea-8abf-8b82c4141a7e', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '2014-06-12', '1'),
(638, '62a1a02f-9154-4202-aa73-ade08a019110', '0', '0', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(639, 'a1624c0e-f5e5-49c6-b746-1b5b973f21ff', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(640, 'dacb94af-499d-4840-8905-09f7974b7123', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(641, '565c1a6e-5ad3-4be0-a515-1ffea37be35b', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(642, '21204683-0c80-4fd8-8f7c-c2410cd312f5', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(643, '6bd0fc24-af0e-4f01-9f01-39f207182cee', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(644, '6b295988-55ed-4b32-b43f-f909d547af18', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(645, '8861b536-e6bb-4f36-bdbd-95b99fa0e297', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '2014-06-12', '1'),
(646, 'db905542-c4ce-4536-9aef-652959c8e11b', '0', '0', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(647, 'd941188d-eea9-4ab3-9554-cefe71c63e12', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(648, 'c1e5c410-6229-43a4-b653-d9df2ccb5d89', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(649, '1109551a-2a2a-46c4-880c-b35d448a3244', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(650, '8ff8bdda-3024-4796-9c8c-2d0f72940e7a', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(651, '5580975b-9333-4386-a56c-4501f479aa37', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(652, 'fac0ae9d-ab68-4265-8c29-727926bdb0c4', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(653, '4a38d0e1-9c85-4331-bbdc-fd44eff5070d', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '2014-06-12', '1'),
(654, '76ab4f56-1cd5-46ca-bebe-3ce056ac8f60', '0', '0', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(655, 'e07de94e-0745-4d30-8bc8-5f02e1c58d72', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(656, 'c179bfff-ae56-480b-b72e-5f0c37f02d8f', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(657, 'fbb60e30-cc2e-4578-889e-2b9feba90e7a', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(658, '94c31f49-2c1e-447c-8d96-925bf9b014c4', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(659, '219bec3a-3937-4840-9502-6c05a375c5da', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(660, 'be66221f-7d70-4903-a40e-d3973e787ad3', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(661, '0eed2922-8564-413a-ae12-527813c9ae4c', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '2014-06-12', '1'),
(662, 'ab932cc8-3e90-4477-851c-e0ae39e99f53', '0', '0', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(663, '6f20b79b-9bf0-4e6c-9779-5e8d62f7c5de', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(664, 'c90da18a-195e-4e8b-992f-de2dbeac8d20', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(665, 'ae53617e-fbab-40ff-a304-bf34bab784f8', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(666, 'fdcc8d2b-8ba6-4c88-a903-fd362b5de3a9', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(667, '2bc5e878-e991-41b7-9861-f95d13a66fac', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(668, '62cd09cd-f280-49b1-8f0f-ca4ed0c7d668', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(669, '64277fcf-0219-4282-ba81-d89a3e5d0af8', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '539a3604-1035-4eb3-9e6b-44af5c325bdd', '2014-06-12', '1'),
(670, 'e246c629-2ca2-47ef-b16f-f2898379108d', '0', '0', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(671, '65a22b09-f423-4c2c-8a03-797e45573b52', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(672, '4b02b200-c1f5-4827-8a3e-95f521694c06', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(673, '12746051-1c97-4ea0-86b3-2d34d24ac3b5', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(674, 'a45c82a7-eca3-4803-8712-6a9a79c74d4f', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(675, '1acd1dcc-e4c6-4cce-b475-a2c7aba9716d', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(676, 'eb87754c-e2c8-4fb2-813e-942d55b17a0d', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(677, 'cf8236c6-0b18-46c7-904b-bcbbcd93aea4', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f62b1173-3bfd-431d-8d9e-60c901438903', '2014-06-12', '1'),
(678, '77fb8d02-c905-4f55-aa18-15c7007c4218', '0', '0', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(679, 'dab33117-ca13-408a-a018-b7b7be701319', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(680, 'f3d01d97-3bed-4026-946d-4a554f8ccfb4', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(681, '7e202852-f598-4ea3-b5f1-bc4fe144a980', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(682, '1b4ae1a1-0825-4eb1-9f16-9ff55b64b523', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(683, '4aad9c7b-7466-47ef-8df5-d4b167f00311', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(684, '6f1e425d-7f33-4790-bab1-86772840199f', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(685, '9fc5ae4b-793a-4387-8548-3c774a8c0de9', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '2014-06-12', '1'),
(686, 'fbf66896-bd44-4d2a-bc88-64d60fded412', '0', '0', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(687, '0514132c-f514-49f9-b03f-cda513e5dfea', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(688, 'a3157e0f-1278-4d76-b846-609f5b21c98d', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(689, '7ba9e4ee-d8e5-4ab9-8d48-076fbd79bfc7', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(690, '1f0b8a9f-8581-4bf1-a76b-6e169f984e83', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(691, '8a4ab35c-6601-4c69-b979-40f994888fd2', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(692, '9cbb05aa-03ea-4c1f-a58c-2e691d5e4c3f', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(693, '30a610fb-ca22-43dc-b612-0af16305ba1b', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '2014-06-12', '1'),
(694, 'f68ceb29-0775-496b-bb8a-73f8c0ac0c14', '0', '0', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(695, '635f9616-9d78-4547-9dc5-d54c12caafdc', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(696, 'e7838705-b580-4dbe-8820-0b15738d3eb2', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(697, 'b26f5823-cf73-4e97-a708-583bfde4b567', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(698, '38616297-dfc5-46f6-b10e-ba57d788b526', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(699, '2a482002-8431-470f-85ca-8fe242893734', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(700, 'c2dcc49e-d2c1-4101-8f54-4cfb2512cfc8', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(701, '5bacaac3-9dfb-4269-8d52-b6bb3ceb63fe', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '70a29e71-d9a3-405a-8804-7c1090682f8a', '2014-06-12', '1'),
(726, '0ffdc0de-925b-4f36-93d8-844d7af5e3cd', '0', '0', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(727, '79034189-9629-44f5-b6da-3d0cb5b3cd48', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(728, 'dadd6ba2-6de0-4d92-85e1-a89e45f8caa1', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(729, 'a1bfb076-591d-4643-91a4-0913a1d0890b', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(730, '729e7c7d-221a-4ad8-a9a2-371fbaae934a', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(731, '2f13c948-4afd-4bb8-b48d-ae917d7b5485', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(732, '3daa66bf-977b-428f-a0cd-179ece380c29', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(733, 'eae6bfa4-36d9-4510-ac0d-d0077db7bfba', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '2014-06-12', '1'),
(734, 'd3aebec7-a710-40f0-8786-27666803048f', '0', '0', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(735, 'b554c8ac-bf33-4d14-999d-4f04506afa74', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(736, '340d9b72-a030-497d-8f2b-5282c7a12523', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(737, 'b6483427-9db0-44a9-992f-7a99131406bb', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(738, '09af95a3-3abd-4f73-8e58-dcb09a57ab5c', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(739, 'f3c2a313-ed28-4ef3-9e64-9bc9d60dd0e0', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(740, '93339685-e213-40c6-8237-2d24c4a05c63', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(741, '5ce7513e-1f37-4e53-87f6-e5a886e646b2', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '2014-06-12', '1'),
(742, '12c52f24-9cea-42ac-9aa3-51abc501eb11', '0', '0', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(743, '9139c7fa-e284-47e9-9360-206aab4e0e84', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(744, '846c4588-44c1-4c3d-b533-26943a22410c', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(745, '5e0b07c7-5783-4f8f-8277-72261ea9f4cf', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(746, '03556770-c2cf-4149-84c7-0ad38c067634', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(747, '708049f6-f62a-4d21-b810-ca13900add45', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(748, 'e74063a9-4d13-4b95-b019-2c3524b10324', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(749, '539d96c6-81cd-4d99-bcf2-b962f71e15bb', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'cbdeb22a-7ad7-4855-a070-747d043378e4', '2014-06-12', '1'),
(750, 'cab16af5-61d7-41e6-b60b-37093e184a95', '0', '0', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(751, '96e7927f-9439-4178-8403-d99c0d06a937', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(752, 'dbe0658f-e817-4192-bf4b-c736cb9628f1', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(753, '6ec4b144-07d0-4911-91ce-11fcc4588812', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(754, '4422afd1-e8f8-4a96-ba0c-4f6eefb4ee3f', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(755, 'a98b8bc3-1746-4e73-ab7f-511eaf34fc9d', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(756, '709c0fd9-8e7c-4a69-94da-60bf03913d26', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(757, '3b52123e-7d81-4f5a-aa8c-ced66a90a589', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '004e8724-3ae3-4b71-a09e-466704766ebb', '2014-06-12', '1'),
(758, '8c459d3f-e3bd-4c22-aef8-988a2f33224c', '0', '0', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(759, '2d4c0373-f653-440b-b484-5b2d3099cfb2', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(760, '5222303f-002f-4c63-9ff7-8886e357b8f8', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(761, '44d7583c-87ce-4008-86f9-b8491ab97306', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(762, 'ea584caf-fcf8-42b9-8341-6cee14d82043', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(763, '6c5974cd-d812-4f23-90da-469c1eae04fa', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(764, '971779c8-826d-4631-9582-b56ce516924e', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(765, '08b7f3a3-8c11-4f0f-9214-fdec10611aa2', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '2014-06-12', '1'),
(766, '42971a78-98ab-43b7-b54d-01f2f9af19ca', '0', '0', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(767, 'c8cce8c2-f65e-428c-9771-7e71e302fc9a', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(768, '864a0154-c6b0-4c28-8b6e-68626647a42a', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(769, '64fb4124-2fa7-40bd-a0c7-e281c424a3c9', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(770, '65622eb7-4e4b-4e51-b08c-b0f7447b8a86', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(771, '9fd372e8-c418-49fd-ae07-ba6bedf879d3', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(772, '97725903-c30d-4501-91d7-829e06749c84', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(773, '3bbdabe4-4b59-4fd6-9363-c37ed2353878', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '2014-06-12', '1'),
(774, '908cf78e-3b6e-48b9-9d23-c5bf933a3d06', '0', '0', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(775, 'ba6338a0-506b-4efb-b7b4-5efa932e135d', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(776, '7ca5f0fd-c634-4eda-94be-c2d9d26a456b', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(777, 'e061d97a-f251-4cac-a758-ec6c6b1342ea', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(778, '56038aec-38c7-4066-885d-98cc9608c971', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(779, '80fd430f-983d-456d-9d24-825114a341a3', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(780, '1f717ce6-639b-43a1-9f7d-33c46bac4a2b', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(781, 'ee05f467-4e6e-4598-bfdf-715a088402a4', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '2014-06-12', '1'),
(782, '343897d0-0a3f-4a5c-86c4-d4a2534b6a4e', '0', '0', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(783, 'ca9be5ed-c9bd-44b6-90cf-c6f648da3659', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(784, '5889353c-846e-47dc-9739-964cb3887b60', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(785, '8822e70a-7870-498c-982a-a5f70a5e0250', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(786, '2b5d35ce-880d-4847-a8c6-8fc032540467', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(787, '9db0bb19-f500-4c01-9936-79ca95caef3f', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(788, '599e4c18-c46c-4087-a081-8be399f40189', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(789, '585cffe6-d0a0-472e-a6aa-4fedefab7895', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '2014-06-12', '1'),
(790, '64ac3560-8327-42ce-9514-70493b64ee00', '0', '0', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1'),
(791, '6322b482-1171-4384-bb2d-9139b8fd74eb', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1');
INSERT INTO `sys_authorities` (`id`, `auth_code`, `is_menu`, `model_code`, `menu_code`, `create_date`, `status`) VALUES
(792, '3e05f85d-ea79-446c-acac-ffd14f209ff5', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1'),
(793, 'da562306-cd8d-49f7-98d4-f7e9ed6c0526', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1'),
(794, '0402528c-c643-4021-9736-d0aa2f1efd57', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1'),
(795, 'fe38c3fc-af37-46dc-ae48-8c9e14b60391', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1'),
(796, 'c003b776-d894-42f8-b42b-73d1bff8f9b7', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1'),
(797, 'cc003d9b-0ab1-43ca-a666-277269478f3f', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '603eaef5-6332-4211-b681-139e96b63e48', '2014-06-12', '1'),
(798, '3e787f18-91c9-478e-a1dc-6343266cecbf', '0', '0', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(799, '9c9ba40e-3195-4750-8f6f-26ae58d57571', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(800, '699a6bbe-1dd0-4fc1-ac07-df37b55290db', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(801, 'fc27ca73-bb0c-41fa-b6a6-8188cd731873', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(802, '9dae2ec2-d759-46aa-971f-2352a8fe7e6a', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(803, '51a40c03-f4e9-4f5e-8002-ebcc05b90d77', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(804, '40b02e73-9a0b-4fca-952e-63f57434a575', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(805, '95e5cb6c-32b2-4738-94da-ff308fc102d9', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '2014-06-12', '1'),
(806, 'e92b393c-10c4-41c6-96c0-7027690caee1', '0', '0', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(807, '4d2fced2-84a0-409f-a5f6-4d4bbaa6e60f', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(808, '3256c1a0-9500-4904-a785-e9d6e7044e82', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(809, '63e14254-a508-453c-8bd1-94a86ba52954', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(810, '10d01e9b-d5d0-417b-8485-76ccec51355d', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(811, 'b11d219a-c109-4d2e-940f-ad607cf4d416', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(812, 'eabc85ef-dea1-43ad-b429-5b9775c46387', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(813, '6eb0d1eb-a722-4940-83a0-0140ffa71299', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '2014-06-12', '1'),
(814, '0ff11d28-4796-4313-8b02-80f3e0a3f8f8', '0', '0', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(815, '0b20e13c-1af2-4044-8a92-517dd1b77a2d', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(816, '69540b3d-2653-4531-b810-02d429a10a76', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(817, '59c167f2-4bea-42f3-9aa6-69d443e73b60', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(818, 'f5f89ac7-9fd3-4ea9-a68d-3487bcfacb2b', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(819, '19c92647-3908-4b52-bcf7-5fc3db2c1654', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(820, 'eaee9247-d2ac-4bb7-bbf5-552ab0b622a5', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(821, '8c5c7360-2245-496b-a74c-8476ec2c831b', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '59edc588-903b-4d65-90c8-c208a4d0db36', '2014-06-12', '1'),
(822, 'bb6f8b85-b4f8-4718-b994-dee14302040a', '0', '0', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(823, '8962f183-ba92-4acb-8255-cdef25fc9404', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(824, '039f425f-64c7-4493-9d3f-999554f4c997', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(825, '7e98f3e4-9788-47b8-99ea-3bacc91ec191', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(826, '4298ac62-89a1-49b6-9193-76f1585e4f37', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(827, '5ce27821-659d-4616-b347-b1b3b60f2653', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(828, 'a7535236-a27f-4c0b-ad3a-dbd910f91e37', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(829, 'ac7d4149-0516-4b88-8059-4118f9d78a9c', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '2014-06-12', '1'),
(830, 'c2dfdae6-9761-4610-b9ec-c62ca625ecc3', '0', '0', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(831, 'f9a718fd-8dff-459e-bde9-e88a70e095a1', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(832, '31788ab2-3c26-4a98-8d43-fb92e4cf5a1c', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(833, '1e7676bf-5969-4eb3-8029-ec2c06b2963b', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(834, 'b5a56c41-387b-43ef-9bdc-8e50a4e737d4', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(835, '12cf96fb-feb4-4c8e-9876-a2a8aa986183', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(836, '04f75409-9af1-42c7-bb8f-c27478af612c', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(837, '2c3bdc62-c174-493c-8468-2371d97c99c7', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '2014-06-12', '1'),
(838, '2d2ac4f9-17ad-4f75-8fbd-ed3d9f1b7a31', '0', '0', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(839, 'e4e9aa51-8162-44cc-94a7-de569e06b9a0', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(840, '70f24eee-2620-45e6-bfe4-83c2cf820103', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(841, 'b147c9ee-4f6c-444c-8cab-f85e199b37a0', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(842, '8a2f2df7-9ad7-4222-adf7-1fbfe3ce5117', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(843, '29af1476-ea62-4895-9ba1-0313c5d0cef1', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(844, '7e1ee565-f094-4491-b31a-3d40a8405044', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(845, 'd5d496d6-80d8-4aa0-95ea-7c86de080dc9', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '2014-06-12', '1'),
(846, '9badbafe-0d35-4d3e-a513-1e563e78befd', '0', '0', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(847, '6cae5280-5ec7-4455-b633-b13b152fd2cc', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(848, '06d80948-b5be-4f5c-9836-4bbdcc0bd66a', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(849, '73184c54-28a5-4c76-95fb-49b284904dd1', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(850, 'fba700dc-9398-4b41-8487-7565f8678a9a', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(851, '2cbee896-8b70-4fcd-8ead-d303646639e5', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(852, '7b626bd1-0a91-4228-ae63-3d22e912ca26', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(853, 'fa826071-cc19-4220-b34c-3cad6673414a', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '2014-06-12', '1'),
(854, '2e6d9e56-1a0b-4a9f-af53-d40bee1daafd', '0', '0', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(855, '989c48e3-93f0-426f-8f4b-28009b6e773f', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(856, 'f0eaf362-b678-4988-ba83-d22dad586a0d', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(857, 'b25348fd-5e69-4a86-a548-de4656429a17', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(858, 'e14144ff-bfc3-47c9-86c6-d3fa32eea7f7', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(859, '70f7ac9a-bdbc-46b5-8c3b-3dcd32620d52', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(860, '95cffdb7-fe99-400c-8d35-b3363e0431ab', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(861, 'e20eebcf-3773-4003-902e-d09b17f660eb', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '2014-06-12', '1'),
(862, '33760849-02ea-4b6d-b76a-52eafa4b8f9a', '0', '0', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(863, '432c584c-8916-4f27-ba53-d8703bdea257', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(864, '3b230200-18b0-4b07-a473-bd2d7f17bdb0', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(865, '1c360921-c002-4ee0-80c5-dfd8afe643d9', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(866, '6aec0214-b42b-442a-9116-b3181779a912', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(867, 'ae5d2461-048e-4257-bf9d-49139e725295', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(868, '0b77a344-be7f-450a-bcff-ec060fcab918', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(869, '8bfd26e6-6744-48dc-b7aa-ac0f046ee976', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '78ec051e-b1ad-43da-aa22-2ec459908aa5', '2014-06-12', '1'),
(870, 'dbbd8e13-b746-468e-943f-8a9aef19ac84', '0', '0', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(871, '152daec2-5210-4fd0-8bb5-35e8e567e8d4', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(872, '9928f403-1b07-45ba-bb1c-61b01f1852cf', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(873, '6563f3f8-3b93-4ee1-a76b-5e05008f4843', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(874, 'f3bb03b2-ab02-4d20-88e3-d69333a13288', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(875, 'ac44a7a5-fadc-420e-8f53-bda22ac1682b', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(876, '3a790131-acf4-4126-a5cc-56d30bfe330d', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(877, '5d2ca27d-9e75-4181-ba67-0b6907fcb6ad', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'b41e0f02-5bde-4452-8966-1fd8631b924c', '2014-06-12', '1'),
(878, '02f75fac-9694-4e64-9f63-4ef9956f27ac', '0', '0', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(879, 'd8f8d4c0-82c0-4ee4-a0c6-5918b5cdea1d', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(880, '0b0af33e-06b2-4894-bf8f-35e7882423ff', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(881, 'e1e486de-c9ed-49bf-950a-5d8f10c36dbb', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(882, '093bd47f-3511-4f15-882d-b1d17e560132', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(883, '2d90100e-9a37-43e6-9f7d-b8118783d035', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(884, 'b8cd5dfd-3e86-4320-8abe-73338ba4f9c9', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(885, 'adad6eda-1578-4a84-b528-d2e41ce60c2d', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '2014-06-12', '1'),
(886, 'da66a5cc-ddf4-4080-a66b-94f6be66cda9', '0', '0', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(887, 'ac2d58c0-80c5-457a-9ba7-411ca78066f2', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(888, 'e9e18ba6-a24e-4be6-8b38-2d5995fc9f41', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(889, 'e67938c5-13a8-4ea0-a0c5-7ee83312a9d5', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(890, '12b3fe8d-c674-4879-8418-d1c65900fe2b', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(891, 'defddf30-b5a9-4d11-b858-302918302b58', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(892, '4488a538-31a8-4967-b72e-4ade976913f3', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(893, 'd3f0bbf0-2886-4f8c-8c1c-c4ed9870ed9f', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '6ef2b035-cc84-45bb-a6a1-107493eba2c8', '2014-06-12', '1'),
(894, 'ff97f4bb-3686-415f-b686-497fcb06e323', '0', '0', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(895, 'aed7eabf-2300-4d1a-9d4c-15e2fca495d4', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(896, 'd2a221dd-168a-4e04-b0af-29aa5d9bddcb', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(897, '4ad0930b-a832-468c-a917-d84a2a0423dc', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(898, 'f3f5ff66-1ae3-42f4-b51b-a8cd7bcd3b7d', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(899, '649c9072-6c6a-43fd-b4db-25ec715adb40', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(900, '0c4ecc6d-3268-444c-aad7-6c93cb189a94', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(901, '394e1c4e-065a-442c-85f4-111efe022b0c', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'fe678146-dad6-4754-b7c1-57a34663b0a4', '2014-06-12', '1'),
(902, 'd6269a15-e210-4b46-a982-2f4085ee074e', '0', '0', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(903, '4533c566-c70d-4c5f-befa-f925f82213c4', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(904, '7650c7bd-83a2-4770-96f9-9535e837b56c', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(905, '179ff709-a0d0-4006-bb3c-b4882e68f089', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(906, '255b2ec6-71d0-483d-8531-60123e75ec90', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(907, '34d51b71-f30c-48ad-a0b9-8366f87baf4f', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(908, '8cbf3c18-fc71-4c7c-b58c-07840c86410b', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(909, '8035780d-ad9a-4295-9301-ed2fbd436bf2', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '5d3c7d86-51b3-4327-bd0f-9ddf15738323', '2014-06-12', '1'),
(910, 'a4c11b8d-3bd6-493b-9128-7d26ed725396', '0', '0', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(911, 'd9e5284f-bded-4638-a94c-f457f515f879', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(912, '1f7049d2-c4a8-44ac-afac-ce840a7d3bb8', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(913, 'f1101dd2-860b-4096-aff0-422ebadcba93', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(914, 'cdb4d115-7816-4154-8cb2-a873ebe66323', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(915, '322e0a04-acfe-467f-a338-6b0481030574', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(916, 'd39cd1fb-1023-4fcc-935c-6d1dfa2af628', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(917, 'c378e3e8-41ef-43ec-88b2-41baa6793a8b', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '2014-06-12', '1'),
(928, '144f5dc9-647c-4892-8897-8618e6daba06', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '92c42b26-bf66-4981-b04e-6983e31923a2', '2014-06-13', '1'),
(929, 'fa2ea91a-6ff8-43d4-a47c-feb74ba06040', '0', '0', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(930, 'e6b0e136-d952-4040-b2f5-daf75e7fd6b0', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(931, 'fbbcf365-1103-4c5a-aa07-40a02e15f915', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(932, '912511a1-1cae-4d9f-a7ff-ccc1f98be3a6', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(933, '4d3a60eb-ed22-4d4c-871c-a02f16da0f37', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(934, 'e39e30dc-27c4-4b6b-a427-07dacab68a0a', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(935, '3961f1df-2ba8-4f51-9216-aa415e2d6588', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(936, '16e4480f-ac06-4b63-ac30-31889cc12dc7', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '2b678c7b-519b-4871-92b4-83bef6e60978', '2014-06-13', '1'),
(945, '9080e5ed-7546-47f2-8056-88485b24ee43', '0', '0', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(946, 'a2147435-aeab-4522-a846-4429ddbcd8e8', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(947, '24ead831-c6b7-420d-a1e1-617e12591eda', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(948, '61978f0b-24d5-47ce-88dc-18b2cf1d6006', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(949, '91930c1b-2009-4bcd-901e-4e938fa34372', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(950, 'ebfff3cf-d6d7-4eae-bde3-df6cf77a00b9', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(951, 'ddfdff0e-6d32-4331-90a7-ba3916c93ee6', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(952, '2827dc34-8f87-48f2-94fd-e1b42361a07f', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '4bf340fe-a02d-46ed-9b7c-1c376799928c', '2014-06-13', '1'),
(953, 'c46beae7-1b20-4b95-8298-6c119903e452', '0', '0', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1'),
(954, '788bdeac-a716-4a8b-9d4d-6a733baf855b', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1'),
(955, '2961bbfd-06ed-4113-b8fe-7ca481e61b55', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1'),
(956, '3ee0c701-ce2a-4cc8-8772-063a0e67d9c6', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1'),
(957, '694c4303-2f5e-4580-b61d-8873020792d7', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1'),
(958, 'dfc3ec53-6934-47da-ae27-95399f2b13b7', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1'),
(959, 'a770f79a-909d-4394-8043-be24979689d2', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1'),
(960, 'da88797a-89e4-4096-ab9c-13f30a842939', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '645204bf-8daa-45ca-9655-22e0fcd75582', '2014-06-15', '1');

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
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=67 ;

--
-- 转存表中的数据 `sys_menus`
--

INSERT INTO `sys_menus` (`id`, `menu_code`, `menu_name`, `levelid`, `fmenu_code`, `engname`, `menu_url`, `create_date`, `status`, `sortValue`) VALUES
(1, 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', '系统功能', '9', '0', 'A_SYSTEM', '', '2014-02-14', '1', 9),
(2, 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', '权限管理', '90', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', 'A_PRIVILEGE', '', '2014-02-14', '1', 0),
(3, 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '用户管理', '901', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_USERMANAGE', '/jsp/user/sysUserList.jsp', '2014-02-14', '1', 1),
(4, 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '角色管理', '902', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_ROLEMANGE', '/jsp/role/role.jsp', '2014-02-16', '1', 2),
(5, 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '菜单管理', '903', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_MENUMANGE', '/jsp/menus/menus.jsp', '2014-02-16', '1', 3),
(16, '0b47540b-cbd8-453d-93f9-60f3365e200e', '工作台', '1', '0', 'gongzuotai', '', '2014-06-12', '1', 1),
(17, '3992e26c-1409-48ae-909d-9315a365c960', '日常工作', '11', '0b47540b-cbd8-453d-93f9-60f3365e200e', 'richanggongzuo', '', '2014-06-12', '1', 0),
(18, '4dc08c8c-fa18-45da-8d92-ebcf4174cd5c', '日常报表', '12', '0b47540b-cbd8-453d-93f9-60f3365e200e', '', '', '2014-06-12', '1', 0),
(19, '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '门店管理', '2', '0', '', '', '2014-06-12', '1', 2),
(21, 'a97b2899-a305-488b-8c73-0a9ccf4c1be7', '门店所在城市', '211', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '', '', '2014-06-12', '1', 0),
(22, '87633631-8ac1-4f56-b91b-b0a6da4f4d12', '已开门店列表', '212', '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '', '', '2014-06-12', '1', 0),
(23, 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '门店地图管理', '22', '243e7fb8-9a88-4b1e-b2a8-43a83286db10', '', '', '2014-06-12', '1', 0),
(24, '5b8e5342-5ef2-4e6c-9044-478ea042532d', '门店地图管理', '221', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '', '', '2014-06-12', '1', 0),
(25, 'f8176d4d-819c-4e3f-819e-aa415fbfea53', '门店区域统计', '222', 'd93a67f2-2f43-4f96-8aad-71395ad2cc27', '', '', '2014-06-12', '1', 0),
(26, 'c51a6ee9-2733-485a-b938-a19510db2baa', '产品管理', '3', '0', '', '', '2014-06-12', '1', 3),
(27, 'f24efa28-a3c6-4324-8d87-9350ae500e4d', '产品类别管理', '31', 'c51a6ee9-2733-485a-b938-a19510db2baa', '', '', '2014-06-12', '1', 0),
(28, '6ef500e0-051f-4e3c-b3be-203a9ec90f06', '产品属性管理', '32', 'c51a6ee9-2733-485a-b938-a19510db2baa', '', '', '2014-06-12', '1', 0),
(29, '8404bc74-6c68-462f-9f1a-98624ec32885', '产品资料管理', '33', 'c51a6ee9-2733-485a-b938-a19510db2baa', '', '', '2014-06-12', '1', 0),
(30, '7baa6ea6-da4f-4172-bf78-3b7c753b8104', '优惠直通车管理', '34', 'c51a6ee9-2733-485a-b938-a19510db2baa', '', '', '2014-06-12', '1', 0),
(31, '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '内容管理', '4', '0', '', '', '2014-06-12', '1', 4),
(32, 'b7676775-c712-47c6-911b-0f1f8b42fa89', '基础设置', '41', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '', '', '2014-06-12', '1', 0),
(33, 'a24416bd-7485-41f6-ad3b-dbd5054ef48d', '内容类型设置', '411', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '', '', '2014-06-12', '1', 0),
(34, '539a3604-1035-4eb3-9e6b-44af5c325bdd', '帮助中心管理', '412', 'b7676775-c712-47c6-911b-0f1f8b42fa89', '', '', '2014-06-12', '1', 0),
(35, 'f62b1173-3bfd-431d-8d9e-60c901438903', '内容发布', '42', '7dcf8a42-cdcf-4293-8a0f-411da10bb4a5', '', '', '2014-06-12', '1', 0),
(36, 'd5ee7e2f-3421-4c48-bb42-38ca85ec0ef3', '首页公告发布', '421', 'f62b1173-3bfd-431d-8d9e-60c901438903', '', '', '2014-06-12', '1', 0),
(37, 'e1ae28e3-5dcf-46f6-a20b-e23e93b4d0ea', '图片广告发布', '422', 'f62b1173-3bfd-431d-8d9e-60c901438903', '', '', '2014-06-12', '1', 0),
(38, '70a29e71-d9a3-405a-8804-7c1090682f8a', '促销活动宣传', '423', 'f62b1173-3bfd-431d-8d9e-60c901438903', '', '', '2014-06-12', '1', 0),
(39, '92c42b26-bf66-4981-b04e-6983e31923a2', '会员管理', '5', '0', 'M_MEMBERMANAGE', '', '2014-06-12', '1', 5),
(40, '4bf340fe-a02d-46ed-9b7c-1c376799928c', '会员资料管理', '51', '92c42b26-bf66-4981-b04e-6983e31923a2', 'M_MEMBERINFO', '/m5_memberInfoList', '2014-06-12', '1', 0),
(42, '8b83df1d-a4f2-43fc-83fa-db979d1240bf', '订单管理', '52', '92c42b26-bf66-4981-b04e-6983e31923a2', '', '', '2014-06-12', '1', 0),
(43, 'ee23ef26-0db1-4c0a-9bb8-1d86f2e22c16', '换购订单管理', '53', '92c42b26-bf66-4981-b04e-6983e31923a2', '', '', '2014-06-12', '1', 0),
(44, 'cbdeb22a-7ad7-4855-a070-747d043378e4', '会员优惠券管理', '54', '92c42b26-bf66-4981-b04e-6983e31923a2', '', '', '2014-06-12', '1', 0),
(45, '004e8724-3ae3-4b71-a09e-466704766ebb', '会员积分管理', '55', '92c42b26-bf66-4981-b04e-6983e31923a2', '', '', '2014-06-12', '1', 0),
(46, '5b7a73fc-7202-438e-96b1-16d6ed43dc8a', '黑名单管理', '56', '92c42b26-bf66-4981-b04e-6983e31923a2', '', '', '2014-06-12', '1', 0),
(47, '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '会员报表查询', '57', '92c42b26-bf66-4981-b04e-6983e31923a2', '', '', '2014-06-12', '1', 0),
(48, '6ac9f6de-b901-46da-b53a-b5dcbbfe08a8', '会员性别比分析', '571', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '', '', '2014-06-12', '1', 0),
(49, '5bcc8a3e-96fc-4658-b38c-a21b0d27ee62', '饼图', '572', '40b3ce5d-e457-4e35-9f29-f8f994f4693f', '', '', '2014-06-12', '1', 0),
(50, '603eaef5-6332-4211-b681-139e96b63e48', '积分管理', '6', '0', '', '', '2014-06-12', '1', 6),
(51, '46c84ffd-9e2c-4bc4-8ab2-03a8aa8081b7', '积分规则管理', '61', '603eaef5-6332-4211-b681-139e96b63e48', '', '', '2014-06-12', '1', 0),
(52, 'dd805820-9aa7-4ad5-b143-a2fb1e00a9f0', '换购商品管理', '62', '603eaef5-6332-4211-b681-139e96b63e48', '', '', '2014-06-12', '1', 0),
(53, '59edc588-903b-4d65-90c8-c208a4d0db36', '订单管理', '63', '603eaef5-6332-4211-b681-139e96b63e48', '', '', '2014-06-12', '1', 0),
(54, '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '订单管理', '7', '0', '', '', '2014-06-12', '1', 7),
(55, '9280d800-6182-41cd-b98c-0e9fd4de0e2a', '当天订单管理', '71', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '', '', '2014-06-12', '1', 0),
(56, 'e87fb09f-f39a-44c6-844e-fbadb1ada120', '订单跟踪管理', '72', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '', '', '2014-06-12', '1', 0),
(57, 'b0ff086e-2fdd-40d1-be2f-17f43ded7f42', '配送范围管理', '73', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '', '', '2014-06-12', '1', 0),
(58, '7d44fbb5-9c99-410a-ab48-9c77010ed2fe', '订单历史查询', '74', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '', '', '2014-06-12', '1', 0),
(59, '78ec051e-b1ad-43da-aa22-2ec459908aa5', '订单投诉管理', '75', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '', '', '2014-06-12', '1', 0),
(60, 'b41e0f02-5bde-4452-8966-1fd8631b924c', '电话订单管理', '76', '4ed49cba-d7b5-4bc8-8e09-c01d858fa6e5', '', '', '2014-06-12', '1', 0),
(61, 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '报表分析', '8', '0', '', '', '2014-06-12', '1', 8),
(62, '6ef2b035-cc84-45bb-a6a1-107493eba2c8', ' 会员资料分析', '81', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '', '', '2014-06-12', '1', 0),
(63, 'fe678146-dad6-4754-b7c1-57a34663b0a4', '会员消费分析', '82', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '', '', '2014-06-12', '1', 0),
(64, '5d3c7d86-51b3-4327-bd0f-9ddf15738323', ' 门店销售分析', '83', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '', '', '2014-06-12', '1', 0),
(65, 'b3e21d0b-1ca5-4772-9b14-5b0245da8227', '其他分析', '84', 'b035d8a0-b0e4-4771-aa2e-28e36a4434c4', '', '', '2014-06-12', '1', 0),
(66, '645204bf-8daa-45ca-9655-22e0fcd75582', '部门管理', '91', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', 'A_DEPARTMANA', '/aaaa', '2014-06-15', '1', 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=gb2312 AUTO_INCREMENT=984 ;

--
-- 转存表中的数据 `sys_roles_authorities`
--

INSERT INTO `sys_roles_authorities` (`id`, `role_code`, `auth_code`, `create_date`, `status`) VALUES
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
(122, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2d19a0c1-5063-4fb5-a4e3-fc7083005ab9', '2014-04-13', '1'),
(155, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '484df61b-c417-40c0-9b3f-cd580153e4a9', '2014-06-12', '1'),
(156, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '53383002-ccb8-40b6-a3ce-9fb91aad31a6', '2014-06-12', '1'),
(157, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '193f230a-aa7b-4e98-8232-a4a064388714', '2014-06-12', '1'),
(158, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0c812621-f207-40a3-b878-129cb6f69526', '2014-06-12', '1'),
(159, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4e6651c6-0eaa-4871-af42-4967773b75e6', '2014-06-12', '1'),
(160, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f4203876-dd59-488f-aca5-dcbe62da0b02', '2014-06-12', '1'),
(161, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dd352572-3885-4abc-a035-29576638a8e1', '2014-06-12', '1'),
(162, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a2df42f2-086b-4bcc-9292-5920eb4c585e', '2014-06-12', '1'),
(523, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e7b98c38-0709-46e4-bf24-671ad70e9641', '2014-06-12', '1'),
(524, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '92ad4c87-3f31-4a14-a42d-fd628c93e99a', '2014-06-12', '1'),
(525, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '185f0b6a-513f-4b21-935d-3a21cb93a918', '2014-06-12', '1'),
(526, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2fa171ef-ced6-4578-a9b2-bb0dc9f42cef', '2014-06-12', '1'),
(527, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '68e91e33-afd7-4b67-903c-e69413439f85', '2014-06-12', '1'),
(528, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a7e6e71d-49e8-474e-be37-2e9f791dd8ab', '2014-06-12', '1'),
(529, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a764812f-e52c-4884-b8bf-58b724b1934e', '2014-06-12', '1'),
(530, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b3b1b421-9329-4f74-9502-36e8dfe45e04', '2014-06-12', '1'),
(531, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f2de900b-3d31-4075-8d2f-85ff440d7db2', '2014-06-12', '1'),
(532, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '69bcf67d-9fc9-4ab3-81f4-8ebefa7e6d8a', '2014-06-12', '1'),
(533, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e6a5607f-50c5-487d-a89e-bddc5e60c66c', '2014-06-12', '1'),
(534, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '697bfdc8-529a-46cd-aef2-18d6a2a5eba3', '2014-06-12', '1'),
(535, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '16045136-7140-4920-8485-ae9288cbea28', '2014-06-12', '1'),
(536, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8b2f5b0f-97d1-473f-9684-8c3e190b40bb', '2014-06-12', '1'),
(537, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '676ce443-699a-46ea-8b91-220eec994d47', '2014-06-12', '1'),
(538, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '58a710f7-fcf8-4df2-8037-fc9d24382acb', '2014-06-12', '1'),
(539, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b6fd798b-2823-42ad-b921-16a74ceb1c46', '2014-06-12', '1'),
(540, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6df9fc0b-8ed6-4f09-96f2-4c1f5bc927d3', '2014-06-12', '1'),
(541, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e734e5ac-148b-41a1-bf90-c5740c5284fb', '2014-06-12', '1'),
(542, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ea72bedc-bc44-47d2-8d7f-2224ff415fdb', '2014-06-12', '1'),
(543, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2134cd4b-17bf-412b-b7da-cb01f023573b', '2014-06-12', '1'),
(544, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8097d258-1ba4-4c8b-8703-28136b02f186', '2014-06-12', '1'),
(545, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c5a333c4-8891-401d-8ebe-471420c7b1ea', '2014-06-12', '1'),
(546, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '01448d27-a59c-4a6d-a034-b89c4ea2e626', '2014-06-12', '1'),
(547, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7b43bab4-d378-40c2-acdf-6e7a35383fb0', '2014-06-12', '1'),
(548, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fa92c519-b777-4b2a-b53f-47aa903d3e91', '2014-06-12', '1'),
(549, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '764546f3-a1b8-4f52-9a7b-99ae84802183', '2014-06-12', '1'),
(550, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bff4a8ed-dd26-4182-8b29-32fbff48ff7a', '2014-06-12', '1'),
(551, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '30c81dd6-bf83-4c18-b970-495adbad5dbf', '2014-06-12', '1'),
(552, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '23d52797-6b53-4dae-9bab-f63f35269bc5', '2014-06-12', '1'),
(553, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '17ede6d5-4ecc-4ba8-aa7e-b6c466378dac', '2014-06-12', '1'),
(554, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6801cb85-a07c-408e-83ab-db63adcd50f2', '2014-06-12', '1'),
(555, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2cb33ec3-95d4-4b44-abfe-ef3e11670e43', '2014-06-12', '1'),
(556, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '00b32538-08b0-4115-8d9e-7c8635e02998', '2014-06-12', '1'),
(557, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'daacaa7a-7e25-4df2-986f-2daf409ebc03', '2014-06-12', '1'),
(558, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bebcb1f9-fa2e-47cf-9256-3fa78b64cb3f', '2014-06-12', '1'),
(559, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a7195f98-78a8-4bc8-a11c-84a4e66d8c50', '2014-06-12', '1'),
(560, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bd4ad8b3-2298-447b-ba97-c601155401f6', '2014-06-12', '1'),
(561, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '56d9f756-3f4b-492b-93f5-e2fe280db9d1', '2014-06-12', '1'),
(562, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bc1264b3-2286-470e-9a9e-28d4cf4c542d', '2014-06-12', '1'),
(563, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '443c47c0-8d21-4de4-b62c-f33e955e35e0', '2014-06-12', '1'),
(564, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '62c88082-d5c9-4531-9cd3-98ba7e105d15', '2014-06-12', '1'),
(565, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8b370dd6-c969-448f-90b3-aab4734066de', '2014-06-12', '1'),
(566, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0503b823-5a9d-4113-a13d-3d8e3658e346', '2014-06-12', '1'),
(567, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd3eb40ef-d2c7-4ffd-a929-ad3bfa85278b', '2014-06-12', '1'),
(568, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '347dbb13-bdd6-41e3-bbd5-08349bdbe237', '2014-06-12', '1'),
(569, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '93946193-8b9f-40dd-96ce-f7c4bf2943e0', '2014-06-12', '1'),
(570, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b6637bba-fb4d-442a-a63e-a60c705a247c', '2014-06-12', '1'),
(571, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9ebac23b-c613-49a5-8b68-d442a3df70a4', '2014-06-12', '1'),
(572, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'de0b6803-de19-441b-ae44-7fc130fd9bb5', '2014-06-12', '1'),
(573, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f15a7c77-1f46-4fca-9174-be431d61bba9', '2014-06-12', '1'),
(574, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '51657646-0e42-44a2-aea9-b448f5e66db7', '2014-06-12', '1'),
(575, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ea4b8f90-3229-4040-a4fc-c938a9438a5e', '2014-06-12', '1'),
(576, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c39b9fe9-dac8-4f87-b147-2016e531a4a5', '2014-06-12', '1'),
(577, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '92a70ec4-939c-4b0b-b0f0-b78f95b0a197', '2014-06-12', '1'),
(578, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9dd03429-04f8-4733-a909-ecd019ab68ea', '2014-06-12', '1'),
(579, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a5da800b-e506-40f0-b46a-6738223236b3', '2014-06-12', '1'),
(580, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3a9b5b1a-26e3-4ad9-8b45-c1610f0b6dbe', '2014-06-12', '1'),
(581, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fa1d0b9e-ad7f-4277-8a83-341e1d9403bb', '2014-06-12', '1'),
(582, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '80467c4f-0f91-4685-a2fa-4d9ca0d5c5e5', '2014-06-12', '1'),
(583, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '410a1164-f879-47ea-8ede-7cf5e934bfb1', '2014-06-12', '1'),
(584, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '00b5520c-367c-4c7f-a061-827ac5f409fd', '2014-06-12', '1'),
(585, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '797c358f-1d50-43ea-88c7-b334115c97c4', '2014-06-12', '1'),
(586, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '21c7eefc-e3d0-4755-ad96-cb56714e6f5f', '2014-06-12', '1'),
(587, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '906ed241-a2fb-42e8-9c33-5619faea6791', '2014-06-12', '1'),
(588, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '58aabed1-3201-446d-be1f-f11ddef0e51d', '2014-06-12', '1'),
(589, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '50929c0d-04d3-4e92-8976-3a74bff05608', '2014-06-12', '1'),
(590, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6dbc2cc9-ad86-4628-ad4a-5199304a32e0', '2014-06-12', '1'),
(591, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e8784dcd-70ac-4e48-9942-73560096b980', '2014-06-12', '1'),
(592, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ebeffd8e-0a5f-4348-8906-ae67ff7b4aa7', '2014-06-12', '1'),
(593, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6baa9909-2ca1-4bab-8e6a-bcdc38e2b826', '2014-06-12', '1'),
(594, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a47e68a0-b032-4430-a455-46994f176453', '2014-06-12', '1'),
(595, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '43aa41fd-ba89-40d0-b0bc-ab3b5cd35e5a', '2014-06-12', '1'),
(596, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '54189914-27aa-4dce-8233-4cd5151e7cf1', '2014-06-12', '1'),
(597, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3b66afc3-1f7f-41c0-abd9-0280e0846bb2', '2014-06-12', '1'),
(598, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '03274edf-ae2a-4bcb-86d8-ee8d8c9ff947', '2014-06-12', '1'),
(599, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '599eb9bd-a512-46c8-9dad-21f52781eaef', '2014-06-12', '1'),
(600, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '314786a3-141e-4a2c-ae2b-6a485ebb8544', '2014-06-12', '1'),
(601, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '34942a82-dc35-4f36-8381-93f5ef2ae8d1', '2014-06-12', '1'),
(602, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '75dd73e2-55d5-4d2d-9a81-c271c96677c5', '2014-06-12', '1'),
(603, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b95b3665-58e6-4afd-98a6-e8ba7cbe4a0c', '2014-06-12', '1'),
(604, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '08612477-0a5a-4ec7-854d-84be74fefb64', '2014-06-12', '1'),
(605, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bcbbb89e-19d4-4439-b742-43110e61393c', '2014-06-12', '1'),
(606, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '469ff074-8312-44a8-80a9-e5d36807ee02', '2014-06-12', '1'),
(607, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ce64c314-0978-4b0f-9d29-1a30ef4ee337', '2014-06-12', '1'),
(608, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a729b222-136a-46b6-a1bb-695675c8bf95', '2014-06-12', '1'),
(609, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '91629999-e80c-4267-b378-5bee20537249', '2014-06-12', '1'),
(610, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cfc97c3e-4276-4691-9d01-e7be48d66cb4', '2014-06-12', '1'),
(611, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '093387ae-9117-4c5c-bca8-b4a6b910233c', '2014-06-12', '1'),
(612, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c6cae329-3e2f-4011-bc3a-e011cf06b226', '2014-06-12', '1'),
(613, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f51eb7c0-e350-46b1-8f9f-c7f8f6406183', '2014-06-12', '1'),
(614, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e428bccb-42aa-4b46-8a26-3ee094758967', '2014-06-12', '1'),
(615, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b8289227-bc16-40a6-bfab-a85f5e95b158', '2014-06-12', '1'),
(616, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '459c1122-3d27-419f-911f-827ccb444ee6', '2014-06-12', '1'),
(617, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c318f266-9dca-4a62-ae4a-1438eef50fe8', '2014-06-12', '1'),
(618, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1815ac3c-99c0-4425-9d24-1a0c06cdaca1', '2014-06-12', '1'),
(619, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b3a92d50-b803-44a1-8642-e8e2759c6f5e', '2014-06-12', '1'),
(620, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '62db04ee-cc0b-4506-8f05-9ba056a493fb', '2014-06-12', '1'),
(621, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b0f592e4-6189-41dd-ba89-e23ea229e45a', '2014-06-12', '1'),
(622, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '20628678-7f7c-434a-a804-19133c1a18ee', '2014-06-12', '1'),
(623, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a485a1f8-6644-4f23-8286-53989069e381', '2014-06-12', '1'),
(624, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7df33a00-fd6b-4fd5-9e28-dfe7e9edda2b', '2014-06-12', '1'),
(625, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c0f015cb-2b00-41f6-87ee-6f3d7667e642', '2014-06-12', '1'),
(626, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6c872bfe-ad38-44f0-bfd1-21ee8e7c3248', '2014-06-12', '1'),
(627, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '85da3690-2da5-4463-a0d2-59395cab270d', '2014-06-12', '1'),
(628, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '47a509a0-8b69-447a-af70-eda282bba6a2', '2014-06-12', '1'),
(629, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0d8a202f-c42e-4f49-be20-6c8995e7e4a9', '2014-06-12', '1'),
(630, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b96bd0ed-70a7-4d5d-a506-0eeb50e6292d', '2014-06-12', '1'),
(631, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '91c6aea8-3289-4cd1-8c74-3d9a06bc1863', '2014-06-12', '1'),
(632, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '68c082ed-d86a-4841-bbb7-5dd04c3a48cd', '2014-06-12', '1'),
(633, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '22c3950d-8387-48fd-9591-7c0e5eee5c1d', '2014-06-12', '1'),
(634, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '99a8776a-b0ae-4404-8c10-72fb724e54c0', '2014-06-12', '1'),
(635, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e0b609f3-fdfe-4776-a027-9829ec80fb4d', '2014-06-12', '1'),
(636, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '814dfcd1-5b99-41e5-9abf-101d96e9f0e3', '2014-06-12', '1'),
(637, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3aa0de2b-d9b1-478a-8b90-bec5bc3cd4f5', '2014-06-12', '1'),
(638, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd2798c92-9dca-4e26-8136-4f0f89c1efcc', '2014-06-12', '1'),
(639, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '55552230-3f2a-411d-a890-b3ac14737828', '2014-06-12', '1'),
(640, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd121c573-5342-43ac-80b4-3bf41b320cb2', '2014-06-12', '1'),
(641, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7bdac04d-e506-4416-b4ea-0ab1b9d5bc8d', '2014-06-12', '1'),
(642, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1b558127-b367-4ab1-a3a4-0d39608b85a7', '2014-06-12', '1'),
(643, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a860921c-3f25-4391-b3b1-1a966f55b2b4', '2014-06-12', '1'),
(644, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'af5aba57-768e-466e-8926-06d16960f18a', '2014-06-12', '1'),
(645, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd176ba28-c6b3-4d09-8275-3b8eb20327b7', '2014-06-12', '1'),
(646, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '86ae14ad-0fa6-4ff4-ae5b-a764b21a1f86', '2014-06-12', '1'),
(647, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'de1f2b3a-3c84-4fec-ac64-2af02333545b', '2014-06-12', '1'),
(648, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a69747d1-dd95-487e-bc5a-f9b81dee11cb', '2014-06-12', '1'),
(649, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '827a1ba3-5f84-4671-8632-e3062d2a1bcf', '2014-06-12', '1'),
(650, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '61e7c471-db09-479f-8ab8-f3f7a42b99c6', '2014-06-12', '1'),
(651, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9e0205d1-e257-470d-93e0-4f30f51251c7', '2014-06-12', '1'),
(652, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5ae66193-2721-4b75-9974-59ec31638b63', '2014-06-12', '1'),
(653, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2962849f-fc4b-461d-bd00-1e1b0b22abc2', '2014-06-12', '1'),
(654, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '65f287cf-65a6-46fc-9c92-7672b5e37ebe', '2014-06-12', '1'),
(655, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f02452b2-9958-445e-a67d-15cb309bc007', '2014-06-12', '1'),
(656, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cc8ebe6e-50c4-444c-af3e-6db90e6f30f8', '2014-06-12', '1'),
(657, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c3b4d98f-c8af-435c-a1a6-8aca914ec3f9', '2014-06-12', '1'),
(658, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1954e720-a219-47be-a772-d3ca7ac79071', '2014-06-12', '1'),
(659, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'de767f41-6e20-4f6f-b27f-c34416dfcc7a', '2014-06-12', '1'),
(660, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '80f22979-838e-45ea-8abf-8b82c4141a7e', '2014-06-12', '1'),
(661, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '62a1a02f-9154-4202-aa73-ade08a019110', '2014-06-12', '1'),
(662, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a1624c0e-f5e5-49c6-b746-1b5b973f21ff', '2014-06-12', '1'),
(663, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dacb94af-499d-4840-8905-09f7974b7123', '2014-06-12', '1'),
(664, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '565c1a6e-5ad3-4be0-a515-1ffea37be35b', '2014-06-12', '1'),
(665, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '21204683-0c80-4fd8-8f7c-c2410cd312f5', '2014-06-12', '1'),
(666, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6bd0fc24-af0e-4f01-9f01-39f207182cee', '2014-06-12', '1'),
(667, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6b295988-55ed-4b32-b43f-f909d547af18', '2014-06-12', '1'),
(668, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8861b536-e6bb-4f36-bdbd-95b99fa0e297', '2014-06-12', '1'),
(669, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'db905542-c4ce-4536-9aef-652959c8e11b', '2014-06-12', '1'),
(670, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd941188d-eea9-4ab3-9554-cefe71c63e12', '2014-06-12', '1'),
(671, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c1e5c410-6229-43a4-b653-d9df2ccb5d89', '2014-06-12', '1'),
(672, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1109551a-2a2a-46c4-880c-b35d448a3244', '2014-06-12', '1'),
(673, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8ff8bdda-3024-4796-9c8c-2d0f72940e7a', '2014-06-12', '1'),
(674, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5580975b-9333-4386-a56c-4501f479aa37', '2014-06-12', '1'),
(675, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fac0ae9d-ab68-4265-8c29-727926bdb0c4', '2014-06-12', '1'),
(676, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4a38d0e1-9c85-4331-bbdc-fd44eff5070d', '2014-06-12', '1'),
(677, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '76ab4f56-1cd5-46ca-bebe-3ce056ac8f60', '2014-06-12', '1'),
(678, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e07de94e-0745-4d30-8bc8-5f02e1c58d72', '2014-06-12', '1'),
(679, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c179bfff-ae56-480b-b72e-5f0c37f02d8f', '2014-06-12', '1'),
(680, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fbb60e30-cc2e-4578-889e-2b9feba90e7a', '2014-06-12', '1'),
(681, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '94c31f49-2c1e-447c-8d96-925bf9b014c4', '2014-06-12', '1'),
(682, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '219bec3a-3937-4840-9502-6c05a375c5da', '2014-06-12', '1'),
(683, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'be66221f-7d70-4903-a40e-d3973e787ad3', '2014-06-12', '1'),
(684, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0eed2922-8564-413a-ae12-527813c9ae4c', '2014-06-12', '1'),
(685, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ab932cc8-3e90-4477-851c-e0ae39e99f53', '2014-06-12', '1'),
(686, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6f20b79b-9bf0-4e6c-9779-5e8d62f7c5de', '2014-06-12', '1'),
(687, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c90da18a-195e-4e8b-992f-de2dbeac8d20', '2014-06-12', '1'),
(688, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ae53617e-fbab-40ff-a304-bf34bab784f8', '2014-06-12', '1'),
(689, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fdcc8d2b-8ba6-4c88-a903-fd362b5de3a9', '2014-06-12', '1'),
(690, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2bc5e878-e991-41b7-9861-f95d13a66fac', '2014-06-12', '1'),
(691, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '62cd09cd-f280-49b1-8f0f-ca4ed0c7d668', '2014-06-12', '1'),
(692, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '64277fcf-0219-4282-ba81-d89a3e5d0af8', '2014-06-12', '1'),
(693, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e246c629-2ca2-47ef-b16f-f2898379108d', '2014-06-12', '1'),
(694, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '65a22b09-f423-4c2c-8a03-797e45573b52', '2014-06-12', '1'),
(695, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4b02b200-c1f5-4827-8a3e-95f521694c06', '2014-06-12', '1'),
(696, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '12746051-1c97-4ea0-86b3-2d34d24ac3b5', '2014-06-12', '1'),
(697, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a45c82a7-eca3-4803-8712-6a9a79c74d4f', '2014-06-12', '1'),
(698, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1acd1dcc-e4c6-4cce-b475-a2c7aba9716d', '2014-06-12', '1'),
(699, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'eb87754c-e2c8-4fb2-813e-942d55b17a0d', '2014-06-12', '1'),
(700, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cf8236c6-0b18-46c7-904b-bcbbcd93aea4', '2014-06-12', '1'),
(701, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '77fb8d02-c905-4f55-aa18-15c7007c4218', '2014-06-12', '1'),
(702, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dab33117-ca13-408a-a018-b7b7be701319', '2014-06-12', '1'),
(703, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f3d01d97-3bed-4026-946d-4a554f8ccfb4', '2014-06-12', '1'),
(704, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7e202852-f598-4ea3-b5f1-bc4fe144a980', '2014-06-12', '1'),
(705, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1b4ae1a1-0825-4eb1-9f16-9ff55b64b523', '2014-06-12', '1'),
(706, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4aad9c7b-7466-47ef-8df5-d4b167f00311', '2014-06-12', '1'),
(707, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6f1e425d-7f33-4790-bab1-86772840199f', '2014-06-12', '1'),
(708, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9fc5ae4b-793a-4387-8548-3c774a8c0de9', '2014-06-12', '1'),
(709, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fbf66896-bd44-4d2a-bc88-64d60fded412', '2014-06-12', '1'),
(710, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0514132c-f514-49f9-b03f-cda513e5dfea', '2014-06-12', '1'),
(711, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a3157e0f-1278-4d76-b846-609f5b21c98d', '2014-06-12', '1'),
(712, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7ba9e4ee-d8e5-4ab9-8d48-076fbd79bfc7', '2014-06-12', '1'),
(713, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1f0b8a9f-8581-4bf1-a76b-6e169f984e83', '2014-06-12', '1'),
(714, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8a4ab35c-6601-4c69-b979-40f994888fd2', '2014-06-12', '1'),
(715, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9cbb05aa-03ea-4c1f-a58c-2e691d5e4c3f', '2014-06-12', '1'),
(716, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '30a610fb-ca22-43dc-b612-0af16305ba1b', '2014-06-12', '1'),
(717, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f68ceb29-0775-496b-bb8a-73f8c0ac0c14', '2014-06-12', '1'),
(718, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '635f9616-9d78-4547-9dc5-d54c12caafdc', '2014-06-12', '1'),
(719, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e7838705-b580-4dbe-8820-0b15738d3eb2', '2014-06-12', '1'),
(720, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b26f5823-cf73-4e97-a708-583bfde4b567', '2014-06-12', '1'),
(721, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '38616297-dfc5-46f6-b10e-ba57d788b526', '2014-06-12', '1'),
(722, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2a482002-8431-470f-85ca-8fe242893734', '2014-06-12', '1'),
(723, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c2dcc49e-d2c1-4101-8f54-4cfb2512cfc8', '2014-06-12', '1'),
(724, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5bacaac3-9dfb-4269-8d52-b6bb3ceb63fe', '2014-06-12', '1'),
(749, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0ffdc0de-925b-4f36-93d8-844d7af5e3cd', '2014-06-12', '1'),
(750, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '79034189-9629-44f5-b6da-3d0cb5b3cd48', '2014-06-12', '1'),
(751, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dadd6ba2-6de0-4d92-85e1-a89e45f8caa1', '2014-06-12', '1'),
(752, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a1bfb076-591d-4643-91a4-0913a1d0890b', '2014-06-12', '1'),
(753, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '729e7c7d-221a-4ad8-a9a2-371fbaae934a', '2014-06-12', '1'),
(754, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2f13c948-4afd-4bb8-b48d-ae917d7b5485', '2014-06-12', '1'),
(755, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3daa66bf-977b-428f-a0cd-179ece380c29', '2014-06-12', '1'),
(756, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'eae6bfa4-36d9-4510-ac0d-d0077db7bfba', '2014-06-12', '1'),
(757, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd3aebec7-a710-40f0-8786-27666803048f', '2014-06-12', '1'),
(758, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b554c8ac-bf33-4d14-999d-4f04506afa74', '2014-06-12', '1'),
(759, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '340d9b72-a030-497d-8f2b-5282c7a12523', '2014-06-12', '1'),
(760, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b6483427-9db0-44a9-992f-7a99131406bb', '2014-06-12', '1'),
(761, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '09af95a3-3abd-4f73-8e58-dcb09a57ab5c', '2014-06-12', '1'),
(762, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f3c2a313-ed28-4ef3-9e64-9bc9d60dd0e0', '2014-06-12', '1'),
(763, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '93339685-e213-40c6-8237-2d24c4a05c63', '2014-06-12', '1'),
(764, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5ce7513e-1f37-4e53-87f6-e5a886e646b2', '2014-06-12', '1'),
(765, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '12c52f24-9cea-42ac-9aa3-51abc501eb11', '2014-06-12', '1'),
(766, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9139c7fa-e284-47e9-9360-206aab4e0e84', '2014-06-12', '1'),
(767, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '846c4588-44c1-4c3d-b533-26943a22410c', '2014-06-12', '1'),
(768, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5e0b07c7-5783-4f8f-8277-72261ea9f4cf', '2014-06-12', '1'),
(769, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '03556770-c2cf-4149-84c7-0ad38c067634', '2014-06-12', '1'),
(770, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '708049f6-f62a-4d21-b810-ca13900add45', '2014-06-12', '1'),
(771, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e74063a9-4d13-4b95-b019-2c3524b10324', '2014-06-12', '1'),
(772, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '539d96c6-81cd-4d99-bcf2-b962f71e15bb', '2014-06-12', '1'),
(773, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cab16af5-61d7-41e6-b60b-37093e184a95', '2014-06-12', '1'),
(774, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '96e7927f-9439-4178-8403-d99c0d06a937', '2014-06-12', '1'),
(775, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dbe0658f-e817-4192-bf4b-c736cb9628f1', '2014-06-12', '1'),
(776, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6ec4b144-07d0-4911-91ce-11fcc4588812', '2014-06-12', '1'),
(777, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4422afd1-e8f8-4a96-ba0c-4f6eefb4ee3f', '2014-06-12', '1'),
(778, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a98b8bc3-1746-4e73-ab7f-511eaf34fc9d', '2014-06-12', '1'),
(779, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '709c0fd9-8e7c-4a69-94da-60bf03913d26', '2014-06-12', '1'),
(780, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3b52123e-7d81-4f5a-aa8c-ced66a90a589', '2014-06-12', '1'),
(781, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8c459d3f-e3bd-4c22-aef8-988a2f33224c', '2014-06-12', '1'),
(782, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2d4c0373-f653-440b-b484-5b2d3099cfb2', '2014-06-12', '1'),
(783, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5222303f-002f-4c63-9ff7-8886e357b8f8', '2014-06-12', '1'),
(784, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '44d7583c-87ce-4008-86f9-b8491ab97306', '2014-06-12', '1'),
(785, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ea584caf-fcf8-42b9-8341-6cee14d82043', '2014-06-12', '1'),
(786, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6c5974cd-d812-4f23-90da-469c1eae04fa', '2014-06-12', '1'),
(787, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '971779c8-826d-4631-9582-b56ce516924e', '2014-06-12', '1'),
(788, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '08b7f3a3-8c11-4f0f-9214-fdec10611aa2', '2014-06-12', '1'),
(789, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '42971a78-98ab-43b7-b54d-01f2f9af19ca', '2014-06-12', '1'),
(790, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c8cce8c2-f65e-428c-9771-7e71e302fc9a', '2014-06-12', '1'),
(791, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '864a0154-c6b0-4c28-8b6e-68626647a42a', '2014-06-12', '1'),
(792, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '64fb4124-2fa7-40bd-a0c7-e281c424a3c9', '2014-06-12', '1'),
(793, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '65622eb7-4e4b-4e51-b08c-b0f7447b8a86', '2014-06-12', '1'),
(794, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9fd372e8-c418-49fd-ae07-ba6bedf879d3', '2014-06-12', '1'),
(795, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '97725903-c30d-4501-91d7-829e06749c84', '2014-06-12', '1'),
(796, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3bbdabe4-4b59-4fd6-9363-c37ed2353878', '2014-06-12', '1'),
(797, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '908cf78e-3b6e-48b9-9d23-c5bf933a3d06', '2014-06-12', '1'),
(798, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ba6338a0-506b-4efb-b7b4-5efa932e135d', '2014-06-12', '1'),
(799, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7ca5f0fd-c634-4eda-94be-c2d9d26a456b', '2014-06-12', '1'),
(800, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e061d97a-f251-4cac-a758-ec6c6b1342ea', '2014-06-12', '1'),
(801, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '56038aec-38c7-4066-885d-98cc9608c971', '2014-06-12', '1'),
(802, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '80fd430f-983d-456d-9d24-825114a341a3', '2014-06-12', '1'),
(803, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1f717ce6-639b-43a1-9f7d-33c46bac4a2b', '2014-06-12', '1'),
(804, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ee05f467-4e6e-4598-bfdf-715a088402a4', '2014-06-12', '1'),
(805, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '343897d0-0a3f-4a5c-86c4-d4a2534b6a4e', '2014-06-12', '1'),
(806, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ca9be5ed-c9bd-44b6-90cf-c6f648da3659', '2014-06-12', '1'),
(807, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5889353c-846e-47dc-9739-964cb3887b60', '2014-06-12', '1'),
(808, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8822e70a-7870-498c-982a-a5f70a5e0250', '2014-06-12', '1'),
(809, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2b5d35ce-880d-4847-a8c6-8fc032540467', '2014-06-12', '1'),
(810, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9db0bb19-f500-4c01-9936-79ca95caef3f', '2014-06-12', '1'),
(811, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '599e4c18-c46c-4087-a081-8be399f40189', '2014-06-12', '1'),
(812, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '585cffe6-d0a0-472e-a6aa-4fedefab7895', '2014-06-12', '1'),
(813, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '64ac3560-8327-42ce-9514-70493b64ee00', '2014-06-12', '1'),
(814, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6322b482-1171-4384-bb2d-9139b8fd74eb', '2014-06-12', '1'),
(815, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3e05f85d-ea79-446c-acac-ffd14f209ff5', '2014-06-12', '1'),
(816, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'da562306-cd8d-49f7-98d4-f7e9ed6c0526', '2014-06-12', '1'),
(817, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0402528c-c643-4021-9736-d0aa2f1efd57', '2014-06-12', '1'),
(818, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fe38c3fc-af37-46dc-ae48-8c9e14b60391', '2014-06-12', '1'),
(819, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c003b776-d894-42f8-b42b-73d1bff8f9b7', '2014-06-12', '1'),
(820, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cc003d9b-0ab1-43ca-a666-277269478f3f', '2014-06-12', '1'),
(821, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3e787f18-91c9-478e-a1dc-6343266cecbf', '2014-06-12', '1'),
(822, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9c9ba40e-3195-4750-8f6f-26ae58d57571', '2014-06-12', '1'),
(823, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '699a6bbe-1dd0-4fc1-ac07-df37b55290db', '2014-06-12', '1'),
(824, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fc27ca73-bb0c-41fa-b6a6-8188cd731873', '2014-06-12', '1'),
(825, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9dae2ec2-d759-46aa-971f-2352a8fe7e6a', '2014-06-12', '1'),
(826, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '51a40c03-f4e9-4f5e-8002-ebcc05b90d77', '2014-06-12', '1'),
(827, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '40b02e73-9a0b-4fca-952e-63f57434a575', '2014-06-12', '1'),
(828, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '95e5cb6c-32b2-4738-94da-ff308fc102d9', '2014-06-12', '1'),
(829, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e92b393c-10c4-41c6-96c0-7027690caee1', '2014-06-12', '1'),
(830, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4d2fced2-84a0-409f-a5f6-4d4bbaa6e60f', '2014-06-12', '1'),
(831, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3256c1a0-9500-4904-a785-e9d6e7044e82', '2014-06-12', '1'),
(832, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '63e14254-a508-453c-8bd1-94a86ba52954', '2014-06-12', '1'),
(833, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '10d01e9b-d5d0-417b-8485-76ccec51355d', '2014-06-12', '1'),
(834, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b11d219a-c109-4d2e-940f-ad607cf4d416', '2014-06-12', '1'),
(835, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'eabc85ef-dea1-43ad-b429-5b9775c46387', '2014-06-12', '1'),
(836, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6eb0d1eb-a722-4940-83a0-0140ffa71299', '2014-06-12', '1'),
(837, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0ff11d28-4796-4313-8b02-80f3e0a3f8f8', '2014-06-12', '1'),
(838, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0b20e13c-1af2-4044-8a92-517dd1b77a2d', '2014-06-12', '1'),
(839, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '69540b3d-2653-4531-b810-02d429a10a76', '2014-06-12', '1'),
(840, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '59c167f2-4bea-42f3-9aa6-69d443e73b60', '2014-06-12', '1'),
(841, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f5f89ac7-9fd3-4ea9-a68d-3487bcfacb2b', '2014-06-12', '1'),
(842, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '19c92647-3908-4b52-bcf7-5fc3db2c1654', '2014-06-12', '1'),
(843, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'eaee9247-d2ac-4bb7-bbf5-552ab0b622a5', '2014-06-12', '1'),
(844, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8c5c7360-2245-496b-a74c-8476ec2c831b', '2014-06-12', '1'),
(845, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bb6f8b85-b4f8-4718-b994-dee14302040a', '2014-06-12', '1'),
(846, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8962f183-ba92-4acb-8255-cdef25fc9404', '2014-06-12', '1'),
(847, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '039f425f-64c7-4493-9d3f-999554f4c997', '2014-06-12', '1'),
(848, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7e98f3e4-9788-47b8-99ea-3bacc91ec191', '2014-06-12', '1'),
(849, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4298ac62-89a1-49b6-9193-76f1585e4f37', '2014-06-12', '1'),
(850, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5ce27821-659d-4616-b347-b1b3b60f2653', '2014-06-12', '1'),
(851, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a7535236-a27f-4c0b-ad3a-dbd910f91e37', '2014-06-12', '1'),
(852, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ac7d4149-0516-4b88-8059-4118f9d78a9c', '2014-06-12', '1'),
(853, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c2dfdae6-9761-4610-b9ec-c62ca625ecc3', '2014-06-12', '1'),
(854, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f9a718fd-8dff-459e-bde9-e88a70e095a1', '2014-06-12', '1'),
(855, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '31788ab2-3c26-4a98-8d43-fb92e4cf5a1c', '2014-06-12', '1'),
(856, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1e7676bf-5969-4eb3-8029-ec2c06b2963b', '2014-06-12', '1'),
(857, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b5a56c41-387b-43ef-9bdc-8e50a4e737d4', '2014-06-12', '1'),
(858, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '12cf96fb-feb4-4c8e-9876-a2a8aa986183', '2014-06-12', '1'),
(859, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '04f75409-9af1-42c7-bb8f-c27478af612c', '2014-06-12', '1'),
(860, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2c3bdc62-c174-493c-8468-2371d97c99c7', '2014-06-12', '1'),
(861, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2d2ac4f9-17ad-4f75-8fbd-ed3d9f1b7a31', '2014-06-12', '1'),
(862, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e4e9aa51-8162-44cc-94a7-de569e06b9a0', '2014-06-12', '1'),
(863, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '70f24eee-2620-45e6-bfe4-83c2cf820103', '2014-06-12', '1'),
(864, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b147c9ee-4f6c-444c-8cab-f85e199b37a0', '2014-06-12', '1'),
(865, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8a2f2df7-9ad7-4222-adf7-1fbfe3ce5117', '2014-06-12', '1'),
(866, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '29af1476-ea62-4895-9ba1-0313c5d0cef1', '2014-06-12', '1'),
(867, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7e1ee565-f094-4491-b31a-3d40a8405044', '2014-06-12', '1'),
(868, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd5d496d6-80d8-4aa0-95ea-7c86de080dc9', '2014-06-12', '1'),
(869, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9badbafe-0d35-4d3e-a513-1e563e78befd', '2014-06-12', '1'),
(870, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6cae5280-5ec7-4455-b633-b13b152fd2cc', '2014-06-12', '1'),
(871, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '06d80948-b5be-4f5c-9836-4bbdcc0bd66a', '2014-06-12', '1'),
(872, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '73184c54-28a5-4c76-95fb-49b284904dd1', '2014-06-12', '1'),
(873, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fba700dc-9398-4b41-8487-7565f8678a9a', '2014-06-12', '1'),
(874, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2cbee896-8b70-4fcd-8ead-d303646639e5', '2014-06-12', '1'),
(875, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7b626bd1-0a91-4228-ae63-3d22e912ca26', '2014-06-12', '1'),
(876, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fa826071-cc19-4220-b34c-3cad6673414a', '2014-06-12', '1'),
(877, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2e6d9e56-1a0b-4a9f-af53-d40bee1daafd', '2014-06-12', '1'),
(878, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '989c48e3-93f0-426f-8f4b-28009b6e773f', '2014-06-12', '1'),
(879, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f0eaf362-b678-4988-ba83-d22dad586a0d', '2014-06-12', '1'),
(880, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b25348fd-5e69-4a86-a548-de4656429a17', '2014-06-12', '1'),
(881, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e14144ff-bfc3-47c9-86c6-d3fa32eea7f7', '2014-06-12', '1'),
(882, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '70f7ac9a-bdbc-46b5-8c3b-3dcd32620d52', '2014-06-12', '1'),
(883, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '95cffdb7-fe99-400c-8d35-b3363e0431ab', '2014-06-12', '1'),
(884, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e20eebcf-3773-4003-902e-d09b17f660eb', '2014-06-12', '1'),
(885, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '33760849-02ea-4b6d-b76a-52eafa4b8f9a', '2014-06-12', '1'),
(886, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '432c584c-8916-4f27-ba53-d8703bdea257', '2014-06-12', '1'),
(887, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3b230200-18b0-4b07-a473-bd2d7f17bdb0', '2014-06-12', '1'),
(888, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1c360921-c002-4ee0-80c5-dfd8afe643d9', '2014-06-12', '1'),
(889, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6aec0214-b42b-442a-9116-b3181779a912', '2014-06-12', '1'),
(890, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ae5d2461-048e-4257-bf9d-49139e725295', '2014-06-12', '1'),
(891, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0b77a344-be7f-450a-bcff-ec060fcab918', '2014-06-12', '1'),
(892, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8bfd26e6-6744-48dc-b7aa-ac0f046ee976', '2014-06-12', '1'),
(893, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dbbd8e13-b746-468e-943f-8a9aef19ac84', '2014-06-12', '1'),
(894, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '152daec2-5210-4fd0-8bb5-35e8e567e8d4', '2014-06-12', '1'),
(895, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9928f403-1b07-45ba-bb1c-61b01f1852cf', '2014-06-12', '1'),
(896, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '6563f3f8-3b93-4ee1-a76b-5e05008f4843', '2014-06-12', '1'),
(897, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f3bb03b2-ab02-4d20-88e3-d69333a13288', '2014-06-12', '1'),
(898, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ac44a7a5-fadc-420e-8f53-bda22ac1682b', '2014-06-12', '1'),
(899, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3a790131-acf4-4126-a5cc-56d30bfe330d', '2014-06-12', '1'),
(900, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5d2ca27d-9e75-4181-ba67-0b6907fcb6ad', '2014-06-12', '1'),
(901, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '02f75fac-9694-4e64-9f63-4ef9956f27ac', '2014-06-12', '1'),
(902, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd8f8d4c0-82c0-4ee4-a0c6-5918b5cdea1d', '2014-06-12', '1'),
(903, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0b0af33e-06b2-4894-bf8f-35e7882423ff', '2014-06-12', '1'),
(904, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e1e486de-c9ed-49bf-950a-5d8f10c36dbb', '2014-06-12', '1'),
(905, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '093bd47f-3511-4f15-882d-b1d17e560132', '2014-06-12', '1'),
(906, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2d90100e-9a37-43e6-9f7d-b8118783d035', '2014-06-12', '1'),
(907, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b8cd5dfd-3e86-4320-8abe-73338ba4f9c9', '2014-06-12', '1'),
(908, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'adad6eda-1578-4a84-b528-d2e41ce60c2d', '2014-06-12', '1'),
(909, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'da66a5cc-ddf4-4080-a66b-94f6be66cda9', '2014-06-12', '1'),
(910, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ac2d58c0-80c5-457a-9ba7-411ca78066f2', '2014-06-12', '1'),
(911, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e9e18ba6-a24e-4be6-8b38-2d5995fc9f41', '2014-06-12', '1'),
(912, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e67938c5-13a8-4ea0-a0c5-7ee83312a9d5', '2014-06-12', '1'),
(913, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '12b3fe8d-c674-4879-8418-d1c65900fe2b', '2014-06-12', '1'),
(914, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'defddf30-b5a9-4d11-b858-302918302b58', '2014-06-12', '1'),
(915, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4488a538-31a8-4967-b72e-4ade976913f3', '2014-06-12', '1'),
(916, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd3f0bbf0-2886-4f8c-8c1c-c4ed9870ed9f', '2014-06-12', '1'),
(917, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ff97f4bb-3686-415f-b686-497fcb06e323', '2014-06-12', '1'),
(918, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'aed7eabf-2300-4d1a-9d4c-15e2fca495d4', '2014-06-12', '1'),
(919, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd2a221dd-168a-4e04-b0af-29aa5d9bddcb', '2014-06-12', '1'),
(920, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4ad0930b-a832-468c-a917-d84a2a0423dc', '2014-06-12', '1'),
(921, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f3f5ff66-1ae3-42f4-b51b-a8cd7bcd3b7d', '2014-06-12', '1'),
(922, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '649c9072-6c6a-43fd-b4db-25ec715adb40', '2014-06-12', '1'),
(923, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '0c4ecc6d-3268-444c-aad7-6c93cb189a94', '2014-06-12', '1'),
(924, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '394e1c4e-065a-442c-85f4-111efe022b0c', '2014-06-12', '1'),
(925, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd6269a15-e210-4b46-a982-2f4085ee074e', '2014-06-12', '1'),
(926, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4533c566-c70d-4c5f-befa-f925f82213c4', '2014-06-12', '1'),
(927, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7650c7bd-83a2-4770-96f9-9535e837b56c', '2014-06-12', '1'),
(928, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '179ff709-a0d0-4006-bb3c-b4882e68f089', '2014-06-12', '1'),
(929, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '255b2ec6-71d0-483d-8531-60123e75ec90', '2014-06-12', '1'),
(930, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '34d51b71-f30c-48ad-a0b9-8366f87baf4f', '2014-06-12', '1'),
(931, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8cbf3c18-fc71-4c7c-b58c-07840c86410b', '2014-06-12', '1'),
(932, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8035780d-ad9a-4295-9301-ed2fbd436bf2', '2014-06-12', '1'),
(933, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a4c11b8d-3bd6-493b-9128-7d26ed725396', '2014-06-12', '1'),
(934, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd9e5284f-bded-4638-a94c-f457f515f879', '2014-06-12', '1'),
(935, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '1f7049d2-c4a8-44ac-afac-ce840a7d3bb8', '2014-06-12', '1'),
(936, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f1101dd2-860b-4096-aff0-422ebadcba93', '2014-06-12', '1'),
(937, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cdb4d115-7816-4154-8cb2-a873ebe66323', '2014-06-12', '1'),
(938, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '322e0a04-acfe-467f-a338-6b0481030574', '2014-06-12', '1'),
(939, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd39cd1fb-1023-4fcc-935c-6d1dfa2af628', '2014-06-12', '1'),
(940, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c378e3e8-41ef-43ec-88b2-41baa6793a8b', '2014-06-12', '1'),
(951, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '144f5dc9-647c-4892-8897-8618e6daba06', '2014-06-13', '1'),
(952, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fa2ea91a-6ff8-43d4-a47c-feb74ba06040', '2014-06-13', '1'),
(953, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e6b0e136-d952-4040-b2f5-daf75e7fd6b0', '2014-06-13', '1'),
(954, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fbbcf365-1103-4c5a-aa07-40a02e15f915', '2014-06-13', '1'),
(955, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '912511a1-1cae-4d9f-a7ff-ccc1f98be3a6', '2014-06-13', '1'),
(956, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4d3a60eb-ed22-4d4c-871c-a02f16da0f37', '2014-06-13', '1'),
(957, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e39e30dc-27c4-4b6b-a427-07dacab68a0a', '2014-06-13', '1'),
(958, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3961f1df-2ba8-4f51-9216-aa415e2d6588', '2014-06-13', '1'),
(959, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '16e4480f-ac06-4b63-ac30-31889cc12dc7', '2014-06-13', '1');
INSERT INTO `sys_roles_authorities` (`id`, `role_code`, `auth_code`, `create_date`, `status`) VALUES
(968, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9080e5ed-7546-47f2-8056-88485b24ee43', '2014-06-13', '1'),
(969, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a2147435-aeab-4522-a846-4429ddbcd8e8', '2014-06-13', '1'),
(970, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '24ead831-c6b7-420d-a1e1-617e12591eda', '2014-06-13', '1'),
(971, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '61978f0b-24d5-47ce-88dc-18b2cf1d6006', '2014-06-13', '1'),
(972, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '91930c1b-2009-4bcd-901e-4e938fa34372', '2014-06-13', '1'),
(973, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ebfff3cf-d6d7-4eae-bde3-df6cf77a00b9', '2014-06-13', '1'),
(974, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ddfdff0e-6d32-4331-90a7-ba3916c93ee6', '2014-06-13', '1'),
(975, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2827dc34-8f87-48f2-94fd-e1b42361a07f', '2014-06-13', '1'),
(976, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c46beae7-1b20-4b95-8298-6c119903e452', '2014-06-15', '1'),
(977, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '788bdeac-a716-4a8b-9d4d-6a733baf855b', '2014-06-15', '1'),
(978, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2961bbfd-06ed-4113-b8fe-7ca481e61b55', '2014-06-15', '1'),
(979, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3ee0c701-ce2a-4cc8-8772-063a0e67d9c6', '2014-06-15', '1'),
(980, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '694c4303-2f5e-4580-b61d-8873020792d7', '2014-06-15', '1'),
(981, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dfc3ec53-6934-47da-ae27-95399f2b13b7', '2014-06-15', '1'),
(982, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a770f79a-909d-4394-8043-be24979689d2', '2014-06-15', '1'),
(983, 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'da88797a-89e4-4096-ab9c-13f30a842939', '2014-06-15', '1');

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
