package com.piyush;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(name, email, password) VALUES (?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            res.sendRedirect("index.jsp");
        } catch (SQLIntegrityConstraintViolationException e) {
            req.setAttribute("error", "Email already registered.");
            req.getRequestDispatcher("register.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
