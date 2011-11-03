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
    @NamedQuery(name = "TbTechnicalArticles.findByRating", query = "SELECT t FROM TbTechnicalArticles t WHERE t.rating = :rating"),
    @NamedQuery(name = "TbTechnicalArticles.findByRateTotal", query = "SELECT t FROM TbTechnicalArticles t WHERE t.rateTotal = :rateTotal"),
    @NamedQuery(name = "TbTechnicalArticles.findByRate", query = "SELECT t FROM TbTechnicalArticles t WHERE t.rate = :rate"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarOne", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starOne = :starOne"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarTwo", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starTwo = :starTwo"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarThree", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starThree = :starThree"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarFour", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starFour = :starFour"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarFive", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starFive = :starFive"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarSix", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starSix = :starSix"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarSeven", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starSeven = :starSeven"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarEight", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starEight = :starEight"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarNine", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starNine = :starNine"),
    @NamedQuery(name = "TbTechnicalArticles.findByStarTen", query = "SELECT t FROM TbTechnicalArticles t WHERE t.starTen = :starTen"),
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
    @Column(name = "Detail_Content")
    private String detailContent;
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
    @Column(name = "Rating")
    private int rating;
    @Basic(optional = false)
    @Column(name = "Rate_Total")
    private int rateTotal;
    @Basic(optional = false)
    @Column(name = "Rate")
    private int rate;
    @Basic(optional = false)
    @Column(name = "Star_One")
    private int starOne;
    @Basic(optional = false)
    @Column(name = "Star_Two")
    private int starTwo;
    @Basic(optional = false)
    @Column(name = "Star_Three")
    private int starThree;
    @Basic(optional = false)
    @Column(name = "Star_Four")
    private int starFour;
    @Basic(optional = false)
    @Column(name = "Star_Five")
    private int starFive;
    @Basic(optional = false)
    @Column(name = "Star_Six")
    private int starSix;
    @Basic(optional = false)
    @Column(name = "Star_Seven")
    private int starSeven;
    @Basic(optional = false)
    @Column(name = "Star_Eight")
    private int starEight;
    @Basic(optional = false)
    @Column(name = "Star_Nine")
    private int starNine;
    @Basic(optional = false)
    @Column(name = "Star_Ten")
    private int starTen;
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

    public TbTechnicalArticles(String articleId, String title, Date createDate, Date updateDate, int viewNo, int rating, int rateTotal, int rate, int starOne, int starTwo, int starThree, int starFour, int starFive, int starSix, int starSeven, int starEight, int starNine, int starTen, String status) {
        this.articleId = articleId;
        this.title = title;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.viewNo = viewNo;
        this.rating = rating;
        this.rateTotal = rateTotal;
        this.rate = rate;
        this.starOne = starOne;
        this.starTwo = starTwo;
        this.starThree = starThree;
        this.starFour = starFour;
        this.starFive = starFive;
        this.starSix = starSix;
        this.starSeven = starSeven;
        this.starEight = starEight;
        this.starNine = starNine;
        this.starTen = starTen;
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

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRateTotal() {
        return rateTotal;
    }

    public void setRateTotal(int rateTotal) {
        this.rateTotal = rateTotal;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getStarOne() {
        return starOne;
    }

    public void setStarOne(int starOne) {
        this.starOne = starOne;
    }

    public int getStarTwo() {
        return starTwo;
    }

    public void setStarTwo(int starTwo) {
        this.starTwo = starTwo;
    }

    public int getStarThree() {
        return starThree;
    }

    public void setStarThree(int starThree) {
        this.starThree = starThree;
    }

    public int getStarFour() {
        return starFour;
    }

    public void setStarFour(int starFour) {
        this.starFour = starFour;
    }

    public int getStarFive() {
        return starFive;
    }

    public void setStarFive(int starFive) {
        this.starFive = starFive;
    }

    public int getStarSix() {
        return starSix;
    }

    public void setStarSix(int starSix) {
        this.starSix = starSix;
    }

    public int getStarSeven() {
        return starSeven;
    }

    public void setStarSeven(int starSeven) {
        this.starSeven = starSeven;
    }

    public int getStarEight() {
        return starEight;
    }

    public void setStarEight(int starEight) {
        this.starEight = starEight;
    }

    public int getStarNine() {
        return starNine;
    }

    public void setStarNine(int starNine) {
        this.starNine = starNine;
    }

    public int getStarTen() {
        return starTen;
    }

    public void setStarTen(int starTen) {
        this.starTen = starTen;
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
