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
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import sessionbean.ReportFacadeLocal;
import sessionbean.TbAccountsFacadeLocal;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;

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
    private String selectedValue;
    //private List options;
    //private SelectItem[] options;
    private boolean rendered = false;

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
        if (filter != null) {
            if (filter.equals("Category")) {
                System.out.println("get detail report for category : "+selectedValue);
                detailreport = reportFacade.findReportByCategory(selectedValue);
            } else if (filter.equals("Technician")) {
                System.out.println("get detail report for Technician: "+selectedValue);
                detailreport = reportFacade.findReportByTechnician(selectedValue);
            } else if (filter.equals("Department")){
                System.out.println("get detail report for department: "+selectedValue);
                detailreport = reportFacade.findReportByDepartment(selectedValue);
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
        rendered = true;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
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

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public List<SelectItem> getOptions() {
        System.out.println("get Options");
        System.out.println(filter);
        System.out.println(rendered);
        List<SelectItem> options = new ArrayList<SelectItem>();
        options.add(new SelectItem("--Select--"));
        if (filter != null && rendered) {
            if (filter.equals("Category")) {
                List<TbCategories> cgrList = tbCategoriesFacade.findAll();
                for (TbCategories cgr : cgrList) {
                    options.add(new SelectItem(cgr.getCategoryId(), cgr.getCategoryName()));
                }
            } else if (filter.equals("Technician")) {
                //get available technician
                List<TbAccounts> technicianList = tbAccountsFacade.findByRoleAndStatus("Roles00002", "Enable");
                for (TbAccounts acc : technicianList) {
                    options.add(new SelectItem(acc.getTbStaffs().getStaffId(), acc.getTbStaffs().getStaffId()));
                }
            } else if (filter.equals("Department")) {                
                List<TbDepartments> deptList = tbDepartmentsFacade.findAll();
                for (TbDepartments dept : deptList) {
                    options.add(new SelectItem(dept.getDepartmentId(), dept.getDepartmentName()));
                }
            }
        }
        for (SelectItem item : options) {
            System.out.println("Label:" + item.getLabel() + " - Value:" + item.getValue().toString());
        }

        return options;
    }

//    public void setOptions(SelectItem[] options) {
//        this.options = options;
//    }
    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public List<Report> getReportList() {
        return reportFacade.findAll();


    }
}
