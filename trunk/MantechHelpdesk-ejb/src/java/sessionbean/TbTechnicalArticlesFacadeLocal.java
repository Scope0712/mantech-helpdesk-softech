/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbTechnicalArticles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbTechnicalArticlesFacadeLocal {

    void create(TbTechnicalArticles tbTechnicalArticles);

    void edit(TbTechnicalArticles tbTechnicalArticles);

    void remove(TbTechnicalArticles tbTechnicalArticles);

    TbTechnicalArticles find(Object id);

    List<TbTechnicalArticles> findAll();

    List<TbTechnicalArticles> findRange(int[] range);

    int count();

    List<TbTechnicalArticles> findAllBySearch(String search);
}
