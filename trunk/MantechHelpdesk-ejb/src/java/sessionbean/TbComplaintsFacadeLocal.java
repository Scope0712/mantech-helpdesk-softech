/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbComplaints;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbComplaintsFacadeLocal {

    void create(TbComplaints tbComplaints);

    void edit(TbComplaints tbComplaints);

    void remove(TbComplaints tbComplaints);

    TbComplaints find(Object id);

    List<TbComplaints> findAll();

    List<TbComplaints> findRange(int[] range);

    int count();

}
