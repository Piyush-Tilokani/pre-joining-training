package com.piyush;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("name", rs.getString("name"));
                res.sendRedirect("welcome.jsp");
            } else {
                req.setAttribute("error", "Invalid credentials.");
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
