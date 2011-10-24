/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbDepartments;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbDepartmentsFacadeLocal {

    void create(TbDepartments tbDepartments);

    void edit(TbDepartments tbDepartments);

    void remove(TbDepartments tbDepartments);

    TbDepartments find(Object id);

    List<TbDepartments> findAll();

    List<TbDepartments> findRange(int[] range);

    int count();

}
