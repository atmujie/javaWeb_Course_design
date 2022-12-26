/*
 Navicat Premium Data Transfer

 Source Server         : mysql5
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : proclinic

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 11/11/2022 22:52:15
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `doctor_info`;
CREATE TABLE `doctor_info`  (
  `doctor_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '医生id',
  `doctor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医生姓名',
  `doctor_sex` enum('男','女','') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '医生性别',
  `doctor_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属科室',
  `doctor_status` int(1) NULL DEFAULT NULL COMMENT '医生状态',
  `doctor_work_age` int(2) NULL DEFAULT NULL COMMENT '医生从业年龄',
  `doctor_age` int(3) NULL DEFAULT NULL COMMENT '医生年龄',
  `doctor_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  `doctor_photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医生照片保存路径',
  PRIMARY KEY (`doctor_id`)
);

-- ----------------------------
-- Records of doctor_info
-- ----------------------------
INSERT INTO `doctor_info` VALUES (1, '刘明', '男', '儿科', 1, 6, 30, '15101236253', NULL);
INSERT INTO `doctor_info` VALUES (2, '李明', '男', '眼科', 1, 23, 57, '17532361123', NULL);
INSERT INTO `doctor_info` VALUES (3, '玛莉', '女', '皮肤科', 2, 10, 40, '13391764856', NULL);
INSERT INTO `doctor_info` VALUES (4, '刘理', '男', '骨科', 1, 5, 30, '15566332255', '');
INSERT INTO `doctor_info` VALUES (22, '韦永永', '男', '心内科', 2, 20, 47, '15122365478', '');
INSERT INTO `doctor_info` VALUES (6, '李五', '男', '耳鼻喉科', 1, 13, 45, '13322336545', '');
INSERT INTO `doctor_info` VALUES (7, '马舞', '女', '儿科', 1, 11, 43, '14569826565', '');
INSERT INTO `doctor_info` VALUES (17, '李四', '男', '精神科', 1, 19, 40, '15666335533', '');
INSERT INTO `doctor_info` VALUES (18, '光头墙', '男', '骨科', 1, 20, 50, '11122223333', '');

-- ----------------------------
-- Table structure for patient_info
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info`  (
  `patient_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '病人id，主键，不可空，不可重复',
  `patient_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '佚名' COMMENT '病人姓名，不可空，默认为佚名',
  `patient_age` int(3) NULL DEFAULT NULL COMMENT '病人年龄，可空',
  `patient_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '病人电话号码',
  `patient_birth` date NULL DEFAULT NULL COMMENT '病人出生日期',
  `patient_email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病人邮箱',
  `patient_sex` enum('','男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '病人性别',
  `patient_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病人家庭住址',
  `patient_case` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '病例',
  PRIMARY KEY (`patient_id`)
);

-- ----------------------------
-- Records of patient_info
-- ----------------------------
INSERT INTO `patient_info` VALUES (1, '小强', 12, '13366665555', '2005-03-10', NULL, '男', '神威北大街', NULL);
INSERT INTO `patient_info` VALUES (4, '张三', 11, '12345678978', '2022-11-10', '112233@qq.com', '男', '111', '11');
INSERT INTO `patient_info` VALUES (16, '小李子', 15, '12345678912', '2022-11-11', '123456@qq.com', '男', '华科', '123');
INSERT INTO `patient_info` VALUES (13, '刘莉莉', 13, '11122233322', '2008-05-11', '1234@qq.com', '女', '酒仙桥', '13');
INSERT INTO `patient_info` VALUES (15, '王某元', 13, '11122233322', '2001-06-08', '1234@qq.com', '男', '防灾北区219', '13');

-- ----------------------------
-- Table structure for user_admin
-- ----------------------------
DROP TABLE IF EXISTS `user_admin`;
CREATE TABLE `user_admin`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名，主键，不可空，不可重复',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码，不可空，md5存储',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱，可空',
  PRIMARY KEY (`username`)
);

-- ----------------------------
-- Records of user_admin
-- ----------------------------
INSERT INTO `user_admin` VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', '2633298206@qq.com');
INSERT INTO `user_admin` VALUES ('atmujie', '21232f297a57a5a743894a0e4a801fc3', '2633298206@qq.com');
INSERT INTO `user_admin` VALUES ('admin123', '21232f297a57a5a743894a0e4a801fc3', '2633298206@qq.com');
INSERT INTO `user_admin` VALUES ('admin12', '21232f297a57a5a743894a0e4a801fc3', '2633298206@qq.com');
INSERT INTO `user_admin` VALUES ('123', '21232f297a57a5a743894a0e4a801fc3', '2633298206@qq.com');
INSERT INTO `user_admin` VALUES ('root', '21232f297a57a5a743894a0e4a801fc3', '112233@qq.com');

-- ----------------------------
-- Table structure for waiting_info
-- ----------------------------
DROP TABLE IF EXISTS `waiting_info`;
CREATE TABLE `waiting_info`  (
  `waiting_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '接诊id',
  `waiting_patient_id` int(10) NOT NULL COMMENT '病人id',
  `waiting_doctor_id` int(10) NULL DEFAULT NULL COMMENT '医生id',
  `waiting_status` int(4) NOT NULL DEFAULT 2 COMMENT '状态',
  `waiting_update` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `waiting_cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '医疗费用',
  `waiting_discount` float(10, 4) NULL DEFAULT NULL COMMENT '折扣',
  `waiting_date` date NULL DEFAULT NULL COMMENT '就诊日期',
  PRIMARY KEY (`waiting_id`)
);
-- ----------------------------
-- Records of waiting_info
-- ----------------------------
INSERT INTO `waiting_info` VALUES (1, 1, NULL, 2, '2022-11-10 23:51:02', NULL, NULL, '2022-11-09');
INSERT INTO `waiting_info` VALUES (3, 4, NULL, 2, '2022-11-10 23:50:28', NULL, NULL, '2022-11-10');
INSERT INTO `waiting_info` VALUES (15, 16, NULL, 2, '2022-11-11 12:51:11', NULL, NULL, '2022-11-11');
INSERT INTO `waiting_info` VALUES (12, 13, NULL, 2, '2022-11-11 11:04:49', NULL, NULL, '2022-11-11');
INSERT INTO `waiting_info` VALUES (14, 15, NULL, 2, '2022-11-11 11:33:55', NULL, NULL, '2022-11-11');

SET FOREIGN_KEY_CHECKS = 1;
