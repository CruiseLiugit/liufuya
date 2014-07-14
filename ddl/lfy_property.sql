/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/9 ������ ���� 8:18:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for lfy_property
-- ----------------------------
CREATE TABLE `lfy_property` (
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `lfy_property` VALUES ('1', '9999bfbc-9d31-4d70-b8e8-36e05b1166fa', '品牌', '1', '2', '品牌', '1', '2', '2014-03-06 22:12:49', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa');
INSERT INTO `lfy_property` VALUES ('2', '0c7d8bbd-b954-4cce-b2b7-6cc9ea9228a4', '价格区间', '2', '4', '价格区间', '1', '2', '2014-03-06 23:11:15', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa');
