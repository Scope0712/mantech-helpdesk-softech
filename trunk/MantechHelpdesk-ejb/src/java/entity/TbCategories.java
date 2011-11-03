/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbCategories")
@NamedQueries({
    @NamedQuery(name = "TbCategories.findAll", query = "SELECT t FROM TbCategories t"),
    @NamedQuery(name = "TbCategories.findByCategoryId", query = "SELECT t FROM TbCategories t WHERE t.categoryId = :categoryId"),
    @NamedQuery(name = "TbCategories.findByCategoryName", query = "SELECT t FROM TbCategories t WHERE t.categoryName = :categoryName"),
    @NamedQuery(name = "TbCategories.findByPriority", query = "SELECT t FROM TbCategories t WHERE t.priority = :priority")})
public class TbCategories implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Category_Id")
    private String categoryId;
    @Basic(optional = false)
    @Column(name = "Category_Name")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "Priority")
    private int priority;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCategories")
    private Collection<TbSolutions> tbSolutionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCategories")
    private Collection<TbTechnicalArticles> tbTechnicalArticlesCollection;

    public TbCategories() {
    }

    public TbCategories(String categoryId) {
        this.categoryId = categoryId;
    }

    public TbCategories(String categoryId, String categoryName, int priority) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.priority = priority;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Collection<TbSolutions> getTbSolutionsCollection() {
        return tbSolutionsCollection;
    }

    public void setTbSolutionsCollection(Collection<TbSolutions> tbSolutionsCollection) {
        this.tbSolutionsCollection = tbSolutionsCollection;
    }

    public Collection<TbTechnicalArticles> getTbTechnicalArticlesCollection() {
        return tbTechnicalArticlesCollection;
    }

    public void setTbTechnicalArticlesCollection(Collection<TbTechnicalArticles> tbTechnicalArticlesCollection) {
        this.tbTechnicalArticlesCollection = tbTechnicalArticlesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCategories)) {
            return false;
        }
        TbCategories other = (TbCategories) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbCategories[categoryId=" + categoryId + "]";
    }

}
