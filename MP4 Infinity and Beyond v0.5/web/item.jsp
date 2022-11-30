<%-- 
    Document   : item
    Created on : 11 29, 22, 5:21:07 PM
    Author     : reiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product View Page</title>
    <link href="item.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="shop.css" rel="stylesheet" type="text/css" />
  </head>

  <body>
      <%
          HashMap<String, Product> stock = new Storage().getStock();
          // imma fix this later if (!stock.containsKey(request.getParameter("product")) || request.getParameter("product") == null) response.sendError(HttpServletResponse.SC_NOT_FOUND);
          Product watch = stock.get(request.getParameter("product"));
      %>
      
      <!-- also add the navigation bar here -->
    <header>
        <input type="checkbox" name="" id="toggle">
        <label for="toggle"><ion-icon name="menu"></ion-icon></label>

        <a href="/MP4_Infinity_and_Beyond" class="logo">Galaxy<span>.</span></a>

        <nav class="navbar">
            <a href="shop.jsp">Home</a>
            <a href="shop.jsp#about">About</a>
            <a href="shop.jsp#products">Products</a>
            <a href="shop.jsp#review">Review</a>
            <a href="shop.jsp#contact">Contact</a>
        </nav>

        <div class="icons">
                <!-- <span class="icon"><ion-icon name="heart"></ion-icon></span>
            </a> -->
            <a href="Cart">
                <span class="icon"><ion-icon name="cart"></ion-icon></span>
            </a>
            <a href="Account">
                <span class="icon"><ion-icon name="person"></ion-icon></span>
            </a>
        </div>
    </header>
      
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    
    <div class="item">
      <div class="item-header">
        <div class="image-item">
            <%
                out.println("<img src='" + request.getParameter("product") + ".jpg' >");
            %>
          <!-- <img src="mercury.jpg" alt="mercury watch" /> -->
        </div>
        <div class="text-item">
          <div class="item-name">
              <%
                  out.println("<h1>" + watch.getName() + "</h1>");
                  out.println("<h2>" + watch.getColor() + "</h2>");
              %>
            <!-- <h1>Futuristic Mercury</h1>
            <h2>DEEP GREY COLOR</h2> -->
          </div>
          <form method="post" action="AddToCart" class="item-cart">
            <input type="hidden" name="item" value="<% out.println(watch.getName()); %>"/>
            <%
                out.println("<h1><input type=\"hidden\" name=\"price\" value=\""+ watch.getPrice() + "\"/>$" + watch.getPrice() + "</h1>");
            %>
            <!-- <h1>P2999.00</h1> -->
            <div id="wrap">
                <h2>Quantity</h2>
                <span class="q_sub">-</span><!-- Decrements the quantity -->
                <input type="text" id="quantity" name="quantity"/>
                <span class="q_add">+</span><!-- Increments the quantity -->
            </div> 
            <button class="add" type="submit">Add to Cart</button>
            
            <!-- TODO: Dito nalang lagay yung quantity to be put in the cart instead of dun sa cart.jsp -->
            
          </form>
          <div class="item-details">
            <h2>Product Details</h2>
            <i class="fas fa-check-circle"><span class="i-text">Water Resistant</span></i>
            <i class="fas fa-check-circle"><span class="i-text">Velcro Strap Material</span></i>
            <i class="fas fa-check-circle"><span class="i-text">Bioceramic Case Material</span></i>
          </div>
        </div>
      </div>
        
        <!-- TODO: fix the footer to the lower portion of the page no matter the size of the screen -->
      <div class="item-footer">
        <i class="fas fa-money-check"><span class="i-text">24 MONTHS WARRANTY</span></i>
        <i class="fas fa-truck"><span class="i-text">EASY RETURN</span></i>
        <i class="fas fa-lock"><span class="i-text">100% SECURE PURCHASE</span></i>
      </div>
    </div>
            
    <!-- This is a javascript that increments and decrements the quantity in the form -->
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            console.log('Item is loaded');
            const add = document.querySelector(".q_add");
            const sub = document.querySelector(".q_sub");
            let num = document.getElementById("quantity").value = 1;
            console.log("Current Quantity is: " + num);
            add.addEventListener("click", ()=> {
                    num++;
                    document.getElementById("quantity").value =  num;
                    console.log("Incremented: " + num);
            });
            
            sub.addEventListener("click", ()=> {
                if(num > 1){
                    num--;
                    document.getElementById("quantity").value = num;
                    console.log("Decremented: " + num);
                }
            });
        });
    </script> 
  </body>
</html>
