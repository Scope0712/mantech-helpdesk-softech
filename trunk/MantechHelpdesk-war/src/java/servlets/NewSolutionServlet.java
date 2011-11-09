/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import entity.TbCategories;
import entity.TbSolutions;
import entity.TbStaffs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbSolutionsFacadeLocal;

/**
 *
 * @author DELL
 */
public class NewSolutionServlet extends HttpServlet {
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    @EJB
    private TbSolutionsFacadeLocal TbSolutions;
    private TbCategories myCategory;
    private TbStaffs myStaff;
    private TbSolutions newSolution;
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
        String problem = request.getParameter("problem");
        String resolve = request.getParameter("resolve");
        String status = request.getParameter("status");
        //String staff_Id = staffId.substring(0, 10);
        System.out.println("Noi dung :" + problem);
        String id = (String) request.getSession().getAttribute("username_online");
        TbStaffs a = tbAccountsFacade.find(id).getTbStaffs();
        myCategory = new TbCategories(categoryId);
        newSolution = new TbSolutions();
        newSolution.setSolutionId("abc"); // Tigger genera automatic
        newSolution.setTbStaffs(a);
        newSolution.setTbCategories(myCategory);
        newSolution.setProblemContent(problem);
        newSolution.setDetailResolve(resolve);
        newSolution.setCreateDate(new Date());
        newSolution.setUpdateDate(new Date());
        newSolution.setStatus(status);
        TbSolutions.create(newSolution);
        response.sendRedirect("faces/admin/ShowAllSolutions.xhtml");
//        try {
//            /* TODO output your page here
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewSolutionServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewSolutionServlet at " + request.getContextPath () + "</h1>");
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
