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

/**
 *
 * @author Khumalo
 */
@Entity
public class PropertyReserves implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private double maintenance;

    /**
     *
     * @return
     */
    public double getMaintenance() {
        return maintenance;
    }

    /**
     *
     * @param maintenance
     */
    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    /**
     *
     * @return
     */
    public double getRenovation() {
        return renovation;
    }

    /**
     *
     * @param renovation
     */
    public void setRenovation(double renovation) {
        this.renovation = renovation;
    }

    /**
     *
     * @return
     */
    public double getDeviance() {
        return deviance;
    }

    /**
     *
     * @param deviance
     */
    public void setDeviance(double deviance) {
        this.deviance = deviance;
    }

    /**
     *
     * @return
     */
    public double getRentInsurance() {
        return rentInsurance;
    }

    /**
     *
     * @param rentInsurance
     */
    public void setRentInsurance(double rentInsurance) {
        this.rentInsurance = rentInsurance;
    }

    /**
     *
     * @return
     */
    public double getMinReserves() {
        return minReserves;
    }

    /**
     *
     * @param minReserves
     */
    public void setMinReserves(double minReserves) {
        this.minReserves = minReserves;
    }
    
    @Column
    private double renovation;
    
    @Column
    private double deviance;
    
    @Column
    private double rentInsurance;
    
    @Column
    private double minReserves;
    
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
        if (!(object instanceof PropertyReserves)) {
            return false;
        }
        PropertyReserves other = (PropertyReserves) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PropertyReserves[ id=" + id + " ]";
    }
    
}
