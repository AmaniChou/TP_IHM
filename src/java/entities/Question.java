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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByIdQuestion", query = "SELECT q FROM Question q WHERE q.questionPK.idQuestion = :idQuestion"),
    @NamedQuery(name = "Question.findByCrit\u00e8reidCrit\u00e8re", query = "SELECT q FROM Question q WHERE q.questionPK.crit\u00e8reidCrit\u00e8re = :crit\u00e8reidCrit\u00e8re"),
    @NamedQuery(name = "Question.findByCrit\u00e8reCategorieidCategorie", query = "SELECT q FROM Question q WHERE q.questionPK.crit\u00e8reCategorieidCategorie = :crit\u00e8reCategorieidCategorie"),
    @NamedQuery(name = "Question.QuestionsFiltrees" , query="SELECT DISTINCT q FROM Question q join fetch q.deviceList join fetch q.userList join "
            + "fetch q.applicationtypeList WHERE :device MEMBER OF q.deviceList and :user MEMBER OF q.userList and :applicationtype MEMBER OF q.applicationtypeList ")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestionPK questionPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "contenu")
    private String contenu;
    @JoinTable(name = "question_has_user", joinColumns = {
        @JoinColumn(name = "Question_idQuestion", referencedColumnName = "idQuestion"),
        @JoinColumn(name = "Question_Crit\u00e8re_idCrit\u00e8re", referencedColumnName = "Crit\u00e8re_idCrit\u00e8re"),
        @JoinColumn(name = "Question_Crit\u00e8re_Categorie_idCategorie", referencedColumnName = "Crit\u00e8re_Categorie_idCategorie")}, inverseJoinColumns = {
        @JoinColumn(name = "User_iduser", referencedColumnName = "iduser")})
    @ManyToMany
    private List<User> userList;
    @ManyToMany(mappedBy = "questionList")
    private List<Device> deviceList;
    @ManyToMany(mappedBy = "questionList")
    private List<Applicationtype> applicationtypeList;
    @JoinColumns({
        @JoinColumn(name = "Crit\u00e8re_idCrit\u00e8re", referencedColumnName = "idCrit\u00e8re", insertable = false, updatable = false),
        @JoinColumn(name = "Crit\u00e8re_Categorie_idCategorie", referencedColumnName = "Categorie_idCategorie", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Critère critère;

    public Question() {
    }

    public Question(QuestionPK questionPK) {
        this.questionPK = questionPK;
    }

    public Question(QuestionPK questionPK, String contenu) {
        this.questionPK = questionPK;
        this.contenu = contenu;
    }

    public Question(int idQuestion, int critèreidCritère, int critèreCategorieidCategorie) {
        this.questionPK = new QuestionPK(idQuestion, critèreidCritère, critèreCategorieidCategorie);
    }

    public QuestionPK getQuestionPK() {
        return questionPK;
    }

    public void setQuestionPK(QuestionPK questionPK) {
        this.questionPK = questionPK;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @XmlTransient
    public List<Applicationtype> getApplicationtypeList() {
        return applicationtypeList;
    }

    public void setApplicationtypeList(List<Applicationtype> applicationtypeList) {
        this.applicationtypeList = applicationtypeList;
    }

    public Critère getCritère() {
        return critère;
    }

    public void setCritère(Critère critère) {
        this.critère = critère;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionPK != null ? questionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.questionPK == null && other.questionPK != null) || (this.questionPK != null && !this.questionPK.equals(other.questionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Question[ questionPK=" + questionPK + " ]";
    }
    
}
