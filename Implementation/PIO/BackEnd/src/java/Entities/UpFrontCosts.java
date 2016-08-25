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
public class UpFrontCosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private double conveyancingFees ;
    
    @Column
    private double vatDebit ;
    
    @Column
    private double deedsFees ;
    
    @Column
    private double initiationFee;

    /**
     *
     * @return
     */
    public double getInitiationFee() {
        return initiationFee;
    }

    /**
     *
     * @param initiationFee
     */
    public void setInitiationFee(double initiationFee) {
        this.initiationFee = initiationFee;
    }

    /**
     *
     * @return
     */
    public double getDeedsFees() {
        return deedsFees;
    }

    /**
     *
     * @param deedsFees
     */
    public void setDeedsFees(double deedsFees) {
        this.deedsFees = deedsFees;
    }
    
    /**
     *
     * @return
     */
    public double getVatDebit() {
        return vatDebit;
    }

    /**
     *
     * @param vatDebit
     */
    public void setVatDebit(double vatDebit) {
        this.vatDebit = vatDebit;
    }

    /**
     *
     * @return
     */
    public double getConveyancingFees() {
        return conveyancingFees;
    }

    /**
     *
     * @param conveyancingFees
     */
    public void setConveyancingFees(double conveyancingFees) {
        this.conveyancingFees = conveyancingFees;
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
        if (!(object instanceof UpFrontCosts)) {
            return false;
        }
        UpFrontCosts other = (UpFrontCosts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.upFrontCosts[ id=" + id + " ]";
    }
    
}
