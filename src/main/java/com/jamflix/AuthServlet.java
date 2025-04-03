package com.jamflix;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthServlet extends HttpServlet {

   // DB config
   private static final String DB_URL = "jdbc:mysql://localhost:3306/jamflix";
   private static final String DB_USER = "jamflix_user"; // or 'root'
   private static final String DB_PASS = "password"; // match your DB password

   public AuthServlet() {}

   // Auth method using database
   public User checkAuth(String username, String password) {
      User user = null;

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

         String query = "SELECT * FROM users WHERE username = ? AND password = ?";
         PreparedStatement stmt = conn.prepareStatement(query);
         stmt.setString(1, username);
         stmt.setString(2, password); // plaintext for now

         ResultSet rs = stmt.executeQuery();
         if (rs.next()) {
            String role = rs.getString("role");
            System.out.println("Authenticated via DB: " + username + " with role: " + role);
            user = new User(username, password, role);
         }

         rs.close();
         stmt.close();
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return user;
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String username = req.getParameter("username");
      String password = req.getParameter("password");

      User user = checkAuth(username, password);

      if (user != null) {
         HttpSession session = req.getSession();
         session.setAttribute("user", user.username);
         session.setAttribute("group", user.group);

         if ("premium".equals(user.group)) {
            res.sendRedirect("premium.jsp");
         } else {
            res.sendRedirect("free.jsp");
         }
      } else {
         res.sendRedirect("login.jsp?error=1");
      }
   }
}