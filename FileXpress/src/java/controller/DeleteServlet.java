/** 
 * Edison J. Javier III
 * Nigel Haim N. Sebastian
 * Group 5 - 2CSC
 * MP3 - Web App
 */

package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DeleteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>DeleteServlet at " + request.getContextPath() + "</h1>");
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
    
    /**
     * This method acts as the delete function of the web application
     * by getting the value of the specified name
     * If the file exists, then it deletes the folder 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        try (PrintWriter out = response.getWriter()) 
        {
            // Gets the requested filename and gets the path of the filename
            String fp = request.getParameter("DeleteServlet");
            String p = getServletContext().getRealPath("/entries/" + fp);
            try
            {
                File filePath = new File(p); // Finds the folder with the file 
                if(filePath.exists())
                {
                    File [] folderContent = filePath.listFiles(); // Scans all the files of the folder and deletes the files 
                    for(final File folderFile : folderContent)
                    {
                        folderFile.delete();
                    }
                    if(filePath.delete()) // Deletes the folder
                    {
                        // Uses sendRedirect with a relative path
                        response.sendRedirect("index.jsp"); // then return to index.jsp
                    }
                    else
                    {
                        // Uses sendRedirect with an absolute path
                        response.sendRedirect("./index.jsp");
                    }
                }
            }
            catch(Exception e)
            {
                // Uses sendRedirect with an absolute path
                response.sendRedirect("./index.jsp");
            }
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
