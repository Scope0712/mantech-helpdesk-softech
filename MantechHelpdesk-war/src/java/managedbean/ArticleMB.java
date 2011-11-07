/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.TbCategories;
import entity.TbTechnicalArticles;
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
import sessionbean.TbTechnicalArticlesFacade;
import sessionbean.TbTechnicalArticlesFacadeLocal;

/**
 *
 * @author DELL
 */
@ManagedBean(name = "ArticleMB")
@SessionScoped
public class ArticleMB {

    public static ArticleMB instanceArticle;

    /**
     * @return the instanceArticle
     */
    public static ArticleMB getInstanceArticle() {
        if(null == instanceArticle){
            instanceArticle = new ArticleMB();
        }
        return instanceArticle;
    }
    @EJB
    private TbTechnicalArticlesFacadeLocal TbTechnicalArticles;
    private TbCategoriesFacadeLocal TbCategories;
    private Collection<TbTechnicalArticles> listArticle;
    private Collection<TbTechnicalArticles> listArticleSearch = new ArrayList<TbTechnicalArticles>();
    private Collection<TbTechnicalArticles> listNewArticle = new ArrayList<TbTechnicalArticles>();
    private Collection<TbTechnicalArticles> listTopArticle = new ArrayList<TbTechnicalArticles>();
    private Collection<TbTechnicalArticles> listSortArticleByCategory = new ArrayList<TbTechnicalArticles>();
    private TbTechnicalArticles myTbTechnicalArticle;
    private TbCategories myCategory;

    private String strSearch = "";
    private String category = "";
    
    /** Creates a new instance of ArticleMB */
    public ArticleMB() {
        myTbTechnicalArticle = new TbTechnicalArticles();
        myCategory = new TbCategories();
    }

    public TbTechnicalArticlesFacadeLocal getInstanseArticlesFacadeLocal() {
        if (null == TbTechnicalArticles) {
            TbTechnicalArticles = new TbTechnicalArticlesFacade();
        }
        return TbTechnicalArticles;
    }

    public TbCategoriesFacadeLocal getInstanseCategoriesFacadeLocal() {
        if (null == TbCategories) {
            TbCategories = new TbCategoriesFacade();
        }
        return TbCategories;
    }

    /**
     * @return the listArticle
     */
    public Collection<TbTechnicalArticles> getListArticle() {
        return getInstanseArticlesFacadeLocal().findAllArticles();
    }

    /**
     * @param listArticle the listArticle to set
     */
    public void setListArticle(Collection<TbTechnicalArticles> listArticle) {
        this.listArticle = getInstanseArticlesFacadeLocal().findAllArticles();
    }

    /**
     * @return the myTbTechnicalArticle
     */
    public TbTechnicalArticles getMyTbTechnicalArticle() {
        return myTbTechnicalArticle;
    }

    /**
     * @param myTbTechnicalArticle the myTbTechnicalArticle to set
     */
    public void setMyTbTechnicalArticle(TbTechnicalArticles myTbTechnicalArticle) {
        this.myTbTechnicalArticle = myTbTechnicalArticle;
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

    public void create(ActionEvent event) {
        myTbTechnicalArticle.setTbCategories(myCategory);
        getInstanseArticlesFacadeLocal().create(myTbTechnicalArticle);
    }

    public void update(ActionEvent event) {
        myTbTechnicalArticle.setUpdateDate(new Date());
        myTbTechnicalArticle.setTbCategories(myCategory);
        getInstanseArticlesFacadeLocal().edit(myTbTechnicalArticle);
    }

    public void delete(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("articleId_delete");
        getInstanseArticlesFacadeLocal().remove(getInstanseArticlesFacadeLocal().find(para.getValue().toString()));
    }

    public void select(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("articleId_view");
        myTbTechnicalArticle = getInstanseArticlesFacadeLocal().find(para.getValue().toString());
        int new_viewno = myTbTechnicalArticle.getViewNo() + 1;
        myTbTechnicalArticle.setViewNo(new_viewno);
        getInstanseArticlesFacadeLocal().edit(myTbTechnicalArticle);
        setMyTbTechnicalArticle(myTbTechnicalArticle);
    }

    public void editArticle(ActionEvent event) {
        UIParameter para = (UIParameter) event.getComponent().findComponent("articleId_edit");
        setMyTbTechnicalArticle(getInstanseArticlesFacadeLocal().find(para.getValue().toString()));
    }

    public void searchArticle(ActionEvent event){
        listArticleSearch.clear();
        setListArticleSearch(getInstanseArticlesFacadeLocal().findAllBySearch(strSearch));
    }

    public void selectTopArticle(){
        listTopArticle.clear();
        setListTopArticle(getInstanseArticlesFacadeLocal().selectTopArticles());
    }

    public void selectNewArticle(){
        listNewArticle.clear();
        setListNewArticle(getInstanseArticlesFacadeLocal().selectNewArticles());
    }

    public void sortArticlesByCategory(ActionEvent event){
        listSortArticleByCategory.clear();
        UIParameter para = (UIParameter) event.getComponent().findComponent("categoryId");
        setListSortArticleByCategory(getInstanseArticlesFacadeLocal().sortArticlesByCategory(para.getValue().toString()));
    }
    
    /**
     * @return the strSearch
     */
    public String getStrSearch() {
        return strSearch;
    }

    /**
     * @param strSearch the strSearch to set
     */
    public void setStrSearch(String strSearch) {
        this.strSearch = strSearch;
    }

    /**
     * @return the listArticleSearch
     */
    public Collection<TbTechnicalArticles> getListArticleSearch() {
        return listArticleSearch;
    }

    /**
     * @param listArticleSearch the listArticleSearch to set
     */
    public void setListArticleSearch(Collection<TbTechnicalArticles> listArticleSearch) {
        this.listArticleSearch = listArticleSearch;
    }

    /**
     * @return the listNewArticle
     */
    public Collection<TbTechnicalArticles> getListNewArticle() {
        return listNewArticle = getInstanseArticlesFacadeLocal().selectNewArticles();
    }

    /**
     * @param listNewArticle the listNewArticle to set
     */
    public void setListNewArticle(Collection<TbTechnicalArticles> listNewArticle) {
        this.listNewArticle = listNewArticle;
    }

    /**
     * @return the listTopArticle
     */
    public Collection<TbTechnicalArticles> getListTopArticle() {
        return listTopArticle = getInstanseArticlesFacadeLocal().selectTopArticles();
    }

    /**
     * @param listTopArticle the listTopArticle to set
     */
    public void setListTopArticle(Collection<TbTechnicalArticles> listTopArticle) {
        this.listTopArticle = listTopArticle;
    }

    /**
     * @return the listSortArticleByCategory
     */
    public Collection<TbTechnicalArticles> getListSortArticleByCategory() {
        return listSortArticleByCategory;
    }

    /**
     * @param listSortArticleByCategory the listSortArticleByCategory to set
     */
    public void setListSortArticleByCategory(Collection<TbTechnicalArticles> listSortArticleByCategory) {
        this.listSortArticleByCategory = listSortArticleByCategory;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
