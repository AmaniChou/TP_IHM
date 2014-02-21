/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import entities.Question;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import session.Gestionnaire;

/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class QuestionsChoiceMBean {
    
     private TreeNode root2;

       List<Question> questions = new ArrayList<>();
        List<Integer> cat= new ArrayList<>();
        List<String> catDes= new ArrayList<>();
                
        
    public TreeNode getRoot2() {
      
        questions = gestionnaire.getQuestions(fbean.choixDevice,  fbean.choixUser,fbean.choixTypeApp);

        //recuperer les categories et les mettre ds les node niveau1
        for (int j = 0; j < questions.size(); j++) {
            if ((cat.isEmpty()) || (!cat.contains(questions.get(j).getQuestionPK().getCritèreCategorieidCategorie()))) {
                cat.add(questions.get(j).getQuestionPK().getCritèreCategorieidCategorie());
            }
        }

        for (int k = 0; k < cat.size(); k++) {
            catDes.add(gestionnaire.findCatById(cat.get(k)).getDesignation());
        }

        root2 = new CheckboxTreeNode("Root", null);
        
         TreeNode node ;
         TreeNode node1  ;
         //List<TreeNode> listNode0 = new ArrayList<>() ;
         
        for (int i=0; i < cat.size(); i++) {
           node = new CheckboxTreeNode(catDes.get(i), root2);
           
          // List<Question> q= new ArrayList<>();
           for(int j=0;j<questions.size();j++){
               if(questions.get(j).getQuestionPK().getCritèreCategorieidCategorie() == cat.get(i))
               {  //q.add(questions.get(j));
               node1 = new CheckboxTreeNode(questions.get(j).getContenu(), node);
           }
//           for(int j=0;j<questions.size();j++){
//           listNode0.add(node);
       }
        }
        
          
        return root2;
    }
    

    public void setRoot2(TreeNode root2) {
        this.root2 = root2;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }
     
     
    @EJB
    private Gestionnaire gestionnaire;

    /**
     * Creates a new instance of QuestionsChoiceMBean
     */
    
    
    
   @ManagedProperty("#{filtresBean}")
           FiltresBean fbean ;

    public FiltresBean getFbean() {
        return fbean;
    }

    public void setFbean(FiltresBean fbean) {
        this.fbean = fbean;
    }
   
   String device ;
   
   
    String user;
    String typeapp ;
    String method ;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTypeapp() {
        return typeapp;
    }

    public void setTypeapp(String typeapp) {
        this.typeapp = typeapp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
   public List<Question> getQuesions(){
   return gestionnaire.getQuestions(device, typeapp, user);
   }
    
    public QuestionsChoiceMBean() {
    }
    /*[19:12:20] Marwouta:  @PostConstruct
public void init () {
  root2 = new CheckboxTreeNode("Root", null);  
        for (int i=0 ;i< this.getQuestion().size();i++)
        {
           TreeNode node = new CheckboxTreeNode(getQuestion().get(i).getContenu(),root2);
        }
}*/
}
/*

package org.primefaces.examples.view;  
  
import java.io.Serializable;  
import java.util.logging.Logger;  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
  
import org.primefaces.model.TreeNode;  
  
import org.primefaces.examples.domain.Document;  
import org.primefaces.model.CheckboxTreeNode;  
  
public class TreeCheckboxBean implements Serializable {  
      
    private static final Logger logger = Logger.getLogger(TreeCheckboxBean.class.getName());  
  
    private TreeNode root2;  
      
    private TreeNode[] selectedNodes;  
      
    public TreeCheckboxBean() {  
        root2 = new CheckboxTreeNode("Root", null);  
        TreeNode node0 = new CheckboxTreeNode("Node 0", root2);  
        TreeNode node1 = new CheckboxTreeNode("Node 1", root2);  
        TreeNode node2 = new CheckboxTreeNode("Node 2", root2);  
          
        TreeNode node00 = new CheckboxTreeNode("Node 0.0", node0);  
        TreeNode node01 = new CheckboxTreeNode("Node 0.1", node0);  
          
        TreeNode node10 = new CheckboxTreeNode("Node 1.0", node1);  
        TreeNode node11 = new CheckboxTreeNode("Node 1.1", node1);  
          
        TreeNode node000 = new CheckboxTreeNode("Node 0.0.0", node00);  
        TreeNode node001 = new CheckboxTreeNode("Node 0.0.1", node00);  
        TreeNode node010 = new CheckboxTreeNode("Node 0.1.0", node01);  
          
        TreeNode node100 = new CheckboxTreeNode("Node 1.0.0", node10);  
    }  
          
    public TreeNode getRoot2() {  
        return root2;  
    }  
  
    public void setRoot2(TreeNode root2) {  
        this.root2 = root2;  
    }  
      
    public TreeNode[] getSelectedNodes() {  
        return selectedNodes;  
    }  
  
    public void setSelectedNodes(TreeNode[] selectedNodes) {  
        this.selectedNodes = selectedNodes;  
    }  
      
    public void displaySelectedMultiple() {  
        if(selectedNodes != null && selectedNodes.length > 0) {  
            StringBuilder builder = new StringBuilder();  
  
            for(TreeNode node : selectedNodes) {  
                builder.append(node.getData().toString());  
                builder.append("<br />");  
            }  
  
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", builder.toString());  
  
            FacesContext.getCurrentInstance().addMessage(null, message);  
        }  
    }  
}  
           


*/