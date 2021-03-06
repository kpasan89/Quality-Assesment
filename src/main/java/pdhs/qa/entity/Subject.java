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
import javax.persistence.Lob;

/**
 *
 * @author root
 */
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String english_name;
    String sinhala_name;
    String tamil_name;
    @Lob
    String english_description;
    @Lob
    String sinhala_description;
    @Lob
    String tmail_description;

    
    
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

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getSinhala_name() {
        return sinhala_name;
    }

    public void setSinhala_name(String sinhala_name) {
        this.sinhala_name = sinhala_name;
    }

    public String getTamil_name() {
        return tamil_name;
    }

    public void setTamil_name(String tamil_name) {
        this.tamil_name = tamil_name;
    }

    public String getEnglish_description() {
        return english_description;
    }

    public void setEnglish_description(String english_description) {
        this.english_description = english_description;
    }

    public String getSinhala_description() {
        return sinhala_description;
    }

    public void setSinhala_description(String sinhala_description) {
        this.sinhala_description = sinhala_description;
    }

    public String getTmail_description() {
        return tmail_description;
    }

    public void setTmail_description(String tmail_description) {
        this.tmail_description = tmail_description;
    }

    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pdhs.qa.entity.Subject[ id=" + id + " ]";
    }
    
}
