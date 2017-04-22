--
-- Table structure for table `account`
--
CREATE TABLE `account` (
  `account_number` bigint(20) NOT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `concept` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `image`
--
CREATE TABLE `image` (
  `image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `hotel_chain`
--
CREATE TABLE `hotel_chain` (
  `hotel_chain_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotel_chain_name` varchar(255) NOT NULL,
  `logo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`hotel_chain_id`),
  KEY `FK_logo_id` (`logo_id`),
  CONSTRAINT `FK_logo_id_reference` FOREIGN KEY (`logo_id`) REFERENCES `image` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `hotel`
--
CREATE TABLE `hotel` (
  `hotel_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_line` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `hotel_name` varchar(255) NOT NULL,
  `province` varchar(255) NOT NULL,
  `zip_code` varchar(255) NOT NULL,
  `hotel_chain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`),
  KEY `FK_hotel_chain_id` (`hotel_chain_id`),
  CONSTRAINT `FK_hotel_chain_reference` FOREIGN KEY (`hotel_chain_id`) REFERENCES `hotel_chain` (`hotel_chain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `hotel_image`
--
CREATE TABLE `hotel_image` (
  `hotel_image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotel_id` bigint(20) DEFAULT NULL,
  `image_id` bigint(20) NOT NULL,
  PRIMARY KEY (`hotel_image_id`),
  KEY `FKiuq13w6lvo454kujxup6icb0n` (`image_id`),
  KEY `FK293ve9b0ocbfji4u5hl2oh3ks` (`hotel_id`),
  CONSTRAINT `FK293ve9b0ocbfji4u5hl2oh3ks` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`),
  CONSTRAINT `FKiuq13w6lvo454kujxup6icb0n` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `room_type`
--
CREATE TABLE `room_type` (
  `room_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bathrooms` bigint(20) NOT NULL,
  `has_air_conditioning` bit(1) NOT NULL,
  `has_heating` bit(1) NOT NULL,
  `has_tv` bit(1) NOT NULL,
  `has_wifi` bit(1) NOT NULL,
  `price` double NOT NULL,
  `room_type` varchar(255) NOT NULL,
  PRIMARY KEY (`room_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `room`
--
CREATE TABLE `room` (
  `room_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `double_beds` bigint(20) NOT NULL,
  `king_beds` bigint(20) NOT NULL,
  `queen_beds` bigint(20) NOT NULL,
  `room_number` varchar(255) NOT NULL,
  `single_beds` bigint(20) NOT NULL,
  `hotel_id` bigint(20) NOT NULL,
  `room_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_id`),
  UNIQUE KEY `UK4ebdthvd3ohrurfgtgul0ao7w` (`hotel_id`,`room_number`),
  KEY `FKd468eq7j1cbue8mk20qfrj5et` (`room_type_id`),
  CONSTRAINT `FKd468eq7j1cbue8mk20qfrj5et` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`),
  CONSTRAINT `FKdosq3ww4h9m2osim6o0lugng8` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `room_image`
--
CREATE TABLE `room_image` (
  `room_image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_id` bigint(20) DEFAULT NULL,
  `image_id` bigint(20) NOT NULL,
  PRIMARY KEY (`room_image_id`),
  KEY `FKgx4h8l17jolj9ndd26dnqoo5w` (`image_id`),
  CONSTRAINT `FKgx4h8l17jolj9ndd26dnqoo5w` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `reservation`
--
CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `person_count` bigint(20) NOT NULL,
  `reservation_code` varchar(255) NOT NULL,
  `room_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b16r178jxqqmyfum9swkjtri9` (`reservation_code`),
  KEY `FKm8xumi0g23038cw32oiva2ymw` (`room_id`),
  CONSTRAINT `FKm8xumi0g23038cw32oiva2ymw` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Inserting default room types
--
INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (1, 'SINGLE ROOM', 1500, 1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (2, 'DOUBLE ROOM', 2000, 1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (3, 'SUITE', 3500, 2, TRUE, TRUE , TRUE , TRUE);