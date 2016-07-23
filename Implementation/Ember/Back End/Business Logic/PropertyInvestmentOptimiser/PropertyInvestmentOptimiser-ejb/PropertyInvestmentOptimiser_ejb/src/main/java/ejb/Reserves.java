/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Khumalo
 */
@Entity
public class Reserves implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private double maintanance;
    
    @OneToOne
    private int renovation;
    
    @OneToOne
    private double deviance;
    
    @OneToOne
    private double rentInsurance;
    
    @OneToOne
    private double minReserves;

    public double getMaintanance() {
        return maintanance;
    }

    public void setMaintanance(double maintanance) {
        this.maintanance = maintanance;
    }

    public int getRenovation() {
        return renovation;
    }

    public void setRenovation(int renovation) {
        this.renovation = renovation;
    }

    public double getDeviance() {
        return deviance;
    }

    public void setDeviance(double deviance) {
        this.deviance = deviance;
    }

    public double getRentInsurance() {
        return rentInsurance;
    }

    public void setRentInsurance(double rentInsurance) {
        this.rentInsurance = rentInsurance;
    }

    public double getMinReserves() {
        return minReserves;
    }

    public void setMinReserves(double minReserves) {
        this.minReserves = minReserves;
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
        if (!(object instanceof Reserves)) {
            return false;
        }
        Reserves other = (Reserves) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Reserves[ id=" + id + " ]";
    }
    
}
