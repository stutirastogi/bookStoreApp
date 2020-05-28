create database book_store;
use book_store;

CREATE TABLE `book` (
`isbn` bigint NOT NULL,
`title` varchar(150) NOT NULL, 
`author` varchar(100) NOT NULL,
`price` float NOT NULL, 
`available_copies` int NOT NULL DEFAULT '1',
`created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`isbn`),
KEY `titleIndex` (`title`), 
KEY `authorIndex` (`author`));
