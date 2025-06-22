-- NULL values
INSERT INTO users (name, email, age) VALUES ('Test User', NULL, NULL);

-- IS NULL / IS NOT NULL
SELECT * FROM users WHERE email IS NULL;
SELECT * FROM users WHERE email IS NOT NULL;

-- GROUP BY
SELECT age, COUNT(*) FROM users GROUP BY age;

-- GROUP BY with HAVING
SELECT age, COUNT(*) AS user_count
FROM users
GROUP BY age
HAVING user_count > 1;

-- Built-in functions
SELECT UPPER(name), LENGTH(email), NOW() FROM users;

-- NULL functions
SELECT IFNULL(email, 'No Email') AS email_status FROM users;
SELECT COALESCE(email, 'Not Provided') FROM users;