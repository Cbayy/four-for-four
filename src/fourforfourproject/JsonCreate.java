/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.json.Json;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author Owner
 */
public class JsonCreate {
    
    public static void create() throws FileNotFoundException{
        OutputStream fileOS = new FileOutputStream("student_data.txt");
        JsonGenerator jsonGen = Json.createGenerator(fileOS);
        
        //Get Array of records
        
        
        //Record sc = JsonWrite.defaultScoreBT();
               
               jsonGen.writeStartArray();
               
        RecordLists rbt = RecordLists.getInstance();
        
        System.out.println("BeepTest size: " + rbt.BeepTests.size());
  
        for(int x = 1; x < rbt.BeepTests.size(); x++){
            jsonGen.writeStartObject();
            jsonGen.write("name", rbt.BeepTests.get(x).s.toString());
            jsonGen.write("type", rbt.BeepTests.get(x).getType());
            jsonGen.write("date", rbt.BeepTests.get(x).getDate());
            jsonGen.write("score", rbt.BeepTests.get(x).getScore());
            jsonGen.writeEnd();
        }
       
        
        jsonGen.writeEnd();
        jsonGen.close();
        
    }
}
