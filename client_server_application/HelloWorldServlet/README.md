# HelloWorldServlet

This simple dynamic web application demonstrates the basics of using **Java Servlets** and **JSP**. It prints a "Hello World" message via both a JSP page and a Servlet. It is ideal for beginners learning about Java EE, web.xml servlet mappings, and deploying servlets on Apache Tomcat using Eclipse IDE.

---

## 📁 Folder Structure

```
HelloWorldServlet/
├── .classpath                 # Eclipse project classpath settings
├── .gitignore                # Git ignore rules (optional)
├── .project                  # Eclipse project metadata
└── src/
    └── main/
        ├── java/
        │   └── HelloServlet.java       # Java servlet file (no package used)
        └── webapp/
            ├── META-INF/
            │   └── MANIFEST.MF         # Manifest file (standard Java web app metadata)
            ├── WEB-INF/
            │   └── web.xml             # Deployment descriptor for servlet mapping
            └── index.jsp               # Landing page (JSP)
```

---

## 🧑‍💻 How to Setup and Run the Project

Follow these steps to get the HelloWorldServlet project running inside Eclipse with Tomcat:

### 1. Clone the Repository

```bash
git clone https://github.com/Piyush-Tilokani/pre-joining-training.git
```


---

### 2. Open Project in Eclipse

1. Launch **Eclipse IDE**.
2. Go to `File > Open Projects from File System...` or `File > Import > Existing Projects into Workspace`.
3. Browse to:  
   `client_server_application/HelloWorldServlet`  
   and **finish** the import.

---

### 3. Setup Apache Tomcat Server (if not already)

1. In Eclipse, go to:
   `Window > Preferences > Server > Runtime Environments`
2. Click **Add...** → Select **Apache Tomcat v9.0**
3. Choose the directory where Tomcat 9 is installed (e.g., `C:\Apache\Tomcat9`)
4. Finish setup.

---

### 4. Run the Project

1. Right-click the `HelloWorldServlet` project.
2. Choose:
   `Run As > Run on Server`
3. Select your configured Tomcat 9 server.
4. Open your browser and go to:
   ```
   http://localhost:8080/HelloWorldServlet/
   ```

You should see the message:
```
Hello from JSP index page!
```

To access the Servlet directly:
```
http://localhost:8080/HelloWorldServlet/hello
```

This will display:
```
Hello from Servlet!
```

---

## ✅ Requirements

| Tool          | Version        |
|---------------|----------------|
| Java          | 18.0.2.1       |
| Eclipse IDE   | 2024-06 (4.33) |
| Apache Tomcat | 9.0.106          |
| Servlet API   | javax.servlet-api-3.0.1.jar           |

---

## Demonstration Screenshots
![image](https://github.com/user-attachments/assets/40079588-03e0-4019-9440-6cbcd78b37c5)

index.jsp page

![image](https://github.com/user-attachments/assets/67ef770c-7414-4128-af53-838030ca4d0c)

Servlet page

