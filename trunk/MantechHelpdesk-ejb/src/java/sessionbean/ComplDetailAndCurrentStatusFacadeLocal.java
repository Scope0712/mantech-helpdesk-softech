/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.ComplDetailAndCurrentStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface ComplDetailAndCurrentStatusFacadeLocal {

    void create(ComplDetailAndCurrentStatus complDetailAndCurrentStatus);

    void edit(ComplDetailAndCurrentStatus complDetailAndCurrentStatus);

    void remove(ComplDetailAndCurrentStatus complDetailAndCurrentStatus);

    ComplDetailAndCurrentStatus find(Object id);

    List<ComplDetailAndCurrentStatus> findAll();

    List<ComplDetailAndCurrentStatus> findRange(int[] range);

    int count();

    List<ComplDetailAndCurrentStatus> findByStatus(String StatusId);

    List<ComplDetailAndCurrentStatus> findNewCompls();

    List<ComplDetailAndCurrentStatus> findResendCompls();

    List<ComplDetailAndCurrentStatus> findAllNeedAssign();

}
