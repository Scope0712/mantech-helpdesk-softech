/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.bean.ManagedBean;
import entity.TbCategories;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import sessionbean.TbCategoriesFacade;
import sessionbean.TbCategoriesFacadeLocal;

/**
 *
 * @author DELL
 */
@ManagedBean(name = "CategoryBean")
@SessionScoped
public class CategoryBean {

    @EJB
    private TbCategoriesFacadeLocal TbCategoriesFacade;
    private Collection<TbCategories> listCategories;
    private TbCategories myCategory;

    public TbCategories shareCategory = new TbCategories();
    /** Creates a new instance of CategoryMB */
    public CategoryBean() {
        myCategory = getInstanseCategory();
    }

    public TbCategoriesFacadeLocal getInstanse() {
        if (null == TbCategoriesFacade) {
            TbCategoriesFacade = new TbCategoriesFacade();
        }
        return TbCategoriesFacade;
    }

    public TbCategories getInstanseCategory() {
        if (null == myCategory) {
            myCategory = new TbCategories();
        }
        return myCategory;
    }

    public void create(ActionEvent event) {
        getInstanse().create(getMyCategory());
    }

    public void update(ActionEvent event) {
        getInstanse().edit(getMyCategory());
    }

    public void delete(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("categoryId_delete");
        getInstanse().remove(getInstanse().find(para.getValue().toString()));
    }

    public void select(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("categoryId_view");
        setMyCategory(getInstanse().find(para.getValue().toString()));
    }

    public TbCategories callCatetory(String categoryid) {
        return getInstanse().find(categoryid);
    }

    /**
     * @return the listCategories
     */
    public Collection<TbCategories> getListCategories() {
        return getInstanse().findAll();
    }

    /**
     * @param listCategories the listCategories to set
     */
    public void setListCategories(Collection<TbCategories> listCategories) {
        this.listCategories = getInstanse().findAll();
    }

    /**
     * @return the myCategory
     */
    public TbCategories getMyCategory() {
        return getInstanseCategory();
    }

    /**
     * @param myCategory the myCategory to set
     */
    public void setMyCategory(TbCategories myCategory) {
        this.myCategory = myCategory;
    }

}
