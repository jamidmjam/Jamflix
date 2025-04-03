<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String user = (String) session.getAttribute("user");
  if (user == null) {
    response.sendRedirect("login.jsp");
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
        <h2> Free Section</h2>
        <br><br>
        

        <!-- Login Free premium-->
        <a href="login.jsp">Login</a>
        <a href="free.jsp">Free</a>
        <a href="premium.jsp">premium</a>
        <a href="logout.jsp">Logout</a>

    </body>
</html>
