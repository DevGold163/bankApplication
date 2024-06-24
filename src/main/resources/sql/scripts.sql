-- Create the eazybank database
CREATE DATABASE eazybank;

-- Select the eazybank database for use
USE eazybank;




CREATE TABLE `eazybank`.`customer` (
                                    `id` INT NOT NULL AUTO_INCREMENT,
                                    `email` VARCHAR(45) NOT NULL,
                                    `pwd` VARCHAR(200) NOT NULL,
                                    `role` VARCHAR(45) NOT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

Insert into 'customer' ('email','pwd','role') VALUES ('rajsonawala2023@gmail.com','12345','admin');