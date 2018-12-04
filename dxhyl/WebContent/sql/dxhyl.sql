/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : jdhyl

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 04/12/2018 21:22:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_computer
-- ----------------------------
DROP TABLE IF EXISTS `base_computer`;
CREATE TABLE `base_computer`  (
  `computer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '���',
  `computer_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��ֽurl',
  `computer_enable` bigint(1) NOT NULL COMMENT 'ͣ��0 ʹ��1',
  `computer_creationtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '����ʱ��',
  PRIMARY KEY (`computer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '���Ա�ֽ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for base_dict
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '�ʺ����',
  `dict_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�ʺ�����',
  `dict_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�ʺ�email',
  `dict_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�ʺ�����',
  `dict_enable` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '���0 ʹ��1',
  `dict_creationtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '����ʱ��',
  PRIMARY KEY (`dict_id`) USING BTREE,
  INDEX `idx_start_time`(`dict_name`) USING BTREE,
  INDEX `idx_end_time`(`dict_email`) USING BTREE,
  INDEX `idx_create_time`(`dict_password`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '�ʺű�' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for base_longin
-- ----------------------------
DROP TABLE IF EXISTS `base_longin`;
CREATE TABLE `base_longin`  (
  `longin_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '���',
  `longin_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��ֽurl',
  `longin_enable` bigint(1) NOT NULL COMMENT 'ͣ��0 ʹ��1',
  `longin_creationtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '����ʱ��',
  PRIMARY KEY (`longin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '�����ֻ���ֽ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for base_phone
-- ----------------------------
DROP TABLE IF EXISTS `base_phone`;
CREATE TABLE `base_phone`  (
  `phone_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '���',
  `phone_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��ֽurl',
  `phone_enable` bigint(1) NOT NULL COMMENT 'ͣ��0 ʹ��1',
  `phone_creationtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '����ʱ��',
  PRIMARY KEY (`phone_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '�ֻ���ֽ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for base_schoolview
-- ----------------------------
DROP TABLE IF EXISTS `base_schoolview`;
CREATE TABLE `base_schoolview`  (
  `schoolview_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '���',
  `schoolview_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��ֽurl',
  `schoolview_enable` bigint(1) NOT NULL COMMENT 'ͣ��0 ʹ��1',
  `schoolview_creationtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '����ʱ��',
  PRIMARY KEY (`schoolview_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'У����ֽ' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
