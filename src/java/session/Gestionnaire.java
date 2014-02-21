/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Applicationtype;
import entities.Categorie;
import entities.Device;
import entities.Question;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author HP
 */
@Stateless
@LocalBean
public class Gestionnaire {
    @PersistenceContext(unitName = "IHM_TP1PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<String> getAllDevices() {
        Query q =em.createNamedQuery("Device.findAll");
        List<Device> l =q.getResultList();
        List<String> ls=new ArrayList<String>();
        for(int i=0 ;i<l.size();i++){
        ls.add(l.get(i).getType());}
        return ls;
    } 
    
     public List<String> getAllUsers() {
        Query q =em.createNamedQuery("User.findAll");
        List<User> l =q.getResultList();
        List<String> ls=new ArrayList<String>();
        for(int i=0 ;i<l.size();i++){
        ls.add(l.get(i).getCategorie());}
        return ls;
    } 
      public List<String> getAllAppTypes() {
        Query q =em.createNamedQuery("Applicationtype.findAll");
        List<Applicationtype> l =q.getResultList();
        List<String> ls=new ArrayList<String>();
        for(int i=0 ;i<l.size();i++){
        ls.add(l.get(i).getType());}
        return ls;
    } 
      
       public List<String> getCategories(String category) {
        Query q =em.createNamedQuery("Critère.findByAuteur");
        List<Categorie> l =q.getResultList();
        List<String> ls=new ArrayList<String>();
        for(int i=0 ;i<l.size();i++){
        ls.add(l.get(i).getDesignation());}
        return ls;
    } 
       
       
       
       public Device getDeviceByName(String nomDevice){
        Query q =em.createNamedQuery("Device.findByType");
        q.setParameter("type", nomDevice);
        return (Device)q.getResultList();
       }
       
       public User getUserByName(String nomUser){
        Query q =em.createNamedQuery("User.findByCategorie");
        q.setParameter("categorie", nomUser);
        return (User)q.getResultList();
       }
        public Applicationtype getApplicationTypeByName(String nomApplicationType){
        Query q =em.createNamedQuery("Applicationtype.findByType");
        q.setParameter("type", nomApplicationType);
        return (Applicationtype)q.getResultList();
       }
       public List<Question> getQuestions(String device ,String typeapp , String user) {
        Query q =em.createNamedQuery("Question.QuestionsFiltrees");
         q.setParameter("device",(Device)getDeviceByName(device));
         q.setParameter("user", (User)getUserByName(user));
         q.setParameter("applicationtype",(Applicationtype) getApplicationTypeByName(typeapp));
               
        List<Question> l =q.getResultList();
        /*List<String> ls=new ArrayList<String>();
              
        for(int i=0 ;i<l.size();i++){
        ls.add(l.get(i).getContenu());}
        */
        return l;
        
         } 
       
        public Categorie findCatById(Integer d)
    {
        Query query=em.createNamedQuery("Categorie.findByIdCategorie");
         query.setParameter("idcategorie", d);
        return  (Categorie)query.getSingleResult();
        
    }
       
      /* 
        public List<Question> getQuestionsFiltree()
    {
     Query q= em.createNamedQuery("Question.QuestionsFiltrees");
     Integer i = new Integer(2) ;
     Device dd =deviceFacade.find(i);
     
    
     q.setParameter("device",dd);
     
     User u=userFacade.find(1);
     q.setParameter("user", u);
     
     Typeapp t=typeappFacade.find(1);
     q.setParameter("typeApp", t);
     
        return q.getResultList();
    }*/
       
       
}
