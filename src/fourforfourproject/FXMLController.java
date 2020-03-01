/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

//Should rewrite most of this class, make functions more modular, currently complication with scenebuilder
// as it doesnt like duplicates

/**
 * FXML Controller class
 *
 * @author Owner
 */
public class FXMLController implements Initializable {

    
   // f = fitness tab, te = tech, ta = tactical, m = motivation 
   @FXML
   private Button btnFit, btnTech, btnTac, btnMot;
   
   @FXML
   private Pane paneFit, paneTech, paneTac, paneMot;
    
   @FXML
   private MenuButton fmbName, fmbType, fmbList;

   @FXML
   private MenuItem fmiName1, fmiName2, fmiName3, fmiName4;
   
   @FXML
   private MenuItem fmiType1, fmiType2, fmiType3, fmiType4;
   
   @FXML
   private TextField ftfScore;
   
   @FXML 
   private ListView fListView;
   
   
   @FXML
   private LineChart <?, ?>LineChart;
   
   @FXML
   private CategoryAxis fxAxis;
   
   @FXML
   private NumberAxis fyAxis;
   
 
  
   
   //--------------------------------------------------
   @FXML
   private MenuButton tembName, tembType, tembList;
   
   @FXML
   private MenuItem temiName1, temiName2, temiName3, temiName4;
   
   @FXML
   private MenuItem temiType1, temiType2, temiType3, temiType4;
   
   @FXML
   private TextField tetfScore;

   @FXML
   private Label telInvalid;
   
   @FXML
   private Button tebAdd;
   
   @FXML
   private ListView teListView;
   //--------------------------------------------------
   @FXML
   private MenuButton tambName, tambType, tambList;
   
   @FXML
   private MenuItem tamiName1, tamiName2, tamiName3, tamiName4;
   
   @FXML
   private MenuItem tamiType1, tamiType2, tamiType3, tamiType4;
   
   @FXML
   private TextField tatfScore;

   @FXML
   private Label talInvalid;
   
   @FXML
   private Button tabAdd;
   
   @FXML
   private ListView taListView;
   //----------------------------------------------------
   @FXML
   private MenuButton mmbName, mmbType, mmbList;
   
   @FXML
   private MenuItem mmiName1, mmiName2, mmiName3, mmiName4;
   
   @FXML
   private MenuItem mmiType1, mmiType2, mmiType3, mmiType4;
   
   @FXML
   private TextField mtfScore;

   @FXML
   private Label mlInvalid;
   
   @FXML
   private Button mbAdd;
   
   @FXML
   private ListView mListView;
   
   
   
   Record tempRec = new Record();
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fmiName1.setText(StudentList.getInstance().students.get(0).getName());
        fmiName2.setText(StudentList.getInstance().students.get(1).getName());
        fmiName3.setText(StudentList.getInstance().students.get(2).getName());
        fmiName4.setText(StudentList.getInstance().students.get(3).getName());
        
        fmiType1.setText("Beep Test");
        fmiType2.setText("Agility Test");
        fmiType3.setText("Vertical Jump");
        fmiType4.setText("20m Sprint");
        fReset();
       
        temiName1.setText(StudentList.getInstance().students.get(0).getName());
        temiName2.setText(StudentList.getInstance().students.get(1).getName());
        temiName3.setText(StudentList.getInstance().students.get(2).getName());
        temiName4.setText(StudentList.getInstance().students.get(3).getName());
        
        //tembName.getItems().add(temiName1);
       
        temiType1.setText("Free Throws");
        temiType2.setText("Layups");
        temiType3.setText("Three-pointers");
        temiType4.setText("Passing");
        
        
        tamiName1.setText(StudentList.getInstance().students.get(0).getName());
        tamiName2.setText(StudentList.getInstance().students.get(1).getName());
        tamiName3.setText(StudentList.getInstance().students.get(2).getName());
        tamiName4.setText(StudentList.getInstance().students.get(3).getName());
        
        /*
        tamiType1.setText("Defensive: 1v1");
        tamiType2.setText("Defensive: Positioning");
        tamiType3.setText("Attack: 1v1");
        tamiType4.setText("Attack: Positioning");
        */
        
        mmiName1.setText(StudentList.getInstance().students.get(0).getName());
        mmiName2.setText(StudentList.getInstance().students.get(1).getName());
        mmiName3.setText(StudentList.getInstance().students.get(2).getName());
        mmiName4.setText(StudentList.getInstance().students.get(3).getName());
        
        telInvalid.setVisible(false);
        talInvalid.setVisible(false);
        
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data<>("0", RecordLists.getInstance().BeepTests.get(0).getScore()));
        series.getData().add(new XYChart.Data<>("1", RecordLists.getInstance().BeepTests.get(1).getScore()));
        //series.getData().add(new XYChart.Data<>("1",10));
        LineChart.getData().addAll(series);
        
        System.out.println(com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
    }    
  
    
    
    @FXML
    public void switchPanel(ActionEvent event){
        if(event.getSource() == btnFit){
            paneFit.toFront();
        } else if(event.getSource() == btnTech){
            paneTech.toFront();
            btnFit.setStyle("menuButton");
        } else if(event.getSource() == btnTac){
            paneTac.toFront();
        } else if(event.getSource() == btnMot){
            paneMot.toFront();
        }
        fReset();
    }
    
    
    @FXML
    public void handlemName(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
         
        if (StudentList.getInstance().students.get(0).getName().equalsIgnoreCase(side)) {
             Student temp = StudentList.getInstance().returnStudent(0);
             tempRec.setStudent(temp);
             mmbName.setText(side);
        } else if (StudentList.getInstance().students.get(1).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(1));
            mmbName.setText(side);
        } else if (StudentList.getInstance().students.get(2).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(2));
            mmbName.setText(side);
        } else if (StudentList.getInstance().students.get(3).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(3));
            mmbName.setText(side);
        }        
    }
  
    @FXML
    public void handlemType(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();    
        if ("Pre-session".equalsIgnoreCase(side)) {
            tempRec.setType("BeepTest");
            System.out.println("Beep test added");
            fmbType.setText(side);
           
            //System.out.println(tempRec.getName().getName());
        } else if ("Agility Test".equalsIgnoreCase(side)) {
            tempRec.setType("AgilityTest");
            System.out.println("Agility Test added");
            fmbType.setText(side);
        } else if ("Vertical Jump".equalsIgnoreCase(side)) {
            tempRec.setType("JumpTest");
            System.out.println("Vertical Jump added");
            fmbType.setText(side);
            
        } else if ("20m Sprint".equalsIgnoreCase(side)) {
            tempRec.setType("SprintTest");
            System.out.println("Sprint added");
            fmbType.setText(side);
        }        
    }
    
    
    
    @FXML
    public void mAdd(ActionEvent event){
         
        if("".equals(ftfScore.getText()) || tempRec.getStudent() == null || tempRec.getType() == null){
            ConfirmBox.display("Invalid Entry", "Record parameters invalid");
        }else{
           tempRec.setScore(Integer.parseInt(ftfScore.getText()));
            switch(tempRec.getType()){
                case "BeepTest":
                    System.out.println("Added bt");
                    RecordLists.getInstance().BeepTests.add(tempRec);
                break;
                case "AgilityTest":
                    System.out.println("Added at");
                    RecordLists.getInstance().AgilityTests.add(tempRec);
                break; 
                case "JumpTest":
                    System.out.println("Added jt");
                    RecordLists.getInstance().JumpTests.add(tempRec);
                break;
                case "SprintTest":
                    System.out.println("Added st");
                    RecordLists.getInstance().SprintTests.add(tempRec);
                break;
            }
            //fReset();

        }
    }
    
    @FXML
    public void mList(ActionEvent event){
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
           
        fListView.getItems().clear();
        if ("Beep Test".equalsIgnoreCase(side)) {
                       
            for(int i = 0; i < RecordLists.getInstance().BeepTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().BeepTests.get(i));
                
            }

           
            fmbList.setText("Beep Test");
            
            
        } else if("Agility Test".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().AgilityTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().AgilityTests.get(i));
            }
            fmbList.setText("Agility Test");
        } else if("20m Sprint".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().SprintTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().SprintTests.get(i));
            }
            fmbList.setText("20m Sprint");
        } else if("Vertical Jump".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().JumpTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().JumpTests.get(i));
            }
            fmbList.setText("Vertical Jump");
        }
    }
    
    @FXML
    public void handletaName(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
         
        if (StudentList.getInstance().students.get(0).getName().equalsIgnoreCase(side)) {
             Student temp = StudentList.getInstance().returnStudent(0);
             tempRec.setStudent(temp);
             tambName.setText(side);
             //mItem.getParentMenu().setText("YEEEEEEEEEEEEEEE");
             //System.out.println(mItem.getParentMenu().getId());
        } else if (StudentList.getInstance().students.get(1).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(1));
            tambName.setText(side);
        } else if (StudentList.getInstance().students.get(2).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(2));
            tambName.setText(side);
        } else if (StudentList.getInstance().students.get(3).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(3));
            tambName.setText(side);
        }        
    }
    
      
    @FXML
    public void handletaType(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();    
        if ("Defensive: 1v1".equalsIgnoreCase(side)) {
            tempRec.setType("D1v1");
            tambType.setText(side);
        } else if ("Defensive: Positioning".equalsIgnoreCase(side)) {
            tempRec.setType("Dpos");
            tambType.setText(side);
        } else if ("Attack: 1v1".equalsIgnoreCase(side)) {
            tempRec.setType("A1v1");
            tambType.setText(side);
        } else if ("Attack: Positioning".equalsIgnoreCase(side)) {
            tempRec.setType("Apos");
            tambType.setText(side);
        }        
    }
  
    
    @FXML
    public void taAdd(ActionEvent event){
         
        if("".equals(tatfScore.getText()) || tempRec.getStudent() == null || tempRec.getType() == null){
            System.out.println("score: " + tatfScore.getText() + "Student: " + tempRec.getStudent() + "Type: " + tempRec.getType());
            ConfirmBox.display("Invalid Entry", "Record parameters invalid");
        } else if(Integer.parseInt(tatfScore.getText()) > 4 || Integer.parseInt(tatfScore.getText()) < 0){
            talInvalid.setVisible(true);
            
        }else{
            talInvalid.setVisible(false);
           tempRec.setScore(Integer.parseInt(tatfScore.getText()));
            switch(tempRec.getType()){
                case "D1v1":
                    System.out.println("Added d1v1");
                    RecordLists.getInstance().D1v1.add(tempRec);
                break;
                case "Dpos":
                    RecordLists.getInstance().Dpos.add(tempRec);
                break; 
                case "A1v1":
                    RecordLists.getInstance().A1v1.add(tempRec);
                break;
                case "Apos":
                    RecordLists.getInstance().Apos.add(tempRec);
                break;
            }
            //fReset();

        }
    }

    @FXML
    public void taList(ActionEvent event){
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
       
        taListView.getItems().clear();
        if ("Defense: 1v1".equalsIgnoreCase(side)) {
            for(int i = 0; i < RecordLists.getInstance().D1v1.size(); i++){
                taListView.getItems().add(RecordLists.getInstance().D1v1.get(i));
            }
            tambList.setText("Defense: 1v1");
        } else if("Defense: Positioning".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().Dpos.size(); i++){
                taListView.getItems().add(RecordLists.getInstance().Dpos.get(i));
            }
            tambList.setText("Defense: Positioning");
        } else if("Attack: 1v1".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().A1v1.size(); i++){
                taListView.getItems().add(RecordLists.getInstance().A1v1.get(i));
            }
            tambList.setText("Attack: 1v1");
        } else if("Attack: Positioning".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().Apos.size(); i++){
                taListView.getItems().add(RecordLists.getInstance().Apos.get(i));
            }
            tambList.setText("Attack: Positioning");
        }
        
    }
    
    @FXML
    public void handleteName(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
         
        if (StudentList.getInstance().students.get(0).getName().equalsIgnoreCase(side)) {
             Student temp = StudentList.getInstance().returnStudent(0);
             tempRec.setStudent(temp);
             tembName.setText(side);
            
        } else if (StudentList.getInstance().students.get(1).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(1));
            tembName.setText(side);
        } else if (StudentList.getInstance().students.get(2).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(2));
            tembName.setText(side);
        } else if (StudentList.getInstance().students.get(3).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(3));
            tembName.setText(side);
        }        
    }
     
  
    @FXML
    public void handleteType(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();    
        if ("Free throws".equalsIgnoreCase(side)) {
            tempRec.setType("FreeThrow");
            System.out.println("3throw added");
            tembType.setText(side);
        } else if ("Layups".equalsIgnoreCase(side)) {
            tempRec.setType("Layup");
            System.out.println("layup added");
            tembType.setText(side);
        } else if ("Three-pointers".equalsIgnoreCase(side)) {
            tempRec.setType("ThreePointer");
            System.out.println("3pointer added");
            tembType.setText(side);
            
        } else if ("Passing".equalsIgnoreCase(side)) {
            tempRec.setType("Passing");
            System.out.println("pass added");
            tembType.setText(side);
        }        
    }
    
    @FXML
    public void teAdd(ActionEvent event){
         
        if("".equals(tetfScore.getText()) || tempRec.getStudent() == null || tempRec.getType() == null){
            System.out.println("score: " + tetfScore.getText() + "Student: " + tempRec.getStudent() + "Type: " + tempRec.getType());
            ConfirmBox.display("Invalid Entry", "Record parameters invalid");
        } else if(Integer.parseInt(tetfScore.getText()) > 10 || Integer.parseInt(tetfScore.getText()) < 0){
            telInvalid.setVisible(true);
            
        }else{
            telInvalid.setVisible(false);
           tempRec.setScore(Integer.parseInt(tetfScore.getText()));
            switch(tempRec.getType()){
                case "FreeThrow":
                    System.out.println("Added tt");
                    RecordLists.getInstance().FreeThrows.add(tempRec);
                break;
                case "Layup":
                    System.out.println("Added lu");
                    RecordLists.getInstance().Layups.add(tempRec);
                break; 
                case "ThreePointer":
                    System.out.println("Added 3p");
                    RecordLists.getInstance().ThreePointers.add(tempRec);
                break;
                case "Passing":
                    System.out.println("Added p");
                    RecordLists.getInstance().Passing.add(tempRec);
                break;
            }
            //fReset();

        }
    }

    @FXML
    public void teList(ActionEvent event){
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
       
        teListView.getItems().clear();
        if ("Free Throws".equalsIgnoreCase(side)) {
            
            for(int i = 0; i < RecordLists.getInstance().FreeThrows.size(); i++){
                teListView.getItems().add(RecordLists.getInstance().FreeThrows.get(i));
            }
            tembList.setText("Free Throws");
        } else if("Layups".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().Layups.size(); i++){
                teListView.getItems().add(RecordLists.getInstance().Layups.get(i));
            }
            tembList.setText("Layups");
        } else if("Three-pointers".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().ThreePointers.size(); i++){
                teListView.getItems().add(RecordLists.getInstance().ThreePointers.get(i));
            }
            fmbList.setText("Three-pointers");
        } else if("Passing".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().Passing.size(); i++){
                teListView.getItems().add(RecordLists.getInstance().Passing.get(i));
            }
            tembList.setText("Passing");
        }
        
    }
    
    
    @FXML
    public void handlefName(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
         
        if (StudentList.getInstance().students.get(0).getName().equalsIgnoreCase(side)) {
             Student temp = StudentList.getInstance().returnStudent(0);
             tempRec.setStudent(temp);
             fmbName.setText(side);
        } else if (StudentList.getInstance().students.get(1).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(1));
            fmbName.setText(side);
        } else if (StudentList.getInstance().students.get(2).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(2));
            fmbName.setText(side);
        } else if (StudentList.getInstance().students.get(3).getName().equalsIgnoreCase(side)) {
            tempRec.setStudent(StudentList.getInstance().students.get(3));
            fmbName.setText(side);
        }        
    }
  
    @FXML
    public void handlefType(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();    
        if ("Beep Test".equalsIgnoreCase(side)) {
            tempRec.setType("BeepTest");
            System.out.println("Beep test added");
            fmbType.setText(side);
           
            //System.out.println(tempRec.getName().getName());
        } else if ("Agility Test".equalsIgnoreCase(side)) {
            tempRec.setType("AgilityTest");
            System.out.println("Agility Test added");
            fmbType.setText(side);
        } else if ("Vertical Jump".equalsIgnoreCase(side)) {
            tempRec.setType("JumpTest");
            System.out.println("Vertical Jump added");
            fmbType.setText(side);
            
        } else if ("20m Sprint".equalsIgnoreCase(side)) {
            tempRec.setType("SprintTest");
            System.out.println("Sprint added");
            fmbType.setText(side);
        }        
    }
    
    
    
    @FXML
    public void fAdd(ActionEvent event){
         
        if("".equals(ftfScore.getText()) || tempRec.getStudent() == null || tempRec.getType() == null){
            ConfirmBox.display("Invalid Entry", "Record parameters invalid");
        }else{
           tempRec.setScore(Integer.parseInt(ftfScore.getText()));
            switch(tempRec.getType()){
                case "BeepTest":
                    System.out.println("Added bt");
                    RecordLists.getInstance().BeepTests.add(tempRec);
                break;
                case "AgilityTest":
                    System.out.println("Added at");
                    RecordLists.getInstance().AgilityTests.add(tempRec);
                break; 
                case "JumpTest":
                    System.out.println("Added jt");
                    RecordLists.getInstance().JumpTests.add(tempRec);
                break;
                case "SprintTest":
                    System.out.println("Added st");
                    RecordLists.getInstance().SprintTests.add(tempRec);
                break;
            }
            //fReset();

        }
    }
    
    public void fReset(){
        tempRec.setScore(-1); tempRec.setStudent(null); tempRec.setType(null);
    }
    
    @FXML
    public void fList(ActionEvent event){
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
           
        fListView.getItems().clear();
        if ("Beep Test".equalsIgnoreCase(side)) {
                       
            for(int i = 0; i < RecordLists.getInstance().BeepTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().BeepTests.get(i));
                
            }

           
            fmbList.setText("Beep Test");
            
            
        } else if("Agility Test".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().AgilityTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().AgilityTests.get(i));
            }
            fmbList.setText("Agility Test");
        } else if("20m Sprint".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().SprintTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().SprintTests.get(i));
            }
            fmbList.setText("20m Sprint");
        } else if("Vertical Jump".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().JumpTests.size(); i++){
                fListView.getItems().add(RecordLists.getInstance().JumpTests.get(i));
            }
            fmbList.setText("Vertical Jump");
        }
        
    }
    
    
    
    
}
