/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "applicationtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applicationtype.findAll", query = "SELECT a FROM Applicationtype a"),
    @NamedQuery(name = "Applicationtype.findByIdApplicationType", query = "SELECT a FROM Applicationtype a WHERE a.idApplicationType = :idApplicationType"),
    @NamedQuery(name = "Applicationtype.findByType", query = "SELECT a FROM Applicationtype a WHERE a.type = :type")})
public class Applicationtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApplicationType")
    private Integer idApplicationType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @JoinTable(name = "applicationtype_has_question", joinColumns = {
        @JoinColumn(name = "ApplicationType_idApplicationType", referencedColumnName = "idApplicationType")}, inverseJoinColumns = {
        @JoinColumn(name = "Question_idQuestion", referencedColumnName = "idQuestion"),
        @JoinColumn(name = "Question_Crit\u00e8re_idCrit\u00e8re", referencedColumnName = "Crit\u00e8re_idCrit\u00e8re"),
        @JoinColumn(name = "Question_Crit\u00e8re_Categorie_idCategorie", referencedColumnName = "Crit\u00e8re_Categorie_idCategorie")})
    @ManyToMany
    private List<Question> questionList;

    public Applicationtype() {
    }

    public Applicationtype(Integer idApplicationType) {
        this.idApplicationType = idApplicationType;
    }

    public Applicationtype(Integer idApplicationType, String type) {
        this.idApplicationType = idApplicationType;
        this.type = type;
    }

    public Integer getIdApplicationType() {
        return idApplicationType;
    }

    public void setIdApplicationType(Integer idApplicationType) {
        this.idApplicationType = idApplicationType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (idApplicationType != null ? idApplicationType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicationtype)) {
            return false;
        }
        Applicationtype other = (Applicationtype) object;
        if ((this.idApplicationType == null && other.idApplicationType != null) || (this.idApplicationType != null && !this.idApplicationType.equals(other.idApplicationType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Applicationtype[ idApplicationType=" + idApplicationType + " ]";
    }
    
}
