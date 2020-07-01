-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 47.94.131.201    Database: pig_video
-- ------------------------------------------------------
-- Server version	5.5.62-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '角色名',
  `roleDetail` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '角色详情',
  `delFlag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '存在标识',
  `permission` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限',
  `menu` varchar(10000) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'超级管理员','superAdmin',1,'role:select,wormInfo:select,wormInfo:update,userInfo:select,role:udpate,user:udpate,','[{\"icon\":\"el-icon-lx-home\",\"index\":\"dashboard\",\"title\":\"系统首页\"},{\"icon\":\"el-icon-mobile-phone\",\"index\":\"planMange\",\"title\":\"计划管理\"},{\"icon\":\"el-icon-edit-outline\",\"index\":\"note\",\"title\":\"我的笔记\"},{\"icon\":\"el-icon-s-management\",\"index\":\"1\",\"title\":\"系统管理\",\"subs\":[{\"index\":\"RoleManage\",\"title\":\"角色管理\"},{\"index\":\"video\",\"title\":\"视频管理\"},{\"index\":\"Bgimage\",\"title\":\"背景设置\"},{\"index\":\"ShortcutManage\",\"title\":\"快捷方式\"}]},{\"icon\":\"el-icon-monitor\",\"index\":\"3\",\"title\":\"系统监控\",\"subs\":[{\"index\":\"userActivity\",\"title\":\"活跃度监控\"},{\"index\":\"Euraka\",\"title\":\"注册中心监控\"}]},{\"icon\":\"el-icon-moon-night\",\"index\":\"9\",\"title\":\"内测功能\",\"subs\":[{\"index\":\"tabs\",\"title\":\"我的通知\"},{\"index\":\"3-2\",\"title\":\"编辑器\",\"subs\":[{\"index\":\"editor\",\"title\":\"富文本编辑器\"},{\"index\":\"markdown\",\"title\":\"markdown编辑器\"}]},{\"index\":\"upload\",\"title\":\"文件上传\"}]}]'),(2,'管理员','admin',1,'user:udpate,','[{\"icon\":\"el-icon-lx-home\",\"index\":\"dashboard\",\"title\":\"系统首页\"},{\"icon\":\"el-icon-mobile-phone\",\"index\":\"planMange\",\"title\":\"计划管理\"},{\"icon\":\"el-icon-edit-outline\",\"index\":\"note\",\"title\":\"我的笔记\"},{\"icon\":\"el-icon-s-management\",\"index\":\"1\",\"title\":\"系统管理\",\"subs\":[{\"index\":\"video\",\"title\":\"视频管理\"},{\"index\":\"Bgimage\",\"title\":\"背景设置\"},{\"index\":\"ShortcutManage\",\"title\":\"快捷方式\"}]},{\"icon\":\"el-icon-monitor\",\"index\":\"3\",\"title\":\"系统监控\",\"subs\":[{\"index\":\"userActivity\",\"title\":\"活跃度监控\"},{\"index\":\"Euraka\",\"title\":\"注册中心监控\"}]},{\"icon\":\"el-icon-moon-night\",\"index\":\"9\",\"title\":\"内测功能\",\"subs\":[{\"index\":\"tabs\",\"title\":\"我的通知\"},{\"index\":\"3-2\",\"title\":\"编辑器\",\"subs\":[{\"index\":\"editor\",\"title\":\"富文本编辑器\"},{\"index\":\"markdown\",\"title\":\"markdown编辑器\"}]},{\"index\":\"upload\",\"title\":\"文件上传\"}]}]'),(100,'普通','',1,'user:udpate,','[{\"icon\":\"el-icon-lx-home\",\"index\":\"dashboard\",\"title\":\"系统首页\"},{\"icon\":\"el-icon-mobile-phone\",\"index\":\"planMange\",\"title\":\"计划管理\"},{\"icon\":\"el-icon-edit-outline\",\"index\":\"note\",\"title\":\"我的笔记\"},{\"icon\":\"el-icon-lx-copy\",\"index\":\"ShortcutManage\",\"title\":\"快捷方式\"},{\"icon\":\"el-icon-picture-outline\",\"index\":\"Bgimage\",\"title\":\"背景设置\"},{\"icon\":\"el-icon-s-check\",\"index\":\"UserInfo\",\"title\":\"个人资料\"}]');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 23:16:22
