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
@Table(name = "tbSolutions")
@NamedQueries({
    @NamedQuery(name = "TbSolutions.findAll", query = "SELECT t FROM TbSolutions t"),
    @NamedQuery(name = "TbSolutions.findBySolutionId", query = "SELECT t FROM TbSolutions t WHERE t.solutionId = :solutionId"),
    @NamedQuery(name = "TbSolutions.findByCreateDate", query = "SELECT t FROM TbSolutions t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbSolutions.findByUpdateDate", query = "SELECT t FROM TbSolutions t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbSolutions.findByViewNo", query = "SELECT t FROM TbSolutions t WHERE t.viewNo = :viewNo"),
    @NamedQuery(name = "TbSolutions.findByVoteNo", query = "SELECT t FROM TbSolutions t WHERE t.voteNo = :voteNo"),
    @NamedQuery(name = "TbSolutions.findByStatus", query = "SELECT t FROM TbSolutions t WHERE t.status = :status")})
public class TbSolutions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Solution_Id")
    private String solutionId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Problem_Content")
    private String problemContent;
    @Lob
    @Column(name = "Short_Resolve")
    private String shortResolve;
    @Lob
    @Column(name = "Long_Resolve")
    private String longResolve;
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

    public TbSolutions() {
    }

    public TbSolutions(String solutionId) {
        this.solutionId = solutionId;
    }

    public TbSolutions(String solutionId, String problemContent, Date createDate, Date updateDate, int viewNo, int voteNo, String status) {
        this.solutionId = solutionId;
        this.problemContent = problemContent;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.viewNo = viewNo;
        this.voteNo = voteNo;
        this.status = status;
    }

    public String getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    public String getShortResolve() {
        return shortResolve;
    }

    public void setShortResolve(String shortResolve) {
        this.shortResolve = shortResolve;
    }

    public String getLongResolve() {
        return longResolve;
    }

    public void setLongResolve(String longResolve) {
        this.longResolve = longResolve;
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
        hash += (solutionId != null ? solutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSolutions)) {
            return false;
        }
        TbSolutions other = (TbSolutions) object;
        if ((this.solutionId == null && other.solutionId != null) || (this.solutionId != null && !this.solutionId.equals(other.solutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbSolutions[solutionId=" + solutionId + "]";
    }

}
