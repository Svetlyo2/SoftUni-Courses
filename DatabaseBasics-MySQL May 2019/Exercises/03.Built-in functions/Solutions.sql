
-- 1.	Find Names of All Employees by First Name
USE `soft_uni`;
SELECT first_name,last_name
FROM employees
WHERE left(first_name, 2)='sa'
ORDER BY employee_id;

-- using substring

SELECT first_name, last_name FROM employees
WHERE substring(lower(first_name),1,2)='sa'
ORDER BY employee_id;

-- 2.	Find Names of All employees by Last Name 
SELECT first_name,last_name
FROM employees
WHERE last_name LIKE('%ei%')
ORDER BY employee_id;

-- using locate:

SELECT first_name, last_name FROM employees
WHERE locate('ei',last_name)>0
ORDER BY employee_id;

-- 3.	Find First Names of All Employees
SELECT first_name FROM employees
WHERE department_id IN(3,10)
AND year(hire_date) BETWEEN 1995 AND 2005
ORDER BY employee_id;

SELECT first_name FROM employees
WHERE department_id IN(3,10)
AND year(hire_date) > 1994 AND year(hire_date)<2006
ORDER BY employee_id;

-- 4.	Find All Employees Except Engineers
SELECT first_name, last_name FROM employees
WHERE locate('engineer',job_title)=0
ORDER BY employee_id;

-- 5.	Find Towns with Name Length
SELECT name FROM towns
WHERE char_length(name) IN (5,6)
ORDER BY name;

-- 6.Find Towns Starting With
SELECT town_id,name FROM towns
WHERE left(name,1) IN ('M','K','B','E')
ORDER BY name;

-- 7. Find Towns Not Starting With
SELECT town_id,name FROM towns
WHERE left(name,1)NOT IN ('R','B','D')
ORDER BY name;

-- 8.	Create View Employees Hired After 2000 Year
CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name FROM employees
WHERE year(hire_date)>2000;
-- SELECT * FROM v_employees_hired_after_2000;

-- 9.	Length of Last Name

SELECT first_name, last_name FROM employees
WHERE char_length(last_name)=5;

-- Part II – Queries for Geography Database 
-- 10.	Countries Holding ‘A’ 3 or More Times
USE `geography`;
SELECT country_name,iso_code FROM countries
WHERE lower(country_name) LIKE '%a%a%a%'
ORDER BY iso_code;

-- 11. Mix of Peak and River Names
SELECT p.peak_name, r.river_name,
lower(concat(p.peak_name,substr(r.river_name,2))) AS `mix`
FROM peaks p, rivers r
WHERE right(peak_name,1)=left(river_name,1)
ORDER BY mix;

-- Part III – Queries for Diablo Database
-- 12.	Games from 2011 and 2012 year
-- USE `diablo`;
SELECT name,DATE_FORMAT(start,'%Y-%m-%d') FROM games
WHERE year(start) BETWEEN 2011 AND 2012
ORDER BY start,name
LIMIT 50;

-- 13.User Email Providers
SELECT user_name, substr(`email`,locate('@',email)+1) AS `Email Provider`
FROM users
ORDER BY `Email Provider`,user_name;

-- 14.Get Users with IP Address Like Pattern
SELECT user_name,ip_address FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

-- 15.	 Show All Games with Duration and Part of the Day
SELECT name,
CASE 
-- WHEN time(start) BETWEEN '00:00:00' AND '11:59:59'THEN 'Morning'
-- WHEN time(start) BETWEEN '12:00:00' AND '17:59:59'THEN 'Afternoon'
WHEN hour(start) BETWEEN 0 AND 11 THEN 'Morning'
WHEN hour(start) BETWEEN 12 AND 17 THEN 'Afternoon'
ELSE 'Evening'
END AS `Part of the Day`,
CASE
WHEN duration<=3 THEN 'Extra Short'
WHEN duration<=6 THEN 'Short'
WHEN duration<=10 THEN 'Long'
ELSE 'Extra Long'
END AS `Duration`
FROM games
ORDER BY name;

-- 16.	 Orders Table
-- USE orders;
SELECT product_name, order_date,
adddate(order_date,3) as 'pay_due',
adddate(order_date,INTERVAL 1 MONTH) as 'deliver_due'
FROM orders;