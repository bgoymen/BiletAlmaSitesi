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

-- tablo yapısı dökülüyor biletal.document
CREATE TABLE IF NOT EXISTS `document` (
  `user_id` int(10) unsigned NOT NULL,
  `filePath` varchar(500) NOT NULL DEFAULT '',
  `fileName` varchar(100) NOT NULL DEFAULT '',
  `fileType` varchar(50) NOT NULL DEFAULT '',
  KEY `user_id_doc_fk` (`user_id`),
  CONSTRAINT `user_id_doc_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- biletal.document: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `document`;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.haberler
CREATE TABLE IF NOT EXISTS `haberler` (
  `haber_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Haber` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`haber_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- biletal.haberler: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `haberler`;
/*!40000 ALTER TABLE `haberler` DISABLE KEYS */;
INSERT INTO `haberler` (`haber_id`, `Haber`) VALUES
	(1, 'adana sahilleri'),
	(2, 'Sitemize Haberler Bölümü Eklendi ve yenilendi'),
	(3, 'Beydagi firmasinda %50 indirim var');
/*!40000 ALTER TABLE `haberler` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.iletisim
CREATE TABLE IF NOT EXISTS `iletisim` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) DEFAULT NULL,
  `Baslik` varchar(50) DEFAULT NULL,
  `Konu` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- biletal.iletisim: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `iletisim`;
/*!40000 ALTER TABLE `iletisim` DISABLE KEYS */;
INSERT INTO `iletisim` (`id`, `mail`, `Baslik`, `Konu`) VALUES
	(1, 'den', ' den', 'den'),
	(2, 'as', 'as', 'as');
/*!40000 ALTER TABLE `iletisim` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.otobus_firmalari
CREATE TABLE IF NOT EXISTS `otobus_firmalari` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

-- biletal.otobus_firmalari: ~25 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `otobus_firmalari`;
/*!40000 ALTER TABLE `otobus_firmalari` DISABLE KEYS */;
INSERT INTO `otobus_firmalari` (`id`, `Name`) VALUES
	(0, '0'),
	(1, 'Beydagi'),
	(2, 'KamilKoc'),
	(3, 'Pamukkale Turizm'),
	(4, 'Astor'),
	(5, 'Sec'),
	(6, 'Ben'),
	(7, 'Cizre Nur'),
	(8, 'Cesur Bingol'),
	(9, 'Yeni Adana'),
	(10, 'Pamukkale'),
	(11, 'Varan Turizm'),
	(12, 'Uusoy Turzim'),
	(13, 'Nilufer Turizm'),
	(14, 'Efe Tur'),
	(15, 'OzKaymak'),
	(16, 'Balikesir Uludag'),
	(17, 'Zafer'),
	(18, 'Best Van'),
	(19, 'Malatya Medine Turizm'),
	(20, 'Istanbul Kalesi'),
	(21, 'Findikli Toros'),
	(22, 'Ben Turizm'),
	(23, 'Suha Turizm'),
	(24, 'Ozlem Diyarbakir');
/*!40000 ALTER TABLE `otobus_firmalari` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.otobus_seferleri
CREATE TABLE IF NOT EXISTS `otobus_seferleri` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firma_id` int(10) unsigned NOT NULL DEFAULT 0,
  `kalkis_nok` int(10) unsigned NOT NULL DEFAULT 0,
  `varis_nok` int(10) unsigned NOT NULL DEFAULT 0,
  `koltuk_sayisi` int(10) unsigned NOT NULL DEFAULT 10,
  `fiyat` int(10) unsigned NOT NULL DEFAULT 20,
  PRIMARY KEY (`id`),
  KEY `firma_id_fk` (`firma_id`),
  KEY `kalkis_nok_fk` (`kalkis_nok`),
  KEY `varis_nok_fk` (`varis_nok`),
  CONSTRAINT `firma_id_fk` FOREIGN KEY (`firma_id`) REFERENCES `otobus_firmalari` (`id`),
  CONSTRAINT `kalkis_nok_fk` FOREIGN KEY (`kalkis_nok`) REFERENCES `sehirler` (`id`),
  CONSTRAINT `varis_nok_fk` FOREIGN KEY (`varis_nok`) REFERENCES `sehirler` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- biletal.otobus_seferleri: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `otobus_seferleri`;
/*!40000 ALTER TABLE `otobus_seferleri` DISABLE KEYS */;
INSERT INTO `otobus_seferleri` (`id`, `firma_id`, `kalkis_nok`, `varis_nok`, `koltuk_sayisi`, `fiyat`) VALUES
	(0, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `otobus_seferleri` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.satin_alinan_bilet
CREATE TABLE IF NOT EXISTS `satin_alinan_bilet` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT 0,
  `seyehat_turu` int(10) unsigned NOT NULL DEFAULT 0,
  `otobus_seferleri_id` int(10) unsigned NOT NULL DEFAULT 0,
  `ucak_seferleri_id` int(10) unsigned NOT NULL DEFAULT 0,
  `tren_seferleri_id` int(10) unsigned NOT NULL,
  `koltuk_no` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `otous_sefer` (`otobus_seferleri_id`),
  KEY `ucak_sefer` (`ucak_seferleri_id`),
  KEY `tren_Sefer` (`tren_seferleri_id`),
  CONSTRAINT `otous_sefer` FOREIGN KEY (`otobus_seferleri_id`) REFERENCES `otobus_seferleri` (`id`),
  CONSTRAINT `tren_Sefer` FOREIGN KEY (`tren_seferleri_id`) REFERENCES `tren_seferleri` (`id`),
  CONSTRAINT `ucak_sefer` FOREIGN KEY (`ucak_seferleri_id`) REFERENCES `ucak_seferleri` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

-- biletal.satin_alinan_bilet: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `satin_alinan_bilet`;
/*!40000 ALTER TABLE `satin_alinan_bilet` DISABLE KEYS */;
/*!40000 ALTER TABLE `satin_alinan_bilet` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.sehirler
CREATE TABLE IF NOT EXISTS `sehirler` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

-- biletal.sehirler: ~82 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `sehirler`;
/*!40000 ALTER TABLE `sehirler` DISABLE KEYS */;
INSERT INTO `sehirler` (`id`, `Name`) VALUES
	(0, '0'),
	(1, 'Adana'),
	(2, 'Adiyaman'),
	(3, 'Afyonkarahisar'),
	(4, 'Agri'),
	(5, 'Aksaray'),
	(6, 'Amasya'),
	(7, 'Ankara'),
	(8, 'Antalya'),
	(9, 'Ardahan'),
	(10, 'Artvin'),
	(11, 'Aydin'),
	(12, 'Balikesir'),
	(13, 'Bartin'),
	(14, 'Batman'),
	(15, 'Bayburt'),
	(16, 'Bilecik'),
	(17, 'Bingol'),
	(18, 'Bitlis'),
	(19, 'Bolu'),
	(20, 'Burdur'),
	(21, 'Bursa'),
	(22, 'Canakkale'),
	(23, 'Cankiri'),
	(24, 'Corum'),
	(25, 'Denizli'),
	(26, 'DiyarBakir'),
	(27, 'Düzce'),
	(28, 'Edirne'),
	(29, 'Elazig'),
	(30, 'Erzincan'),
	(31, 'Erzurum'),
	(32, 'Eskisehir'),
	(33, 'Gaziantep'),
	(34, 'Giresun'),
	(35, 'Gumushane'),
	(36, 'Hakkari'),
	(37, 'Hatay'),
	(38, 'Igdir'),
	(39, 'Isparta'),
	(40, 'Istanbul'),
	(41, 'Izmir'),
	(42, 'Kahramanmaras'),
	(43, 'Karabuk'),
	(44, 'Karaman'),
	(45, 'Kars'),
	(46, 'Kastamonu'),
	(47, 'Kayseri'),
	(48, 'Kirkkale'),
	(49, 'Kirklareli'),
	(50, 'Kirsehir'),
	(51, 'Kilis'),
	(52, 'Kocaeli'),
	(53, 'Konya'),
	(54, 'Kutahya'),
	(55, 'Malatya'),
	(56, 'Manisa'),
	(57, 'Mardin'),
	(58, 'Mersin'),
	(59, 'Mugla'),
	(60, 'Mus'),
	(61, 'Nevsehir'),
	(62, 'Nigde'),
	(63, 'Ordu'),
	(64, 'Osmaniye'),
	(65, 'Rize'),
	(66, 'Sakarya'),
	(67, 'Samsun'),
	(68, 'Siirt'),
	(69, 'Sinop'),
	(70, 'Sivas'),
	(71, 'Sanliurfa'),
	(72, 'Sirnak'),
	(73, 'Tekirdag'),
	(74, 'Tokat'),
	(75, 'Trabzon'),
	(76, 'Tunceli'),
	(77, 'Usak'),
	(78, 'Van'),
	(79, 'Yalova'),
	(80, 'Yozgat'),
	(81, 'Zonguldak');
/*!40000 ALTER TABLE `sehirler` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.tren_firmalari
CREATE TABLE IF NOT EXISTS `tren_firmalari` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- biletal.tren_firmalari: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `tren_firmalari`;
/*!40000 ALTER TABLE `tren_firmalari` DISABLE KEYS */;
INSERT INTO `tren_firmalari` (`id`, `Name`) VALUES
	(0, '0'),
	(1, 'KamilKoç'),
	(2, 'Deneme yenielndi'),
	(3, 'ACDD'),
	(4, 'Tren'),
	(5, 'Ankara Tren'),
	(6, 'TCDD');
/*!40000 ALTER TABLE `tren_firmalari` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.tren_seferleri
CREATE TABLE IF NOT EXISTS `tren_seferleri` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tren_firma_id` int(10) unsigned NOT NULL,
  `kalkis_nok` int(10) unsigned NOT NULL,
  `varis_nok` int(10) unsigned NOT NULL,
  `koltuk_sayisi` int(10) unsigned NOT NULL DEFAULT 10,
  `fiyat` int(10) unsigned NOT NULL DEFAULT 20,
  PRIMARY KEY (`id`),
  KEY `tren_firma_id` (`tren_firma_id`),
  KEY `varis_n` (`varis_nok`),
  KEY `kalkis_n` (`kalkis_nok`),
  CONSTRAINT `kalkis_n` FOREIGN KEY (`kalkis_nok`) REFERENCES `sehirler` (`id`),
  CONSTRAINT `tren_firma_id` FOREIGN KEY (`tren_firma_id`) REFERENCES `tren_firmalari` (`id`),
  CONSTRAINT `varis_n` FOREIGN KEY (`varis_nok`) REFERENCES `sehirler` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- biletal.tren_seferleri: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `tren_seferleri`;
/*!40000 ALTER TABLE `tren_seferleri` DISABLE KEYS */;
INSERT INTO `tren_seferleri` (`id`, `tren_firma_id`, `kalkis_nok`, `varis_nok`, `koltuk_sayisi`, `fiyat`) VALUES
	(0, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `tren_seferleri` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.ucak_firmalari
CREATE TABLE IF NOT EXISTS `ucak_firmalari` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- biletal.ucak_firmalari: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `ucak_firmalari`;
/*!40000 ALTER TABLE `ucak_firmalari` DISABLE KEYS */;
INSERT INTO `ucak_firmalari` (`id`, `Name`) VALUES
	(0, '0'),
	(1, 'THY yeni'),
	(2, 'Pegasus'),
	(3, 'Anadolu Jet'),
	(4, 'Atlas Global'),
	(5, 'Ajax');
/*!40000 ALTER TABLE `ucak_firmalari` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.ucak_seferleri
CREATE TABLE IF NOT EXISTS `ucak_seferleri` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ucak_firma_id` int(10) unsigned NOT NULL,
  `kalkis_nok` int(10) unsigned NOT NULL,
  `varis_nok` int(10) unsigned NOT NULL,
  `koltuk_sayisi` int(10) unsigned NOT NULL DEFAULT 10,
  `fiyat` int(10) unsigned NOT NULL DEFAULT 20,
  PRIMARY KEY (`id`),
  KEY `ucak_firma_id` (`ucak_firma_id`),
  KEY `kalkis_nok` (`kalkis_nok`),
  KEY `varis_nok` (`varis_nok`),
  CONSTRAINT `kalkis_nok` FOREIGN KEY (`kalkis_nok`) REFERENCES `sehirler` (`id`),
  CONSTRAINT `ucak_firma_id` FOREIGN KEY (`ucak_firma_id`) REFERENCES `ucak_firmalari` (`id`),
  CONSTRAINT `varis_nok` FOREIGN KEY (`varis_nok`) REFERENCES `sehirler` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- biletal.ucak_seferleri: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `ucak_seferleri`;
/*!40000 ALTER TABLE `ucak_seferleri` DISABLE KEYS */;
INSERT INTO `ucak_seferleri` (`id`, `ucak_firma_id`, `kalkis_nok`, `varis_nok`, `koltuk_sayisi`, `fiyat`) VALUES
	(0, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `ucak_seferleri` ENABLE KEYS */;

-- tablo yapısı dökülüyor biletal.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_mail` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `type` int(11) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

-- biletal.users: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `user_mail`, `user_name`, `user_password`, `type`) VALUES
	(1, 'admin@gmail.com', 'admin', 'admin', 1),
	(2, 'antepli@gmail.com', 'antepli', 'antepli', 0),
	(3, 'yeni@gmail.com', 'yeni', 'yeni', 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
