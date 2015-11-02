/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.BlogEntry;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Chris Myung
 */
public interface BlogEntryDao {
    
    public BlogEntry addEntry(BlogEntry entry);
    
    public void updateEntry(BlogEntry entry);
    
    public BlogEntry getEntry(Integer entryId);
    
    public void deleteEntry(Integer entryId);
    
    public List<BlogEntry> list();
    
    public List<BlogEntry> searchAfterDate(Date date);
    
    public List<BlogEntry> searchByHashtagId(Integer hashtagId);
    
    public List<BlogEntry> sortByNewestEntry();
    
    public List<BlogEntry> sortByOldestEntry();
}
