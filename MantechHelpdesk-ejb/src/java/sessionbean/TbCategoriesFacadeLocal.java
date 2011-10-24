/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbCategories;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbCategoriesFacadeLocal {

    void create(TbCategories tbCategories);

    void edit(TbCategories tbCategories);

    void remove(TbCategories tbCategories);

    TbCategories find(Object id);

    List<TbCategories> findAll();

    List<TbCategories> findRange(int[] range);

    int count();

}
