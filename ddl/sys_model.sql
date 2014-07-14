/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/6 liulili 11:41:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_model
-- ----------------------------
CREATE TABLE `sys_model` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `model_code` varchar(50) NOT NULL,
  `model_name` varchar(50) NOT NULL,
  `imgname` varchar(50) DEFAULT NULL,
  `model_title` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `sortValue` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sys_model` VALUES ('1', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '查找', 'icon-search', 'OpensearchWin', '2014-02-14', '1', '4');
INSERT INTO `sys_model` VALUES ('2', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '所有', 'icon-search', 'showAll', '2014-02-13', '1', '6');
INSERT INTO `sys_model` VALUES ('3', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '详情', 'icon-search', 'view', '2014-02-14', '1', '5');
INSERT INTO `sys_model` VALUES ('4', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '新增', 'icon-add', 'add', '2014-02-14', '1', '1');
INSERT INTO `sys_model` VALUES ('5', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '修改', 'icon-edit', 'edit', '2014-02-14', '1', '2');
INSERT INTO `sys_model` VALUES ('6', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '删除', 'icon-remove', 'del', '2014-02-14', '1', '3');
INSERT INTO `sys_model` VALUES ('7', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '运行', null, null, '2014-02-14', '1', '0');
