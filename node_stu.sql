-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: node
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `carrier` char(50) NOT NULL,
  `tamano` char(50) NOT NULL,
  `delivery_type` char(50) NOT NULL,
  `service_type` char(50) NOT NULL,
  `customer_destination` char(50) NOT NULL,
  `creation_date` date DEFAULT NULL,
  `promise_date` date DEFAULT NULL,
  `delivery_status` char(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu` DISABLE KEYS */;
INSERT INTO `stu` VALUES (1,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(2,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(3,'DEDICATED','BIG','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(4,'DEDICATED','BIG','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(5,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(6,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(7,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(8,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(9,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(10,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(11,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(12,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(13,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(14,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(15,'DEDICATED','BIG','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(16,'DEDICATED','BIG','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(17,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(18,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(19,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(20,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(21,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(22,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(23,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'NON DELAYED'),(24,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','LA SERENA',NULL,NULL,'DELAYED'),(25,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LAS CONDES',NULL,NULL,'NON DELAYED'),(26,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LAS CONDES',NULL,NULL,'NON DELAYED'),(27,'DEDICATED','BIG','HOME DELIVERY','ALL DAY','MAIPU',NULL,NULL,'DELAYED'),(28,'3PL','BIG','HOME DELIVERY','ALL DAY','MAIPU',NULL,NULL,'DELAYED'),(29,'3PL','MINI','HOME DELIVERY','ALL DAY','SANTIAGO',NULL,NULL,'NON DELAYED'),(30,'3PL','MINI','HOME DELIVERY','ALL DAY','SANTIAGO',NULL,NULL,'NON DELAYED'),(31,'COLABORATIVE','MINI','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'DELAYED'),(32,'COLABORATIVE','MINI','HOME DELIVERY','ALL DAY','???U???OA',NULL,NULL,'DELAYED'),(33,'COLABORATIVE','BIG','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'NON DELAYED'),(34,'3PL','BIG','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'NON DELAYED'),(35,'3PL','MINI','HOME DELIVERY','ALL DAY','???U???OA',NULL,NULL,'DELAYED'),(36,'3PL','MINI','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'NON DELAYED'),(37,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'NON DELAYED'),(38,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'NON DELAYED'),(39,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'DELAYED'),(40,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'DELAYED'),(41,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'NON DELAYED'),(42,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'NON DELAYED'),(43,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'DELAYED'),(44,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'NON DELAYED'),(45,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'DELAYED'),(46,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'DELAYED'),(47,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PLAZA VESPUCIO',NULL,NULL,'NON DELAYED'),(48,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PLAZA VESPUCIO',NULL,NULL,'DELAYED'),(49,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LAS CONDES',NULL,NULL,'NON DELAYED'),(50,'DEDICATED','MINI','HOME DELIVERY','ALL DAY','LAS CONDES',NULL,NULL,'NON DELAYED'),(51,'DEDICATED','BIG','HOME DELIVERY','ALL DAY','MAIPU',NULL,NULL,'NON DELAYED'),(52,'3PL','BIG','HOME DELIVERY','ALL DAY','MAIPU',NULL,NULL,'NON DELAYED'),(53,'3PL','MINI','HOME DELIVERY','ALL DAY','SANTIAGO',NULL,NULL,'DELAYED'),(54,'3PL','MINI','HOME DELIVERY','ALL DAY','SANTIAGO',NULL,NULL,'DELAYED'),(55,'COLABORATIVE','MINI','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'DELAYED'),(56,'COLABORATIVE','MINI','HOME DELIVERY','ALL DAY','???U???OA',NULL,NULL,'NON DELAYED'),(57,'COLABORATIVE','BIG','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'NON DELAYED'),(58,'3PL','BIG','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'NON DELAYED'),(59,'3PL','MINI','HOME DELIVERY','ALL DAY','???U???OA',NULL,NULL,'DELAYED'),(60,'3PL','MINI','HOME DELIVERY','ALL DAY','PROVIDENCIA',NULL,NULL,'DELAYED'),(61,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'NON DELAYED'),(62,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'NON DELAYED'),(63,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'DELAYED'),(64,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'NON DELAYED'),(65,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','ALTO LAS CONDES',NULL,NULL,'NON DELAYED'),(66,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'NON DELAYED'),(67,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'NON DELAYED'),(68,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'NON DELAYED'),(69,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'DELAYED'),(70,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PARQUE ARAUCO',NULL,NULL,'DELAYED'),(71,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PLAZA VESPUCIO',NULL,NULL,'NON DELAYED'),(72,'DEDICATED','MINI','COLLECT IN STORE','ALL DAY','PLAZA VESPUCIO',NULL,NULL,'NON DELAYED');
/*!40000 ALTER TABLE `stu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18 13:25:35
