/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : dqjs

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 04/12/2018 11:30:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���',
  `product_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��Ʒ��ҳͼƬurl',
  `product_enable` bigint(1) NOT NULL COMMENT 'ͣ��0 ʹ��1',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '��ҳ��Ʒ��' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for productid
-- ----------------------------
DROP TABLE IF EXISTS `productid`;
CREATE TABLE `productid`  (
  `productid_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '��ϸ��Ʒ���',
  `productid_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��ϸ��Ʒ��ҳͼƬurl',
  `productid_correspond` bigint(64) NOT NULL COMMENT '��ϸ��Ʒ��Ӧ��Ʒ���',
  PRIMARY KEY (`productid_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '��ҳ��Ʒ��' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for productname
-- ----------------------------
DROP TABLE IF EXISTS `productname`;
CREATE TABLE `productname`  (
  `productname_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '��Ʒ����id',
  `productname_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��Ʒ����',
  `productname_correspond` bigint(64) NOT NULL COMMENT '��Ӧ��Ʒid',
  PRIMARY KEY (`productname_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '��Ʒ����' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for producttable
-- ----------------------------
DROP TABLE IF EXISTS `producttable`;
CREATE TABLE `producttable`  (
  `producttable_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '�����������',
  `producttable_table` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��������',
  `producttable_correspond` bigint(64) NOT NULL COMMENT '���������Ӧ��ͼƬ',
  PRIMARY KEY (`producttable_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '������������' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for producttaobao
-- ----------------------------
DROP TABLE IF EXISTS `producttaobao`;
CREATE TABLE `producttaobao`  (
  `producttaobao_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '�������',
  `producttaobao_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�Ա�����',
  `producttaobao_correspond` bigint(64) NOT NULL COMMENT '������Ӧ�ı���',
  PRIMARY KEY (`producttaobao_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '��������' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for producttext
-- ----------------------------
DROP TABLE IF EXISTS `producttext`;
CREATE TABLE `producttext`  (
  `producttext_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '�������',
  `producttext_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��������',
  `producttext_parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��������',
  `producttext_correspond` bigint(64) NOT NULL COMMENT '������Ӧ�ı���',
  PRIMARY KEY (`producttext_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '��������' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
