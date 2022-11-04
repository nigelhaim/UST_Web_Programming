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

import java.io.*;
import java.util.*;

/**
 *
 * @author nigel
 */
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
            out.println("<h1>Servlet ShowEntry at " + request.getContextPath() + "</h1>");
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
        String filename = request.getParameter("showEntry");
        String subfilename = filename.substring(0, filename.length()-4);
        String path = getServletContext().getRealPath("/entries/" + subfilename + "/" + filename );
        File txt_file= new File(path);  
        
        String imgcontextPath = getServletContext().getRealPath("/entries");
        File Filepath = new File(imgcontextPath);
            
        try ( PrintWriter out = response.getWriter()) {
//            /out.print(txt_file.getName());
            BufferedReader br = new BufferedReader(new FileReader(txt_file));
            out.print("<br>");
            out.print("<h1>"+br.readLine()+"</h1>");
                    if(Filepath.exists()){
                File path_img = new File(imgcontextPath);
                File [] img_filename= path_img.listFiles();
                for (File folder_file : img_filename) {
                    if(folder_file.isDirectory ()){
                        for(final File file:folder_file.listFiles()){
                            if(file.getName().endsWith(".jpg") || file.getName().endsWith(".png")){
                                out.print("<img src=" + "./entries/" + subfilename + "/" + file.getName() + ">");
                                //out.print(getServletContext().getRealPath("/entries/" + subfilename));
                            }
                        }
                    }
                } 
            }
            out.print("<form>");
            out.print("<textarea>");
            out.print(br.readLine());
            out.print("</textarea>");
            out.print("<input type=" + "\"submit\"" + "/>");
            out.print("</form>");
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
