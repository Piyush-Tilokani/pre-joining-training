<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    String name = (session != null) ? (String) session.getAttribute("name") : null;
    if (name == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body { font-family: Arial; background-color: #e6ffe6; padding: 50px; }
        .container { width: 400px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; text-align: center; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= name %>!</h2>
        <form action="logout" method="get">
            <button type="submit">Logout</button>
        </form>
    </div>
</body>
</html>
