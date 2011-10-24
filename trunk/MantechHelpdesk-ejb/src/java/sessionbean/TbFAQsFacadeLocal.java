/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbFAQs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbFAQsFacadeLocal {

    void create(TbFAQs tbFAQs);

    void edit(TbFAQs tbFAQs);

    void remove(TbFAQs tbFAQs);

    TbFAQs find(Object id);

    List<TbFAQs> findAll();

    List<TbFAQs> findRange(int[] range);

    int count();

}
