/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : canteen

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-06-24 21:08:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `admin_name` varchar(10) NOT NULL,
  `job` varchar(10) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO admin VALUES ('10000', 'admin', 'admin', '老板', '系统管理员', '男', '13411606760');
INSERT INTO admin VALUES ('10001', 'tiantian', '123456', '恬恬', '前台服务员', '女', '13411606761');
INSERT INTO admin VALUES ('10002', 'dabao', '123456', '大宝', '菜单管理员', '男', '13411606762');
INSERT INTO admin VALUES ('10003', 'xiongda', '123456', '熊大', '厨房管理员', '男', '13411606763');
INSERT INTO admin VALUES ('10005', 'xionger', '123456', '熊儿', '厨房管理员', '男', '13411606765');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `category_name` varchar(20) NOT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK_managerCategory` (`admin_id`),
  CONSTRAINT `FK_managerCategory` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20021 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO category VALUES ('20000', '10002', '熟菜');
INSERT INTO category VALUES ('20002', '10002', '饮料');
INSERT INTO category VALUES ('20003', '10002', '酒类');
INSERT INTO category VALUES ('20005', '10002', '甜品');
INSERT INTO category VALUES ('20019', '10000', '主食');
INSERT INTO category VALUES ('20020', '10002', '冷菜');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `menu_name` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `summary` varchar(100) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `FK_belong` (`category_id`),
  KEY `FK_managerMenu` (`admin_id`),
  CONSTRAINT `FK_belong` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `FK_managerMenu` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO menu VALUES ('30000', '10002', '20000', '辣子鸡', '25', null, 'img-menu/lzj.jpg');
INSERT INTO menu VALUES ('30001', '10002', '20000', '可乐鸡翅', '20', null, 'img-menu/kljc.jpg');
INSERT INTO menu VALUES ('30003', '10002', '20002', '可乐', '10', null, 'img-menu/kl.jpg');
INSERT INTO menu VALUES ('30004', '10002', '20002', '酸梅汤', '15', null, 'img-menu/smt.jpg');
INSERT INTO menu VALUES ('30005', '10002', '20003', '青岛啤酒', '12', null, 'img-menu/qdpj.jpg');
INSERT INTO menu VALUES ('30006', '10002', '20003', '威士忌', '50', null, 'img-menu/wsj.jpg');
INSERT INTO menu VALUES ('30009', '10002', '20005', '巧克力蛋糕', '15', null, 'img-menu/qkldg.jpg');
INSERT INTO menu VALUES ('30010', '10002', '20005', '冰欺凌', '5', null, 'img-menu/bql.jpg');
INSERT INTO menu VALUES ('30011', '10002', '20020', '凉拌青瓜', '10', null, 'img-menu/lbqg.jpg');
INSERT INTO menu VALUES ('30012', '10002', '20020', '冰晶凤爪', '15', null, 'img-menu/bjfz.jpg');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderItem_id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItem_id`,`menu_id`,`orders_id`),
  KEY `FK_orderItem` (`menu_id`),
  KEY `FK_orderItem2` (`orders_id`),
  CONSTRAINT `FK_orderItem` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `FK_orderItem2` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`orders_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO orderitem VALUES ('1', '2', '30000', '1');
INSERT INTO orderitem VALUES ('2', '2', '30001', '2');
INSERT INTO orderitem VALUES ('4', '2', '30006', '1');
INSERT INTO orderitem VALUES ('5', '3', '30006', '2');
INSERT INTO orderitem VALUES ('6', '3', '30001', '1');
INSERT INTO orderitem VALUES ('7', '4', '30001', '5');
INSERT INTO orderitem VALUES ('8', '5', '30001', '5');
INSERT INTO orderitem VALUES ('9', '6', '30001', '5');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NOT NULL,
  `tables_id` int(11) NOT NULL,
  `orders_time` varchar(50) NOT NULL,
  `discount` int(11) DEFAULT NULL,
  `totalPrice` int(11) DEFAULT NULL,
  `orders_state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orders_id`),
  KEY `FK_Mapping` (`tables_id`),
  KEY `FK_check` (`admin_id`),
  CONSTRAINT `FK_Mapping` FOREIGN KEY (`tables_id`) REFERENCES `tables` (`tables_id`),
  CONSTRAINT `FK_check` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO orders VALUES ('2', '10001', '1', '2018-6-20 19：19：20', '1', '110', '已付费');
INSERT INTO orders VALUES ('3', '10001', '2', '2018-6-20 20:30:00', '1', '120', '已付费');
INSERT INTO orders VALUES ('4', '10001', '3', '2018-6-20 19：20：30', '1', '100', '制作中');
INSERT INTO orders VALUES ('5', '10001', '4', '2018-6-20 19：30：00', '1', '100', '未付费');
INSERT INTO orders VALUES ('6', '10001', '5', '2018-6-20 20:49:49', '1', '100', '已提交');

-- ----------------------------
-- Table structure for `tables`
-- ----------------------------
DROP TABLE IF EXISTS `tables`;
CREATE TABLE `tables` (
  `tables_id` int(11) NOT NULL AUTO_INCREMENT,
  `tables_state` int(1) DEFAULT NULL,
  PRIMARY KEY (`tables_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tables
-- ----------------------------
INSERT INTO tables VALUES ('1', '1');
INSERT INTO tables VALUES ('2', '1');
INSERT INTO tables VALUES ('3', '1');
INSERT INTO tables VALUES ('4', '0');
INSERT INTO tables VALUES ('5', '0');
INSERT INTO tables VALUES ('6', '0');
INSERT INTO tables VALUES ('7', '0');
INSERT INTO tables VALUES ('8', '0');
INSERT INTO tables VALUES ('9', '0');
INSERT INTO tables VALUES ('10', '0');
INSERT INTO tables VALUES ('11', '0');
