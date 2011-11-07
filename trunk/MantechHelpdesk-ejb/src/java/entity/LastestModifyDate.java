/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "LastestModifyDate", catalog = "MantechHelpdesk", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "LastestModifyDate.findAll", query = "SELECT l FROM LastestModifyDate l"),
    @NamedQuery(name = "LastestModifyDate.findByLodgingDate", query = "SELECT l FROM LastestModifyDate l WHERE l.lodgingDate = :lodgingDate"),
    @NamedQuery(name = "LastestModifyDate.findByLatestModifyDate", query = "SELECT l FROM LastestModifyDate l WHERE l.latestModifyDate = :latestModifyDate")})
public class LastestModifyDate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Lodging_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @Id
    private Date lodgingDate;
    @Column(name = "Latest_Modify_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latestModifyDate;
    @JoinColumn(name = "Complaint_Id", referencedColumnName = "Complaint_Id", nullable = false)
    @ManyToOne(optional = false)
    private TbComplaints tbComplaints;

    public LastestModifyDate() {
    }

    public Date getLodgingDate() {
        return lodgingDate;
    }

    public void setLodgingDate(Date lodgingDate) {
        this.lodgingDate = lodgingDate;
    }

    public Date getLatestModifyDate() {
        return latestModifyDate;
    }

    public void setLatestModifyDate(Date latestModifyDate) {
        this.latestModifyDate = latestModifyDate;
    }

    public TbComplaints getTbComplaints() {
        return tbComplaints;
    }

    public void setTbComplaints(TbComplaints tbComplaints) {
        this.tbComplaints = tbComplaints;
    }

}
