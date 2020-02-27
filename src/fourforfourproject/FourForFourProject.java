/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import static java.awt.SystemColor.window;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class FourForFourProject extends Application {
    
      /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
         System.out.println("test");
        
        

        RecordLists rbt = RecordLists.getInstance();
        
        
         //JsonRead read = new JsonRead();
         //read.read();
        
       
       Student s1 = new Student("Cameron");
       Student s2 = new Student("Ethan");
       Student s3 = new Student("Bean");
       Student s4 = new Student("Last");
       StudentList.getInstance().students.add(s1);
       StudentList.getInstance().students.add(s2);
       StudentList.getInstance().students.add(s3);
       StudentList.getInstance().students.add(s4);
       
       Record r1 = new Record(s2,"BeepTest",12,11);
       Record r2 = new Record(s3,"BeepTest", 14, 12);
       rbt.BeepTests.add(r1);
       rbt.BeepTests.add(r2);  
        launch(args);
    }
    
     Stage window;
     Scene main, fit;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add("/fourforfourproject/fxml1.css");
        
        stage.setScene(scene);
        
        
        
         stage.setOnCloseRequest(e -> {
            e.consume();
            try { 
                closeProgram(stage);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FourForFourProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
         stage.show();
        
        /*
                window = primaryStage;
        
        primaryStage.setTitle("StudentTest");
        
        
       
                
        
        
        Button btnFit = new Button();
        btnFit.setText("Fitness");
        
        Button btnBack = new Button();
        btnBack.setText("Home");
        
        
        StackPane layout = new StackPane();
        layout.getChildren().add(btnFit);
        
        main = new Scene(layout, 1280, 720);
        
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btnBack);
        fit = new Scene(layout2, 1280, 720);
        
        
        btnFit.setOnAction(e -> {
            window.setScene(fit);
            JsonWrite.defaultScoreBT();
        });
        
         btnBack.setOnAction(e -> {
            window.setScene(main);
        });
        
        
        window.setScene(main);
        
        
        window.show();
        //primaryStage.show();
        */
        
        
    }

  
    
    
    private void closeProgram(Stage stage) throws FileNotFoundException{
        Boolean ans = ConfirmBox.display("Title", "Are you sure you want to exit?");
        if(ans){
            
            //JsonCreate.create();
            stage.close();
                   
        }
    }
    
    
}
    
    

