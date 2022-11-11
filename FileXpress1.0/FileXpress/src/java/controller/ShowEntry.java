package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.servlet.ServletConfig;

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowEntry</title>");            
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
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("userName");
        String occupation = config.getInitParameter("userOccupation");
        
        response.setContentType("text/html");
        String filename = "";
        if(request.getParameter("show-entry") != null)
        {
            filename = request.getParameter("show-entry");
        }
        else
        {
            filename = ((String) request.getAttribute("show-entry"));
        }
        
        String subFilename = filename;
        String path = getServletContext().getRealPath("/entries/" + subFilename + "/" + (filename+".txt") );
        File txtFile = new File(path);  
        
        String fileContextPath = getServletContext().getRealPath("/entries/" + subFilename);
        File filePath = new File(fileContextPath);
        String fp = "";
        try (PrintWriter out = response.getWriter()) 
        {
            out.print("<head>");
            out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"./styles.css\" />");
            out.print("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Poppins&display=swap\">");
            out.print("</head>");
            out.print("<body class=\"entry\">");
            out.print("<div class=\"entry-head\">");
            out.print("<h2 id=\"entry-head\"> Contributor: " + "<span class=\"lighter\">" + name + "</span>" + "</h2>");
            out.print("<h2 id=\"entry-head\"> Occupation: " + "<span class=\"lighter\">" + occupation + "</span>" + "</h2>");
            out.print("</div>");
            
            out.print("<div class=\"entry-wrap\">");
            out.print("<div class=\"file-name\">");
            BufferedReader br = new BufferedReader(new FileReader(txtFile));
            String s = "";
            out.print("<h1 id=\"file-name\">" + filename.replace("_", " ") + "</h1>");
            if(filePath.exists())
            {
                File [] files = filePath.listFiles();
                for (File file : files) 
                {
                    if(!file.getName().endsWith(".txt"))
                    {
                        fp = file.getName();
                        out.print("<form method=\"get\" action=" + "\"ShowContent\">");
                        out.print("<input type=\"hidden\" value=\"" + fp + "\" id=\"ShowContent\" name=\"ShowContent\">");
                        out.print("<input type=\"submit\" id=\"view\" value=\"View File\">");
                        out.print("</form>");
                    }
                } 
            }
            out.print("</div>");
            
            out.print("<h2 class=\"file-desc\"> Edit the file description: </h2>");
            out.print("<form method=\"post\" action=\"EditServlet\">");
            out.print("<input type=\"hidden\" value=\"" + fp + "\"id=\" file\" name=\"file\">");
            out.print("<textarea id=\"cont\" name=\"cont\" rows=\"5\" cols=\"50\" placeholder=\"Type something (except coding terms)...\">");
            
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
