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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kudzai Muranga
 */

@Entity
@XmlRootElement
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String propertyName;
    
    @Column
    private double marketPriceAdjustment;
    
    @Column
    private double capitalGains;

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }
    
    @Column
    private int profileID;
    
    @OneToOne
    private UpFrontCosts upFrontCosts;
    
    @OneToOne
    private PropertyReserves reserves;
    
    @OneToOne
    private Expenses expenses;
    
    @OneToOne
    private Increases increases;
    
    @OneToOne
    private Rental rental;
    
    @OneToOne
    private Bond bond;


    public Increases getIncreases() {
        return increases;
    }

    public void setIncreases(Increases increases) {
        this.increases = increases;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    @ManyToOne
    private Profile profile;
    


    /**
     *
     * @return
     */
    public UpFrontCosts getUpFrontCosts() {
        return upFrontCosts;
    }

    /**
     *
     * @param upFrontCosts
     */
    public void setUpFrontCosts(UpFrontCosts upFrontCosts) {
        this.upFrontCosts = upFrontCosts;
    }

    /**
     *
     * @return
     */
    public PropertyReserves getReserves() {
        return reserves;
    }

    /**
     *
     * @param reserves
     */
    public void setReserves(PropertyReserves reserves) {
        this.reserves = reserves;
    }

    /**
     *
     * @return
     */
    public Expenses getExpenses() {
        return expenses;
    }

    /**
     *
     * @param expenses
     */
    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    /**
     *
     * @return
     */
    public Increases getInceases() {
        return increases;
    }

    /**
     *
     * @param inceases
     */
    public void setInceases(Increases inceases) {
        this.increases = inceases;
    }

    /**
     *
     * @return
     */
    public double getMarketPriceAdjustment() {
        return marketPriceAdjustment;
    }

    /**
     *
     * @param marketPriceAdjustment
     */
    public void setMarketPriceAdjustment(double marketPriceAdjustment) {
        this.marketPriceAdjustment = marketPriceAdjustment;
    }

    /**
     *
     * @return
     */
    public double getCapitalGains() {
        return capitalGains;
    }

    /**
     *
     * @param capitalGains
     */
    public void setCapitalGains(double capitalGains) {
        this.capitalGains = capitalGains;
    }

    /**
     *
     * @return
     */
    public Bond getBond() {
        return bond;
    }

    /**
     *
     * @param bond
     */
    public void setBond(Bond bond) {
        this.bond = bond;
    }

    /**
     *
     * @return
     */
    public Rental getRental() {
        return rental;
    }

    /**
     *
     * @param rental
     */
    public void setRental(Rental rental) {
        this.rental = rental;
    }
    
    /**
     *
     * @return
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     *
     * @param propertyName
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
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
