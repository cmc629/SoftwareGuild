/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavendvdlibrary.dao;

import com.thesoftwareguild.mavendvdlibrary.model.Dvd;
import com.thesoftwareguild.mavendvdlibrary.model.Note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Christian Choi
 */
public class DvdLibraryTestsChristian {
    
    DvdLibraryDao dao;
    Dvd dvd, dvd2, dvd3;
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);
        
        dvd = new Dvd();
        dvd.setTitle("Inception");
        dvd.setReleaseDate(new Date(110, 7, 13));
        dvd.setMpaaRating("PG-13");
        dvd.setDirector("Christopher Nolan");
        dvd.setStudio("Warner Bros. Pictures");
        dvd.setNotes(new ArrayList<>());
        dao.create(dvd);
        
        dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        dvd2.setNotes(new ArrayList<>());
        dao.create(dvd2);
        
        dvd3 = new Dvd();
        dvd3.setTitle("Inception");
        dvd3.setReleaseDate(new Date(212, 2, 23));
        dvd3.setMpaaRating("R");
        dvd3.setDirector("Nis Colan");
        dvd3.setStudio("Warner Bros. Pictures");
        dvd3.setNotes(new ArrayList<>());
        dao.create(dvd3);
    }
    
    @Test
    public void createCheckIdTest() {
        assertEquals(0, (int) dvd.getId());
        assertEquals(1, (int) dvd2.getId());
        assertEquals(2, (int) dvd3.getId());
    }
    
    @Test
    public void deleteTest() {
        dao.delete(dvd.getId());
        
        Collection<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        expected.add(dvd3);
        
        assertEquals(expected, dao.list());
        
        dao.delete(dvd3.getId());
        expected.remove(dvd3);
        assertEquals(expected, dao.list());
        
        dao.delete(dvd2.getId());
        expected.remove(dvd2);
        assertEquals(expected, dao.list());
        
    }
    
    @Test
    public void getDvdByIdTest() {
        
        assertEquals(dvd, dao.get(0));
        assertEquals(dvd2, dao.get(1));
    }
    
    @Test
    public void listAllDvdsTest() {
        
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd);
        expected.add(dvd2);
        expected.add(dvd3);
        
        assertEquals(expected, dao.list());
        
    }
    
    @Test
    public void searchByTitleTest() {
        
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        
        assertEquals(expected, dao.searchByTitle("21 Jump Street"));
        
        List<Dvd> expected2 = new ArrayList<>();
        expected2.add(dvd);
        expected2.add(dvd3);
        
        assertEquals(expected2, dao.searchByTitle("Inception"));
        
    }
    
    @Test
    public void testUpdate() {
        Dvd dvd4 = new Dvd();
        dvd4.setId(dvd3.getId());
        dvd4.setTitle("Jurassic Park");
        dvd4.setDirector("Stephen Spielberg");
        dvd4.setMpaaRating("R");
        dvd4.setReleaseDate(new Date(93, 6, 9));
        assertEquals(dvd3, dao.get(dvd3.getId()));
        dao.update(dvd4);
        assertEquals(dvd4, dao.get(dvd3.getId()));
    }
    
    @Test
    public void testGet() {
        assertEquals(dvd, dao.get(0));
        assertEquals(dvd2, dao.get(1));
        assertEquals(dvd3, dao.get(2));
        assertEquals(null, dao.get(3));
    }
    
    @Test
    public void testSearchNewerThanYear() {
        List<Dvd> returned = dao.searchNewerThanYear(2011);
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        expected.add(dvd3);
        
        assertEquals(expected, returned);
    }
    
    @Test
    public void testSearchByMpaaRating() {
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        expected.add(dvd3);
        
        assertEquals(expected, dao.searchByMpaaRating("R"));
        assertTrue(dao.searchByMpaaRating("PG").isEmpty());
    }
    
    @Test
    public void testSearchByDirector() {
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        assertEquals(expected, dao.searchByDirector("Chris Miller"));
    }
    
    @Test
    public void testSearchByStudio() {
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd);
        expected.add(dvd3);
        assertEquals(expected, dao.searchByStudio("Warner Bros. Pictures"));
    }
    
    @Test
    public void testGetAverageAge() {
        
        dao.delete(dvd3.getId());
        
        double DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        Date current = new Date();
        
        long dvdAge1 = ((current.getTime() - dvd.getReleaseDate().getTime()));
        long dvdAge2 = ((current.getTime() - dvd2.getReleaseDate().getTime()));
        double total = dvdAge1 + dvdAge2;
        double expected = total/2.0/DAY_IN_MILLIS;
        assertEquals(expected, dao.getAverageAge(), .01);
        
    }
    
    @Test
    public void testGetAverageNumberOfNotes() {
        Note newNote = new Note();
        newNote.setContent("Rawks");
        dvd.getNotes().add(newNote);
        assertEquals(.3, dao.getAverageNumberOfNotes(), .1);
    }
    
    @Test
    public void testFindNewestDvd() {
        assertEquals(dvd3, dao.findNewestDvd());
    }
    
    @Test
    public void testFindOldestDvd() {
        assertEquals(dvd, dao.findOldestDvd());
    }
    
    @Test
    public void testSearchByTitle() {
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd);
        expected.add(dvd3);
        
        assertEquals(expected, dao.searchByTitle("Inception"));
    }
    
}