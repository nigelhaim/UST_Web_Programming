<%-- 
    Document   : categorized_files
    Created on : 11 6, 22, 9:00:51 PM
    Author     : nigel
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.print(request.getAttribute("category")); %></title>
    </head>
    <body>
        <h1>
            <% out.print(request.getAttribute("category")); %> Files
        </h1>
            <%
                List file_list = (List)request.getAttribute("file_list");
                Iterator<String> it = file_list.iterator();
                
                while(it.hasNext()){
                    String og_filename = it.next();
                    int num = og_filename.lastIndexOf('.');
                    String nw_filename = og_filename.substring(0, num);
                    out.print("<form method=" + "\"get\"" + "action=" + "\"ShowEntry\"" + ">" + 
                                    "<button type="+ "\"submit\"" + "name=" + "\"showEntry\"" + "value=" + "\"" + og_filename + "\"" + "/>" + 
                                    nw_filename + "</button>" + 
                                    "</form>" + 
                                    "<br>");
                    out.print("<form method=" + "\"post\"" + "action=" + "\"DeleteServlet\"" + ">" + 
                    "<button type="+ "\"submit\"" + "class=" + "\"delete\"" + "name=" + "\"DeleteServlet\"" + "value=" + "\"" +og_filename + "\"" + "/>" + 
                    "Delete" + "</button>" + 
                    "</form>" + 
                    "<br>");
                }
                
            %>
    </body>
</html>
