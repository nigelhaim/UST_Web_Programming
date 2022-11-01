/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class QuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuizServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Captain America's Score is:</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response); 
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        int cap_am = 0;
        int iro_ma = 0;
        int tho    = 0;
        
        for(int i = 1; i <= 4; i++){
            String num = "ans"+Integer.toString(i);
            String ca = "ca"+Integer.toString(i);
            String im = "im"+Integer.toString(i);
            String th = "th"+Integer.toString(i);
            if(request.getParameter(num).equals(ca)){
                cap_am++;
            }
            else if(request.getParameter(num).equals(im)){
                iro_ma++;
            }
            else if(request.getParameter(num).equals(th)){
                tho++;
            }
        }
        /*String ans = request.getParameter("ans1");
        if(ans.equals("ca1")){
            cap_am++;
        }
        else if(ans.equals("im1")){
            iro_ma++;
        }
        else if(ans.equals("th1")){
            tho++;
        }*/
        
        out.print("The score of captain america is: " + cap_am + "<br>");
        out.print("The score of iron man is: " + iro_ma + "<br>");
        out.print("The score of thor is: " + tho + "<br>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
