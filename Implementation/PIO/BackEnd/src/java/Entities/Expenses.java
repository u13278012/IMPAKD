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
public class Expenses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     *
     * @param rate_taxes
     */
    public void setRates_Taxes(double rate_taxes){
       this.rates_taxes = rate_taxes;
    }

    /**
     *
     * @return
     */
    public double getRates_Taxes(){
        return rates_taxes;
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
    
    @Column
    private double rates_taxes = 370.00;
    
    @Column
    private double levy = 534.50;
    
     @Column
    private double bondFee = 57.00;


    
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
        if (!(object instanceof Expenses)) {
            return false;
        }
        Expenses other = (Expenses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Expenses[ id=" + id + " ]";
    }
    
}
