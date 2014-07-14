/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/7 ������ ���� 11:25:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for lfy_category
-- ----------------------------
CREATE TABLE `lfy_category` (
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `lfy_category` VALUES ('1', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '服饰内衣', '-1', '2014-03-05 19:45:53', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '0', '服饰内衣', '', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd');
INSERT INTO `lfy_category` VALUES ('2', 'bcaf35f8-2716-31c2-83f2-4cd66ad75ehd', '女士上装', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-03-05 19:56:56', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '1', '女士上装', '', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd');
INSERT INTO `lfy_category` VALUES ('3', '2497e007-db3c-444d-9d84-5560f3acf6fc', '女士内衣', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-03-05 22:36:35', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '3', '女士内衣', null, '2497e007-db3c-444d-9d84-5560f3acf6fc');
INSERT INTO `lfy_category` VALUES ('4', '92e6b670-aa00-48df-8198-444a74be4f6b', '男士上装', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-03-05 22:41:55', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '6', '男士上装', null, '92e6b670-aa00-48df-8198-444a74be4f6b');
INSERT INTO `lfy_category` VALUES ('5', '888d03cb-00fb-4b19-9ba2-12b74a80e758', '美食特产', '-1', '2014-03-05 22:46:49', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '2', '美食特产', null, '888d03cb-00fb-4b19-9ba2-12b74a80e758');
INSERT INTO `lfy_category` VALUES ('6', 'a5b59db0-56fa-4b8e-b084-40924c2e8656', '休闲零食', '888d03cb-00fb-4b19-9ba2-12b74a80e758', '2014-03-05 22:47:34', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '3', '休闲零食', null, 'a5b59db0-56fa-4b8e-b084-40924c2e8656');
INSERT INTO `lfy_category` VALUES ('8', 'e0454206-120d-4c11-9b17-d0f96922b891', '衬衫', 'bcaf35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-03-06 19:48:04', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '0', '衬衫', null, 'e0454206-120d-4c11-9b17-d0f96922b891');
INSERT INTO `lfy_category` VALUES ('9', 'cded6ab1-f5e9-4a66-8f40-9220007c273c', '皮衣', 'bcaf35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-03-06 19:48:32', '8532aa11-08ae-444d-bb72-801f4f9997b6', '1', '1', '皮衣', null, 'cded6ab1-f5e9-4a66-8f40-9220007c273c');
