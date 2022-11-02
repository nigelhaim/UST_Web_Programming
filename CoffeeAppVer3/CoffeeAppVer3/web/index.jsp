<%-- 
    Document   : index
    Created on : Oct 22, 2021, 6:30:32 AM
    Author     : Lawrence
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coffee App Page</title>
    </head>
    <body>
        <h1>Coffee Application Version 3!</h1>
        <form method="get" action="SelectCoffee.do">
            Select Beverage Type <p>
                <select name="type" size="1">
                    <option>Coffee/Espresso
                    <option>Non-Coffee/Cream
                    <option>Frappe
                    <option>Tea-based
                </select>
                <br><br>
            <center>
                <input type="SUBMIT">
            </center>
            
        </form>
    </body>
</html>

