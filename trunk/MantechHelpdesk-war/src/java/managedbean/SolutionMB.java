/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbCategories;
import entity.TbSolutions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import sessionbean.TbCategoriesFacade;
import sessionbean.TbCategoriesFacadeLocal;
import sessionbean.TbSolutionsFacade;
import sessionbean.TbSolutionsFacadeLocal;

/**
 *
 * @author DELL
 */
@ManagedBean(name = "SolutionMB")
@SessionScoped
public class SolutionMB {

    @EJB
    private TbSolutionsFacadeLocal TbSolutionsFacade;
    private TbCategoriesFacadeLocal TbCategories;
    private Collection<TbSolutions> listSolutions;
    private TbSolutions myTbSolutions;
    private TbCategories myCategory;
    
    /** Creates a new instance of SolutionMB */
    public SolutionMB() {
        listSolutions = new ArrayList<TbSolutions>();
        myCategory = new TbCategories();
        myTbSolutions = new TbSolutions();
    }

    public TbSolutionsFacadeLocal getInstanseSolutionFacadeLocal() {
        if (null == TbSolutionsFacade) {
            TbSolutionsFacade = new TbSolutionsFacade();
        }
        return TbSolutionsFacade;
    }

    public TbCategoriesFacadeLocal getInstanseCategoriesFacadeLocal() {
        if (null == TbCategories) {
            TbCategories = new TbCategoriesFacade();
        }
        return TbCategories;
    }
    
    public void create(ActionEvent event) {
        myTbSolutions.setTbCategories(myCategory);
        getInstanseSolutionFacadeLocal().create(myTbSolutions);
    }

    public void update(ActionEvent event) {
        myTbSolutions.setUpdateDate(new Date());
        myTbSolutions.setTbCategories(myCategory);
        getInstanseSolutionFacadeLocal().edit(myTbSolutions);
    }

    public void delete(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("solutionId_delete");
        getInstanseSolutionFacadeLocal().remove(getInstanseSolutionFacadeLocal().find(para.getValue().toString()));
    }

    public void select(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("solutionId_view");
        myTbSolutions = getInstanseSolutionFacadeLocal().find(para.getValue().toString());
        getInstanseSolutionFacadeLocal().edit(myTbSolutions);
        setMyTbSolutions(myTbSolutions);
    }

    public void editSolution(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("solutionId_edit");
        setMyTbSolutions(getInstanseSolutionFacadeLocal().find(para.getValue().toString()));
    }

    /**
     * @return the listSolutions
     */
    public Collection<TbSolutions> getListSolutions() {
        return listSolutions = getInstanseSolutionFacadeLocal().findAllSolutions();
    }

    /**
     * @param listSolutions the listSolutions to set
     */
    public void setListSolutions(Collection<TbSolutions> listSolutions) {
        this.listSolutions = listSolutions;
    }

    /**
     * @return the myTbSolutions
     */
    public TbSolutions getMyTbSolutions() {
        return myTbSolutions;
    }

    /**
     * @param myTbSolutions the myTbSolutions to set
     */
    public void setMyTbSolutions(TbSolutions myTbSolutions) {
        this.myTbSolutions = myTbSolutions;
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
