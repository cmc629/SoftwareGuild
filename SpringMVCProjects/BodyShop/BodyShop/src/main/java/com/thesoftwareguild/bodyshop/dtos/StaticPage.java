/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Christian Choi
 */
public class StaticPage {
    
    private Integer staticPageId;
    
    @NotEmpty
    @Size(min = 1, max = 100)
    private String title;
    
    @NotEmpty
    private String content;
    
    public Integer getStaticPageId() {
        return staticPageId;
    }

    public void setStaticPageId(Integer staticPageId) {
        this.staticPageId = staticPageId;
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
    
    
    
}
