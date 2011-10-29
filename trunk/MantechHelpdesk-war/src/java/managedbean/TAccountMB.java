/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entity.TbAccounts;
import java.util.List;
import javax.ejb.EJB;
import sessionbean.TbAccountsFacadeLocal;

/**
 *
 * @author tuyenbui
 */
public class TAccountMB {
    @EJB
    private TbAccountsFacadeLocal tbAccountsFacade;
    List<TbAccounts> technicianList;

    //get available technician
    public List<TbAccounts> getTechnicianList() {
        technicianList = tbAccountsFacade.findByRoleAndStatus("Roles00002","Enable");
        return technicianList;
    }

    /** Creates a new instance of TAccountMB */
    public TAccountMB() {
    }


}
