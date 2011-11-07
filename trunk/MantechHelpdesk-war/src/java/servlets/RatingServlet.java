/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.TbTechnicalArticles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.TbTechnicalArticlesFacadeLocal;

/**
 *
 * @author DELL
 */
@WebServlet(name = "RatingServlet", urlPatterns = {"/RatingServlet"})
public class RatingServlet extends HttpServlet {

    @EJB
    private TbTechnicalArticlesFacadeLocal TbTechnicalArticlesFacade;
    private TbTechnicalArticles myTbTechnicalArticles;

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
        int ratevalue = Integer.parseInt(request.getParameter("rategroup"));
        String articleid = request.getParameter("articleid");
        myTbTechnicalArticles = TbTechnicalArticlesFacade.find(articleid);
        System.out.println("So gia tri rate chon :" + ratevalue);
        // Save information of my article before update
        int rate = myTbTechnicalArticles.getRate();
        int rate_total = myTbTechnicalArticles.getRateTotal();
        int rating = myTbTechnicalArticles.getRating();
        System.out.println("So gia tri rate truoc :" + rate);
        System.out.println("So gia tri rate_Total truoc :" + rate_total);
        System.out.println("So gia tri rating truoc :" + rating);
        // Update information
        int newrating = rating + ratevalue;
        int newrate_total = rate_total + 1;
        int newrate = Math.round(newrating / newrate_total);
        
        System.out.println("So gia tri rate sau :" + newrate);
        System.out.println("So gia tri rate_Total sau :" + newrate_total);
        System.out.println("So gia tri rating sau :" + newrating);

        myTbTechnicalArticles.setRate(newrate);
        myTbTechnicalArticles.setRateTotal(newrate_total);
        myTbTechnicalArticles.setRating(newrating);
        // Reset value star of
        myTbTechnicalArticles.setStarOne(0);
        myTbTechnicalArticles.setStarTwo(0);
        myTbTechnicalArticles.setStarThree(0);
        myTbTechnicalArticles.setStarFour(0);
        myTbTechnicalArticles.setStarFive(0);
        myTbTechnicalArticles.setStarSix(0);
        myTbTechnicalArticles.setStarSeven(0);
        myTbTechnicalArticles.setStarEight(0);
        myTbTechnicalArticles.setStarNine(0);
        myTbTechnicalArticles.setStarTen(0);
        // Update Status Star
        int temp = 1;
        while(temp <= newrate)
        {
            switch (temp) {
                case 1:
                    myTbTechnicalArticles.setStarOne(1);
                    if (temp == 1) {
                        break;
                    }
                case 2:
                    myTbTechnicalArticles.setStarTwo(1);
                    if (temp == 2) {
                        break;
                    }
                case 3:
                    myTbTechnicalArticles.setStarThree(1);
                    if (temp == 3) {
                        break;
                    }
                case 4:
                    myTbTechnicalArticles.setStarFour(1);
                    if (temp == 4) {
                        break;
                    }
                case 5:
                    myTbTechnicalArticles.setStarFive(1);
                    if (temp == 5) {
                        break;
                    }
                case 6:
                    myTbTechnicalArticles.setStarSix(1);
                    if (temp == 6) {
                        break;
                    }
                case 7:
                    myTbTechnicalArticles.setStarSeven(1);
                    if (temp == 7) {
                        break;
                    }
                case 8:
                    myTbTechnicalArticles.setStarEight(1);
                    if (temp == 8) {
                        break;
                    }
                case 9:
                    myTbTechnicalArticles.setStarNine(1);
                    if (temp == 9) {
                        break;
                    }
                case 10:
                    myTbTechnicalArticles.setStarTen(1);
                    if (temp == 10) {
                        break;
                    }
            }
            temp ++;
        }

        myTbTechnicalArticles.setUpdateDate(new Date());
        TbTechnicalArticlesFacade.edit(myTbTechnicalArticles);

        response.sendRedirect("faces/public/ShowAllArticles.xhtml");
//        try {
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RatingServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RatingServlet at " + request.getContextPath() + "</h1>");
//            out.println("<h1>Value of Rate : " + ratevalue + "</h1>");
//            out.println("<h1>Value ID of Article : " + articleid + "</h1>");
//            out.println("<h1>Content of Article : " + myTbTechnicalArticles.getDetailContent() + "</h1>");
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
