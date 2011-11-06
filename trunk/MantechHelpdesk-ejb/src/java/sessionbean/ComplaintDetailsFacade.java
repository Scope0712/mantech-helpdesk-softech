/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.ComplaintDetails;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author THANH
 */
@Stateless
public class ComplaintDetailsFacade extends AbstractFacade<ComplaintDetails> implements ComplaintDetailsFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ComplaintDetailsFacade() {
        super(ComplaintDetails.class);
    }
    @Override
    public List<ComplaintDetails> findByEmployeeID(String id) {
        try{
        return (List<ComplaintDetails>) em.createNamedQuery("ComplaintDetails.findByEmployeeID").setParameter("employeeID", id).getResultList();
        }catch(Exception ex){
            System.out.println("error");
            return null;
        }

    }
//Thanh:      @NamedQuery(name = "ComplaintDetails.findComplaintStatus", query = "SELECT c FROM ComplaintDetails c WHERE c.statusId = :statusId and c.employeeID= :employeeID")})
    public List<ComplaintDetails> findComplaintStatus(String id,String status) {
        try{
        //return (List<ComplaintDetails>) em.createNamedQuery("ComplaintDetails.findComplaintStatus").setParameter("statusId", status).setParameter("employeeID", id).getResultList();
        return (List<ComplaintDetails>) em.createQuery("SELECT c FROM ComplaintDetails c WHERE c.statusId = :statusId and c.employeeID= :employeeID").setParameter("statusId", status).setParameter("employeeID", id).getResultList();
        }catch(Exception ex){
            System.out.println("error");
            return null;
        }

    }

}
