/*
Navicat MySQL Data Transfer

Source Server         : zheng
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : wfpos

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2018-06-17 18:46:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_function
-- ----------------------------
DROP TABLE IF EXISTS `auth_function`;
CREATE TABLE `auth_function` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `page` varchar(255) DEFAULT NULL,
  `generatemenu` varchar(255) DEFAULT NULL,
  `zindex` int(11) DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_Key_2` (`name`),
  KEY `FK33r6np87v1p6gge7t6rpcao5h` (`pid`),
  CONSTRAINT `FK33r6np87v1p6gge7t6rpcao5h` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_function
-- ----------------------------
INSERT INTO `auth_function` VALUES ('11', '菜谱', 'dish', null, null, '1', '2', null);
INSERT INTO `auth_function` VALUES ('111', '菜单大全', 'allmenu', null, 'page_base_dish.action', '1', '0', '11');
INSERT INTO `auth_function` VALUES ('112', '点菜', 'orderdish', null, 'page_base_ordering.action', '1', '1', '13');
INSERT INTO `auth_function` VALUES ('13', '餐桌', 'table', null, null, '1', '0', null);
INSERT INTO `auth_function` VALUES ('131', '餐桌管理', 'tablemanager', null, 'page_base_tablemanager.action', '1', '1', '13');
INSERT INTO `auth_function` VALUES ('14', '支付', 'pay', null, '', '1', '0', null);
INSERT INTO `auth_function` VALUES ('141', '支付管理', 'paymanager', null, 'page_base_pay.action', '1', '1', '14');
INSERT INTO `auth_function` VALUES ('15', '统计报表', 'countchart', null, '', '1', '0', null);
INSERT INTO `auth_function` VALUES ('151', '报表', 'chart', null, 'page_base_chart.action', '1', '3', '15');

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_Key_2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('1', '餐桌管理', '123', '');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(5) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('-1', '全部分类');
INSERT INTO `category` VALUES ('1001', '冷菜');
INSERT INTO `category` VALUES ('1002', '排类');
INSERT INTO `category` VALUES ('1003', '面类');
INSERT INTO `category` VALUES ('1004', '披萨');
INSERT INTO `category` VALUES ('1005', '沙拉');
INSERT INTO `category` VALUES ('1006', '甜食');
INSERT INTO `category` VALUES ('1007', '汤');
INSERT INTO `category` VALUES ('1008', '饮料');
INSERT INTO `category` VALUES ('1009', '酒');

-- ----------------------------
-- Table structure for dinnertable
-- ----------------------------
DROP TABLE IF EXISTS `dinnertable`;
CREATE TABLE `dinnertable` (
  `id` varchar(50) NOT NULL,
  `tableNo` int(10) DEFAULT NULL,
  `seatnum` int(10) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `tableStatusId` int(10) DEFAULT '1',
  `orderNo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `FKnbk4b7hqahs6pknjhoydkkssh` (`tableStatusId`),
  CONSTRAINT `FKnbk4b7hqahs6pknjhoydkkssh` FOREIGN KEY (`tableStatusId`) REFERENCES `tablestatus` (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dinnertable
-- ----------------------------
INSERT INTO `dinnertable` VALUES ('1', '1', '20', null, '1', null);
INSERT INTO `dinnertable` VALUES ('2', '2', '5', '2018-06-13 18:23:20', '3', 'e7d8480b-8556-4077-963a-25e4a1e72794');
INSERT INTO `dinnertable` VALUES ('3', '3', '4', null, '1', null);
INSERT INTO `dinnertable` VALUES ('4', '4', '4', null, '1', null);
INSERT INTO `dinnertable` VALUES ('5', '5', '5', null, '1', null);
INSERT INTO `dinnertable` VALUES ('6', '6', '4', '2018-06-15 10:03:21', '2', null);
INSERT INTO `dinnertable` VALUES ('7', '7', '4', null, '1', null);
INSERT INTO `dinnertable` VALUES ('8', '8', '5', null, '1', null);
INSERT INTO `dinnertable` VALUES ('9', '9', '5', null, '1', null);

-- ----------------------------
-- Table structure for dishes
-- ----------------------------
DROP TABLE IF EXISTS `dishes`;
CREATE TABLE `dishes` (
  `dishid` varchar(10) NOT NULL,
  `dishname` varchar(20) NOT NULL,
  `unit` varchar(5) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `categoryid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`dishid`),
  KEY `FK2i7cgh3nrsiveturdjngdm80q` (`categoryid`),
  CONSTRAINT `FK2i7cgh3nrsiveturdjngdm80q` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`),
  CONSTRAINT `key1` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dishes
-- ----------------------------
INSERT INTO `dishes` VALUES ('a01', '冷杂拌肉', '份', '23.00', '1001');
INSERT INTO `dishes` VALUES ('a02', '鸡肉冻', '份', '15.00', '1001');
INSERT INTO `dishes` VALUES ('a03', '冷烤火鸡', '份', '25.00', '1001');
INSERT INTO `dishes` VALUES ('a04', '火腿蛋', '份', '12.00', '1001');
INSERT INTO `dishes` VALUES ('a05', '芥末煎火腿豌豆', '份', '13.00', '1001');
INSERT INTO `dishes` VALUES ('a06', '鸡肝泥', '份', '18.00', '1001');
INSERT INTO `dishes` VALUES ('a07', '什锦蔬菜', '份', '15.00', '1001');
INSERT INTO `dishes` VALUES ('a08', '奶酪口蘑烤蟹肉', '份', '28.00', '1001');
INSERT INTO `dishes` VALUES ('a09', '红鱼子酱', '份', '24.00', '1001');
INSERT INTO `dishes` VALUES ('a10', '鸡蛋托鲱鱼', '份', '28.00', '1001');
INSERT INTO `dishes` VALUES ('a12', '冷冻沙拉', '份', '10.00', '1001');
INSERT INTO `dishes` VALUES ('b01', '土豆泥煎小牛排', '份', '45.00', '1002');
INSERT INTO `dishes` VALUES ('b02', '煎小牛肝', '份', '45.00', '1002');
INSERT INTO `dishes` VALUES ('b03', '奶油烩猪肉片', '份', '38.00', '1002');
INSERT INTO `dishes` VALUES ('b04', '罗马尼亚式牛肉扒', '份', '45.00', '1002');
INSERT INTO `dishes` VALUES ('b05', '汉堡牛扒', '份', '25.00', '1002');
INSERT INTO `dishes` VALUES ('b06', '总会牛排', '份', '38.00', '1002');
INSERT INTO `dishes` VALUES ('b07', '牛扒托蛋', '份', '40.00', '1002');
INSERT INTO `dishes` VALUES ('b08', '黄油汁煎鸭肝', '份', '34.00', '1002');
INSERT INTO `dishes` VALUES ('b09', '法式猪排', '份', '30.00', '1002');
INSERT INTO `dishes` VALUES ('c01', '肉丝炒通心粉', '份', '28.00', '1003');
INSERT INTO `dishes` VALUES ('c02', '鸡肉火腿通心粉', '份', '28.00', '1003');
INSERT INTO `dishes` VALUES ('c03', '大虾鸡蛋通心粉', '份', '38.00', '1003');
INSERT INTO `dishes` VALUES ('c04', '大虾番茄烤面条', '份', '38.00', '1003');
INSERT INTO `dishes` VALUES ('c05', '奶酪口蘑烤通心粉', '份', '30.00', '1003');
INSERT INTO `dishes` VALUES ('d01', '夏威夷披萨', '份', '58.00', '1004');
INSERT INTO `dishes` VALUES ('d02', '咖喱鸡肉披萨', '份', '68.00', '1004');
INSERT INTO `dishes` VALUES ('d03', '咖喱牛肉披萨', '份', '78.00', '1004');
INSERT INTO `dishes` VALUES ('d04', '意大利香肠披萨', '份', '68.00', '1004');
INSERT INTO `dishes` VALUES ('d05', '海鲜至尊披萨', '份', '88.00', '1004');
INSERT INTO `dishes` VALUES ('d06', '普罗旺斯风情烤鸡披萨', '份', '68.00', '1004');
INSERT INTO `dishes` VALUES ('d07', '意式培根大虾披萨', '份', '88.00', '1004');
INSERT INTO `dishes` VALUES ('e01', '鲜果海鲜沙拉', '份', '45.00', '1005');
INSERT INTO `dishes` VALUES ('e02', '蔬菜水果沙拉', '份', '30.00', '1005');
INSERT INTO `dishes` VALUES ('e03', '鸡丝沙拉', '份', '30.00', '1005');
INSERT INTO `dishes` VALUES ('e04', '鸡蛋沙拉', '份', '25.00', '1005');
INSERT INTO `dishes` VALUES ('e05', '鱼片沙拉', '份', '35.00', '1005');
INSERT INTO `dishes` VALUES ('e06', '虾仁沙拉', '份', '40.00', '1005');
INSERT INTO `dishes` VALUES ('e07', '奶油黄瓜沙拉', '份', '25.00', '1005');
INSERT INTO `dishes` VALUES ('e08', '西红柿黄瓜沙拉', '份', '25.00', '1005');
INSERT INTO `dishes` VALUES ('e09', '鱼籽沙拉', '份', '30.00', '1005');
INSERT INTO `dishes` VALUES ('e10', '素沙拉', '份', '20.00', '1005');
INSERT INTO `dishes` VALUES ('f01', '英式水果蛋糕', '个', '25.00', '1006');
INSERT INTO `dishes` VALUES ('f02', '绿茶奶酪蛋糕', '个', '30.00', '1006');
INSERT INTO `dishes` VALUES ('f03', '意大利提拉米苏', '个', '40.00', '1006');
INSERT INTO `dishes` VALUES ('f04', '巧克力榛子蛋糕', '个', '35.00', '1006');
INSERT INTO `dishes` VALUES ('f05', '白巧克力奶油布丁', '个', '30.00', '1006');
INSERT INTO `dishes` VALUES ('f06', '芒果布丁', '个', '30.00', '1006');
INSERT INTO `dishes` VALUES ('f07', '巧克力冰淇淋', '个', '35.00', '1006');
INSERT INTO `dishes` VALUES ('f08', '绿茶冰淇淋', '个', '35.00', '1006');
INSERT INTO `dishes` VALUES ('f09', '冰糖莲子银耳羹', '个', '30.00', '1006');
INSERT INTO `dishes` VALUES ('f10', '巧克力奶昔', '个', '35.00', '1006');
INSERT INTO `dishes` VALUES ('g01', '奶油鸡茸汤', '份', '12.00', '1007');
INSERT INTO `dishes` VALUES ('g02', '奶油芦笋汤', '份', '12.00', '1007');
INSERT INTO `dishes` VALUES ('g03', '牛尾汤', '份', '20.00', '1007');
INSERT INTO `dishes` VALUES ('g04', '冷牛肉茶', '份', '17.00', '1007');
INSERT INTO `dishes` VALUES ('g05', '高加索鸡块汤', '份', '17.00', '1007');
INSERT INTO `dishes` VALUES ('g06', '白豆汤', '份', '12.00', '1007');
INSERT INTO `dishes` VALUES ('g07', '丸子蔬菜汤', '份', '15.00', '1007');
INSERT INTO `dishes` VALUES ('g08', '洋葱汤', '份', '12.00', '1007');
INSERT INTO `dishes` VALUES ('g09', '肉杂拌汤', '份', '17.00', '1007');
INSERT INTO `dishes` VALUES ('g10', '奶油菠菜汤', '份', '12.00', '1007');
INSERT INTO `dishes` VALUES ('h01', '哥伦比亚咖啡', '杯', '40.00', '1008');
INSERT INTO `dishes` VALUES ('h02', '牙买加咖啡', '杯', '40.00', '1008');
INSERT INTO `dishes` VALUES ('h03', '蓝山咖啡', '杯', '50.00', '1008');
INSERT INTO `dishes` VALUES ('h04', '巴西山度士咖啡', '杯', '45.00', '1008');
INSERT INTO `dishes` VALUES ('h05', '曼特林咖啡', '杯', '50.00', '1008');
INSERT INTO `dishes` VALUES ('h06', '巴黎矿泉水', '杯', '35.00', '1008');
INSERT INTO `dishes` VALUES ('h07', '冰香草咖啡拿铁', '杯', '40.00', '1008');
INSERT INTO `dishes` VALUES ('h08', '金巴利橙汁', '杯', '30.00', '1008');
INSERT INTO `dishes` VALUES ('h09', '意大利苏打', '杯', '20.00', '1008');
INSERT INTO `dishes` VALUES ('h10', '立顿红茶', '杯', '20.00', '1008');
INSERT INTO `dishes` VALUES ('i01', '轩尼诗', '瓶', '550.00', '1009');
INSERT INTO `dishes` VALUES ('i02', '威士忌', '瓶', '550.00', '1009');
INSERT INTO `dishes` VALUES ('i03', '伏特加', '瓶', '450.00', '1009');
INSERT INTO `dishes` VALUES ('i04', '金酒', '瓶', '500.00', '1009');
INSERT INTO `dishes` VALUES ('i05', '龙舌兰酒', '瓶', '400.00', '1009');
INSERT INTO `dishes` VALUES ('i06', '朗姆酒 ', '瓶', '450.00', '1009');
INSERT INTO `dishes` VALUES ('i07', '白兰地', '瓶', '500.00', '1009');
INSERT INTO `dishes` VALUES ('i08', '马爹利', '瓶', '600.00', '1009');
INSERT INTO `dishes` VALUES ('i09', '蓝带马爹利', '瓶', '650.00', '1009');
INSERT INTO `dishes` VALUES ('i10', '波马', '瓶', '450.00', '1009');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` varchar(50) NOT NULL,
  `ordertime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ordertotalprice` double(10,2) DEFAULT NULL,
  `userid` varchar(50) NOT NULL,
  `tableid` varchar(50) DEFAULT NULL,
  `payid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKaqlumottctw8p84a0aox9k91t` (`userid`),
  KEY `FK8whbdalt2htmd14sqmpt505q` (`payid`),
  KEY `FK1trb4gp5qrynu8wyucg3x53ap` (`tableid`),
  CONSTRAINT `FK1trb4gp5qrynu8wyucg3x53ap` FOREIGN KEY (`tableid`) REFERENCES `dinnertable` (`id`),
  CONSTRAINT `FK8whbdalt2htmd14sqmpt505q` FOREIGN KEY (`payid`) REFERENCES `pay` (`id`),
  CONSTRAINT `FKaqlumottctw8p84a0aox9k91t` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('14040c82-285e-49b8-acef-5be5ffcbce2e', '2018-06-12 21:37:45', '136.00', 'z4002', '8', 'd7bcfbc1-72fe-40fa-a107-96c51bb949c3');
INSERT INTO `order` VALUES ('197bbe66-6ee7-4a36-8784-40822b4c5312', '2018-06-12 21:36:57', '52.00', 'z4002', '2', '7e018a5e-e247-49a8-b2c6-f2f2591d203a');
INSERT INTO `order` VALUES ('1aa5c535-ad10-41f1-9f7a-ebd4c4a34c3f', '2018-06-12 21:37:55', '65.00', 'z4002', '3', '340539c9-771e-4ce0-b3dc-4ffd9564f99d');
INSERT INTO `order` VALUES ('25d520ea-50fb-4e5b-8f96-833ba93b01c7', '2018-06-13 16:15:10', '130.00', 'z4002', '5', '361409dd-9223-4949-9c1e-59e9b5191154');
INSERT INTO `order` VALUES ('5e6c208b-b32c-4fea-9ab1-5c36a4204089', '2018-06-15 10:28:01', '74.00', 'z4002', '1', 'fe6e31db-9293-4875-be8c-d3e7df2fbb4f');
INSERT INTO `order` VALUES ('73310b57-39b9-449a-b0a0-ce0583ca2dc9', '2018-06-13 18:23:56', '688.00', 'z4002', '5', 'dd03329a-23e5-45a2-a8fb-5e4ffb5dcee5');
INSERT INTO `order` VALUES ('844e6834-fad5-474b-89bb-6a31eb06c664', '2018-06-13 18:24:25', '39.00', 'z4002', '8', '1e56106a-0e3e-4e5f-bfd2-02faea879d9c');
INSERT INTO `order` VALUES ('953dc603-f5d2-471c-9e09-18359e4826c5', '2018-06-12 21:40:25', '38.00', 'z4002', '4', '0454c090-f831-4896-884c-ab2b0b4faf21');
INSERT INTO `order` VALUES ('e7d8480b-8556-4077-963a-25e4a1e72794', '2018-06-13 21:13:25', '115.00', 'z4002', '2', null);
INSERT INTO `order` VALUES ('f753d8a1-2a06-49b1-a348-c12afd704c3f', '2018-06-12 21:39:16', '63.00', 'z4002', '7', '9ad0d995-c121-4b41-a8a2-c71f0113acfb');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `itemid` varchar(50) NOT NULL,
  `dishid` varchar(50) NOT NULL,
  `num` int(10) DEFAULT NULL,
  `taste` varchar(10) DEFAULT NULL,
  `totalprice` double(10,2) DEFAULT NULL,
  `oid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `FKd91n0bce9vlnnduw8jqsc0mbo` (`oid`),
  KEY `FKna1x138d9b4hirauutdmins31` (`dishid`),
  CONSTRAINT `FKd91n0bce9vlnnduw8jqsc0mbo` FOREIGN KEY (`oid`) REFERENCES `order` (`oid`),
  CONSTRAINT `FKna1x138d9b4hirauutdmins31` FOREIGN KEY (`dishid`) REFERENCES `dishes` (`dishid`),
  CONSTRAINT `key_3` FOREIGN KEY (`dishid`) REFERENCES `dishes` (`dishid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('000e6e57-f238-4d75-beee-fc155b8ee08f', 'a03', '1', '正常', '25.00', '5e6c208b-b32c-4fea-9ab1-5c36a4204089');
INSERT INTO `orderdetail` VALUES ('018bc710-4434-4352-afc9-69377f060a7f', 'a01', '1', '正常', '23.00', '14040c82-285e-49b8-acef-5be5ffcbce2e');
INSERT INTO `orderdetail` VALUES ('108adbdf-eade-4f6f-8b93-bfdba4ac3f14', 'a07', '3', '正常', '45.00', '14040c82-285e-49b8-acef-5be5ffcbce2e');
INSERT INTO `orderdetail` VALUES ('12951563-f13a-42bf-aa7d-9795445a6d0b', 'c03', '1', '正常', '38.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('17c42caa-1305-47fd-9f8d-1c525d46299c', 'a05', '1', '正常', '13.00', '25d520ea-50fb-4e5b-8f96-833ba93b01c7');
INSERT INTO `orderdetail` VALUES ('19856765-e640-4861-b014-b3c9dad0fd17', 'a06', '1', '正常', '18.00', '25d520ea-50fb-4e5b-8f96-833ba93b01c7');
INSERT INTO `orderdetail` VALUES ('2049e5f6-94e1-4dd8-ba48-adb606119303', 'a10', '1', '正常', '28.00', '1aa5c535-ad10-41f1-9f7a-ebd4c4a34c3f');
INSERT INTO `orderdetail` VALUES ('31123bd4-c0f0-4d04-a2c8-900591c5e0b9', 'a03', '1', '正常', '25.00', '14040c82-285e-49b8-acef-5be5ffcbce2e');
INSERT INTO `orderdetail` VALUES ('3328150d-c640-4905-a87c-45b5dd012bbb', 'a10', '3', '超辣', '84.00', '25d520ea-50fb-4e5b-8f96-833ba93b01c7');
INSERT INTO `orderdetail` VALUES ('380e0b44-4f63-4664-8902-d6c34a527221', 'g08', '1', '正常', '12.00', '844e6834-fad5-474b-89bb-6a31eb06c664');
INSERT INTO `orderdetail` VALUES ('3c3b1bbe-df31-4f3e-b38a-370a021fe223', 'a07', '1', '正常', '15.00', '25d520ea-50fb-4e5b-8f96-833ba93b01c7');
INSERT INTO `orderdetail` VALUES ('3c59f6c0-0190-4d7c-97ce-add7f0c20fcb', 'a05', '1', '正常', '13.00', '1aa5c535-ad10-41f1-9f7a-ebd4c4a34c3f');
INSERT INTO `orderdetail` VALUES ('3de6db3c-3449-4618-b2d9-f299996e0c0f', 'a09', '1', '正常', '24.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('3e0f2f28-779a-4e73-b4f1-203858fd0a33', 'i06', '1', '正常', '450.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('4ad9f50d-3ea7-461a-a82f-cfe8765e39f4', 'a03', '1', '正常', '25.00', 'f753d8a1-2a06-49b1-a348-c12afd704c3f');
INSERT INTO `orderdetail` VALUES ('506a4243-ee01-47b9-9ca5-1844975a795a', 'g07', '1', '正常', '15.00', '844e6834-fad5-474b-89bb-6a31eb06c664');
INSERT INTO `orderdetail` VALUES ('52f81355-ffdc-4a80-9ef1-10a652245620', 'a01', '1', '正常', '23.00', 'f753d8a1-2a06-49b1-a348-c12afd704c3f');
INSERT INTO `orderdetail` VALUES ('643b8a5d-e971-4c1a-9008-4bb2c1d29974', 'a10', '1', '正常', '28.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('6a3d5b0d-9e84-48c8-b20a-5d19e8e5bf92', 'g10', '1', '正常', '12.00', '844e6834-fad5-474b-89bb-6a31eb06c664');
INSERT INTO `orderdetail` VALUES ('73d04aa9-2f3b-4474-afc6-b99cdb5796c5', 'a09', '1', '正常', '24.00', '1aa5c535-ad10-41f1-9f7a-ebd4c4a34c3f');
INSERT INTO `orderdetail` VALUES ('78791f26-b56c-4a2a-afec-5c130a3e3d40', 'a04', '1', '正常', '12.00', '197bbe66-6ee7-4a36-8784-40822b4c5312');
INSERT INTO `orderdetail` VALUES ('7ed64ec0-d64e-4344-9a8f-20aa9cd56ac6', 'a08', '1', '正常', '28.00', '14040c82-285e-49b8-acef-5be5ffcbce2e');
INSERT INTO `orderdetail` VALUES ('7ff20d9a-984e-4cdf-aaea-86314372aacf', 'a02', '1', '正常', '15.00', 'f753d8a1-2a06-49b1-a348-c12afd704c3f');
INSERT INTO `orderdetail` VALUES ('97b2e611-a5aa-4ab8-880e-c14c861ddd87', 'a02', '1', '正常', '15.00', '14040c82-285e-49b8-acef-5be5ffcbce2e');
INSERT INTO `orderdetail` VALUES ('a1649b12-01e2-4007-8c36-f2a6a1e337e2', 'a03', '1', '正常', '25.00', '197bbe66-6ee7-4a36-8784-40822b4c5312');
INSERT INTO `orderdetail` VALUES ('a2db1b02-2a45-493f-aa95-c3e58de59b77', 'a02', '1', '正常', '15.00', '197bbe66-6ee7-4a36-8784-40822b4c5312');
INSERT INTO `orderdetail` VALUES ('a773015f-9ef9-44b9-8c50-6e30ecad9a0f', 'a05', '1', '正常', '13.00', '5e6c208b-b32c-4fea-9ab1-5c36a4204089');
INSERT INTO `orderdetail` VALUES ('a798342f-48d2-45c2-9c07-d7e5071ee3c6', 'g07', '1', '正常', '15.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('b946738c-93c8-465c-9c27-c9a42ec3031d', 'h07', '1', '正常', '40.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('dc7fb4fc-d8ee-4904-a84c-1c0ac22c6d64', 'e08', '1', '正常', '25.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('e73be838-0dfd-4f3b-afbd-1e7e703f91eb', 'd04', '1', '正常', '68.00', '73310b57-39b9-449a-b0a0-ce0583ca2dc9');
INSERT INTO `orderdetail` VALUES ('e7a51b33-248f-4e0e-b5fe-8078760737db', 'a02', '1', '正常', '15.00', '953dc603-f5d2-471c-9e09-18359e4826c5');
INSERT INTO `orderdetail` VALUES ('f1c3d349-bbb4-435f-8010-e905c24cd236', 'a01', '5', '正常', '115.00', 'e7d8480b-8556-4077-963a-25e4a1e72794');
INSERT INTO `orderdetail` VALUES ('f48ecc4b-9f51-40a6-b0f0-1988be68ba2f', 'a01', '1', '正常', '23.00', '953dc603-f5d2-471c-9e09-18359e4826c5');
INSERT INTO `orderdetail` VALUES ('fb984372-8ecc-403d-b82f-4243e9a76d74', 'a06', '2', '正常', '36.00', '5e6c208b-b32c-4fea-9ab1-5c36a4204089');

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` varchar(50) NOT NULL,
  `paytime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `paystatus` int(10) DEFAULT '0',
  `paymethod` int(10) DEFAULT NULL,
  `realreceivemoney` double(10,0) DEFAULT NULL,
  `paychange` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES ('0454c090-f831-4896-884c-ab2b0b4faf21', '2018-06-12 21:40:31', '1', '1', '50', '12');
INSERT INTO `pay` VALUES ('1e56106a-0e3e-4e5f-bfd2-02faea879d9c', '2018-06-13 18:29:31', '1', '1', '50', '11');
INSERT INTO `pay` VALUES ('340539c9-771e-4ce0-b3dc-4ffd9564f99d', '2018-06-12 21:38:13', '1', '1', '100', '35');
INSERT INTO `pay` VALUES ('361409dd-9223-4949-9c1e-59e9b5191154', '2018-06-13 16:15:22', '1', '1', '150', '20');
INSERT INTO `pay` VALUES ('7e018a5e-e247-49a8-b2c6-f2f2591d203a', '2018-06-12 21:37:20', '1', '1', '100', '48');
INSERT INTO `pay` VALUES ('9ad0d995-c121-4b41-a8a2-c71f0113acfb', '2018-06-12 21:39:23', '1', '1', '100', '37');
INSERT INTO `pay` VALUES ('d7bcfbc1-72fe-40fa-a107-96c51bb949c3', '2018-06-12 21:38:03', '1', '1', '150', '14');
INSERT INTO `pay` VALUES ('dd03329a-23e5-45a2-a8fb-5e4ffb5dcee5', '2018-06-13 18:24:36', '1', '1', '1000', '312');
INSERT INTO `pay` VALUES ('fe6e31db-9293-4875-be8c-d3e7df2fbb4f', '2018-06-15 10:28:49', '1', '1', '100', '26');

-- ----------------------------
-- Table structure for role_function
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `role_id` varchar(32) NOT NULL,
  `function_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`function_id`),
  KEY `FK5f8riddotqjpm9vly0b8c5nmf` (`function_id`),
  CONSTRAINT `FK10qo908yd9evkyb40vf88og85` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FK5f8riddotqjpm9vly0b8c5nmf` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES ('1', '112');
INSERT INTO `role_function` VALUES ('1', '13');
INSERT INTO `role_function` VALUES ('1', '131');
INSERT INTO `role_function` VALUES ('1', '14');
INSERT INTO `role_function` VALUES ('1', '141');

-- ----------------------------
-- Table structure for tablestatus
-- ----------------------------
DROP TABLE IF EXISTS `tablestatus`;
CREATE TABLE `tablestatus` (
  `statusid` int(10) NOT NULL,
  `statusName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tablestatus
-- ----------------------------
INSERT INTO `tablestatus` VALUES ('-1', '全部');
INSERT INTO `tablestatus` VALUES ('1', '空闲');
INSERT INTO `tablestatus` VALUES ('2', '待点菜');
INSERT INTO `tablestatus` VALUES ('3', '未结账');
INSERT INTO `tablestatus` VALUES ('4', '待清桌');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('z4001', '123', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('z4002', 'admin', '202cb962ac59075b964b07152d234b70', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKqqlqhas35obkljn18mrh6mmms` (`role_id`),
  CONSTRAINT `FKeqon9sx5vssprq67dxm3s7ump` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKqqlqhas35obkljn18mrh6mmms` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('z4001', '1');
