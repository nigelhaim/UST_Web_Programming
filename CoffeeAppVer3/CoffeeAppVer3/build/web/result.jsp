<%-- 
    Document   : result
    Created on : Oct 25, 2021, 6:18:02 AM
    Author     : Lawrence
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <h1>Coffee Recommendations JSP</h1>
        <p><br> Try these drinks: <br>
            <%
                List coffeeList = (List)request.getAttribute("coffeeList");
                Iterator<String> it = coffeeList.iterator();
                
                while(it.hasNext())
                {
                    out.print("<br>" + it.next());
                }
            %>
        
        </p>
    </body>
</html>
