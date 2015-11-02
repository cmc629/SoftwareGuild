/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.dvdlibrarymvc.daos;

import com.thesoftwareguild.dvdlibrarymvc.models.Note;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian Choi
 */
public class NoteDaoImpl implements NoteDao {
    
    private Map<Integer, Note> noteMap = new HashMap<>();
    private Integer nextId = 0;

    @Override
    public Note create(Note note) {
        note.setId(nextId++);
        noteMap.put(note.getId(), note);
        
        return note;
    }

    @Override
    public void update(Note note) {
        
        noteMap.put(note.getId(), note);
        
    }

    @Override
    public Note get(Integer id) {
        
        return noteMap.get(id);
        
    }

    @Override
    public void delete(Integer id) {
        
        noteMap.remove(id);
        
    }

//    @Override
//    public List<Note> getDvdNotes(Integer dvdId) {
//        
//        List<Note> result = new ArrayList<>();
//        
//        for (Note note : noteMap.values()) {
//            if (note.getDvdId().equals(dvdId) ){
//                result.add(note);
//            }
//        }
//        
//        return result;
//    }
//
//    @Override
//    public List<Note> list() {
//        
//        return new ArrayList<>(noteMap.values());
//        
//    }
    
}
