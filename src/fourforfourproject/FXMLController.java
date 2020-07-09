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
import javafx.scene.layout.AnchorPane;
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
   
   int selected =1;
   
   @FXML
   private AnchorPane paneStats, paneNames;
   
   //Student input pane   
   @FXML
   private TextField student1, student2, student3, student4;
   
   @FXML
   private Button btnStudent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        paneNames.toFront();
        
        fmiType1.setText("Beep Test");
        fmiType2.setText("Agility Test");
        fmiType3.setText("Vertical Jump");
        fmiType4.setText("20m Sprint");
        fReset();

        //tembName.getItems().add(temiName1);
       
        temiType1.setText("Free Throws");
        temiType2.setText("Layups");
        temiType3.setText("Three-pointers");
        temiType4.setText("Passing");
        

        /*
        tamiType1.setText("Defensive: 1v1");
        tamiType2.setText("Defensive: Positioning");
        tamiType3.setText("Attack: 1v1");
        tamiType4.setText("Attack: Positioning");
        */
        

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
    public void enterStudents(ActionEvent event){
        StudentList.getInstance().students.get(0).setName(student1.getText());
        StudentList.getInstance().students.get(1).setName(student2.getText());
        StudentList.getInstance().students.get(2).setName(student3.getText());
        StudentList.getInstance().students.get(3).setName(student4.getText());
        
        fmiName1.setText(StudentList.getInstance().students.get(0).getName());
        fmiName2.setText(StudentList.getInstance().students.get(1).getName());
        fmiName3.setText(StudentList.getInstance().students.get(2).getName());
        fmiName4.setText(StudentList.getInstance().students.get(3).getName());

       
        temiName1.setText(StudentList.getInstance().students.get(0).getName());
        temiName2.setText(StudentList.getInstance().students.get(1).getName());
        temiName3.setText(StudentList.getInstance().students.get(2).getName());
        temiName4.setText(StudentList.getInstance().students.get(3).getName());
                
        
        tamiName1.setText(StudentList.getInstance().students.get(0).getName());
        tamiName2.setText(StudentList.getInstance().students.get(1).getName());
        tamiName3.setText(StudentList.getInstance().students.get(2).getName());
        tamiName4.setText(StudentList.getInstance().students.get(3).getName());
                
        mmiName1.setText(StudentList.getInstance().students.get(0).getName());
        mmiName2.setText(StudentList.getInstance().students.get(1).getName());
        mmiName3.setText(StudentList.getInstance().students.get(2).getName());
        mmiName4.setText(StudentList.getInstance().students.get(3).getName());
        
        
        paneNames.toBack();
    }
    
    

    @FXML
    public void switchPanel(ActionEvent event){
        if(event.getSource() == btnFit){
            paneFit.toFront();
            selected = 1;
        } else if(event.getSource() == btnTech){
            paneTech.toFront();
            btnFit.setStyle("menuButton");
            selected = 2;
        } else if(event.getSource() == btnTac){
            paneTac.toFront();
            selected = 3;
        } else if(event.getSource() == btnMot){
            paneMot.toFront();
            selected = 4;
        }
        fReset();
    }
    
    
    public void handleName2(String s, MenuButton m){
        if (StudentList.getInstance().students.get(0).getName().equalsIgnoreCase(s)) {
             Student temp = StudentList.getInstance().returnStudent(0);
             tempRec.setStudent(temp);
             m.setText(s);
        } else if (StudentList.getInstance().students.get(1).getName().equalsIgnoreCase(s)) {
            tempRec.setStudent(StudentList.getInstance().students.get(1));
            m.setText(s);
        } else if (StudentList.getInstance().students.get(2).getName().equalsIgnoreCase(s)) {
            tempRec.setStudent(StudentList.getInstance().students.get(2));
            m.setText(s);
        } else if (StudentList.getInstance().students.get(3).getName().equalsIgnoreCase(s)) {
            tempRec.setStudent(StudentList.getInstance().students.get(3));
            m.setText(s);
        }     
    }
    
    @FXML
    public void handleName(ActionEvent event) {
        //System.out.println("Start of handelName: " + RecordLists.getInstance().BeepTests.toString()); 
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
        //handleName2(side, mmbName);
        //System.out.println("SEL: " + selected);
        
        switch(selected){
            case 1: 
                handleName2(side, fmbName);
            case 2:
                handleName2(side, tembName);
            case 3:
                handleName2(side, tambName);
            case 4:
                handleName2(side, mmbName);
        }
        //System.out.println("end of fName: " + RecordLists.getInstance().BeepTests.toString()); 
    }
    @Deprecated
    @FXML
    public void handlemType(ActionEvent event) {
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();    
        if ("Pre-session".equalsIgnoreCase(side)) {
            tempRec.setType("Pre-session");
            mmbType.setText(side);
        } else if ("During Session".equalsIgnoreCase(side)) {
            tempRec.setType("During Session");
            mmbType.setText(side);
        } else if ("Post-session".equalsIgnoreCase(side)) {
            tempRec.setType("Post-session");
            mmbType.setText(side);
        } else if ("Long Term".equalsIgnoreCase(side)) {
            tempRec.setType("Long Term");
            mmbType.setText(side);
        }        
    }
    
    
    
    @FXML
    public void mAdd(ActionEvent event){
         System.out.println("Start of mAdd: " + RecordLists.getInstance().PreS.toString());
        if("".equals(mtfScore.getText()) || tempRec.getStudent() == null || tempRec.getType() == null){
            ConfirmBox.display("Invalid Entry", "Record parameters invalid");
        }else{
           tempRec.setScore(Integer.parseInt(mtfScore.getText()));
            switch(tempRec.getType()){
                case "Pre-session":
                    RecordLists.getInstance().PreS.add(tempRec);
                break;
                case "During Session":
                    RecordLists.getInstance().DS.add(tempRec);
                break; 
                case "Post-session":
                    RecordLists.getInstance().PostS.add(tempRec);
                break;
                case "Long Term":
                    RecordLists.getInstance().LT.add(tempRec);
                break;
            }
            //fReset();

        }
    }
    
    @FXML
    public void mList(ActionEvent event){
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
        System.out.println(RecordLists.getInstance().PreS.toString());
        mListView.getItems().clear();
        if ("Pre-session".equalsIgnoreCase(side)) {
            for(int i = 0; i < RecordLists.getInstance().PreS.size(); i++){
                mListView.getItems().add(RecordLists.getInstance().PreS.get(i));
            }
            mmbList.setText("Pre-session");
        } else if("During Session".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().DS.size(); i++){
                mListView.getItems().add(RecordLists.getInstance().DS.get(i));
            }
            mmbList.setText("During Session");
        } else if("Post-session".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().PostS.size(); i++){
                mListView.getItems().add(RecordLists.getInstance().PostS.get(i));
            }
            mmbList.setText("Post-session");
        } else if("Long Term".equalsIgnoreCase(side)){
            for(int i = 0; i < RecordLists.getInstance().LT.size(); i++){
                mListView.getItems().add(RecordLists.getInstance().LT.get(i));
            }
            mmbList.setText("Long term");
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
    
    @Deprecated 
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
    @Deprecated
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
    /*
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
     */
    @Deprecated
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
    
    @Deprecated
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

    @Deprecated
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
    
    /*
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
    */
    @Deprecated
    @FXML
    public void fList(ActionEvent event){
        //System.out.println("Start of fList: " + RecordLists.getInstance().BeepTests.toString()); 
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
        System.out.println("TEXT: " + side);
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
    
    
    
    @Deprecated
    @FXML
    public void handlefType(ActionEvent event) {
        System.out.println("Start of fType: " + RecordLists.getInstance().BeepTests.toString()); 
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
    
    public Student detStu(String name){
        if(name.equals(StudentList.getInstance().students.get(0).getName())){
            return StudentList.getInstance().students.get(0);
        } else if(name.equals(StudentList.getInstance().students.get(1).getName())){
            return StudentList.getInstance().students.get(1);
        }else if(name.equals(StudentList.getInstance().students.get(2).getName())){
            return StudentList.getInstance().students.get(2);
        }else if(name.equals(StudentList.getInstance().students.get(3).getName())){
            return StudentList.getInstance().students.get(3);
        }
        return null;
    }
    
    /*
        @FXML
    public void mAdd(ActionEvent event){
         System.out.println("Start of mAdd: " + RecordLists.getInstance().PreS.toString());
        if("".equals(mtfScore.getText()) || tempRec.getStudent() == null || tempRec.getType() == null){
            ConfirmBox.display("Invalid Entry", "Record parameters invalid");
        }else{
           tempRec.setScore(Integer.parseInt(mtfScore.getText()));
            switch(tempRec.getType()){
                case "Pre-session":
                    RecordLists.getInstance().PreS.add(tempRec);
                break;
                case "During Session":
                    RecordLists.getInstance().DS.add(tempRec);
                break; 
                case "Post-session":
                    RecordLists.getInstance().PostS.add(tempRec);
                break;
                case "Long Term":
                    RecordLists.getInstance().LT.add(tempRec);
                break;
            }
            //fReset();

        }
    }
    */
    
    
    @FXML
    public void type(ActionEvent event){
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
        switch(selected){
            case 1:
                System.out.println("Start of fType: " + RecordLists.getInstance().BeepTests.toString()); 
                //MenuItem mItem = (MenuItem) event.getSource();
                //String side = mItem.getText();    
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
            break;
            case 2:   
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
            break;
            case 3:
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
            break;
            case 4:
                if ("Pre-session".equalsIgnoreCase(side)) {
                    tempRec.setType("Pre-session");
                    mmbType.setText(side);
                } else if ("During Session".equalsIgnoreCase(side)) {
                    tempRec.setType("During Session");
                    mmbType.setText(side);
                } else if ("Post-session".equalsIgnoreCase(side)) {
                    tempRec.setType("Post-session");
                    mmbType.setText(side);
                } else if ("Long Term".equalsIgnoreCase(side)) {
                    tempRec.setType("Long Term");
                    mmbType.setText(side);
                }         
        }
    }
    
    
    //Adds record to the list of records
    @FXML
    public void add(ActionEvent event){
        System.out.println("Start of fAdd: " + RecordLists.getInstance().BeepTests.toString()); 
        
        Record tempoRec = new Record();
        System.out.println("SELECTED: " + selected);
        //System.out.println("SCORE:  " + ftfScore.getText() + ", NAME: " + fmbName.getText() + ", TYPE: " + fmbType.getText());
        switch(selected){
            case 1:
                if("".equals(ftfScore.getText()) || fmbName.getText() == null || fmbType.getText() == null){
                    ConfirmBox.display("Invalid Entry", "Record parameters invalid YYE");
                    }else{
                    tempoRec.setStudent(detStu(fmbName.getText()));
                    tempoRec.setScore(Integer.parseInt(ftfScore.getText()));
                    System.out.println("fmbType: " + fmbType.getText());
                    switch(fmbType.getText()){
                         case "Beep Test":
                             tempoRec.setType(fmbType.getText());
                             System.out.println("Added bt");
                             RecordLists.getInstance().BeepTests.add(tempoRec);
                         break;
                         case "Agility Test":
                             System.out.println("Added at");
                             RecordLists.getInstance().AgilityTests.add(tempoRec);
                         break; 
                         case "Vertical Jump":
                             System.out.println("Added jt");
                             RecordLists.getInstance().JumpTests.add(tempoRec);
                         break;
                         case "20m Sprint":
                             System.out.println("Added st");
                             RecordLists.getInstance().SprintTests.add(tempoRec);
                         break;
                    }
                }
            break;
            case 2:
                if("".equals(tetfScore.getText()) || tembName.getText() == null || tembType.getText() == null){
                    ConfirmBox.display("Invalid Entry", "Record parameters invalid NN");
                }else{
                    tempoRec.setStudent(detStu(tembName.getText()));
                    tempoRec.setScore(Integer.parseInt(tetfScore.getText()));
                    switch(tembType.getText()){
                        case "Free Throws":
                            System.out.println("Added Free throw");
                            RecordLists.getInstance().FreeThrows.add(tempoRec);
                        break;
                        case "Layups":
                            System.out.println("Added layup");
                            RecordLists.getInstance().Layups.add(tempoRec);
                        break;
                        case "Three-pointers":
                            System.out.println("added 3p");
                            RecordLists.getInstance().ThreePointers.add(tempoRec);
                        break;
                        case "Passing":
                            System.out.println("Added passing");
                            RecordLists.getInstance().Passing.add(tempoRec);
                        break;
                    }
                }
            break;
            case 3:
                if("".equals(tatfScore.getText()) || tambName.getText() == null || tambType.getText() == null){
                    ConfirmBox.display("Invalid Entry", "Record parameters invalid NN");
                }else{
                    tempoRec.setStudent(detStu(tambName.getText()));
                    tempoRec.setScore(Integer.parseInt(tatfScore.getText()));
                    switch(tambType.getText()){
                        case "Defense: 1v1":
                            System.out.println("Added d1v1");
                            RecordLists.getInstance().D1v1.add(tempoRec);
                        break;
                        case "Defense: Positioning":
                            System.out.println("Added dp");
                            RecordLists.getInstance().Dpos.add(tempoRec);
                        break;
                        case "Attack: 1v1":
                            System.out.println("added a1v1");
                            RecordLists.getInstance().A1v1.add(tempoRec);
                        break;
                        case "Attack: Positioning":
                            System.out.println("Added ap");
                            RecordLists.getInstance().Apos.add(tempoRec);
                        break;
                    }
                }
            break;
            case 4:
                if("".equals(mtfScore.getText()) || mmbName.getText() == null || mmbType.getText() == null){
                    ConfirmBox.display("Invalid Entry", "Record parameters invalid NN");
                }else{
                    tempoRec.setStudent(detStu(mmbName.getText()));
                    tempoRec.setScore(Integer.parseInt(mtfScore.getText()));
                    switch(mmbType.getText()){
                        case "Pre-session":
                            System.out.println("Added pre");
                            RecordLists.getInstance().PreS.add(tempoRec);
                        break;
                        case "During Session":
                            System.out.println("Added ds");
                            RecordLists.getInstance().DS.add(tempoRec);
                        break;
                        case "Post-session":
                            System.out.println("Added post");
                            RecordLists.getInstance().PostS.add(tempoRec);
                        break;
                        case "Long Term":
                            System.out.println("Added lt");
                            RecordLists.getInstance().LT.add(tempoRec);
                        break;
                    }
                }
                
                
            break;
            
           
        
            //fReset();

        }
    }
    
    public void list(ActionEvent event){
        MenuItem mItem = (MenuItem) event.getSource();
        String side = mItem.getText();
        switch(selected){
            case 1:
                System.out.println("TEXT: " + side);
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
            break;
            case 2:
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
            break;
            case 3:
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
            break;
            case 4:
                System.out.println(RecordLists.getInstance().PreS.toString());
                mListView.getItems().clear();
                if ("Pre-session".equalsIgnoreCase(side)) {
                    for(int i = 0; i < RecordLists.getInstance().PreS.size(); i++){
                        mListView.getItems().add(RecordLists.getInstance().PreS.get(i));
                    }
                    mmbList.setText("Pre-session");
                } else if("During Session".equalsIgnoreCase(side)){
                    for(int i = 0; i < RecordLists.getInstance().DS.size(); i++){
                        mListView.getItems().add(RecordLists.getInstance().DS.get(i));
                    }
                    mmbList.setText("During Session");
                } else if("Post-session".equalsIgnoreCase(side)){
                    for(int i = 0; i < RecordLists.getInstance().PostS.size(); i++){
                        mListView.getItems().add(RecordLists.getInstance().PostS.get(i));
                    }
                    mmbList.setText("Post-session");
                } else if("Long Term".equalsIgnoreCase(side)){
                    for(int i = 0; i < RecordLists.getInstance().LT.size(); i++){
                        mListView.getItems().add(RecordLists.getInstance().LT.get(i));
                    }
                    mmbList.setText("Long term");
        }    
            break;         
        }
    }
    
    
    public void fReset(){
        tempRec.setScore(-1); tempRec.setStudent(null); tempRec.setType(null);
    }
    

    
    
    
}
