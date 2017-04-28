DELETE FROM  `reservation`;
DELETE FROM  `room_image`;
DELETE FROM  `room`;
DELETE FROM  `hotel_image`;
DELETE FROM  `hotel`;
DELETE FROM  `hotel_chain`;
DELETE FROM  `account`;
DELETE FROM  `image`;
DELETE FROM  `room_type`;
DELETE FROM  `confirm`;
DELETE FROM  `pay_type`;

--
-- Inserting default room types
--
INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`,`max_persons` ,`bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (1, 'SINGLE ROOM', 1500, 2,1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`,`max_persons`, `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (2, 'DOUBLE ROOM', 2000,2, 1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`,`max_persons` ,`bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (3, 'TRIPLE ROOM', 3000,3, 1, TRUE, TRUE , TRUE , TRUE);

INSERT INTO `room_type` (`room_type_id`, `room_type`, `price`,`max_persons` , `bathrooms`, `has_tv`, `has_wifi`, `has_heating`, `has_air_conditioning`)
VALUES (4, 'SUITE', 3500,4, 2, TRUE, TRUE , TRUE , TRUE);

--
-- Inserting Images
--
INSERT INTO `image` (`image_id`, `path`) VALUES (1, '/upmLogo.jpg');
INSERT INTO `image` (`image_id`, `path`) VALUES (2, '/upmLogo.jpg');
INSERT INTO `image` (`image_id`, `path`) VALUES (3, '/upmLogo.jpg');

--
-- Inserting Accounts
--
INSERT INTO `account` (`account_number`, `account_name`, `concept`) VALUES (1, 'SomeAccount', 'SomeConcept');

--
-- Inserting Chains
--
INSERT INTO `hotel_chain` (`hotel_chain_id`,`hotel_chain_name`, `logo_id`) VALUES (1, 'The UPM Hotels', 1);

--
-- Inserting Hotels
--
INSERT INTO `hotel` (`hotel_id`,`hotel_name`,`address_line`, `city`, `province`, `zip_code`, `hotel_chain_id`)
VALUES (1, 'UPM Sur', 'Sol, 43', 'Madrid', 'Madrid', '28008', 1);

INSERT INTO `hotel` (`hotel_id`,`hotel_name`,`address_line`, `city`, `province`, `zip_code`, `hotel_chain_id`)
VALUES (2, 'UPM Sur 2', 'Sol, 432', 'Madrid', 'Madrid', '28008', 1);

INSERT INTO `hotel` (`hotel_id`,`hotel_name`,`address_line`, `city`, `province`, `zip_code`, `hotel_chain_id`)
VALUES (3, 'UPM Sur 3', 'Sol, 433', 'Madrid', 'Madrid', '28009', 1);

INSERT INTO `hotel` (`hotel_id`,`hotel_name`,`address_line`, `city`, `province`, `zip_code`, `hotel_chain_id`)
VALUES (4, 'UPM Sur 4', 'Sol, 434', 'Madrid', 'Madrid', '28010', 1);

INSERT INTO `hotel` (`hotel_id`,`hotel_name`,`address_line`, `city`, `province`, `zip_code`, `hotel_chain_id`)
VALUES (5, 'UPF Sur 5', 'La Diagonal, 435', 'Barcelona', 'Barcelona', '08001', 1);

--
-- Inserting Hotel Images
--
INSERT INTO `hotel_image` (`hotel_image_id`, `hotel_id`, `image_id`)
VALUES (1, 1, 1);

INSERT INTO `hotel_image` (`hotel_image_id`, `hotel_id`, `image_id`)
VALUES (2, 2, 1);

INSERT INTO `hotel_image` (`hotel_image_id`, `hotel_id`, `image_id`)
VALUES (3, 3, 1);

INSERT INTO `hotel_image` (`hotel_image_id`, `hotel_id`, `image_id`)
VALUES (4, 4, 1);

INSERT INTO `hotel_image` (`hotel_image_id`, `hotel_id`, `image_id`)
VALUES (5, 5, 1);

--
-- Inserting Rooms
--
INSERT INTO `room` (`room_id`, `hotel_id`, `room_type_id`, `room_number`, `single_beds`, `double_beds`, `queen_beds`, `king_beds`)
VALUES (1, 1, 1, '404', 1, 0, 0, 0);

INSERT INTO `room` (`room_id`, `hotel_id`, `room_type_id`, `room_number`, `single_beds`, `double_beds`, `queen_beds`, `king_beds`)
VALUES (2, 2, 2, '4042', 2, 0, 0, 0);

INSERT INTO `room` (`room_id`, `hotel_id`, `room_type_id`, `room_number`, `single_beds`, `double_beds`, `queen_beds`, `king_beds`)
VALUES (3, 3, 3, '4043', 1, 0, 1, 0);

INSERT INTO `room` (`room_id`, `hotel_id`, `room_type_id`, `room_number`, `single_beds`, `double_beds`, `queen_beds`, `king_beds`)
VALUES (4, 5, 4, '4044', 1, 0, 0, 1);

INSERT INTO `room` (`room_id`, `hotel_id`, `room_type_id`, `room_number`, `single_beds`, `double_beds`, `queen_beds`, `king_beds`)
VALUES (5, 5, 2, '4045', 0, 1, 0, 0);

--
-- Inserting Room Images
--
INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (1,1,2);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (2,1,3);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (3,3,2);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (4,4,2);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (5,5,2);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (6,2,2);

--
-- Inserting PayTypes
--
INSERT INTO `pay_type` (`pay_type_id`, `pay_type`)
VALUES (1,'Transfer');

INSERT INTO `pay_type` (`pay_type_id`, `pay_type`)
VALUES (2,'Credit Card');

INSERT INTO `pay_type` (`pay_type_id`, `pay_type`)
VALUES (3,'Debit Card');

--
-- Inserting Confirmations
--
INSERT INTO `confirm` (`confirm_id`, `pay_type_id`, `confirmation_number`, `bank`)
VALUES (1,1,'AGFF23J4', 'BBVA');

--
-- Inserting Reservations
--
INSERT INTO `reservation` (`id`, `person_count`, `reservation_code`, `room_id`, `confirmation_id`)
VALUES (1, 1, 'SMEKDN2MC', 1, 1);


