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
        response.setContentType("text/html");
        String filename = "";
        if(request.getParameter("showEntry") != null){
            filename = request.getParameter("showEntry");
        }
        else{
            filename = ((String) request.getAttribute("showEntry"));
        }
        
        String subfilename = filename;
        String path = getServletContext().getRealPath("/entries/" + subfilename + "/" + (filename+".txt") );
        File txt_file= new File(path);  
        
        String imgcontextPath = getServletContext().getRealPath("/entries/" + subfilename);
        File Filepath = new File(imgcontextPath);
            
        try ( PrintWriter out = response.getWriter()) {
//            /out.print(txt_file.getName());
            BufferedReader br = new BufferedReader(new FileReader(txt_file));
            String s = "";
            out.print("<br>");
            out.print("<form method=" + "\"post\"" + " action=" + "\"EditHeaderServlet\""+">"
            + "<textarea" + " name=" + "\"new_head\"" + ">" + filename.replace("_", " ") + "</textarea>"  + 
            "<input type=" + "\"hidden\"" + " name=" + "\"og_head\"" + " value=" + subfilename + ">" + 
            "<br><input type=" + "\"submit\"" + " value=" + "\"Edit Header\"" + ">"
            +"</form>");
            out.print("<br>");
            if(Filepath.exists()){
                File [] img_filename= Filepath.listFiles();
                for (File file : img_filename) {
                    if(file.getName().endsWith(".jpg") || file.getName().endsWith(".png")){
                        out.print("<img src=" + "./entries/" + subfilename + "/" + file.getName() + ">");
                        //out.print(getServletContext().getRealPath("/entries/" + subfilename));
                    }
                } 
            }
            out.print("<br>");
            out.print("<br>");
            out.print("<input type=" + "\"file\"" + "accept=" + "\"image/png, image/jpg\"" + "name=" + "\"file\"" +">");
            out.print("<br>");
            out.print("<br>");
            out.print("<textarea name=" + "\"cont\"" + " id=" + "\"cont\"" + ">");
            while((s = br.readLine()) != null){
                out.print(s + "\r\n");
            }
            out.print("</textarea>");
            out.print("<br>");
            out.print("<br>");
            
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
