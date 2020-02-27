/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParsingException;


/**
 * Inputs a student data file to parse. No longer used, see jsonRead and jsonCreate.
 * @author Owner
 */
@Deprecated
public class DataParser {
   
      public List<Record> parse(String fileName) throws DataParserException, ParseException{
          
        List<Record> list = new ArrayList<>();
        JsonReader jsonReader = null;
        
        try {
            //read data
            jsonReader = Json.createReader(new FileInputStream(fileName));
        } catch (FileNotFoundException fnfe) {
            throw new DataParserException("File not found: " + fileName);
        }
        
        
         JsonObject jobj = null;
        try{
            jobj = jsonReader.readObject();
        }
        catch (JsonParsingException jpe){
            throw new DataParserException("Parsing exception: " + jpe.getMessage());
        }
          // read the values of the item field
        JsonArray items = jobj.getJsonArray("items");

        for (int i = 0; i < items.size(); i++) {
            JsonObject record = items.getJsonObject(i);
            JsonObject snippet = record.getJsonObject("snippet");

            // parsing to Youtube video
            String name = snippet.getString("name");
            
            int date = snippet.getInt("date");
         
            
            String score = snippet.getString("score");
             
            //Record newScore = new Record(name, date, Integer.parseInt(score)); 

            // add to the list 
            //list.add(newScore);
        }
        return list;
      }
 
}
