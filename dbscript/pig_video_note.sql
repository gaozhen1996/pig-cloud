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
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `note` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint(11) NOT NULL COMMENT '用户id',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `updateTime` date DEFAULT NULL COMMENT '创建时间',
  `type` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT 'note' COMMENT '类型',
  `title` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `fromid` bigint(11) DEFAULT NULL COMMENT '所属目录的id',
  `content` text CHARACTER SET utf8 NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='笔记表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (1,1,'2020-01-03','2020-06-16','note','常用链接',0,'<p>1.左耳耗子</p><p><a href=\"https://coolshell.cn/\" target=\"_blank\">https://coolshell.cn/</a></p><p>2.idea激活码</p><p><a href=\"http://idea.medeming.com/jet/\" target=\"_blank\">http://idea.medeming.com/jet/</a></p><p><a href=\"http://idea.medeming.com/jihuoma/\" target=\"_blank\">http://idea.medeming.com/jihuoma/</a></p><p>3.spring官方文档</p><p><a href=\"https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html\" target=\"_blank\">https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html</a></p><p>4.知乎-如何系统的学习java</p><p><a href=\"https://www.zhihu.com/question/311758187/answer/1043059927\" target=\"_blank\">https://www.zhihu.com/question/311758187/answer/1043059927</a></p><p>5.iview后台模板</p><p><a href=\"https://github.com/iview/iview-admin\" target=\"_blank\">https://github.com/iview/iview-admin</a></p><p>6.dubbo</p><p><a href=\"https://github.com/bz51/SpringBoot-Dubbo-Docker-Jenkins\" target=\"_blank\">https://github.com/bz51/SpringBoot-Dubbo-Docker-Jenkins</a></p><p>7.有哪些你看了以后大呼过瘾的编程书？ - 知乎</p><p><a href=\"https://www.zhihu.com/question/50408698/answer/1154160248\" target=\"_blank\">https://www.zhihu.com/question/50408698/answer/1154160248</a></p><p>8.16000 字 Redis 面试知识点总结，建议收藏！</p><p><a href=\"https://zhuanlan.zhihu.com/p/134104400\" target=\"_blank\">https://zhuanlan.zhihu.com/p/134104400</a></p><p>9.研发中心下载链接</p><p><a href=\"http://rdc.hundsun.com/product/download/index.htm\" target=\"_blank\">http://rdc.hundsun.com/product/download/index.htm</a></p><p><br></p>'),(2,1,'2020-01-10','2020-05-27','note','测试代码',0,'<p><br></p><p>public static void main(String[] args) throws IOException {</p><p>//创建服务器，指定端口 ServerSocket(int port)</p><p>ServerSocket serverSocket = new ServerSocket(16066);</p><p>//接收客户端连接，阻塞式</p><p>Socket client = serverSocket.accept();</p><p>OutputStream out = client.getOutputStream();</p><p>BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));</p><p>DataInputStream dis = new DataInputStream(client.getInputStream());</p><p>DataOutputStream dos = new DataOutputStream(out);</p><p>String inputMsg = \"\";</p><p>String outputMsg = \"\";</p><p>String u1 = \"https://www.ebay.com/usr/ke-6383\";</p><p>videos/67859/91-1080p65</p><p>String u2 = “www.xiaobi014.com/videos/42986/mr-m-s-week-off-part-3-1/”</p><p>System.out.println(\"一个客户端建立连接\");</p><p>//发送数据</p><p>String msg = \"欢迎连接\";</p><p>while(true) {</p><p>//inputMsg = in.readLine();</p><p>inputMsg&nbsp;= dis.readUTF();</p><p>System.out.println(inputMsg);</p><p>dos.writeUTF(\"服务器--&gt;\" + inputMsg.toUpperCase());</p><p>dos.flush();</p><p>}</p>'),(3,1,'2020-02-03','2020-07-01','note','常用命令-数据库等',0,'<p>--查询</p><p>select Host,User from mysql.user;</p><p>--删除</p><p>delete from mysql.user&nbsp;where Host = \'112.10.74.80\';</p><p>--添加</p><p>GRANT ALL PRIVILEGES ON *.* TO \'root\'@\'112.10.75.46\' IDENTIFIED BY \'root\';</p><p>--刷新</p><p>flush privileges;</p><p><br></p><p><br></p><p>地址栏输入：<span style=\"color: rgb(51, 51, 51);\">chrome://flags/#extensions-toolbar-menu</span></p><p>启动扩展程序即可</p>'),(4,2,'2020-05-02',NULL,'note','新建文件',0,'<p>test</p>'),(6,1,'2020-07-01','2020-07-01','note','工作常用模板',0,'<p>【0.如果是缺陷类需求复现步骤】</p><p>【1.自测结果】</p><p>自测场景分析：</p><p>1.需要测试正确的读取附件中文件</p><p>自测结果：</p><p>1：设置好接收路径</p><p>2：可以正确读取接口文件</p><p>【3.影响范围】日终清算</p><p>【4.测试建议】可以使用文件测试</p><p><br></p><p><br></p><p><br></p><p>----------------------------------------------------------------------------------------------------------------------------------------</p><p>---------------------------------------------------- 注册表：</p><p>----------------------------------------------------------------------------------------------------------------------------------------</p><p>计算机\\HKEY_CURRENT_USER\\Software\\Scooter Software\\Beyond Compare 4</p><p><br></p><p>----------------------------------------------------------------------------------------------------------------------------------------</p><p>---------------------------------------------------- oralce：</p><p>----------------------------------------------------------------------------------------------------------------------------------------</p><p>startup pfile=\'F:\\app\\hspcadmin\\admin\\orcl\\pfile\\init.ora.610201918365\'</p><p>shutdown immediate</p><p>startup nomount</p><p><br></p><p><br></p><p>----------------------------------------------------------------------------------------------------------------------------------------</p><p>---------------------------------------------------- 插件路径：</p><p>----------------------------------------------------------------------------------------------------------------------------------------</p><p>C:\\Users\\hspcadmin\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\nnnkddnnlpamobajfibfdgfnbcnkgngh\\9.4.62_0\\static\\js</p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p>');
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01 23:16:19
