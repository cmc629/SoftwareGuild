package com.thesoftwareguild.dvdlibrarymvc.models;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by patricktoner on 9/22/15.
 */
public class Note {
    
    private Integer id;
    
    @NotEmpty
    private String content;
    
    @NotNull
    private Integer dvdId;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDvdId() {
        return dvdId;
    }

    public void setDvdId(Integer dvdId) {
        this.dvdId = dvdId;
    }
    
    
    
}
