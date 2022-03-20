CREATE TABLE `menus_rv` (
	`id` int NOT NULL AUTO_INCREMENT,
	`dish_name` varchar(255) NOT NULL,
	`amount` double NOT NULL,
	`start_date` DATE NOT NULL,
	`end_date` DATE NOT NULL,
	`available` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `orders_rv` (
	`id` int NOT NULL AUTO_INCREMENT,
	`dish_id` int NOT NULL,
	`quantity` int NOT NULL,
	`client_name` varchar(255) NOT NULL,
	`client_address` varchar(255) NOT NULL,
	`amount` double NOT NULL,
	`status` varchar(255) NOT NULL,
	`creation_date` DATE NOT NULL,
	`alteration_date` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE menus_rv ADD COLUMN stock int NOT NULL AFTER end_date;

ALTER TABLE orders_rv ADD COLUMN transaction_id varchar(255) NOT NULL AFTER amount;





