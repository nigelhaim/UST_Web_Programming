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
        <link rel="stylesheet" type="text/css" href="./styles.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to UST Overflow</h1>
        <form method="post" action="PostServlet" enctype="multipart/form-data">
            <h1>Ask something</h1>
            <h2>Input File:</h2>
            <br>
            
            <input type="file" class="fileInput" accepts=".pdf, .java, .jsp, .html, .css,.js, .doc, .docx" name="file" />
            <br>
            <h2>File Description:</h2><textarea id="cont" name="cont" size="15" class="description"></textarea><br>   
            <br>
            <input type="submit" value="submit" name="submit" />
        </form>
        
        <br>
        <form method="get" action="CategoriesServlet">
            <label>Categories: </label>
            <select name ="categories" onchange='if(this.value !== 0) { this.form.submit(); }'>
                <option value= '0'>Select</option>
                <option value='All'>All Files</option>
                <option value='.java'>.java</option>
                <option value='.jsp'>.jsp</option>
                <option value='.html'>.html</option>
                <option value='.css'>.css</option>
            </select>
        </form>
        <%
            List file_list;
            try{
                file_list = (List)request.getAttribute("file_list");
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
                }
            }catch(NullPointerException e){
                file_list = new ArrayList<String>();
            }
        %>
    </body>
</html>
