/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.olympian;

/**
 *
 * @author Christian Choi
 */
public class SkiJumpEvent implements Event {

    @Override
    public String compete() {
        
        //If we weren't using AOP, we would go to each event and type the comments
        //OlympicOfficial official = new OlympicOfficial();
        //official.inspectEquipment();
        System.out.println("Ski jump event. I'm jumping.");
        System.out.println();
        //official.testForPED();
        return "SkiJump";
        
    }
    
}
