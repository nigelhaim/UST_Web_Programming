/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andy
 */
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         if(username.equals("user1") && password.equals("pass1")){
             HttpSession session = request.getSession();
             session.setAttribute("username", username);
             response.sendRedirect("DateTime.jsp");
         }
         else{
             try (PrintWriter out = response.getWriter()){
                out.print("<p> Wrong username or password</p>");
                RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                view.include(request, response); 
            }
        }
    }

}
