package com.thesoftwareguild.bodyshop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thesoftwareguild.bodyshop.daos.BlogEntryDao;
import com.thesoftwareguild.bodyshop.daos.EntryCategoryDao;
import com.thesoftwareguild.bodyshop.daos.HashtagDao;
import com.thesoftwareguild.bodyshop.daos.UserDao;
import com.thesoftwareguild.bodyshop.dtos.BlogEntry;
import com.thesoftwareguild.bodyshop.dtos.EntryCategory;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import com.thesoftwareguild.bodyshop.dtos.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Chris Myung
 */
public class BlogEntryDaoTest {
    
    private BlogEntryDao bDao;
    private HashtagDao hDao;
    private UserDao uDao;
    private EntryCategoryDao eDao;
    SimpleDateFormat sdf;

    BlogEntry b1, b2, b3;
    Hashtag h1, h2, h3, h4;
    User u1, u2, u3;
    EntryCategory e1, e2, e3, e4, e5;
    
    List<Hashtag> hList1, hList2, hList3;

    public BlogEntryDaoTest() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("test-applicationContext.xml");

        
        bDao = ctx.getBean("blogEntryDao", BlogEntryDao.class);
        hDao = ctx.getBean("hashtagDao", HashtagDao.class);
        uDao = ctx.getBean("userDao", UserDao.class);
        eDao = ctx.getBean("entryCategoryDao", EntryCategoryDao.class);

        
        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        template.execute("DELETE FROM comment_hashtag");
        template.execute("DELETE FROM comment");
        template.execute("DELETE FROM entry_hashtag");
        template.execute("DELETE FROM hashtag");
        template.execute("DELETE FROM entry");
        template.execute("DELETE FROM entry_category");
        template.execute("DELETE FROM user");
        
        
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //Create Users and add them to User Table
        u1 = new User();
        u1.setFirstName("Jimbo");
        u1.setLastName("Fisher");
        u1.setGender("M");
        u1.setAge(50);
        u1.setEmail("SeminoleCoach@fsu.edu");
        u1.setPhone("315-454-4564");
        u1.setStreetNumber(1554);
        u1.setStreetName("Bowden Dr.");
        u1.setCity("Tallahassee");
        u1.setState("FL");
        u1.setZip(48634);
        uDao.addUser(u1);
        
        u2 = new User();
        u2.setFirstName("Jim");
        u2.setLastName("Harbaugh");
        u2.setGender("M");
        u2.setAge(54);
        u2.setEmail("WolverineCoach@um.edu");
        u2.setPhone("545-568-4544");
        u2.setStreetNumber(90955);
        u2.setStreetName("Schembechler Blvd.");
        u2.setCity("Ann Arbor");
        u2.setState("MI");
        u2.setZip(23213);
        uDao.addUser(u2);
        
        u3 = new User();
        u3.setFirstName("Byron");
        u3.setLastName("Scott");
        u3.setGender("M");
        u3.setAge(45);
        u3.setEmail("LakersCoach@lakers.com");
        u3.setPhone("213-555-1212");
        u3.setStreetNumber(3233);
        u3.setStreetName("Hearn Ave.");
        u3.setCity("Los Angeles");
        u3.setState("CA");
        u3.setZip(91254);
        uDao.addUser(u3);
        
        //Create hashtags and add them to hashtag table
        h1 = new Hashtag();
        h2 = new Hashtag();
        h3 = new Hashtag();
        h4 = new Hashtag();
        
        h1.setHashtagName("fun");
        h2.setHashtagName("exciting");
        h3.setHashtagName("horrible");
        h4.setHashtagName("boring");
        
        hDao.addHashtag(h1);
        hDao.addHashtag(h2);
        hDao.addHashtag(h3);
        hDao.addHashtag(h4);
        
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
        
        //Create entry categories and add them to entry_category table
        e1 = new EntryCategory();
        e2 = new EntryCategory();
        e3 = new EntryCategory();
        e4 = new EntryCategory();
        e5 = new EntryCategory();
        
        e1.setEntryCategoryName("Promotion");
        e2.setEntryCategoryName("Education");
        e3.setEntryCategoryName("Operation");
        e4.setEntryCategoryName("Reflection");
        e5.setEntryCategoryName("Random");
        
        EntryCategory ec1Added = eDao.addEntryCategory(e1);
        EntryCategory ec2Added = eDao.addEntryCategory(e2);
        EntryCategory ec3Added = eDao.addEntryCategory(e3);
        EntryCategory ec4Added = eDao.addEntryCategory(e4);
        EntryCategory ec5Added = eDao.addEntryCategory(e5);
        
        //Create blog entries
        b1 = new BlogEntry();
        b1.setAuthor(u1);
        b1.setCategory(ec1Added);
        b1.setContent("Hello World");
        b1.setDateCreated(sdf.parse("2015-05-17"));
        b1.setDateExpired(sdf.parse("2015-10-17"));
        b1.setHashtags(hList1);
        b1.setTitle("Hello");
        
        
        b2 = new BlogEntry();
        b2.setAuthor(u2);
        b2.setCategory(ec2Added);
        b2.setContent("A day of sales");
        b2.setDateCreated(sdf.parse("2010-10-22"));
        b2.setDateExpired(sdf.parse("2015-12-25"));
        b2.setHashtags(hList2);
        b2.setTitle("Sell everything");
        
        b3 = new BlogEntry();
        b3.setAuthor(u3);
        b3.setCategory(ec3Added);
        b3.setContent("Crossfit is plain silly");
        b3.setDateCreated(sdf.parse("2015-01-15"));
        b3.setDateExpired(sdf.parse("2015-06-15"));
        b3.setHashtags(hList3);
        b3.setTitle("Sell everything");
        
    }
    
    @After
    public void tearDown() {
    }
        

    @Test
    public void addGetEntryTest() {
        
        BlogEntry addedE1 = bDao.addEntry(b1);
        
        BlogEntry fromDb = bDao.getEntry(addedE1.getEntryId());
        
        Assert.assertEquals(addedE1.getContent(), fromDb.getContent());
        Assert.assertEquals(addedE1.getDateCreated(), fromDb.getDateCreated());
        Assert.assertEquals(addedE1.getDateExpired(), fromDb.getDateExpired());
        //Assert.assertEquals(addedE1.getUserId(), fromDb.getUserId());
        Assert.assertEquals(addedE1.getTitle(), fromDb.getTitle());
        //Assert.assertEquals(addedE1.getCategoryId(), fromDb.getCategoryId());
        Assert.assertEquals(addedE1.getHashtags().get(0).getHashtagId(), fromDb.getHashtags().get(0).getHashtagId());
        // TODO hashtags from DB are returning null.  
    }
    
    @Test
    public void updateEntryTest() throws ParseException{
        BlogEntry addedE1 = bDao.addEntry(b1);
        
        BlogEntry editedE1 = new BlogEntry();
        editedE1.setEntryId(addedE1.getEntryId());
        editedE1.setAuthor(addedE1.getAuthor());
        editedE1.setCategory(addedE1.getCategory());
        editedE1.setContent("Hello Universe");
        editedE1.setDateCreated(sdf.parse("2000-05-17"));
        editedE1.setDateExpired(sdf.parse("2000-10-17"));
        editedE1.setHashtags(hList3);
        editedE1.setTitle("GoodBye");
        
        bDao.updateEntry(editedE1);
        
        BlogEntry fromDbEntry = bDao.getEntry(addedE1.getEntryId());
        
        Assert.assertEquals(editedE1.getContent(), fromDbEntry.getContent());
        Assert.assertEquals(editedE1.getDateCreated(), fromDbEntry.getDateCreated());
        Assert.assertEquals(editedE1.getEntryId(), fromDbEntry.getEntryId());
        Assert.assertEquals(editedE1.getTitle(), fromDbEntry.getTitle());
        Assert.assertEquals(editedE1.getCategory().getEntryCategoryId(), fromDbEntry.getCategory().getEntryCategoryId());
        Assert.assertEquals(editedE1.getHashtags().get(0).getHashtagId(), fromDbEntry.getHashtags().get(0).getHashtagId());
        
    }
    
    @Test
    public void deleteEntryTest() throws ParseException {
        
        BlogEntry addedE3 = bDao.addEntry(b3);
        BlogEntry addedE2 = bDao.addEntry(b2);
        
        //BlogEntry fromDb = eDao.getEntry(addedE3.getEntryId());
        
        int expectedSizeBeforeDeletion = 2;
        
        Assert.assertEquals(expectedSizeBeforeDeletion, bDao.list().size());
        
        bDao.deleteEntry(b3.getEntryId());
        
        int expectedSizeAfterDeletion = 1;
        
        Assert.assertEquals(expectedSizeAfterDeletion, bDao.list().size());
        
        
    }
    
    @Test
    public void listBlogEntryTest() {
        
        BlogEntry addedE1 = bDao.addEntry(b1);
        BlogEntry addedE2 = bDao.addEntry(b2);
        BlogEntry addedE3 = bDao.addEntry(b3);
        
        List<BlogEntry> result = bDao.list();
        
        Assert.assertEquals(b1.getEntryId(), result.get(0).getEntryId());
        Assert.assertEquals(b3.getEntryId(), result.get(2).getEntryId());
        Assert.assertNotEquals(b1.getEntryId(), result.get(1).getEntryId());
    }
    
    @Test
    public void searchAfterDateTest() throws ParseException {
        
        BlogEntry addedE1 = bDao.addEntry(b1);
        BlogEntry addedE2 = bDao.addEntry(b2);
        BlogEntry addedE3 = bDao.addEntry(b3);
        
        Date d1 = sdf.parse("2014-01-01");
        
        List<BlogEntry> result = bDao.searchAfterDate(d1);
        
        int expectedListSize = 2;
        
        Assert.assertEquals(expectedListSize, result.size());
    }
    
    @Test
    public void sortByNewestEntryTest() {
        
        BlogEntry addedE1 = bDao.addEntry(b1);
        BlogEntry addedE2 = bDao.addEntry(b2);
        BlogEntry addedE3 = bDao.addEntry(b3);
        
        List<BlogEntry> result = bDao.sortByNewestEntry();
        
        BlogEntry newestEntry = addedE1;
        
        Assert.assertEquals(newestEntry.getEntryId(), result.get(0).getEntryId());
    }
    
    @Test
    public void sortByOldestEntryTest() {
        
        BlogEntry addedE1 = bDao.addEntry(b1);
        BlogEntry addedE2 = bDao.addEntry(b2);
        BlogEntry addedE3 = bDao.addEntry(b3);
        
        List<BlogEntry> result = bDao.sortByOldestEntry();
        
        BlogEntry oldestEntry = addedE2;
        
        Assert.assertEquals(oldestEntry.getEntryId(), result.get(0).getEntryId());
    }
    
    @Test
    public void searchByHashTagTest() {
        
        BlogEntry addedE1 = bDao.addEntry(b1);
        BlogEntry addedE2 = bDao.addEntry(b2);
        BlogEntry addedE3 = bDao.addEntry(b3);
        
        List<BlogEntry> resultH1 = bDao.searchByHashtagId(h1.getHashtagId());
        
        int expectedListSizeOfH1Search = 2;
        
        Assert.assertEquals(expectedListSizeOfH1Search, resultH1.size());
        
        List<BlogEntry> resultH2 = bDao.searchByHashtagId(h2.getHashtagId());
        
        int expectedListSizeOfH2Search = 3;
        
        Assert.assertEquals(expectedListSizeOfH2Search, resultH2.size());
        
    }
}
