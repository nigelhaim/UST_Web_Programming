<%-- 
    Document   : login
    Created on : Nov 19, 2022, 5:45:35 PM
    Author     : paige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="login.css">
    </head>
    <body>
        <form action="LogSession">
            <div class="login-box">
                <!--Title-->
                <h1>Login</h1>

                <!--Username-->
                <div class="textbox">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" name="username" placeholder="Username">
                </div>

                <!--Password-->
                <div class="textbox">
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input type="text" name="password" placeholder="Password">
                </div>

                <!--Button-->
                <button name="sign-in" type="submit">Sign-in</button>
            </div>
        </form>
    </body>
</html>