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

INSERT INTO book VALUES(121, "t1", "author1", 100, 3);
INSERT INTO book VALUES(122, "t2", "author2", 150, 3);
INSERT INTO book VALUES(123, "t3", "author3", 200, 2);
INSERT INTO book VALUES(124, "t4", "author4", 350, 1);
INSERT INTO book VALUES(125, "t5", "author5", 400, 3);
