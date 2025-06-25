# Client-Server Application (Servlets & JSP)

This module explores the fundamentals of client-server interaction using **Java Servlets**, **JSP (JavaServer Pages)**, and web deployment descriptors like `web.xml`. The project is built using **Java**, hosted with **Tomcat**, and integrated with **MySQL**.

---

## 1. Servlets, JSP, and Servlet Mapping

### Servlets
- A **Servlet** is a Java class that handles HTTP requests and generates dynamic content.
- Lifecycle methods include `init()`, `service()`, and `destroy()`.
- They are deployed on a Servlet container (like Tomcat).

### JSP (JavaServer Pages)
- JSP allows embedding Java code in HTML using special tags.
- Compiled to Servlets internally by the container.
- Ideal for creating the **View** layer in MVC architecture.

### Mapping Servlets
Servlets can be mapped in two ways:

#### 1. Using `web.xml`
```xml
<servlet>
  <servlet-name>HelloServlet</servlet-name>
  <servlet-class>com.example.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
  <servlet-name>HelloServlet</servlet-name>
  <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

#### 2. Using Annotations
```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    // Servlet logic here
}
```
[Learn more → Oracle Java EE Servlet Mapping](https://docs.oracle.com/javaee/6/tutorial/doc/gilik.html)

---

## 2. HTTP Methods and Status Codes

### HTTP Methods
| Method   | Description |
|----------|-------------|
| `GET`    | Retrieves data |
| `POST`   | Sends data to the server |
| `PUT`    | Updates existing data |
| `DELETE` | Deletes specified data |
| `HEAD`   | Similar to GET, but no response body |
| `OPTIONS`| Returns HTTP methods supported |
| `PATCH`  | Partially updates a resource |

### Common HTTP Status Codes
| Code | Meaning |
|------|---------|
| `200 OK` | Request succeeded |
| `201 Created` | Resource created successfully |
| `204 No Content` | Success, but no content to return |
| `400 Bad Request` | Malformed syntax or invalid data |
| `401 Unauthorized` | Authentication required |
| `403 Forbidden` | Valid request, but server refuses |
| `404 Not Found` | Resource not found |
| `500 Internal Server Error` | Server error |
| `503 Service Unavailable` | Server temporarily overloaded/down |

More details: [REST API HTTP Status Codes](http://www.restapitutorial.com/httpstatuscodes.html)

---

## Tools Used

| Tool                     | Version         |
|--------------------------|------------------|
| Java                     | 18.0.2.1         |
| Eclipse IDE              | 4.33             |
| MySQL                    | 8.0.42           |
| MySQL Connector JAR      | mysql-connector-j-9.3.0.jar |
| Tomcat                   | 9.0.106          |
