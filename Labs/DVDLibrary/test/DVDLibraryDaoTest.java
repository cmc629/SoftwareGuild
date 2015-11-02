/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dvdlibrary.dto.DVD;
import dvdlibrary.dto.DvdLibrary;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Christian Choi
 */
public class DVDLibraryDaoTest {

    DvdLibrary library;
    DVD dvd, dvd2, dvd3;

    public DVDLibraryDaoTest() {
    }

    @Before
    public void setUp() {

        library = new DvdLibrary();

        dvd = new DVD();
        dvd.setTitle("Inception");
        dvd.setReleaseDate("07-13-2010");
        dvd.setRating("PG-13");
        dvd.setDirectorName("Christopher Nolan");
        dvd.setStudioName("Warner Bros. Pictures");

        dvd2 = new DVD();
        dvd2.setTitle("21 Jump Street");
        dvd2.setReleaseDate("03-12-2012");
        dvd2.setRating("R");
        dvd2.setDirectorName("Chris Miller");
        dvd2.setStudioName("Columbia Pictures");

        dvd3 = new DVD();
        dvd3.setTitle("Inception");
        dvd3.setReleaseDate("02-23-2102");
        dvd3.setRating("R");
        dvd3.setDirectorName("Nis Colan");
        dvd3.setStudioName("Warner Bros. Pictures");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addDVDCheckIdTest() {

        library.addDVD(dvd);
        Integer expected = 0;

        Assert.assertEquals(expected, dvd.getId());

        library.addDVD(dvd2);
        Integer expected2 = 1;

        Assert.assertEquals(expected, dvd.getId());

    }

    @Test
    public void removeDVDTest() {

        library.addDVD(dvd);
        library.addDVD(dvd2);

        library.removeDVD(dvd.getId());

        Collection<DVD> expected = new ArrayList<>();
        expected.add(dvd2);

        Assert.assertEquals(expected, library.getAllDVDs());

        library.removeDVD(dvd2.getId());
        boolean result = library.getAllDVDs().isEmpty();

        Assert.assertTrue(result);

    }

    @Test
    public void getDVDByIdTest() {

        library.addDVD(dvd);
        library.addDVD(dvd2);

        Assert.assertEquals(dvd, library.getDVD(0));
        Assert.assertEquals(dvd2, library.getDVD(1));
    }

    @Test
    public void listAllDVDsTest() {

        library.addDVD(dvd);
        library.addDVD(dvd2);

        List<DVD> expected = new ArrayList<>();
        expected.add(dvd);
        expected.add(dvd2);

        Assert.assertEquals(expected, library.getAllDVDs());

    }

    @Test
    public void getByTitleTest() {

        library.addDVD(dvd);
        library.addDVD(dvd2);
        library.addDVD(dvd3);

        List<DVD> expected = new ArrayList<>();
        expected.add(dvd2);

        Assert.assertEquals(expected, library.getByTitle("21 Jump Street"));

        List<DVD> expected2 = new ArrayList<>();
        expected2.add(dvd);
        expected2.add(dvd3);

        Assert.assertEquals(expected2, library.getByTitle("Inception"));

    }
}
