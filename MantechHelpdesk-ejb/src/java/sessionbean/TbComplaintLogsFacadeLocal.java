/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbComplaintLogs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbComplaintLogsFacadeLocal {

    void create(TbComplaintLogs tbComplaintLogs);

    void edit(TbComplaintLogs tbComplaintLogs);

    void remove(TbComplaintLogs tbComplaintLogs);

    TbComplaintLogs find(Object id);

    List<TbComplaintLogs> findAll();

    List<TbComplaintLogs> findRange(int[] range);

    int count();

}
