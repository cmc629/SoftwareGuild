/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop;

import com.thesoftwareguild.bodyshop.daos.EntryCategoryDao;
import com.thesoftwareguild.bodyshop.dtos.EntryCategory;
import junit.framework.Assert;
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
public class EntryCategoryDaoTest {
    
    private EntryCategoryDao ecDao;
    
    EntryCategory ec1, ec2, ec3, ec4, ec5;
    
    public EntryCategoryDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    
        
        ecDao = ctx.getBean("entryCategoryDao", EntryCategoryDao.class);
        
        
        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        template.execute("DELETE FROM comment_hashtag");
        template.execute("DELETE FROM comment");
        template.execute("DELETE FROM entry_hashtag");
        template.execute("DELETE FROM hashtag");
        template.execute("DELETE FROM entry");
        template.execute("DELETE FROM entry_category");
        template.execute("DELETE FROM user");
        
        ec1 = new EntryCategory();
        ec2 = new EntryCategory();
        ec3 = new EntryCategory();
        ec4 = new EntryCategory();
        ec5 = new EntryCategory();
        
        ec1.setEntryCategoryName("Promotion");
        ec2.setEntryCategoryName("Education");
        ec3.setEntryCategoryName("Operation");
        ec4.setEntryCategoryName("Reflection");
        ec5.setEntryCategoryName("Random");
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGetEntryCategoryTest() {
        
        EntryCategory addedEc1 = ecDao.addEntryCategory(ec1);
        
        EntryCategory ec1FromDb = ecDao.getEntryCategory(addedEc1.getEntryCategoryId());
        
        Assert.assertEquals(addedEc1.getEntryCategoryName(),ec1FromDb.getEntryCategoryName());
        
    }
    
    @Test
    public void deleteListEntryCategoryTest() {
        
        EntryCategory ec1Added = ecDao.addEntryCategory(ec1);
        EntryCategory ec2Added = ecDao.addEntryCategory(ec2);
        EntryCategory ec3Added = ecDao.addEntryCategory(ec3);
        EntryCategory ec4Added = ecDao.addEntryCategory(ec4);
        EntryCategory ec5Added = ecDao.addEntryCategory(ec5);
        
        EntryCategory ec1FromDb = ecDao.getEntryCategory(ec1Added.getEntryCategoryId());
        EntryCategory ec2FromDb = ecDao.getEntryCategory(ec2Added.getEntryCategoryId());
        EntryCategory ec3FromDb = ecDao.getEntryCategory(ec3Added.getEntryCategoryId());
        EntryCategory ec4FromDb = ecDao.getEntryCategory(ec4Added.getEntryCategoryId());
        EntryCategory ec5FromDb = ecDao.getEntryCategory(ec5Added.getEntryCategoryId());
        
        int expectedSizeBeforeDeletion = 5;
        
        Assert.assertEquals(expectedSizeBeforeDeletion, ecDao.list().size());
        
        ecDao.deleteEntryCategory(ec2Added.getEntryCategoryId());
        
        int expectedSizeAfterDeletion = 4;
        
        Assert.assertEquals(expectedSizeAfterDeletion, ecDao.list().size());
    }
    
    @Test
    public void updateEntryCategoryTest() {
        
        EntryCategory ec1Added = ecDao.addEntryCategory(ec1);
        
        EntryCategory editedEc1 = new EntryCategory();
        editedEc1.setEntryCategoryId(ec1Added.getEntryCategoryId());
        editedEc1.setEntryCategoryName("Black Friday");
        
        ecDao.updateEntryCategory(editedEc1);
        
        EntryCategory ec1FromDb = ecDao.getEntryCategory(ec1Added.getEntryCategoryId());
        
        Assert.assertEquals(editedEc1.getEntryCategoryId(), ec1FromDb.getEntryCategoryId());
    }
    
}
