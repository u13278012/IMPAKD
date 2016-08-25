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
public class IncomeStatement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private double grossProfit;
    
    @OneToOne
    private Asset asset;
    
    @OneToOne
    private Reserves reserves;
    
    @OneToOne
    private Liabilities liabilities;

    /**
     *
     * @return
     */
    public Asset getAsset() {
        return asset;
    }

    /**
     *
     * @param asset
     */
    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    /**
     *
     * @return
     */
    public Reserves getReserves() {
        return reserves;
    }

    /**
     *
     * @param reserves
     */
    public void setReserves(Reserves reserves) {
        this.reserves = reserves;
    }

    /**
     *
     * @return
     */
    public Liabilities getLiabilities() {
        return liabilities;
    }

    /**
     *
     * @param liabilities
     */
    public void setLiabilities(Liabilities liabilities) {
        this.liabilities = liabilities;
    }

    /**
     *
     * @return
     */
    public CashFlowStatement getCashFlowStatement() {
        return cashFlowStatement;
    }

    /**
     *
     * @param cashFlowStatement
     */
    public void setCashFlowStatement(CashFlowStatement cashFlowStatement) {
        this.cashFlowStatement = cashFlowStatement;
    }
    
    @OneToOne
    private CashFlowStatement cashFlowStatement;

    /**
     *
     * @return
     */
    public double getGrossProfit() {
        return grossProfit;
    }

    /**
     *
     * @param grossProfit
     */
    public void setGrossProfit(double grossProfit) {
        this.grossProfit = grossProfit;
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

    /**
     *
     * @return
     */
    public double getInterest() {
        return interest;
    }

    /**
     *
     * @param interest
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    @Column
    private double rent;
    
    
    @Column
    private double interest;
    
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
        if (!(object instanceof IncomeStatement)) {
            return false;
        }
        IncomeStatement other = (IncomeStatement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.IncomeStatement[ id=" + id + " ]";
    }
    
}
