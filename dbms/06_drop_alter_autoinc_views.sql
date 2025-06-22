-- DROP TABLE
DROP TABLE IF EXISTS old_table;

-- ALTER TABLE
ALTER TABLE employees ADD COLUMN join_date DATE;

-- VIEW
CREATE VIEW view_engineers AS
SELECT emp_name, email FROM employees WHERE dept_id = 1;

-- Use view
SELECT * FROM view_engineers;