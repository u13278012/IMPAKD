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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Khumalo
 */
@Entity
@XmlRootElement
public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private Property propertyList[];

    /**
     *
     * @return
     */
    @XmlTransient
    public Property[] getPropertyList() {
        return propertyList;
    }

    /**
     *
     * @param propertyList
     */
    public void setPropertyList(Property[] propertyList) {
        this.propertyList = propertyList;
    }

    /**
     *
     * @return
     */
    public int[] getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(int[] time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public int[] getROI() {
        return ROI;
    }

    /**
     *
     * @param ROI
     */
    public void setROI(int[] ROI) {
        this.ROI = ROI;
    }
    @Column
    private int time[];
    
    @Column
    private int ROI[];
    
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
        if (!(object instanceof Statistics)) {
            return false;
        }
        Statistics other = (Statistics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Statistics[ id=" + id + " ]";
    }
    
}
