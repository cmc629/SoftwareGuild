package com.thesoftwareguild.mavendvdlibrary.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
public class DvdTestsSena {
    
    DvdLibraryDao dvdDao;
    Dvd dvd1, dvd2, dvd3, dvd4, dvd5;
    SimpleDateFormat sdf;
    Date date1, date2, date3, date4, date4a, date5;
    Note note1a, note1b, note2a, note2b, note3a, note3b, note4a, note4b, note5a, note5b;
    
    public DvdTestsSena() {
        
        
    }
    
    @Before
    public void setUp() throws ParseException {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        dvdDao = ctx.getBean("dvdLibraryDao", DvdLibraryDao.class);
        
        /**
         * NOTE: These tests will only pass if "mode.txt" is set to "Test"!!!!!
         * Otherwise, mode.txt should be set to "Prod"
         */
        
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
        List<Note> noteList1 = new ArrayList<>();
        noteList1.add(note1a);
        noteList1.add(note2a);
        
        List<Note> noteList2 = new ArrayList<>();
        noteList2.add(note2a);
        noteList2.add(note2b);
        
        List<Note> noteList3 = new ArrayList<>();
        noteList3.add(note3a);
        noteList3.add(note3b);

        note4a.setContent("Note4a");
        note4b.setContent("Note4b");
        note5a.setContent("Note5a");
        note5b.setContent("Note5b");
        
        dvd1 = new Dvd();
        dvd2 = new Dvd();
        dvd3 = new Dvd();
        dvd4 = new Dvd();
        dvd5 = new Dvd();
        
        dvd1.setTitle("Title1");
        dvd1.setReleaseDate(date1);
        dvd1.setId(1);
        dvd1.setDirector("Director1");
        dvd1.setStudio("Studio1");
        dvd1.setMpaaRating("Rating1");
        dvd1.setUserRating(1);
        dvd1.setNotes(noteList1);
        
        
        dvd2.setTitle("Title2");
        dvd2.setReleaseDate(date2);
        dvd2.setId(2);
        dvd2.setDirector("Director2");
        dvd2.setStudio("Studio2");
        dvd2.setMpaaRating("Rating2");
        dvd2.setUserRating(2);
        dvd2.setNotes(noteList2);
        
        
        dvd3.setTitle("Title3");
        dvd3.setReleaseDate(date3);
        dvd3.setId(3);
        dvd3.setDirector("Director3");
        dvd3.setStudio("Studio3");
        dvd3.setMpaaRating("Rating3");
        dvd3.setUserRating(3);
        dvd3.setNotes(noteList3);
        
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
       
//        PrintWriter writer = null;
//        try {
//            writer = new PrintWriter(new FileWriter("input.txt"));
//            writer.print("");
//            writer.flush();
//            writer.close();
//        } catch (IOException ex) {
//            Logger.getLogger(DvdTestsSena.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }


    /**
     * Test of create method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testCreate1() {
        System.out.println("create");
        

        Dvd result = dvdDao.create(dvd1);
        Dvd expResult = dvd1;
        assertEquals(expResult, result);

        
    }
    
    @Test
    public void testCreate2() {
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        int result = dvdDao.list().size();
        int expResult = 3;
        
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");


        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        dvdDao.delete(dvd3.getId());
        
        int result = dvdDao.list().size();
        int expResult = 2;
        
        Assert.assertEquals(expResult, result);

        
    }
    
    
    @Test
    public void testDelete2() {
        
        
        dvdDao.create(dvd2);
        dvdDao.delete(dvd2.getId());
        
        int result = dvdDao.list().size();
        int expResult = 0;
        
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        dvdDao.create(dvd4);
        
        dvdDao.get(dvd4.getId()).setTitle("Title4Edit");
        
        dvdDao.update(dvd4);
        
        String result = dvdDao.get(dvd4.getId()).getTitle();
        String expResult = "Title4Edit";
        
        Assert.assertEquals(expResult, result);

    }
    
    @Test
    public void testUpdate2() {
        
        dvdDao.create(dvd4);
        
        dvdDao.get(dvd4.getId()).setMpaaRating("Rating4Edit");
        dvdDao.update(dvd4);
        
        String result = dvdDao.get(dvd4.getId()).getMpaaRating();
        String expResult = "Rating4Edit";
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdate3() {
        
        dvdDao.create(dvd4);
        
        dvdDao.get(dvd4.getId()).setDirector("Director4Edit");
        dvdDao.update(dvd4);
        
        String result = dvdDao.get(dvd4.getId()).getDirector();
        String expResult = "Director4Edit";
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdate4() {
        
        
        dvdDao.create(dvd4);
        
        dvdDao.get(dvd4.getId()).setStudio("Studio4Edit");
        dvdDao.update(dvd4);
        
        String result = dvdDao.get(dvd4.getId()).getStudio();
        String expResult = "Studio4Edit";
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testUpdate5() {
        
        
        dvdDao.create(dvd4);
        
        dvdDao.get(dvd4.getId()).setUserRating(5);
        dvdDao.update(dvd4);
        
        int result = dvdDao.get(dvd4.getId()).getUserRating();
        int expResult = 5;
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdate6() {
        
        dvdDao.create(dvd4);
        
        dvdDao.get(dvd4.getId()).setReleaseDate(date4a);
        dvdDao.update(dvd4);
        
        Date result = dvdDao.get(dvd4.getId()).getReleaseDate();
        Date expResult = date4a;
        
        Assert.assertEquals(expResult, result);
    }


    /**
     * Test of get method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGet() {
        System.out.println("get");

        dvdDao.create(dvd1);
        
        Dvd result = dvdDao.get(dvd1.getId());
        Dvd expResult = dvd1;
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testGet2() {

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        Dvd result = dvdDao.get(dvd2.getId());
        Dvd expResult = dvd2;
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testGet3() {

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        Dvd result = dvdDao.get(dvd3.getId());
        Dvd expResult = dvd3;
        
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of list method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testList() {
        System.out.println("list");

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.list();
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        expResult.add(dvd2);
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);

    }
    
    @Test
    public void testList2() {
        System.out.println("list");

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        int result = dvdDao.list().size();
        int expResult = 3;
        
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testList3() {

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        dvdDao.delete(dvd2.getId());
        
        List<Dvd> result = dvdDao.list();
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd1);
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testList4() {
        

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        dvdDao.delete(dvd2.getId());
        
        int result = dvdDao.list().size();
        int expResult = 2;
        
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of searchByTitle method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testSearchByTitle() {
        System.out.println("searchByTitle");


        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.get(dvd2.getId()).setTitle("Title1");
        dvdDao.update(dvd2);
        
        String title = "Title1";
        
        List<Dvd> result = dvdDao.searchByTitle(title);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSearchByTitle2() {
        

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        String title = "Title4";
        
        List<Dvd> result = dvdDao.searchByTitle(title);
        List<Dvd> expResult = new ArrayList<>();
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void testSearchByTitle3() {

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        String title = "Title3";
        
        List<Dvd> result = dvdDao.searchByTitle(title);
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

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        int year = 1999;
        List<Dvd> result = dvdDao.searchNewerThanYear(year);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd2);
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSearchNewerThanYear2() {
        System.out.println("searchNewerThanYear");


        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        int year = 2000;
        List<Dvd> result = dvdDao.searchNewerThanYear(year);
        List<Dvd> expResult = new ArrayList<>();
        
        
        
        expResult.add(dvd3);
        
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSearchNewerThanYear3() {
        System.out.println("searchNewerThanYear");


        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        int year = 2001;
        List<Dvd> result = dvdDao.searchNewerThanYear(year);
        List<Dvd> expResult = new ArrayList<>();

        
        Assert.assertEquals(expResult, result);
        
    }

    /**
     * Test of searchByMpaaRating method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testSearchByMpaaRating() {
        System.out.println("searchByMpaaRating");


        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        dvd2.setMpaaRating("Rating1");
        dvdDao.update(dvd2);
        
        String rating = "Rating1";

        List<Dvd> result = dvdDao.searchByMpaaRating(rating);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        expResult.add(dvd2);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSearchByMpaaRating2() {
        System.out.println("searchByMpaaRating");


        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        String rating = "Rating2";

        List<Dvd> result = dvdDao.searchByMpaaRating(rating);
        List<Dvd> expResult = new ArrayList<>();

        expResult.add(dvd2);
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSearchByMpaaRating3() {
        System.out.println("searchByMpaaRating");

        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        String rating = "Rating3";

        List<Dvd> result = dvdDao.searchByMpaaRating(rating);
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
        dvdDao.create(dvd1);
        dvd1.setDirector("Director2");
        dvdDao.update(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByDirector(director);
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd1);
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);

        
    }
    
    @Test
    public void testSearchByDirector2() {
        System.out.println("searchByDirector");
 
        String director = "Director1";
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByDirector(director);
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd1);
        
        Assert.assertEquals(expResult, result);

        
    }
    
    
    @Test
    public void testSearchByDirector3() {
        System.out.println("searchByDirector");
 
        String director = "Director2";
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByDirector(director);
        List<Dvd> expResult = new ArrayList<>();
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);

        
    }
    
    
    @Test
    public void testSearchByDirector4() {
        System.out.println("searchByDirector");
 
        String director = "Director3";
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByDirector(director);
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
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByStudio(studio);
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
        
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByStudio(studio);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd1);
        
        Assert.assertEquals(expResult, result);

    }
    
    
    @Test
    public void testSearchByStudio3() {
        System.out.println("searchByStudio");

        String studio = "Studio2";
        
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByStudio(studio);
        List<Dvd> expResult = new ArrayList<>();
        
        expResult.add(dvd2);
        
        Assert.assertEquals(expResult, result);

    }
    
    
    @Test
    public void testSearchByStudio4() {
        System.out.println("searchByStudio");

        String studio = "Studio3";
        
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        List<Dvd> result = dvdDao.searchByStudio(studio);
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
        
        Date date = new Date();
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        double result = dvdDao.getAverageAge();
        double expResult = Long.valueOf(((date.getTime() - dvd1.getReleaseDate().getTime()) +
                (date.getTime() - dvd2.getReleaseDate().getTime()) +
                (date.getTime() - dvd3.getReleaseDate().getTime()))/3).doubleValue()/(1000*60*60*24);
        
        Assert.assertEquals(expResult, result, 0.01);
        
    }
    
    
    @Test
    public void testGetAverageAge2() {
        System.out.println("getAverageAge");
        Date date = new Date();
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);

        double result = dvdDao.getAverageAge();
        double expResult = Long.valueOf(((date.getTime() - dvd1.getReleaseDate().getTime()) + (date.getTime() - dvd2.getReleaseDate().getTime()))/2).doubleValue()
                /(1000*60*60*24);
        
        Assert.assertEquals(expResult, result, 0.01);
        
    }
    
    @Test
    public void testGetAverageAge3() {
        System.out.println("getAverageAge");
        
        Date date = new Date();
        
        dvdDao.create(dvd1);

        double result = dvdDao.getAverageAge();
        double expResult = Long.valueOf(date.getTime() - dvd1.getReleaseDate().getTime()).doubleValue()/(1000*60*60*24);
        
        Assert.assertEquals(expResult, result, 0.01);
        
    }

    /**
     * Test of getAverageNumberOfNotes method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testGetAverageNumberOfNotes() {
        System.out.println("getAverageNumberOfNotes");
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);

        double result = dvdDao.getAverageNumberOfNotes();
        double expResult = 2;
        
        Assert.assertEquals(expResult, result, 0);

    }
    
    @Test
    public void testGetAverageNumberOfNotes2() {
        System.out.println("getAverageNumberOfNotes");
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvd3.getNotes().add(note4a);
        dvd3.getNotes().add(note4b);
        dvdDao.create(dvd3);

        double result = dvdDao.getAverageNumberOfNotes();
        double expResult = 2.6666666;
        
        Assert.assertEquals(expResult, result, 0.001);

    }
    
    @Test
    public void testGetAverageNumberOfNotes3() {
        System.out.println("getAverageNumberOfNotes");
        
        dvdDao.create(dvd1);
        dvd2.getNotes().add(note5a);
        dvd2.getNotes().add(note5b);
        dvdDao.create(dvd2);
        dvd3.getNotes().add(note4a);
        dvd3.getNotes().add(note4b);
        dvdDao.create(dvd3);

        double result = dvdDao.getAverageNumberOfNotes();
        double expResult = 3.3333;
        
        Assert.assertEquals(expResult, result, 0.001);

    }
    
    @Test
    public void testGetAverageNumberOfNotes4() {
        System.out.println("getAverageNumberOfNotes");
        
        dvdDao.create(dvd4);


        double result = dvdDao.getAverageNumberOfNotes();
        double expResult = 0;
        
        Assert.assertEquals(expResult, result, 0);

    }
    
    @Test
    public void testGetAverageNumberOfNotes5() {
        System.out.println("getAverageNumberOfNotes");
        
        dvdDao.create(dvd1);

        double result = dvdDao.getAverageNumberOfNotes();
        double expResult = 2;
        
        Assert.assertEquals(expResult, result, 0);

    }

    /**
     * Test of findNewestDvd method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testFindNewestDvd() {
        System.out.println("findNewestDvd");

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        Dvd result = dvdDao.findNewestDvd();
        Dvd expResult = dvd3;
        
        Assert.assertEquals(expResult, result);

    }
    
       @Test
    public void testFindNewestDvd2() {
        System.out.println("findNewestDvd");

        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        
        Dvd result = dvdDao.findNewestDvd();
        Dvd expResult = dvd2;
        
        Assert.assertEquals(expResult, result);

    }
    
       @Test
    public void testFindNewestDvd3() {
        System.out.println("findNewestDvd");

        dvdDao.create(dvd1);
        
        Dvd result = dvdDao.findNewestDvd();
        Dvd expResult = dvd1;
        
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of findOldestDvd method, of class DvdLibraryDaoImpl.
     */
    @Test
    public void testFindOldestDvd() {
        System.out.println("findOldestDvd");
        
        dvdDao.create(dvd1);
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        Dvd result = dvdDao.findOldestDvd();
        Dvd expResult = dvd1;
        
        Assert.assertEquals(expResult, result);
        
    }
    
    
    @Test
    public void testFindOldestDvd2() {
        System.out.println("findOldestDvd");
        
        dvdDao.create(dvd2);
        dvdDao.create(dvd3);
        
        Dvd result = dvdDao.findOldestDvd();
        Dvd expResult = dvd2;
        
        Assert.assertEquals(expResult, result);
        
    }
    
    
    @Test
    public void testFindOldestDvd3() {
        System.out.println("findOldestDvd");
        
        dvdDao.create(dvd3);
        
        Dvd result = dvdDao.findOldestDvd();
        Dvd expResult = dvd3;
        
        Assert.assertEquals(expResult, result);
        
    }

}