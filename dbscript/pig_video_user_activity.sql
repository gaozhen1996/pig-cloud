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
-- Table structure for table `user_activity`
--

DROP TABLE IF EXISTS `user_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `account` varchar(20) NOT NULL COMMENT '账号',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `create_time` bigint(13) DEFAULT NULL COMMENT '活跃时间',
  `behavior` varchar(30) DEFAULT NULL COMMENT '用户活动行为',
  `content` varchar(30) DEFAULT NULL COMMENT '用户活动内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=754 DEFAULT CHARSET=utf8mb4 COMMENT='用户活跃表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_activity`
--

LOCK TABLES `user_activity` WRITE;
/*!40000 ALTER TABLE `user_activity` DISABLE KEYS */;
INSERT INTO `user_activity` VALUES (1,1,'gz',NULL,1592722436020,'newTab',NULL),(2,1,'gz',NULL,1592722891166,'newTab',NULL),(3,1,'gz',NULL,1592723131570,'newTab',NULL),(4,1,'gz',NULL,1592725158729,'newTab',NULL),(5,1,'gz',NULL,1592725579830,'newTab',NULL),(6,1,'gz',NULL,1592725660680,'newTab',NULL),(7,1,'gz',NULL,1592725759157,'newTab',NULL),(8,1,'gz',NULL,1592725833967,'newTab',NULL),(9,1,'gz',NULL,1592726000572,'newTab',NULL),(10,NULL,'wd',NULL,1592729699639,'newTab',NULL),(11,1,'gz',NULL,1592730952624,'newTab',NULL),(12,1,'gz',NULL,1592730958847,'newTab',NULL),(13,1,'gz',NULL,1592731002847,'newTab',NULL),(14,1,'gz',NULL,1592731141907,'newTab',NULL),(15,NULL,'pzy',NULL,1592731149336,'newTab',NULL),(16,NULL,'hzj',NULL,1592731284829,'newTab',NULL),(17,NULL,'hzj',NULL,1592731306653,'newTab',NULL),(18,NULL,'pzy',NULL,1592734186375,'newTab',NULL),(19,NULL,'pzy',NULL,1592734207333,'newTab',NULL),(20,NULL,'pzy',NULL,1592734270394,'newTab',NULL),(21,NULL,'hzj',NULL,1592734587057,'newTab',NULL),(22,NULL,'pzy',NULL,1592735587736,'newTab',NULL),(23,NULL,'pzy',NULL,1592737655447,'newTab',NULL),(24,1,'gz',NULL,1592738616199,'newTab',NULL),(25,NULL,'wd',NULL,1592786235312,'newTab',NULL),(26,NULL,'lxh',NULL,1592788431916,'newTab',NULL),(27,NULL,'lxh',NULL,1592788444778,'newTab',NULL),(28,NULL,'pzy',NULL,1592789460203,'newTab',NULL),(29,NULL,'pzy',NULL,1592789947832,'newTab',NULL),(30,NULL,'pzy',NULL,1592789953401,'newTab',NULL),(31,1,'gz',NULL,1592792227374,'newTab',NULL),(32,1,'gz',NULL,1592792589615,'newTab',NULL),(33,NULL,'lxh',NULL,1592793568722,'newTab',NULL),(34,NULL,'lxh',NULL,1592793914956,'newTab',NULL),(35,NULL,'pzy',NULL,1592793916673,'newTab',NULL),(36,NULL,'pzy',NULL,1592794313783,'newTab',NULL),(37,NULL,'pzy',NULL,1592794340568,'newTab',NULL),(38,NULL,'pzy',NULL,1592794824296,'newTab',NULL),(39,1,'gz',NULL,1592795097697,'newTab',NULL),(40,NULL,'lxh',NULL,1592795361882,'newTab',NULL),(41,1,'gz',NULL,1592796994564,'newTab',NULL),(42,1,'gz',NULL,1592797002464,'newTab',NULL),(43,1,'gz',NULL,1592797007104,'newTab',NULL),(44,1,'gz',NULL,1592797763848,'newTab',NULL),(45,NULL,'pzy',NULL,1592804655640,'newTab',NULL),(46,NULL,'pzy',NULL,1592804790193,'newTab',NULL),(47,NULL,'hzj',NULL,1592805585784,'newTab',NULL),(48,1,'gz',NULL,1592805960536,'newTab',NULL),(49,1,'gz',NULL,1592807958244,'newTab',NULL),(50,1,'gz',NULL,1592808281593,'newTab',NULL),(51,NULL,'ld',NULL,1592808832869,'newTab',NULL),(52,1,'gz',NULL,1592809654811,'newTab',NULL),(53,1,'gz',NULL,1592810136040,'newTab',NULL),(54,1,'gz',NULL,1592810622489,'newTab',NULL),(55,1,'gz',NULL,1592810629491,'newTab',NULL),(56,1,'gz',NULL,1592810664885,'newTab',NULL),(57,1,'gz',NULL,1592810815685,'newTab',NULL),(58,1,'gz',NULL,1592810821641,'newTab',NULL),(59,1,'gz',NULL,1592810830226,'newTab',NULL),(60,1,'gz',NULL,1592810881575,'newTab',NULL),(61,1,'gz',NULL,1592815131296,'newTab',NULL),(62,1,'gz',NULL,1592815137650,'newTab',NULL),(63,1,'gz',NULL,1592816174540,'newTab',NULL),(64,NULL,'lxh',NULL,1592816832473,'newTab',NULL),(65,1,'gz',NULL,1592817353209,'newTab',NULL),(66,1,'gz',NULL,1592817399003,'newTab',NULL),(67,1,'gz',NULL,1592817418524,'newTab',NULL),(68,1,'gz',NULL,1592817423393,'newTab',NULL),(69,1,'gz',NULL,1592817484036,'newTab',NULL),(70,1,'gz',NULL,1592817486991,'newTab',NULL),(71,NULL,'hzj',NULL,1592822940397,'newTab',NULL),(72,13,'hzj',NULL,1592823041140,'newTab',NULL),(73,13,'hzj',NULL,1592823044772,'newTab',NULL),(74,13,'hzj',NULL,1592823057374,'newTab',NULL),(75,13,'hzj',NULL,1592823074475,'newTab',NULL),(76,13,'hzj',NULL,1592823089015,'newTab',NULL),(77,13,'hzj',NULL,1592823095914,'newTab',NULL),(78,13,'hzj',NULL,1592823409903,'newTab',NULL),(79,13,'hzj',NULL,1592823419976,'newTab',NULL),(80,13,'hzj',NULL,1592823427549,'newTab',NULL),(81,13,'hzj',NULL,1592823482828,'newTab',NULL),(82,13,'hzj',NULL,1592823560850,'newTab',NULL),(83,13,'hzj',NULL,1592824727451,'newTab',NULL),(84,13,'hzj',NULL,1592824771560,'newTab',NULL),(85,13,'hzj',NULL,1592825166886,'newTab',NULL),(86,1,'gz',NULL,1592825508918,'newTab',NULL),(87,1,'gz',NULL,1592825897218,'newTab',NULL),(88,1,'gz',NULL,1592826153194,'newTab',NULL),(89,1,'gz',NULL,1592826195421,'newTab',NULL),(90,13,'hzj',NULL,1592826272844,'newTab',NULL),(91,13,'hzj',NULL,1592826367954,'newTab',NULL),(92,13,'hzj',NULL,1592826445515,'newTab',NULL),(93,13,'hzj',NULL,1592826650147,'newTab',NULL),(94,13,'hzj',NULL,1592826653952,'newTab',NULL),(95,1,'gz',NULL,1592826670366,'newTab',NULL),(96,1,'gz',NULL,1592826675688,'newTab',NULL),(97,1,'gz',NULL,1592826936009,'newTab',NULL),(98,1,'gz',NULL,1592827086297,'newTab',NULL),(99,1,'gz',NULL,1592827233601,'newTab',NULL),(100,1,'gz',NULL,1592827309595,'newTab',NULL),(101,1,'gz',NULL,1592827656248,'newTab',NULL),(102,1,'gz',NULL,1592828276583,'newTab',NULL),(103,1,'gz',NULL,1592828863220,'newTab',NULL),(104,1,'gz',NULL,1592829078585,'newTab',NULL),(105,1,'gz',NULL,1592837037738,'newTab',NULL),(106,1,'gz',NULL,1592837213047,'newTab',NULL),(107,1,'gz',NULL,1592837919501,'newTab',NULL),(108,NULL,'wd',NULL,1592840976929,'newTab',NULL),(109,NULL,'wd',NULL,1592841193717,'newTab',NULL),(110,NULL,'lxh',NULL,1592874236494,'newTab',NULL),(111,NULL,'lxh',NULL,1592874356099,'newTab',NULL),(112,NULL,'lxh',NULL,1592874810235,'newTab',NULL),(113,NULL,'lxh',NULL,1592875066238,'newTab',NULL),(114,NULL,'lxh',NULL,1592876681246,'newTab',NULL),(115,1,'gz',NULL,1592878549158,'newTab',NULL),(116,1,'gz',NULL,1592878640806,'newTab',NULL),(117,NULL,'ld',NULL,1592879150220,'newTab',NULL),(118,NULL,'ld',NULL,1592879794438,'newTab',NULL),(119,1,'gz',NULL,1592879904362,'newTab',NULL),(120,1,'gz',NULL,1592879964521,'newTab',NULL),(121,NULL,'lxh',NULL,1592881333562,'newTab',NULL),(122,NULL,'lxh',NULL,1592882226473,'newTab',NULL),(123,NULL,'lxh',NULL,1592882522186,'newTab',NULL),(124,NULL,'lxh',NULL,1592882992441,'newTab',NULL),(125,1,'gz',NULL,1592883321364,'newTab',NULL),(126,1,'gz',NULL,1592883815079,'newTab',NULL),(127,1,'gz',NULL,1592884129585,'newTab',NULL),(128,13,'hzj',NULL,1592884768258,'newTab',NULL),(129,1,'gz',NULL,1592889718586,'newTab',NULL),(130,1,'gz',NULL,1592889736104,'newTab',NULL),(131,1,'gz',NULL,1592889768018,'newTab',NULL),(132,1,'gz',NULL,1592889775098,'newTab',NULL),(133,1,'gz',NULL,1592889792204,'newTab',NULL),(134,1,'gz',NULL,1592889794321,'newTab',NULL),(135,1,'gz',NULL,1592889803271,'newTab',NULL),(136,1,'gz',NULL,1592889888090,'newTab',NULL),(137,1,'gz',NULL,1592889892176,'newTab',NULL),(138,1,'gz',NULL,1592890041450,'newTab',NULL),(139,1,'gz',NULL,1592892645355,'newTab',NULL),(140,1,'gz',NULL,1592892771555,'newTab',NULL),(141,1,'gz',NULL,1592893291012,'newTab',NULL),(142,NULL,'lxh',NULL,1592893597334,'newTab',NULL),(143,NULL,'lxh',NULL,1592895007044,'newTab',NULL),(144,NULL,'ld',NULL,1592897575187,'newTab',NULL),(145,NULL,'lxh',NULL,1592902205658,'newTab',NULL),(146,1,'gz',NULL,1592902478654,'newTab',NULL),(147,NULL,'lxh',NULL,1592904437948,'newTab',NULL),(148,1,'gz',NULL,1592912226020,'newTab',NULL),(149,13,'hzj',NULL,1592912351207,'newTab',NULL),(150,1,'gz',NULL,1592916136744,'newTab',NULL),(151,1,'gz',NULL,1592916429637,'newTab',NULL),(152,1,'gz',NULL,1592916436298,'newTab',NULL),(153,1,'gz',NULL,1592916590542,'newTab',NULL),(154,1,'gz',NULL,1592916791799,'newTab',NULL),(155,1,'gz',NULL,1592916812234,'newTab',NULL),(156,1,'gz',NULL,1592917562196,'newTab',NULL),(157,1,'gz',NULL,1592918537957,'newTab',NULL),(158,1,'gz',NULL,1592918826752,'newTab',NULL),(159,1,'gz',NULL,1592919494312,'newTab',NULL),(160,1,'gz',NULL,1592921406350,'newTab',NULL),(161,1,'gz',NULL,1592921604762,'newTab',NULL),(162,1,'gz',NULL,1592921811971,'newTab',NULL),(163,1,'gz',NULL,1592921826716,'newTab',NULL),(164,1,'gz',NULL,1592922028518,'newTab',NULL),(165,1,'gz',NULL,1592922100852,'newTab',NULL),(166,1,'gz',NULL,1592922437061,'newTab',NULL),(167,1,'gz',NULL,1592922456542,'newTab',NULL),(168,1,'gz',NULL,1592922487460,'newTab',NULL),(169,1,'gz',NULL,1592922689210,'newTab',NULL),(170,1,'gz',NULL,1592922697594,'newTab',NULL),(171,1,'gz',NULL,1592922761006,'newTab',NULL),(172,1,'gz',NULL,1592965534692,'newTab',NULL),(173,1,'gz',NULL,1592965621611,'newTab',NULL),(174,1,'gz',NULL,1592965627000,'newTab',NULL),(175,1,'gz',NULL,1592965686283,'newTab',NULL),(176,1,'gz',NULL,1592978249987,'newTab',NULL),(177,1,'gz',NULL,1592978886431,'newTab',NULL),(178,1,'gz',NULL,1592978960915,'newTab',NULL),(179,1,'gz',NULL,1592979003799,'newTab',NULL),(180,1,'gz',NULL,1592979351528,'newTab',NULL),(181,1,'gz',NULL,1592979448345,'newTab',NULL),(182,1,'gz',NULL,1592979869205,'newTab',NULL),(183,1,'gz',NULL,1592981898877,'newTab',NULL),(184,1,'gz',NULL,1592981905501,'newTab',NULL),(185,1,'gz',NULL,1592981914989,'newTab',NULL),(186,1,'gz',NULL,1592981931305,'newTab',NULL),(187,13,'hzj',NULL,1592984410971,'newTab',NULL),(188,13,'hzj',NULL,1592989637894,'newTab',NULL),(189,1,'gz',NULL,1592990972279,'newTab',NULL),(190,13,'hzj',NULL,1593001614855,'newTab',NULL),(191,13,'hzj',NULL,1593001754116,'newTab',NULL),(192,13,'hzj',NULL,1593001754266,'newTab',NULL),(193,13,'hzj',NULL,1593001760254,'newTab',NULL),(194,1,'gz',NULL,1593012041651,'newTab',NULL),(195,1,'gz',NULL,1593012101605,'newTab',NULL),(196,1,'gz',NULL,1593012104181,'newTab',NULL),(197,NULL,'ld',NULL,1593046970632,'newTab',NULL),(198,NULL,'gz',NULL,1593051397906,'newTab',NULL),(199,NULL,'gz',NULL,1593051483899,'newTab',NULL),(200,1,'gz',NULL,1593051549713,'newTab',NULL),(201,1,'gz',NULL,1593051588473,'newTab',NULL),(202,1,'gz',NULL,1593053662898,'newTab',NULL),(203,1,'gz',NULL,1593056889335,'newTab',NULL),(204,1,'gz',NULL,1593056974702,'newTab',NULL),(205,1,'gz',NULL,1593056977688,'newTab',NULL),(206,1,'gz',NULL,1593057356701,'newTab',NULL),(207,1,'gz',NULL,1593057830659,'newTab',NULL),(208,1,'gz',NULL,1593057952468,'newTab',NULL),(209,1,'gz',NULL,1593059224698,'newTab',NULL),(210,1,'gz',NULL,1593059814881,'newTab',NULL),(211,1,'gz',NULL,1593060351422,'newTab',NULL),(212,1,'gz',NULL,1593060590714,'newTab',NULL),(213,1,'gz',NULL,1593060866411,'newTab',NULL),(214,1,'gz',NULL,1593064629433,'newTab',NULL),(215,1,'gz',NULL,1593065279853,'newTab',NULL),(216,NULL,'ld',NULL,1593066207732,'newTab',NULL),(217,1,'gz',NULL,1593072710399,'newTab',NULL),(218,1,'gz',NULL,1593072744506,'newTab',NULL),(219,1,'gz',NULL,1593073354339,'newTab',NULL),(220,1,'gz',NULL,1593073879613,'newTab',NULL),(221,1,'gz',NULL,1593077964225,'newTab',NULL),(222,1,'gz',NULL,1593078179043,'newTab',NULL),(223,1,'gz',NULL,1593078839022,'newTab',NULL),(224,1,'gz',NULL,1593081373580,'newTab',NULL),(225,1,'gz',NULL,1593083118246,'newTab',NULL),(226,1,'gz',NULL,1593085364633,'newTab',NULL),(227,1,'gz',NULL,1593085405326,'newTab',NULL),(228,1,'gz',NULL,1593096603980,'newTab',NULL),(229,1,'gz',NULL,1593098272971,'newTab',NULL),(230,1,'gz',NULL,1593138193672,'newTab',NULL),(231,1,'gz',NULL,1593140811690,'newTab',NULL),(232,NULL,'wd',NULL,1593146060417,'newTab',NULL),(233,1,'gz',NULL,1593150758895,'newTab',NULL),(234,1,'gz',NULL,1593151394795,'newTab',NULL),(235,NULL,'gz',NULL,1593153313386,'newTab',NULL),(236,NULL,'gz',NULL,1593153328892,'newTab',NULL),(237,NULL,'gz',NULL,1593156916465,'newTab',NULL),(238,NULL,'gz',NULL,1593158008565,'newTab',NULL),(239,NULL,'gz',NULL,1593158200272,'newTab',NULL),(240,NULL,'gz',NULL,1593158318821,'newTab',NULL),(241,NULL,'gz',NULL,1593158766957,'newTab',NULL),(242,NULL,'gz',NULL,1593158797603,'newTab',NULL),(243,NULL,'gz',NULL,1593158867977,'newTab',NULL),(244,NULL,'gz',NULL,1593158881200,'newTab',NULL),(245,NULL,'gz',NULL,1593159184481,'newTab',NULL),(246,NULL,'gz',NULL,1593160310790,'newTab',NULL),(247,NULL,'gz',NULL,1593160393627,'newTab',NULL),(248,NULL,'gz',NULL,1593163099890,'newTab',NULL),(249,NULL,'gz',NULL,1593163112079,'newTab',NULL),(250,NULL,'gz',NULL,1593226836657,'newTab',NULL),(251,NULL,'gz',NULL,1593227390460,'newTab',NULL),(252,NULL,'gz',NULL,1593228390260,'newTab',NULL),(253,NULL,'gz',NULL,1593228467781,'newTab',NULL),(254,NULL,'gz',NULL,1593228787999,'newTab',NULL),(255,NULL,'gz',NULL,1593229121090,'newTab',NULL),(256,NULL,'ld',NULL,1593229143213,'newTab',NULL),(257,NULL,'gz',NULL,1593239133456,'newTab',NULL),(258,NULL,'gz',NULL,1593251202091,'newTab',NULL),(259,NULL,'gz',NULL,1593251391689,'newTab',NULL),(260,NULL,'gz',NULL,1593254841074,'newTab',NULL),(261,NULL,'gz',NULL,1593263982941,'newTab',NULL),(262,NULL,'gz',NULL,1593264097044,'newTab',NULL),(263,NULL,'gz',NULL,1593264348388,'newTab',NULL),(264,NULL,'gz',NULL,1593264425694,'newTab',NULL),(265,NULL,'gz',NULL,1593264757903,'newTab',NULL),(266,NULL,'gz',NULL,1593264772869,'newTab',NULL),(267,NULL,'ld',NULL,1593264860298,'newTab',NULL),(268,NULL,'gz',NULL,1593264865978,'newTab',NULL),(269,NULL,'gz',NULL,1593265112633,'newTab',NULL),(270,NULL,'gz',NULL,1593265680100,'newTab',NULL),(271,NULL,'gz',NULL,1593270120740,'newTab',NULL),(272,NULL,'gz',NULL,1593270777535,'newTab',NULL),(273,NULL,'gz',NULL,1593270847050,'newTab',NULL),(274,NULL,'gz',NULL,1593271097874,'newTab',NULL),(275,NULL,'gz',NULL,1593271166551,'newTab',NULL),(276,NULL,'ld',NULL,1593303846108,'newTab',NULL),(277,NULL,'lxh',NULL,1593305612351,'newTab',NULL),(278,NULL,'lxh',NULL,1593305628310,'newTab',NULL),(279,NULL,'gz',NULL,1593305864600,'newTab',NULL),(280,NULL,'gz',NULL,1593305880990,'newTab',NULL),(281,NULL,'gz',NULL,1593305888602,'newTab',NULL),(282,NULL,'gz',NULL,1593305892797,'newTab',NULL),(283,NULL,'gz',NULL,1593305937497,'newTab',NULL),(284,NULL,'ld',NULL,1593306592572,'newTab',NULL),(285,NULL,'gz',NULL,1593306748287,'newTab',NULL),(286,NULL,'gz',NULL,1593308155393,'newTab',NULL),(287,NULL,'gz',NULL,1593308159501,'newTab',NULL),(288,NULL,'lxh',NULL,1593308268463,'newTab',NULL),(289,NULL,'gz',NULL,1593308557645,'newTab',NULL),(290,NULL,'lxh',NULL,1593309002817,'newTab',NULL),(291,NULL,'gz',NULL,1593309215367,'newTab',NULL),(292,NULL,'lxh',NULL,1593309356098,'newTab',NULL),(293,NULL,'gz',NULL,1593309714607,'newTab',NULL),(294,NULL,'gz',NULL,1593309727887,'newTab',NULL),(295,NULL,'gz',NULL,1593309812709,'newTab',NULL),(296,NULL,'ld',NULL,1593312066446,'newTab',NULL),(297,NULL,'gz',NULL,1593313471700,'newTab',NULL),(298,NULL,'gz',NULL,1593314124021,'newTab',NULL),(299,NULL,'lxh',NULL,1593314871672,'newTab',NULL),(300,NULL,'gz',NULL,1593318177755,'newTab',NULL),(301,NULL,'gz',NULL,1593318234572,'newTab',NULL),(302,NULL,'gz',NULL,1593318720334,'newTab',NULL),(303,NULL,'gz',NULL,1593321748811,'newTab',NULL),(304,NULL,'gz',NULL,1593321794550,'newTab',NULL),(305,NULL,'gz',NULL,1593321800873,'newTab',NULL),(306,NULL,'gz',NULL,1593321802990,'newTab',NULL),(307,NULL,'gz',NULL,1593321804150,'newTab',NULL),(308,NULL,'gz',NULL,1593321805338,'newTab',NULL),(309,NULL,'gz',NULL,1593321806498,'newTab',NULL),(310,NULL,'gz',NULL,1593321818860,'newTab',NULL),(311,NULL,'gz',NULL,1593321875364,'newTab',NULL),(312,NULL,'gz',NULL,1593321876901,'newTab',NULL),(313,NULL,'gz',NULL,1593321880167,'newTab',NULL),(314,NULL,'gz',NULL,1593322060755,'newTab',NULL),(315,NULL,'gz',NULL,1593322074090,'newTab',NULL),(316,NULL,'gz',NULL,1593322076992,'newTab',NULL),(317,NULL,'gz',NULL,1593322078322,'newTab',NULL),(318,NULL,'gz',NULL,1593322082296,'newTab',NULL),(319,NULL,'gz',NULL,1593322084574,'newTab',NULL),(320,NULL,'gz',NULL,1593322090760,'newTab',NULL),(321,NULL,'gz',NULL,1593322113413,'newTab',NULL),(322,NULL,'gz',NULL,1593322120570,'newTab',NULL),(323,NULL,'gz',NULL,1593322125060,'newTab',NULL),(324,NULL,'gz',NULL,1593322220388,'newTab',NULL),(325,NULL,'gz',NULL,1593324015183,'newTab',NULL),(326,NULL,'lxh',NULL,1593324066149,'newTab',NULL),(327,NULL,'lxh',NULL,1593324783502,'newTab',NULL),(328,NULL,'hzj',NULL,1593327778495,'newTab',NULL),(329,NULL,'hzj',NULL,1593327818328,'newTab',NULL),(330,NULL,'hzj',NULL,1593328115531,'newTab',NULL),(331,NULL,'ld',NULL,1593328153197,'newTab',NULL),(332,NULL,'ld',NULL,1593328426942,'newTab',NULL),(333,NULL,'lxh',NULL,1593329809451,'newTab',NULL),(334,NULL,'lxh',NULL,1593329812457,'newTab',NULL),(335,NULL,'lxh',NULL,1593329813462,'newTab',NULL),(336,NULL,'lxh',NULL,1593331556137,'newTab',NULL),(337,NULL,'lxh',NULL,1593335683051,'newTab',NULL),(338,NULL,'lxh',NULL,1593335695288,'newTab',NULL),(339,NULL,'lxh',NULL,1593335742422,'newTab',NULL),(340,NULL,'lxh',NULL,1593335743842,'newTab',NULL),(341,NULL,'lxh',NULL,1593335756131,'newTab',NULL),(342,NULL,'lxh',NULL,1593335773548,'newTab',NULL),(343,NULL,'lxh',NULL,1593335783072,'newTab',NULL),(344,NULL,'lxh',NULL,1593335787111,'newTab',NULL),(345,NULL,'lxh',NULL,1593335792931,'newTab',NULL),(346,NULL,'lxh',NULL,1593335796471,'newTab',NULL),(347,NULL,'gz',NULL,1593347732325,'newTab',NULL),(348,NULL,'gz',NULL,1593348658247,'newTab',NULL),(349,NULL,'gz',NULL,1593353907286,'newTab',NULL),(350,NULL,'gz',NULL,1593355127619,'newTab',NULL),(351,NULL,'gz',NULL,1593356615435,'newTab',NULL),(352,NULL,'gz',NULL,1593358525068,'newTab',NULL),(353,NULL,'gz',NULL,1593391497490,'newTab',NULL),(354,NULL,'gz',NULL,1593391536714,'newTab',NULL),(355,NULL,'gz',NULL,1593391809218,'newTab',NULL),(356,NULL,'gz',NULL,1593391814452,'newTab',NULL),(357,NULL,'gz',NULL,1593391844768,'newTab',NULL),(358,NULL,'gz',NULL,1593392296849,'newTab',NULL),(359,NULL,'lxh',NULL,1593392517645,'newTab',NULL),(360,NULL,'gz',NULL,1593392695766,'newTab',NULL),(361,NULL,'gz',NULL,1593392719221,'newTab',NULL),(362,NULL,'gz',NULL,1593392731059,'newTab',NULL),(363,NULL,'gz',NULL,1593392732381,'newTab',NULL),(364,NULL,'gz',NULL,1593392738439,'newTab',NULL),(365,NULL,'gz',NULL,1593392746543,'newTab',NULL),(366,NULL,'gz',NULL,1593392767812,'newTab',NULL),(367,NULL,'gz',NULL,1593392819658,'newTab',NULL),(368,NULL,'gz',NULL,1593393360273,'newTab',NULL),(369,NULL,'gz',NULL,1593393420309,'newTab',NULL),(370,NULL,'gz',NULL,1593393802900,'newTab',NULL),(371,NULL,'gz',NULL,1593394040918,'newTab',NULL),(372,NULL,'lxh',NULL,1593396057143,'newTab',NULL),(373,NULL,'gz',NULL,1593396154244,'newTab',NULL),(374,NULL,'gz',NULL,1593396543482,'newTab',NULL),(375,NULL,'gz',NULL,1593397008933,'newTab',NULL),(376,NULL,'gz',NULL,1593398290004,'newTab',NULL),(377,NULL,'gz',NULL,1593398470896,'newTab',NULL),(378,NULL,'gz',NULL,1593398733367,'newTab',NULL),(379,NULL,'gz',NULL,1593398867939,'newTab',NULL),(380,NULL,'gz',NULL,1593398937206,'newTab',NULL),(381,NULL,'gz',NULL,1593399211422,'newTab',NULL),(382,NULL,'gz',NULL,1593399289424,'newTab',NULL),(383,NULL,'lxh',NULL,1593400536116,'newTab',NULL),(384,NULL,'lxh',NULL,1593401355700,'newTab',NULL),(385,NULL,'gz',NULL,1593403582676,'newTab',NULL),(386,NULL,'gz',NULL,1593403910222,'newTab',NULL),(387,NULL,'gz',NULL,1593404186453,'newTab',NULL),(388,NULL,'gz',NULL,1593404359830,'newTab',NULL),(389,NULL,'gz',NULL,1593404371284,'newTab',NULL),(390,NULL,'gz',NULL,1593404514050,'newTab',NULL),(391,NULL,'gz',NULL,1593404697481,'newTab',NULL),(392,NULL,'gz',NULL,1593404857596,'newTab',NULL),(393,NULL,'gz',NULL,1593404870821,'newTab',NULL),(394,NULL,'gz',NULL,1593404880980,'newTab',NULL),(395,NULL,'gz',NULL,1593404885447,'newTab',NULL),(396,NULL,'gz',NULL,1593404887261,'newTab',NULL),(397,NULL,'gz',NULL,1593404889340,'newTab',NULL),(398,NULL,'gz',NULL,1593404908030,'newTab',NULL),(399,NULL,'gz',NULL,1593404924159,'newTab',NULL),(400,NULL,'gz',NULL,1593404926804,'newTab',NULL),(401,NULL,'gz',NULL,1593404941579,'newTab',NULL),(402,NULL,'gz',NULL,1593404943356,'newTab',NULL),(403,NULL,'gz',NULL,1593404945297,'newTab',NULL),(404,NULL,'gz',NULL,1593404948604,'newTab',NULL),(405,NULL,'gz',NULL,1593405137460,'newTab',NULL),(406,NULL,'gz',NULL,1593405148623,'newTab',NULL),(407,NULL,'gz',NULL,1593405150483,'newTab',NULL),(408,NULL,'gz',NULL,1593405152159,'newTab',NULL),(409,NULL,'gz',NULL,1593405171912,'newTab',NULL),(410,NULL,'gz',NULL,1593405190182,'newTab',NULL),(411,NULL,'gz',NULL,1593407807203,'newTab',NULL),(412,NULL,'lxh',NULL,1593409219592,'newTab',NULL),(413,NULL,'lxh',NULL,1593409981303,'newTab',NULL),(414,NULL,'gz',NULL,1593410142628,'newTab',NULL),(415,NULL,'gz',NULL,1593411537035,'newTab',NULL),(416,NULL,'hzj',NULL,1593413289784,'newTab',NULL),(417,NULL,'wd',NULL,1593413790932,'newTab',NULL),(418,NULL,'lxh',NULL,1593414172810,'newTab',NULL),(419,NULL,'gz',NULL,1593414365344,'newTab',NULL),(420,NULL,'gz',NULL,1593416166786,'newTab',NULL),(421,NULL,'gz',NULL,1593416177758,'newTab',NULL),(422,NULL,'gz',NULL,1593417145685,'newTab',NULL),(423,NULL,'gz',NULL,1593419604417,'newTab',NULL),(424,NULL,'gz',NULL,1593420849761,'newTab',NULL),(425,NULL,'gz',NULL,1593428014658,'newTab',NULL),(426,NULL,'gz',NULL,1593428875383,'newTab',NULL),(427,NULL,'gz',NULL,1593430326484,'newTab',NULL),(428,NULL,'gz',NULL,1593430363165,'newTab',NULL),(429,NULL,'gz',NULL,1593430387538,'newTab',NULL),(430,NULL,'gz',NULL,1593430389778,'newTab',NULL),(431,NULL,'gz',NULL,1593430398724,'newTab',NULL),(432,NULL,'gz',NULL,1593441788612,'newTab',NULL),(433,NULL,'gz',NULL,1593441847671,'newTab',NULL),(434,NULL,'gz',NULL,1593441856473,'newTab',NULL),(435,NULL,'gz',NULL,1593441864427,'newTab',NULL),(436,NULL,'gz',NULL,1593441989787,'newTab',NULL),(437,NULL,'gz',NULL,1593441999462,'newTab',NULL),(438,NULL,'gz',NULL,1593442180072,'newTab',NULL),(439,NULL,'gz',NULL,1593442182231,'newTab',NULL),(440,NULL,'gz',NULL,1593442182836,'newTab',NULL),(441,NULL,'gz',NULL,1593442183259,'newTab',NULL),(442,NULL,'gz',NULL,1593442183677,'newTab',NULL),(443,NULL,'gz',NULL,1593442227575,'newTab',NULL),(444,NULL,'gz',NULL,1593442240199,'newTab',NULL),(445,NULL,'gz',NULL,1593442277832,'newTab',NULL),(446,NULL,'gz',NULL,1593442280983,'newTab',NULL),(447,NULL,'gz',NULL,1593442286192,'newTab',NULL),(448,NULL,'gz',NULL,1593442291336,'newTab',NULL),(449,NULL,'gz',NULL,1593442305796,'newTab',NULL),(450,NULL,'gz',NULL,1593442307699,'newTab',NULL),(451,NULL,'gz',NULL,1593442308976,'newTab',NULL),(452,NULL,'gz',NULL,1593442309937,'newTab',NULL),(453,NULL,'gz',NULL,1593442310573,'newTab',NULL),(454,NULL,'gz',NULL,1593442314242,'newTab',NULL),(455,NULL,'gz',NULL,1593442326638,'newTab',NULL),(456,NULL,'gz',NULL,1593442328292,'newTab',NULL),(457,NULL,'gz',NULL,1593442329251,'newTab',NULL),(458,NULL,'gz',NULL,1593442329921,'newTab',NULL),(459,NULL,'gz',NULL,1593442331628,'newTab',NULL),(460,NULL,'gz',NULL,1593442333238,'newTab',NULL),(461,NULL,'gz',NULL,1593442334002,'newTab',NULL),(462,NULL,'gz',NULL,1593442380589,'newTab',NULL),(463,NULL,'gz',NULL,1593478016018,'newTab',NULL),(464,NULL,'gz',NULL,1593478431729,'newTab',NULL),(465,NULL,'gz',NULL,1593478468244,'newTab',NULL),(466,NULL,'lxh',NULL,1593478760438,'newTab',NULL),(467,NULL,'gz',NULL,1593478792057,'newTab',NULL),(468,NULL,'lxh',NULL,1593478795897,'newTab',NULL),(469,NULL,'gz',NULL,1593478813585,'newTab',NULL),(470,NULL,'gz',NULL,1593478823453,'newTab',NULL),(471,NULL,'gz',NULL,1593478875666,'newTab',NULL),(472,NULL,'gz',NULL,1593478878643,'newTab',NULL),(473,NULL,'lxh',NULL,1593478992665,'newTab',NULL),(474,NULL,'gz',NULL,1593479033689,'newTab',NULL),(475,NULL,'lxh',NULL,1593479332595,'newTab',NULL),(476,NULL,'gz',NULL,1593479566975,'newTab',NULL),(477,NULL,'gz',NULL,1593479615522,'newTab',NULL),(478,NULL,'hzj',NULL,1593479658152,'newTab',NULL),(479,NULL,'lxh',NULL,1593479666469,'newTab',NULL),(480,NULL,'lxh',NULL,1593479741981,'newTab',NULL),(481,NULL,'gz',NULL,1593480006448,'newTab',NULL),(482,NULL,'gz',NULL,1593480011706,'newTab',NULL),(483,NULL,'gz',NULL,1593480942208,'newTab',NULL),(484,NULL,'gz',NULL,1593482771327,'newTab',NULL),(485,NULL,'gz',NULL,1593482919948,'newTab',NULL),(486,NULL,'gz',NULL,1593487006716,'newTab',NULL),(487,NULL,'hzj',NULL,1593488994693,'newTab',NULL),(488,NULL,'gz',NULL,1593491355596,'newTab',NULL),(489,NULL,'gz',NULL,1593497431098,'newTab',NULL),(490,NULL,'lxh',NULL,1593503587102,'newTab',NULL),(491,NULL,'gz',NULL,1593505288157,'newTab',NULL),(492,NULL,'gz',NULL,1593505313366,'newTab',NULL),(493,NULL,'gz',NULL,1593506244004,'newTab',NULL),(494,NULL,'gz',NULL,1593508831956,'newTab',NULL),(495,NULL,'gz',NULL,1593508859789,'newTab',NULL),(496,NULL,'lxh',NULL,1593512791119,'newTab',NULL),(497,NULL,'gz',NULL,1593515030875,'newTab',NULL),(498,NULL,'gz',NULL,1593515040436,'newTab',NULL),(499,NULL,'gz',NULL,1593519326621,'newTab',NULL),(500,NULL,'lxh',NULL,1593519364846,'newTab',NULL),(501,NULL,'lxh',NULL,1593519382297,'newTab',NULL),(502,NULL,'lxh',NULL,1593519412827,'newTab',NULL),(503,NULL,'lxh',NULL,1593519438374,'newTab',NULL),(504,NULL,'lxh',NULL,1593519443884,'newTab',NULL),(505,NULL,'lxh',NULL,1593519456007,'newTab',NULL),(506,NULL,'lxh',NULL,1593519474479,'newTab',NULL),(507,NULL,'lxh',NULL,1593519489888,'newTab',NULL),(508,NULL,'lxh',NULL,1593519496789,'newTab',NULL),(509,NULL,'lxh',NULL,1593519508632,'newTab',NULL),(510,NULL,'lxh',NULL,1593519519582,'newTab',NULL),(511,NULL,'gz',NULL,1593520725187,'newTab',NULL),(512,NULL,'gz',NULL,1593520727410,'newTab',NULL),(513,NULL,'gz',NULL,1593520772998,'newTab',NULL),(514,NULL,'gz',NULL,1593520775201,'newTab',NULL),(515,NULL,'gz',NULL,1593520791098,'newTab',NULL),(516,NULL,'gz',NULL,1593520793865,'newTab',NULL),(517,NULL,'gz',NULL,1593520813278,'newTab',NULL),(518,NULL,'gz',NULL,1593520814892,'newTab',NULL),(519,NULL,'gz',NULL,1593520816461,'newTab',NULL),(520,NULL,'wd',NULL,1593528496957,'newTab',NULL),(521,NULL,'gz',NULL,1593564415173,'newTab',NULL),(522,NULL,'gz',NULL,1593564472808,'newTab',NULL),(523,NULL,'gz',NULL,1593564492005,'newTab',NULL),(524,NULL,'gz',NULL,1593564503585,'newTab',NULL),(525,NULL,'gz',NULL,1593564685818,'newTab',NULL),(526,NULL,'lxh',NULL,1593564782442,'newTab',NULL),(527,NULL,'lxh',NULL,1593564794749,'newTab',NULL),(528,NULL,'gz',NULL,1593564865562,'newTab',NULL),(529,NULL,'gz',NULL,1593564913888,'newTab',NULL),(530,NULL,'gz',NULL,1593564942324,'newTab',NULL),(531,NULL,'gz',NULL,1593565758358,'newTab',NULL),(532,NULL,'gz',NULL,1593565763384,'newTab',NULL),(533,NULL,'gz',NULL,1593565776593,'newTab',NULL),(534,NULL,'gz',NULL,1593565783162,'newTab',NULL),(535,NULL,'lxh',NULL,1593565993051,'newTab',NULL),(536,NULL,'lxh',NULL,1593565995001,'newTab',NULL),(537,NULL,'lxh',NULL,1593565997171,'newTab',NULL),(538,NULL,'lxh',NULL,1593566001117,'newTab',NULL),(539,NULL,'lxh',NULL,1593566003972,'newTab',NULL),(540,NULL,'lxh',NULL,1593566007117,'newTab',NULL),(541,NULL,'lxh',NULL,1593566008775,'newTab',NULL),(542,NULL,'lxh',NULL,1593566010042,'newTab',NULL),(543,NULL,'lxh',NULL,1593566013007,'newTab',NULL),(544,NULL,'lxh',NULL,1593566014168,'newTab',NULL),(545,NULL,'lxh',NULL,1593566017300,'newTab',NULL),(546,NULL,'lxh',NULL,1593566018381,'newTab',NULL),(547,NULL,'lxh',NULL,1593566036275,'newTab',NULL),(548,NULL,'gz',NULL,1593566107794,'newTab',NULL),(549,NULL,'gz',NULL,1593566149279,'newTab',NULL),(550,NULL,'pzy',NULL,1593566246032,'newTab',NULL),(551,NULL,'pzy',NULL,1593566257056,'newTab',NULL),(552,NULL,'pzy',NULL,1593566266538,'newTab',NULL),(553,NULL,'gz',NULL,1593566281927,'newTab',NULL),(554,NULL,'pzy',NULL,1593566289348,'newTab',NULL),(555,NULL,'pzy',NULL,1593566304252,'newTab',NULL),(556,NULL,'pzy',NULL,1593566310208,'newTab',NULL),(557,NULL,'pzy',NULL,1593566337702,'newTab',NULL),(558,NULL,'gz',NULL,1593566352520,'newTab',NULL),(559,NULL,'pzy',NULL,1593566481929,'newTab',NULL),(560,NULL,'pzy',NULL,1593566495158,'newTab',NULL),(561,NULL,'pzy',NULL,1593566502967,'newTab',NULL),(562,NULL,'pzy',NULL,1593566511754,'newTab',NULL),(563,NULL,'pzy',NULL,1593566535932,'newTab',NULL),(564,NULL,'pzy',NULL,1593566589455,'newTab',NULL),(565,NULL,'pzy',NULL,1593566649626,'newTab',NULL),(566,NULL,'gz',NULL,1593566679034,'newTab',NULL),(567,NULL,'gz',NULL,1593566705278,'newTab',NULL),(568,NULL,'pzy',NULL,1593566718139,'newTab',NULL),(569,NULL,'gz',NULL,1593566727707,'newTab',NULL),(570,NULL,'gz',NULL,1593566849382,'newTab',NULL),(571,NULL,'pzy',NULL,1593566977587,'newTab',NULL),(572,NULL,'pzy',NULL,1593567441655,'newTab',NULL),(573,NULL,'gz',NULL,1593567593893,'newTab',NULL),(574,NULL,'gz',NULL,1593567685652,'newTab',NULL),(575,NULL,'gz',NULL,1593567691983,'newTab',NULL),(576,NULL,'gz',NULL,1593567717533,'newTab',NULL),(577,NULL,'pzy',NULL,1593567755091,'newTab',NULL),(578,NULL,'pzy',NULL,1593568272006,'newTab',NULL),(579,NULL,'pzy',NULL,1593568667481,'newTab',NULL),(580,NULL,'lxh',NULL,1593569325248,'newTab',NULL),(581,NULL,'pzy',NULL,1593570278826,'newTab',NULL),(582,NULL,'pzy',NULL,1593570636005,'newTab',NULL),(583,NULL,'gz',NULL,1593570827881,'newTab',NULL),(584,NULL,'hzj',NULL,1593570949018,'newTab',NULL),(585,NULL,'gz',NULL,1593571337494,'newTab',NULL),(586,NULL,'pzy',NULL,1593571539281,'newTab',NULL),(587,NULL,'gz',NULL,1593571932359,'newTab',NULL),(588,NULL,'gz',NULL,1593572151792,'newTab',NULL),(589,NULL,'gz',NULL,1593572777125,'newTab',NULL),(590,NULL,'gz',NULL,1593572842722,'newTab',NULL),(591,NULL,'gz',NULL,1593572928274,'newTab',NULL),(592,NULL,'gz',NULL,1593573009135,'newTab',NULL),(593,NULL,'pzy',NULL,1593573292944,'newTab',NULL),(594,NULL,'gz',NULL,1593573576025,'newTab',NULL),(595,NULL,'gz',NULL,1593573704480,'newTab',NULL),(596,NULL,'gz',NULL,1593573720708,'newTab',NULL),(597,NULL,'gz',NULL,1593573824944,'newTab',NULL),(598,NULL,'gz',NULL,1593573837446,'newTab',NULL),(599,NULL,'gz',NULL,1593574151719,'newTab',NULL),(600,NULL,'gz',NULL,1593576127967,'newTab',NULL),(601,NULL,'gz',NULL,1593576183902,'newTab',NULL),(602,NULL,'gz',NULL,1593576310283,'newTab',NULL),(603,NULL,'gz',NULL,1593576313408,'newTab',NULL),(604,NULL,'gz',NULL,1593576388990,'newTab',NULL),(605,NULL,'gz',NULL,1593576913214,'newTab',NULL),(606,NULL,'gz',NULL,1593580376089,'newTab',NULL),(607,NULL,'gz',NULL,1593581127628,'newTab',NULL),(608,NULL,'gz',NULL,1593581131747,'newTab',NULL),(609,NULL,'gz',NULL,1593581340450,'newTab',NULL),(610,NULL,'lxh',NULL,1593581410953,'newTab',NULL),(611,NULL,'gz',NULL,1593581831951,'newTab',NULL),(612,NULL,'gz',NULL,1593582142221,'newTab',NULL),(613,NULL,'lxh',NULL,1593582977617,'newTab',NULL),(614,NULL,'gz',NULL,1593583218865,'newTab',NULL),(615,NULL,'gz',NULL,1593583472503,'newTab',NULL),(616,NULL,'pzy',NULL,1593583584457,'newTab',NULL),(617,NULL,'pzy',NULL,1593583751218,'newTab',NULL),(618,NULL,'gz',NULL,1593584638691,'newTab',NULL),(619,NULL,'gz',NULL,1593584814252,'newTab',NULL),(620,NULL,'gz',NULL,1593586602188,'newTab',NULL),(621,NULL,'gz',NULL,1593586826087,'newTab',NULL),(622,NULL,'pzy',NULL,1593586834459,'newTab',NULL),(623,NULL,'pzy',NULL,1593587187534,'newTab',NULL),(624,NULL,'gz',NULL,1593587881524,'newTab',NULL),(625,NULL,'gz',NULL,1593587973746,'newTab',NULL),(626,NULL,'gz',NULL,1593588007566,'newTab',NULL),(627,NULL,'pzy',NULL,1593588193436,'newTab',NULL),(628,NULL,'gz',NULL,1593588253383,'newTab',NULL),(629,NULL,'lxh',NULL,1593588311323,'newTab',NULL),(630,NULL,'lxh',NULL,1593588589092,'newTab',NULL),(631,NULL,'lxh',NULL,1593588641662,'newTab',NULL),(632,NULL,'lxh',NULL,1593588649116,'newTab',NULL),(633,NULL,'lxh',NULL,1593588651821,'newTab',NULL),(634,NULL,'lxh',NULL,1593588656653,'newTab',NULL),(635,NULL,'gz',NULL,1593588702578,'newTab',NULL),(636,NULL,'gz',NULL,1593588761550,'newTab',NULL),(637,NULL,'root',NULL,1593588776027,'newTab',NULL),(638,NULL,'root',NULL,1593588782484,'newTab',NULL),(639,NULL,'gz',NULL,1593588808753,'newTab',NULL),(640,NULL,'gz',NULL,1593590016303,'newTab',NULL),(641,NULL,'gz',NULL,1593590409238,'newTab',NULL),(642,NULL,'pzy',NULL,1593590662555,'newTab',NULL),(643,NULL,'pzy',NULL,1593590668415,'newTab',NULL),(644,NULL,'gz',NULL,1593591043070,'newTab',NULL),(645,NULL,'gz',NULL,1593591291225,'newTab',NULL),(646,NULL,'gz',NULL,1593591663092,'newTab',NULL),(647,NULL,'gz',NULL,1593591668737,'newTab',NULL),(648,NULL,'gz',NULL,1593591787128,'newTab',NULL),(649,NULL,'gz',NULL,1593591973000,'newTab',NULL),(650,NULL,'gz',NULL,1593592069630,'newTab',NULL),(651,NULL,'gz',NULL,1593592122735,'newTab',NULL),(652,NULL,'gz',NULL,1593592303852,'newTab',NULL),(653,NULL,'gz',NULL,1593592685480,'newTab',NULL),(654,NULL,'gz',NULL,1593592687548,'newTab',NULL),(655,NULL,'gz',NULL,1593593240635,'newTab',NULL),(656,NULL,'pzy',NULL,1593593283752,'newTab',NULL),(657,NULL,'gz',NULL,1593593332131,'newTab',NULL),(658,NULL,'gz',NULL,1593593373162,'newTab',NULL),(659,NULL,'pzy',NULL,1593593454168,'newTab',NULL),(660,NULL,'gz',NULL,1593593456287,'newTab',NULL),(661,NULL,'pzy',NULL,1593593466719,'newTab',NULL),(662,NULL,'pzy',NULL,1593593472509,'newTab',NULL),(663,NULL,'gz',NULL,1593593478649,'newTab',NULL),(664,NULL,'pzy',NULL,1593593480141,'newTab',NULL),(665,NULL,'pzy',NULL,1593593560839,'newTab',NULL),(666,NULL,'gz',NULL,1593593807689,'newTab',NULL),(667,NULL,'gz',NULL,1593593912108,'newTab',NULL),(668,NULL,'pzy',NULL,1593593913288,'newTab',NULL),(669,NULL,'gz',NULL,1593593972203,'newTab',NULL),(670,NULL,'gz',NULL,1593594000117,'newTab',NULL),(671,NULL,'gz',NULL,1593594057729,'newTab',NULL),(672,NULL,'gz',NULL,1593594058964,'newTab',NULL),(673,NULL,'gz',NULL,1593594059928,'newTab',NULL),(674,NULL,'gz',NULL,1593594066290,'newTab',NULL),(675,NULL,'gz',NULL,1593594074995,'newTab',NULL),(676,NULL,'gz',NULL,1593594150327,'newTab',NULL),(677,NULL,'gz',NULL,1593594193257,'newTab',NULL),(678,NULL,'gz',NULL,1593594198195,'newTab',NULL),(679,NULL,'gz',NULL,1593594291552,'newTab',NULL),(680,NULL,'gz',NULL,1593594440445,'newTab',NULL),(681,NULL,'gz',NULL,1593594712780,'newTab',NULL),(682,NULL,'gz',NULL,1593594731405,'newTab',NULL),(683,NULL,'gz',NULL,1593594734283,'newTab',NULL),(684,NULL,'gz',NULL,1593594802534,'newTab',NULL),(685,NULL,'lxh',NULL,1593595065293,'newTab',NULL),(686,NULL,'pzy',NULL,1593595197918,'newTab',NULL),(687,NULL,'pzy',NULL,1593595204641,'newTab',NULL),(688,NULL,'pzy',NULL,1593595546506,'newTab',NULL),(689,NULL,'pzy',NULL,1593595644520,'newTab',NULL),(690,NULL,'pzy',NULL,1593595699594,'newTab',NULL),(691,NULL,'pzy',NULL,1593595777506,'newTab',NULL),(692,NULL,'gz',NULL,1593598109938,'newTab',NULL),(693,NULL,'gz',NULL,1593598637845,'newTab',NULL),(694,NULL,'gz',NULL,1593598665183,'newTab',NULL),(695,NULL,'gz',NULL,1593608001371,'newTab',NULL),(696,NULL,'gz',NULL,1593608416270,'newTab',NULL),(697,NULL,'gz',NULL,1593608417020,'newTab',NULL),(698,NULL,'gz',NULL,1593608426892,'newTab',NULL),(699,NULL,'gz',NULL,1593608456992,'newTab',NULL),(700,NULL,'gz',NULL,1593608458053,'newTab',NULL),(701,NULL,'gz',NULL,1593608466279,'newTab',NULL),(702,NULL,'gz',NULL,1593608483694,'newTab',NULL),(703,NULL,'gz',NULL,1593608489231,'newTab',NULL),(704,NULL,'gz',NULL,1593608506532,'newTab',NULL),(705,NULL,'gz',NULL,1593608519177,'newTab',NULL),(706,NULL,'gz',NULL,1593608524219,'newTab',NULL),(707,NULL,'gz',NULL,1593608566241,'newTab',NULL),(708,NULL,'gz',NULL,1593608622866,'newTab',NULL),(709,NULL,'gz',NULL,1593608629801,'newTab',NULL),(710,NULL,'gz',NULL,1593609195722,'newTab',NULL),(711,NULL,'gz',NULL,1593609200149,'newTab',NULL),(712,NULL,'gz',NULL,1593609258991,'newTab',NULL),(713,NULL,'gz',NULL,1593609280680,'newTab',NULL),(714,NULL,'gz',NULL,1593609281836,'newTab',NULL),(715,NULL,'gz',NULL,1593609296354,'newTab',NULL),(716,NULL,'gz',NULL,1593609297663,'newTab',NULL),(717,NULL,'gz',NULL,1593609300579,'newTab',NULL),(718,NULL,'gz',NULL,1593609316522,'newTab',NULL),(719,NULL,'gz',NULL,1593609324341,'newTab',NULL),(720,NULL,'gz',NULL,1593609571616,'newTab',NULL),(721,NULL,'gz',NULL,1593609670278,'newTab',NULL),(722,NULL,'gz',NULL,1593609674562,'newTab',NULL),(723,NULL,'gz',NULL,1593609677189,'newTab',NULL),(724,NULL,'gz',NULL,1593609677843,'newTab',NULL),(725,NULL,'gz',NULL,1593609678484,'newTab',NULL),(726,NULL,'gz',NULL,1593609678996,'newTab',NULL),(727,NULL,'gz',NULL,1593609704206,'newTab',NULL),(728,NULL,'gz',NULL,1593609933658,'newTab',NULL),(729,NULL,'gz',NULL,1593610004417,'newTab',NULL),(730,NULL,'gz',NULL,1593610010137,'newTab',NULL),(731,NULL,'gz',NULL,1593610029681,'newTab',NULL),(732,NULL,'gz',NULL,1593610058816,'newTab',NULL),(733,NULL,'gz',NULL,1593610062947,'newTab',NULL),(734,NULL,'gz',NULL,1593610082359,'newTab',NULL),(735,NULL,'gz',NULL,1593610090750,'newTab',NULL),(736,NULL,'gz',NULL,1593610091995,'newTab',NULL),(737,NULL,'gz',NULL,1593610257437,'newTab',NULL),(738,NULL,'gz',NULL,1593610258385,'newTab',NULL),(739,NULL,'gz',NULL,1593610271543,'newTab',NULL),(740,NULL,'gz',NULL,1593610272524,'newTab',NULL),(741,NULL,'gz',NULL,1593610273335,'newTab',NULL),(742,NULL,'gz',NULL,1593610273955,'newTab',NULL),(743,NULL,'gz',NULL,1593610277311,'newTab',NULL),(744,NULL,'gz',NULL,1593610287354,'newTab',NULL),(745,NULL,'gz',NULL,1593610293179,'newTab',NULL),(746,NULL,'gz',NULL,1593610295084,'newTab',NULL),(747,NULL,'gz',NULL,1593610503093,'newTab',NULL),(748,NULL,'gz',NULL,1593610510667,'newTab',NULL),(749,NULL,'gz',NULL,1593610604763,'newTab',NULL),(750,NULL,'gz',NULL,1593611304938,'newTab',NULL),(751,NULL,'gz',NULL,1593615768260,'newTab',NULL),(752,NULL,'gz',NULL,1593616214712,'newTab',NULL),(753,NULL,'gz',NULL,1593616229450,'newTab',NULL);
/*!40000 ALTER TABLE `user_activity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 23:16:20
