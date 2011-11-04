/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Report;
import entity.TbAccounts;
import entity.TbCategories;
import entity.TbDepartments;
import entity.TbStaffs;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import sessionbean.ReportFacadeLocal;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import util.Week;

/**
 *
 * @author tuyenbui
 */
@ManagedBean
@SessionScoped
public class TReportMB {

    @EJB
    private TbDepartmentsFacadeLocal tbDepartmentsFacade;
    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;
    @EJB
    private ReportFacadeLocal reportFacade;
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    private String periodType;
    private String filter;
    private TbCategories category;
    private TbStaffs technician;
    private TbDepartments department;
    private String summaryreport;
    private List<Report> detailreport;
    private String filterValue;   
    private boolean filterDisabled = true;
    private boolean filterValueDisabled = true;

    /** Creates a new instance of TReportMB */
    public TReportMB() {
    }

    public TbCategories getCategory() {
        return category;
    }

    public void setCategory(TbCategories category) {
        this.category = category;
    }

    public TbDepartments getDepartment() {
        return department;
    }

    public void setDepartment(TbDepartments department) {
        this.department = department;
    }

    public List<Report> getDetailreport() {
        System.out.println("get Report table");
        System.out.println(filter);
        System.out.println(filterValue);
        System.out.println(periodType);
        if (filter != null && filterValue != null) {
            if (periodType.equals("Daily")) {
                detailreport = reportFacade.findDailyReportWithFilter(new Date(), filter, filterValue);
                System.out.println("goi session bean daily");
            } else if (periodType.equals("Weekly")) {
                Date weekStartDate = Week.getWeekStartDate(new Date());
                Date weekEndDate = Week.getWeekEndDate(new Date());
                detailreport = reportFacade.findWeeklyReportWithFilter(weekStartDate, weekEndDate,filter, filterValue);
            } else if (periodType.equals("Monthly")) {
                Calendar cal = Calendar.getInstance();
                detailreport = reportFacade.findMonthlyReportWithFilter(cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR), filter, filterValue);
            }
        }

        return detailreport;
    }

    public void setDetailreport(List<Report> detailreport) {
        this.detailreport = detailreport;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
        filterValueDisabled = false;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
        filterDisabled = false;
    }

    public String getSummaryreport() {
        return summaryreport;
    }

    public void setSummaryreport(String summaryreport) {
        this.summaryreport = summaryreport;
    }

    public TbStaffs getTechnician() {
        return technician;
    }

    public void setTechnician(TbStaffs technician) {
        this.technician = technician;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public boolean isFilterDisabled() {
        return filterDisabled;
    }

    public void setFilterDisabled(boolean filterDisabled) {
        this.filterDisabled = filterDisabled;
    }

    public boolean isFilterValueDisabled() {
        return filterValueDisabled;
    }

    public void setFilterValueDisabled(boolean filterValueDisabled) {
        this.filterValueDisabled = filterValueDisabled;
    }

    public List<SelectItem> getOptions() {
        System.out.println("get Options");
        System.out.println(filter);
        System.out.println(filterValueDisabled);
        List<SelectItem> options = new ArrayList<SelectItem>();

        if (filter != null && !filterValueDisabled) {
            if (filter.equals("Category_Id")) {
                options.add(new SelectItem("--Select Category--"));
                List<TbCategories> cgrList = tbCategoriesFacade.findAll();
                for (TbCategories cgr : cgrList) {
                    options.add(new SelectItem(cgr.getCategoryId(), cgr.getCategoryName()));
                }
            } else if (filter.equals("Technician_Id")) {
                options.add(new SelectItem("--Select Technician--"));
                List<TbAccounts> technicianList = tbAccountsFacade.findByRoleAndStatus("Roles00002", "Enable");
                for (TbAccounts acc : technicianList) {
                    options.add(new SelectItem(acc.getTbStaffs().getStaffId(), acc.getTbStaffs().getStaffId()));
                }
            } else if (filter.equals("Department_Id")) {
                options.add(new SelectItem("--Select Department--"));
                List<TbDepartments> deptList = tbDepartmentsFacade.findAll();
                for (TbDepartments dept : deptList) {
                    options.add(new SelectItem(dept.getDepartmentId(), dept.getDepartmentName()));
                }
            }
        } else {
            options.add(new SelectItem("--No options--"));
        }
        for (SelectItem item : options) {
            System.out.println("Label:" + item.getLabel() + " - Value:" + item.getValue().toString());
        }

        return options;
    }


    public List<Report> getReportList() {
        return reportFacade.findAll();
    }

    public List<Report> getDailyList() {
        return reportFacade.findDailyReportWithFilter(new Date(), "Department_Id", "Depar00002");
    }
}
