-- Create an index on salary to optimize search
CREATE INDEX idx_salary ON employees(salary);

-- Without index: Full Table Scan
-- With index: Much faster when table is large
SELECT * FROM employees WHERE salary > 50000;

-- View all indexes on employees table
SHOW INDEX FROM employees;

-- Drop an index (if needed)
DROP INDEX idx_salary ON employees;