-- CREATE TABLE with constraints
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    salary DECIMAL(10, 2) CHECK (salary >= 30000),
    dept_id INT DEFAULT 1,
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

-- This will fail since emp_name cannot be null
INSERT INTO employees (emp_id, emp_name, email, salary) VALUES (1, NULL, 'a@example.com', 50000);

-- Insert a valid row
INSERT INTO employees (emp_id, emp_name, email, salary, dept_id)
VALUES (1, 'Piyush', 'piyush@example.com', 50000, 1);

-- This will fail since email must be unique
INSERT INTO employees (emp_id, emp_name, email, salary, dept_id)
VALUES (2, 'Atharva', 'piyush@example.com', 45000, 2);

-- This will fail since salary must be at least 30000
INSERT INTO employees (emp_id, emp_name, email, salary, dept_id)
VALUES (3, 'LowPay', 'low@example.com', 20000, 3);

-- dept_id will default to 1
INSERT INTO employees (emp_id, emp_name, email, salary)
VALUES (2, 'Atharva', 'atharva@example.com', 60000);

SELECT * FROM employees;

-- FOREIGN KEY constraint
-- Assuming departments table already exists
ALTER TABLE employees ADD CONSTRAINT fk_dept FOREIGN KEY (dept_id) REFERENCES departments(dept_id);

-- This will fail since dept_id 10 does not exist in departments
INSERT INTO employees (emp_id, emp_name, email, salary, dept_id)
VALUES (4, 'UnknownDept', 'u@example.com', 50000, 10);

SELECT * FROM employees;