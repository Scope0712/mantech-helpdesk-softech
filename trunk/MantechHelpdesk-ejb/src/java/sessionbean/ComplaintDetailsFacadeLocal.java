/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.ComplaintDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THANH
 */
@Local
public interface ComplaintDetailsFacadeLocal {

    void create(ComplaintDetails complaintDetails);

    void edit(ComplaintDetails complaintDetails);

    void remove(ComplaintDetails complaintDetails);

    ComplaintDetails find(Object id);

    List<ComplaintDetails> findAll();

    List<ComplaintDetails> findRange(int[] range);

    int count();

    public java.util.List<entity.ComplaintDetails> findByEmployeeID(java.lang.String id);

    public java.util.List<entity.ComplaintDetails> findComplaintStatus(java.lang.String id, java.lang.String status);

}
