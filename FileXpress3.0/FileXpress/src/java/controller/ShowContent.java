/** 
 * Edison J. Javier III
 * Nigel Haim N. Sebastian
 * Group 5 - 2CSC
 * MP3 - Web App
 */

package controller;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLConnection;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowContent extends HttpServlet {

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
            out.println("<title>ShowContent Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ShowContent at " + request.getContextPath() + "</h1>");
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
     
    /**
     * When view file is clicked, it gets the filename and checks if what ContentType will be shown.
     * The user can view whatever file type is passed.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        // Gets the filename and checks the file type
        String filename = request.getParameter("ShowContent");
        // This will generate the ContentType based on the file type
        String mimeType = URLConnection.guessContentTypeFromName(filename);
        // This will set the ContentType
        response.setContentType(mimeType);
        
        // Prints and shows the contents of a file 
        ServletOutputStream out = response.getOutputStream();
        String path = getServletContext().getRealPath("/entries/" + filename + "/" + (filename) );
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        
        // This will process every byte to show the content of the file
        int ch = 0;
        while ((ch = bis.read()) != -1) 
        {
            bos.write(ch);
        }

        bos.close();
        bis.close();
        fis.close();
        out.close();
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
