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
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowEntry extends HttpServlet {

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
            out.println("<title>ShowEntry Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            doGet(request, response);
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
     * This shows the entry content when a user decides to view the entry 
     * They have the option to view the contents of the file which will be passed
     * to an another servlet they can also edit the description through the textarea 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        // Gets the parameters using the ServletConfig Object
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("userName");
        String occupation = config.getInitParameter("userOccupation");
        
        response.setContentType("text/html");
        String filename = "";
        
        // Gets the filename
        if(request.getParameter("show-entry") != null)
        {
            filename = request.getParameter("show-entry"); // This gets the parameter from a form
        }
        else // else it gets the attribute from the forward method
        {
            filename = ((String) request.getAttribute("show-entry"));
        }
        
        // Gets the file and the description from the folder
        String subFilename = filename;
        String path = getServletContext().getRealPath("/entries/" + subFilename + "/" + (filename+".txt") );
        File txtFile = new File(path);  
        
        // This will get the path to access the entries folder
        String fileContextPath = getServletContext().getRealPath("/entries/" + subFilename);
        File filePath = new File(fileContextPath);
        String fp = "";
        
        // Prints the html tags that will be shown
        try (PrintWriter out = response.getWriter()) 
        {
            // head
            out.print("<head>");
            out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"./styles.css\" />");
            out.print("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Poppins&display=swap\">");
            out.print("</head>");
            
            // body
            // Prints the information of the user
            out.print("<body class=\"entry\">");
            out.print("<div class=\"entry-top\">");
            out.print("<div class=\"entry-head-item\">");
            // Displays the parameters from ServletConfig Object
            out.print("<h2 id=\"entry-head\"> Contributor: <span class=\"lighter\">" + name + "</span> </h2>");
            out.print("<h2 id=\"entry-head\"> Occupation: <span class=\"lighter\">" + occupation + "</span> </h2>");
            out.print("</div>");
            out.print("<div class=\"entry-head-item\">");
            // Displays the parameters from ServletContext Object
            out.print("<h2 id=\"entry-head\"> User ID: <span class=\"lighter\">" + getServletContext().getInitParameter("userID") + "</span> </h2>");
            out.print("<h2 id=\"entry-head\"> Email: <span class=\"lighter\">" + getServletContext().getInitParameter("userEmail") + "</span> </h2>");
            out.print("</div>");
            out.print("</div>");
            
            out.print("<div class=\"entry-wrap\">");
            out.print("<div class=\"file-name\">");
            
            // Gets the file and .txt file
            BufferedReader br = new BufferedReader(new FileReader(txtFile));
            String s = "";
            out.print("<h1 id=\"file-name\">" + filename.replace("_", " ") + "</h1>");
            
            // Shows the file
            if(filePath.exists())
            {
                File [] files = filePath.listFiles();
                for (File file : files) 
                {
                    if(!file.getName().endsWith(".txt"))
                    {
                        fp = file.getName();
                        out.print("<form method=\"get\" action=\"ShowContent\">");
                        out.print("<input type=\"hidden\" value=\"" + fp + "\" id=\"ShowContent\" name=\"ShowContent\">");
                        out.print("<input type=\"submit\" id=\"view\" value=\"View File\">");
                        out.print("</form>");
                    }
                } 
            }
            out.print("</div>");
            
            // Gets the description and place in a textarea that users can have the option to edit again
            out.print("<h2 class=\"file-desc\"> Edit the file description: </h2>");
            out.print("<form method=\"post\" action=\"EditServlet\">");
            out.print("<input type=\"hidden\" value=\"" + fp + "\"id=\" file\" name=\"file\">");
            out.print("<textarea id=\"cont\" name=\"cont\" rows=\"5\" cols=\"70\" placeholder=\"Type something (except coding terms)...\" required>");
            while((s = br.readLine()) != null)
            {
                out.print(s + "\r\n");
            }
            out.print("</textarea>");
            out.print("<input type=\"submit\" id=\"entry-submit\" value=\"Submit\" />");
            out.print("<a onclick=\"history.back()\" class=\"clicked\"><button class=\"entry-back\" type=\"button\">Return</button></a>");
            out.print("</form>");
            out.print("</div>");
            out.print("</body>");
        }
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
