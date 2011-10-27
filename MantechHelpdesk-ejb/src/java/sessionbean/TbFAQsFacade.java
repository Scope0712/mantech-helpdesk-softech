/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbFAQs;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbFAQsFacade extends AbstractFacade<TbFAQs> implements TbFAQsFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbFAQsFacade() {
        super(TbFAQs.class);
    }

    @Override
    public Collection<TbFAQs> findFAQById(String id) {
        Query q = em.createNativeQuery("SELECT * FROM tbFAQs AS a WHERE a.FAQ_Id = ?value", TbFAQs.class);
        q.setParameter("value","%"+ id +"%");
        return q.getResultList();
    }

}
