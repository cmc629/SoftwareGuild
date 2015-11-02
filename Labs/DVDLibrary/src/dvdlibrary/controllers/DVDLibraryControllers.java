/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controllers;

import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dto.DVD;
import dvdlibrary.dto.DvdLibrary;
import dvdlibrary.ui.ConsoleIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public class DVDLibraryControllers {

    private DVDLibraryDao dao = new DVDLibraryDao();
    private ConsoleIO io = new ConsoleIO();
    private DvdLibrary library;

    public void run() {
        library = new DvdLibrary(dao.loadLibrary());
        boolean isRunning = true;
        while (isRunning) {
            printMainMenu();

            int menuSelection = io.promptForIntInRange("", 1, 5);
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
                    searchDVDByTitle();
                    break;
                case 5:
                    isRunning = false;
                    break;
            }
        }

    }

    private void printMainMenu() {
        io.print("\nChoose an option:\n1- Add new DVD\n2- Remove DVD by title"
                + "\n3- List all DVDs\n4- Search for a DVD by title\n5- Exit");
    }

    private void createDVD() {
        String title = io.promptForString("\nPlease enter DVD title");
        String release = io.promptForString("Please enter release date (mm-dd-yyyy)");
        String rating = io.promptForString("Please enter movie rating");
        String director = io.promptForString("Please enter director name");
        String studio = io.promptForString("Please enter studio name");
        List<String> comments = new ArrayList();
        DVD dvd = new DVD();
        dvd.setTitle(title);
        dvd.setReleaseDate(release);
        dvd.setRating(rating);
        dvd.setDirectorName(director);
        dvd.setStudioName(studio);
        dvd.setComments(comments);
        library.addDVD(dvd);
        try {
            dao.writeLibrary(library.getAllDVDs());
        } catch (IOException ex) {
            io.println("There was a problem writing to the disk.");
        }
    }

    private void removeDVD() {
        String title = io.promptForString("\nPlease enter the title of the DVD you would like to remove");
        List<DVD> dvdList = library.getByTitle(title);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs with the title " + title);
        } else {
            if (dvdList.size() == 1) {
                DVD dvdToRemove = dvdList.get(0);
                library.removeDVD(dvdToRemove.getId());
            } else {
                io.println("Here is a list of DVDs with the title " + title + ":");
                for (int i = 0; i < dvdList.size(); i++) {

                    io.println(String.format("%d %s %s", i + 1,
                            dvdList.get(i).getTitle(),
                            dvdList.get(i).getReleaseDate()));
                }
                int option = io.promptForInt("\nPlease enter a number corresponding to the DVD you want to remove") - 1;
                DVD dvdToRemove = dvdList.get(option);
                String check = io.promptForString("\nAre you sure you want to remove this DVD? (yes/no)");
                if (check.equals("yes")) {
                    library.removeDVD(dvdToRemove.getId());
                }
            }
        }

        try {
            dao.writeLibrary(library.getAllDVDs());
        } catch (IOException ex) {
            io.println("There was a problem writing to the disk.");
        }
    }

    private void listAllDVDs() {
        List<DVD> dvdList = library.getAllDVDs();
        if (!dvdList.isEmpty()) {
            io.println("\nHere is the current list of DVDs by title and release date:");
            for (DVD dvd : dvdList) {
                io.println(String.format("Title: %s | Release Date: %s", dvd.getTitle(), dvd.getReleaseDate()));
            }
        } else {
            io.println("\nThe current list of DVDs is empty!");
        }
    }

    private void searchDVDByTitle() {
        String title = io.promptForString("Please enter the title of the DVD: ");
        List<DVD> dvdList = library.getByTitle(title);
        if (dvdList.isEmpty()) {
            io.println("\nThere are no DVDs with the title " + title);
        } else {
            DVD dvdToDisplay;
            if (dvdList.size() == 1) {
                dvdToDisplay = dvdList.get(0);
            } else {
                io.println("\nHere is a list of DVDs with the title " + title);

                for (int i = 0; i < dvdList.size(); i++) {

                    io.println(String.format("%d %s %s", i + 1,
                            dvdList.get(i).getTitle(),
                            dvdList.get(i).getReleaseDate()));
                }
                int option = io.promptForIntInRange("\nPlease enter a number corresponding to the DVD you want to display.", 1, dvdList.size()) - 1;
                dvdToDisplay = dvdList.get(option);
            }
            displayDVDInfo(dvdToDisplay);
            String choice = io.promptForString("\nDo you want to edit this DVD? (yes/no)");
            if (choice.equals("yes")) {
                editDVD(dvdToDisplay);
            }
        }
    }

    private void displayDVDInfo(DVD dvd) {
        io.println("\nDisplaying DVD Information:");
        io.println("The DVD title is " + dvd.getTitle());
        io.println("The DVD release date is " + dvd.getReleaseDate());
        io.println("The DVD rating is " + dvd.getRating());
        io.println("The DVD director name is " + dvd.getDirectorName());
        io.println("The DVD studio name is " + dvd.getStudioName());
        io.println("The DVD list of comments is " + dvd.getComments());
    }

    private void editDVD(DVD dvd) {
        boolean shouldRun = true;
        try {
            while (shouldRun) {
                printDVDMenu();
                int choice = io.promptForIntInRange("", 1, 7);
                switch (choice) {
                    case 1:
                        String title = io.promptForString("\nPlease enter the new title");
                        dvd.setTitle(title);

                        dao.writeLibrary(library.getAllDVDs());
                        break;
                    case 2:
                        String date = io.promptForString("\nPlease enter the new release date (mm-dd-yyyy)");
                        dvd.setReleaseDate(date);
                        dao.writeLibrary(library.getAllDVDs());
                        break;
                    case 3:
                        String rating = io.promptForString("\nPlease enter the new rating");
                        dvd.setRating(rating);
                        dao.writeLibrary(library.getAllDVDs());
                        break;
                    case 4:
                        String director = io.promptForString("\nPlease enter the new director's full name");
                        dvd.setDirectorName(director);
                        dao.writeLibrary(library.getAllDVDs());
                        break;
                    case 5:
                        String studio = io.promptForString("\nPlease enter the new studio's name");
                        dvd.setStudioName(studio);
                        dao.writeLibrary(library.getAllDVDs());
                        break;
                    case 6:
                        editComments(dvd);
                        break;
                    case 7:
                        io.println("Going back to main menu.");
                        shouldRun = false;
                }

            }
            dao.writeLibrary(library.getAllDVDs());
        } catch (IOException e) {
            io.println("There was a problem writing to the disk.");
        }
    }

    private void printDVDMenu() {
        io.print("\nChoose an option to edit:\n1- Title\n2- Release Date"
                + "\n3- Rating\n4- Director Name\n5- Studio Name\n6- Comments"
                + "\n7- Back to main menu");
    }

    private void editComments(DVD dvd) throws IOException {
        printCommentMenu();
        int choice = io.promptForIntInRange("Please select from the above choices", 1, 4);
        switch (choice) {
            case 1:
                String comment = io.promptForString("Please enter comment to add: ");
                dvd.getComments().add(comment);
                dao.writeLibrary(library.getAllDVDs());
                break;
            case 2:
                io.println("Here is the current list of comments: ");
                for (int i = 0; i < dvd.getComments().size(); i++) {
                    io.println(String.format("%d %s", i + 1, dvd.getComments().get(i)));
                }
                int removeIdx = io.promptForInt("Please enter a number corresponding to the comment you want to remove: ") - 1;
                String check = io.promptForString("Are you sure you want to remove this comment? (yes/no)");
                if (check.equals("yes")) {
                    dvd.getComments().remove(removeIdx);
                    dao.writeLibrary(library.getAllDVDs());
                }
                break;
            case 3:
                io.println("Here is the current list of comments:");
                for (int i = 0; i < dvd.getComments().size(); i++) {
                    io.println(String.format("%d %s", i + 1, dvd.getComments().get(i)));
                }
                int editIdx = io.promptForInt("Please enter a number corresponding to the comment you want to edit:") - 1;
                String change = io.promptForString("What would you like to say?");
                dvd.getComments().remove(editIdx);
                dvd.getComments().add(change);
                dao.writeLibrary(library.getAllDVDs());
                break;
            case 4:
                io.println("Going back to main menu.");
                break;
        }

    }

    private void printCommentMenu() {
        io.println("\nChoose an option to edit comments:\n1- Add\n2- Delete"
                + "\n3- Edit\n4- Back to DVD menu\n5- Back to main menu");
    }

}
