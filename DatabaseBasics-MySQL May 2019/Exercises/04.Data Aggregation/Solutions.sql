
-- Exercises

-- USE `gringotts`;
SELECT count(id) FROM wizzard_deposits;

--  Longest Magic Wand
SELECT max(magic_wand_size) as longest_magic_wand
FROM wizzard_deposits;

-- 3.Longest Magic Wand per Deposit Groups
SELECT deposit_group,max(magic_wand_size) as `longest_magic_wand`
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY `longest_magic_wand`,deposit_group;

-- 4.	 Smallest Deposit Group per Magic Wand Size
SELECT deposit_group
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY avg(magic_wand_size)
LIMIT 1;

-- 5.	 Deposits Sum
SELECT deposit_group, sum(deposit_amount) as `total_sum`
FROM wizzard_deposits
GROUP BY deposit_group
ORDER BY total_sum;

-- 6.	 Deposits Sum for Ollivander family
SELECT deposit_group, sum(deposit_amount) as `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator`='Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

-- 7.	Deposits Filter
SELECT deposit_group, sum(deposit_amount) as `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator`='Ollivander family'
GROUP BY deposit_group
HAVING total_sum<150000
ORDER BY total_sum DESC;

-- 8.	 Deposit charge
SELECT deposit_group, magic_wand_creator,min(deposit_charge) as min_deposit_charge
FROM wizzard_deposits
GROUP BY deposit_group, magic_wand_creator
ORDER BY magic_wand_creator,deposit_group;

-- 9. Age Groups
SELECT
CASE
WHEN age BETWEEN 0 AND 10 THEN '[0-10]'
WHEN age BETWEEN 11 AND 20 THEN '[11-20]'
WHEN age BETWEEN 21 AND 30 THEN '[21-30]'
WHEN age BETWEEN 31 AND 40 THEN '[31-40]'
WHEN age BETWEEN 41 AND 50 THEN '[41-50]'
WHEN age BETWEEN 51 AND 60 THEN '[51-60]'
ELSE '[61+]'
END AS `age_group`,
COUNT(id) as wizard_count
FROM wizzard_deposits
GROUP BY age_group
ORDER BY age_group;

-- 10. First Letter
SELECT left(first_name,1) as `first_letter`
FROM wizzard_deposits
WHERE deposit_group='Troll Chest'
GROUP BY first_letter
ORDER BY first_letter;

-- 11.	Average Interest 
SELECT deposit_group,is_deposit_expired, avg(deposit_interest) as average_interest
FROM wizzard_deposits
WHERE deposit_start_date>'1985-01-01'
GROUP BY deposit_group,is_deposit_expired
ORDER BY deposit_group DESC,is_deposit_expired;

-- 12.	Rich Wizard, Poor Wizard *
SELECT sum(diff_current_next) as 'sum_difference'
FROM
(
  SELECT (wd1.deposit_amount-
	(SELECT wd2.deposit_amount
	FROM wizzard_deposits wd2
	WHERE wd2.id=wd1.id+1
	)
  ) AS `diff_current_next`
  FROM wizzard_deposits wd1 
)AS sum_difference;

-- 13.	 Employees Minimum Salaries
-- USE `soft_uni`;
SELECT department_id,min(salary) as minimum_salary
FROM employees
WHERE year(hire_date)>1999 AND department_id IN (2,5,7)
GROUP BY department_id
ORDER BY department_id;

-- 14.	Employees Average Salaries
CREATE TABLE High_paid
SELECT * FROM employees
WHERE salary>30000;
DELETE FROM High_paid
WHERE manager_id = 42;
UPDATE High_paid
SET salary=salary+5000
WHERE department_id =1;
SELECT department_id,avg(salary) as avg_salary
FROM High_paid
GROUP BY department_id
ORDER BY department_id;

-- 15. Employees Maximum Salaries
SELECT department_id,max(salary) as max_salary
FROM employees
GROUP BY department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000
ORDER BY department_id;

-- 16.	Employees Count Salaries
SELECT count(salary)
FROM employees
WHERE manager_id is NULL;

-- 17.	3rd Highest Salary* 
SELECT department_id,
(
	SELECT DISTINCT e2.salary 
	FROM employees e2
	WHERE e2.department_id=e1.department_id
	ORDER BY e2.salary DESC
	LIMIT 2,1
) as `third_highest_salary`
FROM employees e1
GROUP BY department_id
HAVING `third_highest_salary` IS NOT NULL;

-- 18. Salary Challenge **
-- Write a query that returns:
-- •	first_name
-- •	last_name
-- •	department_id
-- for all employees who have salary higher than the average salary of their 
-- respective departments. Select only the first 10 rows. Order by department_id.

SELECT 
    `e`.`first_name`, `e`.`last_name`, `e`.`department_id`
FROM`employees` AS `e`
    JOIN
    (SELECT 
        `department_id`, AVG(`salary`) AS 'dep_avg_salary'
    FROM `employees`
    GROUP BY `department_id`) AS `avrg` 
    ON `e`.`department_id` = `avrg`.`department_id`
WHERE `salary` > `avrg`.`dep_avg_salary`
ORDER BY `department_id`
LIMIT 10;

-- 19.	Departments Total Salaries
SELECT department_id,sum(salary) as total_salary
FROM employees
GROUP BY department_id;

