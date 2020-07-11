CREATE DATABASE  IF NOT EXISTS `wallet-erp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wallet-erp`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: wallet-erp
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `customer-detail`
--

DROP TABLE IF EXISTS `customer-detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer-detail` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(200) NOT NULL,
  `country` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `address` varchar(250) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer-detail`
--

LOCK TABLES `customer-detail` WRITE;
/*!40000 ALTER TABLE `customer-detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer-detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer-logo`
--

DROP TABLE IF EXISTS `customer-logo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer-logo` (
  `customer_id` bigint NOT NULL,
  `picture` longblob,
  `name` varchar(125) DEFAULT NULL,
  `upload_date` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `fk_customer-detail_id_customer_logo_id` FOREIGN KEY (`customer_id`) REFERENCES `customer-detail` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer-logo`
--

LOCK TABLES `customer-logo` WRITE;
/*!40000 ALTER TABLE `customer-logo` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer-logo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer-status`
--

DROP TABLE IF EXISTS `customer-status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer-status` (
  `customer_id` bigint NOT NULL,
  `active` tinyint(1) NOT NULL,
  `last_modify` timestamp NOT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `fk_customer-detail_id_customer_status_id` FOREIGN KEY (`customer_id`) REFERENCES `customer-detail` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer-status`
--

LOCK TABLES `customer-status` WRITE;
/*!40000 ALTER TABLE `customer-status` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer-status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer-tax`
--

DROP TABLE IF EXISTS `customer-tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer-tax` (
  `customer_id` bigint NOT NULL,
  `tax_num` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `fk_customer-detail_id_customer-tax_id` FOREIGN KEY (`customer_id`) REFERENCES `customer-detail` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer-tax`
--

LOCK TABLES `customer-tax` WRITE;
/*!40000 ALTER TABLE `customer-tax` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer-tax` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-11 16:51:45
