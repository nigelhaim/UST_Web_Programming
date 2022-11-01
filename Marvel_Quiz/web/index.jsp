<%-- 
    Document   : index
    Created on : 10 31, 22, 3:46:39 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="QuizServlet">
            <label>First question?</label><br>
            <input type="radio" name="ans1" value="ca1">Captain America</br>
            <input type="radio" name="ans1" value="im1">Iron Man</br>
            <input type="radio" name="ans1" value="th1">Thor</br>
            
             <label>Second question?</label><br>
            <input type="radio" name="ans2" value="ca2">Captain America</br>
            <input type="radio" name="ans2" value="im2">Iron Man</br>
            <input type="radio" name="ans2" value="th2">Thor</br>
            
            <label>Third question?</label><br>
            <input type="radio" name="ans3" value="ca3">Captain America</br>
            <input type="radio" name="ans3" value="im3">Iron Man</br>
            <input type="radio" name="ans3" value="th3">Thor</br>
            
            <label>Fourth question?</label><br>
            <input type="radio" name="ans4" value="ca4">Captain America</br>
            <input type="radio" name="ans4" value="im4">Iron Man</br>
            <input type="radio" name="ans4" value="th4">Thor</br> 
            <br>
            <br>
            
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
