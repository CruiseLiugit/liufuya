/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/6 liulili 11:41:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
CREATE TABLE `sys_user_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(50) NOT NULL,
  `role_code` varchar(50) NOT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '8532aa11-08ae-444d-bb72-801f4f9997b6', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2014-02-15', '1');
INSERT INTO `sys_user_role` VALUES ('2', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2014-02-15', '1');
