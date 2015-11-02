package com.thesoftwareguild.mavendvdlibrary.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.thesoftwareguild.mavendvdlibrary.dao.DvdLibraryDao;
import com.thesoftwareguild.mavendvdlibrary.model.Dvd;
import com.thesoftwareguild.mavendvdlibrary.model.Note;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class YanDVDLibraryTest {
    
    ApplicationContext context;
    private DvdLibraryDao dao;
    Date d1,d2,d3,d4,d5,d6;
    
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        d1= new Date(82, 11, 1);
        d2= new Date(85, 5, 3);
        d3= new Date(91, 4, 5);  
        d4= new Date(73, 0, 5);
        d5= new Date(76, 1, 7);
        d6= new Date(79, 6 , 6);

        dao = (DvdLibraryDao) context.getBean("dvdLibraryDao");//new DvdLibraryDaoLambdaImpl();
        dao.create(makeADVD("Rambo 1", d1, "R", "Who Knows?", "Rambo Studios",
                "Don't mess with Rambo"));
        dao.create(makeADVD("Rambo 2", d2, "R", "Who Knows?", "Rambo Studios",
                "You can take Rambo out of nam, but you can't take the nam...."));
        dao.create(makeADVD("Rambo 3", d3, "R", "Who Knows?", "Rambo Studios",
                "Rambo in Aghanastan helping Taliban"));
        
        dao.create(makeADVD("A New Hope", d4, "PG", "Not George Lucas", "Lucas Films",
                "Whiny kid becomes hero"));
        dao.create(makeADVD("Empire Strikes Back", d5, "PG-13", "Not George Lucas", "Lucas Films",
                "Vader is Luke's father"));
        dao.create(makeADVD("Return of the Jedi", d6, "PG", "Not George Lucas", "Lucas Films",
                "Everything is good"));
    }
    
    @After
    public void tearDown() {
    }

    public Dvd makeADVD(String title, Date releaseDate,String rating,  String director,
            String studio, String note1){
        Dvd d = new Dvd();
        d.setTitle(title);
        d.setReleaseDate(releaseDate);
        d.setMpaaRating(rating);
        d.setDirector(director);
        d.setStudio(studio);
        List<Note> notes = new ArrayList<>();
        d.setNotes(notes);
        
        
        Note n = new Note();
        n.setContent(note1);
        d.getNotes().add(n);
        return d;
    }
    
    @Test // 3 movies newer than 1980
    public void inLastNYears(){
        int res = dao.searchNewerThanYear(1980).size();
        int exp = 3;
        Assert.assertEquals(exp, res);
    }
    
    @Test
    public void listTest(){
        int res = dao.list().size();
        int exp = 6;
        Assert.assertEquals(exp, res);
    }
    
    @Test // 2 Rated PG movies
    public void searchByMPAARating(){
        int res = dao.searchByMpaaRating("PG").size();
        int exp = 2;
        Assert.assertEquals(exp, res);
    }
    
    @Test
    public void getAveAge(){
        double res = dao.getAverageAge();
        double exp = Math.abs((System.currentTimeMillis() - (d1.getTime() + d2.getTime()+d3.getTime()
                +d4.getTime()+d5.getTime()+d6.getTime())/6.0)/(1000.0*60.0*60.0*24.0));
        Assert.assertEquals(exp, res, .1);
    }
    
    @Test 
    public void findOldest(){
        Dvd res = dao.findOldestDvd();
        Date d = new Date();
        d.setYear(1973);
        Dvd exp = makeADVD("A New Hope", d, "PG", "Not George Lucas", "Lucas Films",
                "Whiny kid becomes hero");
        
        Assert.assertEquals(exp.getTitle(), res.getTitle());
    
    }
    
    @Test 
    public void findNewest(){
        Dvd res = dao.findNewestDvd();
        Date d = new Date();
        d.setYear(1991);
        Dvd exp = makeADVD("Rambo 3", d, "R", "Who Knows?", "Rambo Studios",
                "Rambo in Aghanastan helping Taliban");
        
        Assert.assertEquals(exp.getTitle(), res.getTitle());
       
    }
    @Test
    public void aveNotes(){
        double res = dao.getAverageNumberOfNotes();
        double exp = 1.0;
        Assert.assertEquals(exp, res, .0000001);
    }
    @Test // expected total notes = 12 over 6 records
    public void aveNotes2(){
        dao.get(0).getNotes().add(new Note());
        dao.get(0).getNotes().add(new Note());
        dao.get(0).getNotes().add(new Note());
        
        dao.get(1).getNotes().add(new Note());
        dao.get(2).getNotes().add(new Note());
        dao.get(1).getNotes().add(new Note());
        
        double res = dao.getAverageNumberOfNotes();
        double exp = 2.0;
        Assert.assertEquals(exp, res, .0000001);
    }
    
    @Test
    public void createTest(){
        Dvd a = new Dvd();
        Dvd res = dao.create(a);
        
        Assert.assertEquals(a, res);
        
    }
}
