/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbCategories;
import javax.faces.bean.ManagedBean;
import entity.TbFAQs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import sessionbean.TbCategoriesFacade;
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
    private TbFAQsFacadeLocal TbFAQs;
    private TbCategoriesFacadeLocal TbCategories;
    private Collection<TbFAQs> listFAQs;
    private Collection<TbFAQs> listAllFAQs;
    private Collection<TbFAQs> listSearchFAQs;
    private TbCategories myCategory;
    private TbFAQs myFAQ;
    private TbFAQs newFAQ;

    private String search = "";
    // Implentment all methods

    public FAQBean() {
        listSearchFAQs = new ArrayList<TbFAQs>();
        listFAQs = new ArrayList<TbFAQs>();
        listAllFAQs = new ArrayList<TbFAQs>();
        myFAQ = new TbFAQs();
        myCategory = new TbCategories();
        newFAQ = new TbFAQs();
    }

    public TbFAQsFacadeLocal getInstanseFAQsFacadeLocal() {
        if (null == TbFAQs) {
            TbFAQs = new TbFAQsFacade();
        }
        return TbFAQs;
    }

    public TbCategoriesFacadeLocal getInstanseCategoriesFacadeLocal() {
        if (null == TbCategories) {
            TbCategories = new TbCategoriesFacade();
        }
        return TbCategories;
    }

    public void create(ActionEvent event) {
        if(null == getNewFAQ()){
            // Check TbFAQ object
            newFAQ = new TbFAQs();
        }
        TbCategories cateroty = new TbCategories(myCategory.getCategoryId(),myCategory.getCategoryName(),myCategory.getPriority());
        newFAQ.setFaqId("id");
        newFAQ.setCreateDate(new Date());
        newFAQ.setUpdateDate(new Date());
        newFAQ.setTbCategories(cateroty);
        getInstanseFAQsFacadeLocal().create(newFAQ);
        newFAQ = new TbFAQs();
    }

    public void update(ActionEvent event) {
        TbCategories cateroty = new TbCategories(myCategory.getCategoryId(),myCategory.getCategoryName(),myCategory.getPriority());
        myFAQ.setTbCategories(cateroty);
        myFAQ.setUpdateDate(new Date());
        getInstanseFAQsFacadeLocal().edit(myFAQ);
        //System.out.println(" Thanh cong ");
    }

    public void delete(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("faqId_delete");
        getInstanseFAQsFacadeLocal().remove(getInstanseFAQsFacadeLocal().find(para.getValue().toString()));
    }

    public void selectViewFAQ(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("faqId_view");
        setMyFAQ(getInstanseFAQsFacadeLocal().find(para.getValue().toString()));
    }

    public void selectEditFAQ(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("faqId_edit");
        setMyFAQ(getInstanseFAQsFacadeLocal().find(para.getValue().toString()));
    }

    public void searchListFAQs(ActionEvent event) {
        listSearchFAQs.clear();
        setListSearchFAQs(getInstanseFAQsFacadeLocal().searchListFAQs(search));
    }

    /**
     * @return the listFAQs
     */
    public Collection<TbFAQs> getListFAQs() {
        return listFAQs = getInstanseFAQsFacadeLocal().findAllFAQs();
    }

    /**
     * @param listFAQs the listFAQs to set
     */
    public void setListFAQs(Collection<TbFAQs> listFAQs) {
        this.listFAQs = listFAQs;
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

    /**
     * @return the myFAQ
     */
    public TbFAQs getMyFAQ() {
        return myFAQ;
    }

    /**
     * @param myFAQ the myFAQ to set
     */
    public void setMyFAQ(TbFAQs myFAQ) {
        this.myFAQ = myFAQ;
    }

    /**
     * @return the listAllFAQs
     */
    public Collection<TbFAQs> getListAllFAQs() {
        return listAllFAQs = getInstanseFAQsFacadeLocal().findAll();
    }

    /**
     * @param listAllFAQs the listAllFAQs to set
     */
    public void setListAllFAQs(Collection<TbFAQs> listAllFAQs) {
        this.listAllFAQs = listAllFAQs;
    }

    /**
     * @return the newFAQ
     */
    public TbFAQs getNewFAQ() {
        return newFAQ;
    }

    /**
     * @param newFAQ the newFAQ to set
     */
    public void setNewFAQ(TbFAQs newFAQ) {
        this.newFAQ = newFAQ;
    }

    /**
     * @return the listSearchFAQs
     */
    public Collection<TbFAQs> getListSearchFAQs() {
        return listSearchFAQs;
    }

    /**
     * @param listSearchFAQs the listSearchFAQs to set
     */
    public void setListSearchFAQs(Collection<TbFAQs> listSearchFAQs) {
        this.listSearchFAQs = listSearchFAQs;
    }

    /**
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(String search) {
        this.search = search;
    }
}
