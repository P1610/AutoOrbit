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
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `house_number` int DEFAULT NULL,
  `id` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
INSERT INTO `user_address` VALUES (405,1,'bangalore','560100','karnataka','doddathogur'),(405,2,'Abohar','152116','Punjab','doddathogur'),(405,3,'Abohar','152116','Punjab','doddathogur'),(405,4,'Electronics City','560100','Karnataka','doddathogur'),(405,5,'Abohar','152116','Punjab','doddathogur'),(405,6,'Electronics City','560100','Karnataka','doddathogur'),(405,7,'Electronics City','560100','Karnataka','doddathogur'),(405,8,'Electronics City','560100','Karnataka','doddathogur'),(NULL,9,'Abohar','152116','Punjab',''),(405,10,'Electronics City','560100','Karnataka','Doddathogur'),(405,52,'Abohar','152116','Punjab','Doddathogur'),(405,53,'Electronics City','560100','Karnataka','Doddathogur'),(405,54,'Abohar','152116','Punjab','Doddathogur'),(405,102,'Electronics City','560100','Karnataka','Doddathogur'),(405,103,'Abohar','152116','Punjab','Doddathogur'),(405,104,'Electronics City','560100','Karnataka','Doddathogur'),(405,105,'Abohar','152116','Punjab','Doddathogur'),(405,106,'Electronics City','560100','Karnataka','Doddathogur'),(405,107,'Abohar','152116','Punjab','Doddathogur'),(405,108,'Electronics City','560100','Karnataka','Doddathogur'),(405,109,'Abohar','152116','Punjab','Doddathogur'),(405,110,'Electronics City','560100','Karnataka','Doddathogur'),(405,111,'Abohar','152116','Punjab','Doddathogur'),(405,112,'Electronics City','560100','Karnataka','Doddathogur'),(405,113,'Abohar','152116','Punjab','Doddathogur'),(405,114,'Arkdhibariya','824236','Bihar','Doddathogur'),(405,115,'Electronics City','560100','Karnataka','Doddathogur'),(405,116,'Abohar','152116','Punjab','Doddathogur'),(405,152,'Abohar','152116','Punjab','doddathogur'),(405,153,'Electronics City','560100','Karnataka','doddathogur'),(405,202,'Bandarlanka','533221','Andhra Pradesh','doddathogur'),(100,203,'Bandarlanka','533221','Andhra Pradesh','123'),(405,204,'Chamundi Betta','570010','Karnataka','doddathogur');
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
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
