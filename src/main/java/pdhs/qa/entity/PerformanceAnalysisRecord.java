/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdhs.qa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author root
 */
@Entity
public class PerformanceAnalysisRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date fromDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date toDate;
    Long analysisYear;
    Long analysisMonth;
    Long analysisDate;
    @ManyToOne
    Employee employee;
    @ManyToOne
    Branch branch;
    @ManyToOne
    Process process;
    
    Long completed_on_time_count;
    Long delayed_count;
    Double completed_on_time_percentage;
    Double delayed_count_percentage;
    @Lob
    String causes_for_delay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getAnalysisYear() {
        return analysisYear;
    }

    public void setAnalysisYear(Long analysisYear) {
        this.analysisYear = analysisYear;
    }

    public Long getAnalysisMonth() {
        return analysisMonth;
    }

    public void setAnalysisMonth(Long analysisMonth) {
        this.analysisMonth = analysisMonth;
    }

    public Long getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Long analysisDate) {
        this.analysisDate = analysisDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Long getCompleted_on_time_count() {
        return completed_on_time_count;
    }

    public void setCompleted_on_time_count(Long completed_on_time_count) {
        this.completed_on_time_count = completed_on_time_count;
    }

    public Long getDelayed_count() {
        return delayed_count;
    }

    public void setDelayed_count(Long delayed_count) {
        this.delayed_count = delayed_count;
    }

    public Double getCompleted_on_time_percentage() {
        return completed_on_time_percentage;
    }

    public void setCompleted_on_time_percentage(Double completed_on_time_percentage) {
        this.completed_on_time_percentage = completed_on_time_percentage;
    }

    public Double getDelayed_count_percentage() {
        return delayed_count_percentage;
    }

    public void setDelayed_count_percentage(Double delayed_count_percentage) {
        this.delayed_count_percentage = delayed_count_percentage;
    }

    public String getCauses_for_delay() {
        return causes_for_delay;
    }

    public void setCauses_for_delay(String causes_for_delay) {
        this.causes_for_delay = causes_for_delay;
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
        if (!(object instanceof PerformanceAnalysisRecord)) {
            return false;
        }
        PerformanceAnalysisRecord other = (PerformanceAnalysisRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pdhs.qa.entity.MonthlyPerformanceAnalysis[ id=" + id + " ]";
    }
    
}
