


# LoginSignupApp

This is a simple web application developed using **JSP**, **Servlets**, and **MySQL** that allows users to **register**, **login**, and **logout**. It includes form validations using JavaScript and uses a MySQL database for storing user data.

---

## 📁 Folder Structure

```
LoginSignupApp/
│
├── .classpath
├── .gitignore
├── .project
│
├── src/main/
│   ├── java/
│   │   ├── db.properties.example     # Sample DB config file (rename to db.properties)
│   │   └── com/piyush/
│   │       ├── DBUtil.java           # Utility class for DB connection
│   │       ├── LoginServlet.java     # Handles login logic
│   │       ├── LogoutServlet.java    # Handles logout logic
│   │       └── RegisterServlet.java  # Handles registration logic
│   │
│   └── webapp/
│       ├── META-INF/
│       │   └── MANIFEST.MF
│       │
│       ├── WEB-INF/
│       │   ├── web.xml               # Servlet mappings and app configuration
│       │   └── lib/
│       │       └── mysql-connector-j-9.3.0.jar  # MySQL JDBC driver
│       │
│       ├── index.jsp                 # Login page
│       ├── register.jsp              # Registration page
│       ├── welcome.jsp              # Welcome page post login
│       └── js/
│           └── validation.js        # Client-side form validations
```
---

## ⚙️ Setup & Run Instructions

### 1. Clone the Repository

```bash
git https://github.com/Piyush-Tilokani/pre-joining-training
cd client_server_application/LoginSignupApp
````

### 2. Open in Eclipse

* Open **Eclipse IDE for Enterprise Java Developers**.
* Go to `File → Open Projects from File System...` or `File → Import → Existing Projects into Workspace`.
* Select the `LoginSignupApp` directory as the root and import the project.

### 3. Database Configuration

* In `src/main/java/`, rename `db.properties.example` to `db.properties`.
* Edit the file to include your actual MySQL credentials:

```properties
db.url=jdbc:mysql://localhost:3306/your_database_name
db.user=root
db.password=your_password
```

### 4. MySQL Setup

* Make sure **MySQL** is installed and running.
* Create the database and users table manually using MySQL Workbench or CLI:

```sql
CREATE DATABASE login_db;

USE login_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);
```

### 5. Configure Tomcat Server

* In Eclipse:

  * Go to `Servers` tab → Add a new server → Select **Apache Tomcat v9.0**.
  * Point to your Tomcat 9 installation directory.
  * Add the `LoginSignupApp` project to the server.
* Ensure that port **8080** or any other available port is set.

### 6. Add JAR Dependencies

* Confirm the presence of `mysql-connector-j-9.3.0.jar` in:

  ```
  src/main/webapp/WEB-INF/lib/
  ```

* If it's not working:

  * Right-click project → Build Path → Configure Build Path → Add JARs → select the connector jar.

---

## 💡 Features

* **Registration**:

  * Checks for duplicate email.
  * Validates fields using JavaScript.
* **Login**:

  * Authenticates credentials against MySQL.
  * Shows error message on failure.
* **Logout**:

  * Destroys session and redirects to login page.
* **Client-Side Validations**:

  * Uses vanilla JavaScript to validate age, password strength, etc.

---

## 🛠️ Technologies Used

| Tool/Technology | Version          |
| --------------- | ---------------- |
| Java            | 18.0.2.1         |
| Eclipse IDE     | 2023-06 (4.33.0) |
| Apache Tomcat   | 9.0.x            |
| MySQL           | 8.0.42           |
| mysql-connector | 9.3.0            |

---

## Demonstration Screenshots

![image](https://github.com/user-attachments/assets/6aa5b69e-95df-4cb8-bab6-87038dbe6d05)

Home page of the app

![image](https://github.com/user-attachments/assets/b2327dfd-fb0e-43ef-9a12-06bbc97affb6)

Registration page

![image](https://github.com/user-attachments/assets/fb709af2-8e96-4c51-85cf-4d8a4f6e6df3)

input validation for email

![image](https://github.com/user-attachments/assets/2c23f22b-8b48-40ac-83d7-c36204a4d7ea)

input validation for password

![image](https://github.com/user-attachments/assets/15b131e9-53a3-4dbb-9add-5285df093468)

After entering the valid data, user is registered in the MySQL database

![image](https://github.com/user-attachments/assets/2e952aac-13ba-4e1a-b3b8-77c566d661c1)

On submitting wrong credentials

![image](https://github.com/user-attachments/assets/70cd50b0-2592-487f-bf6c-50fe9c81b65e)
 
Access to the welcome page is denied and the user is redirected again to the login page


![image](https://github.com/user-attachments/assets/aafcb20f-d4c3-40f0-a6c4-3c806321b294)

After entering the right credentials, the user is logged in and greeted with Welcome message and their name


![image](https://github.com/user-attachments/assets/dc819f45-a6da-4358-b1c7-5f21fab1b3bc)

After logout, the user is redirected to the login page


