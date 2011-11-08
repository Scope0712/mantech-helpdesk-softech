/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbFAQs;
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
    public List<TbFAQs> findAllFAQs() {
        Query q = em.createNativeQuery("SELECT * FROM TbFAQs c where c.Status = 'Enable'", TbFAQs.class);
        return q.getResultList();
    }

    @Override
    public List<TbFAQs> searchListFAQs(String search) {
        Query q = em.createNativeQuery("SELECT * FROM TbFAQs c where c.Content_Question LIKE ?value Or c.Detail_Answer LIKE ?value", TbFAQs.class);
        q.setParameter("value", "%" + search + "%");
        return q.getResultList();
    }

}
