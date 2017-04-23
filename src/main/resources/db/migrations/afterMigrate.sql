DELETE FROM  `reservation`;
DELETE FROM  `room_image`;
DELETE FROM  `room`;
DELETE FROM  `hotel_image`;
DELETE FROM  `hotel`;
DELETE FROM  `hotel_chain`;
DELETE FROM  `account`;
DELETE FROM  `image`;
DELETE FROM  `room_type`;
DELETE FROM  `pay_type`;
DELETE FROM  `confirm`;

--
-- Inserting default room types
--
INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (1, 'SINGLE ROOM', 1500, 1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (2, 'DOUBLE ROOM', 2000, 1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (3, 'TRIPLE ROOM', 3000, 1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (4, 'SUITE', 3500, 2, TRUE, TRUE , TRUE , TRUE);


INSERT INTO `image` (`image_id`, `path`) VALUES (1, '/upmLogo.jpg');
INSERT INTO `image` (`image_id`, `path`) VALUES (2, '/upmLogo.jpg');
INSERT INTO `image` (`image_id`, `path`) VALUES (3, '/upmLogo.jpg');

INSERT INTO `account` (`account_number`, `account_name`, `concept`) VALUES (1, 'SomeAccount', 'SomeConcept');

INSERT INTO `hotel_chain` (`hotel_chain_id`,`hotel_chain_name`, `logo_id`) VALUES (1, 'The UPM Hotels', 1);

INSERT INTO `hotel` (`hotel_id`,`hotel_name`,`address_line`, `city`, `province`, `zip_code`, `hotel_chain_id`)
VALUES (1, 'UPM Sur', 'Sol, 43', 'Madrid', 'Madrid', '25008', 1);

INSERT INTO `hotel_image` (`hotel_image_id`, `hotel_id`, `image_id`)
VALUES (1, 1, 1);

INSERT INTO `room` (`room_id`, `hotel_id`, `room_type_id`, `room_number`, `single_beds`, `double_beds`, `queen_beds`, `king_beds`)
VALUES (1, 1, 1, '404', 1, 0, 0, 0);

INSERT INTO `reservation` (`id`, `person_count`, `reservation_code`, `room_id`)
VALUES (1, 1, 'SMEKDN2MC', 1);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (1,1,2);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (2,1,3);

INSERT INTO `pay_type` (`pay_type_id`, `pay_type`)
VALUES (1,'Transfer');

INSERT INTO `pay_type` (`pay_type_id`, `pay_type`)
VALUES (2,'Credit Card');

INSERT INTO `pay_type` (`pay_type_id`, `pay_type`)
VALUES (3,'Debit Card');


