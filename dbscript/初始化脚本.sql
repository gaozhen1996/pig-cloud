CREATE DATABASE `pig_video` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use pig_video;

DROP TABLE IF EXISTS `chortcut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chortcut` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int NOT NULL COMMENT '用户id',
  `img_url` varchar(255) DEFAULT '#1abc9c',
  `name` varchar(45) DEFAULT NULL,
  `index` int NOT NULL DEFAULT '0' COMMENT '顺序',
  `addDate` date NOT NULL COMMENT '创建时间',
  `url` varchar(255) DEFAULT NULL,
  `relation` int NOT NULL COMMENT '当值为0表示是用户自己添加的，否则关联的是公共快捷方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='快捷方式表';
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `chortcut` WRITE;
/*!40000 ALTER TABLE `chortcut` DISABLE KEYS */;
INSERT INTO `chortcut` VALUES 
(1,0,'ext.png','扩展',1,'2020-01-03','https://chrome.google.com/webstore/category/extensions?hl=zh-CN',0),
(2,0,'zhihu.png','知乎',2,'2020-01-03','https://www.zhihu.com/',0),
(3,0,'jianshu.png','简书',3,'2020-01-03','https://www.jianshu.com/',0),
(4,0,'douban.png','豆瓣',4,'2020-01-03','https://www.douban.com/',0),
(5,0,'zuimei.png','最美',5,'2020-01-03','http://zuimeia.com/',0),
(6,0,'qqmail.png','QQ邮箱',6,'2020-01-03','https://mail.qq.com/',0),
(131,1,'',NULL,0,'2020-01-03',NULL,1),(136,2,'',NULL,0,'2020-01-03',NULL,1),
(137,2,'',NULL,0,'2020-01-03',NULL,2),(138,2,'',NULL,0,'2020-01-03',NULL,3),
(141,2,'',NULL,0,'2020-01-03',NULL,6),(192,1,'',NULL,0,'2020-01-05',NULL,2),
(227,1,'#1abc9c','翻译',0,'2020-05-22','https://fanyi.baidu.com/translate?aldtype=16047&query=&keyfrom=baidu&smartresult=dict&lang=auto2zh#zh/en/%E9%87%91%E8%9E%8D%E7%A7%AF%E7%B4%AF',0),
(244,1,'#1abc9c',NULL,0,'2020-05-23',NULL,6),(263,2,'#00bcd4','取样工作网',0,'2020-05-24','http://120.27.192.249:8088/Account/Login',0),
(272,2,'#f44336','筑业网',0,'2020-06-07','http://www.zhuyew.cn/',0);
/*!40000 ALTER TABLE `chortcut` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint NOT NULL COMMENT '用户id',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '创建时间',
  `type` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'note' COMMENT '类型',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `fromid` bigint DEFAULT NULL COMMENT '所属目录的id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='笔记表';
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES 
(1,1,'2020-01-03','2020-06-16','note','常用链接',0,'<p>1.左耳耗子</p><p><a href=\"https://coolshell.cn/\" target=\"_blank\">https://coolshell.cn/</a></p><p>2.idea激活码</p><p><a href=\"http://idea.medeming.com/jet/\" target=\"_blank\">http://idea.medeming.com/jet/</a></p><p><a href=\"http://idea.medeming.com/jihuoma/\" target=\"_blank\">http://idea.medeming.com/jihuoma/</a></p><p>3.spring官方文档</p><p><a href=\"https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html\" target=\"_blank\">https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html</a></p><p>4.知乎-如何系统的学习java</p><p><a href=\"https://www.zhihu.com/question/311758187/answer/1043059927\" target=\"_blank\">https://www.zhihu.com/question/311758187/answer/1043059927</a></p><p>5.iview后台模板</p><p><a href=\"https://github.com/iview/iview-admin\" target=\"_blank\">https://github.com/iview/iview-admin</a></p><p>6.dubbo</p><p><a href=\"https://github.com/bz51/SpringBoot-Dubbo-Docker-Jenkins\" target=\"_blank\">https://github.com/bz51/SpringBoot-Dubbo-Docker-Jenkins</a></p><p>7.有哪些你看了以后大呼过瘾的编程书？ - 知乎</p><p><a href=\"https://www.zhihu.com/question/50408698/answer/1154160248\" target=\"_blank\">https://www.zhihu.com/question/50408698/answer/1154160248</a></p><p>8.16000 字 Redis 面试知识点总结，建议收藏！</p><p><a href=\"https://zhuanlan.zhihu.com/p/134104400\" target=\"_blank\">https://zhuanlan.zhihu.com/p/134104400</a></p><p>9.研发中心下载链接</p><p><a href=\"http://rdc.hundsun.com/product/download/index.htm\" target=\"_blank\">http://rdc.hundsun.com/product/download/index.htm</a></p><p><br></p>'),
(4,2,'2020-05-02',NULL,'note','新建文件',0,'<p>test</p>');
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int NOT NULL COMMENT '用户id',
  `plan_type` int NOT NULL DEFAULT '0' COMMENT '计划类型，分为四类',
  `content` varchar(255) NOT NULL COMMENT '计划的内容',
  `finish_status` bigint NOT NULL DEFAULT '0' COMMENT '完成状态，0未完成，1完成',
  `plan_index` varchar(45) NOT NULL COMMENT '位置',
  `create_date` date NOT NULL COMMENT '创建时间',
  `finish_date` date NOT NULL COMMENT '完成时间',
  `public_flag` tinyint(1) DEFAULT '1',
  `actual_finish_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='计划表';
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (169,1,1,'1',0,'0','2021-06-17','2021-06-17',1,NULL);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readlater`
--

DROP TABLE IF EXISTS `readlater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `readlater` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int NOT NULL COMMENT '用户id',
  `parent_id` int NOT NULL DEFAULT '0' COMMENT '父节点id',
  `url` varchar(255) NOT NULL DEFAULT 'http://www.baidu.com' COMMENT '链接URL',
  `title` varchar(255) NOT NULL DEFAULT '百度一下' COMMENT '标题',
  `read_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '阅读状态',
  `addDate` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='稍后阅读';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readlater`
--

LOCK TABLES `readlater` WRITE;
/*!40000 ALTER TABLE `readlater` DISABLE KEYS */;
INSERT INTO `readlater` VALUES (3,1,0,'https://coolshell.cn/','1.左耳耗子',0,'2020-08-02 15:17:47');
/*!40000 ALTER TABLE `readlater` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `roleDetail` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色详情',
  `delFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '存在标识',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  `menu` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES 
(1,'超级管理员','superAdmin',1,'role:select,wormInfo:select,wormInfo:update,userInfo:select,role:udpate,user:udpate,','[{\"icon\":\"el-icon-lx-home\",\"index\":\"dashboard\",\"title\":\"系统首页\"},{\"icon\":\"el-icon-mobile-phone\",\"index\":\"planMange\",\"title\":\"计划管理\"},{\"icon\":\"el-icon-edit-outline\",\"index\":\"note\",\"title\":\"我的笔记\"},{\"icon\":\"el-icon-s-management\",\"index\":\"1\",\"title\":\"系统管理\",\"subs\":[{\"index\":\"RoleManage\",\"title\":\"角色管理\"},{\"index\":\"video\",\"title\":\"视频管理\"},{\"index\":\"Bgimage\",\"title\":\"背景设置\"},{\"index\":\"ShortcutManage\",\"title\":\"快捷方式\"}]},{\"icon\":\"el-icon-monitor\",\"index\":\"3\",\"title\":\"系统监控\",\"subs\":[{\"index\":\"userActivity\",\"title\":\"活跃度监控\"},{\"index\":\"Euraka\",\"title\":\"注册中心监控\"}]},{\"icon\":\"el-icon-moon-night\",\"index\":\"9\",\"title\":\"内测功能\",\"subs\":[{\"index\":\"tabs\",\"title\":\"我的通知\"},{\"index\":\"3-2\",\"title\":\"编辑器\",\"subs\":[{\"index\":\"editor\",\"title\":\"富文本编辑器\"},{\"index\":\"markdown\",\"title\":\"markdown编辑器\"}]},{\"index\":\"upload\",\"title\":\"文件上传\"}]}]'),
(2,'管理员','admin',1,'user:udpate,','[{\"icon\":\"el-icon-lx-home\",\"index\":\"dashboard\",\"title\":\"系统首页\"},{\"icon\":\"el-icon-mobile-phone\",\"index\":\"planMange\",\"title\":\"计划管理\"},{\"icon\":\"el-icon-edit-outline\",\"index\":\"note\",\"title\":\"我的笔记\"},{\"icon\":\"el-icon-s-management\",\"index\":\"1\",\"title\":\"系统管理\",\"subs\":[{\"index\":\"video\",\"title\":\"视频管理\"},{\"index\":\"Bgimage\",\"title\":\"背景设置\"},{\"index\":\"ShortcutManage\",\"title\":\"快捷方式\"}]},{\"icon\":\"el-icon-monitor\",\"index\":\"3\",\"title\":\"系统监控\",\"subs\":[{\"index\":\"userActivity\",\"title\":\"活跃度监控\"},{\"index\":\"Euraka\",\"title\":\"注册中心监控\"}]},{\"icon\":\"el-icon-moon-night\",\"index\":\"9\",\"title\":\"内测功能\",\"subs\":[{\"index\":\"tabs\",\"title\":\"我的通知\"},{\"index\":\"3-2\",\"title\":\"编辑器\",\"subs\":[{\"index\":\"editor\",\"title\":\"富文本编辑器\"},{\"index\":\"markdown\",\"title\":\"markdown编辑器\"}]},{\"index\":\"upload\",\"title\":\"文件上传\"}]}]'),
(100,'普通','',1,'user:udpate,','[{\"icon\":\"el-icon-lx-home\",\"index\":\"dashboard\",\"title\":\"系统首页\"},{\"icon\":\"el-icon-mobile-phone\",\"index\":\"planMange\",\"title\":\"计划管理\"},{\"icon\":\"el-icon-edit-outline\",\"index\":\"note\",\"title\":\"我的笔记\"},{\"icon\":\"el-icon-lx-copy\",\"index\":\"ShortcutManage\",\"title\":\"快捷方式\"},{\"icon\":\"el-icon-picture-outline\",\"index\":\"Bgimage\",\"title\":\"背景设置\"},{\"icon\":\"el-icon-s-check\",\"index\":\"UserInfo\",\"title\":\"个人资料\"}]');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL DEFAULT '100' COMMENT '角色id',
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `photo` blob COMMENT '头像，不超过65KB',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别-0:男，1:女',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `last_login_date` date DEFAULT NULL COMMENT '上一次登录时间',
  `delFlag` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES 
(1,1,'admin','root','管理员',NULL,0,'2019-01-01','2021-06-17',1),
(2,100,'test','test','普通用户',NULL,1,'2019-01-01','2020-06-27',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_activity`
--

DROP TABLE IF EXISTS `user_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_activity` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` int DEFAULT NULL COMMENT '用户id',
  `account` varchar(20) NOT NULL COMMENT '账号',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `create_time` bigint DEFAULT NULL COMMENT '活跃时间',
  `behavior` varchar(30) DEFAULT NULL COMMENT '用户活动行为',
  `content` varchar(30) DEFAULT NULL COMMENT '用户活动内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=759 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户活跃表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_activity`
--

LOCK TABLES `user_activity` WRITE;
/*!40000 ALTER TABLE `user_activity` DISABLE KEYS */;
INSERT INTO `user_activity` VALUES 
(756,1,'gz','',1623900184,'newTab',''),
(757,1,'gz','',1623900318,'newTab',''),
(758,1,'gz','',1623900436,'newTab','');
/*!40000 ALTER TABLE `user_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_info`
--

DROP TABLE IF EXISTS `video_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `videoURL` varchar(255) DEFAULT NULL COMMENT '视频路径',
  `delFlag` bigint DEFAULT NULL COMMENT '存在表示',
  `content` text NOT NULL COMMENT '内容',
  `showFlag` bigint DEFAULT NULL COMMENT '展示表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='视频信息表';
/*!40101 SET character_set_client = @saved_cs_client */;