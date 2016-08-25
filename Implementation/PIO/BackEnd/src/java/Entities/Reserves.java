package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Priscilla
 */
@Entity
public class Reserves implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private double maintenacePerYear;

    /**
     *
     * @return
     */
    public double getMaintenacePerYear() {
        return maintenacePerYear;
    }

    /**
     *
     * @param maintenacePerYear
     */
    public void setMaintenacePerYear(double maintenacePerYear) {
        this.maintenacePerYear = maintenacePerYear;
    }

    /**
     *
     * @return
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     *
     * @param runningTotal
     */
    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }
    
    @Column
    private double runningTotal;
    
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
        return "Entities.Reserves[ id=" + id + " ]";
    }
    
}
