DROP DATABASE IF EXISTS cloudDB03;

CREATE DATABASE cloudDB03 CHARACTER SET UTF8;

USE cloudDB03;

CREATE TABLE payment(
                     id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     serial VARCHAR(200)
);
Add a new github user