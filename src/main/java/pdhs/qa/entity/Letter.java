/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdhs.qa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author root
 */
@Entity
public class Letter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Employee employee;
    @ManyToOne
    Process process;
    @ManyToOne
    Branch branch;
    String letter_No;
    @Lob
    String letter_contants;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date letter_date;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date receive_At;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date forwarded_for_approval_at;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date approved_at;
    @ManyToOne
    Employee approved_by;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date completedAt;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date posted_at;
    @Lob
    String letter_remarks;
    boolean letter_delayed;
    @Lob
    String remarks_for_delay;
    @ManyToOne
    Subject subject;
    @OneToMany(mappedBy = "letter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<LetterReason> letterReasons;

    @OneToMany(mappedBy = "letter", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<LetterProcessMessurment> letterProcessMessurment;

    public List<LetterReason> getLetterReasons() {
        if (letterReasons == null) {
            letterReasons = new ArrayList<>();
        }
        return letterReasons;
    }

    public void setLetterReasons(List<LetterReason> letterReasons) {
        this.letterReasons = letterReasons;
    }

    public List<LetterProcessMessurment> getLetterProcessMessurment() {
        if (letterProcessMessurment == null) {
            letterProcessMessurment = new ArrayList<>();
        }
        return letterProcessMessurment;
    }

    public void setLetterProcessMessurment(List<LetterProcessMessurment> letterProcessMessurment) {
        this.letterProcessMessurment = letterProcessMessurment;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getLetter_No() {
        return letter_No;
    }

    public void setLetter_No(String letter_No) {
        this.letter_No = letter_No;
    }

    public String getLetter_contants() {
        return letter_contants;
    }

    public void setLetter_contants(String letter_contants) {
        this.letter_contants = letter_contants;
    }

    public Date getLetter_date() {
        return letter_date;
    }

    public void setLetter_date(Date letter_date) {
        this.letter_date = letter_date;
    }

    public Date getReceive_At() {
        return receive_At;
    }

    public void setReceive_At(Date receive_At) {
        this.receive_At = receive_At;
    }

    public Date getForwarded_for_approval_at() {
        return forwarded_for_approval_at;
    }

    public void setForwarded_for_approval_at(Date forwarded_for_approval_at) {
        this.forwarded_for_approval_at = forwarded_for_approval_at;
    }

    public Date getApproved_at() {
        return approved_at;
    }

    public void setApproved_at(Date approved_at) {
        this.approved_at = approved_at;
    }

    public Employee getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(Employee approved_by) {
        this.approved_by = approved_by;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
    }

    public String getLetter_remarks() {
        return letter_remarks;
    }

    public void setLetter_remarks(String letter_remarks) {
        this.letter_remarks = letter_remarks;
    }

    public boolean isLetter_delayed() {
        return letter_delayed;
    }

    public void setLetter_delayed(boolean letter_delayed) {
        this.letter_delayed = letter_delayed;
    }

    public String getRemarks_for_delay() {
        return remarks_for_delay;
    }

    public void setRemarks_for_delay(String remarks_for_delay) {
        this.remarks_for_delay = remarks_for_delay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Letter)) {
            return false;
        }
        Letter other = (Letter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pdhs.qa.entity.Letter[ id=" + id + " ]";
    }

}
