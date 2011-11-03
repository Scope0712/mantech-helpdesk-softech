/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Report;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    public List<Report> findReportByTechnician(String technicianId) {
//          @NamedQuery(name = "Report.findByEmployeeId", query = "SELECT r FROM Report r WHERE r.employeeid = :employeeid"),
//    @NamedQuery(name = "Report.findByTechnicianId", query = "SELECT r FROM Report r WHERE r.technicianid = :technicianid"),
// @NamedQuery(name = "Report.findByCategoryid", query = "SELECT r FROM Report r WHERE r.categoryid = :categoryid"),
        return (List<Report>) em.createNamedQuery("Report.findByTechnicianId").setParameter("technicianid", technicianId).getResultList();
    }

    public List<Report> findReportByCategory(String categoryId) {
        return (List<Report>) em.createNamedQuery("Report.findByCategoryid").setParameter("categoryid", categoryId).getResultList();
    }

    public List<Report> findReportByDepartment(String departmentId) {
       return (List<Report>) em.createNamedQuery("Report.findByDepartmentId").setParameter("departmentid", departmentId).getResultList(); 
    }
}
