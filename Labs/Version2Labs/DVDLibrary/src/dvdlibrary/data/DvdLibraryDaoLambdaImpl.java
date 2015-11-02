/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.data;

import com.thesoftwareguild.dao.DvdLibraryDao;
import com.thesoftwareguild.model.Dvd;
import com.thesoftwareguild.model.Note;
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
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Christian Choi/
 */
public class DvdLibraryDaoLambdaImpl implements DvdLibraryDao {

    private List<Dvd> library = new ArrayList<>();
    private static final String fileName = "library.txt";
    private static final String listSeparator = "#%#";
    public static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    private int nextId = 0;
    private boolean testMode = false;
    
    public DvdLibraryDaoLambdaImpl() {
        load();
    }
    
    public DvdLibraryDaoLambdaImpl(boolean testMode) {
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
            Logger.getLogger(DvdLibraryDaoLambdaImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DvdLibraryDaoLambdaImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        delete(dvd.getId());
        library.add(dvd);
        if (!testMode) save();
    }

    @Override
    public Dvd get(Integer id) {
        return library.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(Integer id) {
        library = library.stream().filter(d -> !d.getId().equals(id)).collect(Collectors.toList());
        if (!testMode) save();
    }

    @Override
    public List<Dvd> list() {
        return Collections.unmodifiableList(library);
    }

    @Override
    public List<Dvd> searchNewerThanYear(Integer year) {
        return library.stream().filter(d -> d.getReleaseDate().getYear() > year - 1900).collect(Collectors.toList());
    }

    @Override
    public List<Dvd> searchByMpaaRating(String rating) {
        return library.stream().filter(d -> d.getMpaaRating().equals(rating)).collect(Collectors.toList());
    }

    @Override
    public List<Dvd> searchByDirector(String director) {
        return library.stream().filter(d -> d.getDirector().equals(director)).collect(Collectors.toList());
    }

    @Override
    public List<Dvd> searchByStudio(String studio) {
        return library.stream().filter(d -> d.getStudio().equals(studio)).collect(Collectors.toList());
    }
    
    @Override
    public List<Dvd> searchByTitle(String title) {
        return library.stream().filter(d -> d.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public double getAverageAge() {
        int currentYear = new Date().getYear();
        return library.stream().mapToDouble(Dvd -> currentYear - Dvd.getReleaseDate().getYear()).average().orElse(0);
    }

    @Override
    public double getAverageNumberOfNotes() {
        return library.stream().mapToDouble(Dvd -> Dvd.getNotes().size()).average().orElse(0);
    }

    @Override
    public Dvd findNewestDvd() {
        return library.stream().sorted(Collections.reverseOrder((d1, d2) -> d1.getReleaseDate().compareTo(d2.getReleaseDate()))).findFirst().orElse(null);
    }

    @Override
    public Dvd findOldestDvd() {
        return library.stream().sorted((d1, d2) -> d1.getReleaseDate().compareTo(d2.getReleaseDate())).findFirst().orElse(null);
    }

}
