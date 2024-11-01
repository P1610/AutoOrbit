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
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `asking_price` int DEFAULT NULL,
  `bought_price` int DEFAULT NULL,
  `car_id` int DEFAULT NULL,
  `date_of_purchase` date DEFAULT NULL,
  `id` int NOT NULL,
  `is_sold` bit(1) DEFAULT NULL,
  `transaction_id` int DEFAULT NULL,
  `seller_email` varchar(255) DEFAULT NULL,
  `seller_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlclth1scfk238ruyh43125m8m` (`car_id`),
  UNIQUE KEY `UKapkjqp8pa1alsovp7yr8hq85l` (`transaction_id`),
  CONSTRAINT `FKr5xjqai9h0aw973xcnxj3qrq2` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`),
  CONSTRAINT `FKt83q3jv7eykxauq1iiwrnmmq0` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (780000,650000,1,'2024-09-26',1,_binary '',1,'dv100811@gmail.com','Deepak kumar'),(160000,140000,2,'2024-09-27',2,_binary '',52,'sengaransh094@gmail.com','Ansh Sengar'),(2185000,1900000,52,'2024-10-01',52,_binary '',2,'dv100811@gmail.com','Deepak kumar'),(696000,580000,254,'2024-10-04',102,_binary '\0',NULL,'borninkal@gmail.com','atithi'),(287500,250000,202,'2024-10-07',152,_binary '\0',NULL,'dv100811@gmail.com','Deepak kumar'),(747500,650000,354,'2024-10-07',153,_binary '\0',NULL,'farziydv@gmail.com','anmol'),(5100000,4700000,355,'2024-10-07',154,_binary '\0',NULL,'farziydv@gmail.com','anmol');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-08 14:41:04
