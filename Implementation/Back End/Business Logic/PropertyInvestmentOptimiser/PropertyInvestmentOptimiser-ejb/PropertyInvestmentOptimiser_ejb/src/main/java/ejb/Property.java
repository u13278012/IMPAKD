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
 * @author Kudzai Muranga
 */
@Entity
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private double tax;
    
    @Column
    private double inflation;
    
    @Column
    private String propertyName;
    
    @OneToOne
    private Bond bond;
    
    @OneToOne
    private Rental rental;

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getInflation() {
        return inflation;
    }

    public void setInflation(double inflation) {
        this.inflation = inflation;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getAnnualMaintenanceCost() {
        return annualMaintenanceCost;
    }

    public void setAnnualMaintenanceCost(int annualMaintenanceCost) {
        this.annualMaintenanceCost = annualMaintenanceCost;
    }

    public int getAnnualCostIncrease() {
        return annualCostIncrease;
    }

    public void setAnnualCostIncrease(int annualCostIncrease) {
        this.annualCostIncrease = annualCostIncrease;
    }
    
    @Column
    private int annualMaintenanceCost;
    
    @Column
    private int annualCostIncrease;
    
    
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
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Property[ id=" + id + " ]";
    }
    
}
