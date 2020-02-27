/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class ConfirmBox {
    
    static boolean answer;
    
    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        
        Button btnYes = new Button("Yes");
        Button btnNo = new Button("No");
        Button btnOk = new Button("Ok");
        
        btnYes.setOnAction(e -> {
            answer = true;
            window.close();
        });
        
        btnNo.setOnAction(e ->{
            answer = false;
            window.close();
        });
        
        btnOk.setOnAction(e -> {
            window.close();
        });
        
        VBox layout = new VBox(10);
        
        switch(title){
            case "Invalid Entry":
                layout.getChildren().addAll(label, btnOk);
            break;
            default:
                layout.getChildren().addAll(label, btnYes, btnNo);
        }
        
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }
}
