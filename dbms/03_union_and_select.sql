-- UNION
SELECT name FROM users
UNION
SELECT dept_name FROM departments;

-- SELECT INTO (creates a new table from a query)
CREATE TABLE adult_users
SELECT * FROM users WHERE age >= 18;

SELECT * FROM adult_users;

-- INSERT INTO SELECT
INSERT INTO users (name, email, age)
SELECT name, email, age FROM adult_users;

SELECT * FROM users;