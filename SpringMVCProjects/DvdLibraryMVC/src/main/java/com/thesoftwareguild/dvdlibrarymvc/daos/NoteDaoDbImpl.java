/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.dvdlibrarymvc.daos;

import com.thesoftwareguild.dvdlibrarymvc.models.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Christian Choi
 */
public class NoteDaoDbImpl implements NoteDao {
    
    private static final String SQL_INSERT_NOTE = "INSERT INTO note (CONTENT, DVD_ID) VALUES (?, ?)";
    private static final String SQL_UPDATE_NOTE = "UPDATE note SET CONTENT = ? WHERE ID = ?";
    private static final String SQL_SELECT_NOTE = "SELECT * FROM note where ID = ?";
    private static final String SQL_DELETE_NOTE = "DELETE FROM note WHERE ID = ?";
    private static final String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
    
    private JdbcTemplate jdbcTemplate;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Note create(Note note) {
        
        jdbcTemplate.update(SQL_INSERT_NOTE,
                note.getContent(),
                note.getDvdId());
        
        Integer id = jdbcTemplate.queryForObject(SQL_GET_LAST_ID, Integer.class);
        note.setId(id);
        
        return note;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Note note) {
        
        jdbcTemplate.update(SQL_UPDATE_NOTE,
                note.getContent(),
                note.getId());
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Note get(Integer id) {
        
        Note note = jdbcTemplate.queryForObject(SQL_SELECT_NOTE, new NoteMapper());
        
        return note;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        
        jdbcTemplate.update(SQL_DELETE_NOTE, id);
        
    }
    
    
    
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public List<Note> getDvdNotes(Integer dvdId) {
//        
//        return jdbcTemplate.query(SQL_GET_DVD_NOTES, new NoteMapper(), dvdId);
//        
//    }
//    
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public List<Note> list() {
//        
//        return jdbcTemplate.query(SQL_GET_ALL_NOTES, new NoteMapper());
//        
//    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    
    private static final class NoteMapper implements RowMapper<Note> {

        @Override
        public Note mapRow(ResultSet rs, int i) throws SQLException {
            
            Note note = new Note();
            note.setId(rs.getInt("ID"));
            note.setContent(rs.getString("CONTENT"));
            note.setDvdId(rs.getInt("DVD_ID"));
            
            return note;
        }
        
    }
    
}
