CREATE TABLE IF NOT EXISTS `user_tb` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `username` varchar(20) NOT NULL,
    `password` varchar(20) NOT NULL,
    `email` varchar(30) NOT NULL,
    `gender` varchar(6) NOT NULL,
    PRIMARY KEY (`id`)
    );