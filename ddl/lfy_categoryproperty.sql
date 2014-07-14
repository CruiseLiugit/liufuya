/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/9 ÐÇÆÚÈÕ ÏÂÎç 8:18:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for lfy_categoryproperty
-- ----------------------------
CREATE TABLE `lfy_categoryproperty` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `categoryProperty_code` varchar(50) NOT NULL,
  `category_code` varchar(50) NOT NULL,
  `property_code` varchar(50) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_opid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `lfy_categoryproperty` VALUES ('1', '888835f8-2716-31c2-83f2-4cd66ad75ehd', 'e0454206-120d-4c11-9b17-d0f96922b891', '9999bfbc-9d31-4d70-b8e8-36e05b1166fa', '0', '2014-03-07 21:43:19', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa');
INSERT INTO `lfy_categoryproperty` VALUES ('4', 'd17722f8-75a0-47c2-9c7a-5ccf60ab9355', 'e0454206-120d-4c11-9b17-d0f96922b891', '0c7d8bbd-b954-4cce-b2b7-6cc9ea9228a4', '0', '2014-03-07 23:12:12', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa');
INSERT INTO `lfy_categoryproperty` VALUES ('5', '40b67500-90b0-4d03-8054-9693cd79b02d', 'e0454206-120d-4c11-9b17-d0f96922b891', '9999bfbc-9d31-4d70-b8e8-36e05b1166fa', '0', '2014-03-07 23:18:22', '8532aa11-08ae-444d-bb72-801f4f9997b6');
INSERT INTO `lfy_categoryproperty` VALUES ('6', '5fe800e5-264d-4c94-9f59-4e53dd9e591f', 'e0454206-120d-4c11-9b17-d0f96922b891', '9999bfbc-9d31-4d70-b8e8-36e05b1166fa', '0', '2014-03-08 21:10:49', '8532aa11-08ae-444d-bb72-801f4f9997b6');
INSERT INTO `lfy_categoryproperty` VALUES ('7', 'bc6d81cd-a083-4f4a-a41c-2b17bef69aa5', 'e0454206-120d-4c11-9b17-d0f96922b891', '0c7d8bbd-b954-4cce-b2b7-6cc9ea9228a4', '0', '2014-03-08 21:10:49', '8532aa11-08ae-444d-bb72-801f4f9997b6');
INSERT INTO `lfy_categoryproperty` VALUES ('8', '119d35fb-9ba5-47cb-ace3-3b1d56ebaf3a', 'e0454206-120d-4c11-9b17-d0f96922b891', '9999bfbc-9d31-4d70-b8e8-36e05b1166fa', '0', '2014-03-08 22:07:25', '8532aa11-08ae-444d-bb72-801f4f9997b6');
INSERT INTO `lfy_categoryproperty` VALUES ('9', '8ed4fbdb-bf92-426f-802f-e03da1bb10b5', 'e0454206-120d-4c11-9b17-d0f96922b891', '0c7d8bbd-b954-4cce-b2b7-6cc9ea9228a4', '0', '2014-03-08 22:07:25', '8532aa11-08ae-444d-bb72-801f4f9997b6');
INSERT INTO `lfy_categoryproperty` VALUES ('10', '697aace5-74e8-402d-b7f7-931139981476', 'e0454206-120d-4c11-9b17-d0f96922b891', '9999bfbc-9d31-4d70-b8e8-36e05b1166fa', '1', '2014-03-08 22:17:14', '8532aa11-08ae-444d-bb72-801f4f9997b6');
INSERT INTO `lfy_categoryproperty` VALUES ('11', 'a247ced3-47b6-44ff-a3a1-2fa46bff4f08', 'e0454206-120d-4c11-9b17-d0f96922b891', '0c7d8bbd-b954-4cce-b2b7-6cc9ea9228a4', '1', '2014-03-08 22:17:14', '8532aa11-08ae-444d-bb72-801f4f9997b6');
