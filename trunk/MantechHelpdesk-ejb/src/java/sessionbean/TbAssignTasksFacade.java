/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbAssignTasks;
import entity.TbStaffs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbAssignTasksFacade extends AbstractFacade<TbAssignTasks> implements TbAssignTasksFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbAssignTasksFacade() {
        super(TbAssignTasks.class);
    }

    @Override
    public List<TbAssignTasks> findTask(TbStaffs tbStaffs) {
        return em.createQuery("SELECT t FROM TbAssignTasks t WHERE t.tbStaffs = :tbStaffs").setParameter("tbStaffs",tbStaffs).getResultList();
    }
   //@NamedQuery(name = "TbAssignTasks.findTask", query = "SELECT t FROM TbAssignTasks t WHERE t.tbStaffs = :tbStaffs")
}
