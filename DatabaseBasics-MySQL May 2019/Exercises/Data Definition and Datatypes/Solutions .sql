create schema minions;
USE minions;

-- 1.	Create Tables
CREATE table minions (
id INT(11) PRIMARY KEY,
name VARCHAR(20),
age INT(11)
);
CREATE TABLE towns (
id INT(11) PRIMARY KEY,
name TEXT
);
-- 2.	Alter Minions Table
ALTER TABLE minions ADD town_id INT(11);
ALTER TABLE minions ADD FOREIGN KEY(town_id) REFERENCES towns(id);
-- 3.	Insert Records in Both Tables
INSERT INTO towns (id,name) VALUES (1,'Sofia'),
	(2,'Plovdiv'),
	(3,'Varna');
INSERT INTO minions (id,name,age,town_id) VALUES (1,'Kevin',22,1),
	(2,'Bob',15,3),
	(3,'Steward',NULL,2);
-- 4.	Truncate Table Minions
TRUNCATE TABLE minions;
-- 5.	Drop All Tables
DROP TABLE minions;
DROP TABLE towns;

-- 6.	Create Table People
CREATE TABLE people(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(200) NOT NULL,
picture BLOB,
height DOUBLE(5,2),
weight DOUBLE (5,2),
gender CHAR(1) NOT NULL,
birthdate DATE NOT NULL,
biography TEXT
);
INSERT INTO people (name,height,weight,gender,birthdate)
VALUES ('Pesho',1.60, 50.1, 'm','1990-10-25'),
('Pesho2',1.60, 50.1, 'm','1990-10-25'),
('Pesho3',1.70, 60.1, 'm','1990-10-25'),
('Pesho4',1.80, 70.1, 'm','1990-10-25'),
('Pesho5',1.50, 40.1, 'm','1990-10-25');

-- 7.	Create Table Users
CREATE TABLE users(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
password VARCHAR(26) NOT NULL,
profile_picture BLOB,
last_login_time DATETIME,
is_deleted BIT
);
INSERT INTO users (username , password , last_login_time, is_deleted )
VALUES ('Mara', '1234', '2018-05-30 14:00:00',0),
('Mara2', '1234', '2018-05-30 14:00:00',0),
('Mara3', '1234', '2018-05-30 14:00:00',0),
('Mara4', '1234', '2018-05-30 14:00:00',0),
('Mara5', '1234', '2018-05-30 14:00:00',0);

-- 8.	Change Primary Key
ALTER TABLE users MODIFY COLUMN id INT(11);
ALTER TABLE users DROP PRIMARY KEY;
ALTER TABLE users ADD CONSTRAINT pk_id_username PRIMARY KEY(id,username);

-- 9.	Set Default Value of a Field
ALTER TABLE users MODIFY COLUMN `last_login_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- 10.	 Set Unique Field
ALTER TABLE `users`
	DROP PRIMARY KEY,
	ADD CONSTRAINT PRIMARY KEY (`id`),
	ADD CONSTRAINT UNIQUE (`username`);
-- 11.	Movies Database
USE movies;

CREATE TABLE directors(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
director_name VARCHAR(30) NOT NULL,
notes TEXT
);
CREATE TABLE genres(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
genre_name VARCHAR(20) NOT NULL,
notes TEXT
);
CREATE TABLE categories (
id INT(11) PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(20) NOT NULL,
notes TEXT
);
CREATE TABLE movies (
id INT(11) PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(20) NOT NULL,
director_id INT(11) NOT NULL,
copyright_year YEAR NOT NULL,
length TIME NOT NULL,
genre_id INT(11) NOT NULL,
category_id INT(11) NOT NULL,
rating DOUBLE (2,1) NOT NULL DEFAULT 0,
notes TEXT
);
INSERT INTO directors (director_name) VALUES ('Spillberg'),
	('Pesho'),
	('Gosho'),
	('Mara'),
	('Eli');
INSERT INTO genres (genre_name) VALUES ('fantazi'),
	('horror'),
    ('romance'),
    ('action'),
    ('cartoon');
INSERT INTO categories (category_name) VALUES ('tv'),
	('family'),
    ('teen'),
    ('baby'),
    ('XX');
INSERT INTO movies (title, director_id, copyright_year, length,genre_id, category_id)
VALUES ('star wars',1,'1990', 120, 1,2),
	('Transformers',2,'1993', 20, 2,1),
    ('yy',3,'1991', 30, 3,3),
    ('zz',4,'1992', 150, 4,4),
    ('aa',5,'1994', 40, 5,1);
    
    -- 12.	Car Rental Database
CREATE SCHEMA car_rental 
USE car_rental;

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
category VARCHAR(10) NOT NULL,
daily_rate DOUBLE NOT NULL, 
weekly_rate DOUBLE, 
monthly_rate DOUBLE, 
weekend_rate DOUBLE
);
INSERT INTO categories (category, daily_rate)
VALUES ('small',20),
	('cabrio', 30),
    ('SUV',40);
CREATE TABLE cars (
id INT PRIMARY KEY AUTO_INCREMENT, 
plate_number VARCHAR(10) NOT NULL, 
make VARCHAR(10) NOT NULL, 
model VARCHAR(10) NOT NULL,
car_year YEAR NOT NULL, 
category_id INT, 
doors INT, 
picture BLOB, 
car_condition BIT, 
available BIT DEFAULT 0
);
INSERT INTO cars (plate_number, make, model, car_year)
VALUES ('koko1','opel', 'astra','2017'),
	('koko2','bmw', 'astra','2018'),
    ('koko3','MB', 'SL100','2015');
    
CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT, 
first_name VARCHAR(20) NOT NULL, 
last_name VARCHAR(20) NOT NULL, 
title VARCHAR(30), 
notes VARCHAR(128)
);
INSERT INTO employees (first_name, last_name)
VALUES ('Ivan','Ivanov'),
	('Ivan2','Ivanov'),
    ('Ivan3','Ivanov');
    
CREATE TABLE customers (
id INT PRIMARY KEY AUTO_INCREMENT, 
driver_licence_number INT UNSIGNED NOT NULL, 
full_name VARCHAR (40) NOT NULL, 
address VARCHAR (60), 
city VARCHAR (10), 
zip_code INT(4), 
notes VARCHAR(128)
);

INSERT INTO customers (driver_licence_number, full_name)
VALUES (123,'Ivanov'),
	(456,'Petrov'),
    (789,'Gosho');
    
CREATE TABLE rental_orders (
id INT PRIMARY KEY AUTO_INCREMENT, 
employee_id INT, 
customer_id INT NOT NULL, 
car_id INT NOT NULL, 
car_condition BIT, 
tank_level DOUBLE,
 kilometrage_start INT UNSIGNED, 
 kilometrage_end INT UNSIGNED, 
 total_kilometrage INT UNSIGNED, 
 start_date DATE NOT NULL, 
 end_date DATE,
 total_days INT UNSIGNED, 
 rate_applied INT, 
 tax_rate DOUBLE, 
 order_status INT UNSIGNED, 
 notes VARCHAR (10)
);
INSERT INTO rental_orders (customer_id, car_id, tank_level, start_date)
VALUES (1,1,0.5,DATE(now())),
	(2,3,0.75,DATE(now())),
    (3,2,1,DATE(now()));
    
-- 13.	Hotel Database

CREATE SCHEMA hotel;
USE hotel;
-- for judge
CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR (30) NOT NULL,
title VARCHAR(20) NOT NULL,
notes VARCHAR(128)
);
INSERT INTO employees (first_name, last_name, title)
VALUES ('Gosho', 'Kolev', 'worker'),
	('Gosho1', 'Kolev', 'worker'),
    ('Gosho2', 'Kolev', 'boss');

CREATE TABLE customers (
account_number INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR (30) NOT NULL,
phone_number VARCHAR(20),
emergency_name VARCHAR (50),
emergency_number VARCHAR(20),
notes VARCHAR(128)
);
INSERT INTO customers (first_name, last_name) 
VALUES ('xx','adadada'),
	('xx1','adadada'),
    ('xx','adadada2');
-- int
CREATE TABLE room_status (
room_status INT PRIMARY KEY AUTO_INCREMENT, 
notes VARCHAR(128)
);
INSERT INTO room_status (notes)
VALUES ('free'),('occupied'),('for cleaning');

-- int
CREATE TABLE room_types  (
room_type INT PRIMARY KEY AUTO_INCREMENT,
notes VARCHAR(128)
);
INSERT INTO room_types (notes)
VALUES ('single'),('double'),('delux');

-- int
CREATE TABLE bed_types (
bed_type INT PRIMARY KEY AUTO_INCREMENT,
notes VARCHAR(128)
);

INSERT INTO bed_types (notes)
VALUES ('single'),('double'),('water');

CREATE TABLE rooms (
room_number INT(11) PRIMARY KEY AUTO_INCREMENT,
room_type INT NOT NULL,
bed_type INT NOT NULL,
rate DOUBLE DEFAULT 0,
room_status INT NOT NULL,
notes VARCHAR(128)
);
INSERT INTO rooms (room_type, bed_type, room_status)
VALUES (1,1,1),
	(2,2,2),
    (3,3,3);

CREATE TABLE payments (
id INT(11) PRIMARY KEY AUTO_INCREMENT,
employee_id INT(11) NOT NULL,
payment_date DATE NOT NULL,
account_number INT(11) NOT NULL,
first_date_occupied DATE,
last_date_occupied DATE,
total_days INT(11) UNSIGNED,
amount_charged DOUBLE,
tax_rate DOUBLE,
tax_amount DOUBLE,
payment_total DOUBLE,
notes VARCHAR(128)
);

INSERT INTO payments (employee_id, payment_date, account_number,tax_rate)
VALUES (1,DATE(now()), 1,10),
	(2,DATE(now()), 2,10),
    (3,DATE(now()), 3,15);
CREATE TABLE occupancies (
id INT(11) PRIMARY KEY AUTO_INCREMENT,
employee_id INT NOT NULL,
date_occupied DATE NOT NULL,
account_number INT NOT NULL,
room_number INT NOT NULL,
rate_applied DOUBLE,
phone_charge DOUBLE,
notes VARCHAR(128)
);
    
INSERT INTO occupancies (employee_id, date_occupied, account_number, room_number)
VALUES (3,DATE(now()), 1,1),
	(2,DATE(now()), 2,2),
    (1,DATE(now()), 3,3);
    
-- 14.	Create SoftUni Database
CREATE DATABASE `soft_uni1`;
USE `soft_uni1`;

CREATE TABLE towns(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15) NOT NULL
);

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT, 
address_text VARCHAR(128) NOT NULL, 
town_id INT NOT NULL,
FOREIGN KEY (town_id) REFERENCES towns(id)
);
CREATE TABLE departments (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(15) NOT NULL
);
CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(15) NOT NULL,
middle_name VARCHAR(15), 
last_name VARCHAR(15) NOT NULL, 
job_title VARCHAR(15), 
department_id INT,
FOREIGN KEY (department_id) REFERENCES departments(id),
hire_date DATE NOT NULL, 
salary DOUBLE, 
address_id INT,
FOREIGN KEY (address_id) REFERENCES addresses(id)
);

CREATE TABLE `employees` (
	`id` INT UNSIGNED UNIQUE AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`middle_name` VARCHAR(30),
	`last_name` VARCHAR(30) NOT NULL,
	`job_title` VARCHAR(30) NOT NULL,
	`department_id` INT UNSIGNED,
	`hire_date` DATE,
	`salary` DECIMAL(10 , 2 ),
	`address_id` INT UNSIGNED,
	CONSTRAINT `pk_employees` PRIMARY KEY (`id`),
	CONSTRAINT `fk_employees_departments` FOREIGN KEY (`department_id`)
		REFERENCES `departments` (`id`),
	CONSTRAINT `fk_employees_addresses` FOREIGN KEY (`address_id`)
		REFERENCES `addresses` (`id`)
);

-- 16.	Basic Insert
INSERT INTO `towns` 
		(`name`) 
	VALUES
		('Sofia'),
		('Plovdiv'),
		('Varna'),
		('Burgas');

INSERT INTO `departments` 
		(`name`) 
	VALUES
		('Engineering'),
		('Sales'),
		('Marketing'),
		('Software Development'),
		('Quality Assurance');

INSERT INTO `employees`
		(`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
	VALUES
		('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
		('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
		('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
		('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
		('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);
    
-- 17.	Basic Select All Fields
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

-- 18.	Basic Select All Fields and Order Them
SELECT * FROM `towns` ORDER BY `name`;
SELECT * FROM `departments` ORDER BY `name`;
SELECT * FROM `employees` ORDER BY `salary` DESC;

-- 19.	Basic Select Some Fields
SELECT `name` FROM `towns` ORDER BY `name`;
SELECT `name` FROM `departments` ORDER BY `name`;
SELECT `first_name`, `last_name`, `job_title`, `salary`
FROM `employees` ORDER BY `salary` DESC;

-- 20.	Increase Employees Salary
UPDATE `employees` 
SET`salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;

-- 21.	Decrease Tax Rate
UPDATE payments
SET tax_rate=tax_rate*0.97;
SELECT tax_rate FROM payments;
-- 22.	Delete All Records
DELETE FROM occupancies;
-- OR
TRUNCATE TABLE occupancies;
-- end

    

