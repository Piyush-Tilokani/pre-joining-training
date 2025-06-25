<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <script src="js/validation.js"></script>
    <style>
        body { font-family: Arial; background-color: #f4f4f4; padding: 50px; }
        .container { width: 400px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; }
        .error { color: red; margin-bottom: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Register</h2>

        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <div class="error"><%= error %></div>
        <% } %>

        <form action="register" method="post" onsubmit="return validateRegisterForm();">
            <label>Name:</label>
            <input type="text" name="name" id="regName" required><br><br>

            <label>Email:</label>
            <input type="email" name="email" id="regEmail" required><br><br>

            <label>Password:</label>
            <input type="password" name="password" id="regPassword" required><br><br>

            <button type="submit">Register</button>
        </form>

        <p>Already registered? <a href="index.jsp">Login here</a></p>
    </div>
</body>
</html>
