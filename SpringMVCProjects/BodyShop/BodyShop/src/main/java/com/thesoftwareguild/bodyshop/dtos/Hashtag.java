/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.dtos;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Chris Myung
 */
public class Hashtag {
    
    @NotEmpty
    @Size(min = 1, max = 20)
    private Integer hashtagId;
    
    @NotEmpty
    @Size(min = 2, max = 200)
    private String hashtagName;

    public Integer getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(Integer hashtagId) {
        this.hashtagId = hashtagId;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }
    
    
    
}
