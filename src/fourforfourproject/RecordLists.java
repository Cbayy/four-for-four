/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
public class RecordLists {
    
    private static RecordLists rbt = null;
    
    
    ArrayList<ArrayList<Record>> all = new ArrayList<>();
 
    
    
    ArrayList<Record> BeepTests; // = new ArrayList<>();
    ArrayList<Record> AgilityTests; // = new ArrayList<>();
    ArrayList<Record> JumpTests; // = new ArrayList<>();
    ArrayList<Record> SprintTests; // = new ArrayList<>();
    
    ArrayList<Record> FreeThrows;
    ArrayList<Record> Layups;
    ArrayList<Record> ThreePointers;
    ArrayList<Record> Passing;
    
    ArrayList<Record> D1v1;
    ArrayList<Record> Dpos;
    ArrayList<Record> A1v1;
    ArrayList<Record> Apos;
    
    
    
    private RecordLists(){
        this.AgilityTests = new ArrayList<>();
        this.BeepTests = new ArrayList<>();
        this.JumpTests = new ArrayList<>();
        this.SprintTests = new ArrayList<>();
        
        this.FreeThrows = new ArrayList<>();
        this.Layups = new ArrayList<>();
        this.ThreePointers = new ArrayList<>();
        this.Passing = new ArrayList<>();

        this.D1v1 = new ArrayList<>();
        this.Dpos = new ArrayList<>();
        this.A1v1 = new ArrayList<>();
        this.Apos = new ArrayList<>();
        
    }
    
    public static RecordLists getInstance(){
        if(rbt == null){
            rbt = new RecordLists();
        }
        return rbt;
    }
    
}
