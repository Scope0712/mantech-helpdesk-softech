/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbRolesFacadeLocal {

    void create(TbRoles tbRoles);

    void edit(TbRoles tbRoles);

    void remove(TbRoles tbRoles);

    TbRoles find(Object id);

    List<TbRoles> findAll();

    List<TbRoles> findRange(int[] range);

    int count();

}
