/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class DVDLibraryDao {

    private static final String fileName = "library.txt";
    private static final String listSeparator = "#%#";


    public Collection<DVD> loadLibrary() {

        int highestId = 0;
        Collection<DVD> dvds = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(this.fileName)));
            while (sc.hasNext()) {

                String line = sc.nextLine();

                String[] properties = line.split(",");
                DVD dvd = new DVD();
                dvd.setTitle(properties[0]);
                dvd.setReleaseDate(properties[1]);
                dvd.setRating(properties[2]);
                dvd.setDirectorName(properties[3]);
                dvd.setStudioName(properties[4]);
                String[] comments = properties[5].split(this.listSeparator);
                List<String> commentList = new ArrayList();
                for (String comment : comments) {
                    if (!comment.equals("")) { //last item is an empty string, don't want to include that
                        commentList.add(comment);
                    }
                }
                dvd.setComments(commentList);
                dvd.setId(Integer.parseInt(properties[6]));
                if (dvd.getId() >= highestId) {
                    highestId = dvd.getId() + 1;
                }
                dvds.add(dvd);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DVDLibraryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dvds;
    }

    public void writeLibrary(Collection<DVD> library) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(this.fileName));

        for (DVD dvd : library) {
            String commentMegaString = "";
            for (String comment : dvd.getComments()) {
                commentMegaString += (comment + this.listSeparator);
            }
            writer.printf("%s,%s,%s,%s,%s,%s,%d",
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getRating(),
                    dvd.getDirectorName(),
                    dvd.getStudioName(),
                    commentMegaString,
                    dvd.getId());

            writer.println("");
        }
        writer.flush();
        writer.close();
    }
}
