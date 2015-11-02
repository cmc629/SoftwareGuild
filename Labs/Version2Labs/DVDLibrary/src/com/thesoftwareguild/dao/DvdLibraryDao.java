package com.thesoftwareguild.dao;

import com.thesoftwareguild.model.Dvd;

import java.util.List;

/**
 * Created by patricktoner on 9/22/15.
 */
public interface DvdLibraryDao {

    public Dvd create(Dvd dvd);

    public void update(Dvd dvd);

    public Dvd get(Integer id);

    public void delete(Integer id);

    public List<Dvd> list();

    public List<Dvd> searchNewerThanYear(Integer year);

    public List<Dvd> searchByMpaaRating(String rating);

    public List<Dvd> searchByDirector(String director);

    public List<Dvd> searchByStudio(String studio);

    public List<Dvd> searchByTitle(String title);

    public double getAverageAge();

    public double getAverageNumberOfNotes();

    public Dvd findNewestDvd();

    public Dvd findOldestDvd();

}
