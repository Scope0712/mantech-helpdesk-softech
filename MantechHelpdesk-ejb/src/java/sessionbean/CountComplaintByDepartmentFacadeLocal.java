/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.CountComplaintByDepartment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface CountComplaintByDepartmentFacadeLocal {

    void create(CountComplaintByDepartment countComplaintByDepartment);

    void edit(CountComplaintByDepartment countComplaintByDepartment);

    void remove(CountComplaintByDepartment countComplaintByDepartment);

    CountComplaintByDepartment find(Object id);

    List<CountComplaintByDepartment> findAll();

    List<CountComplaintByDepartment> findRange(int[] range);

    int count();

    //List<CountComplaintByDepartment> CountByDepartment();

}
