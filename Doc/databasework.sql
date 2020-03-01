/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : databasework

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 21/06/2019 21:55:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `aId` int(11) NOT NULL AUTO_INCREMENT,
  `uId` int(11) DEFAULT NULL,
  `aName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `aCreationTime` date NOT NULL,
  `aDeadlineTime` date NOT NULL,
  `aParticipation` int(11) DEFAULT 0,
  `aAbstract` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `aDescription` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `aStatus` int(11) DEFAULT 1,
  `aNotice` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `aAddress` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`aId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (16, 1, '图灵运动挑战赛', '2019-06-13', '2019-06-13', 0, '身为重邮人，挑战不可能', '此活动是计算机科学与技术学院团总支学生会围绕“三走”为主题策划的，为营造整个学院的体育竞技氛围，旨在通过挑战赛的方式，达到让学生走出寝室，走下网络，走向操场的目的。并能让全院学生达到锻炼身体的效果，促进学生培养一个良好的运动习惯。', 1, '每晚8点到10点，图灵运动挑战赛与你再度相约风华运动场。\n     本次挑战赛有长跑、飞镖、跳绳、踢毽、呼啦圈等主打项目。让你在课余时间恣意运动，体验运动带给你的乐趣！', '老操（风华操场）');
INSERT INTO `activity` VALUES (48, 10, '中国传统文化节', '2019-06-21', '2019-06-24', 0, '体味中国传统文化艺术', '16日传统记忆日投壶、刺绣、九连环；国画、折扇、鲁班锁......快乐相伴，精彩共享！17日社团活动日笔歌墨舞(兰亭书社)、箭无虚发(射箭协会)、棋逢对手(棋牌社)、以书会友（南山文学社）......文韬武略，中华之魂！更有15日晚皮影戏、16日晚灯谜会等着你！', 1, '！16日传统记忆日投壶、刺绣、九连环；国画、折扇、鲁班锁......快乐相伴，精彩共享！17日社团活动日笔歌墨舞(兰亭书社)、箭无虚发(射箭协会)、棋逢对手(棋牌社)、以书会友（南山文学社）......文韬武略，中华之魂！更有15日晚皮影戏、16日晚灯谜会等着你！', '老图书馆门口');
INSERT INTO `activity` VALUES (55, 10, '测试活动', '2019-06-21', '2019-06-22', 0, '测试活动', '测试活动', 1, '哎呀！该活动暂时还没有公告啊', '测试地点');

-- ----------------------------
-- Table structure for applicationcontent
-- ----------------------------
DROP TABLE IF EXISTS `applicationcontent`;
CREATE TABLE `applicationcontent`  (
  `fId` int(11) DEFAULT NULL,
  `uId` int(11) DEFAULT NULL,
  `content` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  INDEX `fId`(`fId`) USING BTREE,
  CONSTRAINT `applicationcontent_ibfk_1` FOREIGN KEY (`fId`) REFERENCES `field` (`fId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of applicationcontent
-- ----------------------------
INSERT INTO `applicationcontent` VALUES (69, 1, 'zhangsan');
INSERT INTO `applicationcontent` VALUES (70, 1, '1762862861794');
INSERT INTO `applicationcontent` VALUES (71, 1, '1762861794@qq.com');
INSERT INTO `applicationcontent` VALUES (72, 1, '2016365412');
INSERT INTO `applicationcontent` VALUES (69, 1, 'zhangsan');
INSERT INTO `applicationcontent` VALUES (70, 1, '1225541122');
INSERT INTO `applicationcontent` VALUES (71, 1, '2135445102');
INSERT INTO `applicationcontent` VALUES (72, 1, '12312313123');
INSERT INTO `applicationcontent` VALUES (69, 1, 'zhangsan');
INSERT INTO `applicationcontent` VALUES (70, 1, '1225541122');
INSERT INTO `applicationcontent` VALUES (71, 1, '2135445102');
INSERT INTO `applicationcontent` VALUES (72, 1, '12312313123');
INSERT INTO `applicationcontent` VALUES (69, 1, 'zhangsan');
INSERT INTO `applicationcontent` VALUES (70, 1, '1225541122');
INSERT INTO `applicationcontent` VALUES (71, 1, '2135445102');
INSERT INTO `applicationcontent` VALUES (72, 1, '12312313123');
INSERT INTO `applicationcontent` VALUES (69, 1, 'zhangsan');
INSERT INTO `applicationcontent` VALUES (70, 1, '1225541122');
INSERT INTO `applicationcontent` VALUES (71, 1, '2135445102');
INSERT INTO `applicationcontent` VALUES (72, 1, '12312313123');
INSERT INTO `applicationcontent` VALUES (51, 10, 'ljc@163.com');
INSERT INTO `applicationcontent` VALUES (52, 10, '1231534231');
INSERT INTO `applicationcontent` VALUES (69, 1, 'ss');
INSERT INTO `applicationcontent` VALUES (70, 1, '1235551');
INSERT INTO `applicationcontent` VALUES (71, 1, '123123131@163.com');
INSERT INTO `applicationcontent` VALUES (72, 1, '2514521445');
INSERT INTO `applicationcontent` VALUES (51, 1, '1542541@163.com');
INSERT INTO `applicationcontent` VALUES (52, 1, '15231315345');

-- ----------------------------
-- Table structure for childactivity
-- ----------------------------
DROP TABLE IF EXISTS `childactivity`;
CREATE TABLE `childactivity`  (
  `caId` int(11) NOT NULL AUTO_INCREMENT,
  `aId` int(11) NOT NULL,
  `caName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `caDescription` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `caScore` int(11) DEFAULT 0,
  `caDayMaxJoin` int(11) DEFAULT 1,
  `caIsAvailable` tinyint(1) DEFAULT 1,
  `flag` int(2) NOT NULL,
  `minScore` int(11) DEFAULT NULL,
  `maxScore` int(11) DEFAULT NULL,
  PRIMARY KEY (`caId`) USING BTREE,
  INDEX `aId`(`aId`) USING BTREE,
  CONSTRAINT `childactivity_ibfk_1` FOREIGN KEY (`aId`) REFERENCES `activity` (`aId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of childactivity
-- ----------------------------
INSERT INTO `childactivity` VALUES (23, 16, '趣味飞镖', '趣味飞镖', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (24, 16, '跳绳', '跳绳', 2, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (25, 16, '踢毽子', '踢毽子', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (26, 16, '1000米跑', '1000米跑', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (27, 16, '投篮', '投篮', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (36, 48, '刺绣', '刺绣', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (37, 48, '投壶', '投壶', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (38, 48, '鲁班锁', '鲁班锁', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (39, 48, '皮影戏', '皮影戏', 0, 1, 1, 0, NULL, NULL);
INSERT INTO `childactivity` VALUES (51, 55, '活动项目一', '活动项目一的描述', 0, 1, 1, 0, NULL, NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cId` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) DEFAULT NULL,
  `fromUid` int(11) DEFAULT NULL,
  `toCid` int(11) DEFAULT NULL,
  `content` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `commentTime` date DEFAULT NULL,
  PRIMARY KEY (`cId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (25, 31, 1, 0, '哇塞，活动奖品也太丰富了吧，大家快来啊！！！', '2019-06-13');
INSERT INTO `comment` VALUES (26, 31, 10, 0, '这活动还蛮有意思的嘛，特别是趣味飞镖，太好玩了，下次我还要来玩', '2019-06-13');
INSERT INTO `comment` VALUES (27, 31, 1, 0, '巧了，我也喜欢玩趣味飞镖', '2019-06-13');
INSERT INTO `comment` VALUES (28, 31, 1, 26, '巧了，我也喜欢玩趣味飞镖', '2019-06-13');
INSERT INTO `comment` VALUES (29, 40, 1, 0, '这个传统文化节还是不错', '2019-06-21');
INSERT INTO `comment` VALUES (30, 40, 10, 29, '我也觉得', '2019-06-21');
INSERT INTO `comment` VALUES (31, 40, 2, 0, '我觉得那个射箭的活动搞得多可以的，大家可以去试试啊', '2019-06-21');
INSERT INTO `comment` VALUES (32, 31, 2, 26, '我也觉得还可以，下次一起啊', '2019-06-21');
INSERT INTO `comment` VALUES (33, 46, 1, 0, '睡懒觉不好啊    早睡早起', '2019-06-21');
INSERT INTO `comment` VALUES (34, 46, 10, 0, '没办法嘛   flag才立就倒   我也很无奈啊', '2019-06-21');
INSERT INTO `comment` VALUES (35, 46, 2, 34, '那可不一定   像我就能早睡早起   ', '2019-06-21');
INSERT INTO `comment` VALUES (36, 40, 1, 0, '中国传统文化节让我尝试了古代好多有趣的东西啊，特别是那个投壶，原来觥筹交错说的就是这个，涨见识了！', '2019-06-21');
INSERT INTO `comment` VALUES (37, 40, 1, 0, '一条评论', '2019-06-21');
INSERT INTO `comment` VALUES (38, 40, 1, 36, '回复评论', '2019-06-21');
INSERT INTO `comment` VALUES (39, 40, 1, 0, '发布评论', '2019-06-21');
INSERT INTO `comment` VALUES (40, 40, 1, 31, '回复评论', '2019-06-21');
INSERT INTO `comment` VALUES (41, 46, 1, 34, '  回复', '2019-06-21');

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field`  (
  `fId` int(11) NOT NULL AUTO_INCREMENT,
  `aId` int(11) DEFAULT NULL,
  `fieldName` varchar(28) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fieldNotice` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`fId`) USING BTREE,
  INDEX `aId`(`aId`) USING BTREE,
  CONSTRAINT `field_ibfk_1` FOREIGN KEY (`aId`) REFERENCES `activity` (`aId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES (51, 16, '邮箱', '请输入邮箱');
INSERT INTO `field` VALUES (52, 16, '学号', '请输入学号');
INSERT INTO `field` VALUES (69, 48, '姓名', '请输入姓名');
INSERT INTO `field` VALUES (70, 48, 'QQ', '请输入QQ');
INSERT INTO `field` VALUES (71, 48, '邮箱', '请输入邮箱');
INSERT INTO `field` VALUES (72, 48, '学号', '请输入学号');
INSERT INTO `field` VALUES (89, 55, NULL, NULL);

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`  (
  `iId` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) DEFAULT NULL,
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`iId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES (1, 1, '3f6bd1ae79a64842a258155e5176c609.jpg', 0);
INSERT INTO `images` VALUES (2, 2, '4.jpg', 0);
INSERT INTO `images` VALUES (3, 3, '1.jpg', 0);
INSERT INTO `images` VALUES (4, 4, '2.jpg', 0);
INSERT INTO `images` VALUES (5, 5, '6.jpg', 0);
INSERT INTO `images` VALUES (6, 6, '1.jpg', 0);
INSERT INTO `images` VALUES (7, 7, '3.jpg', 0);
INSERT INTO `images` VALUES (8, 4, '2.jpg', 0);
INSERT INTO `images` VALUES (9, 8, '1.jpg', 0);
INSERT INTO `images` VALUES (10, 4, '3.jpg', 1);
INSERT INTO `images` VALUES (11, 1, '1.jpg', 1);
INSERT INTO `images` VALUES (12, 1, '1.jpg', 2);
INSERT INTO `images` VALUES (13, 9, '1.jpg', 1);
INSERT INTO `images` VALUES (14, 10, '3e2f9db4386d48298e8fd186a4c85120.jpg', 0);
INSERT INTO `images` VALUES (15, 11, '1.jpg', 0);
INSERT INTO `images` VALUES (16, 12, '3.jpg', 0);
INSERT INTO `images` VALUES (17, 13, '1.jpg', 0);
INSERT INTO `images` VALUES (18, 14, '1.jpg', 0);
INSERT INTO `images` VALUES (19, 15, '1.jpg', 1);
INSERT INTO `images` VALUES (20, 16, '1.jpg', 0);
INSERT INTO `images` VALUES (29, 1, 'ae51378e989c495ea16d65452e95b19a.jpg', 2);
INSERT INTO `images` VALUES (30, 3, '76f1dc4294eb4594b98b3bc183f3c813.jpg', 2);
INSERT INTO `images` VALUES (31, 4, '0abb651d5d0b41e685cf5506f8bf937d.jpg', 2);
INSERT INTO `images` VALUES (32, 2, '11906ff37f984cd8948f22821e59e80f.jpg', 2);
INSERT INTO `images` VALUES (33, 2, '257fb27c00574b86813dd06a366e0683.jpg', 2);
INSERT INTO `images` VALUES (34, 3, '6478509dda1e4d38864d717f011b9a0e.jpg', 2);
INSERT INTO `images` VALUES (35, 1, '4d2dd6b690594e298e1e26f88936eeec.jpg', 2);
INSERT INTO `images` VALUES (36, 3, 'c7980db518a443399f43cd938412a030.jpg', 2);
INSERT INTO `images` VALUES (37, 17, '1.jpg', 0);
INSERT INTO `images` VALUES (38, 18, '1.jpg', 0);
INSERT INTO `images` VALUES (39, 19, '1.jpg', 0);
INSERT INTO `images` VALUES (40, 3, 'fdc8273666b349259b1d47c95203ef38.jpg', 2);
INSERT INTO `images` VALUES (41, 4, 'a76dfd2d6c1a4e3793b6afd93fd1afcf.jpg', 1);
INSERT INTO `images` VALUES (42, 2, 'be8f372ee08a48039f2d03e1612640b8.jpg', 2);
INSERT INTO `images` VALUES (43, 30, '4a0fa9e4480c4e699fd04adcbb4d3a45.jpg', 2);
INSERT INTO `images` VALUES (44, 30, '7472519f9fd84ec89cc6749f90624170.jpg', 2);
INSERT INTO `images` VALUES (45, 30, '90b43c7f96cf4986abf36554ffea2015.jpg', 2);
INSERT INTO `images` VALUES (46, 16, 'tuling.jpg', 1);
INSERT INTO `images` VALUES (47, 16, 'tuling01.jpg', 1);
INSERT INTO `images` VALUES (48, 16, 'tuling02.jpg', 1);
INSERT INTO `images` VALUES (49, 0, 'b25a264919b746808e78620366859561.jpg', 1);
INSERT INTO `images` VALUES (50, 0, '3994cfecf10a4b338197b2471d5b32b8.jpg', 1);
INSERT INTO `images` VALUES (51, 0, '60fca31ccbce4002aa5d76119ac077cb.jpg', 1);
INSERT INTO `images` VALUES (52, 0, '1e9b1c443c064280a5bdeb4b17533afc.jpg', 1);
INSERT INTO `images` VALUES (53, 0, '8eda7edab3954a57bf8e1d951367d96d.jpg', 1);
INSERT INTO `images` VALUES (54, 0, '58c057ccff654b3fab18902e80b73bda.jpg', 1);
INSERT INTO `images` VALUES (55, 0, '7aaf77c01c48477b829ea02f8263003d.jpg', 1);
INSERT INTO `images` VALUES (56, 23, '6dd5a1bda52f48c3aa4552bfccdcf8f1.jpg', 1);
INSERT INTO `images` VALUES (57, 23, 'dd6cbcd8413d4ace91be51c526c6555e.jpg', 1);
INSERT INTO `images` VALUES (58, 23, '487dbb8c1bbe4b7ba173df32a24f91fd.jpg', 1);
INSERT INTO `images` VALUES (59, 23, '437be565145b473bbb67de468b19967d.jpg', 1);
INSERT INTO `images` VALUES (60, 24, '866d9fb32c8c4afc921df6e40f45830c.jpg', 1);
INSERT INTO `images` VALUES (61, 24, 'e8e2486e3cbe421993a83107d1e5a831.jpg', 1);
INSERT INTO `images` VALUES (62, 48, '2658713d495e434ebae2ccf992082c19.jpg', 1);
INSERT INTO `images` VALUES (63, 48, '628a7980182d41eda3f9825c751e7006.jpg', 1);
INSERT INTO `images` VALUES (64, 48, 'aaced0d4d0734484aabf8e4bc769ffab.jpg', 1);
INSERT INTO `images` VALUES (65, 48, '2d196128aaae4ec6a70c38a203bdf81c.jpg', 1);
INSERT INTO `images` VALUES (66, 48, '9cd1a8e7851d438ebd71dfa87e775ad8.jpg', 1);
INSERT INTO `images` VALUES (67, 48, '3ef597c7171f4f1bb356e799bec4ba99.jpg', 1);
INSERT INTO `images` VALUES (68, 41, '858c8ac48e2b4a7cb0c2ecdd7f2c2390.jpg', 2);
INSERT INTO `images` VALUES (69, 41, '8d047ecf51fa4c8fa788785f1c7e4465.jpg', 2);
INSERT INTO `images` VALUES (70, 41, '03e8794f1b8747b0a01640d708f65d77.jpg', 2);
INSERT INTO `images` VALUES (71, 41, 'c01b994acdf34fad9e14df47f984d780.jpg', 2);
INSERT INTO `images` VALUES (72, 41, 'e54802b0469d4cce88e73862dbf8ddf7.jpg', 2);
INSERT INTO `images` VALUES (73, 41, 'd110d86378e24ca0a920887979fe95b0.jpg', 2);
INSERT INTO `images` VALUES (74, 43, '8235b47225714e59b43ea429e008618f.jpg', 2);
INSERT INTO `images` VALUES (75, 43, 'eb27ce891ea94888b5d3b0d7ac400e59.jpg', 2);
INSERT INTO `images` VALUES (76, 43, '9441ddfe1cf04316aef8439ccc2f6400.jpg', 2);
INSERT INTO `images` VALUES (77, 45, '18a06d36ceae46bd90ca1f74004aa892.jpg', 2);
INSERT INTO `images` VALUES (78, 50, '6.jpg', 1);
INSERT INTO `images` VALUES (79, 50, '3.jpg', 1);
INSERT INTO `images` VALUES (80, 46, '8628a81589da4d67a2dbbd77dcdf516f.jpg', 2);
INSERT INTO `images` VALUES (81, 53, '9a9a1d83c3204d9b88c9fb26271da32c.jpg', 1);
INSERT INTO `images` VALUES (82, 53, 'b5323afb52c0430ebcc8cb6c48bedfb4.jpg', 1);
INSERT INTO `images` VALUES (83, 53, '7860edf27d6449bdb976973bc96258d4.jpg', 1);
INSERT INTO `images` VALUES (84, 54, '20843b95c1864a899565a22e6cb520d1.jpg', 1);
INSERT INTO `images` VALUES (85, 54, 'f2015eadaa37466c9225eb926752f1b0.jpg', 1);
INSERT INTO `images` VALUES (86, 55, 'a06ce14385cb43cfaffe165a9c27bc21.jpg', 1);
INSERT INTO `images` VALUES (87, 55, 'b876ed26d10840c6887b4e84b735345a.jpg', 1);

-- ----------------------------
-- Table structure for joincaform
-- ----------------------------
DROP TABLE IF EXISTS `joincaform`;
CREATE TABLE `joincaform`  (
  `uId` int(11) DEFAULT NULL,
  `caId` int(11) DEFAULT NULL,
  `joinTime` date DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  INDEX `uId`(`uId`) USING BTREE,
  INDEX `caId`(`caId`) USING BTREE,
  CONSTRAINT `joincaform_ibfk_1` FOREIGN KEY (`uId`) REFERENCES `userinfo` (`uId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `joincaform_ibfk_2` FOREIGN KEY (`caId`) REFERENCES `childactivity` (`caId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of joincaform
-- ----------------------------
INSERT INTO `joincaform` VALUES (1, 39, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 38, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 37, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (10, 23, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (10, 26, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (10, 24, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 39, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 38, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 37, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 23, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 25, '2019-06-21', 0, 0);
INSERT INTO `joincaform` VALUES (1, 26, '2019-06-21', 0, 0);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `aId` int(11) DEFAULT NULL,
  `caId` int(11) NOT NULL,
  `uId` int(11) NOT NULL,
  `mDeadTime` bigint(20) NOT NULL,
  PRIMARY KEY (`caId`, `uId`) USING BTREE,
  INDEX `aId`(`aId`) USING BTREE,
  INDEX `uId`(`uId`) USING BTREE,
  CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`aId`) REFERENCES `activity` (`aId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `manager_ibfk_2` FOREIGN KEY (`uId`) REFERENCES `userinfo` (`uId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `manager_ibfk_3` FOREIGN KEY (`caId`) REFERENCES `childactivity` (`caId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (16, 23, 10, 1560958186258);
INSERT INTO `manager` VALUES (16, 24, 10, 1560958186258);
INSERT INTO `manager` VALUES (16, 25, 10, 1560958186258);
INSERT INTO `manager` VALUES (16, 26, 10, 1560958186258);
INSERT INTO `manager` VALUES (16, 27, 10, 1560958186258);
INSERT INTO `manager` VALUES (48, 36, 10, 1561117869584);
INSERT INTO `manager` VALUES (48, 36, 11, 1561117869584);
INSERT INTO `manager` VALUES (48, 36, 14, 1561129775459);
INSERT INTO `manager` VALUES (48, 36, 16, 1561130582563);
INSERT INTO `manager` VALUES (48, 37, 10, 1561117869584);
INSERT INTO `manager` VALUES (48, 37, 11, 1561117869584);
INSERT INTO `manager` VALUES (48, 37, 14, 1561129775459);
INSERT INTO `manager` VALUES (48, 37, 16, 1561130582563);
INSERT INTO `manager` VALUES (48, 38, 10, 1561117869584);
INSERT INTO `manager` VALUES (48, 38, 11, 1561117869584);
INSERT INTO `manager` VALUES (48, 38, 14, 1561129775459);
INSERT INTO `manager` VALUES (48, 38, 16, 1561130582563);
INSERT INTO `manager` VALUES (48, 39, 10, 1561117869584);
INSERT INTO `manager` VALUES (48, 39, 11, 1561117869584);
INSERT INTO `manager` VALUES (48, 39, 14, 1561129775459);
INSERT INTO `manager` VALUES (48, 39, 16, 1561130582563);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `nId` int(11) NOT NULL AUTO_INCREMENT,
  `aId` int(11) DEFAULT NULL,
  `content` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `noticeTime` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`nId`) USING BTREE,
  INDEX `aId`(`aId`) USING BTREE,
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`aId`) REFERENCES `activity` (`aId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for publishmessage
-- ----------------------------
DROP TABLE IF EXISTS `publishmessage`;
CREATE TABLE `publishmessage`  (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `uId` int(11) DEFAULT NULL,
  `aId` int(11) DEFAULT NULL,
  `praiseCount` int(11) DEFAULT 0,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`pId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publishmessage
-- ----------------------------
INSERT INTO `publishmessage` VALUES (31, 0, 16, 0, '此活动是计算机科学与技术学院团总支学生会围绕“三走”为主题策划的，为营造整个学院的体育竞技氛围，旨在通过挑战赛的方式，达到让学生走出寝室，走下网络，走向操场的目的。并能让全院学生达到锻炼身体的效果，促进学生培养一个良好的运动习惯。');
INSERT INTO `publishmessage` VALUES (40, 0, 48, 0, '16日传统记忆日投壶、刺绣、九连环；国画、折扇、鲁班锁......快乐相伴，精彩共享！17日社团活动日笔歌墨舞(兰亭书社)、箭无虚发(射箭协会)、棋逢对手(棋牌社)、以书会友（南山文学社）......文韬武略，中华之魂！更有15日晚皮影戏、16日晚灯谜会等着你！');
INSERT INTO `publishmessage` VALUES (44, 0, 50, 0, '大家一起来吃粽子啊');
INSERT INTO `publishmessage` VALUES (45, 1, 0, 0, '“日北至，日长之至，日影短至，故曰夏至。至者，极也。”\n今日23时54分迎来夏至，夏至将至，炎热将至\n（图via人名日报）');
INSERT INTO `publishmessage` VALUES (46, 2, 0, 0, '创业第一天起床失败，创业未始而中道崩殂。\n一日之计在于晨，期末来临，大家需要早起早复习，千万不要\n赖床一时爽，期末火葬场。');
INSERT INTO `publishmessage` VALUES (50, 0, 54, 0, '测试活动');
INSERT INTO `publishmessage` VALUES (51, 0, 55, 0, '测试活动');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `uName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uPassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uSignature` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `uSex` tinyint(1) NOT NULL,
  `uPhone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `uEmail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'zhangsan', '123456', 'I am Father! You, brother!', 1, '13272894373', 'wy2017211@163.com');
INSERT INTO `userinfo` VALUES (2, '李四', '123456', '这个人很懒，什么也没有留下.......', 1, '165413132131', '3306699766@qq.com');
INSERT INTO `userinfo` VALUES (3, 'test', '123456', '这个人很懒，什么也没有留下.......', 1, '464156313132', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (4, 'pahantom', '123456', '这个人很懒，什么也没有留下.......', 1, '17388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (5, '寂寥', '123456', '这个人很懒，什么也没有留下.......', 1, '645343423', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (6, '吃饭', '1123456', '这个人很懒，什么也没有留下.......', 1, '17388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (7, '其缘自由天定', '123456', '这个人很懒，什么也没有留下.......', 1, '17388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (8, 'word', 'w', '这个人很懒，什么也没有留下.......', 1, '17388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (9, '安心', '123456', '这个人很懒，什么也没有留下.......', 1, '117388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (10, 'ljc', '123456', '这个人很懒，什么也没有留下.......', 1, '17388242805', '1824857373@qq.com');
INSERT INTO `userinfo` VALUES (11, '二狗子', '123456', '这个人很懒，什么也没有留下.......', 1, '13587246875', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (12, '我是你得不到的男人', '123456', '这个人很懒，什么也没有留下.......', 1, '17388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (13, '你好', '123456', '不会还乱码吗', 1, '17388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (14, '天下', '12345', '要是在乱码的话，真的要绝望了', 1, '17388242805', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (15, 'zsj', '123456', '这个人很懒，什么也没有留下.......', 1, '13983582657', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (16, '诸葛无敌', '123456', '这个人很懒，什么也没有留下.......', 1, '12345678954', 'wy911@163.com');
INSERT INTO `userinfo` VALUES (17, '小毛孩', '123456', '这个人很懒，什么也没有留下.......', 1, '17388242805', '1065300740@qq.com');
INSERT INTO `userinfo` VALUES (18, '今生有缘', '123456', '这个人很懒，什么也没有留下.......', 1, '17388242805', '470327298@qq.com');
INSERT INTO `userinfo` VALUES (19, '善待自己', '123456', '这个人很懒，什么也没有留下.......', 1, '17536955689', '1814490908@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
