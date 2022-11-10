<%-- 
    Document   : index
    Created on : 11 10, 22, 4:45:40 PM
    Author     : reiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %> 
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="./styles.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins&display=swap">
        <title>Main Page for Notes App</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body class="body">
        <nav id="side-bar">
            <header id="nav">code 2 go</header>
            <div class="nav">
                <form method="get" action="CategoriesServlet">
                    <label class="category" for="categories">Categories:</label>
                    <div class="custom-select">
                        <select name="categories" class="categories" onchange='if(this.value !== 0) { this.form.submit(); }'>
                            <option value='0' selected disabled hidden>Select</option>
                            <option value='All'>All Files</option>
                            <option value='.java'>.java</option>
                            <option value='.jsp'>.jsp</option>
                            <option value='.html'>.html</option>
                            <option value='.css'>.css</option>
                        </select>
                    </div>
                </form>
            </div>
        </nav>

        <div class="work-bar">
            <form method="post" action="PostServlet" enctype="multipart/form-data">
                <h2>Code it down...</h2>
                    <div class="file-bar">
                        <label class="submit">Input a file:</label>
                        <input type="file" id="file" accepts=".pdf, .java, .jsp, .html, .css,.js, .doc, .docx" name="file">
                        <label class="submit">File Description:
                            <textarea id="cont" name="cont" rows="5" cols="70" placeholder="Type something (except coding terms)..."></textarea>
                        </label>
                        <input type="submit" id="submit" value="Submit" />
                    </div>
            </form>
        </div>
            
        <nav class="all-files">
            <%
                List fileList;
                try
                {
                    fileList = (List)request.getAttribute("fileList");
                    Iterator<String> it = fileList.iterator();

                    while(it.hasNext())
                    {
                        String origFilename = it.next();
                        int num = origFilename.lastIndexOf('.');
                        String newFilename = origFilename.substring(0, num);
                        out.print("<form method=" + "\"get\"" + "action=" + "\"ShowEntry\"" + ">");
                        out.print("<button type="+ "\"submit\"" + "class=" + "\"list-obj\"" + "name=" + "\"showEntry\"" + "value=" + "\"" + origFilename + "\"" + "/>" + newFilename);
                        out.print("</button>");
                        out.print("</form>");
                        out.print("<form method=" + "\"post\"" + "action=" + "\"DeleteServlet\"" + ">" + 
                        "<button type="+ "\"submit\"" + "class=" + "\"delete\"" +"name=" + "\"DeleteServlet\"" + "value=" + "\"" + origFilename + "\"" + "/>" + 
                        "Delete" + "</button>" + 
                        "</form>" + 
                        "<br>");
                    }
                }

                catch(NullPointerException e)
                {
                    fileList = new ArrayList<String>();
                }
            %>
        </nav>
    </body>
</html>

