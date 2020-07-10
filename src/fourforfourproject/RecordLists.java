/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourforfourproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class, holds all of the test types in an array list.
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
    
    ArrayList<Record> decisionMaking;
    ArrayList<Record> skillExecution;
    ArrayList<Record> support;
    ArrayList<Record> preventScoring;
    ArrayList<Record> totals;
    
    ArrayList<Record> PreS;
    ArrayList<Record> DS;
    ArrayList<Record> PostS;
    ArrayList<Record> LT;
    
    
    private RecordLists(){
        this.AgilityTests = new ArrayList<>();
        this.BeepTests = new ArrayList<>();
        this.JumpTests = new ArrayList<>();
        this.SprintTests = new ArrayList<>();
        
        this.FreeThrows = new ArrayList<>();
        this.Layups = new ArrayList<>();
        this.ThreePointers = new ArrayList<>();
        this.Passing = new ArrayList<>();

        this.decisionMaking = new ArrayList<>();
        this.skillExecution = new ArrayList<>();
        this.support = new ArrayList<>();
        this.preventScoring = new ArrayList<>();
        this.totals = new ArrayList<>();
        
        this.PreS = new ArrayList<>();
        this.DS = new ArrayList<>();
        this.PostS = new ArrayList<>();
        this.LT = new ArrayList<>();
        
    }
    
    public static RecordLists getInstance(){
        if(rbt == null){
            rbt = new RecordLists();
        }
        return rbt;
    }
    
}
