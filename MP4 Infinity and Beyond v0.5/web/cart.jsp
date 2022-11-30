<%-- 
    Document   : cart
    Created on : 11 28, 22, 10:00:15 PM
    Author     : reiva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart Page</title>
    <link href="cart.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="shop.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body class="cart">
      <!-- TODO: Add the navigation bar -->
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
      
      <br> <br>
    <div class="cart-container">
      <div class="cart-header">
        <h2 id="cart-title">Your Shopping Cart</h2>
        <h4 id="cart-remove">Remove Items</h4>
      </div>
      <div class="cart-item">
        <div class="image-wrap">
          <img src="phantom.png" alt="gun"/>
        </div>
        <div class="item-about">
          <h1 class="item-title">Phantom Gun</h1>
          <h3 class="item-subtitle">Variation: SW-ACR PHANTOM</h3>
        </div>
          
          <!-- TODO: transfer item counter to the form element in item.jsp -->
        <div class="item-counter">
          <button class="counter-btn" type="button">-</button>
          <div class="counter-count">1</div>
          <button class="counter-btn" type="button">+</button>
        </div>

        <div class="item-price">
          <div class="price-amount">$9999.99</div>
          <div class="item-stock">999 items left</div>
          <div class="item-remove"><u>Remove Item</u></div>
        </div>
      </div>
    </div>
  </body>
</html>
  
