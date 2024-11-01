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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` int NOT NULL,
  `km_driven` int DEFAULT NULL,
  `mileage` int DEFAULT NULL,
  `no_of_owners` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fuel_type` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `reg_id` varchar(255) DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,100000,22,2,2016,'Hyundai','white','car','diesel','Verna','PB10AU1234','manual'),(2,150000,17,2,2006,'Honda','silver','well maintained car','petrol','City','PB15W5870','manual'),(52,20000,18,1,2021,'toyota','white','well maintained car, white in color','diesel','innova','PB10AU1234','automatic'),(202,90000,22,2,2015,'suzuki','white','car is well maintained','petrol','swift','PB15AU1234','manual'),(253,20000,22,1,2022,'Tata','red','well maintained car, red color ','petrol','Altroz','PB10AU1234','manual'),(254,21000,25,1,2015,'Tata','red','well maintained car, red in color','petrol','Altroz','PB10AU1234','manual'),(302,20000,24,1,2015,'Tata','manual','white color tata altroz','petrol','Altroz','PB10AU1234','automatic'),(354,20000,19,1,2023,'Nissan','manual','The Magnite, in its new avatar, gets several exterior updates.','petrol','Magnite','PB15AU1234','manual'),(355,49998,15,1,2020,'Audi','black',' It comes standard with all-wheel drive and many top-notch tech features','diesel','Q3','PB15W5870','automatic');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-08 14:41:07
