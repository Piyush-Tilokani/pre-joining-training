package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JDBCDemo {
    public static void main(String[] args) {
    	
    	Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("src/config.properties")) {
            // Load database config from properties file
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error reading properties file: " + e.getMessage());
            return;
        }

        // Securely access the database connection properties from the properties file
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        try {
            // 1. Establishing connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");

            // 2. Creating a Statement to execute SQL commands
            Statement stmt = conn.createStatement();

            // 3. Creating an employee table if it doesn't exist
            String createTable = """
                CREATE TABLE IF NOT EXISTS employee (
                    id INT PRIMARY KEY,
                    name VARCHAR(100),
                    department VARCHAR(100),
                    salary DOUBLE
                );
                """;
            stmt.execute(createTable);
            System.out.println("Employee table is ready.");

            // 4. Inserting records into the employee table
            String insert = """
                INSERT INTO employee (id, name, department, salary)
                VALUES (1, 'Piyush', 'Engineering', 60000),
                       (2, 'Shashwat', 'Marketing', 52000),
                       (3, 'Atharva', 'Finance', 58000)
                ON DUPLICATE KEY UPDATE name = VALUES(name);
                """;
            stmt.executeUpdate(insert);
            System.out.println("Employee data inserted or updated.");

            // 5. Retrieving and displaying all employee records
            String select = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(select);
            System.out.println("\nEmployee Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.printf("ID: %d | Name: %s | Dept: %s | Salary: ₹%.2f%n", id, name, dept, salary);
            }

            // 6. Updating salary for an employee
            String update = "UPDATE employee SET salary = salary + 5000 WHERE name = 'Piyush'";
            stmt.executeUpdate(update);
            System.out.println("\nUpdated salary for Piyush.");

            // 7. Deleting an employee record
            String delete = "DELETE FROM employee WHERE id = 2";
            stmt.executeUpdate(delete);
            System.out.println("Deleted employee with ID = 2.");

            // 8. Final state of the table
            System.out.println("\nFinal Employee Records:");
            rs = stmt.executeQuery(select);
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Dept: %s | Salary: ₹%.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"));
            }

            // 9. Closing the resources
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\nConnection closed.");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}