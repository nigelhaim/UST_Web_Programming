<%-- 
    Document   : index
    Created on : 11 2, 22, 11:58:49 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %> 
<%@page import="java.util.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to UST Overflow</h1>
        <form method="post" action="PostServlet" enctype="multipart/form-data">
            <h1>Ask something</h1>
            <h1>Note title:</h1><input id="head" name="head" size="15"><br>
            <h2>Note content:</h2><input id="cont" name="cont" size="15"><br>     
            <h2>Input Picture:</h2>
            <input type="file" accept="image/png, image/jpg" name="file">
            <br>
            <input type="submit" value="submit" />
        </form>
        
        <br>
        
        <%
            try{
                String contextPath = getServletContext().getRealPath("/entries");
                File Filepath = new File(contextPath);
                if(Filepath.exists()){
                    File path = new File(contextPath);
                    File [] filename= path.listFiles();
                    for (File folder_file : filename) {
                        if(folder_file.isDirectory ()){
                            for(final File file:folder_file.listFiles()){
                                if(file.getName().endsWith(".txt")){
                                    out.print("<form method=" + "\"get\"" + "action=" + "\"ShowEntry\"" + ">" + 
                                    "<input type="+ "\"submit\"" + "name=" + "\"showEntry\"" + "value=" + "\"" + file.getName() + "\"" + ">" + 
                                    "</form>" + 
                                    "<br>");
                                }
                            }
                        }
                    } 
                }
            }catch(Exception e){
                out.print("Not Entries");
            } 
        %>
    </body>
</html>
