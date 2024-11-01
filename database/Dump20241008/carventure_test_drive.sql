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
-- Table structure for table `test_drive`
--

DROP TABLE IF EXISTS `test_drive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_drive` (
  `car_id` int DEFAULT NULL,
  `id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time_slot` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKowg6tyy64wwasesob9ag2ayn3` (`car_id`),
  KEY `FK96ptht00m8vlbw1vk07hrvkdp` (`user_id`),
  CONSTRAINT `FK96ptht00m8vlbw1vk07hrvkdp` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKowg6tyy64wwasesob9ag2ayn3` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_drive`
--

LOCK TABLES `test_drive` WRITE;
/*!40000 ALTER TABLE `test_drive` DISABLE KEYS */;
INSERT INTO `test_drive` VALUES (1,1,2,'2024-09-27','Completed','02:00 PM - 03:00 PM'),(2,2,1,'2024-09-28','Completed','11:00 AM - 12:00 PM'),(2,3,1,'2024-09-28','Completed','01:00 PM - 02:00 PM'),(2,4,1,'2024-09-28','Completed','02:00 PM - 03:00 PM'),(2,5,1,'2024-09-30','Completed','02:00 PM - 03:00 PM'),(2,52,1,'2024-10-02','Scheduled','10:00 AM - 11:00 AM'),(2,102,152,'2024-10-08','Completed','11:00 AM - 12:00 PM'),(254,152,1,'2024-10-15','Scheduled','01:00 PM - 02:00 PM'),(254,153,2,'2024-10-08','Scheduled','12:00 PM - 01:00 PM'),(355,202,203,'2024-10-10','Scheduled','11:00 AM - 12:00 PM');
/*!40000 ALTER TABLE `test_drive` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-08 14:41:06
