-- Create department table
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

INSERT INTO departments (dept_id, dept_name) VALUES
(1, 'Engineering'),
(2, 'Marketing');

-- Add foreign key to users table
ALTER TABLE users ADD dept_id INT;
UPDATE users SET dept_id = 1 WHERE name = 'Piyush';
UPDATE users SET dept_id = 2 WHERE name = 'Atharva';

-- INNER JOIN
SELECT u.name, d.dept_name
FROM users u
INNER JOIN departments d ON u.dept_id = d.dept_id;

-- LEFT JOIN
SELECT u.name, d.dept_name
FROM users u
LEFT JOIN departments d ON u.dept_id = d.dept_id;

-- RIGHT JOIN
SELECT u.name, d.dept_name
FROM users u
RIGHT JOIN departments d ON u.dept_id = d.dept_id;

-- FULL JOIN (simulate using UNION)
SELECT u.name, d.dept_name
FROM users u
LEFT JOIN departments d ON u.dept_id = d.dept_id
UNION
SELECT u.name, d.dept_name
FROM users u
RIGHT JOIN departments d ON u.dept_id = d.dept_id;