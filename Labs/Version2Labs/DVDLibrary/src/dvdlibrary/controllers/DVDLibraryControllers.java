/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controllers;

import com.thesoftwareguild.dao.DvdLibraryDao;
import com.thesoftwareguild.model.Dvd;
import com.thesoftwareguild.model.Note;
import dvdlibrary.data.DvdLibraryDaoImpl;
import dvdlibrary.data.DvdLibraryDaoLambdaImpl;
import dvdlibrary.ui.ConsoleIO;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Choi
 */
public class DVDLibraryControllers {

    private DvdLibraryDao dao = new DvdLibraryDaoLambdaImpl();
    //private DvdLibraryDao dao = new DvdLibraryDaoImpl();
    private ConsoleIO io = new ConsoleIO();

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            printMainMenu();

            int menuSelection = io.promptInt("> ", 1, 13);
            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    listAllDVDs();
                    break;
                case 4:
                    searchByTitle();
                    break;
                case 5:
                    searchByYear();
                    break;
                case 6:
                    searchByRating();
                    break;
                case 7:
                    searchByDirector();
                    break;
                case 8:
                    searchByStudio();
                    break;
                case 9:
                    getOldest();
                    break;
                case 10:
                    getNewest();
                    break;
                case 11:
                    getAverageNotes();
                    break;
                case 12:
                    getAverageAge();
                    break;
                case 13:
                    isRunning = false;
                    break;
            }
        }

    }

    private void printMainMenu() {
        io.println("********************************************************");
        io.println("Choose an option:");
        io.println("1- Add new DVD\t\t\t8- Search DVD by studio");
        io.println("2- Remove DVD by Title\t\t9- Get oldest DVD");
        io.println("3- List all DVDs\t\t10- Get newest DVD");
        io.println("4- Search DVD by title\t\t11- Get average notes");
        io.println("5- Search DVD by year\t\t12- Get average age");
        io.println("6- Search DVD by MPAA rating\t13- Quit");
        io.println("7- Search DVD by director");
    }

    private void createDVD() {
        String title = io.promptString("\nPlease enter DVD title: ");
        String release = io.promptString("Please enter release date (mm-dd-yyyy): ");
        String rating = io.promptString("Please enter movie rating: ");
        String director = io.promptString("Please enter director name: ");
        String studio = io.promptString("Please enter studio name: ");
        List<Note> comments = new ArrayList();
        Dvd dvd = new Dvd();
        dvd.setTitle(title);
        try {
            dvd.setReleaseDate(DvdLibraryDaoImpl.dateFormat.parse(release));
        } catch (ParseException ex) {
            Logger.getLogger(DVDLibraryControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
        dvd.setMpaaRating(rating);
        dvd.setDirector(director);
        dvd.setStudio(studio);
        dvd.setNotes(comments);
        dao.create(dvd);
        io.println("DVD was added!");
    }

    private void removeDVD() {
        String title = io.promptString("\nPlease enter the title of the DVD you would like to remove: ");
        List<Dvd> dvdList = dao.searchByTitle(title);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs with the title " + title);
        } else {
            Dvd dvdToRemove = null;
            io.println("Here is a list of DVDs with the title " + title + ":");
            for (int i = 0; i < dvdList.size(); i++) {

                io.println(String.format("%d %s %s", i + 1,
                        dvdList.get(i).getTitle(),
                        dvdList.get(i).getReleaseDate()));
            }
            int option = io.promptInt("\nPlease enter a number corresponding to the DVD you want to remove: ") - 1;
            dvdToRemove = dvdList.get(option);

            String check = io.promptString("\nEnter 'yes' to remove DVD. Enter anything else to cancel: ");
            if (check.equals("yes")) {
                dao.delete(dvdToRemove.getId());
                io.println("DVD was removed!");
            } else {
                io.println("DVD was not removed!");
            }
        }
    }

    private void listAllDVDs() {
        List<Dvd> dvdList = dao.list();
        if (!dvdList.isEmpty()) {
            io.println("\nHere is the current list of DVDs by title and release date:");
            for (Dvd dvd : dvdList) {
                io.println(String.format("Title: %s | Release Date: %s", dvd.getTitle(),
                        DvdLibraryDaoImpl.dateFormat.format(dvd.getReleaseDate())));
            }
        } else {
            io.println("\nThe current list of DVDs is empty!");
        }
    }

    private void searchByTitle() {
        String title = io.promptString("Please enter the title of the DVD: ");
        List<Dvd> dvdList = dao.searchByTitle(title);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs with the title " + title);
        } else {
            Dvd dvdToDisplay;
            for (Dvd dvd : dvdList) {
                if (dvd.getTitle().equalsIgnoreCase(title)) {
                    dvdToDisplay = dvd;
                    break;
                }
            }

            io.println("\nHere is a list of DVDs with the title " + title);

            for (int i = 0; i < dvdList.size(); i++) {

                io.println(String.format("%d- Title: %s | Release Date: %s", i + 1,
                        dvdList.get(i).getTitle(),
                        DvdLibraryDaoImpl.dateFormat.format(dvdList.get(i).getReleaseDate())));
            }
            dvdToDisplay = askForDisplay(dvdList);
            AskForEdit(dvdToDisplay);
        }
    }

    private void searchByYear() {
        Integer year = io.promptInt("Enter a year to display DVDs released after that year: ");
        List<Dvd> dvdList = dao.searchNewerThanYear(year);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs released after " + year);
        } else {
            Dvd dvdToDisplay;
            for (Dvd dvd : dvdList) {
                if (((Integer) dvd.getReleaseDate().getYear()).equals(year)) {
                    dvdToDisplay = dvd;
                    break;
                }
            }

            io.println("\nHere is a list of DVDs released after " + year);

            for (int i = 0; i < dvdList.size(); i++) {

                io.println(String.format("%d- Title: %s | Release Date: %s", i + 1,
                        dvdList.get(i).getTitle(),
                        DvdLibraryDaoImpl.dateFormat.format(dvdList.get(i).getReleaseDate())));
            }
            dvdToDisplay = askForDisplay(dvdList);
            AskForEdit(dvdToDisplay);
        }
    }

    private void searchByRating() {
        String rating = io.promptString("Please enter a MPAA rating: ");
        List<Dvd> dvdList = dao.searchByMpaaRating(rating);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs with the rating " + rating);
        } else {
            Dvd dvdToDisplay;
            for (Dvd dvd : dvdList) {
                if (dvd.getMpaaRating().equalsIgnoreCase(rating)) {
                    dvdToDisplay = dvd;
                    break;
                }
            }

            io.println("\nHere is a list of DVDs with the rating " + rating);

            for (int i = 0; i < dvdList.size(); i++) {

                io.println(String.format("%d- Title: %s | Release Date: %s", i + 1,
                        dvdList.get(i).getTitle(),
                        DvdLibraryDaoImpl.dateFormat.format(dvdList.get(i).getReleaseDate())));
            }
            dvdToDisplay = askForDisplay(dvdList);
            AskForEdit(dvdToDisplay);
        }
    }

    private void searchByDirector() {
        String director = io.promptString("Please enter a director's name: ");
        List<Dvd> dvdList = dao.searchByDirector(director);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs with the director " + director);
        } else {
            Dvd dvdToDisplay;
            for (Dvd dvd : dvdList) {
                if (dvd.getDirector().equalsIgnoreCase(director)) {
                    dvdToDisplay = dvd;
                    break;
                }
            }

            io.println("\nHere is a list of DVDs with the director " + director);

            for (int i = 0; i < dvdList.size(); i++) {

                io.println(String.format("%d- Title: %s | Release Date: %s", i + 1,
                        dvdList.get(i).getTitle(),
                        DvdLibraryDaoImpl.dateFormat.format(dvdList.get(i).getReleaseDate())));
            }
            dvdToDisplay = askForDisplay(dvdList);
            AskForEdit(dvdToDisplay);
        }
    }

    private void searchByStudio() {
        String studio = io.promptString("Please enter a studio's name: ");
        List<Dvd> dvdList = dao.searchByStudio(studio);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs with the studio name " + studio);
        } else {
            Dvd dvdToDisplay;
            for (Dvd dvd : dvdList) {
                if (dvd.getStudio().equalsIgnoreCase(studio)) {
                    dvdToDisplay = dvd;
                    break;
                }
            }

            io.println("\nHere is a list of DVDs with the studio name " + studio);

            for (int i = 0; i < dvdList.size(); i++) {

                io.println(String.format("%d- Title: %s | Release Date: %s", i + 1,
                        dvdList.get(i).getTitle(),
                        DvdLibraryDaoImpl.dateFormat.format(dvdList.get(i).getReleaseDate())));
            }
            dvdToDisplay = askForDisplay(dvdList);
            AskForEdit(dvdToDisplay);
        }
    }

    private void getOldest() {
        io.println(String.format("Oldest DVD found:\nTitle: %s | Release Date: %s",
                dao.findOldestDvd().getTitle(),
                DvdLibraryDaoImpl.dateFormat
                .format(dao.findOldestDvd().getReleaseDate())));
    }

    private void getNewest() {
        io.println(String.format("Newest DVD found:\nTitle: %s | Release Date: %s",
                dao.findNewestDvd().getTitle(),
                DvdLibraryDaoImpl.dateFormat
                .format(dao.findNewestDvd().getReleaseDate())));
    }

    private void getAverageNotes() {
        io.println(String.format("Average number of notes: %f", dao.getAverageNumberOfNotes()));
    }

    private void getAverageAge() {
        io.println(String.format("Average age: %f", dao.getAverageAge()));
    }

    private void AskForEdit(Dvd dvdToDisplay) {
        String choice = io.promptString("\nDo you want to edit this DVD? Enter 'yes' to edit. Enter anything else to cancel: ");
        if (choice.equals("yes")) {
            editDVD(dvdToDisplay);
        }
    }

    private Dvd askForDisplay(List<Dvd> dvdList) throws NumberFormatException {
        Dvd dvdToDisplay;
        int option = io.promptInt("\nPlease enter a number corresponding to the DVD you want to display: ", 1, dvdList.size()) - 1;
        dvdToDisplay = dvdList.get(option);
        displayDVDInfo(dvdToDisplay);
        return dvdToDisplay;
    }

    private void displayDVDInfo(Dvd dvd) {
        io.println("\nDisplaying DVD Information:");
        io.println("The DVD title is " + dvd.getTitle());
        io.println("The DVD release date is " + DvdLibraryDaoImpl.dateFormat.format(dvd.getReleaseDate()));
        io.println("The DVD rating is " + dvd.getMpaaRating());
        io.println("The DVD director name is " + dvd.getDirector());
        io.println("The DVD studio name is " + dvd.getStudio());
        io.println("The DVD list of comments is: ");
        for (int i = 0; i < dvd.getNotes().size(); i++) {
            io.println("\t" + dvd.getNotes().get(i).getContent());
        }
    }

    private void editDVD(Dvd dvd) {
        boolean shouldRun = true;
        try {
            while (shouldRun) {
                printDVDMenu();
                io.println("");
                int choice = io.promptInt("> ", 1, 7);
                switch (choice) {
                    case 1:
                        String title = io.promptString("\nPlease enter the new title: ");
                        dvd.setTitle(title);
                        break;
                    case 2:
                        String date = io.promptString("\nPlease enter the new release date (mm-dd-yyyy): ");
                        dvd.setReleaseDate(DvdLibraryDaoImpl.dateFormat.parse(date));
                        break;
                    case 3:
                        String rating = io.promptString("\nPlease enter the new rating: ");
                        dvd.setMpaaRating(rating);
                        break;
                    case 4:
                        String director = io.promptString("\nPlease enter the new director's full name: ");
                        dvd.setDirector(director);
                        break;
                    case 5:
                        String studio = io.promptString("\nPlease enter the new studio's name: ");
                        dvd.setStudio(studio);
                        break;
                    case 6:
                        editComments(dvd);
                        break;
                    case 7:
                        io.println("Going back to main menu.");
                        shouldRun = false;
                }
                dao.update(dvd);

            }
        } catch (IOException ex) {
            io.println("There was a problem writing to the disk.");
        } catch (ParseException ex) {
            Logger.getLogger(DVDLibraryControllers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printDVDMenu() {
        io.print("\nChoose an option to edit:\n1- Title\n2- Release Date"
                + "\n3- Rating\n4- Director Name\n5- Studio Name\n6- Comments"
                + "\n7- Back to main menu");
    }

    private void editComments(Dvd dvd) throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            printCommentMenu();
            int choice = io.promptInt("Please select from the above choices: ", 1, 4);
        
            switch (choice) {
                case 1:
                    String comment = io.promptString("Please enter comment to add: ");
                    Note note = new Note();
                    note.setContent(comment);
                    dvd.getNotes().add(note);
                    break;
                case 2:
                    if (dvd.getNotes().isEmpty()) {
                        io.println("No comments to delete!");
                    } else {
                        io.println("Here is the current list of comments: ");

                        for (int i = 0; i < dvd.getNotes().size(); i++) {
                            io.println(String.format("%d %s", i + 1, dvd.getNotes().get(i)));
                        }
                        int removeIdx = io.promptInt("Please enter a number corresponding to the comment you want to remove: ") - 1;
                        String check = io.promptString("Are you sure you want to remove this comment? Enter 'yes' to remove otherwise enter anything else to cancel: ");
                        if (check.equals("yes")) {
                            dvd.getNotes().remove(removeIdx);
                        }
                    }
                    break;
                case 3:
                    if (dvd.getNotes().isEmpty()) {
                        io.println("No comments to edit!");
                    } else {
                        io.println("Here is the current list of comments:");
                        for (int i = 0; i < dvd.getNotes().size(); i++) {
                            io.println(String.format("%d %s", i + 1, dvd.getNotes().get(i).getContent()));
                        }
                        int editIdx = io.promptInt("Please enter a number corresponding to the comment you want to edit: ") - 1;
                        String change = io.promptString("What would you like to say?: ");
                        dvd.getNotes().remove(editIdx);
                        Note editedNote = new Note();
                        editedNote.setContent(change);
                        dvd.getNotes().add(editedNote);
                    }
                    break;
                case 4:
                    io.println("Going back to main menu.");
                    isRunning = false;
                    break;
            }
        }

    }

    private void printCommentMenu() {
        io.println("\nChoose an option to edit comments:\n1- Add\n2- Delete"
                + "\n3- Edit\n4- Back to DVD menu");
    }

}
