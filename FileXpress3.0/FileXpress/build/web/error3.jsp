<<!-- Edison J. Javier III   Nigel Haim N. Sebastian : Group 5 - 2CSC    MP3 - Web App -->

<!-- error3.jsp -->
<!-- This will show a customized error page. -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="./styles.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins&display=swap">
        <title>Error Page 3 for Notes App</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <header id="error-header">
            <h1 id="error-app-name">FileXpress</h1>
        </header>

        <div class="error">
            <div class="error-divide">
                <div class="error-wrap">
                    <h1>Oh snap!</h1>
                    <h2>You encountered an error!</h2>
                </div>
                <img id="error-img-3" src="https://cdn.discordapp.com/attachments/1013982573841616907/1039517817432703056/error_icon3.png" alt="error icon" />
            </div>
            <h3>No worries! You can <span id="bold">return to the homepage</span> and try again.</h3>
            <a href="index.jsp" class="clicked"><button class="return" type="button">Return to Homepage</button></a>
        </div>
    </body>
</html>
