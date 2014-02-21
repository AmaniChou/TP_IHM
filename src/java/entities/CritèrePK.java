/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HP
 */
@Embeddable
public class CritèrePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idCrit\u00e8re")
    private int idCritère;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Categorie_idCategorie")
    private int categorieidCategorie;

    public CritèrePK() {
    }

    public CritèrePK(int idCritère, int categorieidCategorie) {
        this.idCritère = idCritère;
        this.categorieidCategorie = categorieidCategorie;
    }

    public int getIdCritère() {
        return idCritère;
    }

    public void setIdCritère(int idCritère) {
        this.idCritère = idCritère;
    }

    public int getCategorieidCategorie() {
        return categorieidCategorie;
    }

    public void setCategorieidCategorie(int categorieidCategorie) {
        this.categorieidCategorie = categorieidCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCritère;
        hash += (int) categorieidCategorie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CritèrePK)) {
            return false;
        }
        CritèrePK other = (CritèrePK) object;
        if (this.idCritère != other.idCritère) {
            return false;
        }
        if (this.categorieidCategorie != other.categorieidCategorie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Crit\u00e8rePK[ idCrit\u00e8re=" + idCritère + ", categorieidCategorie=" + categorieidCategorie + " ]";
    }
    
}
