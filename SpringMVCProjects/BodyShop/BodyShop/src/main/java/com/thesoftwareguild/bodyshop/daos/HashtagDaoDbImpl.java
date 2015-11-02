/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chris Myung
 */
public class HashtagDaoDbImpl implements HashtagDao{
    
    private static final String SQL_INSERT_HASHTAG = "INSERT INTO hashtag (HASHTAG_NAME) VALUES(?)";
    private static final String SQL_GET_LAST_HASHTAG_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_SELECT_HASHTAG = "SELECT * FROM hashtag WHERE HASHTAG_ID = ?";
    private static final String SQL_UPDATE_HASHTAG = "UPDATE hashtag SET HASHTAG_NAME = ? WHERE HASHTAG_ID = ?";
    private static final String SQL_DELETE_HASHTAG = "DELETE FROM hashtag WHERE HASHTAG_ID = ?";
    private static final String SQL_GET_ALL_HASHTAGS = "SELECT * FROM hashtag";
    
    
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Hashtag addHashtag(Hashtag hashtag) {

        jdbcTemplate.update(SQL_INSERT_HASHTAG,
                hashtag.getHashtagName());
        
        Integer hashtagId = jdbcTemplate.queryForObject(SQL_GET_LAST_HASHTAG_ID, Integer.class);
        hashtag.setHashtagId(hashtagId);
        
        return hashtag;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateHashtag(Hashtag hashtag) {

        jdbcTemplate.update(SQL_UPDATE_HASHTAG,
                hashtag.getHashtagName(),
                hashtag.getHashtagId());
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Hashtag getHashtag(Integer hashtagId) {

        Hashtag hashtag = jdbcTemplate.queryForObject(SQL_SELECT_HASHTAG, new HashtagMapper(), hashtagId);
        
        return hashtag;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteHashtag(Integer hashtagId) {

        jdbcTemplate.update(SQL_DELETE_HASHTAG, hashtagId);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Hashtag> list() {
        
        List<Hashtag> result = jdbcTemplate.query(SQL_GET_ALL_HASHTAGS, new HashtagMapper());
        
        return result;
        
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class HashtagMapper implements RowMapper<Hashtag> {

        @Override
        public Hashtag mapRow(ResultSet rs, int i) throws SQLException {

            Hashtag hashtag = new Hashtag();
            hashtag.setHashtagId(rs.getInt("HASHTAG_ID"));
            hashtag.setHashtagName(rs.getString("HASHTAG_NAME"));
            
            return hashtag;
        }
        
    }
    
    
}
