-- CREATE DATABASE 
CREATE DATABASE company;
USE company;

-- Create a sample table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    age INT
);

-- Insert sample data
INSERT INTO users (name, email, age) VALUES
('Piyush', 'piyush@gmail.com', 25),
('Atharva', 'atharva@gmail.com', 30),
('Shashwat', 'shashwat@gmail.com', 17),
('Piyush', 'duplicate@gmail.com', 25);

-- SELECT
SELECT * FROM users;

-- DISTINCT
SELECT DISTINCT name FROM users;

-- WHERE
SELECT * FROM users WHERE age > 18;

-- AND / OR
SELECT * FROM users WHERE age > 18 AND name = 'Piyush';
SELECT * FROM users WHERE age < 18 OR name = 'Atharva';

-- ORDER BY AND LIMIT
SELECT * FROM users ORDER BY age DESC;
SELECT * FROM users ORDER BY age DESC LIMIT 3;

-- LIKE / WILDCARDS
SELECT * FROM users WHERE name LIKE 'P%';

-- IN / BETWEEN
SELECT * FROM users WHERE age IN (17, 25);
SELECT * FROM users WHERE age BETWEEN 18 AND 30;

UPDATE users SET age = 15 WHERE id = 4;

-- ALIASES
SELECT name AS username, email AS email_address FROM users;

-- SQL injection
DELETE FROM users WHERE name = ' ' OR '1'='1';