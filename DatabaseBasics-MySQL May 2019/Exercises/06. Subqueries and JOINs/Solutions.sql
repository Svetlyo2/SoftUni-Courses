
-- Exercises 1.	Employee Address
SELECT e.employee_id,e.job_title,e.address_id,a.address_text
FROM employees e
JOIN addresses AS a
ON a.address_id=e.address_id
ORDER BY e.address_id
LIMIT 5;

-- 2.	Addresses with Towns
SELECT e.first_name,	e.last_name,	t.name as town,a.address_text
FROM employees e
JOIN addresses AS a
ON a.address_id=e.address_id
JOIN towns t
ON t.town_id=a.town_id
ORDER BY e.first_name,e.last_name
LIMIT 5;

-- 3.	Sales Employee
SELECT e.employee_id,e.first_name,e.last_name,d.name as department_name
FROM employees e
JOIN departments AS d
ON d.department_id=e.department_id
WHERE d.name='Sales'
ORDER BY e.employee_id DESC;

-- 4.	Employee Departments
SELECT e.employee_id,e.first_name,e.salary,d.name as department_name
FROM employees e
JOIN departments AS d
ON d.department_id=e.department_id
WHERE e.salary>15000
ORDER BY e.department_id DESC
LIMIT 5;

-- 5.	Employees Without Project
SELECT e.employee_id,e.first_name
FROM employees e
LEFT JOIN employees_projects AS ep
ON ep.employee_id=e.employee_id
WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

-- 6.	Employees Hired After
SELECT e.first_name,e.last_name,e.hire_date,d.name as dept_name
FROM employees e
JOIN departments AS d
ON e.department_id=d.department_id
WHERE  d.name IN ('Sales','Finance') AND date(e.hire_date)>'1999/01/01'
ORDER BY e.hire_date;
-- 7.	Employees with Project
SELECT e.employee_id,e.first_name,p.name as project_name
FROM employees e
JOIN employees_projects AS ep
ON ep.employee_id=e.employee_id
JOIN projects AS p
ON ep.project_id=p.project_id
WHERE date( p.start_date)>'2002-08-13' AND p.end_date IS NULL
ORDER BY e.first_name,p.name
LIMIT 5;
-- 8.	Employee 24
SELECT e.employee_id,e.first_name,
IF(YEAR(p.start_date) >= 2005,
        NULL,
        p.name) AS 'project_name'
FROM employees e
JOIN employees_projects AS ep
ON ep.employee_id=e.employee_id
JOIN projects AS p
ON ep.project_id=p.project_id
WHERE e.employee_id=24
ORDER BY p.name;
-- 9.	Employee Manager
SELECT e.employee_id,e.first_name,e.manager_id, c.first_name as manager_name
FROM employees e
JOIN employees c
ON c.employee_id=e.manager_id
WHERE e.manager_id IN(3,7)
ORDER BY e.first_name;

-- 10.	Employee Summary
SELECT e.employee_id,
	concat(e.first_name,' ',e.last_name) as employee_name,
	concat(c.first_name,' ',c.last_name) as manager_name,
	d.name as department_name
FROM employees e
JOIN employees c
ON c.employee_id=e.manager_id
JOIN departments d
ON d.department_id=e.department_id
ORDER BY e.employee_id
LIMIT 5;

-- using subquery
SELECT e2.`employee_id`,
concat(e2.`first_name`,' ', e2.`last_name`) as employee_name, 
(
SELECT concat(e3.`first_name`,' ', e3.`last_name`) 
FROM employees e3
WHERE e3.`employee_id`=e2.manager_id
) as manager_name,d.name
FROM employees e
JOIN `employees` e2
ON e2.`manager_id`=e.`employee_id`
JOIN `departments`d
ON d.`department_id`=e2.`department_id`
ORDER BY e2.`employee_id`
LIMIT 5;

-- 11.	Min Average Salary
SELECT avg(e.salary) as `min_average_salary`
FROM employees e
GROUP BY e.department_id
ORDER BY `min_average_salary`
LIMIT 1;

-- 12.	Highest Peaks in Bulgaria
-- USE `geography`;

SELECT mc.country_code,m.mountain_range,p.peak_name,p.elevation
FROM mountains_countries as mc
JOIN mountains as m
ON m.id=mc.mountain_id
JOIN peaks p
ON p.mountain_id=m.id
WHERE mc.country_code='BG' AND p.elevation>2835
ORDER BY p.elevation DESC;

-- 13.	Count Mountain Ranges
SELECT mc.country_code,COUNT(mc.mountain_id) as `mountain_range`
FROM mountains_countries as mc
JOIN countries c
ON c.country_code=mc.country_code
WHERE c.country_name IN ('United States','Russia','Bulgaria')
GROUP BY mc.country_code
ORDER BY `mountain_range`DESC;

-- 14.	Countries with Rivers
SELECT c.country_name,	r.river_name
FROM countries c
LEFT JOIN countries_rivers cr
ON cr.country_code=c.country_code
LEFT JOIN rivers r
ON r.id=cr.river_id
JOIN continents ct
ON ct.continent_code=c.continent_code
WHERE ct.continent_name='Africa'
ORDER BY c.country_name
LIMIT 5;

-- 15.	*Continents and Currencies
SELECT continent_code,	currency_code, COUNT(c.currency_code) as `currency_usage`
FROM countries c
GROUP BY continent_code,c.currency_code
HAVING `currency_usage`>1
AND `currency_usage`=(
SELECT COUNT(*) as cn
FROM countries c2
WHERE c2.continent_code=c.continent_code
GROUP BY c2.currency_code
ORDER BY cn DESC
LIMIT 1
)
ORDER BY c.continent_code;

-- 16.	Countries without any Mountains
SELECT COUNT(c.country_code) as country_count
FROM countries c
LEFT JOIN mountains_countries as mc
ON c.country_code=mc.country_code
WHERE mc.mountain_id IS NULL;

-- 17.	Highest Peak and Longest River by Country
SELECT c.country_name,MAX(p.elevation) as `highest_peak_elevation`, 
MAX(r.length) as	`longest_river_length`
FROM countries c
LEFT JOIN countries_rivers cr
ON cr.country_code=c.country_code
LEFT JOIN rivers r
ON r.id=cr.river_id
LEFT JOIN mountains_countries as mc
ON c.country_code=mc.country_code
LEFT JOIN peaks p
ON p.mountain_id=mc.mountain_id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC,`longest_river_length`DESC,c.country_name
LIMIT 5;
