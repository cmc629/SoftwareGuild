/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.dvdlibrarymvc;

import com.thesoftwareguild.dvdlibrarymvc.daos.DvdLibraryDao;
import com.thesoftwareguild.dvdlibrarymvc.daos.NoteDao;
import com.thesoftwareguild.dvdlibrarymvc.models.Dvd;
import com.thesoftwareguild.dvdlibrarymvc.models.Note;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Christian Choi
 */
public class DvdLibraryTest {

    private DvdLibraryDao ddao;
    private NoteDao ndao;

    public DvdLibraryTest() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        ddao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);
        ndao = ctx.getBean("noteDao", NoteDao.class);

        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        template.execute("DELETE FROM note");
        template.execute("DELETE FROM dvd");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void addGetDvd() {

        Dvd dvd = new Dvd();
        dvd.setTitle("Inception");
        dvd.setReleaseDate(new Date(110, 7, 13));
        dvd.setMpaaRating("PG-13");
        dvd.setDirector("Christopher Nolan");
        dvd.setStudio("Warner Bros. Pictures");
        dvd.setNotes(new ArrayList<>());
        ddao.create(dvd);

        Dvd fromDb = ddao.get(dvd.getId());

        Assert.assertEquals(dvd.getTitle(), fromDb.getTitle());
        Assert.assertEquals(dvd.getReleaseDate(), fromDb.getReleaseDate());
        Assert.assertEquals(dvd.getMpaaRating(), fromDb.getMpaaRating());
        Assert.assertEquals(dvd.getDirector(), fromDb.getDirector());
        Assert.assertEquals(dvd.getStudio(), fromDb.getStudio());
        Assert.assertEquals(dvd.getNotes(), fromDb.getNotes());

    }

    @Test
    public void updateDvd() {

        //Create and add a new Dvd
        Dvd dvd = new Dvd();
        dvd.setTitle("Inception");
        dvd.setReleaseDate(new Date(110, 7, 13));
        dvd.setMpaaRating("PG-13");
        dvd.setDirector("Christopher Nolan");
        dvd.setStudio("Warner Bros. Pictures");
        dvd.setNotes(new ArrayList<>());
        ddao.create(dvd);

        Dvd updatedDvd = new Dvd();
        updatedDvd.setTitle("Inception");
        updatedDvd.setReleaseDate(new Date(110, 7, 13));
        updatedDvd.setMpaaRating("PG-13");
        updatedDvd.setDirector("Christopher Nolan");
        updatedDvd.setStudio("Warner Bros. Pictures");

        //create a note
        Note note = new Note();
        note.setContent("This is a comment.");
        note.setDvdId(dvd.getId());
        ndao.create(note);

        //Instantiate notes property for updated dvd and add in the new note
        updatedDvd.setNotes(new ArrayList<>());
        updatedDvd.getNotes().add(note);

        //update dvd
        ddao.update(updatedDvd);

        //Get the dvd id using the old dvd object
        Dvd fromDb = ddao.get(dvd.getId());

        //Test updatedDvd after the update
        Assert.assertEquals(fromDb.getTitle(), updatedDvd.getTitle());
        Assert.assertEquals(fromDb.getReleaseDate(), updatedDvd.getReleaseDate());
        Assert.assertEquals(fromDb.getMpaaRating(), updatedDvd.getMpaaRating());
        Assert.assertEquals(fromDb.getDirector(), updatedDvd.getDirector());
        Assert.assertEquals(fromDb.getStudio(), updatedDvd.getStudio());
        
        //Test to see if size of note lists are same
        Assert.assertEquals(fromDb.getNotes().size(), updatedDvd.getNotes().size());
        
        //Iterate through each element in list and check to see if content, ids, and dvd_ids match
        for (int idx = 0; idx < fromDb.getNotes().size(); idx++) {
            
            Assert.assertEquals(fromDb.getNotes().get(idx).getId(), updatedDvd.getNotes().get(idx).getId());
            Assert.assertEquals(fromDb.getNotes().get(idx).getContent(), updatedDvd.getNotes().get(idx).getContent());
            Assert.assertEquals(fromDb.getNotes().get(idx).getDvdId(), updatedDvd.getNotes().get(idx).getDvdId());
            
        }
        
    }
    
    @Test
    public void deleteDvd() {
        
        //Create and add a new Dvd
        Dvd dvd = new Dvd();
        dvd.setTitle("Inception");
        dvd.setReleaseDate(new Date(110, 7, 13));
        dvd.setMpaaRating("PG-13");
        dvd.setDirector("Christopher Nolan");
        dvd.setStudio("Warner Bros. Pictures");
        dvd.setNotes(new ArrayList<>());
        ddao.create(dvd);
        
        //Delete dvd
        ddao.delete(dvd.getId());
        
        //Test to see if list is empty
        Assert.assertTrue(ddao.list().isEmpty());
        
    }
    
    @Test
    public void testListDvds() {
        
        //Create and add two dvds
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Assert.assertEquals(dvd1.getId(), ddao.list().get(0).getId());
        Assert.assertEquals(dvd2.getId(), ddao.list().get(1).getId());
        
    }
    
    @Test
    public void testSearchAfterYear() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Jurassic World");
        dvd3.setReleaseDate(new Date(115, 5, 25));
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirector("Colin Trevorrow");
        dvd3.setStudio("Universal Studios");
        dvd3.setNotes(new ArrayList<>());
        ddao.create(dvd3);

        //Search after 2009. Contain three dvds from 2010, 2012, and 2015
        List<Dvd> result1 = ddao.searchNewerThanYear(2009);
        
        Assert.assertEquals(dvd1.getId(), result1.get(0).getId());
        Assert.assertEquals(dvd2.getId(), result1.get(1).getId());
        Assert.assertEquals(dvd3.getId(), result1.get(2).getId());
        
        //Search after 2010. Contain two dvds from 2012 and 2015
        List<Dvd> result2 = ddao.searchNewerThanYear(2010);
        
        Assert.assertEquals(dvd2.getId(), result2.get(0).getId());
        Assert.assertEquals(dvd3.getId(), result2.get(1).getId());
        
        //Search after 2014. Should only contain one dvd released in 2015
        List<Dvd> result3 = ddao.searchNewerThanYear(2014);
        
        Assert.assertEquals(dvd3.getId(), result3.get(0).getId());
        
        //Search after 2015. Result should be empty
        List<Dvd> result4 = ddao.searchNewerThanYear(2015);
        
        Assert.assertTrue(result4.isEmpty());
    }
    
    @Test
    public void testSearchByTitle() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Jurassic World");
        dvd3.setReleaseDate(new Date(115, 5, 25));
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirector("Colin Trevorrow");
        dvd3.setStudio("Universal Studios");
        dvd3.setNotes(new ArrayList<>());
        ddao.create(dvd3);
        
        List<Dvd> result = ddao.searchByTitle("Jurassic World");
        
        Assert.assertEquals(dvd3.getId(), result.get(0).getId());
        
    }
    
    @Test
    public void testSearchByRating() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Jurassic World");
        dvd3.setReleaseDate(new Date(115, 5, 25));
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirector("Colin Trevorrow");
        dvd3.setStudio("Universal Studios");
        dvd3.setNotes(new ArrayList<>());
        ddao.create(dvd3);
        
        List<Dvd> result = ddao.searchByMpaaRating("PG-13");
        
        Assert.assertEquals(dvd1.getId(), result.get(0).getId());
        Assert.assertEquals(dvd3.getId(), result.get(1).getId());
        
    }
    
    @Test
    public void testSearchByDirector() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Jurassic World");
        dvd3.setReleaseDate(new Date(115, 5, 25));
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirector("Colin Trevorrow");
        dvd3.setStudio("Universal Studios");
        dvd3.setNotes(new ArrayList<>());
        ddao.create(dvd3);
        
        List<Dvd> result = ddao.searchByDirector("Chris Miller");
        
        Assert.assertEquals(dvd2.getId(), result.get(0).getId());
        
    }
    
    @Test
    public void testSearchByStudio() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Jurassic World");
        dvd3.setReleaseDate(new Date(115, 5, 25));
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirector("Colin Trevorrow");
        dvd3.setStudio("Universal Studios");
        dvd3.setNotes(new ArrayList<>());
        ddao.create(dvd3);
        
        List<Dvd> result = ddao.searchByStudio("Universal Studios");
        
        Assert.assertEquals(dvd3.getId(), result.get(0).getId());
        
    }
    
    @Test
    public void testGetOldest() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("21 Jump Street");
        dvd1.setReleaseDate(new Date(112, 3, 12));
        dvd1.setMpaaRating("R");
        dvd1.setDirector("Chris Miller");
        dvd1.setStudio("Columbia Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("Inception");
        dvd2.setReleaseDate(new Date(110, 7, 13));
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirector("Christopher Nolan");
        dvd2.setStudio("Warner Bros. Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Jurassic World");
        dvd3.setReleaseDate(new Date(115, 5, 25));
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirector("Colin Trevorrow");
        dvd3.setStudio("Universal Studios");
        dvd3.setNotes(new ArrayList<>());
        ddao.create(dvd3);
        
        Assert.assertEquals(dvd2.getId(), ddao.findOldestDvd().getId());
        
    }
    
    @Test
    public void testGetNewest() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("21 Jump Street");
        dvd1.setReleaseDate(new Date(112, 3, 12));
        dvd1.setMpaaRating("R");
        dvd1.setDirector("Chris Miller");
        dvd1.setStudio("Columbia Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("Inception");
        dvd2.setReleaseDate(new Date(110, 7, 13));
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirector("Christopher Nolan");
        dvd2.setStudio("Warner Bros. Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Jurassic World");
        dvd3.setReleaseDate(new Date(115, 5, 25));
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirector("Colin Trevorrow");
        dvd3.setStudio("Universal Studios");
        dvd3.setNotes(new ArrayList<>());
        ddao.create(dvd3);
        
        Dvd newest = ddao.findNewestDvd();
        
        Assert.assertEquals(dvd3.getId(), ddao.findNewestDvd().getId());
        
    }
    
    @Test
    public void testAverageNotes() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Note note = new Note();
        note.setContent("This is a comment.");
        note.setDvdId(dvd1.getId());
        ndao.create(note);

        //Instantiate notes property for updated dvd and add in the new note
        dvd1.setNotes(new ArrayList<>());
        dvd1.getNotes().add(note);

        //update dvd
        ddao.update(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        Assert.assertEquals(0.5, ddao.getAverageNumberOfNotes());
        
    }
    
    @Test
    public void testAverageAge() {
        
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Inception");
        dvd1.setReleaseDate(new Date(110, 7, 13));
        dvd1.setMpaaRating("PG-13");
        dvd1.setDirector("Christopher Nolan");
        dvd1.setStudio("Warner Bros. Pictures");
        dvd1.setNotes(new ArrayList<>());
        ddao.create(dvd1);
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        ddao.create(dvd2);
        
        double DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        Date current = new Date();
        
        long dvdAge1 = ((current.getTime() - dvd1.getReleaseDate().getTime()));
        long dvdAge2 = ((current.getTime() - dvd2.getReleaseDate().getTime()));
        double total = dvdAge1 + dvdAge2;
        
        double expected = Math.floor(total/2.0/DAY_IN_MILLIS);
        
        Assert.assertEquals(expected, ddao.getAverageAge());
        
    }

}
