<!-- Edison J. Javier III   Nigel Haim N. Sebastian : Group 5 - 2CSC    MP3 - Web App -->

<!-- index.jsp -->
<!-- This will show the page that allows the user to upload files and display all the files. -->

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %> 
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="./styles.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins&display=swap">
        <title>Main Page for FileXpress App</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body class="body">
        <!-- This is the bar that is displayed in the left side -->
        <nav id="side-bar">
            <header id="nav">FileXpress</header>
            <div class="nav">
                <!-- A select form that passes a value of a specific file extension or all files to the CategoriesServlet -->
                <!-- This will show the files either all or of a specific file type -->
                <form method="get" action="CategoriesServlet">
                    <label class="view-files" for="categories">View Files Here:</label>
                    <div class="custom-select">
                        <select name="categories" class="categories" onchange='if(this.value !== 0) { this.form.submit(); }'>
                            <option value='0' selected disabled hidden>Categories:</option>
                            <option value='All'>All Files</option>
                            <option value='.java'>.java</option>
                            <option value='.jsp'>.jsp</option>
                            <option value='.html'>.html</option>
                            <option value='.css'>.css</option>
                            <option value='.pdf'>.pdf</option>
                        </select>
                    </div>
                    <!-- This button will return to the default welcome page -->
                    <a href="start.html" class="clicked"><button class="back" type="button">Return to Welcome Page</button></a>
                    
                    <!-- Uses ServletContext Object to display the parameters -->
                    <h2 class="user-info-title">User Info:</h2>
                    <div class="user-info">
                        <h2>User ID:  <% out.print("<h2 class=\"small\">" + getServletContext().getInitParameter("userID") + "</h2>"); %> </h2>
                        <h2>User Email: <% out.print("<h2 class=\"small\">" + getServletContext().getInitParameter("userEmail") + "</h2>"); %> </h2>
                    </div>
                    
                    <!-- Uses ServletContextListener to retrieved the stored object -->
                    <%
                        Date date = (Date)getServletContext().getAttribute("date");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String dateForm= sdf.format(date);
                        out.print("<h2 class=\"date\"> Today's Date: </h2>");
                        out.print("<h2 class=\"small\">" + dateForm + "</h2>");
                    %>
                </form>
            </div>
        </nav>
                
        <!-- This is the upload area in the middle of the page -->
        <div class="work-bar">
            <!-- This is the form that passes the file and the description to the PostServlet -->
            <form method="post" action="PostServlet" enctype="multipart/form-data">
                <h2>Drop any file...</h2>
                    <div class="file-bar">
                        <label class="submit">Input a file:</label>
                        <input type="file" id="file" name="file">
                        <label class="submit">File Description:
                            <textarea id="cont" name="cont" rows="5" cols="70" placeholder="Type something (except coding terms)..."></textarea>
                        </label>
                        <input type="submit" id="submit" value="Submit" />
                    </div>
            </form>
        </div>
        
        <!-- This is the bar that is displayed in the right side -->
        <nav class="all-files">
            <div id="all-files">
                <header>All Files</header>
                <!-- Closes the viewing of All Files -->
                <a href="index.jsp" class="clicked"><button class="clear" type="button">Close View</button></a>
            </div>
            <!-- This displays the list of files returned by the CategoriesServlet when All Files category is requested -->
            <nav class="all-files-view">
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
                            
                            out.print("<div class=\"obj-wrap\">");
                            // This displays file    
                            out.print("<form method=\"get\" action=\"ShowEntry\">");
                            out.print("<button type=\"submit\" class=\"list-obj\" name=\"show-entry\" value=\"" + origFilename + "\"/>" + newFilename.replace("_", " "));
                            out.print("</button>");
                            out.print("</form>");
                            
                            // This displays the delete button
                            out.print("<form method=\"post\" action=\"DeleteServlet\">");
                            out.print("<button type=\"submit\" class=\"delete\" name=\"DeleteServlet\" value=\"" + origFilename + "\"/><i class=\"fa fa-trash\" aria-hidden=\"true\"></i>");
                            out.print("</button>"); 
                            out.print("</form>");
                            out.print("</div>");
                        }
                    }
                    catch(NullPointerException e)
                    {
                        fileList = new ArrayList<String>();
                    }
                %>
            </nav>
        </nav>
    </body>
</html>

