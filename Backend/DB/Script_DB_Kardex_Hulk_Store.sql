-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema kardex_hulk_store
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kardex_hulk_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kardex_hulk_store` DEFAULT CHARACTER SET utf8 ;
USE `kardex_hulk_store` ;



-- -----------------------------------------------------
-- Table `kardex_hulk_store`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kardex_hulk_store`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `names` VARCHAR(45) NULL DEFAULT NULL,
  `surnames` VARCHAR(45) NULL DEFAULT NULL,
  `user_name` VARBINARY(255) NULL DEFAULT NULL,
  `password` VARBINARY(255) NULL DEFAULT NULL,
  `date_of_birth` DATETIME NULL DEFAULT NULL,
  `credit_card` VARBINARY(255) NULL DEFAULT NULL,
  `type_credit_card` VARCHAR(1) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `id_roles` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kardex_hulk_store`.`bills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kardex_hulk_store`.`bills` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code_authorization` VARCHAR(45) NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `date_create` DATETIME NULL DEFAULT NULL,
  `date_send_product` DATETIME NULL DEFAULT NULL,
  `is_send` TINYINT(4) NULL DEFAULT NULL,
  `is_pick_up_store` TINYINT(4) NULL DEFAULT NULL,
  `total_value` VARCHAR(45) NULL DEFAULT NULL,
  `user_create` VARCHAR(45) NULL DEFAULT NULL,
  `user_update` VARCHAR(45) NULL DEFAULT NULL,
  `id_user` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bills_users1_idx` (`id_user` ASC) ,
  CONSTRAINT `fk_bills_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `kardex_hulk_store`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kardex_hulk_store`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kardex_hulk_store`.`products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `stock` INT(11) NULL DEFAULT NULL,
  `value` VARBINARY(255) NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `color` VARCHAR(20) NULL DEFAULT NULL,
  `weight` VARCHAR(20) NULL DEFAULT NULL,
  `height` VARCHAR(20) NULL DEFAULT NULL,
  `is_free_send` TINYINT(4) NULL DEFAULT NULL,
  `user_create` VARCHAR(45) NULL DEFAULT NULL,
  `user_update` VARCHAR(45) NULL DEFAULT NULL,
  `date_create` DATETIME NULL DEFAULT NULL,
  `date_update` DATETIME NULL DEFAULT NULL,
  `img` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kardex_hulk_store`.`sales_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kardex_hulk_store`.`sales_products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL DEFAULT NULL,
  `id_products` INT(11) NOT NULL,
  `id_bills` INT(11) NOT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `sub_total` VARCHAR(45) NULL DEFAULT NULL,
  `user_create` VARCHAR(45) NULL DEFAULT NULL,
  `user_update` VARCHAR(45) NULL DEFAULT NULL,
  `date_create` VARCHAR(45) NULL DEFAULT NULL,
  `date_update` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sales_products_products1_idx` (`id_products` ASC) ,
  INDEX `fk_sales_products_bills1_idx` (`id_bills` ASC) ,
  CONSTRAINT `fk_sales_products_bills1`
    FOREIGN KEY (`id_bills`)
    REFERENCES `kardex_hulk_store`.`bills` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sales_products_products1`
    FOREIGN KEY (`id_products`)
    REFERENCES `kardex_hulk_store`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kardex_hulk_store`.`tokens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kardex_hulk_store`.`tokens` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `token` VARBINARY(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tokens_users1_idx` (`id_user` ASC),
  CONSTRAINT `fk_tokens_users1`
    FOREIGN KEY (`id_user`)
    REFERENCES `kardex_hulk_store`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
