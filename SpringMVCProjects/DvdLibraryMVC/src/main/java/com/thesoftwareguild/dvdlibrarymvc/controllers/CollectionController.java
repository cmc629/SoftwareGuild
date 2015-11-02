package com.thesoftwareguild.dvdlibrarymvc.controllers;

import com.thesoftwareguild.dvdlibrarymvc.daos.DvdLibraryDao;
import com.thesoftwareguild.dvdlibrarymvc.daos.NoteDao;
import com.thesoftwareguild.dvdlibrarymvc.models.Dvd;
import com.thesoftwareguild.dvdlibrarymvc.models.Note;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping({"/collection"})
public class CollectionController {
        
    private DvdLibraryDao dDao;
    private NoteDao nDao;
    
    @Inject
    public CollectionController(DvdLibraryDao dDao, NoteDao nDao) {
        this.dDao = dDao;
        this.nDao = nDao;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        
        List<Dvd> dvds = dDao.list();
        
        model.addAttribute("dvds", dvds);
        model.addAttribute("dvd", new Dvd());
        
        return "list";
    }
    
    @RequestMapping(value="/", method = RequestMethod.POST)
    @ResponseBody
    public Dvd add(@Valid @RequestBody Dvd dvd) {
        
        //dvd.setNotes(new ArrayList<>());
        
        Dvd addedDvd = dDao.create(dvd);
        
        return addedDvd;
    }
    
    @RequestMapping(value="/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Integer id, Model model) {
        
        Dvd dvd = dDao.get(id);
        
        model.addAttribute("dvd", dvd);
        
        return "view";
    }
    
    @RequestMapping(value = "/view/{id}/note", method = RequestMethod.POST)
    @ResponseBody
    public Note addNote(@PathVariable("id") Integer id, @RequestBody Note note) {
        
        note.setDvdId(id);
        Note createdNote = nDao.create(note);
        Dvd dvd = dDao.get(id);
        dvd.getNotes().add(createdNote);
        
        dDao.update(dvd);
        
        return createdNote;
        
    }
    
//    @RequestMapping(value="/view/{id}/addNote", method = RequestMethod.POST)
//    public String addNote(@PathVariable("id") Integer id, @RequestParam("comment") String comment) {
//        
//        Note note = new Note();
//        note.setContent(comment);
//        
//        Dvd dvd = dDao.get(id);
//        dvd.getNotes().add(note);
//        
//        dDao.update(dvd);
//        
//        return "redirect:/collection/view/{id}";
//    }
    
    @RequestMapping(value="/view/note/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteNote(@PathVariable("id") Integer id) {
        
        //Get note
        Note note = nDao.get(id);
        
        //get dvd containing note
        Dvd dvd = dDao.get(note.getDvdId());
        //search for the note in the dvd using the note id. get the index and remove it
        for (int idx = 0; idx < dvd.getNotes().size(); idx++) {
            Note targetNote = dvd.getNotes().get(idx);
            if (targetNote.getId().equals(note.getId())) {
                dvd.getNotes().remove(idx);
            }
        }
        //update dvd without the deleted note
        dDao.update(dvd);
        //delete the note from the notedao
        nDao.delete(note.getId());
        
    }
    
    @RequestMapping(value="view/note/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Note getNote(@PathVariable("id") Integer id) {
        
        Note note = nDao.get(id);
        
        return note;
    }
    
    @RequestMapping(value="view/note/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Note editNote(@RequestBody Note note) {
        
        nDao.update(note);
        Dvd dvd = dDao.get(note.getDvdId());
        for (int idx = 0; idx < dvd.getNotes().size(); idx++) {
            Note targetNote = dvd.getNotes().get(idx);
            if (targetNote.getId().equals(note.getId())) {
                dvd.getNotes().remove(idx);
                dvd.getNotes().add(idx, note);
            }
        }
        
        dDao.update(dvd);
        
        return note;
    }
//    @RequestMapping(value="/view/{id}/editNote/{index}", method = RequestMethod.POST)
//    public String editNote(@PathVariable("id") Integer id, @PathVariable("index") Integer index, @RequestParam("content") String comment) {
//        
//        Dvd dvd = dDao.get(id);
//        int idx = index;
//        dvd.getNotes().remove(idx);
//        
//        Note note = new Note();
//        note.setContent(comment);
//        
//        dvd.getNotes().add(idx, note);
//        
//        dDao.update(dvd);
//        
//        return "redirect:/collection/view/{id}";
//    }
    
    @RequestMapping(value="/view/edit/{id}", method = RequestMethod.GET)
    public String editDvdForm(@PathVariable("id") Integer id, Model model) {
        
        Dvd dvd = dDao.get(id);
        
        model.addAttribute("dvd", dvd);
        
        return "edit";
        
    }
    
    @RequestMapping(value="/view/collection/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Dvd editDvd(@Valid @RequestBody Dvd dvd) {
        
//        model.addAttribute("id", dvd.getId());
//        
//        if (bindingResult.hasErrors()) {
//            return "redirect:/collection/view/edit/{id}";
//        }
//         
//        dDao.update(dvd);
        
          dDao.update(dvd);
          
        return dvd;
        
    }
    
    @RequestMapping(value="/view/delete/{id}", method = RequestMethod.GET)
    public String deleteDvd(@PathVariable("id") Integer id) {
        
        dDao.delete(id);
        
        return "redirect:/collection";
    }
    
    @RequestMapping(value="view/collection/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Dvd getDvd(@PathVariable("id") Integer id) {
        
        Dvd dvd = dDao.get(id);
        
        return dvd;
        
    }
    
}
