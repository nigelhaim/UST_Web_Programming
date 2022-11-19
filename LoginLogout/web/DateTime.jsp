<%-- 
    Document   : DateTime
    Created on : 11 19, 22, 5:27:02 PM
    Author     : andy
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
            }
        
        %>
        <h1>Welcome ${username}</h1>
         <%
         Date date = new Date();
         out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
         %>
        
        <form action="logout">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
