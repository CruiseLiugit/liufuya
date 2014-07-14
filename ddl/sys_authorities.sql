/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/7 liulili 11:25:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_authorities
-- ----------------------------
CREATE TABLE `sys_authorities` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `auth_code` varchar(50) NOT NULL,
  `is_menu` varchar(10) DEFAULT NULL COMMENT '是否是子菜单',
  `model_code` varchar(50) DEFAULT NULL,
  `menu_code` varchar(50) NOT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sys_authorities` VALUES ('1', 'k14f35f8-2246-41h2-34f2-4cg56ad75ead', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'd23f35b8-2716-41c2-84f2-4cd56bb75ebb', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('2', 'k24f35f8-2246-41h2-34f2-4cg56ad75ead', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'c23f35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('3', '855a5476-0d8d-4ccd-ac64-54ab2eef1fc7', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('4', 'fc9d19ee-3e51-4a1d-86b8-a043ec48b0a3', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('5', '26439706-7e39-4f8d-89f4-4f12aa2f8bda', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('6', '46b26d66-948f-4010-8e73-d87b99442d78', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('7', '632f97e9-e013-48ae-8171-5d15b7106f29', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('8', 'e498230e-bed9-41b4-8df4-2a96b128934a', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-14', '1');
INSERT INTO `sys_authorities` VALUES ('9', 'h2df30b8-2df6-41d2-84f2-4cd56bb75ecc', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'a23f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-15', '1');
INSERT INTO `sys_authorities` VALUES ('10', 'a3455654-dfdf-2345-sdfg-asdfghjdfger', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('11', 'bd455654-dfdf-2345-sdfg-asdfghjdfger', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('12', '34555654-dfdf-2345-sdfg-asdfghjdfger', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('13', '09895654-dfdf-2345-sdfg-asdfghjdfger', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('14', 'ijkl5654-dfdf-2345-sdfg-asdfghjdfger', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('15', 'ol055654-dfdf-2345-sdfg-asdfghjdfger', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('16', '33335654-dfdf-2345-sdfg-asdfghjdfger', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'f83f35f8-2716-31c2-83f2-4cd66ad75ehd', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('17', 'dfdfdfdf-2343-dfdf-dfdf-234325343', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('18', '7bh87y3-f34f-dfd3er-efre-3rf3r3r', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('19', 'wgtf4t4-dgrghrg-dgfrh5r-try4hy54y', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('20', 'dfdfefr4-4g4g4y-f4rt-t4-t4-t4t4t4t', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('21', 'cergr0-32-r3r-34t4gt54gy-3er4gt4r', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('22', 'dfdgfe4-grgrhth-34g4rht5rh5ju-f4g', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('23', 'dg9jf4gt4-f4gt4gy0f4gt-f4g45h54hy', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'abcd35f8-2716-41c2-83f2-4cd56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('31', '4a65d7c4-9b87-440e-9fd6-821d0d24c916', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'f251ebe3-d143-4826-a18c-5e055242b8a2', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('32', '3a9c90a6-1ce7-4867-90ce-e08a8a12a35c', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'f251ebe3-d143-4826-a18c-5e055242b8a2', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('33', '7b39cc3c-dfbb-4c4d-a52c-d28290b01815', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'f251ebe3-d143-4826-a18c-5e055242b8a2', '2014-02-16', '1');
INSERT INTO `sys_authorities` VALUES ('34', '487bc775-363e-4d26-bcb1-5bf95f398ef1', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '365c7266-8c4e-4d87-8dd6-09e46832349c', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('35', 'ab6fbf22-f158-4c71-bd6b-9566050122f6', '0', '0', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('36', '555423be-7abd-4b8b-b5e3-1c3b9ddba4fd', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('37', '31e17456-7f48-426e-94dc-e3eca629731f', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('38', '43a92bde-cf19-46cb-9c65-32b3453f51bb', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('39', '50085cee-e582-4370-9395-5a0b148b6afb', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('40', '65ca29a2-9bcd-4496-a5ec-6ff92f68e20e', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('41', 'fd8c0d74-b303-4fc4-885c-62da789dba66', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('42', 'ffc8b8e6-8d72-410d-8414-8eae9a2322c1', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '170e9076-07df-448e-ad1a-a522756147be', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('43', 'bf03339b-e927-4ccc-9cc3-dc16c8ef3e44', '0', '0', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('44', '12af47fd-1d80-47ff-b481-22d74dafd3c5', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('45', '7e068109-1093-4763-ac05-bf4978a2938d', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('46', 'ba56a7c4-13d7-449d-be25-c4822e711f6d', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('47', '13f5f078-2e6a-4a60-9a06-a6014a8cc48c', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('48', '38414380-a4da-4688-bb69-5675a4f88889', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('49', '962dff78-1329-48a2-a47d-8db4398df46e', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('50', 'dacda700-6f42-45fc-850a-4b61a6419e0b', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'c7693b2e-dea6-4aab-801f-6bc24903d801', '2014-02-18', '1');
INSERT INTO `sys_authorities` VALUES ('51', 'a5f3940b-0ae1-4839-b527-4f29251c3def', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', '3916cde4-a656-4e4c-91cc-fd0ba76060c9', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('52', '20db17fa-25c0-422c-8d61-a07042c25ed1', '0', '0', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('53', 'cd31fa99-01cc-4585-a746-f078dc238def', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('54', '026f9c3b-8196-496b-b554-419fc8f00567', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('55', '666fc5d2-8031-4d3f-9793-b286b4ddb249', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('56', '710cb246-5163-4d0a-9442-4e88b9db5d9d', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('57', 'd314d14b-9942-48a1-8d61-75553dea2d6f', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('58', 'f3287f28-8127-4b55-91fc-62985fe718eb', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('59', '870da044-eb6c-4108-9eec-dcf798e9f164', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'a387a429-a750-4b50-8b56-e8b2d14d3c9a', '2014-03-04', '1');
INSERT INTO `sys_authorities` VALUES ('60', '5b8fd092-4abc-4433-bc0e-f7d385e38f87', '0', '0', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('61', 'eae3e9d9-2343-4677-b417-733081eaf226', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('62', 'be169ed2-7837-4bfc-88df-0248e7b0bd79', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('63', 'b8cff796-4664-4c44-bed9-5cf0aea0d38a', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('64', '8143832e-62d5-408f-986f-5b17f1ed5b67', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('65', 'd215bf61-365a-48c8-988a-143019aa6a54', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('66', 'b6765370-fdf9-4db1-95cb-f0e6383e6750', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('67', 'c6631983-c3fc-44e6-b290-93c4f920fced', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'bb3dcf51-2570-4f4e-8f5e-8330cbb495a3', '2014-03-06', '1');
INSERT INTO `sys_authorities` VALUES ('68', '3e6c81cf-d422-4574-8898-e86a3b4c4473', '0', '0', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
INSERT INTO `sys_authorities` VALUES ('69', '4c369013-8e6e-41b7-9438-9d0ee2774b0e', '0', 'f26x3ty8-2457-41g2-64fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
INSERT INTO `sys_authorities` VALUES ('70', '82a79ff8-2ab7-4183-a2b2-3cd010785114', '0', 'f77x3ty8-2457-41g2-74fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
INSERT INTO `sys_authorities` VALUES ('71', 'ced6ec40-5e52-4e53-ba64-0c938833996b', '0', 'v26x3ty8-2457-41g2-04fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
INSERT INTO `sys_authorities` VALUES ('72', '31bf4960-da25-4304-98dd-e1baf89975cd', '0', 'gbkf35f8-2246-41h2-34f2-4cg56ad75ead', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
INSERT INTO `sys_authorities` VALUES ('73', '9277ca06-0c5d-41a2-b5bd-ffbe17134806', '0', 'f99x3g48-2246-41g2-54fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
INSERT INTO `sys_authorities` VALUES ('74', 'e2456be5-af0b-4517-aa9a-f6c0cf9b1197', '0', 'z26x3ty8-2457-41g2-54fy-4hg56ad75efs', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
INSERT INTO `sys_authorities` VALUES ('75', '2e2e620a-56fe-484f-9968-76fb5e99e110', '1', 'f14f35f8-2246-41h2-34f2-4cg56ad75ead', 'ef47dca1-b953-4455-8a0a-88027bd2b617', '2014-03-07', '1');
