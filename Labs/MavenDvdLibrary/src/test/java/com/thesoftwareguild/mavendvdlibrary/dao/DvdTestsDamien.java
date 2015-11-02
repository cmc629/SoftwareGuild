package com.thesoftwareguild.mavendvdlibrary.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.thesoftwareguild.mavendvdlibrary.dao.DvdLibraryDao;
import com.thesoftwareguild.mavendvdlibrary.model.Dvd;
import com.thesoftwareguild.mavendvdlibrary.model.Note;

/**
 *
 * @author apprentice
 */
public class DvdTestsDamien {

    Map<Integer, Dvd> dvds;
    static ApplicationContext context;
    DvdLibraryDao library;
    final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    @Before
    public void setUp() throws ParseException, IOException {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

        library = context.getBean("dvdLibraryDao", DvdLibraryDao.class);

        dvds = new HashMap<>();
        Dvd dvd = new Dvd();
        dvd.setTitle("Inception");
        dvd.setReleaseDate(dateFormat.parse("07-13-2010"));
        dvd.setMpaaRating("PG-13");
        dvd.setDirector("Christopher Nolan");
        dvd.setStudio("Warner Bros. Pictures");
        dvd.setId(0);
        dvd.setNotes(new ArrayList<>());
        assertTrue(dvd.getNotes() != null);
        dvds.put(dvd.getId(), dvd);

        dvd = new Dvd();
        dvd.setTitle("21 Jump Street");
        dvd.setReleaseDate(dateFormat.parse("07-13-2012"));
        dvd.setMpaaRating("R");
        dvd.setDirector("Chris Miller");
        dvd.setStudio("Columbia Pictures");
        dvd.setNotes(new ArrayList<>());
        dvd.setId(1);
        assertTrue(dvd.getNotes() != null);
        dvds.put(dvd.getId(), dvd);

        dvd = new Dvd();
        dvd.setTitle("Inception");
        dvd.setReleaseDate(dateFormat.parse("07-13-2110"));
        dvd.setMpaaRating("R");
        dvd.setDirector("Christopher Nolan");
        dvd.setStudio("Warner Bros. Pictures");
        dvd.setNotes(new ArrayList<>());
        dvd.setId(2);
        assertTrue(dvd.getNotes() != null);
        dvds.put(dvd.getId(), dvd);

        for (Integer id : dvds.keySet()) {
            library.create(dvds.get(id));
        }
    }

    @Test
    public void deleteTest() {
        System.out.println("deleteTest");
        //Create new collection to avoid ConcurrentModification errors in iteration.
        Collection<Dvd> returnedDvds = new ArrayList<>(library.list());
        for (Dvd dvd : returnedDvds) {
            assertEquals(dvd, library.get(dvd.getId()));
            library.delete(dvd.getId());
            assertEquals(null, library.get(dvd.getId()));
        }
    }

    @Test
    public void getDvdByIdTest() {
        System.out.println("getDvdByIdTest");
        for (Integer id : dvds.keySet()) {
            assertEquals(dvds.get(id), library.get(id));
        }
    }

    @Test
    public void listAllDvdsTest() {
        System.out.println("listAllDvdsTest");
        List<Dvd> expected = new ArrayList<>(dvds.values());

        assertEquals(expected, library.list());
    }

    @Test
    public void searchByTitleTest() {
        System.out.println("searchByTitleTest");
        final String title = "21 Jump Street";
        List<Dvd> expected = dvds.values().stream().filter(dvd -> dvd.getTitle().equals(title)).collect(Collectors.toList());

        assertEquals(expected, library.searchByTitle("21 Jump Street"));

        final String title2 = "Inception";
        List<Dvd> expected2 = dvds.values().stream().filter(dvd -> dvd.getTitle().equals(title2)).collect(Collectors.toList());

        assertEquals(expected2, library.searchByTitle("Inception"));

    }
    /*
     @Test
     public void testUpdate() {
     System.out.println("testUpdate");
     Dvd dvd = new Dvd();
     dvd.setId(dvds.get(0).getId());
     dvd.setTitle("Jurassic Park");
     dvd.setDirector("Stephen Spielberg");
     dvd.setMpaaRating("R");
     dvd.setReleaseDate(new Date(93, 6, 9));
     assertEquals(dvds.get(0), library.get(0));
     library.update(dvd);
     assertEquals(dvd, library.get(0));
     }
     */

    @Test
    public void testSearchNewerThanYear() {
        System.out.println("testSearchNewerThanYear");
        int year = 2011;
        List<Dvd> returned = library.searchNewerThanYear(year);
        List<Dvd> expected = dvds.values().stream().filter(dvd -> dvd.getReleaseDate().getYear() > year - 1900).collect(Collectors.toList());

        assertEquals(expected, returned);
    }

    @Test
    public void testSearchByMpaaRating() {
        System.out.println("testSearchByMpaaRating");
        String rating = "R";
        List<Dvd> expected = dvds.values().stream().filter(dvd -> dvd.getMpaaRating().equals(rating)).collect(Collectors.toList());

        assertEquals(expected, library.searchByMpaaRating("R"));
    }

    @Test
    public void testSearchByDirector() {
        System.out.println("testSearchByDirector");
        String directorName = "Chris Miller";
        List<Dvd> expected = dvds.values().stream().filter((dvd) -> dvd.getDirector().equals(directorName)).collect(Collectors.toList());
        assertEquals(expected, library.searchByDirector("Chris Miller"));
    }

    @Test
    public void testSearchByStudio() {
        System.out.println("testSearchByStudio");
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvds.get(0));
        expected.add(dvds.get(2));
        assertEquals(expected, library.searchByStudio("Warner Bros. Pictures"));
    }

    @Test
    public void testGetAverageAge() throws ParseException {
        System.out.println("getAverageAge");
        Date now = new Date();
        double expected = dvds.values().stream().mapToDouble(dvd -> now.getTime() - dvd.getReleaseDate().getTime()).average().orElse(0.0);
        double actual = library.getAverageAge();
        expected = expected / 1000 / 60 / 60 / 24;
        assertEquals(expected, actual, .000001);
    }

    @Test
    public void testGetAverageNumberOfNotes() {
        System.out.println("getAverageNumberOfNotes");
        List<Note> notes = new ArrayList<>();
        Note newNote = new Note();
        newNote.setContent("Rawks");
        notes.add(newNote);
        dvds.get(0).setNotes(notes);
        assertEquals(.3, library.getAverageNumberOfNotes(), .1);
    }

    @Test
    public void testFindNewestDvd() {
        System.out.println("findNewestDvd");
        Dvd newest = dvds.values().stream().max((a, b) -> Long.compare(a.getReleaseDate().getTime(), b.getReleaseDate().getTime())).get();
        assertEquals(dvds.get(2), library.findNewestDvd());
    }

    @Test
    public void testFindOldestDvd() {
        System.out.println("findOldestDvd");
        Dvd oldest = dvds.values().stream().min((a, b) -> Long.compare(a.getReleaseDate().getTime(), b.getReleaseDate().getTime())).get();
        assertEquals(oldest, library.findOldestDvd());
    }

    @Test
    public void testSearchByTitle() {
        System.out.println("searchByTitle");
        String title = "Inception";
        List<Dvd> expected = dvds.values().stream().filter((dvd) -> dvd.getTitle().equals(title)).collect(Collectors.toList());

        assertEquals(expected, library.searchByTitle("Inception"));
    }

}
