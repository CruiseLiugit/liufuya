/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2014/5/22 citys and areas and streets
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for lfy_citypart
-- ----------------------------
CREATE TABLE `lfy_citypart` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(100) NOT NULL,
  `address_desc` varchar(100) DEFAULT NULL,
  `address_parent` int(50) NOT NULL DEFAULT '0' COMMENT '父节点',
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('上海', '直辖市',-1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('浦东新区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('黄浦区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('卢湾区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('徐汇区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('长宁区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('静安区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('普陀区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('闸北区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('虹口区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('杨浦区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('闵行区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('宝山区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('金山区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('松江区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('青浦区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('南汇区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('奉贤区', '',1, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('崇明县', '',1, '1');

-- ----------------------------
-- 浦东新区 http://www.shmzj.gov.cn/gb/shmzj/node6/node34/node587/userobject1ai8232.html
-- ----------------------------
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('陆家嘴街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('潍坊新村街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('塘桥街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('洋泾街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('花木街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('金杨新村街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('沪东新村街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('浦兴路街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('上钢新村街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('南码头路街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('周家渡街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('东明路街道', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('金桥镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('曹路镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('张江镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('合庆镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('唐镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('高桥镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('高东镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('高行镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('三林镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('北蔡镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('川沙新镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('祝桥镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('康桥镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('周浦镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('航头镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('新场镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('宣桥镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('惠南镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('老港镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('万祥镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('大团镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('泥城镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('书院镇', '浦东新区社区',2, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('南汇新城镇', '浦东新区社区',2, '1');


-- ----------------------------
-- 黄埔区
-- ----------------------------
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('南京东路街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('外滩街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('老西门街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('半淞园街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('小东门街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('豫园街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('打浦路街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('淮海中路街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('瑞金二路街道', '黄埔区街道',3, '1');
INSERT INTO `lfy_citypart`(address_name,address_desc,address_parent,status) VALUES ('五里桥街道', '黄埔区街道',3, '1');























