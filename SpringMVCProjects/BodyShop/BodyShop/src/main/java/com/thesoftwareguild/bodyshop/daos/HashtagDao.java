/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import java.util.List;

/**
 *
 * @author Chris Myung
 */
public interface HashtagDao {
    
    public Hashtag addHashtag(Hashtag hashtag);
    
    public void updateHashtag(Hashtag hashtag);
    
    public Hashtag getHashtag(Integer hashtagId);
    
    public void deleteHashtag(Integer hashtagId);
    
    public List<Hashtag> list();
    
    
}
