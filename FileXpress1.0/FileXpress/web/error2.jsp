<%-- 
    Document   : error2
    Created on : 11 10, 22, 4:59:05 PM
    Author     : reiva
--%>

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
    <header id="header">
      <h1 id="app-name">code 2 go</h1>
      <nav id="nav-bar">
        <ul>
          <li><a href="#home">Home</a></li>
          <li><a href="#features">Features</a></li>
          <li><a href="#about-us">About us</a></li>
        </ul>
      </nav>
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
      <a href="" class="clicked"><button class="return" type="button">Return to Homepage</button></a>
    </div>
  </body>
</html>