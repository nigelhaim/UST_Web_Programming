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
import model.File_category;
import java.util.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author nigel
 */
public class CategoriesServlet extends HttpServlet {

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
            out.println("<title>Servlet CategoriesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoriesServlet at " + request.getContextPath() + "</h1>");
            String category = request.getParameter("categories");
            String contextPath = getServletContext().getRealPath("/entries");
            File_category f_category = new File_category();
            List file_list = f_category.getFiles(category, contextPath);
            if(file_list == null){
                response.sendRedirect("index.jsp");
            }
            else{
                request.setAttribute("category", category);
                request.setAttribute("file_list", file_list);
                RequestDispatcher view = request.getRequestDispatcher("Categorized_files.jsp");
                view.forward(request, response);
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
        /* try ( PrintWriter out = response.getWriter()) {
            //out.print(request.getParameter("categories"));
            String c = request.getParameter("categories");
            
            
            try{
                String contextPath = getServletContext().getRealPath("/entries");
                File Filepath = new File(contextPath);
                String finfilename;
                if(Filepath.exists()){
                    File path = new File(contextPath);
                    File [] filename= path.listFiles();
                    for (File folder_file : filename) {
                        if(folder_file.isDirectory ()){
                            for(final File file:folder_file.listFiles()){
                                if(!c.equals("All")){
                                    if(file.getName().endsWith(c)){
                                    finfilename = file.getName().toString();
                                    out.print(finfilename);
                                    }
                                }
                                else{
                                    if(!file.getName().endsWith(".txt")){
                                        finfilename = file.getName().toString();
                                        out.print(finfilename);
                                    }
                                }
                            }
                        }
                    } 
                }
            }catch(Exception e){
                out.print("Not Entries");
            }
         }*/
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
