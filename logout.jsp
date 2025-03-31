<%
  session.invalidate(); // Kill the session
  response.sendRedirect("login.jsp");
%>