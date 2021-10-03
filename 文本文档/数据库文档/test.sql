/*
 Navicat Premium Data Transfer

 Source Server         : www.onecbuying.com
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 03/10/2021 22:43:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `questionId` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) DEFAULT NULL COMMENT '问题(10-8=?)',
  `optionA` varchar(20) DEFAULT NULL COMMENT '选项1(A:9)',
  `optionB` varchar(20) DEFAULT NULL COMMENT '选项2(B:1)',
  `optionC` varchar(20) DEFAULT NULL COMMENT '选项3 (C:2)',
  `optionD` varchar(20) DEFAULT NULL COMMENT '选项4(D:0)',
  `answer` char(1) DEFAULT NULL COMMENT '正确答案',
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷表';

-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES (1, '60-40=?', '10', '30', '40', '20', 'D');
INSERT INTO `question` VALUES (3, '30*7=?', '210', '390', '599', '100', 'A');
INSERT INTO `question` VALUES (4, '6*3=?', '12', '18', '16', '14', 'B');
INSERT INTO `question` VALUES (6, '60-43=?', '16', '17', '18', '19', 'B');
INSERT INTO `question` VALUES (7, '70/2=?', '40', '36', '35', '24', 'C');
INSERT INTO `question` VALUES (8, '70/2=?', '40', '42', '35', '35', 'C');
INSERT INTO `question` VALUES (9, '30*20=?', '210', '499', '599', '600', 'D');
INSERT INTO `question` VALUES (10, 'Material ', '妹妹', '叔叔', '爸爸', '姐姐', 'C');
INSERT INTO `question` VALUES (11, 'UI Material Theme UI', 'green', 'yellow', 'pink', 'purple', 'C');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT ' 用户编号',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别(‘男’或‘女’)',
  `email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'mike', '123', '男', 'mike@q163.com');
INSERT INTO `users` VALUES (2, 'smith', '123', '男', 'smith@q163.com');
INSERT INTO `users` VALUES (20, 'tom', '123', '男', 'tom@q163.com');
INSERT INTO `users` VALUES (21, 'king', '123', '男', 'king@q163.com');
INSERT INTO `users` VALUES (27, '2', '2', '男', '2@qq.com');
INSERT INTO `users` VALUES (28, '3', '3', '男', '3@qq.com');
INSERT INTO `users` VALUES (29, '4', '4', '男', '4@qq.com');
INSERT INTO `users` VALUES (30, NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
