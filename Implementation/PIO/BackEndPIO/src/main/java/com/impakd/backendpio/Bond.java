/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impakd.backendpio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kudzai Muranga
 */
@Entity
@XmlRootElement
public class Bond implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private Double interestRate;
    
    @Column
    private Double propertyValue;
    
    @Column
    private Double depositInRands;
    
     @Column
    private Double bondRepayment;
    
    @Column
    private int numberOfYears;
    
    @OneToOne
    private AdditionalBondRepayment additionalBondRepayment;

    public Double getDepositInRands() {
        return depositInRands;
    }

    public void setDepositInRands(Double depositInRands) {
        this.depositInRands = depositInRands;
    }

    public Double getBondRepayment() {
        return bondRepayment;
    }

    public void setBondRepayment(Double bondRepayment) {
        this.bondRepayment = bondRepayment;
    }

    public AdditionalBondRepayment getAdditionalBondRepayment() {
        return additionalBondRepayment;
    }

    public void setAdditionalBondRepayment(AdditionalBondRepayment additionalBondRepayment) {
        this.additionalBondRepayment = additionalBondRepayment;
    }
    
   

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
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
        if (!(object instanceof Bond)) {
            return false;
        }
        Bond other = (Bond) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Bond[ id=" + id + " ]";
    }
    
}
