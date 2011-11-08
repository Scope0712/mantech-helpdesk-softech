/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entity.CountComplaintByDepartment;
import java.util.List;
import javax.ejb.EJB;
import sessionbean.CountComplaintByDepartmentFacadeLocal;


/**
 *
 * @author tuyenbui
 */
public class TSummaryReportMB {
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

}
