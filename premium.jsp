<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String user = (String) session.getAttribute("user");
  String group = (String) session.getAttribute("group");

  if (user == null) {
    response.sendRedirect("login.jsp");
    return;
  }

  if (!"premium".equals(group)) {
    response.sendRedirect("free.jsp"); // or maybe a “not authorized” page
    return;
  }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Jamflix</title>
    </head>

    <body>
        <h1>JamFlix</h1>
        <br><br>
        <p>Welcome, <%= user %>! You are a <%= group %> member.</p>
        <br><br>
        <h2> premium Section</h2>
        <br><br>
        

        <!-- Login Free premium-->
        <a href="login.jsp">Login</a>
        <a href="free.jsp">Free</a>
        <a href="premium.jsp">premium</a>
        <a href="logout.jsp">Logout</a>

    </body>
</html>
