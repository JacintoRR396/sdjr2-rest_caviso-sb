--
-- Table structure for table `address`
--
DROP TABLE IF EXISTS `address`;

CREATE TABLE `db_ca_viso`.`address` (
  `id_address` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(80) NOT NULL,
  `number` VARCHAR(10) NOT NULL,
  `town` VARCHAR(60) DEFAULT NULL,
  `city` VARCHAR(40) DEFAULT NULL,
  `country` VARCHAR(40) DEFAULT NULL,
  `postal_code` INT NOT NULL,
  `additional_info` LONGTEXT DEFAULT NULL,
  PRIMARY KEY (`id_address`),
  UNIQUE INDEX `id_address_UNIQUE` (`id_address` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci
COMMENT = 'This table represents the address entity.';


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
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci
COMMENT ='This table represents the contact entity.';
