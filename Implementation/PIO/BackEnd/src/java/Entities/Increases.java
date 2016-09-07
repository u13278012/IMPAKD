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
 * @author Khumalo
 */
@Entity
@XmlRootElement
public class Increases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *
     * @return
     */
    public double getInflation() {
        return inflation;
    }

    /**
     *
     * @param inflation
     */
    public void setInflation(double inflation) {
        this.inflation = inflation;
    }

    /**
     *
     * @return
     */
    public double getPropertyValue() {
        return propertyValue;
    }

    /**
     *
     * @param propertyValue
     */
    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    /**
     *
     * @return
     */
    public double getRent() {
        return rent;
    }

    /**
     *
     * @param rent
     */
    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getRates_taxes() {
        return rates_taxes;
    }

    public void setRates_taxes(double rates_taxes) {
        this.rates_taxes = rates_taxes;
    }

    /**
     *
     * @return
     */
    public double getBondFee() {
        return bondFee;
    }

    /**
     *
     * @param bondFee
     */
    public void setBondFee(double bondFee) {
        this.bondFee = bondFee;
    }

    /**
     *
     * @return
     */
    public double getLevy() {
        return levy;
    }

    /**
     *
     * @param levy
     */
    public void setLevy(double levy) {
        this.levy = levy;
    }
    
    @Column
    private double inflation;
    
    @Column
    private double propertyValue;
    
    @Column
    private double rent;
    
    @Column
    private double rates_taxes;
    
    @Column
    private double bondFee;
    
    @Column
    private double levy;
    
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
        if (!(object instanceof Increases)) {
            return false;
        }
        Increases other = (Increases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Inceases[ id=" + id + " ]";
    }
    
}
