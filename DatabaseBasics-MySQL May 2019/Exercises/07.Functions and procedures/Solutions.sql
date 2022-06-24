-- Part I – Queries for SoftUni Database

-- Exercises 1.	Employees with Salary Above 35000
-- USE `soft_uni`;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN
	SELECT first_name,last_name
    FROM employees
    WHERE salary>35000
    ORDER BY first_name,last_name,employee_id;
END
$$
-- CALL usp_get_employees_salary_above_35000();

-- 2.	Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above (min_salary DOUBLE(19,4))
BEGIN
	SELECT e.first_name,e.last_name
    FROM employees e
    WHERE e.salary>=min_salary
    ORDER BY e.first_name,e.last_name,e.employee_id;
END
$$
-- CALL usp_get_employees_salary_above(48100);
-- DROP PROCEDURE IF EXISTS usp_get_employees_salary_above;

-- 3.	Town Names Starting With
DELIMITER $$  - not acceptable for judge
CREATE PROCEDURE usp_get_towns_starting_with (start_string VARCHAR(20))
BEGIN
	SELECT name as `town_name`
    FROM towns t
    WHERE left(t.name,char_length(start_string))=start_string
    ORDER BY `town_name`;
END
$$
-- CALL usp_get_towns_starting_with('b');

-- 4.	Employees from Town
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town (town_name VARCHAR(20))
BEGIN
	SELECT e.first_name,e.last_name
    FROM employees e
    JOIN addresses a
    ON a.address_id=e.address_id
    JOIN towns t
    ON t.town_id=a.town_id
    WHERE t.name=town_name
    ORDER BY e.first_name,e.last_name,e.employee_id;
 END
$$
 -- CALL usp_get_employees_from_town('Sofia');
 
 -- 5.	Salary Level Function
 -- SET GLOBAL log_bin_trust_function_creators = 1   !!! in case of error 1418

CREATE FUNCTION ufn_get_salary_level(salary DOUBLE(19,4))
RETURNS VARCHAR(7)
RETURN (
    CASE 
        WHEN salary < 30000 THEN 'Low'
        WHEN salary <= 50000 THEN 'Average'
        ELSE 'High'
    END
);

SELECT ufn_get_salary_level(13500);
SELECT ufn_get_salary_level(43300);
SELECT ufn_get_salary_level(125500);

DROP FUNCTION IF EXISTS ufn_get_salary_level;

-- Using return parameter and IF-ELSE construction

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DOUBLE(19,4))
RETURNS VARCHAR(7)
BEGIN
    DECLARE level VARCHAR(7);
    IF 
        salary < 30000 THEN SET level := 'Low';
    ELSEIF 
        salary <= 50000 THEN SET level := 'Average';
    ELSE 
        SET level := 'High';
    END IF;
    RETURN level;
END 
$$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DOUBLE(19,4))
RETURNS VARCHAR(7)
BEGIN
    DECLARE level VARCHAR(7);
    CASE 
        WHEN salary < 30000 THEN SET level := 'Low';
        WHEN salary <= 50000 THEN SET level := 'Average';
		ELSE SET level := 'High';
    END CASE;
    RETURN level;
END 
$$
DELIMITER ;
-- SELECT ufn_get_salary_level(43300);

-- 6.	Employees by Salary Level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level (salary_level VARCHAR(10))
BEGIN
	SELECT first_name, last_name
    FROM employees e
    WHERE e.salary<30000 AND salary_level='low'
    OR e.salary<=50000 AND e.salary>=30000 AND salary_level='average'
    OR e.salary>50000 AND salary_level='high'   
    ORDER BY e.first_name DESC, last_name DESC;
END
$$
CALL usp_get_employees_by_salary_level('high');

-- Solution with call to ufn_get_salary_level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
    SELECT e.first_name, e.last_name
    FROM `employees` AS e
    WHERE ufn_get_salary_level(e.salary) = salary_level
    ORDER BY e.first_name DESC, e.last_name DESC;
END 
$$
DELIMITER ;

-- 7.	Define Function
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
RETURN lower(word) REGEXP (concat('^[', lower(set_of_letters),']+$'));

-- SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');
-- SELECT ufn_is_word_comprised('oistmiahf', 'halves');
-- SELECT ufn_is_word_comprised('bobr', 'Rob');

-- using loops
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS INT
BEGIN
	DECLARE result INT;
	DECLARE counter INT;
	DECLARE our_char VARCHAR(30);
	SET result = 1;
	SET counter = 0;
	REPEAT
		SET our_char = SUBSTRING(word, counter, 1);
		SET result = IF(set_of_letters NOT LIKE CONCAT('%', our_char, '%'), 0, 1);
		SET counter = counter + 1;
	UNTIL result = 0 OR counter = CHAR_LENGTH(word) + 1
	END REPEAT;
	RETURN result;
END 
$$

-- PART II – Queries for Bank Database
-- 8.	Find Full Name
-- USE `bank`;
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT concat(first_name,' ', last_name) as `full_name`
    FROM account_holders
    ORDER BY `full_name`,id;
END
$$
CALL usp_get_holders_full_name();

-- 9.	People with Balance Higher Than
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than (number DOUBLE(19,4))
BEGIN
	SELECT ah.first_name, ah.last_name
    FROM account_holders ah
    JOIN accounts a
    ON a.account_holder_id=ah.id
    GROUP BY ah.id
    HAVING SUM(a.balance)>number
    ORDER BY a.id; -- ah.first_name, ah.last_name excluded for judge
END 
$$
-- CALL usp_get_holders_with_balance_higher_than(7000);

-- 10.	Future Value Function
-- SET GLOBAL log_bin_trust_function_creators = 1; --  !!! in case of error 1418
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (initial_sum DECIMAL(20,4), interest_rate DECIMAL(19,4), years INT(11))
RETURNS DECIMAL(20,4)
BEGIN
	RETURN initial_sum*power((1+interest_rate), years);
END;

-- using variable

/*CREATE FUNCTION ufn_calculate_future_value(total DECIMAL(20,4), rate DECIMAL(15,4), years INT)
returns DECIMAL(20,4)
BEGIN 
	DECLARE result DECIMAL(20,4);
	SET result = total * POW((1 + rate), years);
	return result;
END;*/
$$
-- SELECT ufn_calculate_future_value(1000, 0.1, 5);
 
 -- 11.	Calculating Interest
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (initial_sum DECIMAL(20,4), interest_rate DECIMAL(19,4), years INT(11))
RETURNS DECIMAL(20,4)
BEGIN
	RETURN initial_sum*power((1+interest_rate), years);
END;

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(15, 4))
BEGIN
	SELECT a.id, a_h.first_name, a_h.last_name, a.balance as current_balance,
	ufn_calculate_future_value(a.balance, interest_rate, 5) as balance_in_5_years 
	FROM accounts as a 
	JOIN account_holders as a_h ON a.account_holder_id = a_h.id
	WHERE a.id = account_id;
END; 
$$
DELIMITER ;
-- CALL usp_calculate_future_value_for_account(1, 0.1);

-- 12.	Deposit Money /judge doesn't require account check/ -- 
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(20,4))
BEGIN
START TRANSACTION;
	CASE
		WHEN money_amount<0 OR ((SELECT ac.id
        FROM accounts ac
        WHERE ac.id =account_id) IS NULL)
        THEN ROLLBACK;
	ELSE
		UPDATE accounts a
        SET a.balance=a.balance+money_amount
        WHERE a.id = account_id;
	END CASE;
COMMIT;
END
$$
DELIMITER ;
CALL usp_deposit_money(1,10);

-- 13.	Withdraw Money

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
	IF money_amount >0 THEN
		START TRANSACTION;
		UPDATE accounts AS a 
		SET a.balance=a.balance-money_amount
		WHERE a.id=account_id;
		
		IF ((SELECT id
            FROM accounts
            WHERE id = account_id
            ) IS NULL)  OR  (SELECT a.balance FROM accounts a 
		WHERE a.id = account_id) <0       
		THEN ROLLBACK;
		ELSE
			COMMIT;
		END IF;
	END IF;
END 
$$
DELIMITER ;

-- using CASE:

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(20,4))
BEGIN
START TRANSACTION;
	CASE
		WHEN money_amount<0 OR (SELECT ac.balance
        FROM accounts ac
        WHERE ac.id=account_id AND ac.balance<money_amount)
        THEN ROLLBACK;
	ELSE
		UPDATE accounts a
        SET a.balance=a.balance-money_amount
        WHERE a.id = account_id;
	END CASE;
COMMIT;
END
END 
$$
DELIMITER ;
-- CALL usp_withdraw_money(1,10);
-- SELECT id,account_holder_id,balance FROM accounts a
-- WHERE a.id=1;

-- 14.	Money Transfer
DELIMITER $$
CREATE PROCEDURE usp_transfer_money (from_account_id INT, 
to_account_id INT, amount DECIMAL(19,4))
BEGIN
	IF amount >0 THEN
		START TRANSACTION;
		UPDATE accounts AS a 
		SET a.balance=a.balance-amount
		WHERE a.id=from_account_id;
        UPDATE accounts AS a 
		SET a.balance=a.balance+amount
		WHERE a.id=to_account_id;	
		
		IF ((SELECT id
            FROM accounts a
            WHERE a.id = from_account_id
            ) IS NULL)  
            OR ((SELECT id
            FROM accounts a
            WHERE a.id = to_account_id
            ) IS NULL) 
            OR  (SELECT a.balance FROM accounts a 
		WHERE a.id = from_account_id) <0       
		THEN ROLLBACK;
		ELSE
			COMMIT;
		END IF;
	END IF;
END
$$
DELIMITER ;
-- CALL usp_transfer_money(1,2,10);
/*SELECT id,account_holder_id,balance FROM accounts a
WHERE a.id<3;*/

-- 15.	Log Accounts Trigger
CREATE TABLE logs(
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT NOT NULL, 
old_sum DECIMAL(19,4), 
new_sum DECIMAL(19,4)
);
-- DELIMITER $$
CREATE TRIGGER tr_balance_change
AFTER UPDATE ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs (account_id,old_sum,new_sum)
    VALUES(OLD.id,OLD.balance,NEW.balance);
END $$
DELIMITER ;
-- CALL usp_deposit_money(1,10);
-- CALL usp_withdraw_money(2,14);
-- CALL usp_transfer_money(2,1,100);
-- SELECT * FROM logs;

-- DROP TRIGGER tr_balance_change;
-- SET foreign_key_checks = 0; --dangerous
-- SET foreign_key_checks = 1; 

-- 16.	Emails Trigger
-- judge requires solution 15 !!!
CREATE TABLE logs(
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT NOT NULL, 
old_sum DECIMAL(19,4), 
new_sum DECIMAL(19,4)
);
-- DELIMITER $$
CREATE TRIGGER tr_balance_change
AFTER UPDATE ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs (account_id,old_sum,new_sum)
    VALUES(OLD.id,OLD.balance,NEW.balance);
END; -- $$

CREATE TABLE notification_emails(
id INT PRIMARY KEY AUTO_INCREMENT, 
recipient INT NOT NULL, 
subject VARCHAR (50)NOT NULL,
body TEXT NOT NULL
);
-- DELIMITER $$
CREATE TRIGGER tr_create_email
AFTER INSERT ON logs
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails (recipient, subject, body)
    VALUES (NEW.account_id,
    concat('Balance change for account: ', NEW.account_id),
    concat('On ',DATE_FORMAT(NOW(), '%b %d %Y at %r'), 
    ' your balance was changed from ',NEW.old_sum,' to ',
    NEW.new_sum,'.'));
END 
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `bank`.tr_create_email;
