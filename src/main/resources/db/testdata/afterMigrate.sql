DELETE FROM  `room_image`;
DELETE FROM  `room`;
DELETE FROM  `hotel_image`;
DELETE FROM  `hotel`;
DELETE FROM  `hotel_chain`;
DELETE FROM  `account`;
DELETE FROM  `image`;


INSERT INTO `image` (`image_id`, `path`) VALUES (1, '/upmLogo.png');
INSERT INTO `image` (`image_id`, `path`) VALUES (2, '/upmLogo.png');
INSERT INTO `image` (`image_id`, `path`) VALUES (3, '/upmLogo.png');

INSERT INTO `account` (`account_number`, `account_name`, `concept`) VALUES (1, 'SomeAccount', 'SomeConcept');

INSERT INTO `hotel_chain` (`hotel_chain_id`,`hotel_chain_name`, `logo_id`) VALUES (1, 'The UPM Hotels', 1);

INSERT INTO `hotel` (`hotel_id`,`hotel_name`,`address_line`, `city`, `province`, `zip_code`, `hotel_chain_id`)
VALUES (1, 'UPM Sur', 'Sol, 43', 'Madrid', 'Madrid', '25008', 1);

INSERT INTO `hotel_image` (`hotel_image_id`, `hotel_id`, `image_id`)
VALUES (1, 1, 1);

INSERT INTO `room` (`room_id`, `hotel_id`, `room_type_id`, `room_number`, `single_beds`, `double_beds`, `queen_beds`, `king_beds`)
VALUES (1, 1, 1, '404', 1, 0, 0, 0);

INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (1,1,2);
INSERT INTO `room_image` (`room_image_id`, `room_id`, `image_id`)
VALUES (2,1,3);


