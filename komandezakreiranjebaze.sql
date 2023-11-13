/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.25-MariaDB : Database - projsoft
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projsoft` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `projsoft`;

/*Table structure for table `nastavnik` */

DROP TABLE IF EXISTS `nastavnik`;

CREATE TABLE `nastavnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `zvanje_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `zvanje_id` (`zvanje_id`),
  CONSTRAINT `nastavnik_ibfk_1` FOREIGN KEY (`zvanje_id`) REFERENCES `zvanje` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

/*Data for the table `nastavnik` */

insert  into `nastavnik`(`id`,`ime`,`prezime`,`zvanje_id`) values 
(1,'andragog','gungar',1),
(2,'bibar','bibic',1),
(3,'mulahita','babic',3),
(4,'amalgam','bibic',2),
(5,'hamdala','bibic',2),
(6,'gungula ','cecenic',3),
(7,'mulahit','gigic',3),
(8,'mulahita','guzoni',5),
(9,'aftamil','babic',4),
(10,'mulafet','babic',4),
(11,'mulafet','ganganic',4),
(12,'gungula','ganganic',5),
(13,'gigonga','ganganic',5),
(14,'gospodindan','babic',5),
(16,'gospodin gungula','babic',3),
(24,'giga','giiiigaaaaaaaaaaaaa',3),
(29,'a','b',2),
(31,'gungala','gagac',2),
(32,'gungala','gagac',3),
(33,'gungala','gagac',5);

/*Table structure for table `predmet` */

DROP TABLE IF EXISTS `predmet`;

CREATE TABLE `predmet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `espb` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `predmet` */

insert  into `predmet`(`id`,`naziv`,`espb`) values 
(1,'matematika 1',6),
(2,'matematika 2',6),
(3,'matematika 3',6),
(4,'prog 1',4),
(5,'prog 2',4),
(6,'prog 3',4),
(7,'OI1',6),
(8,'OI2',6),
(9,'Engleski 1',5),
(10,'Engleski 2',4),
(11,'Engleski 3',4);

/*Table structure for table `zvanje` */

DROP TABLE IF EXISTS `zvanje`;

CREATE TABLE `zvanje` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `zvanje` */

insert  into `zvanje`(`id`,`naziv`) values 
(1,'asistent'),
(2,'asistent_sa_doktoratom'),
(3,'docent'),
(4,'vanredni_profesor'),
(5,'redovni_profesor');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
