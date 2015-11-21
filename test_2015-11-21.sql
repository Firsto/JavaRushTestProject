# ************************************************************
# Sequel Pro SQL dump
# Версия 4499
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Адрес: 127.0.0.1 (MySQL 5.7.9)
# Схема: test
# Время создания: 2015-11-21 15:46:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Дамп таблицы User
# ------------------------------------------------------------

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `age` int(11) NOT NULL DEFAULT '0',
  `isAdmin` bit(1) NOT NULL DEFAULT b'0',
  `createdDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;

INSERT INTO `User` (`id`, `name`, `age`, `isAdmin`, `createdDate`)
VALUES
	(1,'First',25,10000000,'2015-11-21 12:58:32'),
	(2,'Second',100,00000000,'2015-11-21 19:26:51'),
	(3,'New User',10,00000000,'2015-11-21 20:15:26'),
	(4,'bob',34,00000000,'2015-11-21 20:15:48'),
	(5,'Anonymous',0,00000000,'2015-11-21 20:17:50'),
	(11,'Anonymous',0,00000000,'2015-11-21 21:59:34'),
	(12,'Anonymous',0,00000000,'2015-11-21 21:59:37'),
	(13,'Blablabla',23,10000000,'2015-11-21 21:59:45'),
	(14,'Anonymous',0,00000000,'2015-11-21 22:11:07'),
	(15,'New User',10,00000000,'2015-11-21 22:20:29'),
	(16,'Blablabla',23,10000000,'2015-11-21 22:20:37'),
	(17,'Blablabla',23,10000000,'2015-11-21 22:20:41'),
	(18,'Blablabla222222222',23,10000000,'2015-11-21 22:20:46'),
	(19,'Blablabla',232,00000000,'2015-11-21 22:20:49');

/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
