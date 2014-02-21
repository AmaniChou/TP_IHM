/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "crit\u00e8re")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crit\u00e8re.findAll", query = "SELECT c FROM Crit\u00e8re c"),
    @NamedQuery(name = "Crit\u00e8re.findByIdCrit\u00e8re", query = "SELECT c FROM Crit\u00e8re c WHERE c.crit\u00e8rePK.idCrit\u00e8re = :idCrit\u00e8re"),
    @NamedQuery(name = "Crit\u00e8re.findByDesignation", query = "SELECT c FROM Crit\u00e8re c WHERE c.designation = :designation"),
    @NamedQuery(name = "Crit\u00e8re.findByAuteur", query = "SELECT c FROM Crit\u00e8re c WHERE c.auteur = :auteur"),
    @NamedQuery(name = "Crit\u00e8re.findByCategorieidCategorie", query = "SELECT c FROM Crit\u00e8re c WHERE c.crit\u00e8rePK.categorieidCategorie = :categorieidCategorie")})
public class Critère implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CritèrePK critèrePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "auteur")
    private String auteur;
    @JoinColumn(name = "Categorie_idCategorie", referencedColumnName = "idCategorie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categorie categorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crit\u00e8re")
    private List<Question> questionList;

    public Critère() {
    }

    public Critère(CritèrePK critèrePK) {
        this.critèrePK = critèrePK;
    }

    public Critère(CritèrePK critèrePK, String designation, String auteur) {
        this.critèrePK = critèrePK;
        this.designation = designation;
        this.auteur = auteur;
    }

    public Critère(int idCritère, int categorieidCategorie) {
        this.critèrePK = new CritèrePK(idCritère, categorieidCategorie);
    }

    public CritèrePK getCritèrePK() {
        return critèrePK;
    }

    public void setCritèrePK(CritèrePK critèrePK) {
        this.critèrePK = critèrePK;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @XmlTransient
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (critèrePK != null ? critèrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Critère)) {
            return false;
        }
        Critère other = (Critère) object;
        if ((this.critèrePK == null && other.critèrePK != null) || (this.critèrePK != null && !this.critèrePK.equals(other.critèrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Crit\u00e8re[ crit\u00e8rePK=" + critèrePK + " ]";
    }
    
}
