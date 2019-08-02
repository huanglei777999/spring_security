/*
 Navicat Premium Data Transfer

 Source Server         : mysecurity
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 10.0.4.186:3306
 Source Schema         : spring_security

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 02/08/2019 15:56:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(2) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `auth` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'ROLE_USER', 'user');
INSERT INTO `role` VALUES (2, 'ROLE_ADMIN', 'user,admin');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(2) NOT NULL,
  `last_password_change` bigint(13) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('admin', '123456', 2, 0, 1);
INSERT INTO `user` VALUES ('guest', '123456', 1, 0, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
