/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entity.CountComplaintByCategory;
import entity.CountComplaintByDepartment;
import entity.CountComplaintByTechnician;
import entity.TbDepartments;
import entity.TbStaffs;
import java.util.List;
import javax.ejb.EJB;
import sessionbean.CountComplaintByCategoryFacadeLocal;
import sessionbean.CountComplaintByDepartmentFacadeLocal;
import sessionbean.CountComplaintByTechnicianFacadeLocal;
import sessionbean.TbDepartmentsFacadeLocal;
import sessionbean.TbStaffsFacadeLocal;


/**
 *
 * @author tuyenbui
 */
public class TSummaryReportMB {
    @EJB
    private TbDepartmentsFacadeLocal tbDepartmentsFacade;
    @EJB
    private TbStaffsFacadeLocal tbStaffsFacade;
    @EJB
    private CountComplaintByTechnicianFacadeLocal countComplaintByTechnicianFacade;
    @EJB
    private CountComplaintByCategoryFacadeLocal countComplaintByCategoryFacade;
    @EJB
    private CountComplaintByDepartmentFacadeLocal countComplaintByDepartmentFacade;




    private List<CountComplaintByDepartment> sumListByDept;


    
    /** Creates a new instance of TSummaryReportMB */
    public TSummaryReportMB() {
    }

    public List<CountComplaintByDepartment> getSumListByDept(){
        this.sumListByDept = countComplaintByDepartmentFacade.findAll();
        return sumListByDept;
    }

    public List<CountComplaintByTechnician> getSumListByTech(){
        return countComplaintByTechnicianFacade.findAll();
    }

    public List<CountComplaintByCategory> getSumListByCate(){
        return countComplaintByCategoryFacade.findAll();
    }

    public TbStaffs findStaff(String staffId){
        return tbStaffsFacade.find(staffId);
    }

    public TbDepartments findDept(String deptId){
        return tbDepartmentsFacade.find(deptId);
    }


}
