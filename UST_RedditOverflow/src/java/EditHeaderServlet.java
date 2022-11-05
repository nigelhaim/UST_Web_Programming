/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nigel
 */
public class EditHeaderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet EditHeaderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditHeaderServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        try ( PrintWriter out = response.getWriter()) {

            String oldString = request.getParameter("og_head");
            String newStrng = request.getParameter("new_head");
            //out.print(getServletContext().getRealPath("/entries/" + oldString + "/"));
            //out.print(getServletContext().getRealPath("/entries/" + oldString) + "\\" + oldString + ".txt");
            String txt_path = getServletContext().getRealPath("/entries" + "\\"+ oldString);
            String newFileName = newStrng.replace(" ","_");
            File old_txt_name = new File(txt_path + "\\" + oldString + ".txt");
        
            old_txt_name.renameTo(new File(txt_path + "\\" + newFileName + ".txt"));
            File old_folder_name = new File(txt_path);  
            String newFolder_name = getServletContext().getRealPath("/entries/");
            old_folder_name.renameTo(new File(newFolder_name + "\\" + newFileName));
            
            /*request.setAttribute("showEntry", newStrng);
            RequestDispatcher rd = request.getRequestDispatcher("ShowEntry");
            rd.forward(request, response);*/
            //response.sendRedirect("index.jsp");
        }
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