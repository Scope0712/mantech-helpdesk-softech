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
import javax.persistence.Lob;
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
    @NamedQuery(name = "TbFAQs.findByFaqId", query = "SELECT t FROM TbFAQs t WHERE t.faqId = :faqId"),
    @NamedQuery(name = "TbFAQs.findByCreateDate", query = "SELECT t FROM TbFAQs t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbFAQs.findByUpdateDate", query = "SELECT t FROM TbFAQs t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbFAQs.findByStatus", query = "SELECT t FROM TbFAQs t WHERE t.status = :status")})
public class TbFAQs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Faq_Id")
    private String faqId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Content_Question")
    private String contentQuestion;
    @Lob
    @Column(name = "Detail_Answer")
    private String detailAnswer;
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

    public String getFaqId() {
        return faqId;
    }

    public void setFaqId(String faqId) {
        this.faqId = faqId;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public void setContentQuestion(String contentQuestion) {
        this.contentQuestion = contentQuestion;
    }

    public String getDetailAnswer() {
        return detailAnswer;
    }

    public void setDetailAnswer(String detailAnswer) {
        this.detailAnswer = detailAnswer;
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
