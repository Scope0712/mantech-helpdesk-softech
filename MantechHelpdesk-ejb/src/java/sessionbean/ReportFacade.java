/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Report;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class ReportFacade extends AbstractFacade<Report> implements ReportFacadeLocal {

    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportFacade() {
        super(Report.class);
    }

//    public List<Report> findReportByTechnician(String technicianId) {
//        return (List<Report>) em.createNamedQuery("Report.findByTechnicianId").setParameter("technicianid", technicianId).getResultList();
//    }
//
//    public List<Report> findReportByCategory(String categoryId) {
//        return (List<Report>) em.createNamedQuery("Report.findByCategoryid").setParameter("categoryid", categoryId).getResultList();
//    }
//
//    public List<Report> findReportByDepartment(String departmentId) {
//        return (List<Report>) em.createNamedQuery("Report.findByDepartmentId").setParameter("departmentid", departmentId).getResultList();
//    }

//dung cho report:
//          @NamedQuery(name = "Report.findByEmployeeId", query = "SELECT r FROM Report r WHERE r.employeeid = :employeeid"),
//    @NamedQuery(name = "Report.findByTechnicianId", query = "SELECT r FROM Report r WHERE r.technicianid = :technicianid"),
// @NamedQuery(name = "Report.findByCategoryid", query = "SELECT r FROM Report r WHERE r.categoryid = :categoryid"),
    public List<Report> findDailyReportWithFilter(Date date, String filterName, String filterValue) {
        Query query = em.createNativeQuery("select * from report where DATEDIFF (DAY,Lodging_Date,?date)= 0 and +" + filterName + "= ?fiterValue", Report.class);
        query.setParameter("date", date).setParameter("fiterValue", filterValue);
        return (List<Report>) query.getResultList();
    }

    public List<Report> findWeeklyReportWithFilter(Date startDate, Date endDate, String filterName, String filterValue) {
        Query query = em.createNativeQuery("select * from report where Lodging_Date between ?startdate and ?enddate and " + filterName + "= ?fiterValue", Report.class);
        query.setParameter("startdate", startDate).setParameter("enddate", endDate).setParameter("fiterValue", filterValue);
        return (List<Report>) query.getResultList();
        //complaint_id,Category_id,Employee_Id,Department_Id,Technician_Id,Resend_No,Status,Lodging_Date,Assigning_Date,Latest_Modify_Date,Solving_Time
    }

    public List<Report> findMonthlyReportWithFilter(int month, int year, String filterName, String filterValue) {
        Query query = em.createNativeQuery("select * from report where Month(Lodging_Date)= ?month and Year(Lodging_Date) = ?year and " + filterName + "= ?fiterValue", Report.class);
        query.setParameter("month", month).setParameter("year", year).setParameter("fiterValue", filterValue);
        return (List<Report>) query.getResultList();
    }
}
