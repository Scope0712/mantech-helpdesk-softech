/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.ComplDetailAndCurrentStatus;
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
public class ComplDetailAndCurrentStatusFacade extends AbstractFacade<ComplDetailAndCurrentStatus> implements ComplDetailAndCurrentStatusFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ComplDetailAndCurrentStatusFacade() {
        super(ComplDetailAndCurrentStatus.class);
    }


//
    public List<ComplDetailAndCurrentStatus> findByStatus(String StatusId) {
          try {
            Query query = em.createNamedQuery("ComplDetailAndCurrentStatus.findByStatus");
            return (List<ComplDetailAndCurrentStatus>) query.setParameter("status", StatusId).getResultList();
        } catch (Exception ex) {
            System.out.println("Error in findByStatus !");
            ex.printStackTrace();
            return null;
        }
    }

       //tuyen
//    @NamedQuery(name = "ComplDetailAndCurrentStatus.findAllNeedAssign", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' or c.status = 'Statu00004'"),
//    @NamedQuery(name = "ComplDetailAndCurrentStatus.findNewCompls", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' and c.resendNo = 0 and c.complaintid not in (Select o.tbComplaints.complaintId from TbAssignTasks o)"),
//    @NamedQuery(name = "ComplDetailAndCurrentStatus.findResendCompls", query = "SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' and c.resendNo <> 0")})

    public List<ComplDetailAndCurrentStatus> findNewCompls() {
         try {
            //return (List<ComplDetailAndCurrentStatus>) em.createNamedQuery("ComplDetailAndCurrentStatus.findNewCompls").getResultList();
             return (List<ComplDetailAndCurrentStatus>) em.createQuery("SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' and c.resendNo = 0 and c.complaintid not in (Select o.tbComplaints.complaintId from TbAssignTasks o)").getResultList();
        } catch (Exception ex) {
            System.out.println("Error in findNewCompls!");
            ex.printStackTrace();
            return null;
        }
    }

    public List<ComplDetailAndCurrentStatus> findResendCompls() {
         try {
            //return (List<ComplDetailAndCurrentStatus>) em.createNamedQuery("ComplDetailAndCurrentStatus.findResendCompls").getResultList();
             return (List<ComplDetailAndCurrentStatus>) em.createQuery("SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' and c.resendNo <> 0").getResultList();
        } catch (Exception ex) {
            System.out.println("Error in findResendCompls!");
            ex.printStackTrace();
            return null;
        }
    }

    public List<ComplDetailAndCurrentStatus> findAllNeedAssign() {
         try {
            //return (List<ComplDetailAndCurrentStatus>) em.createNamedQuery("ComplDetailAndCurrentStatus.findAllNeedAssign").getResultList();
             return (List<ComplDetailAndCurrentStatus>) em.createQuery("SELECT c FROM ComplDetailAndCurrentStatus c WHERE c.status = 'Statu00001' or c.status = 'Statu00004'").getResultList();
        } catch (Exception ex) {
            System.out.println("Error in findAllNeedAssign!");
            ex.printStackTrace();
            return null;
        }
    }

}
