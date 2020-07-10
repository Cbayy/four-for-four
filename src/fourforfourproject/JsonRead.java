/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * Inputs a text file, with the student data and parses it.
 * @author Owner
 */
public class JsonRead {
    public static final String file = "student_data.txt";
    
    public void read() throws FileNotFoundException, IOException{
        try (InputStream fileIS = new FileInputStream(file); JsonReader jsonRead = Json.createReader(fileIS)) {
            JsonArray jsonArr = jsonRead.readArray();
            
            System.out.println("size of json Array being read: " + jsonArr.size());
            for(int x = 0; x < jsonArr.size(); x++){
                System.out.println("size of json Array being read: " + jsonArr.size());
                JsonObject jsonObj;
                jsonObj = jsonArr.getJsonObject(x);
                Record sc = new Record();
                
                sc.s.setName(jsonObj.getString("name"));
                sc.setType(jsonObj.getString("type"));
                sc.setDate(jsonObj.getString("date"));
                sc.setScore(jsonObj.getInt("score"));
             
                switch(sc.getType()){
                    case "BeepTest":
                        RecordLists.getInstance().BeepTests.add(sc);
                        System.out.println("ADDED BEEP");
                    case "SprintTest":
                        RecordLists.getInstance().SprintTests.add(sc);
                }
            }
             
            jsonRead.close();
             
             
             
        }
       
    }
}
