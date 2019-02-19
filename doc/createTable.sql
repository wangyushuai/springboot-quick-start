CREATE SCHEMA `_local_test` ;

CREATE TABLE `_local_test`.`test_table` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `age` TINYINT(3) NOT NULL,
  `create_time` DATETIME(3) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
