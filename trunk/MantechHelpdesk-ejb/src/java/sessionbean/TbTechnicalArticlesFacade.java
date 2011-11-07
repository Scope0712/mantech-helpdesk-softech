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
import javax.persistence.Query;

/**
 *
 * @author DELL
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
        Query q = em.createNativeQuery("SELECT * FROM TbTechnicalArticles AS c WHERE c.Title LIKE ?value Or c.Detail_Content LIKE ?value and c.Status = 'Enable'", TbTechnicalArticles.class);
        q.setParameter("value", "%" + search + "%");
        return q.getResultList();
    }

    @Override
    public List<TbTechnicalArticles> selectTopArticles() {
        Query q = em.createNativeQuery("SELECT Top 5 * FROM TbTechnicalArticles c where c.Status = 'Enable' ORDER BY c.View_No DESC", TbTechnicalArticles.class);
        return q.getResultList();
    }

    @Override
    public List<TbTechnicalArticles> selectNewArticles() {
        Query q = em.createNativeQuery("SELECT TOP 5 * FROM TbTechnicalArticles c where c.Status = 'Enable' ORDER BY c.Create_Date DESC ", TbTechnicalArticles.class);
        return q.getResultList();
    }

    @Override
    public List<TbTechnicalArticles> findAllArticles() {
        Query q = em.createNativeQuery("SELECT * FROM TbTechnicalArticles c where c.Status = 'Enable'", TbTechnicalArticles.class);
        return q.getResultList();
    }

    @Override
    public List<TbTechnicalArticles> sortArticlesByCategory(String category) {
        Query q = em.createNativeQuery("SELECT * FROM TbTechnicalArticles AS c WHERE c.Category_Id = ?value and c.Status = 'Enable'", TbTechnicalArticles.class);
        q.setParameter("value", category);
        return q.getResultList();
    }
}
