/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.CountComplaintByTechnician;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tuyenbui
 */
@Local
public interface CountComplaintByTechnicianFacadeLocal {

    void create(CountComplaintByTechnician countComplaintByTechnician);

    void edit(CountComplaintByTechnician countComplaintByTechnician);

    void remove(CountComplaintByTechnician countComplaintByTechnician);

    CountComplaintByTechnician find(Object id);

    List<CountComplaintByTechnician> findAll();

    List<CountComplaintByTechnician> findRange(int[] range);

    int count();

}
