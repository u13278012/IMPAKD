/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impakd.propertyinvestmentoptimiser;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kudzai Muranga
 */
@Entity
@XmlRootElement
public class AdditionalBondRepayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private Double period;

    public Double getPeriod() {
        return period;
    }

    public void setPeriod(Double period) {
        this.period = period;
    }

    public Double getAdditionalCash() {
        return additionalCash;
    }

    public void setAdditionalCash(Double additionalCash) {
        this.additionalCash = additionalCash;
    }

    public Double getOnceOffPayment() {
        return onceOffPayment;
    }

    public void setOnceOffPayment(Double onceOffPayment) {
        this.onceOffPayment = onceOffPayment;
    }
    
    @Column
    private Double additionalCash;
    
    @Column
    private Double onceOffPayment;

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
        if (!(object instanceof AdditionalBondRepayment)) {
            return false;
        }
        AdditionalBondRepayment other = (AdditionalBondRepayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.AdditionalBondRepayment[ id=" + id + " ]";
    }
    
}
