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
    private Collection<TbSolutions> listAllSolutions;
    private Collection<TbSolutions> listSearchSolutions;
    private TbSolutions myTbSolutions;
    private TbSolutions newTbSolution;
    private TbCategories myCategory;
    private String search = "";
    /** Creates a new instance of SolutionMB */
    public SolutionMB() {
        listSolutions = new ArrayList<TbSolutions>();
        listAllSolutions = new ArrayList<TbSolutions>();
        listSearchSolutions = new ArrayList<TbSolutions>();
        myCategory = new TbCategories();
        myTbSolutions = new TbSolutions();
        newTbSolution = new TbSolutions();
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
        setMyTbSolutions(getInstanseSolutionFacadeLocal().find(para.getValue().toString()));
    }

    public void editSolution(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("solutionId_edit");
        setMyTbSolutions(getInstanseSolutionFacadeLocal().find(para.getValue().toString()));
    }

    public void searchListSolutions(ActionEvent event) {
        listSearchSolutions.clear();
        setListSearchSolutions(getInstanseSolutionFacadeLocal().searchListSolutions(getSearch()));
        setSearch("");
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

    /**
     * @return the listAllSolutions
     */
    public Collection<TbSolutions> getListAllSolutions() {
        return listAllSolutions = getInstanseSolutionFacadeLocal().findAll();
    }

    /**
     * @param listAllSolutions the listAllSolutions to set
     */
    public void setListAllSolutions(Collection<TbSolutions> listAllSolutions) {
        this.listAllSolutions = listAllSolutions;
    }

    /**
     * @return the listSearchSolutions
     */
    public Collection<TbSolutions> getListSearchSolutions() {
        return listSearchSolutions;
    }

    /**
     * @param listSearchSolutions the listSearchSolutions to set
     */
    public void setListSearchSolutions(Collection<TbSolutions> listSearchSolutions) {
        this.listSearchSolutions = listSearchSolutions;
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

    /**
     * @return the newTbSolution
     */
    public TbSolutions getNewTbSolution() {
        return newTbSolution;
    }

    /**
     * @param newTbSolution the newTbSolution to set
     */
    public void setNewTbSolution(TbSolutions newTbSolution) {
        this.newTbSolution = newTbSolution;
    }
}
