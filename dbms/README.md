

## 1. Why Do We Need a Database?

Databases are essential for:

- Persistent Data Storage: Unlike RAM, databases retain information even after a program ends.
- Organized Structure: Tabular structures with relationships allow efficient querying and updates.
- Security: User permissions, constraints, and transactions ensure controlled and secure access.
- Scalability: Databases support high volumes of data and concurrent users.
- Data Integrity: Constraints like `NOT NULL`, `UNIQUE`, `CHECK`, etc., enforce data rules.

---

## 2. Basic SQL Queries and Concepts

### 2.1 Data Retrieval

| Clause/Keyword | Purpose |
|----------------|---------|
| `SELECT` | Retrieve data from tables |
| `DISTINCT` | Remove duplicates |
| `WHERE` | Filter records |
| `AND`, `OR` | Combine conditions |
| `ORDER BY` | Sort results |
| `LIMIT` or `TOP` | Restrict number of results |
| `LIKE`, `%`, `_` | Pattern matching |
| `IN` | Match against a list |
| `BETWEEN` | Match range |
| `AS` | Rename columns/tables (aliasing) |

### 2.2 Data Manipulation

| Clause | Purpose |
|--------|---------|
| `INSERT INTO` | Add new rows |
| `UPDATE` | Modify existing rows |
| `DELETE` | Remove rows |
| SQL Injection | A security vulnerability when user input is not properly handled in queries |

### 2.3 Joins

| Type | Usage |
|------|-------|
| `INNER JOIN` | Only matching rows from both tables |
| `LEFT JOIN` | All from left + matching from right |
| `RIGHT JOIN` | All from right + matching from left |
| `FULL JOIN` | All from both sides (not supported directly in MySQL) |

### 2.4 Combining Tables

| Clause | Description |
|--------|-------------|
| `UNION` | Merge result sets (removes duplicates) |
| `UNION ALL` | Merge all (including duplicates) |
| `SELECT INTO` | Copy data into a new table |
| `INSERT INTO SELECT` | Copy data from one to another |

### 2.5 Database/Table Management

| Command | Description |
|---------|-------------|
| `CREATE DATABASE` | Make a new database |
| `CREATE TABLE` | Define table structure |
| `ALTER TABLE` | Modify schema (add, drop, rename columns, etc.) |
| `DROP` | Delete database/table permanently |

### 2.6 Constraints

| Type | Description |
|------|-------------|
| `NOT NULL` | Disallow NULLs |
| `UNIQUE` | Values must be different |
| `CHECK` | Validates conditions |
| `DEFAULT` | Assigns default value |
| `PRIMARY KEY` | Uniquely identifies rows |
| `FOREIGN KEY` | Enforces relationship with another table |

### 2.7 Auto Increment

- Automatically increases numeric values (commonly used for `id` fields)
- Defined using `AUTO_INCREMENT` in MySQL.

### 2.8 Indexes

- Indexes are used to speed up the retrieval of rows by using a pointer-like structure.
- They do **not** affect the actual data in tables but help optimize SELECT queries, especially on large datasets.
- Syntax: `CREATE INDEX index_name ON table_name(column_name);`
- Indexes can be single-column or composite (multi-column).
- Over-indexing can slow down INSERT and UPDATE operations.

### 2.9 Views

- A **view** is a virtual table based on the result of a `SELECT` query.
- Views do not store data themselves; they reference data stored in base tables.
- Useful for simplifying complex queries, providing security (by hiding certain columns), and abstracting data access.
- Syntax:
  ```sql
  CREATE VIEW view_name AS
  SELECT column1, column2 FROM table_name WHERE condition;

### NULL Handling
| Clause                      | Description                                          |
| --------------------------- | ---------------------------------------------------- |
| `IS NULL`                   | Checks if a column has a NULL value                  |
| `IS NOT NULL`               | Checks if a column has a non-NULL value              |
| `IFNULL(val, alt)`          | Returns `alt` if `val` is NULL                       |
| `COALESCE(val1, val2, ...)` | Returns the first non-NULL value among its arguments |


## 3. Aggregations and Grouping
SQL supports several aggregation functions used with GROUP BY for analyzing data.

| Function  | Purpose             |
| --------- | ------------------- |
| `COUNT()` | Counts rows         |
| `SUM()`   | Adds values         |
| `AVG()`   | Computes average    |
| `MAX()`   | Finds maximum value |
| `MIN()`   | Finds minimum value |

| Function  | Purpose             |
| --------- | ------------------- |
| `COUNT()` | Counts rows         |
| `SUM()`   | Adds values         |
| `AVG()`   | Computes average    |
| `MAX()`   | Finds maximum value |
| `MIN()`   | Finds minimum value |

```sql
SELECT department, COUNT(*) 
FROM employees 
GROUP BY department 
HAVING COUNT(*) > 10;
```

## 4. Callable Statement, Prepared Statement, and Stored Procedure

### 4.1 PreparedStatement

- A PreparedStatement is a precompiled SQL statement that allows you to bind variables.
- Improves performance and prevents SQL injection.
- Example:

```java
PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
ps.setString(1, "john@example.com");
ResultSet rs = ps.executeQuery();
```

### 4.2 CallableStatement
 - A CallableStatement is used to call stored procedures from Java.
- It allows interaction with pre-defined logic in the database.
- Example:
```java
CallableStatement cs = conn.prepareCall("{call getUser(?, ?)}");
cs.setInt(1, 1001); // input
cs.registerOutParameter(2, Types.VARCHAR); // output
cs.execute();
String name = cs.getString(2);
```

### 4.3 Stored Procedure

- A Stored Procedure is a set of SQL statements that perform a task, stored on the DB server.
- Helps with encapsulating logic, improving performance, and reducing network load.
- Example:

```sql
DELIMITER //
CREATE PROCEDURE getUser(IN userId INT, OUT userName VARCHAR(100))
BEGIN
  SELECT name INTO userName FROM users WHERE id = userId;
END //
DELIMITER ;
```

## 5. Concept of Normalization
Normalization is the process of organizing data in a database to reduce redundancy and improve integrity.

### Types of Normal Forms
1. First Normal Form (1NF): Eliminate repeating groups by ensuring atomic values.
2. Second Normal Form (2NF): Eliminate partial dependency on a composite key.
3. Third Normal Form (3NF): Eliminate transitive dependencies between non-key columns.
4. Boyce-Codd Normal Form (BCNF): A stricter version of 3NF where every determinant is a candidate key.

### Example
Unnormalized Table:
```scss
Student(ID, Name, Courses)
1, Alex, "Math, Physics"
```

### Normalized Form:
- Students(ID, Name)
- Courses(CourseID, Name)
- Enrollments(StudentID, CourseID)

Normalization avoids insertion, update, and deletion anomalies and supports efficient storage and querying.