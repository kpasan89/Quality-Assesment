/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import pdhs.qa.entity.Branch;
import pdhs.qa.entity.Employee;

/**
 *
 * @author root
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    Employee employee;
    Branch branch;
    String language;

    public String getLanguage() {
        if (language == null) {
            language = "en";
        }
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

}
