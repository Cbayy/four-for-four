/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import java.util.ArrayList;


/**
 *
 * @author Owner
 */
public class Student{
    
    /**
     * The student's class
     */
    //String className;
    
    /**
     * The student's name
     */
    String name;
    
    /*
    * The students scores
    */
    ArrayList<Record> scores = new ArrayList<>();

    public Student(String name){
        //this.className = className;
        this.name = name;
    }
    
    public Student(){
        
    }
    
    /*
    public void setClassName(String className) {
        this.className = className;
    }
    */
    public void setScores(ArrayList<Record> scores) {
        this.scores = scores;
    }

     public void setName(String name) {
        this.name = name;
    }
    
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Record> getScores() {
        return scores;
    }

    
    
}
