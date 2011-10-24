/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbStaffs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbStaffsFacadeLocal {

    void create(TbStaffs tbStaffs);

    void edit(TbStaffs tbStaffs);

    void remove(TbStaffs tbStaffs);

    TbStaffs find(Object id);

    List<TbStaffs> findAll();

    List<TbStaffs> findRange(int[] range);

    int count();

}
