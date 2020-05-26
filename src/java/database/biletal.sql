-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- biletal için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `biletal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `biletal`;

-- tablo yapısı dökülüyor biletal.haberler
CREATE TABLE IF NOT EXISTS `haberler` (
  `haber_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Haber` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`haber_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- biletal.haberler: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `haberler`;
/*!40000 ALTER TABLE `haberler` DISABLE KEYS */;
INSERT INTO `haberler` (`haber_id`, `Haber`) VALUES
	(2, 'adana sahilleri'),
	(4, 'yeni bir haber ekliyorum 8768963');
/*!40000 ALTER TABLE `haberler` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.iletisim
CREATE TABLE IF NOT EXISTS `iletisim` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) DEFAULT NULL,
  `Baslik` varchar(50) DEFAULT NULL,
  `Konu` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- biletal.iletisim: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `iletisim`;
/*!40000 ALTER TABLE `iletisim` DISABLE KEYS */;
INSERT INTO `iletisim` (`id`, `mail`, `Baslik`, `Konu`) VALUES
	(1, 'den', ' den', 'den'),
	(2, 'as', 'as', 'as'),
	(3, 'as', '', 'as'),
	(4, 'ad', 'sad', 'ad'),
	(5, 'sasas', 'sasa', 'sasa'),
	(6, 'asdsfsdaga<s', 'gsdgsegsrg', 'fsdzfgsdgsz');
/*!40000 ALTER TABLE `iletisim` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.otobus_firmalari
CREATE TABLE IF NOT EXISTS `otobus_firmalari` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.otobus_firmalari: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `otobus_firmalari`;
/*!40000 ALTER TABLE `otobus_firmalari` DISABLE KEYS */;
/*!40000 ALTER TABLE `otobus_firmalari` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.otobus_seferleri
CREATE TABLE IF NOT EXISTS `otobus_seferleri` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firma_id` int(10) unsigned NOT NULL DEFAULT 0,
  `kalkis_nok` varchar(50) DEFAULT NULL,
  `varis_nok` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `firma_id_fk` (`firma_id`),
  CONSTRAINT `firma_id_fk` FOREIGN KEY (`firma_id`) REFERENCES `otobus_firmalari` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.otobus_seferleri: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `otobus_seferleri`;
/*!40000 ALTER TABLE `otobus_seferleri` DISABLE KEYS */;
/*!40000 ALTER TABLE `otobus_seferleri` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.satin_alinan_bilet
CREATE TABLE IF NOT EXISTS `satin_alinan_bilet` (
  `satin_alinan_bilet` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`satin_alinan_bilet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.satin_alinan_bilet: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `satin_alinan_bilet`;
/*!40000 ALTER TABLE `satin_alinan_bilet` DISABLE KEYS */;
/*!40000 ALTER TABLE `satin_alinan_bilet` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.tren_firmalari
CREATE TABLE IF NOT EXISTS `tren_firmalari` (
  `firma_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`firma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.tren_firmalari: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `tren_firmalari`;
/*!40000 ALTER TABLE `tren_firmalari` DISABLE KEYS */;
/*!40000 ALTER TABLE `tren_firmalari` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.tren_seferleri
CREATE TABLE IF NOT EXISTS `tren_seferleri` (
  `tren_sefer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tren_firma_id` int(10) unsigned NOT NULL,
  `kalkis_nok` varchar(50) DEFAULT NULL,
  `varis_nok` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tren_sefer_id`),
  KEY `tren_firma_fk` (`tren_firma_id`),
  CONSTRAINT `tren_firma_fk` FOREIGN KEY (`tren_firma_id`) REFERENCES `tren_firmalari` (`firma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.tren_seferleri: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `tren_seferleri`;
/*!40000 ALTER TABLE `tren_seferleri` DISABLE KEYS */;
/*!40000 ALTER TABLE `tren_seferleri` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.ucak_firmalari
CREATE TABLE IF NOT EXISTS `ucak_firmalari` (
  `firma_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`firma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.ucak_firmalari: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `ucak_firmalari`;
/*!40000 ALTER TABLE `ucak_firmalari` DISABLE KEYS */;
/*!40000 ALTER TABLE `ucak_firmalari` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.ucak_seferleri
CREATE TABLE IF NOT EXISTS `ucak_seferleri` (
  `ucak_sefer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ucak_firma_id` int(10) unsigned NOT NULL DEFAULT 0,
  `kalkis_nok` varchar(50) DEFAULT NULL,
  `varis_nok` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ucak_sefer_id`),
  KEY `ucak_firma_id` (`ucak_firma_id`),
  CONSTRAINT `ucak_firma_id` FOREIGN KEY (`ucak_firma_id`) REFERENCES `ucak_firmalari` (`firma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.ucak_seferleri: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `ucak_seferleri`;
/*!40000 ALTER TABLE `ucak_seferleri` DISABLE KEYS */;
/*!40000 ALTER TABLE `ucak_seferleri` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_mail` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `type` int(11) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- biletal.users: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `user_mail`, `user_name`, `user_password`, `type`) VALUES
	(1, 'admin@gmail.com', 'admin', 'admin', 1),
	(3, 'istedigimmail@gmail.com', 'istedigimkullaiciadi', 'istedigimsifre', 0),
	(4, 'yenilendi5', ' yenilendi6', 'yenilendi7', 0),
	(5, 'antepli@gmail.com', 'antepli', 'antepli123', 0),
	(18, 'bgoymen35', 'bgoymen22', 'bgoymen23', 0),
	(21, 'deneme', 'deneme', 'deneme', 0),
	(22, 'deneme3', 'deneme3', 'deneme3', 0),
	(23, 'ssadssdgdfhdzfhz', 'ffdhdfhs', 'hfdhdhdhz', 0),
	(24, 'bg@gmail.com', '28', '2828', 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
