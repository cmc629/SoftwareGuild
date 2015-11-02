/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.dvdlibrarymvc.daos;


import com.thesoftwareguild.dvdlibrarymvc.models.Dvd;
import com.thesoftwareguild.dvdlibrarymvc.models.Note;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi/
 */
public class DvdLibraryDaoImpl implements DvdLibraryDao {

    private List<Dvd> library = new ArrayList<>();
    private static final String fileName = "library.txt";
    private static final String listSeparator = "#%#";
    public static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    private int nextId = 0;
    private boolean testMode = false;

    public DvdLibraryDaoImpl() {
        load();
    }
    
    public DvdLibraryDaoImpl(boolean testMode) {
        this.testMode = testMode;
    }

    private void load() {

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(this.fileName)));
            while (sc.hasNext()) {

                String line = sc.nextLine();

                String[] properties = line.split(",");
                Dvd dvd = new Dvd();
                dvd.setTitle(properties[0]);
                dvd.setReleaseDate(dateFormat.parse(properties[1]));
                dvd.setMpaaRating(properties[2]);
                dvd.setDirector(properties[3]);
                dvd.setStudio(properties[4]);
                String[] comments = properties[5].split(this.listSeparator);
                List<Note> commentList = new ArrayList<>();
                for (String comment : comments) {
                    if (!comment.equals("")) { //last item is an empty string, don't want to include that
                        Note note = new Note();
                        note.setContent(comment);
                        commentList.add(note);
                    }
                }
                dvd.setNotes(commentList);
                dvd.setId(Integer.parseInt(properties[6]));
                if (dvd.getId() >= nextId) {
                    nextId = dvd.getId() + 1;
                }
                library.add(dvd);
            }
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(DvdLibraryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void save() {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(this.fileName));
            for (Dvd dvd : library) {
                String commentMegaString = "";
                for (Note comment : dvd.getNotes()) {
                    commentMegaString += (comment.getContent() + this.listSeparator);
                }
                writer.printf("%s,%s,%s,%s,%s,%s,%d",
                        dvd.getTitle(),
                        dateFormat.format(dvd.getReleaseDate()),
                        dvd.getMpaaRating(),
                        dvd.getDirector(),
                        dvd.getStudio(),
                        commentMegaString,
                        dvd.getId());
                
                writer.println("");
            }
            
            writer.flush();
            writer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(DvdLibraryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Dvd create(Dvd dvd) {
        dvd.setId(nextId++);
        library.add(dvd);
        if (!testMode) save();
        return dvd;
    }

    @Override
    public void update(Dvd dvd) {
        Dvd current = this.get(dvd.getId());
        dvd.setNotes(current.getNotes());
        int index = this.library.indexOf(current);
        library.remove(current);
        library.add(index, dvd);
        if (!testMode) save();
    }

    @Override
    public Dvd get(Integer id) {
        for (Dvd dvd : library) {
            if (dvd.getId().equals(id)) {
                return dvd;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        //Iterator prevents ConcurrentModificationException.
        Iterator<Dvd> iter = library.iterator();
        while (iter.hasNext()) {
            Dvd next = iter.next();
            if (next.getId().equals(id)) {
                iter.remove();
            }
        }
        if (!testMode) save();
    }

    @Override
    public List<Dvd> list() {
        return Collections.unmodifiableList(library);
    }
    
    @Override
    public List<Dvd> searchByTitle(String title) {
        List<Dvd> dvds = new ArrayList<>();
        for (Dvd dvd : library) {
            if (dvd.getTitle().toLowerCase().matches(".*" + title.toLowerCase() + ".*")) {
                dvds.add(dvd);
            }
        }
        return dvds;
    }
    
    @Override
    public List<Dvd> searchNewerThanYear(Integer year) {
        List<Dvd> dvds = new ArrayList<>();
        for (Dvd dvd : library) {
            //Have to subtract 1900 from the year parameter becaause date is awful.
            if (dvd.getReleaseDate().getYear() > year - 1900) {
                dvds.add(dvd);
            }
        }
        return dvds;
    }

    @Override
    public List<Dvd> searchByMpaaRating(String rating) {
        List<Dvd> dvds = new ArrayList<>();
        for (Dvd dvd : library) {
            if (dvd.getMpaaRating().equalsIgnoreCase(rating)) {
                dvds.add(dvd);
            }
        }
        return dvds;
    }

    @Override
    public List<Dvd> searchByDirector(String director) {
        List<Dvd> dvds = new ArrayList<>();
        for (Dvd dvd : library) {
            if (dvd.getDirector().toLowerCase().matches(".*" + director.toLowerCase() + ".*")) {
                dvds.add(dvd);
            }
        }
        return dvds;
    }

    @Override
    public List<Dvd> searchByStudio(String studio) {
        List<Dvd> dvds = new ArrayList<>();
        for (Dvd dvd : library) {
            if (dvd.getStudio().toLowerCase().matches(".*" + studio.toLowerCase() + ".*")) {
                dvds.add(dvd);
            }
        }
        return dvds;
    }

    @Override
    public double getAverageAge() {
        double DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        Date current = new Date();
        double total = 0;
        for (Dvd dvd: library) {
            total += ((current.getTime() - dvd.getReleaseDate().getTime())) /DAY_IN_MILLIS;
        }
        return total / library.size();
    }

    @Override
    public double getAverageNumberOfNotes() {
        int count = 0;
        double noteCount = 0;
        for (Dvd dvd : library) {
            noteCount += dvd.getNotes() != null ? dvd.getNotes().size() : 0;
            count++;
        }
        return noteCount / count;
    }

    @Override
    public Dvd findNewestDvd() {
        if (library.isEmpty()) {
            return null;
        }
        Collections.sort(library, new Comparator<Dvd>() {

            @Override
            public int compare(Dvd o1, Dvd o2) {
                return o1.getReleaseDate().compareTo(o2.getReleaseDate());
            }

        });
        return library.get(library.size() - 1);
    }

    @Override
    public Dvd findOldestDvd() {
        if (library.isEmpty()) {
            return null;
        }
        Collections.sort(library, new Comparator<Dvd>() {

            @Override
            public int compare(Dvd o1, Dvd o2) {
                return o1.getReleaseDate().compareTo(o2.getReleaseDate());
            }

        });
        return library.get(0);
    }

}
