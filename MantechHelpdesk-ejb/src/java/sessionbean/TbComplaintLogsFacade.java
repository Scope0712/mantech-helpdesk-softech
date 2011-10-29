/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.TbComplaintLogs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbComplaintLogsFacade extends AbstractFacade<TbComplaintLogs> implements TbComplaintLogsFacadeLocal {

    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbComplaintLogsFacade() {
        super(TbComplaintLogs.class);
    }

    public int findResendNo(String complaintId) {
         return (Integer) em.createNativeQuery("select max(resend_no)from tbComplaintLogs where complaint_Id = ?1").setParameter(1, complaintId).getSingleResult();       
       // return (Integer) em.createQuery("SELECT MAX(x.resendNo) FROM TbComplaintLogs x WHERE x.TbComplaintLogsPK.complaintId = :complaintId").setParameter("complaintId", complaintId).getSingleResult();
       
    }
}
