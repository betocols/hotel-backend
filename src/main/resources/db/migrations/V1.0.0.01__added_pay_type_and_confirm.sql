--
-- Table structure for table `hotel`
--
CREATE TABLE `pay_type` (
  `pay_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_type` varchar(255) NOT NULL,
  PRIMARY KEY (`pay_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `hotel_chain`
--
CREATE TABLE `confirm` (
  `confirm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pay_type_id` bigint(20) NOT NULL,
  `confirmation_number` VARCHAR(255) NOT NULL,
  `bank` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`confirm_id`),
  KEY `FK_pay_type_id` (`pay_type_id`),
  CONSTRAINT `FK_pay_type_id_reference` FOREIGN KEY (`pay_type_id`) REFERENCES `pay_type` (`pay_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
