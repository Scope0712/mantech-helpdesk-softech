/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.CountComplaintByDepartment;
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
public class CountComplaintByDepartmentFacade extends AbstractFacade<CountComplaintByDepartment> implements CountComplaintByDepartmentFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CountComplaintByDepartmentFacade() {
        super(CountComplaintByDepartment.class);
    }


}
