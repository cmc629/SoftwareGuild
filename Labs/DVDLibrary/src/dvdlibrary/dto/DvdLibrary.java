/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DvdLibrary {

    private int nextId = 0;
    private final Map<Integer, DVD> dvds = new HashMap<>();

    public DvdLibrary(Collection<DVD> library) {
        if (!library.isEmpty()) {
            dvds.putAll(library.stream().collect(Collectors.toMap(i -> i.getId(), i -> i)));
            nextId = library.stream().mapToInt(dvd -> dvd.getId()).max().getAsInt() + 1;
        }
    }

    public DvdLibrary() {

    }

    public void addDVD(DVD dvd) {
        if (dvd.getId() == null) {
            dvd.setId(nextId++);
        }

        dvds.put(dvd.getId(), dvd);
    }

    public void removeDVD(Integer id) {
        dvds.remove(id);
    }

    public DVD getDVD(Integer id) {
        return dvds.get(id);
    }

    public List<DVD> getAllDVDs() {
        List<DVD> dvdList = new ArrayList();

        dvdList.addAll(dvds.values());
        return dvdList;
    }

    public List<DVD> getByTitle(String title) {
        title = title.toLowerCase();
        List<DVD> dvdTitles = new ArrayList();

        List<DVD> dvdList = this.getAllDVDs();
        for (DVD dvd : dvdList) {
            if (dvd.getTitle().toLowerCase().matches(".*" + title + ".*")) {
                dvdTitles.add(dvd);
            }
        }

        return dvdTitles;
    }

    public void addNotes(String comment, Integer id) {
        dvds.get(id).getComments().add(comment);
    }

    public void removeNote(String comment, Integer id) {
        dvds.get(id).getComments().remove(comment);
    }
}
