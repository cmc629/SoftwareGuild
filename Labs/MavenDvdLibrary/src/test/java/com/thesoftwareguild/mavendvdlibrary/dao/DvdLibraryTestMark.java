package com.thesoftwareguild.mavendvdlibrary.dao;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.thesoftwareguild.mavendvdlibrary.dao.DvdLibraryDao;
import com.thesoftwareguild.mavendvdlibrary.model.Dvd;
import com.thesoftwareguild.mavendvdlibrary.model.Note;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DvdLibraryTestMark {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    DvdLibraryDao dvdLibraryDao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);;    
    Dvd dvd1, dvd2, dvd3, dvd4, dvd5;
    SimpleDateFormat sdf;
    Date date1, date2, date3, date4, date4a, date5;
    Note note1a, note1b, note2a, note2b, note3a, note3b, note4a, note4b, note5a, note5b;

    @Before
    public void setUp() throws ParseException {
        while (!dvdLibraryDao.list().isEmpty()) {
            dvdLibraryDao.delete(dvdLibraryDao.list().get(0).getId());
        }
        
        sdf = new SimpleDateFormat("yyyy");
        date1 = sdf.parse("1999");
        date2 = sdf.parse("2000");
        date3 = sdf.parse("2001");
        date4 = sdf.parse("2002");
        date4a = sdf.parse("2001");
        date5 = sdf.parse("2003");
        
        note1a = new Note();
        note1b = new Note();
        note2a = new Note();
        note2b = new Note();
        note3a = new Note();
        note3b = new Note();
        note4a = new Note();
        note4b = new Note();
        note5a = new Note();
        note5b = new Note();
        
        note1a.setContent("Note1a");
        note1b.setContent("Note1b");
        note2a.setContent("Note2a");
        note2b.setContent("Note2b");
        note3a.setContent("Note3a");
        note3b.setContent("Note3b"); 

        note4a.setContent("Note4a");
        note4b.setContent("Note4b");
        note5a.setContent("Note5a");
        note5b.setContent("Note5b");
        
        dvd1 = new Dvd();
        dvd1.setNotes(new ArrayList<>());
        dvd2 = new Dvd();
        dvd2.setNotes(new ArrayList<>());
        dvd3 = new Dvd();
        dvd3.setNotes(new ArrayList<>());
        dvd4 = new Dvd();
        dvd4.setNotes(new ArrayList<>());
        dvd5 = new Dvd();
        dvd5.setNotes(new ArrayList<>());
        
        dvd1.setTitle("Title1");
        dvd1.setReleaseDate(date1);
        dvd1.setId(1);
        dvd1.setDirector("Director1");
        dvd1.setStudio("Studio1");
        dvd1.setMpaaRating("Rating1");
        dvd1.setUserRating(1);
        dvd1.getNotes().add(note1a);
        dvd1.getNotes().add(note1b);
        
        
        dvd2.setTitle("Title2");
        dvd2.setReleaseDate(date2);
        dvd2.setId(2);
        dvd2.setDirector("Director2");
        dvd2.setStudio("Studio2");
        dvd2.setMpaaRating("Rating2");
        dvd2.setUserRating(2);
        dvd2.getNotes().add(note2a);
        dvd2.getNotes().add(note2b);
        
        
        dvd3.setTitle("Title3");
        dvd3.setReleaseDate(date3);
        dvd3.setId(3);
        dvd3.setDirector("Director3");
        dvd3.setStudio("Studio3");
        dvd3.setMpaaRating("Rating3");
        dvd3.setUserRating(3);
        dvd3.getNotes().add(note3a);
        dvd3.getNotes().add(note3b);
        
        dvd4.setId(4);
        dvd4.setTitle("Title4");
        dvd4.setReleaseDate(date4);
        dvd4.setDirector("Director4");
        dvd4.setStudio("Studio4");
        dvd4.setMpaaRating("Rating4");
        dvd4.setUserRating(4);
        
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of create method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testCreate1() {
        Dvd result = dvdLibraryDao.create(dvd1);
        Dvd expResult = dvd1;
        assertEquals(expResult, result);

        
    }
    
    @Test
    public void testCreate3() {
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        int result = dvdLibraryDao.list().size();
        int expResult = 3;
        
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        

        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        dvdLibraryDao.delete(dvd3.getId());
        
        int result = dvdLibraryDao.list().size();
        int expResult = 2;
        
        Assert.assertEquals(expResult, result);

        
    }
    
    
    @Test
    public void testDelete2() {
        
        
        
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.delete(dvd2.getId());
        
        int result = dvdLibraryDao.list().size();
        int expResult = 0;
        
        Assert.assertEquals(expResult, result);
    }


    /**
     * Test of update method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        dvdLibraryDao.create(dvd4);
        
        dvdLibraryDao.get(dvd4.getId()).setTitle("Title4Edit");
        
        dvdLibraryDao.update(dvd4);
        
        String result = dvdLibraryDao.get(dvd4.getId()).getTitle();
        String expResult = "Title4Edit";
        
        Assert.assertEquals(expResult, result);

    }
    
    @Test
    public void testUpdate2() {
        
        
        dvdLibraryDao.create(dvd4);
        
        dvdLibraryDao.get(dvd4.getId()).setMpaaRating("Rating4Edit");
        dvdLibraryDao.update(dvd4);
        
        String result = dvdLibraryDao.get(dvd4.getId()).getMpaaRating();
        String expResult = "Rating4Edit";
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdate3() {
        
        
        dvdLibraryDao.create(dvd4);
        
        dvdLibraryDao.get(dvd4.getId()).setDirector("Director4Edit");
        dvdLibraryDao.update(dvd4);
        
        String result = dvdLibraryDao.get(dvd4.getId()).getDirector();
        String expResult = "Director4Edit";
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdate4() {
        
        
        
        dvdLibraryDao.create(dvd4);
        
        dvdLibraryDao.get(dvd4.getId()).setStudio("Studio4Edit");
        dvdLibraryDao.update(dvd4);
        
        String result = dvdLibraryDao.get(dvd4.getId()).getStudio();
        String expResult = "Studio4Edit";
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testUpdate5() {
        
        
        
        dvdLibraryDao.create(dvd4);
        
        dvdLibraryDao.get(dvd4.getId()).setUserRating(5);
        dvdLibraryDao.update(dvd4);
        
        int result = dvdLibraryDao.get(dvd4.getId()).getUserRating();
        int expResult = 5;
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdate6() {
        
        
        
        dvdLibraryDao.create(dvd4);
        
        dvdLibraryDao.get(dvd4.getId()).setReleaseDate(date4a);
        dvdLibraryDao.update(dvd4);
        
        Date result = dvdLibraryDao.get(dvd4.getId()).getReleaseDate();
        Date expResult = date4a;
        
        Assert.assertEquals(expResult, result);
    }


    /**
     * Test of get method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGet() {
        System.out.println("get");

        

        dvdLibraryDao.create(dvd1);
        
        Dvd result = dvdLibraryDao.get(dvd1.getId());
        Dvd expResult = dvd1;
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testGet2() {
        

        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        Dvd result = dvdLibraryDao.get(dvd2.getId());
        Dvd expResult = dvd2;
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testGet3() {
        

        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        Dvd result = dvdLibraryDao.get(dvd3.getId());
        Dvd expResult = dvd3;
        
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of list method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testList() {
        System.out.println("list");
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.list();
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        expResult.add(dvd2);
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);

    }
    
    @Test
    public void testList2() {
        System.out.println("list");
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        int result = dvdLibraryDao.list().size();
        int expResult = 3;
        
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testList3() {
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        dvdLibraryDao.delete(dvd2.getId());
        
        List<Dvd> result = dvdLibraryDao.list();
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd1);
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testList4() {
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        dvdLibraryDao.delete(dvd2.getId());
        
        int result = dvdLibraryDao.list().size();
        int expResult = 2;
        
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of searchByTitle method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testSearchByTitle() {
        System.out.println("searchByTitle");

        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.get(dvd2.getId()).setTitle("Title1");
        dvdLibraryDao.update(dvd2);
        
        String title = "Title1";
        
        List<Dvd> result = dvdLibraryDao.searchByTitle(title);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSearchByTitle2() {
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        String title = "Title4";
        
        List<Dvd> result = dvdLibraryDao.searchByTitle(title);
        List<Dvd> expResult = new ArrayList<>();
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testSearchByTitle3() {
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        String title = "Title3";
        
        List<Dvd> result = dvdLibraryDao.searchByTitle(title);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);
        
        
    }

    /**
     * Test of searchNewerThanYear method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testSearchNewerThanYear() {
        System.out.println("searchNewerThanYear");

        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        int year = 1999;
        List<Dvd> result = dvdLibraryDao.searchNewerThanYear(year);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd2);
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testSearchNewerThanYear2() {
        System.out.println("searchNewerThanYear");

        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        int year = 2000;
        List<Dvd> result = dvdLibraryDao.searchNewerThanYear(year);
        List<Dvd> expResult = new ArrayList<>();
        
        
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSearchNewerThanYear3() {
        System.out.println("searchNewerThanYear");

        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        int year = 2001;
        List<Dvd> result = dvdLibraryDao.searchNewerThanYear(year);
        List<Dvd> expResult = new ArrayList<>();
        
        
        Assert.assertEquals(expResult, result);
        
    }

    /**
     * Test of searchByMpaaRating method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testSearchByMpaaRating() {
        System.out.println("searchByMpaaRating");

        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        dvd2.setMpaaRating("Rating1");
        dvdLibraryDao.update(dvd2);
        
        String rating = "Rating1";

        List<Dvd> result = dvdLibraryDao.searchByMpaaRating(rating);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        expResult.add(dvd2);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSearchByMpaaRating2() {
        System.out.println("searchByMpaaRating");

        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        String rating = "Rating2";

        List<Dvd> result = dvdLibraryDao.searchByMpaaRating(rating);
        List<Dvd> expResult = new ArrayList<>();

        expResult.add(dvd2);
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSearchByMpaaRating3() {
        System.out.println("searchByMpaaRating");

        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        String rating = "Rating3";

        List<Dvd> result = dvdLibraryDao.searchByMpaaRating(rating);
        List<Dvd> expResult = new ArrayList<>();

        expResult.add(dvd3);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of searchByDirector method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testSearchByDirector() {
        System.out.println("searchByDirector");
 
        
        String director = "Director2";
        dvdLibraryDao.create(dvd1);
        dvd1.setDirector("Director2");
        dvdLibraryDao.update(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByDirector(director);
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd1);
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);

        
    }
    
    @Test
    public void testSearchByDirector2() {
        System.out.println("searchByDirector");
 
        
        String director = "Director1";
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByDirector(director);
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd1);
        
        Assert.assertEquals(expResult, result);

        
    }
    
    
    @Test
    public void testSearchByDirector3() {
        System.out.println("searchByDirector");
 
        
        String director = "Director2";
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByDirector(director);
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);

        
    }
    
    
    @Test
    public void testSearchByDirector4() {
        System.out.println("searchByDirector");
 
        
        String director = "Director3";
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByDirector(director);
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);

        
    }

    /**
     * Test of searchByStudio method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testSearchByStudio() {
        System.out.println("searchByStudio");

        
        String studio = "Studio3";
        
        dvd1.setStudio("Studio3");
        dvd2.setStudio("Studio3");
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByStudio(studio);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        expResult.add(dvd2);
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);

    }
    
    @Test
    public void testSearchByStudio2() {
        System.out.println("searchByStudio");

        
        String studio = "Studio1";
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByStudio(studio);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        
        Assert.assertEquals(expResult, result);

    }
    
    
    @Test
    public void testSearchByStudio3() {
        System.out.println("searchByStudio");

        
        String studio = "Studio2";
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByStudio(studio);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);

    }
    
    
    @Test
    public void testSearchByStudio4() {
        System.out.println("searchByStudio");

        
        String studio = "Studio3";
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        List<Dvd> result = dvdLibraryDao.searchByStudio(studio);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of getAverageAge method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGetAverageAge() {
        System.out.println("getAverageAge");
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        double result = Math.floor(dvdLibraryDao.getAverageAge());
        double expResult = dvd1.getReleaseDate().toInstant().getEpochSecond();
        expResult += dvd2.getReleaseDate().toInstant().getEpochSecond();
        expResult += dvd3.getReleaseDate().toInstant().getEpochSecond();
        expResult /= 3;
        expResult = new Date().toInstant().getEpochSecond() - expResult;
        expResult /= (3600 * 24);
        expResult = Math.floor(expResult);
        
        Assert.assertEquals(expResult, result, 0);
        
    }
    
    
    @Test
    public void testGetAverageAge2() {
        System.out.println("getAverageAge");
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);

        double result = Math.floor(dvdLibraryDao.getAverageAge());
        double expResult = dvd1.getReleaseDate().toInstant().getEpochSecond();
        expResult += dvd2.getReleaseDate().toInstant().getEpochSecond();
        expResult /= 2;
        expResult = new Date().toInstant().getEpochSecond() - expResult;
        expResult /= (3600 * 24);
        expResult = Math.floor(expResult);
        
        Assert.assertEquals(expResult, result, 0);
        
    }
    
    @Test
    public void testGetAverageAge3() {
        System.out.println("getAverageAge");
        
        
        dvdLibraryDao.create(dvd1);

        double result = Math.floor(dvdLibraryDao.getAverageAge());
        double expResult = dvd1.getReleaseDate().toInstant().getEpochSecond();
        expResult /= 1;
        expResult = new Date().toInstant().getEpochSecond() - expResult;
        expResult /= (3600 * 24);
        expResult = Math.floor(expResult);
        
        Assert.assertEquals(expResult, result, 0);
        
    }

    /**
     * Test of getAverageNumberOfNotes method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGetAverageNumberOfNotes() {
        System.out.println("getAverageNumberOfNotes");
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);

        double result = dvdLibraryDao.getAverageNumberOfNotes();
        double expResult = 2;
        
        Assert.assertEquals(expResult, result, 0);

    }
    
    @Test
    public void testGetAverageNumberOfNotes2() {
        System.out.println("getAverageNumberOfNotes");
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvd3.getNotes().add(note4a);
        dvd3.getNotes().add(note4b);
        dvdLibraryDao.create(dvd3);

        double result = dvdLibraryDao.getAverageNumberOfNotes();
        double expResult = 2.6666666;
        
        Assert.assertEquals(expResult, result, 0.001);

    }
    
    @Test
    public void testGetAverageNumberOfNotes3() {
        System.out.println("getAverageNumberOfNotes");
        
        
        dvdLibraryDao.create(dvd1);
        dvd2.getNotes().add(note5a);
        dvd2.getNotes().add(note5b);
        dvdLibraryDao.create(dvd2);
        dvd3.getNotes().add(note4a);
        dvd3.getNotes().add(note4b);
        dvdLibraryDao.create(dvd3);

        double result = dvdLibraryDao.getAverageNumberOfNotes();
        double expResult = 3.3333;
        
        Assert.assertEquals(expResult, result, 0.001);

    }
    
    @Test
    public void testGetAverageNumberOfNotes4() {
        System.out.println("getAverageNumberOfNotes");
        
        
        dvdLibraryDao.create(dvd4);


        double result = dvdLibraryDao.getAverageNumberOfNotes();
        double expResult = 0;
        
        Assert.assertEquals(expResult, result, 0);

    }
    
    @Test
    public void testGetAverageNumberOfNotes5() {
        System.out.println("getAverageNumberOfNotes");
        
        
        dvdLibraryDao.create(dvd1);

        double result = dvdLibraryDao.getAverageNumberOfNotes();
        double expResult = 2;
        
        Assert.assertEquals(expResult, result, 0);

    }

    /**
     * Test of findNewestDvd method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testFindNewestDvd() {
        System.out.println("findNewestDvd");
        

        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        Dvd result = dvdLibraryDao.findNewestDvd();
        Dvd expResult = dvd3;
        
        Assert.assertEquals(expResult, result);

    }
    
       @Test
    public void testFindNewestDvd2() {
        System.out.println("findNewestDvd");
        

        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        
        Dvd result = dvdLibraryDao.findNewestDvd();
        Dvd expResult = dvd2;
        
        Assert.assertEquals(expResult, result);

    }
    
       @Test
    public void testFindNewestDvd3() {
        System.out.println("findNewestDvd");
        

        dvdLibraryDao.create(dvd1);
        
        Dvd result = dvdLibraryDao.findNewestDvd();
        Dvd expResult = dvd1;
        
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of findOldestDvd method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testFindOldestDvd() {
        System.out.println("findOldestDvd");
        
        
        dvdLibraryDao.create(dvd1);
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        Dvd result = dvdLibraryDao.findOldestDvd();
        Dvd expResult = dvd1;
        
        Assert.assertEquals(expResult, result);
        
    }
    
    
    @Test
    public void testFindOldestDvd2() {
        System.out.println("findOldestDvd");
        
        
        dvdLibraryDao.create(dvd2);
        dvdLibraryDao.create(dvd3);
        
        Dvd result = dvdLibraryDao.findOldestDvd();
        Dvd expResult = dvd2;
        
        Assert.assertEquals(expResult, result);
        
    }
    
    
    @Test
    public void testFindOldestDvd3() {
        System.out.println("findOldestDvd");
        
        
        dvdLibraryDao.create(dvd3);
        
        Dvd result = dvdLibraryDao.findOldestDvd();
        Dvd expResult = dvd3;
        
        Assert.assertEquals(expResult, result);
        
    }
}