CREATE DATABASE RealEstateDB;

USE RealEstateDB;

CREATE TABLE Property (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    location VARCHAR(100),
    price DECIMAL(10, 2),
    area FLOAT
);
