/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/6/03 门店管理表:门店类型、省份、地址、店员、经纬度
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for lfy_store_address
-- ----------------------------
CREATE TABLE `lfy_store_address` (
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
  `city_id` int(10)  NOT NULL COMMENT '城市id',
  `store_address` varchar(100) NOT NULL COMMENT '门店地址',
  `store_director` varchar(100) DEFAULT NULL COMMENT '主管姓名',
  `store_directorphone` varchar(100)  DEFAULT NULL COMMENT '主管电话',
  `store_assistant` varchar(100)  DEFAULT NULL COMMENT '店员姓名',
  `store_assistantphone` varchar(100)  DEFAULT NULL COMMENT '店员电话',
  `gps_lng` varchar(100) NOT NULL COMMENT '经度',
  `gps_lat` varchar(100) NOT NULL COMMENT '纬度',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- ----------------------------
-- Records
-- ----------------------------

















