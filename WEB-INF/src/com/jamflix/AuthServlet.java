package com.jamflix;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class AuthServlet extends HttpServlet {

    public static class User {
        String username;
        String password;
        String group;
        User(String u, String p, String g) {
            username = u; password = p; group = g;
        }
    }

    public ArrayList<User> returnArrayList() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("user1", "password", "free"));
        users.add(new User("user2", "password", "premium"));
        return users;
    }

    public User checkAuth(String username, String password) {
        for (User u : returnArrayList()) {
            if (u.username.equals(username) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

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



