-- MySQL dump 10.16  Distrib 10.1.33-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: cuti_db
-- ------------------------------------------------------
-- Server version	10.1.33-MariaDB

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
-- Table structure for table `emailhistori`
--

DROP TABLE IF EXISTS `emailhistori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emailhistori` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `pengirim` varchar(100) DEFAULT NULL,
  `penerima` varchar(100) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailhistori`
--

LOCK TABLES `emailhistori` WRITE;
/*!40000 ALTER TABLE `emailhistori` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailhistori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historicuti`
--

DROP TABLE IF EXISTS `historicuti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historicuti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal_request` date NOT NULL,
  `nik_karyawan` varchar(15) NOT NULL,
  `id_kategoricuti` int(11) NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `status` enum('Disetujuin','Ditolak','Dibatalkan','Submit') NOT NULL,
  `nama_karyawan` varchar(30) NOT NULL,
  `nama_cuti` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicuti`
--

LOCK TABLES `historicuti` WRITE;
/*!40000 ALTER TABLE `historicuti` DISABLE KEYS */;
/*!40000 ALTER TABLE `historicuti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `karyawan`
--

DROP TABLE IF EXISTS `karyawan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `karyawan` (
  `nik` varchar(15) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jenisKelamin` enum('Pria','Wanita') NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `status_pernikahan` enum('Menikah','Cerai','Lajang') NOT NULL,
  `status_kerja` enum('Kontrak','Permanent') NOT NULL,
  `tanggalbergabung` date NOT NULL,
  `tanggalterminate` date DEFAULT NULL,
  `tanggallahir` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `telpon` varchar(15) NOT NULL,
  `status` enum('Aktif','Non Aktif') NOT NULL,
  `atasan_nik` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `karyawan`
--

LOCK TABLES `karyawan` WRITE;
/*!40000 ALTER TABLE `karyawan` DISABLE KEYS */;
INSERT INTO `karyawan` VALUES ('140801221','ABU KHOERUL ISKANDAR ALI','Pria','JL. PETA BARAT NO.60 KALIDERES JAKARTA BARAT','Menikah','Kontrak','2017-08-18',NULL,'1994-12-07','khoirulabhu@gmail.com','081218209581','Aktif','admin'),('140801223','ANGGA MAULANA','Pria','BOGOR','Lajang','Kontrak','2018-09-03',NULL,'2018-09-06','ANGGA@GMAIL.COM','0812128121','Aktif','140801221'),('140801224','Tama','Pria','JL. GP JAKARTA','Lajang','Kontrak','2018-09-04',NULL,'2017-09-04','TAMA@GMAIL.COM','123121212','Aktif','140801221'),('140801225','SOIMAH','Wanita','JAKARTA SELATAN','Lajang','Kontrak','2012-09-18',NULL,'1993-05-18','soimah@gmail.com','081218209581','Aktif','140801221'),('140801226','RARA ELISA MANAPA','Wanita','JAKARTA BARAT','Menikah','Kontrak','2018-10-01',NULL,'1995-04-05','RARA@GMAIL.COM','089675116160','Aktif','140801221'),('admin','Administrator','Pria','xxx','Menikah','Permanent','2018-09-01',NULL,'2018-09-01','xxx','xxx','Aktif','admin');
/*!40000 ALTER TABLE `karyawan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategoricuti`
--

DROP TABLE IF EXISTS `kategoricuti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategoricuti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_cuti` varchar(30) NOT NULL,
  `masa_berlaku` int(4) NOT NULL,
  `deskripsi` varchar(100) DEFAULT NULL,
  `validasi_jk` varchar(10) DEFAULT NULL,
  `validasi_tipemasa` varchar(6) DEFAULT NULL,
  `validasi_masakeerja` int(3) DEFAULT NULL,
  `validasi_status` varchar(10) DEFAULT NULL,
  `status` enum('Aktif','Non Aktif') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nama_cuti` (`nama_cuti`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategoricuti`
--

LOCK TABLES `kategoricuti` WRITE;
/*!40000 ALTER TABLE `kategoricuti` DISABLE KEYS */;
INSERT INTO `kategoricuti` VALUES (1,'Cuti Melahirkan',120,'Bagi Wanita saja','Wanita','Bulan',3,'Kontrak','Aktif'),(2,'Cuti Menikah',7,'Cuti Menikah','All','Bulan',3,'All','Aktif'),(3,'Sakit',2,'Untuk sakit','All','Bulan',3,'All','Aktif'),(4,'Cuti Ibadah Haji',90,'Cuti hanya untuk ibadah haji','All','Tahun',1,'Permanent','Aktif'),(5,'Cuti Hari Ayah',1,'Cuti Hari Ayah','Pria','Tahun',1,'Permanent','Aktif'),(6,'Cuti Umroh',30,'Cuti Umroh','All','Tahun',1,'Permanent','Aktif'),(7,'PATTERNITY',1,'CUTI PATERNITY','Pria','Bulan',3,'All','Aktif');
/*!40000 ALTER TABLE `kategoricuti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter` (
  `id` int(11) NOT NULL,
  `deskripsi` varchar(255) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `isi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter`
--

LOCK TABLES `parameter` WRITE;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` VALUES (1,'Host','MAIL_SMTP_HOST','smtp.gmail.com'),(2,'Port','MAIL_SMTP_PORT','587'),(3,'Auth','MAIL_SMTP_AUTH','true'),(4,'SMTP Sender','MAIL_SMTP_SENDER','khoirulabhu@gmail.com'),(5,'SMTP Sender Password','MAIL_SMTP_PASSWORD','Tia18neida93'),(6,'Subject Cuti','MAIL_SUBJECT_REQUEST_CUTI','Cuti Elektronik Notifikasi'),(7,'Content Request Cuti','MAIL_CONTENT_REQUEST_CUTI','<html><head><style>.colored {color: blue;}#body {font-size: 14px;}</style></head><body><div id=\'body\'><p>Hi {Manager},</p><p class=\'colored\'>This text is blue.</p><p>{Admin}</p> </div></body></html>'),(8,'Content Setujui Cuti','MAIL_CONTENT_APPROVE_CUTI','<html><head><style>.colored {color: blue;}#body {font-size: 14px;}</style></head><body><div id=\'body\'><p>Hi {Karyawan},</p><p class=\'colored\'>Cuti anda telah disetujui, Terimakasih.</p><p>{Admin}</p> </div></body></html>'),(9,'Content Tolak Cuti','MAIL_SUBJECT_TOLAK_CUTI','<html>\r\n  <head>\r\n    <style>\r\n      .colored {\r\n        color: blue;\r\n      }\r\n      #body {\r\n        font-size: 14px;\r\n      }\r\n      @media screen and (min-width: 500px) {\r\n        .colored {\r\n          color:red;\r\n        }\r\n      }\r\n    </style>\r\n  <'),(10,'Content Batal Cuti','MAIL_SUBJECT_BATAL_CUTI','<html>\r\n  <head>\r\n    <style>\r\n      .colored {\r\n        color: blue;\r\n      }\r\n      #body {\r\n        font-size: 14px;\r\n      }\r\n      @media screen and (min-width: 500px) {\r\n        .colored {\r\n          color:red;\r\n        }\r\n      }\r\n    </style>\r\n  <');
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riwayatcuti`
--

DROP TABLE IF EXISTS `riwayatcuti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riwayatcuti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal_request` date NOT NULL,
  `nik_karyawan` varchar(15) DEFAULT NULL,
  `nik_atasan` varchar(15) DEFAULT NULL,
  `status` enum('Disetujui','Ditolak','Dibatalkan','Submit') DEFAULT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `id_kategoricuti` int(11) NOT NULL,
  `tanggalSetuju` date DEFAULT NULL,
  `tanggalTolak` date DEFAULT NULL,
  `tanggalBatal` date DEFAULT NULL,
  `transaksi_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riwayatcuti`
--

LOCK TABLES `riwayatcuti` WRITE;
/*!40000 ALTER TABLE `riwayatcuti` DISABLE KEYS */;
INSERT INTO `riwayatcuti` VALUES (1,'2018-10-07','140801223','140801221','Ditolak','2018-10-17','2018-10-19',3,NULL,'2018-10-09',NULL,1),(2,'2018-10-08','140801223','140801221','Submit','2018-10-08','2018-10-12',2,NULL,NULL,NULL,1),(3,'2018-10-08','140801223','140801221','Submit','2018-10-08','2018-10-11',3,NULL,NULL,NULL,1),(4,'2018-10-08','140801223','140801221','Submit','2018-10-09','2018-10-12',2,NULL,NULL,NULL,1),(5,'2018-10-08','140801223','140801221','Submit','2018-10-09','2018-11-07',6,NULL,NULL,NULL,1),(6,'2018-10-10','140801223','140801221','Submit','2018-10-11','2018-10-12',3,NULL,NULL,NULL,1),(7,'2018-10-21','140801221','admin','Submit','2018-10-10','2018-10-11',3,NULL,NULL,NULL,1),(8,'2018-12-10','140801221','admin','Submit','2018-12-11','2018-12-13',2,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `riwayatcuti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksicuti`
--

DROP TABLE IF EXISTS `transaksicuti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksicuti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal_request` date NOT NULL,
  `nik_karyawan` varchar(15) NOT NULL,
  `id_kategoricuti` int(11) NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `tahun` varchar(4) NOT NULL,
  `status` enum('Disetujui','Ditolak','Dibatalkan','Submit') NOT NULL,
  `atasan_nik` varchar(15) NOT NULL,
  `deskripsi` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `tanggalsetuju` date DEFAULT NULL,
  `tanggaltolak` date DEFAULT NULL,
  `tanggalbatal` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nik_karyawan` (`nik_karyawan`),
  KEY `id_kategoricuti` (`id_kategoricuti`),
  CONSTRAINT `transaksicuti_ibfk_1` FOREIGN KEY (`nik_karyawan`) REFERENCES `karyawan` (`nik`),
  CONSTRAINT `transaksicuti_ibfk_2` FOREIGN KEY (`id_kategoricuti`) REFERENCES `kategoricuti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksicuti`
--

LOCK TABLES `transaksicuti` WRITE;
/*!40000 ALTER TABLE `transaksicuti` DISABLE KEYS */;
INSERT INTO `transaksicuti` VALUES (1,'2018-10-07','140801223',3,'2018-10-17','2018-10-19','2018','Ditolak','140801221','Sakit hati','Tolak',NULL,'2018-10-09',NULL),(2,'2018-10-08','140801223',2,'2018-10-08','2018-10-12','2018','Ditolak','140801221','asdasas','Tolak',NULL,'2018-10-09',NULL),(3,'2018-10-08','140801223',3,'2018-10-08','2018-10-11','2018','Dibatalkan','140801221','kk','Revoked',NULL,NULL,'2018-10-10'),(4,'2018-10-08','140801223',2,'2018-10-09','2018-10-12','2018','Dibatalkan','140801221','Menikah','Revoked',NULL,NULL,'2018-10-09'),(5,'2018-10-08','140801223',6,'2018-10-09','2018-11-07','2018','Dibatalkan','140801221','asadsdasa','Revoked',NULL,NULL,'2018-10-09'),(6,'2018-10-10','140801223',3,'2018-10-11','2018-10-12','2018','Dibatalkan','140801221','Sakit','Revoked by admin',NULL,NULL,'2018-10-21'),(7,'2018-10-21','140801221',3,'2018-10-10','2018-10-11','2018','Submit','admin','kkjbsdkjdsfasdfa','',NULL,NULL,NULL),(8,'2018-12-10','140801221',2,'2018-12-11','2018-12-13','2018','Disetujui','admin','ijniuhbihbuhbu','','2018-12-10',NULL,NULL);
/*!40000 ALTER TABLE `transaksicuti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlogin`
--

DROP TABLE IF EXISTS `userlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlogin` (
  `nik_user` varchar(15) NOT NULL,
  `password_user` varchar(30) NOT NULL,
  `hak_akses` enum('admin','user') NOT NULL,
  `status` enum('Aktif','Tidak aktif') NOT NULL,
  PRIMARY KEY (`nik_user`),
  CONSTRAINT `userlogin_ibfk_1` FOREIGN KEY (`nik_user`) REFERENCES `karyawan` (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlogin`
--

LOCK TABLES `userlogin` WRITE;
/*!40000 ALTER TABLE `userlogin` DISABLE KEYS */;
INSERT INTO `userlogin` VALUES ('140801221','19941207','user','Aktif'),('140801223','20180906','user','Aktif'),('140801224','20170904','user','Aktif'),('admin','admin','admin','Aktif');
/*!40000 ALTER TABLE `userlogin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-10 21:41:37
