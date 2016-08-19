package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Priscilla
 */
@Entity
public class Liabilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private double principalDebt;

    public double getPrincipalDebt() {
        return principalDebt;
    }

    public void setPrincipalDebt(double principalDebt) {
        this.principalDebt = principalDebt;
    }

    public double getOwnerEquity() {
        return ownerEquity;
    }

    public void setOwnerEquity(double ownerEquity) {
        this.ownerEquity = ownerEquity;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
    
    @Column
    private double ownerEquity;
    
    @OneToOne
    private Asset asset;
    
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
        if (!(object instanceof Liabilities)) {
            return false;
        }
        Liabilities other = (Liabilities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Liabilities[ id=" + id + " ]";
    }
    
}
