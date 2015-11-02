/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.dtos;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Chris Myung
 */
public class BlogEntry {
    
    
    @NotEmpty
    @Size(min = 1, max = 20)
    private Integer entryId;
    
    private User author;
    
//    @NotEmpty
//    @Size(min = 1, max = 20)
//    private Integer userId;
    
    @NotNull
    private Date dateCreated;
    
    private Date dateExpired;
    
    @NotEmpty
    @Size(min = 1, max = 200)
    private String title;
    
    @NotEmpty
    @Size(min = 1)
    private String content;
    
    private EntryCategory category;
//    @NotEmpty
//    @Size(min = 1, max = 100)
//    private Integer categoryId;
    
    private List<Hashtag> hashtags;

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public EntryCategory getCategory() {
        return category;
    }

    public void setCategory(EntryCategory category) {
        this.category = category;
    }
    
    
}
