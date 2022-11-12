<!-- Edison J. Javier III   Nigel Haim N. Sebastian : Group 5 - 2CSC    MP3 - Web App -->

<!-- error2.jsp -->
<!-- This will show a customized Error 500. -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="./styles.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins&display=swap">
        <title>Error Page 2 for FileXpress App</title>
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
                    <h1>Oops!</h1>
                    <h2>Error 500 - Internal Server Error</h2>
                </div>
                <img id="error-img-2" src="https://cdn.discordapp.com/attachments/1013982573841616907/1038356330441883658/error_icon2.png" alt="error icon" />
            </div>
            <h3>It seems like the page isn't working and could not complete your request. It is advisable to <span id="bold">return to the homepage</span> and try again.</h3>
            <a href="index.jsp" class="clicked"><button class="return" type="button">Return to Homepage</button></a>
        </div>
    </body>
</html>