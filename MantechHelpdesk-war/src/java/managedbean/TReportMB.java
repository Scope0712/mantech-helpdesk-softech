/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entity.Report;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessionbean.ReportFacadeLocal;

/**
 *
 * @author tuyenbui
 */
@ManagedBean
@RequestScoped
public class TReportMB {
    @EJB
    private ReportFacadeLocal reportFacade;


    /** Creates a new instance of TReportMB */
    public TReportMB() {
    }

    public List<Report> getReportList(){
        return reportFacade.findAll();
    }


}
