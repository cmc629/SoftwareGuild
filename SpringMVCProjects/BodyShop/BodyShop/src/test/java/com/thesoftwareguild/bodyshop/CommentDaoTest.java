

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop;

import com.thesoftwareguild.bodyshop.daos.BlogEntryDao;
import com.thesoftwareguild.bodyshop.daos.CommentDao;
import com.thesoftwareguild.bodyshop.daos.EntryCategoryDao;
import com.thesoftwareguild.bodyshop.daos.HashtagDao;
import com.thesoftwareguild.bodyshop.daos.UserDao;
import com.thesoftwareguild.bodyshop.dtos.BlogEntry;
import com.thesoftwareguild.bodyshop.dtos.Comment;
import com.thesoftwareguild.bodyshop.dtos.EntryCategory;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
import com.thesoftwareguild.bodyshop.dtos.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class CommentDaoTest {
    
    private CommentDao cDao;
    private BlogEntryDao bDao;
    private HashtagDao hDao;
    private UserDao uDao;
    private EntryCategoryDao eDao;
    
    SimpleDateFormat sdf;
    
    Comment c1, c2, c3, c4, c5;
    BlogEntry b1, b2, b3;
    Hashtag h1, h2, h3, h4;
    User u1, u2, u3;
    EntryCategory e1, e2, e3, e4, e5;
    
    List<Hashtag> hList1, hList2, hList3;
    
    
    public CommentDaoTest() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        cDao = ctx.getBean("commentDao", CommentDao.class);
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
        
        
        b1 = new BlogEntry();
        b1.setAuthor(uDao.getUser(u1.getUserId()));
        //e1.setUserId(u1.getUserId());
        b1.setCategory(eDao.getEntryCategory(ec1Added.getEntryCategoryId()));
        //e1.setCategoryId(ec1Added.getEntryCategoryId());
        b1.setContent("Hello World");
        b1.setDateCreated(sdf.parse("2015-05-17"));
        b1.setDateExpired(sdf.parse("2015-10-17"));
        b1.setHashtags(hList1);
        b1.setTitle("Hello");
        bDao.addEntry(b1);
        
        
        b2 = new BlogEntry();
        b2.setAuthor(uDao.getUser(u2.getUserId()));
        b2.setCategory(eDao.getEntryCategory(ec2Added.getEntryCategoryId()));
        b2.setContent("A day of sales");
        b2.setDateCreated(sdf.parse("2010-10-22"));
        b2.setDateExpired(sdf.parse("2015-12-25"));
        b2.setHashtags(hList2);
        b2.setTitle("Sell everything");
        bDao.addEntry(b2);
        
        b3 = new BlogEntry();
        b3.setAuthor(uDao.getUser(u3.getUserId()));
        b3.setCategory(eDao.getEntryCategory(ec3Added.getEntryCategoryId()));
        b3.setContent("Crossfit is plain silly");
        b3.setDateCreated(sdf.parse("2015-01-15"));
        b3.setDateExpired(sdf.parse("2015-06-15"));
        b3.setHashtags(hList3);
        b3.setTitle("Sell everything");
        bDao.addEntry(b3);
        
        c1 = new Comment();
        c2 = new Comment();
        c3 = new Comment();
        c4 = new Comment();
        
        c1.setAuthor(uDao.getUser(u1.getUserId()));
        c1.setEntryId(b1.getEntryId());
        c1.setHashtags(hList1);
        c1.setContent("This was so much fun");
        
        c2.setAuthor(uDao.getUser(u2.getUserId()));
        c2.setEntryId(b2.getEntryId());
        c2.setHashtags(hList2);
        c2.setContent("This was so irritating");
        
        c3.setAuthor(uDao.getUser(u3.getUserId()));
        c3.setEntryId(b3.getEntryId());
        c3.setHashtags(hList3);
        c3.setContent("This was so not fun at all");
        
        c4.setAuthor(uDao.getUser(u2.getUserId()));
        c4.setEntryId(b2.getEntryId());
        c4.setHashtags(hList3);
        c4.setContent("Why does Joe where shirts from baby GAP?");
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGetCommentTest() {
        
        Comment addedC1 = cDao.addComment(c1);
        
        Comment c1FromDb = cDao.getComment(addedC1.getCommentId());
        
        Assert.assertEquals(addedC1.getContent(), c1FromDb.getContent());
        
    }
    
    @Test
    public void updateCommentTest() {
        
        Comment addedC1 = cDao.addComment(c1);
        
        Comment editedC1 = new Comment();
        editedC1.setAuthor(uDao.getUser(u1.getUserId()));
        editedC1.setEntryId(b1.getEntryId());
        editedC1.setCommentId(addedC1.getCommentId());
        editedC1.setHashtags(hList2);
        editedC1.setContent("Not as much fun");
        
        cDao.updateComment(editedC1);
        
        Comment c1FromDb = cDao.getComment(addedC1.getCommentId());
        
        Assert.assertEquals(editedC1.getContent(), c1FromDb.getContent());
        Assert.assertEquals(editedC1.getHashtags().get(0).getHashtagId(), c1FromDb.getHashtags().get(0).getHashtagId());
        
    }
    
    @Test
    public void deleteCommentTest() {
        
        Comment addedC1 = cDao.addComment(c1);
        Comment addedC2 = cDao.addComment(c2);
        Comment addedC3 = cDao.addComment(c3);
        
        //Comment cFromDb = cDao.getComment(addedC1.getCommentId());
        
        int expectedSizeBeforeDeletion = 3;
        
        Assert.assertEquals(expectedSizeBeforeDeletion, cDao.listAllComments().size());
        
    }
    
    @Test
    public void listCommentTest() {
        
        Comment addedC1 = cDao.addComment(c1);
        Comment addedC2 = cDao.addComment(c2);
        Comment addedC3 = cDao.addComment(c3);
        
        List<Comment> result = cDao.listAllComments();
        
        Assert.assertEquals(addedC1.getCommentId(), result.get(0).getCommentId());
        Assert.assertEquals(addedC3.getCommentId(), result.get(2).getCommentId());
        
    }
    
    @Test
    public void commentListByEntryTest() {
        
        Comment addedC1 = cDao.addComment(c1);
        Comment addedC2 = cDao.addComment(c2);
        Comment addedC3 = cDao.addComment(c3);
        Comment addedC4 = cDao.addComment(c4);
        
        //comment 2 & 4 is under the same blog entry
        
        List<Comment> result = cDao.commentListByEntry(b2.getEntryId());
        
        int expectedSizeOfList = 2;
        
        Assert.assertEquals(expectedSizeOfList, result.size());
    }
    
    @Test
    public void commentListByHashTag() {
        
        Comment addedC1 = cDao.addComment(c1);
        Comment addedC2 = cDao.addComment(c2);
        Comment addedC3 = cDao.addComment(c3);
        Comment addedC4 = cDao.addComment(c4);
        
        //h2 is in all. h1 is in only C1 C3 & C4
        
        List<Comment> h2Result = cDao.searchByHashTagId(h2.getHashtagId());
        
        int expectedListSizeOfH2Search = 4;
        
        Assert.assertEquals(expectedListSizeOfH2Search, h2Result.size());
        
        List<Comment> h1Result = cDao.searchByHashTagId(h1.getHashtagId());
        int expectedListSizeOfH1Search = 3;
        
        Assert.assertEquals(expectedListSizeOfH1Search, h1Result.size());
        
    }
    
}
