/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Owner
 */
public class Record {
   
    Student s;
    
    /*
    * Date of the score
    */
    int date;
    
    
    
    
    String type;
    
    /*
    * Score
    */
    int score;

  
   
    public Record(Student s, String rType, int date, int score) {
        this.s = s;
        this.type = rType;
        this.date = date;
        this.score = score;
    }

    
    public Record() {
    }
    
  
    public void setStudent(Student s){
        this.s = s;
    }

    public void setType(String type){
        this.type = type;
    }
    
    public void setDate(int date) {
        this.date = date;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent(){
        return s;
    }
    
    public String getType(){
        return type;
    }
    
    public int getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\t Name: " + s.getName() + "\t Score: " + score + "\n";
    }
    
  
    
    /*
    public void place(Record rec){
        switch(rec.type){
            case BeepTest:
                BeepTests.add(rec);
            case AgilityTest:
                AgilityTests.add(rec);
            case JumpTest:
                JumpTests.add(rec);
            case SprintTest:
                SprintTests.add(rec);
                
        }
    }

    */
}
