/*
SQLyog Ultimate v8.55 
MySQL - 5.6.14-log : Database - learnersdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`learnersdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `learnersdb`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `sellingPrice` decimal(10,0) DEFAULT NULL,
  `addedDate` int(11) DEFAULT NULL,
  `stockInHand` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `reOrderLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book` (`typeId`),
  CONSTRAINT `FK_book` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`isbn`,`sellingPrice`,`addedDate`,`stockInHand`,`typeId`,`reOrderLevel`) values (1,'Amma','978-955-21-2853-6','650',201703,13,1,5),(2,'Kaliugaya','978-955-21-2853-7','400',201703,3,2,5),(3,'Rathu Rosa Mala','978-955-21-2853-7','1000',201606,8,3,5),(4,'Guru Geethaya','978-955-21-2853-7','400',201702,9,4,5);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `NewIndex1` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`categoryName`) values (1,'Action'),(4,'Commedy'),(3,'Kids'),(2,'Tragedy');

/*Table structure for table `client_notification` */

DROP TABLE IF EXISTS `client_notification`;

CREATE TABLE `client_notification` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `traineeId` int(10) NOT NULL,
  `notifyDate` date NOT NULL,
  `notification` date NOT NULL,
  `state` varchar(75) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_client_notification` (`traineeId`),
  CONSTRAINT `FK_client_notification` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `client_notification` */

/*Table structure for table `document` */

DROP TABLE IF EXISTS `document`;

CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `document` varchar(100) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `document` */

insert  into `document`(`id`,`document`) values (1,'Guidance Book'),(2,'CD'),(3,'Paper set');

/*Table structure for table `document_issued` */

DROP TABLE IF EXISTS `document_issued`;

CREATE TABLE `document_issued` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `traineeId` int(11) NOT NULL,
  `documentId` int(11) NOT NULL,
  `issuedDate` date NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `FK_document_issued` (`documentId`),
  KEY `FK_document_issued1` (`traineeId`),
  CONSTRAINT `FK_document_issued` FOREIGN KEY (`documentId`) REFERENCES `document` (`id`),
  CONSTRAINT `FK_document_issued1` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `document_issued` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `salary` double NOT NULL,
  `totSalary` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`salary`,`totSalary`) values (1,'Amal',10000,10000),(2,'Kamal',25000,27000),(3,'Sunil',15000,17000),(4,'Nima',18000,20000),(5,'Ranil',3000,3000);

/*Table structure for table `exam_result` */

DROP TABLE IF EXISTS `exam_result`;

CREATE TABLE `exam_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `traineeId` int(10) NOT NULL,
  `examDate` date NOT NULL,
  `noOfAttempts` enum('One','Two','Three','Reject') NOT NULL,
  `examType` varchar(75) NOT NULL,
  `marks` int(5) NOT NULL,
  `result` enum('Pass','Fail','Repeat') NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `FK_exam_result` (`traineeId`),
  CONSTRAINT `FK_exam_result` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam_result` */

/*Table structure for table `exam_schedule` */

DROP TABLE IF EXISTS `exam_schedule`;

CREATE TABLE `exam_schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `traineeId` int(10) NOT NULL,
  `examDate` date NOT NULL,
  `noOfAttempts` enum('One','Two','Three') NOT NULL,
  `description` varchar(200) NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `FK_exam_schedule` (`traineeId`),
  CONSTRAINT `FK_exam_schedule` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `exam_schedule` */

/*Table structure for table `fuel` */

DROP TABLE IF EXISTS `fuel`;

CREATE TABLE `fuel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `cost` double NOT NULL,
  `vehicleId` int(10) NOT NULL,
  `fuelDate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fuel` (`vehicleId`),
  CONSTRAINT `FK_fuel` FOREIGN KEY (`vehicleId`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fuel` */

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(40) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_item` (`categoryId`),
  CONSTRAINT `FK_item` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`id`,`itemName`,`categoryId`) values (100,'trouser',1),(101,'T shirt',1),(102,'shirt',1),(103,'short',2);

/*Table structure for table `learners_role` */

DROP TABLE IF EXISTS `learners_role`;

CREATE TABLE `learners_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(64) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_learners_role` (`userEmail`),
  CONSTRAINT `FK_learners_role` FOREIGN KEY (`userEmail`) REFERENCES `learners_user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `learners_role` */

insert  into `learners_role`(`id`,`userEmail`,`roleId`) values (1,'shamanthi@gmail.com',2),(2,'amila@gmail.com',1);

/*Table structure for table `learners_user` */

DROP TABLE IF EXISTS `learners_user`;

CREATE TABLE `learners_user` (
  `email` varchar(64) NOT NULL,
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `learners_user` */

insert  into `learners_user`(`email`,`firstName`,`lastName`,`password`) values ('amila@gmail.com','Amila','Ruwan','abc123'),('shamanthi@gmail.com','Shamanthi','Shanika','abc123');

/*Table structure for table `license_applied` */

DROP TABLE IF EXISTS `license_applied`;

CREATE TABLE `license_applied` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `licenseClassId` int(10) NOT NULL,
  `traineeId` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_license_applied` (`traineeId`),
  KEY `FK_license_applied1` (`licenseClassId`),
  CONSTRAINT `FK_license_applied` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`),
  CONSTRAINT `FK_license_applied1` FOREIGN KEY (`licenseClassId`) REFERENCES `license_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `license_applied` */

/*Table structure for table `license_class` */

DROP TABLE IF EXISTS `license_class`;

CREATE TABLE `license_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` varchar(10) NOT NULL,
  `class_Description` varchar(75) NOT NULL,
  `total_Fee` decimal(10,0) NOT NULL,
  `basic_Fee` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `license_class` */

insert  into `license_class`(`id`,`class`,`class_Description`,`total_Fee`,`basic_Fee`) values (1,'ghbjk','njknlk','12','1233'),(2,'hbj','jmjk','46','896'),(3,'hiu',' juyhgbi','896','521'),(4,'xzd','xdzdc','45','15'),(5,'nmn','bkj','523','56'),(6,'nkm','m ','22','354'),(7,'23','rer','45','85'),(8,'dfdsf','dstg','45','213'),(9,'fgd','hgh','45','523');

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(255) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_movie` (`categoryId`),
  CONSTRAINT `FK_movie` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `movie` */

insert  into `movie`(`id`,`movieName`,`categoryId`) values (1,'Titanic',2),(2,'Maya',3),(3,'24',1),(4,'Zoom',4),(5,'Romeo&Juiet',1),(6,'Mohendajaro',4),(7,'Scoobydoo',2),(8,'singham',3),(9,'Suhada Koka',4);

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `traineeId` int(10) NOT NULL,
  `registrationFee` decimal(10,0) NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `paymentDate` date NOT NULL,
  `totalPaid` decimal(10,0) NOT NULL,
  `dueAmount` decimal(10,0) NOT NULL,
  `classId` int(11) NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `FK_payment1` (`classId`),
  KEY `FK_payment` (`traineeId`),
  CONSTRAINT `FK_payment` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`),
  CONSTRAINT `FK_payment1` FOREIGN KEY (`classId`) REFERENCES `license_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `payment` */

/*Table structure for table `profit` */

DROP TABLE IF EXISTS `profit`;

CREATE TABLE `profit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(25) NOT NULL,
  `netProfit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `profit` */

insert  into `profit`(`id`,`month`,`netProfit`) values (1,'January',12000),(2,'February',13000),(3,'March',13000),(4,'April',10000);

/*Table structure for table `salary` */

DROP TABLE IF EXISTS `salary`;

CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffId` int(10) NOT NULL,
  `basic` decimal(10,0) NOT NULL,
  `allowances` decimal(10,0) NOT NULL,
  `bonus` decimal(10,0) NOT NULL,
  `grossSalary` decimal(10,0) NOT NULL,
  `deductions` decimal(10,0) NOT NULL,
  `netSalary` decimal(10,0) NOT NULL,
  `total` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK_salary` (`staffId`),
  CONSTRAINT `FK_salary` FOREIGN KEY (`staffId`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salary` */

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameWithInitials` varchar(100) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `nic` varchar(20) NOT NULL,
  `civilStatus` enum('Single','Married','Divorced','Widow') NOT NULL,
  `occupation` varchar(50) NOT NULL,
  `contactHome` varchar(25) NOT NULL,
  `contactMobile` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `permanentAddressLine1` varchar(100) NOT NULL,
  `permanentAddressLine2` varchar(100) NOT NULL,
  `permanentAddressLine3` varchar(100) DEFAULT NULL,
  `contactAddressLine1` varchar(100) DEFAULT NULL,
  `contactAddressLine2` varchar(100) DEFAULT NULL,
  `contactAddressLine3` varchar(100) DEFAULT NULL,
  `dateOfRecruited` date NOT NULL,
  `currentStatus` enum('worker','leaver') NOT NULL,
  `dateOfLeft` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`id`,`nameWithInitials`,`fullName`,`dateOfBirth`,`gender`,`nic`,`civilStatus`,`occupation`,`contactHome`,`contactMobile`,`email`,`permanentAddressLine1`,`permanentAddressLine2`,`permanentAddressLine3`,`contactAddressLine1`,`contactAddressLine2`,`contactAddressLine3`,`dateOfRecruited`,`currentStatus`,`dateOfLeft`) values (1,'G.I.Perera','Gihan Imesh','1985-01-24','Male','850243568V','Married','Inspector','0372284569','0713158654','gihan@gmail.com','Main Street','Kuliyapitiya',NULL,NULL,NULL,NULL,'2005-02-15','worker',NULL),(2,'R.M.Ranathunghe','Rekha Madhumali','1992-05-21','Female','926146598V','Single','Clerk','0375289646','0776589321','Rekha@yahoo.com','Kurunegala Rd','Narammala',NULL,NULL,NULL,NULL,'2015-12-10','worker',NULL),(3,'H.L.Zoyza','Hemal Lakesh','1992-02-08','Male','920461252V','Married','Inspector','0322589769','0785649876','Hemal@gmail.com','Madampe Rd','eegahakotuwa',NULL,NULL,NULL,NULL,'2012-08-16','worker',NULL);

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

insert  into `stock`(`id`,`name`,`quantity`) values (1,'Car',24),(2,'Van',30),(3,'Motor Bike',60),(4,'Push Cycle',90),(5,'Bus',50);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `regNo` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`regNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`regNo`,`name`) values ('r10000','Amila'),('r10001','Ruwan');

/*Table structure for table `todo_notifications` */

DROP TABLE IF EXISTS `todo_notifications`;

CREATE TABLE `todo_notifications` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `notification` varchar(255) NOT NULL,
  `dateAdded` date NOT NULL,
  `dueDate` date NOT NULL,
  `displayDate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_todo_notifications` (`email`),
  CONSTRAINT `FK_todo_notifications` FOREIGN KEY (`email`) REFERENCES `amila_user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `todo_notifications` */

/*Table structure for table `trainee` */

DROP TABLE IF EXISTS `trainee`;

CREATE TABLE `trainee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameWithInitials` varchar(125) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` varchar(10) NOT NULL,
  `civilStatus` enum('Single','Married','Divorced','Widow','seperated') NOT NULL,
  `nicNo` varchar(20) NOT NULL,
  `heightFeets/Inches` double NOT NULL,
  `weightKg` decimal(5,0) NOT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `contact1` varchar(25) NOT NULL,
  `contact2` varchar(25) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `permanentAddressLine1` varchar(100) NOT NULL,
  `permanentAddressLine2` varchar(100) NOT NULL,
  `permanentAddressLine3` varchar(100) DEFAULT NULL,
  `ContactAddressLine1` varchar(100) DEFAULT NULL,
  `ContactAddressLine2` varchar(100) DEFAULT NULL,
  `ContactAddressLine3` varchar(100) DEFAULT NULL,
  `city` varchar(75) NOT NULL,
  `district` varchar(50) NOT NULL,
  `divisionalSecretariatOffice` varchar(75) NOT NULL,
  `nearestPoliceStation` varchar(50) NOT NULL,
  `classApplying` varchar(30) NOT NULL,
  `alreadyHavingLicense` enum('Yes','No') NOT NULL,
  `licenseNo` varchar(25) DEFAULT NULL,
  `class` varchar(75) DEFAULT NULL,
  `dateOfIssued` date DEFAULT NULL,
  `dateOfExpire` date DEFAULT NULL,
  `documentIssuedId` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  `registeredDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `trainee` */

insert  into `trainee`(`id`,`nameWithInitials`,`fullName`,`dateOfBirth`,`gender`,`civilStatus`,`nicNo`,`heightFeets/Inches`,`weightKg`,`occupation`,`contact1`,`contact2`,`email`,`permanentAddressLine1`,`permanentAddressLine2`,`permanentAddressLine3`,`ContactAddressLine1`,`ContactAddressLine2`,`ContactAddressLine3`,`city`,`district`,`divisionalSecretariatOffice`,`nearestPoliceStation`,`classApplying`,`alreadyHavingLicense`,`licenseNo`,`class`,`dateOfIssued`,`dateOfExpire`,`documentIssuedId`,`classId`,`registeredDate`) values (1,'s.m perera','frdr5cv gtgvyghb','1996-11-04','','','',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00'),(2,'sds','sdsf','2017-02-18','','','',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00'),(3,'dsfd','fdfdg','2017-02-12','','','',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00'),(5,'sdsd','sdewe','2017-02-07','','','',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00'),(6,'dfd','dsg','2000-12-12','Male','Single','14528686',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00'),(7,'vvh','jnlk','1994-12-12','Female','Single','kkm',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00'),(8,'dgfg','fhn','1994-10-10','Male','seperated','ghgm',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00'),(9,'gjj','jhi','1998-12-10','Male','Married','hgkjk',0,'0',NULL,'',NULL,'','','',NULL,NULL,NULL,NULL,'','','','','','Yes',NULL,NULL,NULL,NULL,0,0,'0000-00-00');

/*Table structure for table `trial_result` */

DROP TABLE IF EXISTS `trial_result`;

CREATE TABLE `trial_result` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `traineeId` int(10) NOT NULL,
  `trialDate` date NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `result` enum('Pass','Fail','Repeat') NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `FK_trial_result` (`traineeId`),
  CONSTRAINT `FK_trial_result` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trial_result` */

/*Table structure for table `trial_schedule` */

DROP TABLE IF EXISTS `trial_schedule`;

CREATE TABLE `trial_schedule` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `traineeId` int(10) NOT NULL,
  `trialDate` date NOT NULL,
  `noOfAttempts` enum('One','Two','Three') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_trial_schedule` (`traineeId`),
  CONSTRAINT `FK_trial_schedule` FOREIGN KEY (`traineeId`) REFERENCES `trainee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trial_schedule` */

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`typeName`) values (1,'Sinhala Novel'),(2,'Sinhala Short Stories'),(3,'Translation Novel'),(4,'Translation Short Stories');

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registrationNo` varchar(50) NOT NULL,
  `registereddate` date NOT NULL,
  `licenseNo` varchar(25) NOT NULL,
  `age` int(11) NOT NULL,
  `licenseExpiresOn` date NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`registrationNo`),
  KEY `NewIndex2` (`categoryId`),
  CONSTRAINT `FK_vehicle` FOREIGN KEY (`categoryId`) REFERENCES `vehicle_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `vehicle` */

insert  into `vehicle`(`id`,`registrationNo`,`registereddate`,`licenseNo`,`age`,`licenseExpiresOn`,`categoryId`) values (1,'10002','2010-02-05','ws-9066',45,'2016-12-30',2),(2,'564287','2000-05-09','ads-2531',52,'2017-05-20',1),(3,'642581','2002-06-15','vf-6813',12,'2017-02-01',3),(4,'46578','2003-10-11','hj-256',15,'2016-09-11',2),(5,'45698','2006-10-11','fg-4569',30,'2017-01-01',1),(6,'4857','2014-12-08','ht-6785',30,'2016-02-08',2);

/*Table structure for table `vehicle_category` */

DROP TABLE IF EXISTS `vehicle_category`;

CREATE TABLE `vehicle_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleType` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`vehicleType`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `vehicle_category` */

insert  into `vehicle_category`(`id`,`vehicleType`) values (1,'Heavy'),(2,'Light'),(3,'Motor Bike');

/*Table structure for table `vehicle_service` */

DROP TABLE IF EXISTS `vehicle_service`;

CREATE TABLE `vehicle_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicleId` int(10) NOT NULL,
  `serviceDate` date NOT NULL,
  `serviceType` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK_vehicle_service` (`vehicleId`),
  CONSTRAINT `FK_vehicle_service` FOREIGN KEY (`vehicleId`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vehicle_service` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
