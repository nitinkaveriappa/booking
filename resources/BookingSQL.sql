CREATE DATABASE IF NOT EXISTS bookingdb;

USE bookingdb;

DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS amenity;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer
(
  cus_id INT NOT NULL AUTO_INCREMENT,
  cus_name VARCHAR(50) NOT NULL,
  cus_gender VARCHAR(25) NOT NULL,
  cus_dob DATE NOT NULL,
  cus_bio VARCHAR(200) NOT NULL,
  PRIMARY KEY (cus_id)
)ENGINE=InnoDB AUTO_INCREMENT=10;

CREATE TABLE IF NOT EXISTS hotel
(
  hot_id INT NOT NULL AUTO_INCREMENT,
  hot_name VARCHAR(50) NOT NULL,
  hot_email VARCHAR(100) NOT NULL,
  hot_address VARCHAR(200) NOT NULL,
  PRIMARY KEY (hot_id)
)ENGINE=InnoDB AUTO_INCREMENT=10;

CREATE TABLE IF NOT EXISTS amenity
(
  hot_id INT NOT NULL,
  ame_stars INT NOT NULL,
  ame_wifi BOOLEAN NOT NULL,
  ame_restaurant BOOLEAN NOT NULL,
  ame_ac BOOLEAN NOT NULL,
  ame_breakfast BOOLEAN NOT NULL,
  ame_pool BOOLEAN NOT NULL,
  ame_gym BOOLEAN NOT NULL,
  PRIMARY KEY (hot_id),
  FOREIGN KEY (hot_id) REFERENCES hotel(hot_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS review
(
  rev_id INT NOT NULL AUTO_INCREMENT,
  rev_title VARCHAR(100) NOT NULL,
  rev_comment VARCHAR(200) NOT NULL,
  rev_rating INT NOT NULL,
  cus_id INT NOT NULL,
  hot_id INT NOT NULL,
  PRIMARY KEY (rev_id),
  FOREIGN KEY (cus_id) REFERENCES customer(cus_id),
  FOREIGN KEY (hot_id) REFERENCES hotel(hot_id)
)ENGINE=InnoDB AUTO_INCREMENT=10;

CREATE TABLE IF NOT EXISTS room
(
  roo_id INT NOT NULL AUTO_INCREMENT,
  roo_type VARCHAR(50) NOT NULL,
  roo_price NUMERIC(10,2) NOT NULL,
  hot_id INT NOT NULL,
  PRIMARY KEY (roo_id),
  FOREIGN KEY (hot_id) REFERENCES hotel(hot_id)
)ENGINE=InnoDB AUTO_INCREMENT=10;

CREATE TABLE IF NOT EXISTS reservation
(
  res_id INT NOT NULL AUTO_INCREMENT,
  res_date INT NOT NULL,
  res_checkin INT NOT NULL,
  res_checkout INT NOT NULL,
  cus_id INT NOT NULL,
  roo_id INT NOT NULL,
  PRIMARY KEY (res_id),
  FOREIGN KEY (cus_id) REFERENCES customer(cus_id),
  FOREIGN KEY (roo_id) REFERENCES room(roo_id)
)ENGINE=InnoDB AUTO_INCREMENT=10;


INSERT INTO `bookingdb`.`customer` (`cus_id`, `cus_name`, `cus_gender`, `cus_dob`, `cus_bio`) VALUES ('1', 'Nitin', 'Male', '1991-12-21', 'This is Me.');
INSERT INTO `bookingdb`.`hotel` (`hot_id`, `hot_name`, `hot_email`, `hot_address`) VALUES ('1', 'Leela Palace', 'lp@lp.com', '@LeelaPalace');
INSERT INTO `bookingdb`.`amenity` (`hot_id`, `ame_stars`, `ame_wifi`, `ame_restaurant`, `ame_ac`, `ame_breakfast`, `ame_pool`, `ame_gym`) VALUES ('1', '5', '1', '1', '1', '1', '1', '1');
INSERT INTO `bookingdb`.`review` (`rev_id`, `rev_title`, `rev_comment`, `rev_rating`, `cus_id`, `hot_id`) VALUES ('1', 'Leela is the Worst', 'The worst hotel is Leela', '1', '1', '1');
