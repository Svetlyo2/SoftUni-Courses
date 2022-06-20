
 -- Exercises 1.	One-To-One Relationship
 
 use `project_management`;
 CREATE TABLE persons (
 person_id INT,
 first_name VARCHAR (20) NOT NULL,
 salary DECIMAL(10,2) NOT NULL DEFAULT 0,
 passport_id INT(11) NOT NULL UNIQUE
 );
 CREATE TABLE passports (
 passport_id INT(11) PRIMARY KEY AUTO_INCREMENT,
 passport_number VARCHAR (8)NOT NULL UNIQUE
 ) AUTO_INCREMENT=101; 
 
 ALTER TABLE persons
 MODIFY COLUMN person_id INT PRIMARY KEY AUTO_INCREMENT;
 ALTER TABLE persons
 ADD CONSTRAINT fk_passport_id 
 FOREIGN KEY (passport_id)
 REFERENCES passports(passport_id);
 INSERT INTO passports (passport_number)
VALUES ('N34FG21B'), ('K65LO4R7'), ('ZE657QP2');
INSERT INTO persons (first_name,salary,passport_id)
 VALUES ('Roberto', 43300, 102), 
		('Tom', 56100, 103), 
		('Yana', 60200, 101);

 -- 2.	One-To-Many Relationship
 -- Data should be inserted after CREATE, but if we do so the data test in 
-- Judge fails because entries are not ordered as expected there so
-- first we have to complete tables setup.

CREATE TABLE manufacturers (
 manufacturer_id INT UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
 name VARCHAR (10) NOT NULL,
 established_on DATE NOT NULL 
 );
 
 CREATE TABLE models (
 model_id INT UNIQUE NOT NULL AUTO_INCREMENT,
 name VARCHAR (10) NOT NULL,
 manufacturer_id INT UNSIGNED NOT NULL
 ) AUTO_INCREMENT=101;
 
 ALTER TABLE manufacturers
ADD CONSTRAINT pk_manufacturer_id
PRIMARY KEY (manufacturer_id);
ALTER TABLE models
ADD CONSTRAINT pk_model_id
PRIMARY KEY (model_id);
ALTER TABLE models
ADD CONSTRAINT fk_manufacturer_id
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id);

INSERT INTO manufacturers (name,established_on)
 VALUES ('BMW', '1916-03-01'),
		('Tesla', '2003-01-01'),
		('Lada', '1966-05-01');

 INSERT INTO models (name,manufacturer_id)
 VALUES ('X1', 1),
		('i6', 1),
		('Model S', 2),
		('Model X', 2),
		('Model 3', 2),
		('Nova', 3);

-- 3.	Many-To-Many Relationship
CREATE TABLE students (
student_id INT UNIQUE NOT NULL AUTO_INCREMENT,
name VARCHAR (20) NOT NULL
);
CREATE TABLE exams (
exam_id INT UNIQUE NOT NULL AUTO_INCREMENT,
name VARCHAR (30) NOT NULL
) AUTO_INCREMENT=101;
CREATE TABLE students_exams (
student_id INT NOT NULL,
exam_id INT NOT NULL
);
ALTER TABLE students
ADD CONSTRAINT PRIMARY KEY (student_id);
ALTER TABLE exams
ADD CONSTRAINT PRIMARY KEY (exam_id);
ALTER TABLE students_exams
ADD CONSTRAINT pk_students_exams
PRIMARY KEY(student_id,exam_id),
ADD CONSTRAINT fk_students_exams_students
FOREIGN KEY (student_id)
REFERENCES students(student_id),
ADD CONSTRAINT fk_students_exams_exams
FOREIGN KEY (exam_id)
REFERENCES exams(exam_id);
INSERT INTO students (name)
VALUES ('Mila'),
		('Toni'),
        ('Ron');
INSERT INTO exams (name)
VALUES ('Spring MVC'),
		('Neo4j'),
        ('Oracle 11g');
INSERT INTO students_exams
VALUES (1,101),(1,102),(2,101),(3,103),(2,102),(2,103);

 -- 4.	Self-Referencing
 CREATE TABLE teachers (
 teacher_id INT UNIQUE NOT NULL AUTO_INCREMENT,
 name VARCHAR (30) NOT NULL,
 manager_id INT DEFAULT NULL
 ) AUTO_INCREMENT=101;
 INSERT INTO teachers (name,manager_id)
 VALUES ('John', NULL),
('Maya', 106),
('Silvia', 106),
('Ted', 105),
('Mark', 101),
('Greta', 101);
 ALTER TABLE teachers
 ADD CONSTRAINT PRIMARY KEY (teacher_id),
 ADD CONSTRAINT fk_teacher_mgr
 FOREIGN KEY (manager_id)
 REFERENCES teachers(teacher_id);
 
-- 5.	Online Store Database
CREATE SCHEMA Online_Store; -- not for judge
CREATE TABLE items (
 item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL,
 item_type_id INT(11)
);
CREATE TABLE item_types (
item_type_id INT (11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL
);
CREATE TABLE customers (
customer_id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
birthday DATE,
city_id INT(11)
);
CREATE TABLE cities (
city_id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);
 CREATE TABLE orders (
 order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
 customer_id INT(11),
 FOREIGN KEY (customer_id) 
 REFERENCES customers(customer_id)
 );
 CREATE TABLE order_items (
 order_id INT(11) NOT NULL,
 item_id INT (11) NOT NULL,
 PRIMARY KEY (order_id,item_id),
 FOREIGN KEY (order_id) REFERENCES orders (order_id),
 FOREIGN KEY (item_id) REFERENCES items (item_id)
 );
 ALTER TABLE items
 ADD CONSTRAINT FOREIGN KEY fk_items_types
 (item_type_id) REFERENCES item_types (item_type_id);
 ALTER TABLE customers
 ADD CONSTRAINT FOREIGN KEY fk_customer_city
 (city_id) REFERENCES cities(city_id);
 
 -- 6.	University Database
 -- CREATE SCHEMA University;
 -- use University;
 CREATE TABLE subjects (
 subject_id INT (11) PRIMARY KEY AUTO_INCREMENT,
 subject_name VARCHAR(50) NOT NULL
 );
 CREATE TABLE majors (
 major_id INT(11) PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL
 );
 CREATE TABLE students (
 student_id INT (11) PRIMARY KEY AUTO_INCREMENT,
 student_number VARCHAR(12) UNIQUE NOT NULL,
 student_name VARCHAR(50) NOT NULL,
 major_id INT(11),
 FOREIGN KEY (major_id) REFERENCES majors(major_id)
 ); 
 CREATE TABLE payments (
 payment_id INT(11) PRIMARY KEY AUTO_INCREMENT,
 payment_date DATE NOT NULL,
 payment_amount DECIMAL(8,2) NOT NULL,
 student_id INT(11),
 FOREIGN KEY (student_id) REFERENCES students(student_id) 
 );
 CREATE TABLE agenda (
 student_id INT(11) NOT NULL,
 subject_id INT (11),
 PRIMARY KEY (student_id,subject_id),
 FOREIGN KEY (student_id) REFERENCES students(student_id),
 FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
 );
 
 -- 09.	Peaks in Rila 
 SELECT m.mountain_range, p.peak_name,p.elevation as 'peak_elevation'
 FROM mountains as m
 JOIN peaks as p
 ON m.id=p.mountain_id
 WHERE m.mountain_range='Rila'
 ORDER BY p.elevation DESC;
 