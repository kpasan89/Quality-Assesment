/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pdhs.qa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author root
 */
@Entity
public class LetterProcessMessurment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    long timeLaken;
    
    @ManyToOne
    Letter letter;
    
    @ManyToOne
    ProcessMessurment processMessurment;

    public ProcessMessurment getProcessMessurment() {
        return processMessurment;
    }

    public void setProcessMessurment(ProcessMessurment processMessurment) {
        this.processMessurment = processMessurment;
    }
    

    
    
    public long getTimeLaken() {
        return timeLaken;
    }

    public void setTimeLaken(long timeLaken) {
        this.timeLaken = timeLaken;
    }

    
    
    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
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
        if (!(object instanceof LetterProcessMessurment)) {
            return false;
        }
        LetterProcessMessurment other = (LetterProcessMessurment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pdhs.qa.entity.LetterProcessMessurment[ id=" + id + " ]";
    }
    
}
