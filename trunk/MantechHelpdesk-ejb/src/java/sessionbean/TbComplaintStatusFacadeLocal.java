/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbComplaintStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbComplaintStatusFacadeLocal {

    void create(TbComplaintStatus tbComplaintStatus);

    void edit(TbComplaintStatus tbComplaintStatus);

    void remove(TbComplaintStatus tbComplaintStatus);

    TbComplaintStatus find(Object id);

    List<TbComplaintStatus> findAll();

    List<TbComplaintStatus> findRange(int[] range);

    int count();

}
