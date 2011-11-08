/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.TbCategories;
import entity.TbFAQs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbFAQsFacadeLocal;

/**
 *
 * @author DELL
 */
public class NewFAQServlet extends HttpServlet {

    @EJB
    private TbFAQsFacadeLocal TbFAQs;
    private TbCategories myCategory;
    private TbFAQs newFAQ;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String categoryId = request.getParameter("categoryId");
        String question = request.getParameter("question");
        String anwswer = request.getParameter("anwswer");
        String status = request.getParameter("status");
        myCategory = new TbCategories(categoryId);
        newFAQ = new TbFAQs();
        newFAQ.setFaqId("abc"); // Tigger genera automatic
        newFAQ.setTbCategories(myCategory);
        newFAQ.setContentQuestion(question);
        newFAQ.setDetailAnswer(anwswer);
        newFAQ.setCreateDate(new Date());
        newFAQ.setUpdateDate(new Date());
        newFAQ.setStatus(status);
        TbFAQs.create(newFAQ);
        response.sendRedirect("faces/admin/ShowAllFAQs.xhtml");
//        try {
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewFAQServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewFAQServlet at " + request.getContextPath() + "</h1>");
//            out.println("<h1>Anwser content : " + categoryId + " " + question + " " + anwswer + " " + status + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {
//            out.close();
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
