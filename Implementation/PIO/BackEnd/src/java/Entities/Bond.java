/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
    private Double bondRepayment;
    
    @Column
    private Double depositPercentage;
    
    @Column
    private int numberOfYears;
    
    
    /**
     *
     * @param depositPercentage
     */
    public void setDepositPercentage(Double depositPercentage){
        this.depositPercentage = depositPercentage;
    } 
     /**
     *
     * @return
     */
    public Double getDepositPercentage() {
        return depositPercentage;
    }

   

    /**
     *
     * @return
     */
    public Double getBondRepayment() {
        return bondRepayment;
    }

    /**
     *
     * @param bondRepayment
     */
    public void setBondRepayment(Double bondRepayment) {
        this.bondRepayment = bondRepayment;
    }

    /**
     *
     * @return
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     *
     * @param interestRate
     */
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     *
     * @return
     */
    public Double getPropertyValue() {
        return propertyValue;
    }

    /**
     *
     * @param propertyValue
     */
    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }

    /**
     *
     * @return
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     *
     * @param numberOfYears
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    
    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
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
