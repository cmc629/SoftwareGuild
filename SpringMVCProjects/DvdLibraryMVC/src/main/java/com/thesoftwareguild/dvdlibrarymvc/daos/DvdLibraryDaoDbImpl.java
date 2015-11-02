/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.dvdlibrarymvc.daos;

import com.thesoftwareguild.dvdlibrarymvc.models.Dvd;
import com.thesoftwareguild.dvdlibrarymvc.models.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Christian Choi
 */
public class DvdLibraryDaoDbImpl implements DvdLibraryDao {

    //CRUD
    private static final String SQL_INSERT_DVD = "INSERT INTO dvd (TITLE, RELEASE_DATE, MPAA_RATING, DIRECTOR, STUDIO) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DVD = "UPDATE dvd SET TITLE = ?, RELEASE_DATE = ?, MPAA_RATING = ?, DIRECTOR = ?, STUDIO = ? WHERE ID = ?";
    private static final String SQL_SELECT_DVD = "SELECT * FROM dvd WHERE ID = ?";
    private static final String SQL_DELETE_DVD = "DELETE FROM dvd WHERE ID = ?";
    private static final String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_GET_ALL_DVDS = "SELECT * FROM dvd";
    private static final String SQL_GET_DVD_NOTES = "SELECT * FROM note WHERE DVD_ID = ?";

    //Search that returns a list
    private static final String SQL_SEARCH_AFTER_YEAR = "SELECT * FROM dvd WHERE RELEASE_DATE > ?";
    private static final String SQL_SEARCH_BY_RATING = "SELECT * FROM dvd WHERE MPAA_RATING = ?";
    private static final String SQL_SEARCH_BY_DIRECTOR = "SELECT * FROM dvd WHERE DIRECTOR = ?";
    private static final String SQL_SEARCH_BY_STUDIO = "SELECT * FROM dvd WHERE STUDIO = ?";
    private static final String SQL_SEARCH_BY_TITLE = "SELECT * FROM dvd WHERE TITLE = ?";

    //Misc
    private static final String SQL_GET_AVERAGE_DAYS = "SELECT AVG(TO_DAYS(RELEASE_DATE)) FROM dvd";
    private static final String SQL_GET_CURRENT_DAYS = "SELECT TO_DAYS(CURDATE())";
    //private static final String SQL_GET_AVERAGE_UNIX_TIME = "SELECT AVG(UNIX_TIMESTAMP(RELEASE_DATE)) FROM dvd";
    private static final String SQL_SEARCH_NEWEST = "SELECT * FROM dvd d1 WHERE RELEASE_DATE = (SELECT MAX(d2.RELEASE_DATE) FROM dvd d2);";
    private static final String SQL_SEARCH_OLDEST = "SELECT * FROM dvd d1 WHERE RELEASE_DATE = (SELECT MIN(d2.RELEASE_DATE) FROM dvd d2);";
    private static final String SQL_GET_TOTAL_NOTES = "SELECT COUNT(DISTINCT ID) FROM note";
    private static final String SQL_GET_TOTAL_DVDS = "SELECT COUNT(DISTINCT ID) FROM dvd";

    private JdbcTemplate jdbcTemplate;

    @Override
    public Dvd create(Dvd dvd) {

        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio());

        Integer id = jdbcTemplate.queryForObject(SQL_GET_LAST_ID, Integer.class);
        dvd.setId(id);

        return dvd;

    }

    @Override
    public void update(Dvd dvd) {

        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getId());

    }

    @Override
    public Dvd get(Integer id) {

        Dvd dvd = jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), id);
        
        List<Note> notes = jdbcTemplate.query(SQL_GET_DVD_NOTES, new NoteMapper(), dvd.getId());
        
        dvd.setNotes(notes);
        
        return dvd;

    }

    @Override
    public void delete(Integer id) {

        jdbcTemplate.update(SQL_DELETE_DVD, id);

    }

    @Override
    public List<Dvd> list() {

        return jdbcTemplate.query(SQL_GET_ALL_DVDS, new DvdMapper());

    }

    @Override
    public List<Dvd> searchNewerThanYear(Integer year) {

        Date date = new Date(year - 1900, 11, 31);
        return jdbcTemplate.query(SQL_SEARCH_AFTER_YEAR, new DvdMapper(), date);

    }

    @Override
    public List<Dvd> searchByMpaaRating(String rating) {

        return jdbcTemplate.query(SQL_SEARCH_BY_RATING, new DvdMapper(), rating);

    }

    @Override
    public List<Dvd> searchByDirector(String director) {

        return jdbcTemplate.query(SQL_SEARCH_BY_DIRECTOR, new DvdMapper(), director);

    }

    @Override
    public List<Dvd> searchByStudio(String studio) {

        return jdbcTemplate.query(SQL_SEARCH_BY_STUDIO, new DvdMapper(), studio);

    }

    @Override
    public List<Dvd> searchByTitle(String title) {

        return jdbcTemplate.query(SQL_SEARCH_BY_TITLE, new DvdMapper(), title);

    }

    @Override
    public double getAverageAge() {

        //Numbers of seconds since 1970 until avg of release dates
//        Double ageSeconds = jdbcTemplate.queryForObject(SQL_GET_AVERAGE_UNIX_TIME, Double.class);
//        Double movieDays = ageSeconds / (60 * 60 * 24);
//        
//        double currentDays = new Date().getTime() / (1000 * 60 * 60 * 24);
//        
//        double result = currentDays - movieDays;
        
        double movieDays = jdbcTemplate.queryForObject(SQL_GET_AVERAGE_DAYS, Double.class);
        double currentDays = jdbcTemplate.queryForObject(SQL_GET_CURRENT_DAYS, Double.class);
        
        double result = currentDays - movieDays;

        return result;

    }

    @Override
    public double getAverageNumberOfNotes() {

        Double numNotes = jdbcTemplate.queryForObject(SQL_GET_TOTAL_NOTES, Double.class);
        Double numDvds = jdbcTemplate.queryForObject(SQL_GET_TOTAL_DVDS, Double.class);

        return numNotes / numDvds;

    }

    @Override
    public Dvd findNewestDvd() {

        return jdbcTemplate.queryForObject(SQL_SEARCH_NEWEST, new DvdMapper());
    }

    @Override
    public Dvd findOldestDvd() {

        return jdbcTemplate.queryForObject(SQL_SEARCH_OLDEST, new DvdMapper());

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //MAPPERS
    private static final class DvdMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {

            Dvd dvd = new Dvd();
            dvd.setId(rs.getInt("ID"));
            dvd.setTitle(rs.getString("TITLE"));
            dvd.setReleaseDate(rs.getDate("RELEASE_DATE"));
            dvd.setMpaaRating(rs.getString("MPAA_RATING"));
            dvd.setDirector(rs.getString("DIRECTOR"));
            dvd.setStudio(rs.getString("STUDIO"));

            return dvd;

        }

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
