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
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

/**
 *
 * @author User
 */

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostServlet</title>");            
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
        //processRequest(request, response);
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
         String header = request.getParameter("head").replace(" ", "_");
         String content = request.getParameter("cont");
         String contextPath = getServletContext().getRealPath("/");
         Part img;
         img = request.getPart("file");
         String img_name = img.getSubmittedFileName().replaceAll(" ", "_");
         File path = new File(contextPath+"/entries");
         if(!path.exists()){
             path.mkdirs();
         }
        File entry_path = new File(contextPath+"/entries/"+header);
        
        if(!entry_path.exists()){
             entry_path.mkdirs();
        }
        String[] del = entry_path.list();
        for (String s1:del){
            File f1 = new File (entry_path,s1);
            f1.delete();   
        }
        
        String newFile = header + ".txt";

        FileOutputStream fos = new FileOutputStream(entry_path + "/" + newFile, true);
        String fheader = header + "\n";
        byte[] h = fheader.getBytes();
        byte[] b = content.getBytes();
        fos.write(h);
        fos.write(b);
        fos.close();
        
        String img_path = contextPath+"/entries/"+header + "/" + img_name;
            try (FileOutputStream img_fos = new FileOutputStream(img_path)) {
                InputStream is = img.getInputStream();

                byte[] data = new byte[is.available()];
                is.read(data);
                img_fos.write(data);
            }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
        request.setAttribute("showEntry", header);
        RequestDispatcher rd = request.getRequestDispatcher("ShowEntry");
        rd.forward(request, response);
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

    private String extractFileName(Part img) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
