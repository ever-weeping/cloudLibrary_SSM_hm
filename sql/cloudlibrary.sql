-- MySQL dump 10.13  Distrib 9.6.0, for macos14.8 (x86_64)
--
-- Host: localhost    Database: cloudlibrary
-- ------------------------------------------------------
-- Server version	9.6.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(32) DEFAULT NULL COMMENT '图书名称',
  `book_isbn` varchar(32) DEFAULT NULL COMMENT '图书标准 ISBN',
  `book_press` varchar(32) DEFAULT NULL COMMENT '图书出版社',
  `book_author` varchar(32) DEFAULT NULL COMMENT '图书作者',
  `book_pagination` int DEFAULT NULL COMMENT '图书页数',
  `book_price` double DEFAULT NULL COMMENT '图书价格',
  `book_uploadtime` varchar(32) DEFAULT NULL COMMENT '图书上架时间',
  `book_status` varchar(1) DEFAULT NULL COMMENT '图书状态（0: 可借阅, 1:借阅中, 2: 归还中, 3: 已下架）',
  `book_borrower` varchar(32) DEFAULT NULL COMMENT '图书借阅人',
  `book_borrowtime` varchar(32) DEFAULT NULL COMMENT '图书借阅时间',
  `book_returntime` varchar(32) DEFAULT NULL COMMENT '图书预计归还时间',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='图书信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Java编程思想','9787111213826','机械工业出版社','Bruce Eckel',880,108,'2026-01-10 10:00:00','3','','',''),(2,'算法图解','9787115451248','人民邮电出版社','Aditya Bhargava',200,49,'2026-01-12 09:30:00','0',NULL,NULL,NULL),(3,'深入理解Java虚拟机','9787111641247','机械工业出版社','周志明',552,129,'2026-01-15 14:20:00','0','','',''),(4,'高性能MySQL','9787121198854','电子工业出版社','Baron Schwartz',800,128,'2026-01-18 11:00:00','0',NULL,NULL,NULL),(5,'重构：改善既有代码的设计','9787115369390','人民邮电出版社','Martin Fowler',448,79,'2026-01-20 16:45:00','0','','',''),(6,'人类简史','9787508647357','中信出版社','尤瓦尔·赫拉利',440,68,'2026-01-22 10:30:00','0',NULL,NULL,NULL),(7,'三体全集','9787536692930','重庆出版社','刘慈欣',900,198,'2026-01-25 09:00:00','0','','',''),(8,'活着','9787506365437','作家出版社','余华',191,28,'2026-01-28 15:10:00','0',NULL,NULL,NULL),(9,'计算机网络：自顶向下方法','9787111599364','机械工业出版社','James Kurose',560,99,'2026-02-01 13:00:00','2','黑马程序员','2026-03-09','2026-03-09'),(10,'代码整洁之道','9787115213907','人民邮电出版社','Robert C. Martin',304,59,'2026-02-03 11:20:00','0',NULL,NULL,NULL),(11,'百年孤独','9787544253994','南海出版公司','加西亚·马尔克斯',360,55,'2026-02-05 17:00:00','0','','',''),(12,'明朝那些事儿','9787513300711','新星出版社','当年明月',2400,358,'2026-02-08 08:30:00','0',NULL,NULL,NULL),(13,'围城','9787101000108','人民文学出版社','钱钟书',359,39,'2026-02-10 14:00:00','0',NULL,NULL,NULL),(14,'自卑与超越','9787505737110','中国华侨出版社','阿德勒',248,32,'2026-02-12 10:00:00','0',NULL,NULL,NULL),(15,'软技能：代码之外的生存指南','9787115426178','人民邮电出版社','John Sonmez',364,69,'2026-02-15 09:45:00','0',NULL,NULL,NULL),(16,'非暴力沟通','9787508061610','华夏出版社','马歇尔·卢森堡',198,45,'2026-02-18 16:00:00','0',NULL,NULL,NULL),(17,'追风筝的人','9787208061644','上海人民出版社','卡勒德·胡赛尼',362,35,'2026-02-20 11:30:00','0',NULL,NULL,NULL),(18,'Effective Java 中文版','9787111612728','机械工业出版社','Joshua Bloch',312,119,'2026-02-22 15:00:00','0',NULL,NULL,NULL),(19,'白夜行','9787544258609','南海出版公司','东野圭吾',538,59.5,'2026-02-25 10:20:00','2','赵六','2026-03-07 09:00:00','2026-03-21 09:00:00'),(20,'Python基础教程','9787115479525','人民邮电出版社','Magnus Lie Hetland',488,79,'2026-02-28 14:00:00','2','马海','2026-03-08','2026-03-08'),(21,'深入理解计算机系统','9787111544937','机械工业出版社','Randal E. Bryant',737,139,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(22,'Java编程思想(第4版)','9787111213826','机械工业出版社','Bruce Eckel',864,108,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(23,'Effective Java(第3版)','9787111612728','机械工业出版社','Joshua Bloch',404,119,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(24,'Spring实战(第5版)','9787115531421','人民邮电出版社','Craig Walls',520,109,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(25,'高性能MySQL','9787121198854','电子工业出版社','Baron Schwartz',796,128,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(26,'算法导论(第3版)','9787111407010','机械工业出版社','Thomas H. Cormen',780,128,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(27,'代码整洁之道','9787115216878','人民邮电出版社','Robert C. Martin',432,79,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(28,'重构:改善既有代码的设计','9787115509970','人民邮电出版社','Martin Fowler',448,168,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(29,'三体(全三册)','9787536692930','重庆出版社','刘慈欣',893,93,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(30,'活着','9787506365437','作家出版社','余华',191,28,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(31,'百年孤独','9787544253994','南海出版公司','加西亚·马尔克斯',360,39.5,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(32,'人类简史','9787508647357','中信出版社','尤瓦尔·赫拉利',440,68,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(33,'明朝那些事儿(增补版)','9787508678498','中信出版社','当年明月',2340,358,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(34,'乌合之众:大众心理研究','9787539981543','江苏凤凰文艺出版社','古斯塔夫·勒庞',264,32,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(35,'原则','9787508684031','中信出版社','瑞·达利欧',576,98,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(36,'穷爸爸富爸爸','9787220119851','四川人民出版社','罗伯特·清崎',328,58,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(37,'牛奶可乐经济学','9787300244243','中国人民大学出版社','罗伯特·弗兰克',348,59.9,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(38,'影响力','9787300122237','中国人民大学出版社','罗伯特·西奥迪尼',356,69.9,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(39,'思考,快与慢','9787508633558','中信出版社','丹尼尔·卡尼曼',424,69,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(40,'追风筝的人','9787208061644','上海人民出版社','卡勒德·胡赛尼',362,36,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(41,'白夜行','9787544258609','南海出版公司','东野圭吾',358,45,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(42,'解忧杂货店','9787544270878','南海出版公司','东野圭吾',291,39.5,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(43,'嫌疑人X的献身','9787544267618','南海出版公司','东野圭吾',251,35,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(44,'平凡的世界(全三部)','9787530215593','北京十月文艺出版社','路遥',1042,108,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(45,'围城','9787020024759','人民文学出版社','钱钟书',383,33,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(46,'乡土中国','9787301208032','北京大学出版社','费孝通',161,35,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(47,'万历十五年','9787101052039','中华书局','黄仁宇',315,28,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(48,'梦的解析','9787514330687','现代出版社','西格蒙德·弗洛伊德',450,49.8,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(49,'自私的基因','9787508634159','中信出版社','理查德·道金斯',388,68,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(50,'国富论','9787501579228','知识出版社','亚当·斯密',536,48,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(51,'资本论','9787010046499','人民出版社','卡尔·马克思',944,110,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(52,'毛泽东选集','9787010009227','人民出版社','毛泽东',1599,150,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(53,'史记(全四册)','9787101003048','中华书局','司马迁',3322,180,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(54,'孙子兵法','9787101054064','中华书局','孙武',188,20,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(55,'红楼梦(上下)','9787020002207','人民文学出版社','曹雪芹',1606,59.7,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(56,'西游记(上下)','9787020008735','人民文学出版社','吴承恩',1373,56.5,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(57,'三国演义(上下)','9787020008728','人民文学出版社','罗贯中',1133,47.05,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(58,'水浒传(上下)','9787020008742','人民文学出版社','施耐庵',1404,57.8,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(59,'老人与海','9787532767373','上海译文出版社','海明威',104,25,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(60,'月亮与六便士','9787533936020','浙江文艺出版社','毛姆',290,39.8,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(61,'小王子','9787020042494','人民文学出版社','安东尼·德·圣-埃克苏佩里',97,22,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(62,'窗边的小豆豆','9787544253994','南海出版公司','黑柳彻子',260,39.5,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(63,'我们仨','9787108018809','生活·读书·新知三联书店','杨绛',165,23,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(64,'看见','9787549529322','广西师范大学出版社','柴静',405,39.8,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(65,'撒哈拉的故事','9787530211144','北京十月文艺出版社','三毛',273,28,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(66,'黄金时代','9787208061644','上海人民出版社','王小波',264,36,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(67,'哈利·波特与魔法石','9787020033430','人民文学出版社','J.K.罗琳',234,32,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(68,'狂人日记','9787108006721','生活·读书·新知三联书店','鲁迅',188,25,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(69,'彷徨','9787108006738','生活·读书·新知三联书店','鲁迅',212,28,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(70,'野草','9787108006745','生活·读书·新知三联书店','鲁迅',150,22,'2026-03-08 14:06:06','0',NULL,NULL,NULL),(71,'JavaEE企业级应用','9787115568175','人民邮电出版社','黑马程序员',284,59.8,'2026-03-08','3',NULL,NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record` (
  `record_id` int NOT NULL AUTO_INCREMENT,
  `record_bookname` varchar(32) DEFAULT NULL COMMENT '借阅的图书名称',
  `record_bookisbn` varchar(32) DEFAULT NULL COMMENT '借阅的图书的 ISBN',
  `record_borrower` varchar(32) DEFAULT NULL COMMENT '图书借阅人',
  `record_borrowtime` varchar(32) DEFAULT NULL COMMENT '图书借阅时间',
  `record_remandtime` varchar(32) DEFAULT NULL COMMENT '图书归还时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='借阅记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (3,'Java编程思想','9787111213826','黑马程序员','2026-03-10','2026-03-10');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL COMMENT '用户id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `user_password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `user_email` varchar(32) DEFAULT NULL COMMENT '用户邮箱（用户账号）',
  `user_role` varchar(32) DEFAULT NULL COMMENT '用户角色（ADMIN: 管理员, USER: 普通用户）',
  `user_status` varchar(1) DEFAULT NULL COMMENT '用户状态（0: 正常, 1: 禁用）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'黑马程序员','123456','itheima@itcast.cn','ADMIN','0'),(2,'马海','123456','1609628369@qq.com','USER','0'),(3,'张三','123456','3179049834@qq.com','USER','0'),(4,'李四','123456','lingfeng62424@gmail.com','USER','0'),(5,'王五','123456','mahai666@icloud.com','USER','0'),(6,'赵六','123456','2661721282@qq.com','USER','0');
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

-- Dump completed on 2026-03-13 17:06:50
