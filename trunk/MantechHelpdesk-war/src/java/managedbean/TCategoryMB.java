/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbean;

import entity.TbCategories;
import javax.ejb.EJB;
import sessionbean.TbCategoriesFacadeLocal;


/**
 *
 * @author tuyenbui
 */
public class TCategoryMB {
    @EJB
    private TbCategoriesFacadeLocal tbCategoriesFacade;

    /** Creates a new instance of TCategoryMB */
    public TCategoryMB() {
    }

    public TbCategories findCategory(String categoryId){
        return tbCategoriesFacade.find(categoryId);
    }

}
