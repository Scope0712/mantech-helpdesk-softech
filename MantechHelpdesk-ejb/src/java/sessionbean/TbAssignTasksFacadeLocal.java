/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbAssignTasks;
import entity.TbStaffs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbAssignTasksFacadeLocal {

    void create(TbAssignTasks tbAssignTasks);

    void edit(TbAssignTasks tbAssignTasks);

    void remove(TbAssignTasks tbAssignTasks);

    TbAssignTasks find(Object id);

    List<TbAssignTasks> findAll();

    List<TbAssignTasks> findRange(int[] range);

    int count();

    List<TbAssignTasks> findTask(TbStaffs tbStaffs);

}
