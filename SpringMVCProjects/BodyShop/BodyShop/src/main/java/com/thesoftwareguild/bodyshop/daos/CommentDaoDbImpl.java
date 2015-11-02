/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.Comment;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chris Myung
 */
public class CommentDaoDbImpl implements CommentDao{
    
    private static final String SQL_INSERT_COMMENT = "INSERT INTO comment (USER_ID, ENTRY_ID, CONTENT) VALUES (?, ?, ?)";
    private static final String SQL_GET_LAST_COMMENT_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_SELECT_COMMENT = "SELECT * FROM comment WHERE COMMENT_ID = ?";
    private static final String SQL_UPDATE_COMMENT = "UPDATE comment SET USER_ID = ?, ENTRY_ID = ?, CONTENT = ? WHERE COMMENT_ID = ?";
    private static final String SQL_DELETE_COMMENT = "DELETE FROM comment WHERE COMMENT_ID = ?";
    private static final String SQL_GET_ALL_COMMENTS = "SELECT * FROM comment";
    private static final String SQL_GET_COMMENTS_BY_ENTRY_ID = "SELECT * FROM comment WHERE ENTRY_ID = ?";
    //private static final String SQL_GET_COMMENTS_BY_HASHTAG_ID = "SELECT COMMENT_ID FROM comment_hashtag WHERE HASHTAG_ID = ?";
    
    private static final String SQL_INSERT_COMMENT_HASHTAG = "INSERT INTO comment_hashtag (COMMENT_ID, HASHTAG_ID) VALUES(?, ?)";
    private static final String SQL_DELETE_COMMENT_HASHTAG = "DELETE FROM comment_hashtag WHERE COMMENT_ID = ?";
    private static final String SQL_GET_HASHTAG_IDS = "SELECT HASHTAG_ID FROM comment_hashtag WHERE COMMENT_ID = ?";
    private static final String SQL_GET_COMMENT_IDS = "SELECT COMMENT_ID FROM comment_hashtag WHERE HASHTAG_ID = ?";
    
    
    
    private JdbcTemplate jdbcTemplate;
    private final BlogEntryDao eDao;
    private final HashtagDao hDao;
    private final UserDao uDao;
    
    public CommentDaoDbImpl(BlogEntryDao eDao, HashtagDao hDao, UserDao uDao) {
        this.eDao = eDao;
        this.hDao = hDao;
        this.uDao = uDao;
    }
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Comment addComment(Comment comment) {
        
        jdbcTemplate.update(SQL_INSERT_COMMENT,
                comment.getAuthor().getUserId(),
                comment.getEntryId(),
                comment.getContent());

        comment.setCommentId(jdbcTemplate.queryForObject(SQL_GET_LAST_COMMENT_ID, Integer.class));
        
        List<Hashtag> hashtags = comment.getHashtags();
        for (Hashtag hashtag : hashtags) {
            jdbcTemplate.update(SQL_INSERT_COMMENT_HASHTAG,
                    comment.getCommentId(),
                    hashtag.getHashtagId());
        }
        
        return comment;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateComment(Comment comment) {

        jdbcTemplate.update(SQL_UPDATE_COMMENT, 
                comment.getAuthor().getUserId(),
                comment.getEntryId(),
                comment.getContent(),
                comment.getCommentId());
        
        jdbcTemplate.update(SQL_DELETE_COMMENT_HASHTAG, comment.getCommentId());
        
        List<Hashtag> hashtags = comment.getHashtags();
        for (Hashtag hashtag : hashtags) {
            jdbcTemplate.update(SQL_INSERT_COMMENT_HASHTAG,
                    comment.getCommentId(),
                    hashtag.getHashtagId());
        }
        
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Comment getComment(Integer commentId) {

        Comment comment = jdbcTemplate.queryForObject(SQL_SELECT_COMMENT, new CommentMapper(), commentId);
        
        List<Integer> hashtagIds = jdbcTemplate.queryForList(SQL_GET_HASHTAG_IDS, Integer.class, commentId);
        
        List<Hashtag> hashtags = new ArrayList<>();
        
        List<Hashtag> allHashtags = hDao.list();
        
        for (Hashtag hashtag : allHashtags) {
            if (hashtagIds.contains(hashtag.getHashtagId())) {
                hashtags.add(hashtag);
            }
        }
        
        comment.setHashtags(hashtags);
        
        return comment;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteComment(Integer commentId) {
        
        jdbcTemplate.update(SQL_DELETE_COMMENT_HASHTAG, commentId);
        
        jdbcTemplate.update(SQL_DELETE_COMMENT, commentId);
        
        
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Comment> listAllComments() {
        
        return jdbcTemplate.query(SQL_GET_ALL_COMMENTS, new CommentMapper());
        
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Comment> commentListByEntry(Integer entryId) {
        
        return jdbcTemplate.query(SQL_GET_COMMENTS_BY_ENTRY_ID, new CommentMapper(), entryId);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Comment> searchByHashTagId(Integer hashtagId) {
        
        List<Integer> commentIds = jdbcTemplate.queryForList(SQL_GET_COMMENT_IDS, Integer.class, hashtagId);
        
        List<Comment> comments = new ArrayList<>();
        
        commentIds.stream().map((integer) -> this.getComment(integer)).forEach((commentToAdd) -> {
            comments.add(commentToAdd);
        });
        
        return comments;
        
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final class CommentMapper implements RowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            
            Comment comment = new Comment();
            comment.setCommentId(rs.getInt("COMMENT_ID"));
            comment.setAuthor(uDao.getUser(rs.getInt("USER_ID")));
            comment.setEntryId(rs.getInt("ENTRY_ID"));
            comment.setContent(rs.getString("CONTENT"));
            
            return comment;
        }
        
    }
    
}
