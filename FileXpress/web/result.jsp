<%-- 
    Document   : result
    Created on : 11 10, 22, 6:17:08 PM
    Author     : reiva
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="./styles.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins&display=swap">
        <title>Result Page of FileXpress App</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
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
                    <a href="index.jsp" class="clicked"><button class="back" type="button">Return to Homepage</button></a> 
                </form>
            </div>
        </nav>
        
        <main class="work-bar">
            <h1 class="result-title"><% out.print(request.getAttribute("category")); %> Files</h1>
            <div class="list">
                <%
                    List fileList = (List)request.getAttribute("fileList");
                    Iterator<String> it = fileList.iterator();
                
                    while(it.hasNext())
                    {
                        String origFilename = it.next();
                        int num = origFilename.lastIndexOf('.');
                        String newFilename = origFilename.substring(0, num);
                        out.print("<form method=" + "\"get\"" + "action=" + "\"ShowEntry\"" + ">");
                        out.print("<button type="+ "\"submit\"" + "class=" + "\"list-obj\"" + "name=" + "\"show-entry\"" + "value=" + "\"" + origFilename + "\"" + "/>" + newFilename);
                        out.print("</button>");
                        out.print("</form>");
                        out.print("<form method=" + "\"post\"" + "action=" + "\"DeleteServlet\"" + ">" + 
                        "<button type="+ "\"submit\"" + "class=" + "\"delete\"" + "name=" + "\"DeleteServlet\"" + "value=" + "\"" + origFilename + "\"" + "/>" + 
                        "Delete" + "</button>" + 
                        "</form>" + 
                        "<br>");
                    }
                %>
            </div>
        </main>
    </body>
</html>
