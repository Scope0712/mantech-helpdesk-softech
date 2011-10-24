/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbTechnicalArticles;
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

}
