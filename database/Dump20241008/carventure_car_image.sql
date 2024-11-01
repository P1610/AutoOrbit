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
-- Table structure for table `car_image`
--

DROP TABLE IF EXISTS `car_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_image` (
  `car_id` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  KEY `FK91nl01tvyj0xus5j92voo4ht1` (`car_id`),
  CONSTRAINT `FK91nl01tvyj0xus5j92voo4ht1` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_image`
--

LOCK TABLES `car_image` WRITE;
/*!40000 ALTER TABLE `car_image` DISABLE KEYS */;
INSERT INTO `car_image` VALUES (1,'https://imgd.aeplcdn.com/664x374/n/cw/ec/121943/verna-exterior-right-front-three-quarter-101.jpeg?isig=0&q=80'),(2,'https://imgd.aeplcdn.com/664x374/n/cw/ec/134287/city-exterior-right-front-three-quarter-77.jpeg?isig=0&q=80'),(52,'https://imgd.aeplcdn.com/664x374/n/cw/ec/140809/innova-crysta-exterior-right-front-three-quarter-2.png?isig=0&q=80'),(202,'https://imgd.aeplcdn.com/664x374/n/cw/ec/159099/swift-exterior-right-front-three-quarter.jpeg?isig=0&q=80'),(253,'https://imgd.aeplcdn.com/664x374/n/cw/ec/32597/altroz-exterior-right-front-three-quarter-80.jpeg?isig=0&q=80'),(254,'https://imgd.aeplcdn.com/664x374/n/cw/ec/32597/altroz-exterior-right-front-three-quarter-80.jpeg?isig=0&q=80'),(302,'https://imgd.aeplcdn.com/664x374/n/cw/ec/32597/altroz-exterior-right-front-three-quarter-80.jpeg?isig=0&q=80'),(354,'https://imgd.aeplcdn.com/664x374/n/cw/ec/173325/magnite-facelift-exterior-left-front-three-quarter-10.jpeg?isig=0&q=80'),(354,'https://imgd.aeplcdn.com/664x374/n/cw/ec/173325/magnite-facelift-exterior-left-front-three-quarter-4.jpeg?isig=0&q=80'),(354,'https://imgd.aeplcdn.com/664x374/n/cw/ec/173325/magnite-facelift-interior-dashboard.jpeg?isig=0&q=80'),(355,'https://imgd.aeplcdn.com/664x374/n/cw/ec/141373/q3-sportback-exterior-right-front-three-quarter-2.jpeg?isig=0&q=80'),(355,'https://imgd.aeplcdn.com/664x374/n/cw/ec/141373/q3-sportback-exterior-right-front-three-quarter-14.jpeg?isig=0&q=80');
/*!40000 ALTER TABLE `car_image` ENABLE KEYS */;
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
