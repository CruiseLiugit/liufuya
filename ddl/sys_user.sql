/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/6 liulili 11:41:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
CREATE TABLE `sys_user` (
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
) ENGINE=InnoDB;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '8532aa11-08ae-444d-bb72-801f4f9997b6', 'admin', '21232F297A57A5A743894A0E4A801FC3', '刘立立', '1149412346@qq.com', '18951106637', null, null, '2014-02-14', '1');
INSERT INTO `sys_user` VALUES ('2', 'fb2fbfbc-9d31-4d70-b8e8-36e05b1166fa', 'test1', '5A105E8B9D40E1329780D62EA2265D8A', '缪汉斌', '2345678@qq.com', '18914023646', null, null, '2014-02-15', '1');
