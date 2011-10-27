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
@Table(name = "tbFAQs")
@NamedQueries({
    @NamedQuery(name = "TbFAQs.findAll", query = "SELECT t FROM TbFAQs t"),
    @NamedQuery(name = "TbFAQs.findByfaqId", query = "SELECT t FROM TbFAQs t WHERE t.faqId = :faqId"),
    @NamedQuery(name = "TbFAQs.findByCreateDate", query = "SELECT t FROM TbFAQs t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbFAQs.findByUpdateDate", query = "SELECT t FROM TbFAQs t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbFAQs.findByStatus", query = "SELECT t FROM TbFAQs t WHERE t.status = :status")})
public class TbFAQs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FAQ_Id")
    private String faqId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Content_Question")
    private String contentQuestion;
    @Lob
    @Column(name = "Short_Answer")
    private String shortAnswer;
    @Lob
    @Column(name = "Long_Answer")
    private String longAnswer;
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
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id")
    @ManyToOne(optional = false)
    private TbCategories tbCategories;

    public TbFAQs() {
    }

    public TbFAQs(String faqId) {
        this.faqId = faqId;
    }

    public TbFAQs(String faqId, String contentQuestion, Date createDate, Date updateDate, String status) {
        this.faqId = faqId;
        this.contentQuestion = contentQuestion;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public String getfaqId() {
        return faqId;
    }

    public void setfaqId(String faqId) {
        this.faqId = faqId;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public void setContentQuestion(String contentQuestion) {
        this.contentQuestion = contentQuestion;
    }

    public String getShortAnswer() {
        return shortAnswer;
    }

    public void setShortAnswer(String shortAnswer) {
        this.shortAnswer = shortAnswer;
    }

    public String getLongAnswer() {
        return longAnswer;
    }

    public void setLongAnswer(String longAnswer) {
        this.longAnswer = longAnswer;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash += (faqId != null ? faqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFAQs)) {
            return false;
        }
        TbFAQs other = (TbFAQs) object;
        if ((this.faqId == null && other.faqId != null) || (this.faqId != null && !this.faqId.equals(other.faqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbFAQs[faqId=" + faqId + "]";
    }

}
