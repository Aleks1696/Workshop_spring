CREATE DATABASE  IF NOT EXISTS `workshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `workshop`;
-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: workshop
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commentary` varchar(300) DEFAULT NULL,
  `mark` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category` varchar(45) NOT NULL,
  `device` varchar(45) NOT NULL,
  `description` varchar(300) DEFAULT '',
  `creationDate` date NOT NULL,
  `status` varchar(45) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `managerComment` varchar(300) DEFAULT '',
  `customer` int(11) NOT NULL,
  `manager` int(11) DEFAULT NULL,
  `master` int(11) DEFAULT NULL,
  `feedback` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `description_UNIQUE` (`description`),
  KEY `fk_request_user_idx` (`customer`),
  KEY `fk_request_user1_idx` (`manager`),
  KEY `fk_request_user2_idx` (`master`),
  KEY `fk_request_feedback1_idx1` (`feedback`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `feedback_id` FOREIGN KEY (`feedback`) REFERENCES `feedback` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `manager_id` FOREIGN KEY (`manager`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `master_id` FOREIGN KEY (`master`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_archive`
--

DROP TABLE IF EXISTS `request_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_archive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_category` varchar(45) NOT NULL,
  `device` varchar(45) NOT NULL,
  `description` varchar(300) DEFAULT '',
  `creationDate` date NOT NULL,
  `status` varchar(45) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `managerComment` varchar(300) DEFAULT '',
  `customer` int(11) NOT NULL,
  `manager` int(11) DEFAULT NULL,
  `master` int(11) DEFAULT NULL,
  `feedback` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `description_UNIQUE` (`description`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_archive`
--

LOCK TABLES `request_archive` WRITE;
/*!40000 ALTER TABLE `request_archive` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `name_ua` varchar(60) DEFAULT NULL,
  `surname` varchar(60) DEFAULT NULL,
  `surname_ua` varchar(60) DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `phone_number` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `password_UNIQUE` (`password`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'manager','21232f297a57a5a743894a0e4a801fc3','MANAGER','Manager','Менеджер','Manager','Менеджер','manager@manager.com','0000000'),(2,'master','eb0a191797624dd3a48fa681d3061212','MASTER','Master','Майстер','Master','Майстер','master@master.com','0000000');
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

-- Dump completed on 2019-04-22 11:42:26
