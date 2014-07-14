/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/3/7 liulili 11:25:40
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for sys_roles_authorities
-- ----------------------------
CREATE TABLE `sys_roles_authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `auth_code` varchar(50) NOT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `sys_roles_authorities` VALUES ('1', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'k14f35f8-2246-41h2-34f2-4cg56ad75ead  ', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('2', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'k24f35f8-2246-41h2-34f2-4cg56ad75ead', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('3', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '855a5476-0d8d-4ccd-ac64-54ab2eef1fc7', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('4', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fc9d19ee-3e51-4a1d-86b8-a043ec48b0a3', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('5', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '26439706-7e39-4f8d-89f4-4f12aa2f8bda', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('6', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '46b26d66-948f-4010-8e73-d87b99442d78', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('7', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '632f97e9-e013-48ae-8171-5d15b7106f29', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('8', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e498230e-bed9-41b4-8df4-2a96b128934a', '2014-02-14', '1');
INSERT INTO `sys_roles_authorities` VALUES ('9', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'h2df30b8-2df6-41d2-84f2-4cd56bb75ecc', '2014-02-15', '1');
INSERT INTO `sys_roles_authorities` VALUES ('10', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a3455654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('11', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bd455654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('12', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '34555654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('13', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '09895654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('14', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ijkl5654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('15', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ol055654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('16', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '33335654-dfdf-2345-sdfg-asdfghjdfger', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('34', '2ffba9aa-af3f-4729-8826-221febc712cf', 'k14f35f8-2246-41h2-34f2-4cg56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('35', '2ffba9aa-af3f-4729-8826-221febc712cf', 'k24f35f8-2246-41h2-34f2-4cg56ad75ead', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('36', '2ffba9aa-af3f-4729-8826-221febc712cf', '26439706-7e39-4f8d-89f4-4f12aa2f8bda', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('37', '2ffba9aa-af3f-4729-8826-221febc712cf', '855a5476-0d8d-4ccd-ac64-54ab2eef1fc7', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('38', '2ffba9aa-af3f-4729-8826-221febc712cf', 'fc9d19ee-3e51-4a1d-86b8-a043ec48b0a3', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('39', '2ffba9aa-af3f-4729-8826-221febc712cf', '46b26d66-948f-4010-8e73-d87b99442d78', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('40', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dfdfdfdf-2343-dfdf-dfdf-234325343', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('41', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7bh87y3-f34f-dfd3er-efre-3rf3r3r', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('42', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'wgtf4t4-dgrghrg-dgfrh5r-try4hy54y', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('43', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dfdfefr4-4g4g4y-f4rt-t4-t4-t4t4t4t', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('44', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cergr0-32-r3r-34t4gt54gy-3er4gt4r', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('45', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dfdgfe4-grgrhth-34g4rht5rh5ju-f4g', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('46', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dg9jf4gt4-f4gt4gy0f4gt-f4g45h54hy', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('54', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4a65d7c4-9b87-440e-9fd6-821d0d24c916', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('55', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3a9c90a6-1ce7-4867-90ce-e08a8a12a35c', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('56', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7b39cc3c-dfbb-4c4d-a52c-d28290b01815', '2014-02-16', '1');
INSERT INTO `sys_roles_authorities` VALUES ('57', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '487bc775-363e-4d26-bcb1-5bf95f398ef1', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('58', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ab6fbf22-f158-4c71-bd6b-9566050122f6', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('59', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '555423be-7abd-4b8b-b5e3-1c3b9ddba4fd', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('60', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '31e17456-7f48-426e-94dc-e3eca629731f', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('61', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '43a92bde-cf19-46cb-9c65-32b3453f51bb', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('62', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '50085cee-e582-4370-9395-5a0b148b6afb', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('63', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '65ca29a2-9bcd-4496-a5ec-6ff92f68e20e', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('64', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'fd8c0d74-b303-4fc4-885c-62da789dba66', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('65', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ffc8b8e6-8d72-410d-8414-8eae9a2322c1', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('66', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'bf03339b-e927-4ccc-9cc3-dc16c8ef3e44', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('67', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '12af47fd-1d80-47ff-b481-22d74dafd3c5', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('68', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '7e068109-1093-4763-ac05-bf4978a2938d', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('69', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ba56a7c4-13d7-449d-be25-c4822e711f6d', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('70', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '13f5f078-2e6a-4a60-9a06-a6014a8cc48c', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('71', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '38414380-a4da-4688-bb69-5675a4f88889', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('72', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '962dff78-1329-48a2-a47d-8db4398df46e', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('73', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'dacda700-6f42-45fc-850a-4b61a6419e0b', '2014-02-18', '1');
INSERT INTO `sys_roles_authorities` VALUES ('74', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'a5f3940b-0ae1-4839-b527-4f29251c3def', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('75', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '20db17fa-25c0-422c-8d61-a07042c25ed1', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('76', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'cd31fa99-01cc-4585-a746-f078dc238def', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('77', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '026f9c3b-8196-496b-b554-419fc8f00567', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('78', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '666fc5d2-8031-4d3f-9793-b286b4ddb249', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('79', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '710cb246-5163-4d0a-9442-4e88b9db5d9d', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('80', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd314d14b-9942-48a1-8d61-75553dea2d6f', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('81', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'f3287f28-8127-4b55-91fc-62985fe718eb', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('82', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '870da044-eb6c-4108-9eec-dcf798e9f164', '2014-03-04', '1');
INSERT INTO `sys_roles_authorities` VALUES ('83', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '5b8fd092-4abc-4433-bc0e-f7d385e38f87', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('84', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'eae3e9d9-2343-4677-b417-733081eaf226', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('85', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'be169ed2-7837-4bfc-88df-0248e7b0bd79', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('86', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b8cff796-4664-4c44-bed9-5cf0aea0d38a', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('87', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '8143832e-62d5-408f-986f-5b17f1ed5b67', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('88', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'd215bf61-365a-48c8-988a-143019aa6a54', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('89', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'b6765370-fdf9-4db1-95cb-f0e6383e6750', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('90', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'c6631983-c3fc-44e6-b290-93c4f920fced', '2014-03-06', '1');
INSERT INTO `sys_roles_authorities` VALUES ('91', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '3e6c81cf-d422-4574-8898-e86a3b4c4473', '2014-03-07', '1');
INSERT INTO `sys_roles_authorities` VALUES ('92', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '4c369013-8e6e-41b7-9438-9d0ee2774b0e', '2014-03-07', '1');
INSERT INTO `sys_roles_authorities` VALUES ('93', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '82a79ff8-2ab7-4183-a2b2-3cd010785114', '2014-03-07', '1');
INSERT INTO `sys_roles_authorities` VALUES ('94', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'ced6ec40-5e52-4e53-ba64-0c938833996b', '2014-03-07', '1');
INSERT INTO `sys_roles_authorities` VALUES ('95', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '31bf4960-da25-4304-98dd-e1baf89975cd', '2014-03-07', '1');
INSERT INTO `sys_roles_authorities` VALUES ('96', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '9277ca06-0c5d-41a2-b5bd-ffbe17134806', '2014-03-07', '1');
INSERT INTO `sys_roles_authorities` VALUES ('97', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', 'e2456be5-af0b-4517-aa9a-f6c0cf9b1197', '2014-03-07', '1');
INSERT INTO `sys_roles_authorities` VALUES ('98', 'd22f30b8-2716-41d2-84f2-4cd56bb75ecc', '2e2e620a-56fe-484f-9968-76fb5e99e110', '2014-03-07', '1');
