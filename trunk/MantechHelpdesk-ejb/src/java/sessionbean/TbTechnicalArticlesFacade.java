/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.TbTechnicalArticles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbTechnicalArticlesFacade extends AbstractFacade<TbTechnicalArticles> implements TbTechnicalArticlesFacadeLocal {

    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbTechnicalArticlesFacade() {
        super(TbTechnicalArticles.class);
    }

    @Override
    public List<TbTechnicalArticles> findAllBySearch(String search) {
        return getEntityManager().createQuery("select object(o) from TbTechnicalArticles o where o.title like '%ptimal Deterrence when%'").getResultList();
    }
}
