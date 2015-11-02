/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.BlogEntry;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chris Myung
 */
public class BlogEntryDaoDbImpl implements BlogEntryDao {

    private static final String SQL_INSERT_ENTRY = "INSERT INTO entry (AUTHOR_ID, CATEGORY_ID, ENTRY_TITLE, DATE_CREATED, DATE_EXPIRED, ENTRY_CONTENT) "
            + "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_GET_LAST_ENTRY_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_SELECT_ENTRY = "SELECT * FROM entry WHERE ENTRY_ID = ?";
    private static final String SQL_UPDATE_ENTRY = "UPDATE entry SET AUTHOR_ID = ?, CATEGORY_ID = ?, ENTRY_TITLE = ?, ENTRY_CONTENT = ?, DATE_CREATED = ?, DATE_EXPIRED = ? WHERE ENTRY_ID = ?";
    private static final String SQL_DELETE_ENTRY = "DELETE FROM entry WHERE ENTRY_ID = ?";
    private static final String SQL_GET_ALL_ENTRY = "SELECT * FROM entry";
    //private static final String SQL_GET_HASHTAGS = "SELECT * FROM hashtag WHERE ENTRY_ID = ?"; I don't think we need this

    private static final String SQL_SEARCH_FOR_AFTER_DATE = "SELECT * FROM entry WHERE unix_timestamp(DATE_CREATED)  > ?";
    //private static final String SQL_SEARCH_BY_HASHTAG_ID = "";

    private static final String SQL_GET_ENTRY_BY_NEWEST = "SELECT * FROM entry ORDER BY DATE_CREATED DESC";
    private static final String SQL_GET_ENTRY_BY_OLDEST = "SELECT * FROM entry ORDER BY DATE_CREATED ASC";

    //entry_hashtag bridge table SQL
    private static final String SQL_INSERT_ENTRY_HASHTAG = "INSERT INTO entry_hashtag (ENTRY_ID, HASHTAG_ID) VALUES(?, ?)";
    private static final String SQL_DELETE_ENTRY_HASHTAG = "DELETE FROM entry_hashtag WHERE ENTRY_ID = ?";
    private static final String SQL_GET_HASHTAG_IDS = "SELECT HASHTAG_ID FROM entry_hashtag WHERE ENTRY_ID = ?";
    private static final String SQL_GET_HASHTAGS = "SELECT * FROM hashtag";
    private static final String SQL_GET_ENTRY_IDS = "SELECT ENTRY_ID FROM entry_hashtag WHERE HASHTAG_ID = ?";

    private JdbcTemplate jdbcTemplate;
    private HashtagDao hDao;
    private EntryCategoryDao eDao;
    private UserDao uDao;

    public BlogEntryDaoDbImpl(HashtagDao hDao, EntryCategoryDao eDao, UserDao uDao) {
        this.hDao = hDao;
        this.eDao = eDao;
        this.uDao = uDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BlogEntry addEntry(BlogEntry entry) {

        jdbcTemplate.update(SQL_INSERT_ENTRY,
                entry.getAuthor().getUserId(),
                entry.getCategory().getEntryCategoryId(),
                entry.getTitle(),
                entry.getDateCreated(),
                entry.getDateExpired(),
                entry.getContent());

        entry.setEntryId(jdbcTemplate.queryForObject(SQL_GET_LAST_ENTRY_ID, Integer.class));

        List<Hashtag> hashtags = entry.getHashtags();
        for (Hashtag hashtag : hashtags) {
            jdbcTemplate.update(SQL_INSERT_ENTRY_HASHTAG,
                    entry.getEntryId(),
                    hashtag.getHashtagId());
        }

        return entry;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEntry(BlogEntry entry) {

        jdbcTemplate.update(SQL_UPDATE_ENTRY,
                entry.getAuthor().getUserId(),
                entry.getCategory().getEntryCategoryId(),
                entry.getTitle(),
                entry.getContent(),
                entry.getDateCreated(),
                entry.getDateExpired(),
                entry.getEntryId());

        jdbcTemplate.update(SQL_DELETE_ENTRY_HASHTAG, entry.getEntryId());

        List<Hashtag> hashtags = entry.getHashtags();
        for (Hashtag hashtag : hashtags) {
            jdbcTemplate.update(SQL_INSERT_ENTRY_HASHTAG,
                    entry.getEntryId(),
                    hashtag.getHashtagId());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BlogEntry getEntry(Integer entryId) {

        BlogEntry entry = jdbcTemplate.queryForObject(SQL_SELECT_ENTRY, new EntryMapper(), entryId);

        List<Integer> hashtagIds = jdbcTemplate.queryForList(SQL_GET_HASHTAG_IDS, Integer.class, entryId);

        List<Hashtag> hashtags = new ArrayList<>();

        List<Hashtag> allHashtags = hDao.list();

        for (Hashtag hashtag : allHashtags) {
            if (hashtagIds.contains(hashtag.getHashtagId())) {
                hashtags.add(hashtag);
            }
        }

        entry.setHashtags(hashtags);

        return entry;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteEntry(Integer entryId) {

        jdbcTemplate.update(SQL_DELETE_ENTRY_HASHTAG, entryId);

        jdbcTemplate.update(SQL_DELETE_ENTRY, entryId);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BlogEntry> list() {

        return jdbcTemplate.query(SQL_GET_ALL_ENTRY, new EntryMapper());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BlogEntry> searchAfterDate(Date date) {

        return jdbcTemplate.query(SQL_SEARCH_FOR_AFTER_DATE, new EntryMapper(), date.getTime() / 1000);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BlogEntry> searchByHashtagId(Integer hashtagId) {

        List<Integer> entryIds = jdbcTemplate.queryForList(SQL_GET_ENTRY_IDS, Integer.class, hashtagId);
        
        List<BlogEntry> entries = new ArrayList<>();
        
        entryIds.stream().map((integer) -> this.getEntry(integer)).forEach((entryToAdd) -> {
            entries.add(entryToAdd);
        });
        
        return entries;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BlogEntry> sortByNewestEntry() {

        return jdbcTemplate.query(SQL_GET_ENTRY_BY_NEWEST, new EntryMapper());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<BlogEntry> sortByOldestEntry() {

        return jdbcTemplate.query(SQL_GET_ENTRY_BY_OLDEST, new EntryMapper());

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final class EntryMapper implements RowMapper<BlogEntry> {

        @Override
        public BlogEntry mapRow(ResultSet rs, int i) throws SQLException {

            BlogEntry entry = new BlogEntry();
            entry.setEntryId(rs.getInt("ENTRY_ID"));
            entry.setCategory(eDao.getEntryCategory(rs.getInt("CATEGORY_ID")));
            entry.setAuthor(uDao.getUser(rs.getInt("AUTHOR_ID")));
            entry.setTitle(rs.getString("ENTRY_TITLE"));
            entry.setDateCreated(rs.getDate("DATE_CREATED"));
            entry.setDateExpired(rs.getDate("DATE_EXPIRED"));
            entry.setContent(rs.getString("ENTRY_CONTENT"));
            
            List <Hashtag> allHashtags = hDao.list();
            
            List <Hashtag> entryHashtags = new ArrayList<>();
            
            List <Integer> hashtagIds = jdbcTemplate
                    .queryForList(SQL_GET_HASHTAG_IDS, 
                            Integer.class, entry.getEntryId());
            
            hashtagIds.stream().forEach((num) -> {
              allHashtags.stream().filter((hashtag) -> 
                      (Objects.equals(num, hashtag.getHashtagId())))
                      .forEach((hashtag) -> {entryHashtags.add(hashtag);});
            });
            
            entry.setHashtags(entryHashtags);

            return entry;

        }

    }

}
