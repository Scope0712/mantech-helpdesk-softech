/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entity.TbComplaintStatus;
import javax.ejb.EJB;
import sessionbean.TbComplaintStatusFacadeLocal;


/**
 *
 * @author tuyenbui
 */
public class TStatusMB {
    @EJB
    private TbComplaintStatusFacadeLocal tbComplaintStatusFacade;

    /** Creates a new instance of TStatusMB */
    public TStatusMB() {
    }

    public TbComplaintStatus findStatus(String statusId){
        return tbComplaintStatusFacade.find(statusId);
    }

}
