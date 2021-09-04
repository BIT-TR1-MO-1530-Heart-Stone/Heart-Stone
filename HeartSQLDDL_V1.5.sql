/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : tourism_system

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 04/09/2021 12:12:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administration
-- ----------------------------
DROP TABLE IF EXISTS `administration`;
CREATE TABLE `administration`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `AdminPassword` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administration
-- ----------------------------
INSERT INTO `administration` VALUES (12345, 'Happier', '123456', '');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID，主键',
  `User_id` int(0) NULL DEFAULT NULL,
  `Post_id` int(0) NULL DEFAULT NULL,
  `Collection_date` datetime(0) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `Collection1`(`User_id`) USING BTREE,
  INDEX `Collection2`(`Post_id`) USING BTREE,
  CONSTRAINT `Collection1` FOREIGN KEY (`User_id`) REFERENCES `user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Collection2` FOREIGN KEY (`Post_id`) REFERENCES `post` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (1, NULL, NULL, '2016-03-24 20:45:11');
INSERT INTO `collection` VALUES (2, NULL, NULL, '2016-03-24 20:45:13');

-- ----------------------------
-- Table structure for followerlist
-- ----------------------------
DROP TABLE IF EXISTS `followerlist`;
CREATE TABLE `followerlist`  (
  `ID` int(0) NOT NULL,
  `User_id` int(0) NULL DEFAULT NULL,
  `Follower_id` int(0) NULL DEFAULT NULL,
  INDEX `FL1`(`User_id`) USING BTREE,
  INDEX `dad22`(`Follower_id`) USING BTREE,
  CONSTRAINT `dad22` FOREIGN KEY (`Follower_id`) REFERENCES `user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FL1` FOREIGN KEY (`User_id`) REFERENCES `user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of followerlist
-- ----------------------------

-- ----------------------------
-- Table structure for historypost
-- ----------------------------
DROP TABLE IF EXISTS `historypost`;
CREATE TABLE `historypost`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `User_id` int(0) NULL DEFAULT NULL,
  `Historypost_ID` int(0) NULL DEFAULT NULL,
  `Historypost_date` datetime(0) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `Historypost2`(`User_id`) USING BTREE,
  INDEX `Historypost_b2`(`Historypost_ID`) USING BTREE,
  CONSTRAINT `Historypost1` FOREIGN KEY (`User_id`) REFERENCES `user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Historypost_b2` FOREIGN KEY (`Historypost_ID`) REFERENCES `post` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of historypost
-- ----------------------------
INSERT INTO `historypost` VALUES (1222, NULL, NULL, '2011-11-11 00:00:00');

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID，主键',
  `Like_Time` datetime(0) NOT NULL COMMENT '喜欢时间',
  `User_id` int(0) NULL DEFAULT NULL COMMENT '外键',
  `Post_id` int(0) NULL DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `tt_fk_1`(`User_id`) USING BTREE,
  INDEX `tt_fk_2`(`Post_id`) USING BTREE,
  CONSTRAINT `tt_fk_1` FOREIGN KEY (`User_id`) REFERENCES `user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tt_fk_2` FOREIGN KEY (`Post_id`) REFERENCES `post` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of like
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID，主键',
  `Category` int(0) NOT NULL COMMENT '类别',
  `Title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点介绍',
  `Info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '价钱',
  `Picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `Date` datetime(0) NOT NULL COMMENT '开发时间',
  `User_id` int(0) NULL DEFAULT NULL COMMENT '作者id',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `post_1`(`User_id`) USING BTREE,
  CONSTRAINT `post_1` FOREIGN KEY (`User_id`) REFERENCES `user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 1, '“西湖十景”是指浙江省杭州市著名旅游景点西湖上的十处特色风景，分别是苏堤春晓、曲苑风荷、平湖秋月、断桥残雪、柳浪闻莺、花港观鱼、雷峰夕照、双峰插云、南屏晚钟、三潭印月。西湖十景形成于南宋时期，基本围绕西湖分布，有的就位于湖上。', '3000', '/source/images/20160319/201603191618.png', '2016-03-18 21:36:28', NULL);
INSERT INTO `post` VALUES (2, 2, '张家界景色很美，门票有点贵，火车站建得太小气了，不过森林公园太赞了，它美妙得展现了大自然的美丽，雄伟的山峰直插云霄。森林公园里环境优美，空气很清新，是真正的大自然风光。', '1', '/source/images/20160319/201603191920.png', '2016-03-20 16:24:32', NULL);

-- ----------------------------
-- Table structure for response
-- ----------------------------
DROP TABLE IF EXISTS `response`;
CREATE TABLE `response`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID，主键',
  `User_id` int(0) NOT NULL COMMENT '用户ID，外键',
  `Response_ID` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论编号',
  `Response_body` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论',
  `Response_time` datetime(0) NOT NULL,
  `Post_id` int(0) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `os_fk_1`(`User_id`) USING BTREE,
  INDEX `os_fk_2`(`Post_id`) USING BTREE,
  CONSTRAINT `os_fk_1` FOREIGN KEY (`User_id`) REFERENCES `user` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `os_fk_2` FOREIGN KEY (`Post_id`) REFERENCES `post` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of response
-- ----------------------------
INSERT INTO `response` VALUES (1, 1222, '2', '6000', '2016-03-18 21:41:11', 1);
INSERT INTO `response` VALUES (2, 1222, '2', '6000', '2016-03-18 21:41:29', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID，主键',
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `Fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Screenname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `Gender` int(0) NOT NULL,
  `Phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `Email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1222, '111111', '1', 'Nicky', 1, '15511231222', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
