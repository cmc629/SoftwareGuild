/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.dvdlibrarymvc.daos;

import com.thesoftwareguild.dvdlibrarymvc.models.Note;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public interface NoteDao {
    
    public Note create(Note note);

    public void update(Note note);

    public Note get(Integer id);

    public void delete(Integer id);
    
}
