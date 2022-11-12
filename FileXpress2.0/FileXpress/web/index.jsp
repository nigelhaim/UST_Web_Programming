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
        <title>Main Page for FileXpress App</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body class="body">
        <!-- The side bar is composed of the name of the application, categories and information of the user -->
        <nav id="side-bar">
            <header id="nav">FileXpress</header>
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
                    <!-- This gets the  data from the web xml -->
                    <a href="start.html" class="clicked"><button class="back" type="button">Return</button></a>
                    <a href="index.jsp" class="clicked"><button class="clear" type="button">Return from All Files</button></a>
                    <h2 class="user-info-title">User Info:</h2>
                    <div class="user-info">
                        <h2>User ID:  <% out.print("<h2 class=\"small\">" + getServletContext().getInitParameter("userID") + "</h2>"); %> </h2>
                        <h2>User Email: <% out.print("<h2 class=\"small\">" + getServletContext().getInitParameter("userEmail") + "</h2>"); %> </h2>
                    </div>
                </form>
            </div>
        </nav>
        <!-- Form where the file and description is sumbmitted  for the PosServlet-->
        <div class="work-bar">
            <form method="post" action="PostServlet" enctype="multipart/form-data">
                <h2>Drop any file...</h2>
                    <div class="file-bar">
                        <label class="submit">Input a file:</label>
                        <input type="file" id="file" name="file">
                        <label class="submit">File Description:
                            <textarea id="cont" name="cont" rows="5" cols="70" placeholder="Type something (except coding terms)..." required></textarea>
                        </label>
                        <input type="submit" id="submit" value="Submit" />
                    </div>
            </form>
        </div>
            
        <nav class="all-files">
            <header id="all-files">All Files</header>
            <div class="obj-wrap">
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
                            out.print("<form method=" + "\"get\"" + "action=" + "\"ShowEntry\">");
                            out.print("<button type="+ "\"submit\"" + "class=" + "\"list-obj\"" + "name=" + "\"show-entry\"" + "value=" + "\"" + origFilename + "\"/>" + newFilename);
                            out.print("</button>");
                            out.print("</form>");
                            out.print("<form method=" + "\"post\"" + "action=" + "\"DeleteServlet\"" + ">" + 
                            "<button type="+ "\"submit\"" + "class=" + "\"delete\"" +"name=" + "\"DeleteServlet\"" + "value=" + "\"" + origFilename + "\"" + "/>" + 
                            "X" + "</button>" + 
                            "</form>" + 
                            "<br>");
                        }
                    }

                    catch(NullPointerException e)
                    {
                        fileList = new ArrayList<String>();
                    }
                %>
            </div>
        </nav>
    </body>
</html>

