<%-- 
    Document   : index
    Created on : 11 2, 22, 11:58:49 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to UST Overflow</h1>
        <form method="get" action="PostServlet">
            <h1>Ask something</h1>
            <input id="ask" name="ask" size="15"><br>
            <input type="submit" value="submit" />      
        </form>
        
        <br>
        
        <% 
            String folderpath = "C:/Users/User/Documents/Nigel_Folder/UST_RedditOverflow/data";
            File f = new File(folderpath);
            File [] filename= f.listFiles();
            for (File file : filename) {
                if(file.isFile()){
                out.print(file.getName()+"<br>");
                }else{
                    if(file.isDirectory()){
                        out.print(file.getName()+"<br>");
                    }
                }
            }
        %>
    </body>
</html>
