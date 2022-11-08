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
            <h2>Input File:</h2>
            <br>
            <input type="file" accepts=".pdf, .java, .jsp, .html, .css,.js, .doc, .docx" name="file">
            <br>
            <h2>File Description:</h2><textarea id="cont" name="cont" size="15"></textarea><br>   
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
        <!-- comment<%
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
                                    String txtfilename = file.getName().toString();
                                    out.print("<form method=" + "\"get\"" + "action=" + "\"ShowEntry\"" + ">" + 
                                    "<button type="+ "\"submit\"" + "name=" + "\"showEntry\"" + "value=" + "\"" + txtfilename.substring(0, txtfilename.length()-4) + "\"" + "/>" + 
                                    txtfilename.substring(0, txtfilename.length()-4).replaceAll("_", " ") + "</button>" + 
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
        %>-->
    </body>
</html>
