/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbAccounts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface TbAccountsFacadeLocal {

    void create(TbAccounts tbAccounts);

    void edit(TbAccounts tbAccounts);

    void remove(TbAccounts tbAccounts);

    TbAccounts find(Object id);

    List<TbAccounts> findAll();

    List<TbAccounts> findRange(int[] range);

    int count();

    TbAccounts checkUsernamePassword(String username, String password);

}
