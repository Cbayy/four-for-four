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
public class StudentList {
    
    private static StudentList list = null;
    
    ArrayList<Student> students;
    
    
    
    private StudentList(){
        this.students = new ArrayList<>();
        
    }
    
    public static StudentList getInstance() 
    { 
        if (list == null) 
            list = new StudentList(); 
  
        return list; 
    } 
    
    public Student returnStudent(int i){
        return students.get(i);
    }
}
