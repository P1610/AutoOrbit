-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: carventure
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `asking_price` int DEFAULT NULL,
  `car_id` int DEFAULT NULL,
  `date_of_application` date DEFAULT NULL,
  `date_of_purchase` date DEFAULT NULL,
  `final_offer` int DEFAULT NULL,
  `id` int NOT NULL,
  `initial_offer` int DEFAULT NULL,
  `inventory_price` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `rejection_reason` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4duy1epkxyw27019bcj76rhb5` (`car_id`),
  KEY `FKldca8xj6lqb3rsqawrowmkqbg` (`user_id`),
  CONSTRAINT `FKldca8xj6lqb3rsqawrowmkqbg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKst8xgdau7igvp6og3ure9vwru` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (700000,1,'2024-09-26','2024-09-26',650000,1,600000,780000,1,NULL,'Completed'),(150000,2,'2024-09-27','2024-09-27',140000,2,130000,161000,2,NULL,'Completed'),(2000000,52,'2024-10-01','2024-10-01',1900000,52,1800000,2185000,1,NULL,'Completed'),(300000,202,'2024-10-02','2024-10-07',250000,102,230000,287500,1,NULL,'Completed'),(599998,253,'2024-10-04',NULL,NULL,152,NULL,NULL,152,NULL,'Pending'),(600000,254,'2024-10-04','2024-10-04',580000,153,550000,696000,152,NULL,'Completed'),(600000,302,'2024-10-05',NULL,NULL,202,NULL,NULL,1,NULL,'Pending'),(700000,354,'2024-10-07','2024-10-07',650000,252,620000,747500,109,NULL,'Completed'),(5000000,355,'2024-10-07','2024-10-07',4700000,253,4500000,5170000,109,NULL,'Completed');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-08 14:41:05
