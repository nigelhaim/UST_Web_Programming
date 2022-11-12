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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class PostServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PostServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostServlet at " + request.getContextPath() + "</h1>");
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
     * This method gets the parameters of the description and the submitted 
     * file to be stored in the entries folder.
     * The description is also written on the .txt file.
     * If the entries folder does not exist, then it will create a new folder.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        
        // Gets the description and the file to be saved 
        String header;
        String content = request.getParameter("cont");
        String contextPath = getServletContext().getRealPath("/");
        Part file;
        file = request.getPart("file");
        String filename = file.getSubmittedFileName().replaceAll(" ", "_");
        header = filename;
        File path = new File(contextPath + "/entries");
        if(!(file.getSize() <= 0)) // If there is a passed file, then it runs the save process
        {
            if(!content.equals("")) // If there is a description, then it will continue saving
            {
                if(!path.exists()) // If there is no entries folder, then it makes a new folder 
                {
                    path.mkdirs();
                }

                File entryPath = new File(contextPath + "/entries/" + header); // Creates the new folder in the entries
                if(!entryPath.exists())
                {
                    entryPath.mkdirs();
                }
                
                // Clears the folder
                String[] del = entryPath.list(); 
                for (String s: del)
                {
                    File f = new File (entryPath,s);
                    f.delete();   
                }

                String newFile = header + ".txt"; // Creates the new txt file

                FileOutputStream fos = new FileOutputStream(entryPath + "/" + newFile, true); // Places the submitted file on the folder
                byte[] b = content.getBytes();
                fos.write(b);
                fos.close();
                
                // Writes the description of the file on the txt file
                String filePath = contextPath + "/entries/" + header + "/" + filename; 
                try (FileOutputStream fileFos = new FileOutputStream(filePath))
                {
                    InputStream is = file.getInputStream();

                    byte[] data = new byte[is.available()];
                    is.read(data);
                    fileFos.write(data);
                }
                catch(Exception e)
                {
                    System.out.print(e.getMessage());
                }
                
                // Uses sendRedirect with a relative path
                response.sendRedirect("index.jsp"); // If the creation of the file is successful, then it returns to index.jsp      
            }   
            else // If there is no description, then it includes a prompt to the user that it needs a description every submission of the file 
            {  
                out.print("<h3 class=\"prompt\"> Kindly include a description for the file! </h3>");
                // using the RequestDispatcher.include()
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.include(request, response); 
            }
        }
        else // else it displays the custoomized error page
        {
            // Uses sendRedirect with an absolute path
            response.sendRedirect("./error3.jsp");
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
