/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenflooringmastery.daos;

import com.thesoftwareguild.mavenflooringmastery.dtos.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class StateDaoImpl implements StateDao {
    
    private Map<String, State> states = new HashMap<>();
    private final String fileName = "DataTaxes.txt";

    public StateDaoImpl() {
    }
    
    @Override
    public Map<String, State> getStates() {
        return states;
    }
    
    @Override
    public void load() {
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            sc.nextLine();
            
            while (sc.hasNext()) {

                String[] properties = sc.nextLine().split(",");
                State state = new State();
                state.setStateName(properties[0]);
                state.setTaxRate(Double.parseDouble(properties[1]));

                states.put(state.getStateName(), state);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StateDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void save() {
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            out.print("State,TaxRate\n");
            for (State state : states.values()) {
                out.printf(String.format("%s,%.2f\n",
                        state.getStateName(),
                        state.getTaxRate()));
            }
            out.flush();
            out.close();
            
        } catch (IOException ex) {
            Logger.getLogger(StateDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public List<String> listCurrentStates() {
        List<String> stateList = new ArrayList<>();
        stateList.addAll(states.keySet());
        return stateList;
    }
     
    @Override
    public boolean isValidState(String stateName) {
        
        return states.containsKey(stateName);
    }
    
    @Override
    public void create(State state) {
        states.put(state.getStateName(), state);
    }
    
    @Override
    public State delete(State state) {
        State removedState = states.remove(state.getStateName());
        return removedState;
    }

    @Override
    public void update(State oldState, State newState) {
        states.remove(oldState.getStateName());
        create(newState);
    }
}
