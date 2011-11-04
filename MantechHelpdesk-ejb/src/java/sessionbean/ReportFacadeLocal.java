/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Report;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface ReportFacadeLocal {

    void create(Report report);

    void edit(Report report);

    void remove(Report report);

    Report find(Object id);

    List<Report> findAll();

    List<Report> findRange(int[] range);

    int count();

    List<Report> findReportByTechnician(String technicianId);

    List<Report> findReportByCategory(String categoryId);

    List<Report> findReportByDepartment(String departmentId);

    List<Report> findDailyReportWithFilter(Date date, String filterName, String fiterValue);

    List<Report> findWeeklyReportWithFilter(Date startDate, Date endDate, String filterName, String fiterValue);

    List<Report> findMonthlyReportWithFilter(int month, int year, String filterName,String filterValue);
}
