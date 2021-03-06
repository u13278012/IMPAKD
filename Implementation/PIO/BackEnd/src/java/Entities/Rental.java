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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kudzai Muranga
 */
@Entity
@XmlRootElement
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private Double occupancyRate;
    
    @Column
    private Double agentCommission;
    
    @Column
    private Double rentalAmount;
    
    @Column
    private Double onceOffAgentFee;
    
     @Column
    private Double totalRent;

    /**
     *
     * @return
     */
    public Double getOccupancyRate() {
        return occupancyRate;
    }

    /**
     *
     * @param occupancyRate
     */
    public void setOccupancyRate(Double occupancyRate) {
        this.occupancyRate = occupancyRate;
    }

    /**
     *
     * @return
     */
    public Double getAgentCommission() {
        return agentCommission;
    }

    /**
     *
     * @param agentCommission
     */
    public void setAgentCommission(Double agentCommission) {
        this.agentCommission = agentCommission;
    }

    /**
     *
     * @return
     */
    public Double getRentalAmount() {
        return rentalAmount;
    }

    /**
     *
     * @param rentalAmount
     */
    public void setRentalAmount(Double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    /**
     *
     * @return
     */
    public Double getOnceOffAgentFee() {
        return onceOffAgentFee;
    }

    /**
     *
     * @param onceOffAgentFee
     */
    public void setOnceOffAgentFee(Double onceOffAgentFee) {
        this.onceOffAgentFee = onceOffAgentFee;
    }

    /**
     *
     * @return
     */
    public Double getTotalRent() {
        return totalRent;
    }

    /**
     *
     * @param totalRent
     */
    public void setTotalRent(Double totalRent) {
        this.totalRent = totalRent;
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
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Rental[ id=" + id + " ]";
    }
    
}
