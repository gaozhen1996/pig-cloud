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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(11) NOT NULL,
  `roleId` bigint(11) NOT NULL DEFAULT '100' COMMENT '角色id',
  `account` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '用户账号',
  `password` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '用户密码',
  `name` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
  `photo` blob COMMENT '头像，不超过65KB',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别-0:男，1:女',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `last_login_date` date DEFAULT NULL COMMENT '上一次登录时间',
  `delFlag` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'gz','root','高振','http://47.94.131.201/pigvideo/1-1556793667043.png',0,'2019-01-01','2020-07-01',1),(2,100,'ld','ld','刘丹','http://47.94.131.201/pigvideo/2-1561301528607.png',1,'2019-01-01','2020-06-27',1),(3,100,'hh','hh','狒狒',NULL,1,'2019-01-01','2020-05-31',1),(4,100,'lj','lj','刘晶',NULL,0,'2019-01-01','2020-02-08',1),(5,100,'fzh','fzh','范振华',NULL,0,'2019-01-01','2020-07-01',1),(6,2,'lxh','lxh','罗小航',NULL,0,'2019-01-01','2020-07-01',1),(7,100,'pzy','pzy','庞周烨','http://47.94.131.201/pigvideo/7-1593593382433.png',0,'2019-01-01','2020-07-01',1),(8,100,'wd','wd','魏东',NULL,0,'2019-01-01','2020-06-07',1),(9,100,'lfh','lfh','李风浩',NULL,0,'2019-01-01','2020-01-03',1),(10,100,'wjj','wjj','王佳健',NULL,0,'2019-01-01','2020-01-03',1),(11,100,'lxf','lxf','雒鑫发',NULL,0,'2019-01-01','2020-01-03',1),(12,100,'root','root','root','http://47.94.131.201/pigvideo/12-1593592812768.png',0,'2019-01-01','2020-07-01',1),(13,100,'hzj','hzj','洪振江',NULL,0,'2019-01-01','2020-06-22',1),(14,100,'hk','hk','侯康',NULL,0,'2019-01-01','2020-05-26',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 23:16:26
