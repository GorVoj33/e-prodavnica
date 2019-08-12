/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.7.23 : Database - web_shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`web_shop` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `web_shop`;

/*Table structure for table `adresaisporuke` */

DROP TABLE IF EXISTS `adresaisporuke`;

CREATE TABLE `adresaisporuke` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(255) NOT NULL,
  `grad` varchar(255) NOT NULL,
  `postanskiKod` int(11) NOT NULL,
  `profil_profilId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC2D3BDAACB05141F` (`profil_profilId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `adresaisporuke` */

insert  into `adresaisporuke`(`id`,`adresa`,`grad`,`postanskiKod`,`profil_profilId`) values 
(1,'Adresa1','Beograd',11000,1),
(2,'AdminAdresa','Beograd',11000,2),
(4,'a','a',12,4);

/*Table structure for table `artikal` */

DROP TABLE IF EXISTS `artikal`;

CREATE TABLE `artikal` (
  `artikalId` int(11) NOT NULL AUTO_INCREMENT,
  `cenaBezPDV` double NOT NULL,
  `cenaSaPDV` double NOT NULL,
  `kolicinaZaProdaju` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL,
  `opis` varchar(255) NOT NULL,
  `kategorija_id` int(11) NOT NULL,
  `poreska_stopa_id` int(11) NOT NULL,
  PRIMARY KEY (`artikalId`),
  KEY `FK37918190B1B7BC54` (`poreska_stopa_id`),
  KEY `FK3791819026CDC703` (`kategorija_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `artikal` */

insert  into `artikal`(`artikalId`,`cenaBezPDV`,`cenaSaPDV`,`kolicinaZaProdaju`,`naziv`,`opis`,`kategorija_id`,`poreska_stopa_id`) values 
(2,4000,4720,6,'Lampa Uno','Lampa finog dizajna',1,1),
(3,5400,6372,7,'Lampa Italy','Lampa italijanskog dizajna za vas radni sto',1,1),
(4,3500,4130,2,'Lampa Leguro','Nocna lampa za spavacu sobu',1,1),
(5,56000,66080,2,'Trosed Alegro','Trosed modernog dizajna',3,1),
(6,7000,8260,2,'Fotelja Conte','Udobna fotelja, novo u nasoj ponudi',2,1),
(7,8000,9440,2,'Fotelja Karmen','Fotelja engloskog tradicionalnog dizajna',2,1),
(8,78000,92040,3,'Trosed Milano','Udoban veliki trosed idealan za vasu dnevnu sobu',3,1),
(9,93000,109740,4,'Trosed Lester','Veliki udoban trosed finog dizajna',1,1),
(10,68000,80240,3,'Trosed Bon','Veliki udoban trosed',1,1);

/*Table structure for table `authorities` */

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `autoritiesId` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`autoritiesId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `authorities` */

insert  into `authorities`(`autoritiesId`,`authority`,`username`) values 
(1,'ROLE_USER','marko123'),
(2,'ROLE_ADMIN','admin'),
(3,'ROLE_USER','a'),
(4,'ROLE_USER','a');

/*Table structure for table `kategorija` */

DROP TABLE IF EXISTS `kategorija`;

CREATE TABLE `kategorija` (
  `kategorijaId` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `opis` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kategorijaId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `kategorija` */

insert  into `kategorija`(`kategorijaId`,`naziv`,`opis`) values 
(1,'Lampe','Nocne i ukrasne lampe'),
(2,'Fotelje','Fotelje modernog dizajna'),
(3,'Trosedi','Udobni trosedi raznih dimenzija');

/*Table structure for table `korpa` */

DROP TABLE IF EXISTS `korpa`;

CREATE TABLE `korpa` (
  `korpaId` int(11) NOT NULL AUTO_INCREMENT,
  `ukupnaCenaKorpe` double NOT NULL,
  `profil_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`korpaId`),
  KEY `FK45511DF444CEB23` (`profil_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `korpa` */

insert  into `korpa`(`korpaId`,`ukupnaCenaKorpe`,`profil_id`) values 
(1,0,1),
(2,0,2);

/*Table structure for table `narudzbenica` */

DROP TABLE IF EXISTS `narudzbenica`;

CREATE TABLE `narudzbenica` (
  `narudzbenicaId` int(11) NOT NULL AUTO_INCREMENT,
  `datum_kreiranja` date DEFAULT NULL,
  `ukupno` double NOT NULL,
  `adresa_id` int(11) DEFAULT NULL,
  `korpa_id` int(11) DEFAULT NULL,
  `profil_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`narudzbenicaId`),
  KEY `FKC56EC788BFAA7449` (`adresa_id`),
  KEY `FKC56EC788DD5A4951` (`korpa_id`),
  KEY `FKC56EC788444CEB23` (`profil_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Data for the table `narudzbenica` */

insert  into `narudzbenica`(`narudzbenicaId`,`datum_kreiranja`,`ukupno`,`adresa_id`,`korpa_id`,`profil_id`) values 
(27,'2019-07-26',4130,2,2,2),
(18,'2019-07-26',89680,2,2,2);

/*Table structure for table `poreskastopa` */

DROP TABLE IF EXISTS `poreskastopa`;

CREATE TABLE `poreskastopa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `vrednost` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `poreskastopa` */

insert  into `poreskastopa`(`id`,`naziv`,`vrednost`) values 
(1,'Opsta',18),
(2,'Posebna',8);

/*Table structure for table `profil` */

DROP TABLE IF EXISTS `profil`;

CREATE TABLE `profil` (
  `profilId` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` tinyint(1) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `kontakt` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `adresa_id` int(11) DEFAULT NULL,
  `korpa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`profilId`),
  KEY `FK8EFE2A5CBFAA7449` (`adresa_id`),
  KEY `FK8EFE2A5CDD5A4951` (`korpa_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `profil` */

insert  into `profil`(`profilId`,`enabled`,`ime`,`kontakt`,`password`,`prezime`,`username`,`adresa_id`,`korpa_id`) values 
(1,1,'Marko','064321331','marko123','Markovic','marko123',1,1),
(2,1,'Admin','062313213','admin','Adminovic','admin',2,2);

/*Table structure for table `stavka_narudzbenice` */

DROP TABLE IF EXISTS `stavka_narudzbenice`;

CREATE TABLE `stavka_narudzbenice` (
  `stavkaNarudzbeniceId` int(11) NOT NULL AUTO_INCREMENT,
  `kolicina` int(11) NOT NULL,
  `ukupnaCenaStavke` double NOT NULL,
  `artikal_id` int(11) DEFAULT NULL,
  `narudzbenica_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stavkaNarudzbeniceId`),
  KEY `FK613F6E9F79C738E3` (`narudzbenica_id`),
  KEY `FK613F6E9F84BA3DF1` (`artikal_id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

/*Data for the table `stavka_narudzbenice` */

insert  into `stavka_narudzbenice`(`stavkaNarudzbeniceId`,`kolicina`,`ukupnaCenaStavke`,`artikal_id`,`narudzbenica_id`) values 
(32,1,4130,4,27),
(31,1,80240,10,18),
(30,1,9440,7,18);

/*Table structure for table `stavkakorpe` */

DROP TABLE IF EXISTS `stavkakorpe`;

CREATE TABLE `stavkakorpe` (
  `stavkaKorpeId` int(11) NOT NULL AUTO_INCREMENT,
  `kolicina` int(11) NOT NULL,
  `ukupnaCenaStavke` double NOT NULL,
  `artikal_id` int(11) DEFAULT NULL,
  `korpa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stavkaKorpeId`),
  KEY `FKCD3BDF1784BA3DF1` (`artikal_id`),
  KEY `FKCD3BDF17DD5A4951` (`korpa_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `stavkakorpe` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
