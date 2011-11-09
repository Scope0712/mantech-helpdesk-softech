/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.CountComplaintByCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface CountComplaintByCategoryFacadeLocal {

    void create(CountComplaintByCategory countComplaintByCategory);

    void edit(CountComplaintByCategory countComplaintByCategory);

    void remove(CountComplaintByCategory countComplaintByCategory);

    CountComplaintByCategory find(Object id);

    List<CountComplaintByCategory> findAll();

    List<CountComplaintByCategory> findRange(int[] range);

    int count();

}
