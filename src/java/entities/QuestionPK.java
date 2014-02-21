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
public class QuestionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idQuestion")
    private int idQuestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Crit\u00e8re_idCrit\u00e8re")
    private int critèreidCritère;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Crit\u00e8re_Categorie_idCategorie")
    private int critèreCategorieidCategorie;

    public QuestionPK() {
    }

    public QuestionPK(int idQuestion, int critèreidCritère, int critèreCategorieidCategorie) {
        this.idQuestion = idQuestion;
        this.critèreidCritère = critèreidCritère;
        this.critèreCategorieidCategorie = critèreCategorieidCategorie;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getCritèreidCritère() {
        return critèreidCritère;
    }

    public void setCritèreidCritère(int critèreidCritère) {
        this.critèreidCritère = critèreidCritère;
    }

    public int getCritèreCategorieidCategorie() {
        return critèreCategorieidCategorie;
    }

    public void setCritèreCategorieidCategorie(int critèreCategorieidCategorie) {
        this.critèreCategorieidCategorie = critèreCategorieidCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idQuestion;
        hash += (int) critèreidCritère;
        hash += (int) critèreCategorieidCategorie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionPK)) {
            return false;
        }
        QuestionPK other = (QuestionPK) object;
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        if (this.critèreidCritère != other.critèreidCritère) {
            return false;
        }
        if (this.critèreCategorieidCategorie != other.critèreCategorieidCategorie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.QuestionPK[ idQuestion=" + idQuestion + ", crit\u00e8reidCrit\u00e8re=" + critèreidCritère + ", crit\u00e8reCategorieidCategorie=" + critèreCategorieidCategorie + " ]";
    }
    
}
