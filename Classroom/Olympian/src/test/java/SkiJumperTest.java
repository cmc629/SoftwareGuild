/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thesoftwareguild.olympian.Event;
import com.thesoftwareguild.olympian.Olympian;
import com.thesoftwareguild.olympian.SkiJumpEvent;
import com.thesoftwareguild.olympian.SkiJumper;
import com.thesoftwareguild.olympian.SpeedSkatingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Christian Choi
 */
public class SkiJumperTest {
    
    ApplicationContext ctx;
    
    public SkiJumperTest() {
    }
    
    @Before
    public void setUp() {
        
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml"); //ClassPathXml is an interface of application context
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSkiJumper() {
        
        SkiJumper jumper = new SkiJumper();
        assertEquals(jumper.competeInEvent(), "SkiJump");
        
    }
    
    @Test
    public void testSkiJumpOlympian() {
        
        Event skiJumpEvent = new SkiJumpEvent();
        Olympian olympicSkiJumper = new Olympian(skiJumpEvent);
        
        olympicSkiJumper.competeInEvent();
        
    }
    
    @Test
    public void testSpeedSkater() {
        Event speedSkateEvent = new SpeedSkatingEvent();
        Olympian olympicSpeedSkater = new Olympian(speedSkateEvent);
        
        olympicSpeedSkater.competeInEvent();
    }
    
    
    @Test
    public void testBeans() {
        
        Olympian usaSkiJumper = (Olympian) ctx.getBean("usaSkiJumper");
        usaSkiJumper.competeInEvent();
        
        Olympian canadaSkiJumper = (Olympian) ctx.getBean("canadaSkiJumper");
        canadaSkiJumper.competeInEvent();
        
        Olympian usaSpeedSkater = (Olympian) ctx.getBean("usaSpeedSkater");
        usaSpeedSkater.competeInEvent();
        
        Olympian canadaSpeedSkater = (Olympian) ctx.getBean("canadaSpeedSkater");
        canadaSpeedSkater.competeInEvent();
        
    }
    
    
}
