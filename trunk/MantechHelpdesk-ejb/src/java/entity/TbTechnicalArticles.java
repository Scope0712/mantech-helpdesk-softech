/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbTechnicalArticles")
@NamedQueries({
    @NamedQuery(name = "TbTechnicalArticles.findAll", query = "SELECT t FROM TbTechnicalArticles t"),
    @NamedQuery(name = "TbTechnicalArticles.findByArticleId", query = "SELECT t FROM TbTechnicalArticles t WHERE t.articleId = :articleId"),
    @NamedQuery(name = "TbTechnicalArticles.findByCreateDate", query = "SELECT t FROM TbTechnicalArticles t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbTechnicalArticles.findByUpdateDate", query = "SELECT t FROM TbTechnicalArticles t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbTechnicalArticles.findByViewNo", query = "SELECT t FROM TbTechnicalArticles t WHERE t.viewNo = :viewNo"),
    @NamedQuery(name = "TbTechnicalArticles.findByVoteNo", query = "SELECT t FROM TbTechnicalArticles t WHERE t.voteNo = :voteNo"),
    @NamedQuery(name = "TbTechnicalArticles.findByStatus", query = "SELECT t FROM TbTechnicalArticles t WHERE t.status = :status")})
public class TbTechnicalArticles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Article_Id")
    private String articleId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Title")
    private String title;
    @Lob
    @Column(name = "Short_Content")
    private String shortContent;
    @Lob
    @Column(name = "Long_Content")
    private String longContent;
    @Lob
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @Column(name = "Create_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "Update_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Basic(optional = false)
    @Column(name = "View_No")
    private int viewNo;
    @Basic(optional = false)
    @Column(name = "Vote_No")
    private int voteNo;
    @Basic(optional = false)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "Staff_Id", referencedColumnName = "Staff_Id")
    @ManyToOne(optional = false)
    private TbStaffs tbStaffs;
    @JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id")
    @ManyToOne(optional = false)
    private TbCategories tbCategories;

    public TbTechnicalArticles() {
    }

    public TbTechnicalArticles(String articleId) {
        this.articleId = articleId;
    }

    public TbTechnicalArticles(String articleId, String title, Date createDate, Date updateDate, int viewNo, int voteNo, String status) {
        this.articleId = articleId;
        this.title = title;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.viewNo = viewNo;
        this.voteNo = voteNo;
        this.status = status;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getLongContent() {
        return longContent;
    }

    public void setLongContent(String longContent) {
        this.longContent = longContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getViewNo() {
        return viewNo;
    }

    public void setViewNo(int viewNo) {
        this.viewNo = viewNo;
    }

    public int getVoteNo() {
        return voteNo;
    }

    public void setVoteNo(int voteNo) {
        this.voteNo = voteNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TbStaffs getTbStaffs() {
        return tbStaffs;
    }

    public void setTbStaffs(TbStaffs tbStaffs) {
        this.tbStaffs = tbStaffs;
    }

    public TbCategories getTbCategories() {
        return tbCategories;
    }

    public void setTbCategories(TbCategories tbCategories) {
        this.tbCategories = tbCategories;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleId != null ? articleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTechnicalArticles)) {
            return false;
        }
        TbTechnicalArticles other = (TbTechnicalArticles) object;
        if ((this.articleId == null && other.articleId != null) || (this.articleId != null && !this.articleId.equals(other.articleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbTechnicalArticles[articleId=" + articleId + "]";
    }

}
