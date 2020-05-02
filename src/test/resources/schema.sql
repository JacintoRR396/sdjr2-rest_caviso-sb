--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id_contact` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `phone_mobile` varchar(15) DEFAULT NULL,
  `phone_home` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id_contact`),
  UNIQUE KEY `id_contact_UNIQUE` (`id_contact`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `tlf_movil_UNIQUE` (`phone_mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='This table represents the contact entity.';

