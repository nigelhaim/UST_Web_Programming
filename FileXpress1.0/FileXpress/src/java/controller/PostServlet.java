package controller;

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
        try (PrintWriter out = response.getWriter()) {
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  

        String header;
        String content = request.getParameter("cont");
        String contextPath = getServletContext().getRealPath("/");
        Part file;
        file = request.getPart("file");
        String imgName = file.getSubmittedFileName().replaceAll(" ", "_");
        header = imgName;
        File path = new File(contextPath + "/entries");
        if(!(file.getSize()<=0)){
            if(!content.equals("")){
                if(!path.exists()){
                    path.mkdirs();
                }

                File entryPath = new File(contextPath + "/entries/" + header);
                if(!entryPath.exists())
                {
                    entryPath.mkdirs();
                }

                String[] del = entryPath.list();
                for (String s1:del)
                {
                    File f1 = new File (entryPath,s1);
                    f1.delete();   
                }

                String newFile = header + ".txt";

                FileOutputStream fos = new FileOutputStream(entryPath + "/" + newFile, true);
                byte[] b = content.getBytes();
                fos.write(b);
                fos.close();

                String imgPath = contextPath + "/entries/" + header + "/" + imgName;
                try (FileOutputStream imgFos = new FileOutputStream(imgPath))
                {
                    InputStream is = file.getInputStream();

                    byte[] data = new byte[is.available()];
                    is.read(data);
                    imgFos.write(data);
                }

                catch(Exception e)
                {
                    System.out.print(e.getMessage());
                }

                response.sendRedirect("index.jsp");     
            }   
            else{  
                out.print("<h3 class=" + "\"prompt\"" + ">" + "Please include a description of the file!" + "</h3>");
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.include(request, response); 
            }
        }
        else{
             response.sendRedirect("error3.jsp");
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
    
    private String extractFileName(Part img) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
