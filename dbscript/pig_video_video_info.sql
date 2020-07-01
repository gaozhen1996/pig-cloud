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
-- Table structure for table `video_info`
--

DROP TABLE IF EXISTS `video_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  `videoURL` varchar(255) DEFAULT NULL COMMENT '视频路径',
  `delFlag` bigint(1) DEFAULT NULL COMMENT '存在表示',
  `content` text NOT NULL COMMENT '内容',
  `showFlag` bigint(1) DEFAULT NULL COMMENT '展示表示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COMMENT='视频信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_info`
--

LOCK TABLES `video_info` WRITE;
/*!40000 ALTER TABLE `video_info` DISABLE KEYS */;
INSERT INTO `video_info` VALUES (1,1591938139187,'http://alimov2.a.yximgs.com/upic/2018/08/20/17/BMjAxODA4MjAxNzU1MTJfNDU0NjI4OTU5Xzc2ODY0MjMwNTBfMl8z_hd3_Bb1dd04ed9505a6dc0b1ed0a9961de113.mp4',NULL,'驾考小技巧每天更新双击收藏吧',NULL),(2,1591938139197,'http://alimov2.a.yximgs.com/upic/2018/08/22/18/BMjAxODA4MjIxODEwNTBfMTQ0Mzk3OTE1Xzc3MTYwNzQwMzJfMV8z_hd3_Bdb62040b579143b5950849e2ac9b70dd.mp4',NULL,'...',NULL),(3,1591938139204,'http://tx2.a.yximgs.com/upic/2018/12/11/18/BMjAxODEyMTExODE1MDlfMzIyNDQ1OTQwXzkzMjEzMDUxNDBfMV8z_b_B20b89ea1cde047e54be1e3441cb78798.mp4',NULL,'我真的在名仕酒吧找到男朋友了吗？? 老铁们双击，评论起来',NULL),(4,1591938139210,'http://jsmov2.a.yximgs.com/upic/2019/04/04/18/BMjAxOTA0MDQxODM3MDhfNTI0NTYxNzFfMTE5MjM0NTI2ODBfMV8z_b_B74e457016a388d3fae4b6e6823e7269f.mp4',NULL,'...',NULL),(5,1591938139220,'http://jsmov2.a.yximgs.com/upic/2019/04/18/18/BMjAxOTA0MTgxODIyNDhfMTExNjg0MTU4OV8xMjMwMDU4MzYzMV8xXzM=_b_B6fa2c230aa2f55dbe14ac8137a37da09.mp4',NULL,'据说这个小游戏没人逃得过它的测试结果#心理测试',NULL),(6,1591938139227,'http://qnmov.a.yximgs.com/upic/2019/06/12/11/BMjAxOTA2MTIxMTMzMjRfODMwODkzNzc2XzEzOTkwOTg0MzA1XzFfMw==_b_Bd7d64832b3f59b138015c1dca4066594.mp4',NULL,'感情太好了吧',NULL),(7,1591939502844,'http://txmov2.a.yximgs.com/upic/2018/08/31/13/BMjAxODA4MzExMzUzNTZfMTc3MTE4OTNfNzg0NDMzNjYyMl8yXzM=_hd3_B9534d4eb338d708cf0416523006775eb.mp4',NULL,'可怕的微调。砍的我小心脏砰砰跳\n\n\n#DNF##地下城与勇士#',NULL),(8,1591939502851,'http://alimov2.a.yximgs.com/upic/2018/09/07/10/BMjAxODA5MDcxMDMzNTJfMzM1OTk3OTQyXzc5MzExNjQwMzBfMl8z_hd3_Baf48964b4ce74a9c7b78ea1a0e03d4e2.mp4',NULL,'...',NULL),(9,1591939502859,'http://jsmov2.a.yximgs.com/upic/2019/06/15/08/BMjAxOTA2MTUwODI3MDlfMTEwMDU0NjkxMV8xNDA4MDU2NTQ0MV8xXzM=_b_B248d0f445dda305a0fe8d51fc751aa84.mp4',NULL,'现在的生活是真好呀，想想都开心?\n @蓝天晨【大石桥联盟】\n @阿浩【大石桥联盟】\n @富贵【大石桥联盟】 \n @星林【大石桥联盟】\n @胡胖【大石桥联盟】\n @李雪秋【大石桥联盟】\n @海龙【大石桥联盟】 \n\n摄影?： @明M【大石桥联盟】',NULL),(10,1591939502866,'http://alimov2.a.yximgs.com/upic/2019/03/16/10/BMjAxOTAzMTYxMDAxMTRfNjA2MzMwMjkzXzExNDMxOTI4MDk5XzFfMw==_b_Be0b57e1415cc80d66334498790416879.mp4',NULL,'炒的怎么样',NULL),(11,1592038500052,'http://jsmov2.a.yximgs.com/upic/2018/11/11/19/BMjAxODExMTExOTMwMTBfNzQ5Mjk1MDFfODg3MzUzNDM1M18xXzM=_b_B6e28d627ff594d29174e60b48e77adad.mp4',NULL,'姐姐刚下车 视频更新晚啦?抱歉让你们久等啦 姐姐会每天准时给你们更新的 已备足库存啦 双击吧❤️！\n\n✈️明天八点飞广州～',NULL),(12,1592038500081,'http://qnmov.a.yximgs.com/upic/2019/04/18/17/BMjAxOTA0MTgxNzEyMTBfMTgxNDQ2Mjk3XzEyMjk4Njc2Nzg3XzFfMw==_b_Bc45e3e4e8171c6200db2e1a6e5c34a94.mp4',NULL,'我妈真能忽悠我 我说不可能请我吃饭吗 套路',NULL),(13,1592038500089,'http://jsmov2.a.yximgs.com/upic/2019/07/03/16/BMjAxOTA3MDMxNjQ4MDZfNzMxMjY2NTYzXzE0NzM4NzUxMjk4XzFfMw==_b_Ba1385366e3519841e74874f2dd88cc7d.mp4',NULL,'#日长穿搭 #感谢快手平台 #感谢快手我要上热门',NULL),(14,1592038528100,'http://jsmov2.a.yximgs.com/upic/2018/09/13/19/BMjAxODA5MTMxOTAwMDJfMzI0ODU0ODI5XzgwMTU4ODUzNjNfMV8z_b_B70aef688a2bbbd9e7329050c886b2d07.mp4',NULL,'点击头像更多精彩',NULL),(15,1592038528110,'http://tx2.a.yximgs.com/upic/2019/01/23/16/BMjAxOTAxMjMxNjIxMjFfMTAyOTc1MjA4MV8xMDEwNzEyMDg1M18xXzM=_b_Ba61ed0dec9855ba94b0c6010ee700817.mp4',NULL,'关爱环卫工人，爱护公共环境，从你我做起！每天一点点真能量，有你们的见证，我很欣慰！加油！我会努力坚持下去的✊',NULL),(16,1592038528116,'http://jsmov2.a.yximgs.com/upic/2019/03/24/17/BMjAxOTAzMjQxNzM2MjJfMTE1MzYyODM0MF8xMTY0OTI0MTMwM18xXzM=_b_B1603fb96e440aeb3342111a001b3693a.mp4',NULL,'喜欢发型可以关注我哦',NULL),(17,1592038536980,'http://alimov2.a.yximgs.com/upic/2018/05/27/15/BMjAxODA1MjcxNTU3MjJfNzAzNzU0NDMyXzY0NDYyMjA2MDNfMl8z_hd3_Bbd8c2708bb6ed997d2ec84596a498cda.mp4',NULL,'...',NULL),(18,1592038536987,'http://txmov2.a.yximgs.com/upic/2018/06/19/11/BMjAxODA2MTkxMTQ2MjFfMjQzOTk4OTE2XzY3NDAyMDc2NjRfMl8z_hd3_B18450a418bc5dcad4a8a8bb27bbc3040.mp4',NULL,'?双击?666',NULL),(19,1592038536993,'http://txmov2.a.yximgs.com/upic/2018/08/20/12/BMjAxODA4MjAxMjIyMDdfNTkwNzYyNjY1Xzc2ODE3NzI4MjNfMV8z_b_B9283b287a27cf6cef95c33e852481b71.mp4',NULL,'...',NULL),(20,1592038536999,'http://tx2.a.yximgs.com/upic/2018/12/18/18/BMjAxODEyMTgxODI3NTFfMzk0MDY0MzUwXzk0MzExNzcxNzRfMl8z_b_B2c01546d981b96888dc9d019e69067cd.mp4',NULL,'...',NULL),(21,1592038546450,'http://jsmov2.a.yximgs.com/upic/2018/08/24/00/BMjAxODA4MjQwMDAxNDBfNTI1NjQ3MzE3Xzc3MzYwNjg0NDZfMl8z_hd3_Bcadfdc7dde214324b9f4e0378bfec40e.mp4',NULL,'别屏蔽我阿',NULL),(22,1592038546457,'http://alimov2.a.yximgs.com/upic/2019/06/24/10/BMjAxOTA2MjQxMDM5NDlfNDIzMzcyMzgwXzE0NDA0MjM2MjQ0XzJfMw==_b_Bef3b9758731d1783207df59979817b2c.mp4',NULL,'无兄弟，不篮球???#热爱篮球 #篮球',NULL),(23,1592038546465,'http://hwmov.a.yximgs.com/upic/2019/06/24/11/BMjAxOTA2MjQxMTU4NDVfMTY1NTQ4OTEzXzE0NDA2MzkyODI3XzJfMw==_b_B236f811b498855db126880a106f66290.mp4',NULL,'妈妈拌菜 爸爸品尝后最后决定口感',NULL),(24,1592038546472,'http://txmov2.a.yximgs.com/upic/2019/07/25/13/BMjAxOTA3MjUxMzM3NTlfNjMyNzM1NDI4XzE1NjAwODI4Njc4XzJfMw==_b_B58ce701bc81c818e797687684e335538.mp4',NULL,'...',NULL),(25,1592038546479,'http://tx2.a.yximgs.com/upic/2019/01/07/21/BMjAxOTAxMDcyMTM5MzFfMTA5NTkwODQwMF85ODAwNzY5MTAyXzJfMw==_b_B1a0052a2bf10b830fb3e7394e9d0b001.mp4',NULL,'你最多能吃多少饺子？#南宁 #美食 #吃喝玩乐',NULL),(26,1592312840213,'http://alimov2.a.yximgs.com/upic/2019/04/18/13/BMjAxOTA0MTgxMzQ4MDNfMTE4MzI0NjA1XzEyMjk0MzYwMTAwXzFfMw==_b_B2981ca8264932c730a04dde94042703a.mp4',NULL,'要看完呀 #小哥哥小姐姐#',NULL),(27,1592312840279,'http://tx2.a.yximgs.com/upic/2019/01/23/09/BMjAxOTAxMjMwOTI0MzFfNTIwMDcxNTk1XzEwMDk4ODE0ODkzXzJfMw==_b_B18e1fcf3ca68b711b81f8d62f88f20a8.mp4',NULL,'...#记录我的生活#',NULL),(28,1592312845284,'http://tx2.a.yximgs.com/upic/2018/10/09/16/BMjAxODEwMDkxNjIxMzlfMTAxNTE0MDA0N184Mzk4NDkyNzY4XzFfMw==_b_B3f15cdac8ac48d0d8947f65094e02e06.mp4',NULL,'脸大的我',NULL),(29,1592312845296,'http://bdmov.a.yximgs.com/upic/2019/07/15/19/BMjAxOTA3MTUxOTQzMjFfMTMxNDQzMDgyXzE1MjIxNTk3ODU0XzFfMw==_b_B3ed2c78d49711372558befdbd97c7603.mp4',NULL,'谁说女子不如男，现代单身花木兰，有人要吗。?举个手#王者荣耀',NULL),(30,1592312845303,'http://bdmov.a.yximgs.com/upic/2019/07/16/10/BMjAxOTA3MTYxMDQyMDZfNDM4NTkyMTYxXzE1MjQwMjA3OTY4XzFfMw==_b_Bb90c5ead31d19ed6e2ed3f627483dfea.mp4',NULL,'把我拍成一点都不像85斤的人?',NULL),(31,1592312853427,'http://tx2.a.yximgs.com/upic/2018/08/27/06/BMjAxODA4MjcwNjA0MjdfNTM2NjI2NTM3Xzc3ODI1NzM4MTlfMl8z_b_Be673a793521735a31b65aed8bd81f47f.mp4',NULL,'...',NULL),(32,1592312853435,'http://bdmov.a.yximgs.com/upic/2019/04/09/11/BMjAxOTA0MDkxMTIwNDBfNzYyNTkxNDgzXzEyMDY1MjkxOTg4XzJfMw==_b_B2ab34e88ff804b9252e4346d8a1c9b1d.mp4',NULL,'...',NULL),(33,1592312859409,'http://txmov2.a.yximgs.com/upic/2019/07/12/20/BMjAxOTA3MTIyMDMzMTJfMTMxMjgwNjM5Nl8xNTEwMjI1NTM3MV8xXzM=_b_B6637886da34034c0f76e540c120d2d08.mp4',NULL,'妈妈是世界上最唠叨的人，也是最爱你的人，答应我，对她多丢丢耐心哦～\n#感谢快手我要上热门 #支持快手传播正能量 #快手小剧场 #微剧',NULL),(34,1592312859418,'http://txmov2.a.yximgs.com/upic/2019/03/17/18/BMjAxOTAzMTcxODQ3MThfMTYxOTcyMjU2XzExNDc3Nzc1NzQzXzJfMw==_b_B58332497ae104362120b677bdf01a5ec.mp4',NULL,'大吵大闹的从来都不是真正的离开，默不作声才是\n#情感语录',NULL),(35,1592312873651,'http://qnmov.a.yximgs.com/upic/2018/06/03/22/BMjAxODA2MDMyMjA3MzFfMjM4NDEwNzk2XzY1NDEwNDgyOTdfMV8z_hd3_B13aa9ab94cc2357f025c239232f9add6.mp4',NULL,'☞和我的朵宝又来了??我朵的笑容最迷人，支持快手正能量！愿每一个妈妈都是孩子的榜样！\n\n今日语录:\n短期交往看脸蛋，长期交往看脾气，一生交往看人品，时光会教你看清每一张脸！愿我们可以一直住进你的心里❤笔芯',NULL),(36,1592312873661,'http://txmov2.a.yximgs.com/upic/2018/08/20/19/BMjAxODA4MjAxOTMxMDRfMTIyNzkxNDA1Xzc2ODc5NjY4NzJfMl8z_hd3_Bcc35c62c797e582411ab79b479d69e86.mp4',NULL,'...',NULL),(37,1592312873671,'http://txmov2.a.yximgs.com/upic/2019/06/18/13/BMjAxOTA2MTgxMzUyMzZfMTM0OTI5NzgwM18xNDE5OTc2MjU1Ml8wXzM=_b_B6369b2713e8fe5de72780c8e2247efbc.mp4',NULL,'打开荔枝APP,更多精彩鬼故事等你来听!',NULL),(38,1592313522635,'http://qnmov.a.yximgs.com/upic/2018/09/10/17/BMjAxODA5MTAxNzQwMTZfNzAyMTE3MDlfNzk3OTg2NTIyMV8xXzM=_hd3_Bc0019ba2dde6c5c55eed62a2726dc761.mp4',NULL,'来自一个小姐姐投稿❤️\n\n一个游戏玩毁了多少人的心呢？\n\n话题：你玩快手多久了？谢谢陪着活宝的\n\n努力练貂蝉加油?',NULL),(39,1592313522646,'http://jsmov2.a.yximgs.com/upic/2019/07/06/12/BMjAxOTA3MDYxMjEyNDZfMTIwNDE1MTEyOF8xNDg0MzM2OTYwNF8yXzM=_b_Bc3214796fbf62bdb26cfd8cbd8d896ec.mp4',NULL,'你们喜欢吃汉堡包吗',NULL),(40,1592313588184,'http://jsmov2.a.yximgs.com/upic/2018/05/31/19/BMjAxODA1MzExOTIxMjhfODExOTkzNDM5XzY0OTM3NzU0ODNfMV8z_b_B82ea048517d1d25c735a841d9569d164.mp4',NULL,'矮脚宝宝，走起路来可萌可萌的。',NULL),(41,1592313588193,'http://qnmov.a.yximgs.com/upic/2019/06/16/17/BMjAxOTA2MTYxNzEyMzNfNjA0NTY4NTMyXzE0MTQyMTU1MjU2XzFfMw==_b_B286315a97e68f3fadbff8686f49f5d49.mp4',NULL,'祝全天下父母长命百岁\n父亲节快乐\n今日话题：你今天送你父亲什么？\n评论父亲节快乐\n#感谢快手我要上热门',NULL),(42,1592313588202,'http://tx2.a.yximgs.com/upic/2019/01/11/15/BMjAxOTAxMTExNTE4MjVfMTkwNDU3NzIxXzk4NjM1NzA0MjlfMV8z_b_B321480f54477f6eac6b4b1652617454b.mp4',NULL,'#家庭美食争霸赛#',NULL),(43,1592313588210,'http://txmov2.a.yximgs.com/upic/2019/03/19/22/BMjAxOTAzMTkyMjI3NDNfMTAzNDE1ODkyOF8xMTUyNzM3NzgzMF8yXzM=_b_B107f803d4e0682739bb135e309fcc0cc.mp4',NULL,'...',NULL),(44,1592314146501,'http://txmov2.a.yximgs.com/upic/2018/08/20/08/BMjAxODA4MjAwODE3MzFfMjQwOTgwNjkyXzc2Nzg5MDU4MjZfMV8z_hd3_Bb080debc8f9af717d39a78bc7f58b75f.mp4',NULL,'早上好',NULL),(45,1592314146532,'http://alimov2.a.yximgs.com/upic/2019/04/08/18/BMjAxOTA0MDgxODAxMTBfNTMyMDc1Mjk1XzEyMDUwOTEzMTU2XzFfMw==_b_B49e1ec7a3de89504f5e9de3d415ee09a.mp4',NULL,'很简单哦',NULL),(46,1592314146581,'http://msmov.a.yximgs.com/upic/2019/05/16/19/BMjAxOTA1MTYxOTEzMjlfMjk5NjMxMjE0XzEzMTE4MzE5MjY3XzFfMw==_b_B8e940df53aae7c49205e266dbb40f0de.mp4',NULL,'我的库存，没有了……#烫门 #热门 #我要上热门 #爱官方爱热门',NULL),(47,1592314146590,'http://tx2.a.yximgs.com/upic/2019/01/17/09/BMjAxOTAxMTcwOTUxNTFfMzc2NjAzOTU1Xzk5NzY0OTU2MTBfMl8z_b_B7ce50261084f58ebbd266690fcfe8c97.mp4',NULL,'...',NULL),(48,1592314757957,'http://alimov2.a.yximgs.com/upic/2018/11/09/20/BMjAxODExMDkyMDE2MjhfNDgxNzY5OTgwXzg4MzgwODAwNDdfMl8z_b_Ba5750df12402b830f6e6bfec27f7c330.mp4',NULL,'双击点亮红心，方便查找',NULL),(49,1592314757967,'http://tx2.a.yximgs.com/upic/2019/02/25/14/BMjAxOTAyMjUxNDU5NTJfOTMwMTI0ODcyXzExMDE1NzA0NDQxXzFfMw==_b_B3f787bf7e707aec1efceec68e1ed4125.mp4',NULL,'#快影 #美食 #爱官方',NULL),(50,1592314757973,'http://sjymov.a.yximgs.com/upic/2019/03/20/09/BMjAxOTAzMjAwOTMzMjNfNTM5NDk5MDI3XzExNTMxOTA0MDA0XzJfMw==_b_B23dbcf9e81a7b6a07fc8b0b04d2ad8bb.mp4',NULL,'...',NULL),(51,1592314757979,'http://ydmov.a.yximgs.com/upic/2019/03/21/18/BMjAxOTAzMjExODQ0NTVfMTExNTgxMjAyN18xMTU2NTIzNDU0Ml8xXzM=_b_B24d792f49dbc5fab2ce791afe61baaa1.mp4',NULL,'...',NULL),(52,1592315311765,'http://jsmov2.a.yximgs.com/upic/2019/04/09/17/BMjAxOTA0MDkxNzMyMTFfMTAxODQwOTc1OV8xMjA3MzA1MDY0Nl8xXzM=_b_Bd77eb2e2c4805e91835f29e57efcfc11.mp4',NULL,'我滴个乖乖。真的是好了，是我做的瓜尔胶最喜欢的一个?。',NULL),(53,1592315311775,'http://js2.a.yximgs.com/upic/2019/02/24/17/BMjAxOTAyMjQxNzMzMjJfOTEyNjMzNzUyXzEwOTk4NTIwNzA0XzJfMw==_b_Bd1f03b5122101abcab20a5058fd99ef9.mp4',NULL,'挖不到竹笋的时候就这样??',NULL),(54,1592315333899,'http://js2.a.yximgs.com/upic/2018/11/05/09/BMjAxODExMDUwOTE3NDZfMjMxMTU3MDkxXzg3Nzc1NDAxNTBfMV8z_b_Bdb5a2bffe6784c05bb5802776ad44d50.mp4',NULL,'此物 招财，辟邪……知道的朋友评论666，为手艺人赞一赞?',NULL),(55,1592315333914,'http://jsmov2.a.yximgs.com/upic/2019/04/20/20/BMjAxOTA0MjAyMDQ5MjJfMTE2NDA4NzY1OF8xMjM2ODM3MzYwOF8xXzM=_b_Bec686db5b4983527b45ca7fe3a904d74.mp4',NULL,'#感谢快手我要上热门##快手音乐人#',NULL),(56,1592315333921,'http://alimov2.a.yximgs.com/upic/2019/04/25/16/BMjAxOTA0MjUxNjM0NTZfMzIxMjIwMzc5XzEyNDk2NDY2MDM3XzFfMw==_b_B174f8c3eafc04c65a4e111c937e7d132.mp4',NULL,'#樱花舞 你还是点进来了，既然都进来了能不能给个双击',NULL),(57,1592315333928,'http://jsmov2.a.yximgs.com/upic/2019/05/21/08/BMjAxOTA1MjEwODQ0NDlfNjA2MDkxOTc2XzEzMjY5NTU2MzQxXzJfMw==_b_Bba9b153a86b203b5cdd8c20ee4b8c7c4.mp4',NULL,'喜欢典韦的帅哥美女双击加关注。这波看见典韦的伤害了吗。一个站撸三个！键盘侠这皮肤手感是真好！\n正在直播中…三排带你飞\n#王者荣耀 #热门',NULL),(58,1592315333978,'http://tx2.a.yximgs.com/upic/2019/01/24/20/BMjAxOTAxMjQyMDE2NDVfNTY1MzE5ODU4XzEwMTM5NDI3NzM4XzJfMw==_b_Bf289945d8fac1d466f6a3d8400e69da6.mp4',NULL,'...',NULL),(59,1592726567492,'http://tx2.a.yximgs.com/upic/2018/09/23/15/BMjAxODA5MjMxNTEwMjlfMjkzNjM4NzFfODE1MjM2MzIyNV8yXzM=_b_Ba7151a758d522c03bd338f4a5fc89d3e.mp4',NULL,'钟馗是个好演员，支持梦老师点双击！',NULL),(60,1592726567508,'http://txmov2.a.yximgs.com/upic/2019/05/03/07/BMjAxOTA1MDMwNzE2MDlfMTI2NDc4NTM4MV8xMjcxOTAxNDkxMV8yXzM=_b_B90276be325bde19c302d179090986e9d.mp4',NULL,'...',NULL),(61,1592726567538,'http://hwmov.a.yximgs.com/upic/2019/06/26/22/BMjAxOTA2MjYyMjA3MjBfNDA1NTc3NjM0XzE0NDkxNzAxODU0XzJfMw==_b_Bee0d6dca2656b437520f53eca629c6f2.mp4',NULL,'日历旋转制作不易关注一下点点红❤',NULL),(62,1592726567545,'http://tx2.a.yximgs.com/upic/2019/01/22/20/BMjAxOTAxMjIyMDAyMTBfNjMzMjgyOTgxXzEwMDkxMjkxMjg4XzJfMw==_b_B4f5e10cd737d106572e14cd95fa1e9e0.mp4',NULL,'...',NULL),(63,1592726567552,'http://tx2.a.yximgs.com/upic/2019/03/05/09/BMjAxOTAzMDUwOTU0MDZfMTIxNjAzNzUyM18xMTE4MjIyNjU2N18xXzM=_b_B00d07d47efacc8f8b18e6cfe4fe1e204.mp4',NULL,'新号播放量都到300到500才正常，如果发一周作品还不到300那你就要检查一下你的账号有没有违规了\n1⃣️看别人作品点赞一下就去看下一个了，这样肯定不行，你要看完，提高你的完播率，这样才会不被认为是刷\n2⃣️多去评论别人的作品，只有这样别人才会给你回评论\n3⃣️正常养号一周还没有热门，那你就要去看看自己的账号正不正常了#爱官方爱热门 #我要上热门 #爱官方爱热门 #我要上热门 #爱官方爱热门',NULL),(64,1592726567558,'http://alimov2.a.yximgs.com/upic/2019/03/23/13/BMjAxOTAzMjMxMzU1NDVfNzgyNzcxNTQwXzExNjEwMDc1MDU3XzFfMw==_b_Bc467cd86036e3cb19c66cd2f85631244.mp4',NULL,'三室两卫一厅一厨 收纳整的挺好',NULL),(65,1592726609718,'http://jsmov2.a.yximgs.com/upic/2018/09/13/18/BMjAxODA5MTMxODI3NTRfODAzMTgwODIzXzgwMTU0NTE0NTFfMV8z_b_Bacbc6e6b380b17b8bba39861b71411df.mp4',NULL,'送给七哥的生日礼物，他好像不是特别喜欢，???',NULL),(66,1592726609726,'http://tx2.a.yximgs.com/upic/2018/10/09/18/BMjAxODEwMDkxODQ1NDhfNTA5NDkwMDc3Xzg0MDAyMjcwNzlfMV8z_b_Bac17a950568ab3866b9bfefb5328d17f.mp4',NULL,'昨天的拜佛兄弟们学会了么？今天来试试哈登无解后撤步加上拜佛！强无敌的组合技能！都给我点赞！！\n多多重复，百炼成钢，你就是下一个野球帝?',NULL),(67,1592726609732,'http://jsmov2.a.yximgs.com/upic/2019/06/17/18/BMjAxOTA2MTcxODI4MThfODAxNzQ3MjdfMTQxNzY1ODE1OTBfMV8z_b_B82004a1ea9b00c11219bad39063db0b4.mp4',NULL,'...',NULL),(68,1592726645507,'http://alimov2.a.yximgs.com/upic/2018/05/29/14/BMjAxODA1MjkxNDQ1MjdfNTAzMjAwODdfNjQ2ODY1MjA5NV8xXzM=_hd3_Ba8026f0cf7464779d9f7937f5afa75f4.mp4',NULL,'59拉300水冷全套换赛道版传动',NULL),(69,1592726645516,'http://tx2.a.yximgs.com/upic/2018/10/26/10/BMjAxODEwMjYxMDIxMzNfOTU5NjU5MzU5Xzg2MjQ1NTE0NjBfMV8z_b_Bd414a56b99d22aea67a8bf011af7a1c9.mp4',NULL,'皮皮的宝宝又回来了? @帅大斌团队、小文? @殷小硕【反串演绎】',NULL),(70,1592726645522,'http://msmov.a.yximgs.com/upic/2019/06/24/15/BMjAxOTA2MjQxNTU5MTJfNTQyNzQyNDI5XzE0NDEzMTc1MjgxXzFfMw==_b_Bf51f64fad1091704887c3a0224fd9dd4.mp4',NULL,'...',NULL),(71,1592726882189,'http://txmov2.a.yximgs.com/upic/2018/07/08/07/BMjAxODA3MDgwNzQwMDlfODI5MTg5NTY2XzcwMjEwMDk4NDdfMV8z_hd3_B08e34584089688cd16aa31a1907e6f85.mp4',NULL,'哈喽！小伙伴们早上好☀️',NULL),(72,1592726882198,'http://tx2.a.yximgs.com/upic/2018/12/28/16/BMjAxODEyMjgxNjM5MTdfMTQyNzc4Mzk5Xzk1OTc5ODMyNTZfMV8z_b_B5e7ee09610551fa45ee07d782d21f7b3.mp4',NULL,'@七公子o(O365753367)你咋不问我车牌号是几呢我丢\n\n\n师父 @调皮的小飞哥⚜️(O6057494)',NULL),(73,1592726882209,'http://alimov2.a.yximgs.com/upic/2019/04/10/09/BMjAxOTA0MTAwOTUwNDdfMTQ2MDM5MDQxXzEyMDg1OTkwMTAwXzJfMw==_b_B42e086140c1ae3770577d60baeb980a4.mp4',NULL,'感谢官方，感谢老铁支持，这套锅全石英石台面，下午6点看效果',NULL),(74,1592726882219,'http://tx2.a.yximgs.com/upic/2019/02/10/21/BMjAxOTAyMTAyMTE4MzlfNjE4NDcxMjJfMTA2NDg0NTYxNzVfMV8z_b_B6027e91f6f604c9db97007865e6451db.mp4',NULL,'菠萝和桃子?',NULL),(75,1592726882225,'http://txmov2.a.yximgs.com/upic/2019/03/15/16/BMjAxOTAzMTUxNjAwMzVfMzYzNjkyNDUxXzExNDEzNzU2NzI2XzJfMw==_b_B423647b3a9828575e76f3ced4eb4cd25.mp4',NULL,'这是二哥的看家本领！但闭眼浇面是要烫手的，面好帅气！????',NULL),(76,1592726882233,'http://alimov2.a.yximgs.com/upic/2019/03/18/14/BMjAxOTAzMTgxNDUyMjVfMTE0MDE5MjczXzExNDk0OTI2MTY2XzJfMw==_b_B3ee895b2242f82e2f4597e463b48a4a2.mp4',NULL,'感谢点❤的朋友。我是一个传统手艺人，从业十四年！',NULL),(77,1592726884230,'http://tx2.a.yximgs.com/upic/2018/10/02/13/BMjAxODEwMDIxMzU0MTFfMTE1NDMzNjY0XzgyODExNjM5MzlfMV8z_b_B30483efdb2e05e03fec237f1f320064b.mp4',NULL,'...',NULL),(78,1592726884238,'http://alimov2.a.yximgs.com/upic/2018/11/20/18/BMjAxODExMjAxODU5MjRfNTg1OTU3NDBfOTAwNDA3MTA5MV8yXzM=_b_Bb46673139655ddbe81030bb1b838068e.mp4',NULL,'...',NULL),(79,1592726884247,'http://alimov2.a.yximgs.com/upic/2019/04/24/13/BMjAxOTA0MjQxMzAxMDlfMjI3ODQwMjcwXzEyNDY4OTU5MDY0XzFfMw==_b_B1985a91b1c5503142c85db7698e31815.mp4',NULL,'666666',NULL),(80,1592726884254,'http://bdmov.a.yximgs.com/upic/2019/09/08/18/BMjAxOTA5MDgxODAyMTBfNjExOTQyODFfMTcyNTk2MjgyMTdfMV8z_b_Bf4be9d36a49675bdf45d932363de4bf6.mp4',NULL,'你们能@十万粉丝的萌宠主播过来，我倒立吃饭?#萌宠 #Vlog',NULL),(81,1592837091430,'http://bdmov.a.yximgs.com/upic/2019/04/13/13/BMjAxOTA0MTMxMzM2NTBfMTEyMjA2Nzc1MV8xMjE2MzgyMTk2MF8xXzM=_b_B53e143c002792b64ce7296e04e43a665.mp4',NULL,'...',NULL),(82,1592837091462,'http://msmov.a.yximgs.com/upic/2019/07/11/14/BMjAxOTA3MTExNDM1MjJfMTE0MTA4NDk4OV8xNTA0ODA5OTI2N18yXzM=_b_B615a466cf96c2e64d07da8e95cf793f5.mp4',NULL,'谢谢你们给我的支持与动力 我都看在眼里 一直记在心里 遇见你们是我最大的幸运。\n\n我会一直努力，给予你们阳光！\n\n我会努力变强做到更好，会让你们觉得关注我是最好的 是不错的。\n谢谢你们，大恩铭记在心中❤\n#我要上热门##三岁杨的故事# #三岁杨# #诸葛亮#',NULL),(83,1592837110655,'http://txmov2.a.yximgs.com/upic/2018/11/04/09/BMjAxODExMDQwOTM1MzhfNTk1MTEwNTI2Xzg3NjAzOTA3NzhfMV8z_b_B9a8d3ce9012dadcf92d401657140ddce.mp4',NULL,'...',NULL),(84,1592837110660,'http://jsmov2.a.yximgs.com/upic/2019/05/25/13/BMjAxOTA1MjUxMzM3MThfMTExOTQ0OTM5Nl8xMzM5Mjg0NzYxMF8xXzM=_b_B8c93f20f54b4194ab890436905d55b48.mp4',NULL,'...',NULL),(85,1592837110666,'http://alimov2.a.yximgs.com/upic/2019/07/07/19/BMjAxOTA3MDcxOTQ0NDhfNzM0MjMyODZfMTQ5MDQ2NDUxMjFfMV8z_b_B16ec272ea631ec86ae55df7990348dbf.mp4',NULL,'挤出来的视频～',NULL),(86,1592837110673,'http://msmov.a.yximgs.com/upic/2019/03/26/19/BMjAxOTAzMjYxOTM3NTVfMzU3OTUzNzkxXzExNjk4NzU2MjcwXzFfMw==_b_B222a7be02fd9ee2410a885e1c9ea7d0c.mp4',NULL,'春夏秋冬失去了你，我怎么过一年四季。\n#爱情',NULL),(87,1592837202800,'http://jsmov2.a.yximgs.com/upic/2019/06/29/21/BMjAxOTA2MjkyMTE2NTdfNTEzODU2NTJfMTQ2MDAzNDQ1OTFfMV8z_b_Bfa9d34bacc6c11f14632951933c70396.mp4',NULL,'九妹九妹~漂亮的妹妹，这歌太魔性了，最近这歌太火了。欢迎大家带上标签#最火九妹#，和我一起来挑战哈。同框、原声、手势舞拍起来！（谁拍这个谁上热门）',NULL),(88,1592837202810,'http://txmov2.a.yximgs.com/upic/2019/07/05/18/BMjAxOTA3MDUxODMwNTBfMTQxMjAzMzM4XzE0ODE3MjE3ODk3XzFfMw==_b_B4286e6ce7bde2dbdf69dead16ddac0e7.mp4',NULL,'#感谢快手官大大送上热门  @快手小管家(O40300028)',NULL),(89,1593059825772,'http://txmov2.a.yximgs.com/upic/2018/05/28/08/BMjAxODA1MjgwODM4NTFfNDIyNzM4ODYzXzY0NTQ1MDE4NTFfMl8z_hd3_Bd8c6aed77c857757ce1bce5c9625add2.mp4',NULL,'毛晓莉：?️\n\n双击  留名：加急看主页',NULL),(90,1593059825813,'http://txmov2.a.yximgs.com/upic/2018/07/18/18/BMjAxODA3MTgxODAxMDBfMTgwNTU1NTY4XzcxODQzODY4MDFfMV8z_hd3_Bbff2f69c4dfa0372f0f7bd9f8bb60570.mp4',NULL,'老铁们帮我双击屏幕点个关注吧！\n\n团长： @疯狂?武大郎【情感剧】\n\n拍摄： @郎家?摄影 痦子哥吖\n\n助演： @郎家?莉宝宝',NULL),(91,1593059825819,'http://txmov2.a.yximgs.com/upic/2019/05/10/11/BMjAxOTA1MTAxMTA4MjBfNzMwMTgxMDUyXzEyOTIyODE2ODc2XzFfMw==_b_B2d98da7bc4836552ba7fe937b404e027.mp4',NULL,'#官方大大我要热门 #网络热歌分享',NULL),(92,1593059848392,'http://alimov2.a.yximgs.com/upic/2018/07/09/15/BMjAxODA3MDkxNTM0MjVfMTYyOTQ5NjUwXzcwNDM3NTkwODdfMV8z_hd3_Bfb812cde7011204d5737de9e3fe3fb49.mp4',NULL,'',NULL),(93,1593059848400,'http://tx2.a.yximgs.com/upic/2018/09/30/18/BMjAxODA5MzAxODQ2NDJfNjU4NTUzNjE2XzgyNDg5MTQ2NTlfMl8z_b_B456fa694c70a23731e59aaf72b005a48.mp4',NULL,'用心拍每一个作品，喜欢别忘了给个双击\n\n\n 女主: @刘晓（马大有团队） \n\n女二: @李然（马大有团队） \n\n\n\n感谢你们一路的支持',NULL),(94,1593059848421,'http://alimov2.a.yximgs.com/upic/2019/06/27/17/BMjAxOTA2MjcxNzIwMDhfNDI4MzM3MTIxXzE0NTEzNzc5MjIzXzJfMw==_b_B1023e091396c5357ff549226a8a0610d.mp4',NULL,'吓坏了都，',NULL),(95,1593059970657,'http://tx2.a.yximgs.com/upic/2019/02/14/18/BMjAxOTAyMTQxODQzMjFfNDU5OTM2ODg4XzEwNzUwMjA3Mzc3XzJfMw==_b_B935305b567d9c62edae83e4d54bd3076.mp4',NULL,'毛毛意思自己最漂亮！！喜欢狗狗的给老弟一个关注呗，你们的关注我会更加努力！！！！！',NULL);
/*!40000 ALTER TABLE `video_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 23:16:21