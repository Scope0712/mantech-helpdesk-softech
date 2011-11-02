/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.ViewAssignTaskDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dell
 */
@Local
public interface ViewAssignTaskDetailsFacadeLocal {

    void create(ViewAssignTaskDetails viewAssignTaskDetails);

    void edit(ViewAssignTaskDetails viewAssignTaskDetails);

    void remove(ViewAssignTaskDetails viewAssignTaskDetails);

    ViewAssignTaskDetails find(Object id);

    List<ViewAssignTaskDetails> findAll();

    List<ViewAssignTaskDetails> findRange(int[] range);

    int count();

}
