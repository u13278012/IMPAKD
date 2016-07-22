/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impakd.backend;

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
    
    @OneToOne
    private UpFrontCosts upFrontCosts;
    
    @OneToOne
    private Reserves reserves;
    
    @OneToOne
    private Expenses expenses;
    
    @OneToOne
    private Increases increases;
    
    @OneToOne
    private Rental rental;
    
    @OneToOne
    private Bond bond;

    public UpFrontCosts getUpFrontCosts() {
        return upFrontCosts;
    }

    public void setUpFrontCosts(UpFrontCosts upFrontCosts) {
        this.upFrontCosts = upFrontCosts;
    }

    public Reserves getReserves() {
        return reserves;
    }

    public void setReserves(Reserves reserves) {
        this.reserves = reserves;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public Increases getInceases() {
        return increases;
    }

    public void setInceases(Increases inceases) {
        this.increases = inceases;
    }

    public double getMarketPriceAdjustment() {
        return marketPriceAdjustment;
    }

    public void setMarketPriceAdjustment(double marketPriceAdjustment) {
        this.marketPriceAdjustment = marketPriceAdjustment;
    }

    public double getCapitalGains() {
        return capitalGains;
    }

    public void setCapitalGains(double capitalGains) {
        this.capitalGains = capitalGains;
    }

    public Bond getBond() {
        return bond;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
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
