/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbean;

import entity.TbDepartments;
import entity.TbStaffs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuyenbui
 */
@Stateless
public class TbStaffsFacade extends AbstractFacade<TbStaffs> implements TbStaffsFacadeLocal {
    @PersistenceContext(unitName = "MantechHelpdesk-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TbStaffsFacade() {
        super(TbStaffs.class);
    }

    @Override
    public List<TbStaffs> searchStaffFromDepart(TbDepartments depart) {
      //  System.out.println(depart.getDepartmentName());
        try{
        return (List<TbStaffs>) em.createQuery("SELECT t FROM TbStaffs t WHERE t.tbDepartments= :tbDepartments").setParameter("tbDepartments", depart).getResultList();
        }
        catch(Exception ex){
            return null;
        }
    }
 //   @NamedQuery(name = "TbStaffs.searchStaffFromDepart", query = "SELECT t FROM TbStaffs t WHERE t.tbDepartments= :tbDepartments")

}
