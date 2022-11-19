<%-- 
    Document   : login
    Created on : 11 19, 22, 5:09:45 PM
    Author     : andy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            <fieldset>
                <legend>Username</legend> 
                <input name="username" type="text">
            </fieldset>
            <fieldset>
                <legend>Password</legend> 
                <input name="password" type="password">
            </fieldset>
            <br>
            <input type="submit" value="submit">
        </form> 
    </body>
</html>
