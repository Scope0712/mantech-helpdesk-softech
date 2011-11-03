/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbCategories;
import javax.faces.bean.ManagedBean;
import entity.TbFAQs;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbFAQsFacade;
import sessionbean.TbFAQsFacadeLocal;

/**
 *
 * @author DELL
 */
@ManagedBean(name = "FAQBean")
@SessionScoped
public class FAQBean {

    @EJB
    private TbFAQsFacadeLocal TbFAQsFacade;
    private TbCategoriesFacadeLocal TbCategoriesFacade;
    private Collection<TbFAQs> listFAQs;
    private TbFAQs myFAQ;
    private TbCategories myCategory;
    // Implentment all methods

    public FAQBean() {
        myFAQ = getInstanseFAQ();
        myCategory = new TbCategories();
    }

    public TbFAQsFacadeLocal getInstanse() {
        if (null == TbFAQsFacade) {
            TbFAQsFacade = new TbFAQsFacade();
        }
        return TbFAQsFacade;
    }

    public TbFAQs getInstanseFAQ() {
        if (null == myFAQ) {
            myFAQ = new TbFAQs();
        }
        return myFAQ;
    }

    public void createFAQ(ActionEvent event) {
        myFAQ.setfaqId("dasda");
        myFAQ.setTbCategories(myCategory);
        getInstanse().create(myFAQ);
    }

    public void updateFAQ(ActionEvent event) {
        myFAQ.setTbCategories(myCategory);
        getInstanse().edit(myFAQ);
    }

    public void deleteFAQ(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("faqId_delete");
        getInstanse().remove(getInstanse().find(para.getValue().toString()));
    }

    public void selectFAQs(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("faqId_view");
        setMyFAQ(getInstanse().find(para.getValue().toString()));
    }

    public void selectFAQById(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("faqId_edit");
        setMyFAQ(getInstanse().find(para.getValue().toString()));
    }

    public void searchFAQ(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("search");
        setListFAQs(getInstanse().findFAQById(para.getValue().toString()));
    }

    /**
     * @return the listFAQs
     */
    public Collection<TbFAQs> getListFAQs() {
        return getInstanse().findAll();
    }

    /**
     * @param listFAQs the listFAQs to set
     */
    public void setListFAQs(Collection<TbFAQs> listFAQs) {
        this.listFAQs = getInstanse().findAll();
    }

    /**
     * @return the myFAQ
     */
    public TbFAQs getMyFAQ() {
        return getInstanseFAQ();
    }

    /**
     * @param myFAQ the myFAQ to set
     */
    public void setMyFAQ(TbFAQs myFAQ) {
        this.myFAQ = myFAQ;
    }

    /**
     * @return the myCategory
     */
    public TbCategories getMyCategory() {
        return myCategory;
    }

    /**
     * @param myCategory the myCategory to set
     */
    public void setMyCategory(TbCategories myCategory) {
        this.myCategory = myCategory;
    }
}
