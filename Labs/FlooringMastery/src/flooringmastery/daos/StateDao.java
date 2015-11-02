/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.daos;

import flooringmastery.dtos.State;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Choi
 */
public interface StateDao {

    public void create(State state);

    public Map<String, State> getStates();

    public boolean isValidState(String stateName);

    public List<String> listCurrentStates();

    public State delete(State state);
    
}
