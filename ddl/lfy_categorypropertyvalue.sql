/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/9 ������ ���� 8:18:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for lfy_categorypropertyvalue
-- ----------------------------
CREATE TABLE `lfy_categorypropertyvalue` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `pv_code` varchar(50) NOT NULL,
  `categoryProperty_code` varchar(50) NOT NULL COMMENT '类目属性 外键',
  `PV_name` varchar(100) DEFAULT NULL COMMENT '性值属名称',
  `show_name` varchar(100) DEFAULT NULL COMMENT '般一和属性值名称相等',
  `PV_type` varchar(10) DEFAULT NULL COMMENT '属性值类型 1字符串 2价格区间',
  `PV_order` int(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `lfy_categorypropertyvalue` VALUES ('1', 'rrr7ced3-47b6-44ff-a3a1-2fa46bff4f08', 'a247ced3-47b6-44ff-a3a1-2fa46bff4f08', '100-200', '100-200', '2', '0', '1');
INSERT INTO `lfy_categorypropertyvalue` VALUES ('2', 'ccr7ced3-47b6-44ff-a3a1-2fa46bff4f08', 'a247ced3-47b6-44ff-a3a1-2fa46bff4f08', '200-300', '200-300', '2', '1', '1');
INSERT INTO `lfy_categorypropertyvalue` VALUES ('3', 'ec261c09-9329-461c-ad44-5d9d6be6952f', 'a247ced3-47b6-44ff-a3a1-2fa46bff4f08', '300-400', '300-400', '2', '1', '1');
