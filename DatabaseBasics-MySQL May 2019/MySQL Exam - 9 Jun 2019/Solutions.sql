
-- CREATE SCHEMA bank;
USE bank;

CREATE TABLE branches (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL UNIQUE
);
CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(10,2) NOT NULL,
started_on DATE NOT NULL,
branch_id INT NOT NULL,
FOREIGN KEY (branch_id) REFERENCES branches(id)
);
CREATE TABLE clients (
id INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
age INT NOT NULL
);
CREATE TABLE employees_clients (
employee_id INT,
client_id INT,
FOREIGN KEY (employee_id) REFERENCES employees(id),
FOREIGN KEY (client_id) REFERENCES clients(id)
);
CREATE TABLE bank_accounts (
id INT PRIMARY KEY AUTO_INCREMENT,
account_number VARCHAR(10) NOT NULL,
balance DECIMAL(10,2) NOT NULL,
client_id INT NOT NULL UNIQUE,
FOREIGN KEY (client_id) REFERENCES clients(id)
);
CREATE TABLE cards(
id INT PRIMARY KEY AUTO_INCREMENT,
card_number VARCHAR(19) NOT NULL,
card_status VARCHAR(7) NOT NULL,
bank_account_id INT NOT NULL,
FOREIGN KEY (bank_account_id) REFERENCES bank_accounts(id)
);

-- 2 Insert
INSERT INTO cards (card_number,card_status,bank_account_id)
SELECT reverse(c.full_name),'Active',c.id
FROM clients c
JOIN bank_accounts ba
ON ba.client_id=c.id
WHERE c.id BETWEEN 191 AND 200;

-- 3 Update
UPDATE `employees_clients` AS ec
JOIN
(SELECT ec1.`employee_id`, COUNT(ec1.`client_id`) AS 'count'
		FROM `employees_clients` AS ec1 
		GROUP BY ec1.`employee_id`
		ORDER BY count, ec1.`employee_id`) AS s
SET ec.`employee_id` = s.`employee_id`
WHERE ec.`employee_id` = ec.`client_id`;

-- 4 Delete
DELETE FROM `employees`
WHERE id NOT IN (
	SELECT employee_id
	FROM employees_clients
);

-- 5 Clients
SELECT id, full_name
FROM clients
ORDER BY id;

-- 6
SELECT id,concat(first_name,' ',last_name)as full_name, 
concat('$', salary) as salary, started_on
FROM employees
WHERE salary>=100000 AND started_on >='2018-01-01'
ORDER BY salary DESC,id;

-- 7 Cards against Humanity
SELECT ca.id, concat(ca.card_number,' : ',c.full_name) as card_token
FROM cards ca
JOIN bank_accounts ba
ON ba.id=ca.bank_account_id
JOIN clients c
ON c.id=ba.client_id
ORDER BY ca.id DESC;

-- 8Top 5 Employees
SELECT concat ( e.first_name, ' ',e.last_name) as `name`, 
e.started_on, count( ec.client_id) as `count_of_clients`
FROM employees e
JOIN employees_clients ec
ON ec.employee_id=e.id
GROUP BY `name`
ORDER BY `count_of_clients` DESC, e.id
LIMIT 5;

-- 9 Branch cards
SELECT b.name, count(ca.id) as `count_of_cards`
FROM branches  b
LEFT JOIN employees e
ON e.branch_id=b.id
LEFT JOIN employees_clients ec
ON ec.employee_id=e.id
LEFT JOIN clients c
ON c.id=ec.client_id
LEFT JOIN bank_accounts ba
ON ba.client_id=c.id
LEFT JOIN cards ca
ON ca.bank_account_id=ba.id
GROUP BY b.name
ORDER BY `count_of_cards` DESC,b.name;

-- 10 Extract client cards count
-- SET GLOBAL log_bin_trust_function_creators = 1; if you ger error 1418;
DELIMITER $$
CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
RETURNS INT(11)
BEGIN
	DECLARE c_count INT;
	SET c_count:=(
    SELECT COUNT(ca.id) as `cards`
	FROM clients c
	JOIN bank_accounts ba
	ON ba.client_id=c.id
	JOIN cards ca
	ON ca.bank_account_id=ba.id
	WHERE c.full_name =name
    );
    RETURN c_count;
END
$$
DELIMITER ;
SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` 
FROM clients c
WHERE c.full_name = 'Baxy David';

-- 11 Extract Client Info
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(20))
BEGIN
	SELECT c.full_name,c.age,ba.account_number, concat('$', ba.balance) as `balance`
	FROM clients c
	JOIN bank_accounts ba
	ON ba.client_id=c.id
	WHERE c.full_name =full_name;
END
$$
DELIMITER ;

CALL udp_clientinfo('Hunter Wesgate');


