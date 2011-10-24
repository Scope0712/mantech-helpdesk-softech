/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tuyenbui
 */
@Entity
@Table(name = "tbStaffs")
@NamedQueries({
    @NamedQuery(name = "TbStaffs.findAll", query = "SELECT t FROM TbStaffs t"),
    @NamedQuery(name = "TbStaffs.findByStaffId", query = "SELECT t FROM TbStaffs t WHERE t.staffId = :staffId"),
    @NamedQuery(name = "TbStaffs.findByFirstName", query = "SELECT t FROM TbStaffs t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "TbStaffs.findByLastName", query = "SELECT t FROM TbStaffs t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "TbStaffs.findByGender", query = "SELECT t FROM TbStaffs t WHERE t.gender = :gender"),
    @NamedQuery(name = "TbStaffs.findByMaritalStatus", query = "SELECT t FROM TbStaffs t WHERE t.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "TbStaffs.findByIdentityCard", query = "SELECT t FROM TbStaffs t WHERE t.identityCard = :identityCard"),
    @NamedQuery(name = "TbStaffs.findByDateOfBirth", query = "SELECT t FROM TbStaffs t WHERE t.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "TbStaffs.findByPhoneNo", query = "SELECT t FROM TbStaffs t WHERE t.phoneNo = :phoneNo"),
    @NamedQuery(name = "TbStaffs.findByEmail", query = "SELECT t FROM TbStaffs t WHERE t.email = :email")})
public class TbStaffs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Staff_Id")
    private String staffId;
    @Basic(optional = false)
    @Column(name = "First_Name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "Last_Name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Marital_Status")
    private String maritalStatus;
    @Column(name = "Identity_Card")
    private String identityCard;
    @Basic(optional = false)
    @Column(name = "Date_Of_Birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Column(name = "Phone_No")
    private String phoneNo;
    @Lob
    @Column(name = "Address")
    private String address;
    @Column(name = "Email")
    private String email;
    @Lob
    @Column(name = "Avatar")
    private String avatar;
    @ManyToMany(mappedBy = "tbStaffsCollection")
    private Collection<TbAssignTasks> tbAssignTasksCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbStaffs")
    private Collection<TbSolutions> tbSolutionsCollection;
    @OneToMany(mappedBy = "tbStaffs")
    private Collection<TbAccounts> tbAccountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbStaffs")
    private Collection<TbComplaints> tbComplaintsCollection;
    @JoinColumn(name = "Department_Id", referencedColumnName = "Department_Id")
    @ManyToOne(optional = false)
    private TbDepartments tbDepartments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbStaffs")
    private Collection<TbTechnicalArticles> tbTechnicalArticlesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbStaffs")
    private Collection<TbAssignTasks> tbAssignTasksCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbStaffs1")
    private Collection<TbAssignTasks> tbAssignTasksCollection2;

    public TbStaffs() {
    }

    public TbStaffs(String staffId) {
        this.staffId = staffId;
    }

    public TbStaffs(String staffId, String firstName, String lastName, String gender, Date dateOfBirth) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Collection<TbAssignTasks> getTbAssignTasksCollection() {
        return tbAssignTasksCollection;
    }

    public void setTbAssignTasksCollection(Collection<TbAssignTasks> tbAssignTasksCollection) {
        this.tbAssignTasksCollection = tbAssignTasksCollection;
    }

    public Collection<TbSolutions> getTbSolutionsCollection() {
        return tbSolutionsCollection;
    }

    public void setTbSolutionsCollection(Collection<TbSolutions> tbSolutionsCollection) {
        this.tbSolutionsCollection = tbSolutionsCollection;
    }

    public Collection<TbAccounts> getTbAccountsCollection() {
        return tbAccountsCollection;
    }

    public void setTbAccountsCollection(Collection<TbAccounts> tbAccountsCollection) {
        this.tbAccountsCollection = tbAccountsCollection;
    }

    public Collection<TbComplaints> getTbComplaintsCollection() {
        return tbComplaintsCollection;
    }

    public void setTbComplaintsCollection(Collection<TbComplaints> tbComplaintsCollection) {
        this.tbComplaintsCollection = tbComplaintsCollection;
    }

    public TbDepartments getTbDepartments() {
        return tbDepartments;
    }

    public void setTbDepartments(TbDepartments tbDepartments) {
        this.tbDepartments = tbDepartments;
    }

    public Collection<TbTechnicalArticles> getTbTechnicalArticlesCollection() {
        return tbTechnicalArticlesCollection;
    }

    public void setTbTechnicalArticlesCollection(Collection<TbTechnicalArticles> tbTechnicalArticlesCollection) {
        this.tbTechnicalArticlesCollection = tbTechnicalArticlesCollection;
    }

    public Collection<TbAssignTasks> getTbAssignTasksCollection1() {
        return tbAssignTasksCollection1;
    }

    public void setTbAssignTasksCollection1(Collection<TbAssignTasks> tbAssignTasksCollection1) {
        this.tbAssignTasksCollection1 = tbAssignTasksCollection1;
    }

    public Collection<TbAssignTasks> getTbAssignTasksCollection2() {
        return tbAssignTasksCollection2;
    }

    public void setTbAssignTasksCollection2(Collection<TbAssignTasks> tbAssignTasksCollection2) {
        this.tbAssignTasksCollection2 = tbAssignTasksCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbStaffs)) {
            return false;
        }
        TbStaffs other = (TbStaffs) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TbStaffs[staffId=" + staffId + "]";
    }

}
