/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/6  liulili 11:41:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
CREATE TABLE `sys_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `is_system` varchar(10) DEFAULT '0' COMMENT '否是是系统产生的，0否 1是 系统产生不能删除',
  `type` varchar(10) DEFAULT '0' COMMENT '0菜单角色 1数据角色',
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '系统管理员', '系统管理员', '1', '0', '2014-02-14', '1');
