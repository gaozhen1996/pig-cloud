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
-- Table structure for table `chortcut`
--

DROP TABLE IF EXISTS `chortcut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chortcut` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `img_url` varchar(255) DEFAULT '#1abc9c',
  `name` varchar(45) DEFAULT NULL,
  `index` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  `addDate` date NOT NULL COMMENT '创建时间',
  `url` varchar(255) DEFAULT NULL,
  `relation` int(11) NOT NULL COMMENT '当值为0表示是用户自己添加的，否则关联的是公共快捷方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=utf8mb4 COMMENT='快捷方式表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chortcut`
--

LOCK TABLES `chortcut` WRITE;
/*!40000 ALTER TABLE `chortcut` DISABLE KEYS */;
INSERT INTO `chortcut` VALUES (1,0,'ext.png','扩展',1,'2020-01-03','https://chrome.google.com/webstore/category/extensions?hl=zh-CN',0),(2,0,'zhihu.png','知乎',2,'2020-01-03','https://www.zhihu.com/',0),(3,0,'jianshu.png','简书',3,'2020-01-03','https://www.jianshu.com/',0),(4,0,'douban.png','豆瓣',4,'2020-01-03','https://www.douban.com/',0),(5,0,'zuimei.png','最美',5,'2020-01-03','http://zuimeia.com/',0),(6,0,'qqmail.png','QQ邮箱',6,'2020-01-03','https://mail.qq.com/',0),(131,1,'',NULL,0,'2020-01-03',NULL,1),(136,2,'',NULL,0,'2020-01-03',NULL,1),(137,2,'',NULL,0,'2020-01-03',NULL,2),(138,2,'',NULL,0,'2020-01-03',NULL,3),(141,2,'',NULL,0,'2020-01-03',NULL,6),(142,3,'',NULL,0,'2020-01-03',NULL,1),(143,3,'',NULL,0,'2020-01-03',NULL,2),(144,3,'',NULL,0,'2020-01-03',NULL,3),(145,3,'',NULL,0,'2020-01-03',NULL,4),(146,3,'',NULL,0,'2020-01-03',NULL,5),(147,3,'',NULL,0,'2020-01-03',NULL,6),(148,4,'',NULL,0,'2020-01-03',NULL,1),(149,4,'',NULL,0,'2020-01-03',NULL,2),(150,4,'',NULL,0,'2020-01-03',NULL,3),(151,4,'',NULL,0,'2020-01-03',NULL,4),(152,4,'',NULL,0,'2020-01-03',NULL,5),(153,4,'',NULL,0,'2020-01-03',NULL,6),(154,5,'',NULL,0,'2020-01-03',NULL,1),(155,5,'',NULL,0,'2020-01-03',NULL,2),(156,5,'',NULL,0,'2020-01-03',NULL,3),(157,5,'',NULL,0,'2020-01-03',NULL,4),(158,5,'',NULL,0,'2020-01-03',NULL,5),(159,5,'',NULL,0,'2020-01-03',NULL,6),(160,6,'',NULL,0,'2020-01-03',NULL,1),(161,6,'',NULL,0,'2020-01-03',NULL,2),(164,7,'',NULL,0,'2020-01-03',NULL,1),(165,7,'',NULL,0,'2020-01-03',NULL,2),(166,7,'',NULL,0,'2020-01-03',NULL,3),(167,7,'',NULL,0,'2020-01-03',NULL,4),(168,8,'',NULL,0,'2020-01-03',NULL,1),(169,8,'',NULL,0,'2020-01-03',NULL,2),(170,8,'',NULL,0,'2020-01-03',NULL,3),(171,8,'',NULL,0,'2020-01-03',NULL,4),(172,8,'',NULL,0,'2020-01-03',NULL,5),(173,8,'',NULL,0,'2020-01-03',NULL,6),(174,9,'',NULL,0,'2020-01-03',NULL,1),(175,9,'',NULL,0,'2020-01-03',NULL,2),(176,9,'',NULL,0,'2020-01-03',NULL,3),(177,9,'',NULL,0,'2020-01-03',NULL,4),(178,9,'',NULL,0,'2020-01-03',NULL,5),(179,9,'',NULL,0,'2020-01-03',NULL,6),(180,10,'',NULL,0,'2020-01-03',NULL,1),(181,10,'',NULL,0,'2020-01-03',NULL,2),(182,10,'',NULL,0,'2020-01-03',NULL,3),(183,10,'',NULL,0,'2020-01-03',NULL,4),(184,10,'',NULL,0,'2020-01-03',NULL,5),(185,10,'',NULL,0,'2020-01-03',NULL,6),(186,11,'',NULL,0,'2020-01-03',NULL,1),(187,11,'',NULL,0,'2020-01-03',NULL,2),(188,11,'',NULL,0,'2020-01-03',NULL,3),(189,11,'',NULL,0,'2020-01-03',NULL,4),(190,11,'',NULL,0,'2020-01-03',NULL,5),(191,11,'',NULL,0,'2020-01-03',NULL,6),(192,1,'',NULL,0,'2020-01-05',NULL,2),(196,6,'#1abc9c','TS',0,'2020-01-06','https://ts.hundsun.com/se/portal/SupportPortal.htm',0),(197,1,'#F44336','TS',0,'2020-01-06','https://ts.hundsun.com/se/portal/SupportPortal.htm',0),(199,6,'#9c27b0','SE',0,'2020-01-06','https://se.hundsun.com/secure/Dashboard.jspa',0),(201,1,'#00bcd4','邮箱',0,'2020-01-10','https://mail.hundsun.com/owa/#path=/mail',0),(211,13,'#1abc9c',NULL,0,'2020-05-16',NULL,2),(214,13,'#1abc9c','协同',0,'2020-05-16','https://synergy.hundsun.com/wui/main.jsp',0),(217,13,'#1abc9c','ITSM',0,'2020-05-17','http://kfhsitsm.hundsun.com/kfhsitsm/main.action',0),(227,1,'#1abc9c','翻译',0,'2020-05-22','https://fanyi.baidu.com/translate?aldtype=16047&query=&keyfrom=baidu&smartresult=dict&lang=auto2zh#zh/en/%E9%87%91%E8%9E%8D%E7%A7%AF%E7%B4%AF',0),(231,14,'#1abc9c',NULL,0,'2020-05-22',NULL,2),(236,14,'#1abc9c','JIRA',0,'2020-05-22','https://se.hundsun.com/browse/TGIIVI-15746?filter=-2',0),(244,1,'#1abc9c',NULL,0,'2020-05-23',NULL,6),(263,2,'#00bcd4','取样工作网',0,'2020-05-24','http://120.27.192.249:8088/Account/Login',0),(264,14,'#f44336','TS',0,'2020-05-26','https://ts.hundsun.com/se/portal/SupportPortal.htm',0),(265,14,'',NULL,0,'2020-05-26',NULL,3),(266,14,'',NULL,0,'2020-05-26',NULL,4),(267,14,'#00bcd4','测试云平台',0,'2020-05-28','http://cloud.blade.hundsun.com/index.htm',0),(268,13,'#f44336','TS',0,'2020-06-02','https://ts.hundsun.com/se/portal/SupportPortal.htm',0),(269,13,'#00bcd4','客服在线管理平台',0,'2020-06-02','https://service.hundsun.com/backend/login',0),(270,13,'#009688','RDM',0,'2020-06-02','http://pm.hundsun.com/main.do',0),(272,2,'#f44336','筑业网',0,'2020-06-07','http://www.zhuyew.cn/',0),(274,1,'#ff9800','协同',0,'2020-06-10','https://synergy.hundsun.com/wui/main.jsp',0),(275,1,'#00bcd4','JIRA',0,'2020-06-12','https://se.hundsun.com/secure/Dashboard.jspa',0),(279,7,'',NULL,0,'2020-07-01',NULL,6),(280,7,'',NULL,0,'2020-07-01',NULL,5);
/*!40000 ALTER TABLE `chortcut` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 23:16:25
