/*
 Navicat Premium Data Transfer

 Source Server         : service
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : service.cf:3306
 Source Schema         : office

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 28/04/2022 17:20:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, '今天上班...', '2022-04-28 16:00:08', '2022-04-28 10:01:12');
INSERT INTO `banner` VALUES (2, '今天放假...', '2022-04-28 16:00:50', '2022-04-28 16:00:50');

-- ----------------------------
-- Table structure for depa
-- ----------------------------
DROP TABLE IF EXISTS `depa`;
CREATE TABLE `depa`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `depa_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depa
-- ----------------------------
INSERT INTO `depa` VALUES (1, '开发', '2022-04-28 16:09:20', '2022-04-28 16:09:20');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(2) NULL DEFAULT NULL COMMENT '类型（1- 通知 2-汇报）',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id（发送者）',
  `receive_user_id` bigint(20) NULL DEFAULT NULL COMMENT '接收者id',
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '消息内容',
  `files` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '附件',
  `status` int(2) NULL DEFAULT 0 COMMENT '是否读（0-未确认 1-出错 2-已确认）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消息/汇报' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, 2, 3, '通知1', 'https://minio.service.cf/file/%E5%9C%A8%E7%BA%BF%E5%8A%9E%E5%85%AC%E7%B3%BB%E7%BB%9F-05ce6acd2ace4e21947ddec635a19545.docx', 0, '2022-04-28 16:43:54', '2022-04-28 10:57:12');
INSERT INTO `message` VALUES (2, 2, 3, 2, '汇报1', 'https://minio.service.cf/file/%E5%9C%A8%E7%BA%BF%E5%8A%9E%E5%85%AC%E7%B3%BB%E7%BB%9F-05ce6acd2ace4e21947ddec635a19545.docx', 1, '2022-04-28 16:48:10', '2022-04-28 11:12:03');
INSERT INTO `message` VALUES (3, 2, 3, 2, '汇报2', 'https://minio.service.cf/file/%E5%9C%A8%E7%BA%BF%E5%8A%9E%E5%85%AC%E7%B3%BB%E7%BB%9F-05ce6acd2ace4e21947ddec635a19545.docx', 0, '2022-04-28 17:12:17', '2022-04-28 17:12:17');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `sex` int(2) NULL DEFAULT NULL COMMENT '性别（1-男 2-女）',
  `depa_id` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  `depa_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `type` int(2) NULL DEFAULT 1 COMMENT '类型（1-管理员 2-领导 3-员工）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `un`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '管理员', 'e10adc3949ba59abbe56e057f20f883e', 1, NULL, NULL, 1, '2022-04-28 16:27:59', '2022-04-28 10:30:01');
INSERT INTO `user` VALUES (2, 'leader1', '领导1', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, '开发', 2, '2022-04-28 16:29:30', '2022-04-28 10:34:49');
INSERT INTO `user` VALUES (3, 'user1', '员工1', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, '开发', 3, '2022-04-28 16:31:20', '2022-04-28 10:34:51');

SET FOREIGN_KEY_CHECKS = 1;
