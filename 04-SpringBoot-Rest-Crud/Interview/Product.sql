CREATE DATABASE  IF NOT EXISTS `product_directory`;
USE `product_directory`;


DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
   `product_amount` int DEFAULT NULL,
   PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `product` VALUES 
	(1,500),
	(2,1500),
	(3,5000);

