/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/7 liulili 11:25:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_menus
-- status 1为正常，0被删除
-- ----------------------------
CREATE TABLE `sys_menus` (
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
) ENGINE=InnoDB;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sys_menus` VALUES ('1', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', '系统功能', '1', '0', 'A_SYSTEM', null, '2014-02-14', '1', '0');
INSERT INTO `sys_menus` VALUES ('2', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', '权限管理', '10', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', 'A_PRIVILEGE', null, '2014-02-14', '1', '0');
INSERT INTO `sys_menus` VALUES ('3', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '用户管理', '101', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_USERMANAGE', '/sysUserList', '2014-02-14', '1', '1');
INSERT INTO `sys_menus` VALUES ('4', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '角色管理', '102', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_ROLEMANGE', '/sysRoleList', '2014-02-16', '1', '2');
INSERT INTO `sys_menus` VALUES ('5', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '菜单管理', '103', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', 'A_MENUMANGE', '/sysMenusList', '2014-02-16', '1', '3');
INSERT INTO `sys_menus` VALUES ('6', '365c7266-8c4e-4d87-8dd6-09e46832349c', '用户模块管理', '2', '0', 'A_USERMODELMANAGE', '', '2014-02-18', '1', '1');
INSERT INTO `sys_menus` VALUES ('7', '170e9076-07df-448e-ad1a-a522756147be', '用户问题管理', '21', '365c7266-8c4e-4d87-8dd6-09e46832349c', 'A_USERQUESTIONMANAGE', '/jsp/questions/questions.jsp', '2014-02-18', '1', '0');
INSERT INTO `sys_menus` VALUES ('8', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '用户管理', '22', '365c7266-8c4e-4d87-8dd6-09e46832349c', 'A_PREUSERMANAGE', '/jsp/preUser/preUsers.jsp', '2014-02-18', '1', '0');
INSERT INTO `sys_menus` VALUES ('9', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', '产品管理', '3', '0', 'A_PRODUCTMANAGE', '', '2014-03-04', '1', '3');
INSERT INTO `sys_menus` VALUES ('10', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '类目管理', '31', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_CATEGORYMANAGE', '/jsp/category/category.jsp', '2014-03-04', '1', '0');
INSERT INTO `sys_menus` VALUES ('11', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '属性管理', '32', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_PROPERTYMANAGE', '/jsp/property/property.jsp', '2014-03-06', '1', '2');
INSERT INTO `sys_menus` VALUES ('12', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '类目属性管理', '33', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', 'A_CPMANAGE', '/jsp/property/categoryProperty.jsp', '2014-03-07', '1', '4');
