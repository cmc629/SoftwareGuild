/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop;

import com.thesoftwareguild.bodyshop.daos.HashtagDao;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import java.util.ArrayList;
import java.util.List;
//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Chris Myung
 */
public class HashtagDaoTest {
    
    private HashtagDao hDao;
    
    Hashtag h1, h2, h3, h4;
    
    List<Hashtag> hList1, hList2, hList3;
    
    public HashtagDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        hDao = ctx.getBean("hashtagDao", HashtagDao.class);
        
        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        template.execute("DELETE FROM entry_hashtag");
        template.execute("DELETE FROM hashtag");
        
        h1 = new Hashtag();
        h2 = new Hashtag();
        h3 = new Hashtag();
        h4 = new Hashtag();
        
        h1.setHashtagName("fun");
        h2.setHashtagName("exciting");
        h3.setHashtagName("horrible");
        h4.setHashtagName("boring");
        
        hList1 = new ArrayList<>();
        hList1.add(h1);
        hList1.add(h2);
        
        hList2 = new ArrayList<>();
        hList2.add(h2);
        hList2.add(h3);
        
        hList3 = new ArrayList<>();
        hList3.add(h1);
        hList3.add(h2);
        hList3.add(h3);
        hList3.add(h4);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGetHashtagTest() {
        
        Hashtag addedH1 = hDao.addHashtag(h1);
        Hashtag addedH2 = hDao.addHashtag(h2);
        
        Hashtag fromDbH1 = hDao.getHashtag(addedH1.getHashtagId());
        
        Assert.assertEquals(addedH1.getHashtagName(), fromDbH1.getHashtagName());
        
        
    }
    
    @Test
    public void updateHashtagTest() {
        
        Hashtag addedH1 = hDao.addHashtag(h1);
        Hashtag editedH1 = new Hashtag();
        editedH1.setHashtagId(addedH1.getHashtagId());
        editedH1.setHashtagName("hilarious");
        
        hDao.updateHashtag(editedH1);
        
        Hashtag h1FromDb = hDao.getHashtag(addedH1.getHashtagId());
        
        Assert.assertEquals(editedH1.getHashtagId(), h1FromDb.getHashtagId());
        Assert.assertEquals(editedH1.getHashtagName(), h1FromDb.getHashtagName());
        Assert.assertNotEquals(editedH1.getHashtagName(),addedH1.getHashtagName());
        
    }
    
    @Test
    public void deleteListHashtagTest() {
        
        Hashtag addedH1 = hDao.addHashtag(h1);
        Hashtag addedH2 = hDao.addHashtag(h2);
        Hashtag addedH3 = hDao.addHashtag(h3);
        Hashtag addedH4 = hDao.addHashtag(h4);
        
        int expectedSizeBeforeDeletion = 4;
        
        List<Hashtag> dbList = hDao.list();
        
        Assert.assertEquals(expectedSizeBeforeDeletion, hDao.list().size());
        
        hDao.deleteHashtag(addedH2.getHashtagId());
        
        int expectedSizeAfterDeletion = 3; 
        
        Assert.assertEquals(expectedSizeAfterDeletion, hDao.list().size());
        
    }
    
   
    
    
}
