
CREATE TABLE `user` (
                        `user_id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(50) NOT NULL,
                        `password` varchar(50) NOT NULL,
                        `email` varchar(100) NOT NULL,
                        `create_time` datetime DEFAULT NULL,
                        `update_time` datetime DEFAULT NULL,
                        PRIMARY KEY (`user_id`),
                        UNIQUE KEY `username` (`username`),
                        UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `account` (
                           `account_id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int NOT NULL,
                           `name` varchar(100) NOT NULL,
                           `type` varchar(50) NOT NULL,
                           `balance` decimal(10,2) NOT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_time` datetime DEFAULT NULL,
                           PRIMARY KEY (`account_id`),
                           KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `transaction` (
                               `transaction_id` int NOT NULL AUTO_INCREMENT,
                               `account_id` int NOT NULL,
                               `amount` decimal(10,2) NOT NULL,
                               `currency` varchar(10) NOT NULL,
                               `description` varchar(200) DEFAULT NULL,
                               `transaction_time` datetime NOT NULL,
                               `create_time` datetime DEFAULT NULL,
                               `update_time` datetime DEFAULT NULL,
                               PRIMARY KEY (`transaction_id`),
                               KEY `account_id` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tag` (
                       `tag_id` int NOT NULL AUTO_INCREMENT,
                       `user_id` int DEFAULT NULL,
                       `name` varchar(50) NOT NULL,
                       `create_time` datetime DEFAULT NULL,
                       `update_time` datetime DEFAULT NULL,
                       PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `currency` (
                            `currency_id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(50) NOT NULL,
                            `symbol` varchar(10) NOT NULL,
                            `rate` decimal(10,2) NOT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `update_time` datetime DEFAULT NULL,
                            PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `transaction_tag` (
                                   `transaction_id` int NOT NULL,
                                   `tag_id` int NOT NULL,
                                   `create_time` datetime DEFAULT NULL,
                                   `update_time` datetime DEFAULT NULL,
                                   PRIMARY KEY (`transaction_id`,`tag_id`),
                                   KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;