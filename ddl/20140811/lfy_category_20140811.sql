-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2014-08-11 11:40:44
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
-- 表的结构 `lfy_category`
--

CREATE TABLE IF NOT EXISTS `lfy_category` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(50) NOT NULL COMMENT '随机数编码CA时间戳4位数字',
  `category_name` varchar(100) DEFAULT NULL COMMENT '类别名称',
  `category_pcode` varchar(50) NOT NULL DEFAULT '0' COMMENT '节点父,订餐网站默认-1,微信默认-2',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间,修改时，更新时间',
  `create_opid` varchar(50) DEFAULT NULL COMMENT '创建人 id，为了方便，这里存放创建人姓名',
  `status` varchar(10) DEFAULT NULL COMMENT '状态0被删除,1正常',
  `categoryOrder` int(10) DEFAULT NULL COMMENT '排序,修改这里的值可以控制页面显示顺序',
  `show_name` varchar(100) DEFAULT NULL COMMENT '子标题名称',
  `categoryType` varchar(10) DEFAULT '备留字段',
  `category_rootcode` varchar(50) DEFAULT NULL COMMENT '根节点，备留字段',
  `image` varchar(50) DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `lfy_category`
--

INSERT INTO `lfy_category` (`id`, `category_code`, `category_name`, `category_pcode`, `create_date`, `create_opid`, `status`, `categoryOrder`, `show_name`, `categoryType`, `category_rootcode`, `image`) VALUES
(10, 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '充氮包装', '-1', '2014-04-09 21:39:42', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 0, '充氮包装', NULL, 'a943cdd3-5a80-4cdf-ba86-a681c981a174', NULL),
(11, '32842c97-7063-453e-a5c9-3b25670a7190', '鸭类产品', 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '2014-04-09 21:40:20', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 0, '鸭类产品', NULL, '32842c97-7063-453e-a5c9-3b25670a7190', NULL),
(13, 'd10db273-f25f-4a75-92cb-789a3db44af8', '素食产品', 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '2014-04-09 21:41:26', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 2, '素食产品', NULL, 'd10db273-f25f-4a75-92cb-789a3db44af8', NULL),
(14, 'bbd0415f-22bb-4204-bcad-4ed8c064f679', '其他产品', 'a943cdd3-5a80-4cdf-ba86-a681c981a174', '2014-04-09 21:41:51', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 3, '其他产品', NULL, 'bbd0415f-22bb-4204-bcad-4ed8c064f679', NULL),
(15, '03fc52c0-3d8c-4963-ad5b-f4bf36ee50e2', '优惠直通车', '-1', '2014-04-09 21:42:19', '8532aa11-08ae-444d-bb72-801f4f9997b6', '0', 1, '超值套餐', NULL, '03fc52c0-3d8c-4963-ad5b-f4bf36ee50e2', NULL),
(16, '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', '优惠直通车', '-1', '2014-04-09 21:42:46', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 1, '优惠直通车', NULL, '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', NULL),
(17, '2e3c4997-624c-409e-9e2d-d267d99b630a', '超值套餐', '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', '2014-04-09 21:42:59', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 0, '超值套餐', NULL, '2e3c4997-624c-409e-9e2d-d267d99b630a', NULL),
(18, '2d2fbc3f-b772-45ab-baa9-fea5ef5cc390', '散装系列', '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', '2014-04-09 21:43:30', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 1, '散装系列', NULL, '2d2fbc3f-b772-45ab-baa9-fea5ef5cc390', NULL),
(19, '1243cdd3-5a80-4cdf-ba86-a681c981a174', '鸭脖', '-2', '2014-04-09 21:39:42', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 0, '鸭脖', NULL, 'a943cdd3-5a80-4cdf-ba86-a681c981a174', 'prod1.jpg'),
(20, '23842c97-7063-453e-a5c9-3b25670a7190', '鸭锁骨', '-2', '2014-04-09 21:40:20', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 1, '鸭锁骨', NULL, '32842c97-7063-453e-a5c9-3b25670a7190', 'prod2.jpg'),
(21, '340db273-f25f-4a75-92cb-789a3db44af8', '鸭掌', '-2', '2014-04-09 21:41:26', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 2, '鸭掌', NULL, 'd10db273-f25f-4a75-92cb-789a3db44af8', 'prod3.jpg'),
(22, '45d0415f-22bb-4204-bcad-4ed8c064f679', '鸭翅', '-2', '2014-04-09 21:41:51', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 3, '鸭掌', NULL, 'bbd0415f-22bb-4204-bcad-4ed8c064f679', 'prod4.jpg'),
(23, '56fc52c0-3d8c-4963-ad5b-f4bf36ee50e2', '鸭舌', '-2', '2014-04-09 21:42:19', '8532aa11-08ae-444d-bb72-801f4f9997b6', '0', 4, '鸭舌', NULL, '03fc52c0-3d8c-4963-ad5b-f4bf36ee50e2', 'prod5.jpg'),
(24, '6746b025-dec8-46bb-a8f4-c8c1e46af2fa', '佛手', '-2', '2014-04-09 21:42:46', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 5, '鸭头', NULL, '7046b025-dec8-46bb-a8f4-c8c1e46af2fa', 'prod6.jpg'),
(25, '783c4997-624c-409e-9e2d-d267d99b630a', '鸭头', '-2', '2014-04-09 21:42:59', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', 6, '佛手', NULL, '2e3c4997-624c-409e-9e2d-d267d99b630a', 'prod7.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
