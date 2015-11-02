CREATE DATABASE  IF NOT EXISTS `bodyshop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bodyshop`;
-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: bodyshop
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `COMMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `ENTRY_ID` bigint(20) NOT NULL,
  `CONTENT` longtext NOT NULL,
  PRIMARY KEY (`COMMENT_ID`),
  KEY `fk_user_id_idx` (`USER_ID`),
  KEY `fk_entry_id_idx` (`ENTRY_ID`),
  CONSTRAINT `FK_ENTRY_COMMENT_ID` FOREIGN KEY (`ENTRY_ID`) REFERENCES `entry` (`entry_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENTRY_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_hashtag`
--

DROP TABLE IF EXISTS `comment_hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_hashtag` (
  `COMMENT_HASHTAG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMENT_ID` bigint(20) NOT NULL,
  `HASHTAG_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`COMMENT_HASHTAG_ID`),
  KEY `fk_comment_id_idx` (`COMMENT_ID`),
  KEY `fk_hashtag_id_idx` (`HASHTAG_ID`),
  CONSTRAINT `FK_COMMENT_ID` FOREIGN KEY (`COMMENT_ID`) REFERENCES `comment` (`COMMENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_HASHTAG_ID` FOREIGN KEY (`HASHTAG_ID`) REFERENCES `hashtag` (`hashtag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_hashtag`
--

LOCK TABLES `comment_hashtag` WRITE;
/*!40000 ALTER TABLE `comment_hashtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry` (
  `ENTRY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AUTHOR_ID` bigint(20) NOT NULL,
  `CATEGORY_ID` bigint(20) DEFAULT NULL,
  `ENTRY_TITLE` varchar(45) NOT NULL,
  `ENTRY_CONTENT` longtext NOT NULL,
  `DATE_CREATED` date DEFAULT NULL,
  `DATE_EXPIRED` date DEFAULT NULL,
  PRIMARY KEY (`ENTRY_ID`),
  KEY `fk_author_id_idx` (`AUTHOR_ID`),
  KEY `fk_category_id_idx` (`CATEGORY_ID`),
  CONSTRAINT `FK_AUTHOR_ID` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CATEGORY_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `entry_category` (`entry_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry_category`
--

DROP TABLE IF EXISTS `entry_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry_category` (
  `ENTRY_CATEGORY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ENTRY_CATEGORY_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ENTRY_CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry_category`
--

LOCK TABLES `entry_category` WRITE;
/*!40000 ALTER TABLE `entry_category` DISABLE KEYS */;
INSERT INTO `entry_category` VALUES (9,'Promotion'),(10,'Fitness'),(11,'Pat Feels'),(12,'Tonerlicious');
/*!40000 ALTER TABLE `entry_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry_hashtag`
--

DROP TABLE IF EXISTS `entry_hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry_hashtag` (
  `ENTRY_HASHTAG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ENTRY_ID` bigint(20) NOT NULL,
  `HASHTAG_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ENTRY_HASHTAG_ID`),
  KEY `fk_entry_id_idx` (`ENTRY_ID`),
  KEY `fk_hash_id_idx` (`HASHTAG_ID`),
  CONSTRAINT `FK_ENTRY_HASHTAG_ID` FOREIGN KEY (`HASHTAG_ID`) REFERENCES `hashtag` (`hashtag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENTRY_ID` FOREIGN KEY (`ENTRY_ID`) REFERENCES `entry` (`ENTRY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry_hashtag`
--

LOCK TABLES `entry_hashtag` WRITE;
/*!40000 ALTER TABLE `entry_hashtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `entry_hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hashtag`
--

DROP TABLE IF EXISTS `hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hashtag` (
  `HASHTAG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `HASHTAG_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`HASHTAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hashtag`
--

LOCK TABLES `hashtag` WRITE;
/*!40000 ALTER TABLE `hashtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `static_page`
--

DROP TABLE IF EXISTS `static_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `static_page` (
  `STATIC_PAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(45) NOT NULL,
  `CONTENT` longtext NOT NULL,
  PRIMARY KEY (`STATIC_PAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `static_page`
--

LOCK TABLES `static_page` WRITE;
/*!40000 ALTER TABLE `static_page` DISABLE KEYS */;
/*!40000 ALTER TABLE `static_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `PHONE` varchar(12) DEFAULT NULL,
  `STREET_NUMBER` int(11) DEFAULT NULL,
  `STREET_NAME` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `ZIP` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2015-10-29 11:07:22
CREATE DATABASE  IF NOT EXISTS `bodyshop_test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bodyshop_test`;
-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: bodyshop_test
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `COMMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `ENTRY_ID` bigint(20) NOT NULL,
  `CONTENT` longtext NOT NULL,
  PRIMARY KEY (`COMMENT_ID`),
  KEY `fk_user_id_idx` (`USER_ID`),
  KEY `fk_entry_id_idx` (`ENTRY_ID`),
  CONSTRAINT `FK_ENTRY_COMMENT_ID` FOREIGN KEY (`ENTRY_ID`) REFERENCES `entry` (`entry_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENTRY_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_hashtag`
--

DROP TABLE IF EXISTS `comment_hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_hashtag` (
  `COMMENT_HASHTAG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMENT_ID` bigint(20) NOT NULL,
  `HASHTAG_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`COMMENT_HASHTAG_ID`),
  KEY `fk_comment_id_idx` (`COMMENT_ID`),
  KEY `fk_hashtag_id_idx` (`HASHTAG_ID`),
  CONSTRAINT `FK_COMMENT_ID` FOREIGN KEY (`COMMENT_ID`) REFERENCES `comment` (`COMMENT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_HASHTAG_ID` FOREIGN KEY (`HASHTAG_ID`) REFERENCES `hashtag` (`hashtag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_hashtag`
--

LOCK TABLES `comment_hashtag` WRITE;
/*!40000 ALTER TABLE `comment_hashtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment_hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry` (
  `ENTRY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AUTHOR_ID` bigint(20) NOT NULL,
  `CATEGORY_ID` bigint(20) DEFAULT NULL,
  `ENTRY_TITLE` varchar(45) NOT NULL,
  `ENTRY_CONTENT` longtext NOT NULL,
  `DATE_CREATED` date DEFAULT NULL,
  `DATE_EXPIRED` date DEFAULT NULL,
  PRIMARY KEY (`ENTRY_ID`),
  KEY `fk_author_id_idx` (`AUTHOR_ID`),
  KEY `fk_category_id_idx` (`CATEGORY_ID`),
  CONSTRAINT `FK_AUTHOR_ID` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CATEGORY_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `entry_category` (`entry_category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
INSERT INTO `entry` VALUES (6,2,NULL,'Hello','Hello World',NULL,NULL);
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry_category`
--

DROP TABLE IF EXISTS `entry_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry_category` (
  `ENTRY_CATEGORY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ENTRY_CATEGORY_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ENTRY_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry_category`
--

LOCK TABLES `entry_category` WRITE;
/*!40000 ALTER TABLE `entry_category` DISABLE KEYS */;
INSERT INTO `entry_category` VALUES (5,'Promotion'),(6,'Fitness'),(7,'Pat Feels'),(8,'Tonerlicious');
/*!40000 ALTER TABLE `entry_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry_hashtag`
--

DROP TABLE IF EXISTS `entry_hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry_hashtag` (
  `ENTRY_HASHTAG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ENTRY_ID` bigint(20) NOT NULL,
  `HASHTAG_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ENTRY_HASHTAG_ID`),
  KEY `fk_entry_id_idx` (`ENTRY_ID`),
  KEY `fk_hash_id_idx` (`HASHTAG_ID`),
  CONSTRAINT `FK_ENTRY_HASHTAG_ID` FOREIGN KEY (`HASHTAG_ID`) REFERENCES `hashtag` (`hashtag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENTRY_ID` FOREIGN KEY (`ENTRY_ID`) REFERENCES `entry` (`ENTRY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry_hashtag`
--

LOCK TABLES `entry_hashtag` WRITE;
/*!40000 ALTER TABLE `entry_hashtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `entry_hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hashtag`
--

DROP TABLE IF EXISTS `hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hashtag` (
  `HASHTAG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `HASHTAG_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`HASHTAG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hashtag`
--

LOCK TABLES `hashtag` WRITE;
/*!40000 ALTER TABLE `hashtag` DISABLE KEYS */;
INSERT INTO `hashtag` VALUES (34,'fun'),(35,'exciting'),(36,'horrible'),(37,'boring');
/*!40000 ALTER TABLE `hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `static_page`
--

DROP TABLE IF EXISTS `static_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `static_page` (
  `STATIC_PAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(45) NOT NULL,
  `CONTENT` longtext NOT NULL,
  PRIMARY KEY (`STATIC_PAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `static_page`
--

LOCK TABLES `static_page` WRITE;
/*!40000 ALTER TABLE `static_page` DISABLE KEYS */;
/*!40000 ALTER TABLE `static_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  `AGE` int(11) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `PHONE` varchar(12) DEFAULT NULL,
  `STREET_NUMBER` int(11) DEFAULT NULL,
  `STREET_NAME` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STATE` varchar(45) DEFAULT NULL,
  `ZIP` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Hello','Person','M',0,'hello@hello.com','215-898-9090',2540,'BALLS','Akron','OH',43333);
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

-- Dump completed on 2015-10-29 11:07:22
