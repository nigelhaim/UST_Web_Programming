/** 
 * Edison J. Javier III
 * Nigel Haim N. Sebastian
 * Group 5 - 2CSC
 * MP3 - Web App
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FileCategories;
import java.util.*;
import javax.servlet.RequestDispatcher;

public class CategoriesServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CategoriesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            /**
             * This serves as the controller of the categories MVC where 
             * if the user picked a category then it will scan the entries
             * and return a list of filenames (Strings) with the same file
             * extension
             */
            
            // Gets the requested category and gets the contextPath of entries folder
            String category = request.getParameter("categories");
            String contextPath = getServletContext().getRealPath("/entries");
            
            // Calls the FileCategories model and scans the files that is compared to the parsed string (file extension)
            FileCategories fileCategory = new FileCategories();
            List fileList = fileCategory.getFiles(category, contextPath);
            
            if(fileList == null) // if the scanning of files failed, then it returns to index.jsp
            {
                // Uses sendRedirect with a relative path
                response.sendRedirect("index.jsp");
            }
            else
            {
                if(!category.equals("All")) // if there is a selected category, then the list will be forward to the result.jsp
                {
                    request.setAttribute("category", category);
                    request.setAttribute("fileList", fileList);
                    // using the RequestDispatcher.forward()
                    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
                    view.forward(request, response);
                }
                else // else if the selected category is All Files then the list will appear on the All Files div tag of index.jsp
                {
                    request.setAttribute("fileList", fileList);
                    // using the RequestDispatcher.forward()
                    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                    view.forward(request, response);
                }                     
            }
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
