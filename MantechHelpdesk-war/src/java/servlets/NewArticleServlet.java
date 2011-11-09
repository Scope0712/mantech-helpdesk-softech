/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import entity.TbAccounts;
import entity.TbCategories;
import entity.TbStaffs;
import entity.TbTechnicalArticles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbTechnicalArticlesFacadeLocal;

/**
 *
 * @author DELL
 */
public class NewArticleServlet extends HttpServlet {
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;

    @EJB
    private TbTechnicalArticlesFacadeLocal TbArticles;
    
    private TbCategories myCategory;
    private TbTechnicalArticles newArticle;
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
        //String staffId = request.getParameter("staffId");
        String categoryId = request.getParameter("categoryId");
        String title = request.getParameter("title");
        String content = request.getParameter("content2");
        String status = request.getParameter("status");
        // Cut String staffId
        String id = (String) request.getSession().getAttribute("username_online");
        //String staff_Id = staffId.substring(0, 10);
        //System.out.println(id);
        //myStaff = new TbStaffs();
        TbStaffs a = tbAccountsFacade.find(id).getTbStaffs();
        myCategory = new TbCategories(categoryId);
        newArticle = new TbTechnicalArticles();
        newArticle.setArticleId("abc"); // Tigger genera automatic
        newArticle.setTbStaffs(a);
        newArticle.setTbCategories(myCategory);
        newArticle.setTitle(title);
        newArticle.setDetailContent(content);
        newArticle.setCreateDate(new Date());
        newArticle.setUpdateDate(new Date());
        newArticle.setViewNo(0);
        newArticle.setRate(0);
        newArticle.setRateTotal(0);
        newArticle.setRating(0);
        newArticle.setStarOne(0);
        newArticle.setStarTwo(0);
        newArticle.setStarThree(0);
        newArticle.setStarFour(0);
        newArticle.setStarFive(0);
        newArticle.setStarSix(0);
        newArticle.setStarSeven(0);
        newArticle.setStarEight(0);
        newArticle.setStarNine(0);
        newArticle.setStarTen(0);
        newArticle.setStatus(status);
        TbArticles.create(newArticle);
        response.sendRedirect("faces/admin/ShowAllArticles.xhtml");
//        try {
//            /* TODO output your page here
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewArticleServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewArticleServlet at " + request.getContextPath () + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//            */
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
