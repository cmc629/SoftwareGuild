/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.data;

import com.thesoftwareguild.dao.DvdLibraryDao;
import com.thesoftwareguild.model.Dvd;
import com.thesoftwareguild.model.Note;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDaoImplTest {
    
    DvdLibraryDao library;
    Dvd dvd, dvd2, dvd3;
    
    @Before
    public void setUp() {
        //library = new DvdLibraryDaoImpl(true);
        library = new DvdLibraryDaoLambdaImpl(true);
        
        dvd = new Dvd();
        dvd.setTitle("Inception");
        dvd.setReleaseDate(new Date(110, 7, 13));
        dvd.setMpaaRating("PG-13");
        dvd.setDirector("Christopher Nolan");
        dvd.setStudio("Warner Bros. Pictures");
        library.create(dvd);
        
        dvd2 = new Dvd();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate(new Date(112, 3, 12));
        dvd2.setMpaaRating("R");
        dvd2.setDirector("Chris Miller");
        dvd2.setStudio("Columbia Pictures");
        library.create(dvd2);
        
        dvd3 = new Dvd();
        dvd3.setTitle("Inception");
        dvd3.setReleaseDate(new Date(212, 2, 23));
        dvd3.setMpaaRating("R");
        dvd3.setDirector("Nis Colan");
        dvd3.setStudio("Warner Bros. Pictures");
        library.create(dvd3);
    }
    
    @Test
    public void createCheckIdTest() {
        assertEquals(0, (int) dvd.getId());
        assertEquals(1, (int) dvd2.getId());
        assertEquals(2, (int) dvd3.getId());
    }
    
    @Test
    public void deleteTest() {
        library.delete(dvd.getId());
        
        Collection<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        expected.add(dvd3);
        
        assertEquals(expected, library.list());
        
        library.delete(dvd3.getId());
        expected.remove(dvd3);
        assertEquals(expected, library.list());
        
        library.delete(dvd2.getId());
        expected.remove(dvd2);
        assertEquals(expected, library.list());
        
    }
    
    @Test
    public void getDvdByIdTest() {
        
        assertEquals(dvd, library.get(0));
        assertEquals(dvd2, library.get(1));
    }
    
    @Test
    public void listAllDvdsTest() {
        
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd);
        expected.add(dvd2);
        expected.add(dvd3);
        
        assertEquals(expected, library.list());
        
    }
    
    @Test
    public void searchByTitleTest() {
        
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        
        assertEquals(expected, library.searchByTitle("21 Jump Street"));
        
        List<Dvd> expected2 = new ArrayList<>();
        expected2.add(dvd);
        expected2.add(dvd3);
        
        assertEquals(expected2, library.searchByTitle("Inception"));
        
    }
    
    @Test
    public void testUpdate() {
        Dvd dvd4 = new Dvd();
        dvd4.setId(dvd3.getId());
        dvd4.setTitle("Jurassic Park");
        dvd4.setDirector("Stephen Spielberg");
        dvd4.setMpaaRating("R");
        dvd4.setReleaseDate(new Date(93, 6, 9));
        assertEquals(dvd3, library.get(dvd3.getId()));
        library.update(dvd4);
        assertEquals(dvd4, library.get(dvd3.getId()));
    }
    
    @Test
    public void testGet() {
        assertEquals(dvd, library.get(0));
        assertEquals(dvd2, library.get(1));
        assertEquals(dvd3, library.get(2));
        assertEquals(null, library.get(3));
    }
    
    @Test
    public void testSearchNewerThanYear() {
        List<Dvd> returned = library.searchNewerThanYear(2011);
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
        
        assertEquals(expected, library.searchByMpaaRating("R"));
        assertTrue(library.searchByMpaaRating("PG").isEmpty());
    }
    
    @Test
    public void testSearchByDirector() {
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd2);
        assertEquals(expected, library.searchByDirector("Chris Miller"));
    }
    
    @Test
    public void testSearchByStudio() {
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd);
        expected.add(dvd3);
        assertEquals(expected, library.searchByStudio("Warner Bros. Pictures"));
    }
    
    @Test
    public void testGetAverageAge() {
        double expected = -89.0 / 3;
        assertEquals(expected, library.getAverageAge(), .01);
    }
    
    @Test
    public void testGetAverageNumberOfNotes() {
        List<Note> notes = new ArrayList<>();
        Note newNote = new Note();
        newNote.setContent("Rawks");
        notes.add(newNote);
        dvd.setNotes(notes);
        assertEquals(.3, library.getAverageNumberOfNotes(), .1);
    }
    
    @Test
    public void testFindNewestDvd() {
        assertEquals(dvd3, library.findNewestDvd());
    }
    
    @Test
    public void testFindOldestDvd() {
        assertEquals(dvd, library.findOldestDvd());
    }
    
    @Test
    public void testSearchByTitle() {
        List<Dvd> expected = new ArrayList<>();
        expected.add(dvd);
        expected.add(dvd3);
        
        assertEquals(expected, library.searchByTitle("Inception"));
    }
    
}
