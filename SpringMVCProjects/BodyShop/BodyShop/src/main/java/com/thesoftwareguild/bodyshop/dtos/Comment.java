/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.dtos;

import java.util.List;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Chris Myung
 */
public class Comment {
    
    @NotEmpty
    @Size(min = 1, max = 20)
    private Integer commentId;
    
//    @NotEmpty
//    @Size(min = 1, max = 20)
//    private Integer userId;
    
    private User author;
    
    @NotEmpty
    @Size(min = 1, max = 20)
    private Integer entryId;
    
    @NotEmpty
    @Size(min = 1)
    private String content;
    
    private List<Hashtag> hashtags;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
    
    
    
}
