-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: epgs
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `epgs`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `epgs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `epgs`;

--
-- Table structure for table `attendence`
--

DROP TABLE IF EXISTS `attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendence` (
  `attandence_id` bigint NOT NULL AUTO_INCREMENT,
  `advance` float NOT NULL,
  `conveyance_expenses` float NOT NULL,
  `date` date DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  `end_to` varchar(255) DEFAULT NULL,
  `hours` float NOT NULL,
  `over_time` char(1) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `start_from` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `employee_id` bigint DEFAULT NULL,
  `site_id` bigint DEFAULT NULL,
  `over_time_hours` float NOT NULL,
  `over_time_hour` char(1) NOT NULL,
  PRIMARY KEY (`attandence_id`),
  KEY `FK36p0tha25qptt2iq5gi9uacgk` (`employee_id`),
  KEY `FKifws6bwxt9iuvkal0huffd83b` (`site_id`)
) ENGINE=MyISAM AUTO_INCREMENT=237 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendence`
--

LOCK TABLES `attendence` WRITE;
/*!40000 ALTER TABLE `attendence` DISABLE KEYS */;
INSERT INTO `attendence` VALUES (1,0,100,'2023-04-01','Sat','Gaziabad',0,'N','cash','Delhi','P',1,1,0,''),(2,0,0,'2023-04-02','Sun','Delhi',0,'N','','Delhi','P',1,1,0,''),(3,2000,0,'2023-04-03','Mon','Gaziabad',0,'N','','Gaziabad','P',1,1,0,''),(4,0,0,'2023-04-01','Sat','Delhi',8,'0','','Delhi','P',2,1,0,''),(5,0,0,'2020-03-02','Sun','delhi',0,'N','','delhi','P',2,1,0,''),(6,0,0,'2020-04-03','Mon','delhi',8,'N','','delhi','P',2,1,0,''),(7,0,0,'2020-04-04','Tue','delhi',8,'N','','delhi','P',2,1,0,''),(8,0,0,'2020-04-05','Wed','delhi',8,'N','','delhi','P',2,1,0,''),(9,0,0,'2020-04-06','Thru','delhi',8,'N','','delhi','P',2,1,0,''),(10,0,0,'2020-04-07','Fri','delhi',8,'N','','delhi','P',2,1,0,''),(11,0,0,'2020-04-08','Sat','delhi',8,'N','','delhi','P',2,1,0,''),(12,0,0,'2020-04-09','Sun','delhi',8,'N','','delhi','P',2,1,0,''),(13,0,0,'2020-04-10','Sat','delhi',8,'N','','delhi','P',2,1,0,''),(169,150,0,'2023-03-31','FRIDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(170,150,0,'2023-04-01','SATURDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(171,150,0,'2023-04-02','SUNDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(172,150,0,'2023-04-03','MONDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(173,150,0,'2023-04-04','TUESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(174,150,0,'2023-04-05','WEDNESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(175,150,0,'2023-04-06','THURSDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(176,150,0,'2023-04-07','FRIDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(177,150,0,'2023-04-08','SATURDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(178,150,0,'2023-04-09','SUNDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(179,150,0,'2023-04-10','MONDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(180,150,0,'2023-04-11','TUESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(181,150,0,'2023-04-12','WEDNESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(182,150,0,'2023-04-13','THURSDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(183,150,0,'2023-04-14','FRIDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(184,150,0,'2023-04-15','SATURDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(185,150,0,'2023-04-16','SUNDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(186,150,0,'2023-04-17','MONDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(187,150,0,'2023-04-18','TUESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(188,150,0,'2023-04-19','WEDNESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(189,150,0,'2023-04-20','THURSDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(190,150,0,'2023-04-21','FRIDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(191,150,0,'2023-04-22','SATURDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(192,150,0,'2023-04-23','SUNDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(193,150,0,'2023-04-24','MONDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(194,150,0,'2023-04-25','TUESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(195,150,0,'2023-04-26','WEDNESDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(196,150,0,'2023-04-27','THURSDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(197,150,0,'2023-04-28','FRIDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(198,150,0,'2023-04-29','SATURDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(199,150,0,'2023-04-30','SUNDAY','Delhi',8,'N','PATTM','Delhi','P',3,4,0,''),(200,100,0,'2023-03-31','FRIDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(201,100,0,'2023-04-01','SATURDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(202,100,0,'2023-04-02','SUNDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(203,100,0,'2023-04-03','MONDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(204,100,0,'2023-04-04','TUESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(205,100,0,'2023-04-05','WEDNESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(206,100,0,'2023-04-06','THURSDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(207,100,0,'2023-04-07','FRIDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(208,100,0,'2023-04-08','SATURDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(209,100,0,'2023-04-09','SUNDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(210,100,0,'2023-04-10','MONDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(211,100,0,'2023-04-11','TUESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(212,100,0,'2023-04-12','WEDNESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(213,100,0,'2023-04-13','THURSDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(214,100,0,'2023-04-14','FRIDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(215,100,0,'2023-04-15','SATURDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(216,100,0,'2023-04-16','SUNDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(217,100,0,'2023-04-17','MONDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(218,100,0,'2023-04-18','TUESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(219,100,0,'2023-04-19','WEDNESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(220,100,0,'2023-04-20','THURSDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(221,100,0,'2023-04-21','FRIDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(222,100,0,'2023-04-22','SATURDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(223,100,0,'2023-04-23','SUNDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(224,100,0,'2023-04-24','MONDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(225,100,0,'2023-04-25','TUESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(226,100,0,'2023-04-26','WEDNESDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(227,100,0,'2023-04-27','THURSDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(228,100,0,'2023-04-28','FRIDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(229,100,0,'2023-04-29','SATURDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(230,100,0,'2023-04-30','SUNDAY','Noida',8,'N','CASH','Noida','P',4,4,0,''),(231,500,500,NULL,'MONDAY','k',8,'n','kkk','d','p',1,6,0,''),(232,500,500,NULL,'WEDNESDAY','k',8,'Y','cash','d','p',3,1,0,''),(233,500,500,'2023-05-03','WEDNESDAY','k',8,'Y','cash','d','p',1,1,0,''),(234,500,500,'2023-05-03','WEDNESDAY','k',8,'Y','cash','d','p',3,4,0,''),(235,500,500,'2023-05-03','WEDNESDAY','k',8,'Y','cash','d','p',3,6,5,''),(236,400,500,'2023-05-03','WEDNESDAY','k',8,'Y','','d','p',4,6,5,'');
/*!40000 ALTER TABLE `attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `daily_wase_amount` float NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile1` varchar(255) DEFAULT NULL,
  `mobile2` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `salary` float NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Gaur Sidhratham',0,'maxsanjeevanand@gmail.com','1234567890','','RITIK ANAND','emp',10000,'Permanent'),(2,'Sidhratam Vihar',700,'maxsanjeevanand@gmail.com','1234567890','','Sanjeev Anand','emp',0,'Daily'),(3,'Mayur vihar',800,'abc@gmail.com','0987654321','','Virendra kumar','employee',0,'Daily'),(4,'Lakshmi Nagar',0,'abc@gmail.com','0987654321','','Ramesh','Employee',9000,'Permanent');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expence`
--

DROP TABLE IF EXISTS `expence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expence` (
  `expence_id` bigint NOT NULL AUTO_INCREMENT,
  `expence_amount` float NOT NULL,
  `expence_description` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  PRIMARY KEY (`expence_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expence`
--

LOCK TABLES `expence` WRITE;
/*!40000 ALTER TABLE `expence` DISABLE KEYS */;
INSERT INTO `expence` VALUES (1,1000,'given to sha',NULL,NULL),(6,1000,'tesslo2',NULL,'2023-05-18');
/*!40000 ALTER TABLE `expence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_blob_triggers`
--

DROP TABLE IF EXISTS `qrtz_blob_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_blob_triggers`
--

LOCK TABLES `qrtz_blob_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_blob_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_calendars`
--

DROP TABLE IF EXISTS `qrtz_calendars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(190) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_calendars`
--

LOCK TABLES `qrtz_calendars` WRITE;
/*!40000 ALTER TABLE `qrtz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_calendars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_cron_triggers`
--

DROP TABLE IF EXISTS `qrtz_cron_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_cron_triggers`
--

LOCK TABLES `qrtz_cron_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_cron_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_cron_triggers` VALUES ('quartzScheduler','01b8eed7-0056-43a8-a01b-05b6a14936c4','email-triggers','0 0/1 17-22 * * ?','Asia/Calcutta'),('quartzScheduler','13a5367d-15ca-45ea-8749-f23fa7137513','email-triggers','0 0/1 17-22 * * ?','Asia/Calcutta'),('quartzScheduler','476712d5-ccf4-44dd-9f6d-7cfafda19ba7','email-triggers','0 */1 * ? * *','Asia/Calcutta'),('quartzScheduler','47e27191-fac5-4831-872e-46b061573727','email-triggers','0 */1 * ? * *','Asia/Calcutta'),('quartzScheduler','59df2748-7c44-4b08-a8a7-2a6bf185e0bf','email-triggers','0 */1 * ? * *','Asia/Calcutta'),('quartzScheduler','64e71cb1-2878-4f9c-867a-dfe4e4ca5952','email-triggers','0 */1 * ? * *','Asia/Calcutta'),('quartzScheduler','876820d3-1b22-44f3-98ad-dfedaae397c4','email-triggers','0 0/2 17-22 * * ?','Asia/Calcutta'),('quartzScheduler','a613cc0d-9876-4adb-a1a3-e95d7150ffc8','email-triggers','0 */1 * ? * *','Asia/Calcutta'),('quartzScheduler','bdb7ebc2-a947-4fde-a624-eba677770d7e','email-triggers','0 0/1 17-22 * * ?','Asia/Calcutta'),('quartzScheduler','d163ef2b-e4a7-4104-8c10-1f7db49d57e5','email-triggers','0 0/1 17-22 * * ?','Asia/Calcutta'),('quartzScheduler','f5a9216f-36c7-452b-8fae-eaf5f662585b','email-triggers','0 */5 * ? * *','Asia/Calcutta');
/*!40000 ALTER TABLE `qrtz_cron_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_fired_triggers`
--

DROP TABLE IF EXISTS `qrtz_fired_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `INSTANCE_NAME` varchar(190) NOT NULL,
  `FIRED_TIME` bigint NOT NULL,
  `SCHED_TIME` bigint NOT NULL,
  `PRIORITY` int NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(190) DEFAULT NULL,
  `JOB_GROUP` varchar(190) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_fired_triggers`
--

LOCK TABLES `qrtz_fired_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_fired_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_fired_triggers` VALUES ('quartzScheduler','NON_CLUSTERED1684412044209','47e27191-fac5-4831-872e-46b061573727','email-triggers','NON_CLUSTERED',1684422000102,1684422000000,5,'EXECUTING','47e27191-fac5-4831-872e-46b061573727','email-jobs','0','0'),('quartzScheduler','NON_CLUSTERED1684412044210','59df2748-7c44-4b08-a8a7-2a6bf185e0bf','email-triggers','NON_CLUSTERED',1684422000137,1684422000000,5,'EXECUTING','59df2748-7c44-4b08-a8a7-2a6bf185e0bf','email-jobs','0','0'),('quartzScheduler','NON_CLUSTERED1684412044212','876820d3-1b22-44f3-98ad-dfedaae397c4','email-triggers','NON_CLUSTERED',1684422002561,1684422000000,5,'EXECUTING','876820d3-1b22-44f3-98ad-dfedaae397c4','email-jobs','0','0'),('quartzScheduler','NON_CLUSTERED1684412044214','bdb7ebc2-a947-4fde-a624-eba677770d7e','email-triggers','NON_CLUSTERED',1684422004668,1684422000000,5,'EXECUTING','bdb7ebc2-a947-4fde-a624-eba677770d7e','email-jobs','0','0'),('quartzScheduler','NON_CLUSTERED1684412044609','64e71cb1-2878-4f9c-867a-dfe4e4ca5952','email-triggers','NON_CLUSTERED',1684428314477,1684428300000,5,'EXECUTING','64e71cb1-2878-4f9c-867a-dfe4e4ca5952','backup-jobs','0','0');
/*!40000 ALTER TABLE `qrtz_fired_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_job_details`
--

DROP TABLE IF EXISTS `qrtz_job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(190) NOT NULL,
  `JOB_GROUP` varchar(190) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_job_details`
--

LOCK TABLES `qrtz_job_details` WRITE;
/*!40000 ALTER TABLE `qrtz_job_details` DISABLE KEYS */;
INSERT INTO `qrtz_job_details` VALUES ('quartzScheduler','01b8eed7-0056-43a8-a01b-05b6a14936c4','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','13a5367d-15ca-45ea-8749-f23fa7137513','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','280c9ad9-08e2-4e1d-af6d-536125252260','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','476712d5-ccf4-44dd-9f6d-7cfafda19ba7','backup-jobs','Send Back Job','com.arvs.epgs.job.BackUpJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0filenamet\0&BackupThu May 18 03:17:19 IST 2023.sqlx\0'),('quartzScheduler','47e27191-fac5-4831-872e-46b061573727','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0develectrical2025@gmail.comx\0'),('quartzScheduler','507f9e01-8b65-447a-857c-4b2d8176c966','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','59df2748-7c44-4b08-a8a7-2a6bf185e0bf','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','64e71cb1-2878-4f9c-867a-dfe4e4ca5952','backup-jobs','Send Back Job','com.arvs.epgs.job.BackUpJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0filenamet\0&BackupThu May 18 03:26:00 IST 2023.sqlx\0'),('quartzScheduler','876820d3-1b22-44f3-98ad-dfedaae397c4','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','a613cc0d-9876-4adb-a1a3-e95d7150ffc8','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0develectrical@gmail.comx\0'),('quartzScheduler','bdb7ebc2-a947-4fde-a624-eba677770d7e','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','d163ef2b-e4a7-4104-8c10-1f7db49d57e5','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0'),('quartzScheduler','f5a9216f-36c7-452b-8fae-eaf5f662585b','email-jobs','Send Email Job','com.arvs.epgs.job.EmailJob','1','0','0','0',_binary '¬\í\0sr\0org.quartz.JobDataMapŸ°ƒè¿©°\Ë\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap‚\è\Ãû\Å](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\æ.­(v\n\Î\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\ÚÁ\Ã`\Ñ\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0subjectt\0bodyt\0bodyt\0subjectt\0emailt\0\rsan@gmail.comx\0');
/*!40000 ALTER TABLE `qrtz_job_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_locks`
--

DROP TABLE IF EXISTS `qrtz_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_locks`
--

LOCK TABLES `qrtz_locks` WRITE;
/*!40000 ALTER TABLE `qrtz_locks` DISABLE KEYS */;
INSERT INTO `qrtz_locks` VALUES ('quartzScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `qrtz_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_paused_trigger_grps`
--

LOCK TABLES `qrtz_paused_trigger_grps` WRITE;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_scheduler_state`
--

DROP TABLE IF EXISTS `qrtz_scheduler_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(190) NOT NULL,
  `LAST_CHECKIN_TIME` bigint NOT NULL,
  `CHECKIN_INTERVAL` bigint NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_scheduler_state`
--

LOCK TABLES `qrtz_scheduler_state` WRITE;
/*!40000 ALTER TABLE `qrtz_scheduler_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_scheduler_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simple_triggers`
--

DROP TABLE IF EXISTS `qrtz_simple_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `REPEAT_COUNT` bigint NOT NULL,
  `REPEAT_INTERVAL` bigint NOT NULL,
  `TIMES_TRIGGERED` bigint NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simple_triggers`
--

LOCK TABLES `qrtz_simple_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simple_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simprop_triggers`
--

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int DEFAULT NULL,
  `INT_PROP_2` int DEFAULT NULL,
  `LONG_PROP_1` bigint DEFAULT NULL,
  `LONG_PROP_2` bigint DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simprop_triggers`
--

LOCK TABLES `qrtz_simprop_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_triggers`
--

DROP TABLE IF EXISTS `qrtz_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `JOB_NAME` varchar(190) NOT NULL,
  `JOB_GROUP` varchar(190) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint DEFAULT NULL,
  `PREV_FIRE_TIME` bigint DEFAULT NULL,
  `PRIORITY` int DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint NOT NULL,
  `END_TIME` bigint DEFAULT NULL,
  `CALENDAR_NAME` varchar(190) DEFAULT NULL,
  `MISFIRE_INSTR` smallint DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_triggers`
--

LOCK TABLES `qrtz_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_triggers` VALUES ('quartzScheduler','01b8eed7-0056-43a8-a01b-05b6a14936c4','email-triggers','01b8eed7-0056-43a8-a01b-05b6a14936c4','email-jobs','Send Email Trigger',1684428360000,1684428300000,5,'WAITING','CRON',1684218840000,0,NULL,0,''),('quartzScheduler','13a5367d-15ca-45ea-8749-f23fa7137513','email-triggers','13a5367d-15ca-45ea-8749-f23fa7137513','email-jobs','Send Email Trigger',1684428360000,1684428300000,5,'WAITING','CRON',1684175580000,0,NULL,0,''),('quartzScheduler','476712d5-ccf4-44dd-9f6d-7cfafda19ba7','email-triggers','476712d5-ccf4-44dd-9f6d-7cfafda19ba7','backup-jobs','Send Backup Trigger',1684428360000,1684428300000,5,'WAITING','CRON',1684360039000,0,NULL,0,''),('quartzScheduler','47e27191-fac5-4831-872e-46b061573727','email-triggers','47e27191-fac5-4831-872e-46b061573727','email-jobs','Send Email Trigger',1684428360000,1684428300000,5,'WAITING','CRON',1684355340000,0,NULL,0,''),('quartzScheduler','59df2748-7c44-4b08-a8a7-2a6bf185e0bf','email-triggers','59df2748-7c44-4b08-a8a7-2a6bf185e0bf','email-jobs','Send Email Trigger',1684428360000,1684428300000,5,'WAITING','CRON',1684354920000,0,NULL,0,''),('quartzScheduler','64e71cb1-2878-4f9c-867a-dfe4e4ca5952','email-triggers','64e71cb1-2878-4f9c-867a-dfe4e4ca5952','backup-jobs','Send Backup Trigger',1684428360000,1684428300000,5,'WAITING','CRON',1684360560000,0,NULL,0,''),('quartzScheduler','876820d3-1b22-44f3-98ad-dfedaae397c4','email-triggers','876820d3-1b22-44f3-98ad-dfedaae397c4','email-jobs','Send Email Trigger',1684428360000,1684428240000,5,'WAITING','CRON',1684080540000,0,NULL,0,''),('quartzScheduler','a613cc0d-9876-4adb-a1a3-e95d7150ffc8','email-triggers','a613cc0d-9876-4adb-a1a3-e95d7150ffc8','email-jobs','Send Email Trigger',1684428300000,1684428240000,5,'WAITING','CRON',1684355160000,0,NULL,0,''),('quartzScheduler','bdb7ebc2-a947-4fde-a624-eba677770d7e','email-triggers','bdb7ebc2-a947-4fde-a624-eba677770d7e','email-jobs','Send Email Trigger',1684428300000,1684428240000,5,'WAITING','CRON',1684393109000,0,NULL,0,''),('quartzScheduler','d163ef2b-e4a7-4104-8c10-1f7db49d57e5','email-triggers','d163ef2b-e4a7-4104-8c10-1f7db49d57e5','email-jobs','Send Email Trigger',1684428300000,1684428240000,5,'WAITING','CRON',1684082460000,0,NULL,0,''),('quartzScheduler','f5a9216f-36c7-452b-8fae-eaf5f662585b','email-triggers','f5a9216f-36c7-452b-8fae-eaf5f662585b','email-jobs','Send Email Trigger',1684428300000,1684428000000,5,'WAITING','CRON',1684393649000,0,NULL,0,'');
/*!40000 ALTER TABLE `qrtz_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site` (
  `site_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `site_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`site_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (1,'Pratap Vihar','Gaur'),(4,'Yamuna Bank Delhi','Yamuna Bank'),(5,'hajipur','abc pvt'),(6,'sidhratham','Prateek'),(7,'delji','aaaa '),(8,'delji','aaaa '),(9,'delji','aaaa '),(10,'delji','aaaa ');
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-18 22:15:15
