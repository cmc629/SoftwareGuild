/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop;

import com.thesoftwareguild.bodyshop.daos.StaticPageDao;
import com.thesoftwareguild.bodyshop.dtos.StaticPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Christian Choi
 */
public class StaticPageDaoTest {
    
    private StaticPageDao dao;
    
    public StaticPageDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = ctx.getBean("staticPageDao", StaticPageDao.class);
        
        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        
        template.execute("DELETE FROM static_page");
        
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testCreateAndGet() {
        
        //Create a static page and add to database
        StaticPage staticPage = new StaticPage();
        staticPage.setTitle("Classes");
        staticPage.setContent("Here are the available courses we offer: Spinning and Yoga");
        
        dao.create(staticPage);
        
        //Get the static page from the database
        StaticPage fromDb = dao.get(staticPage.getStaticPageId());
        
        //Test if fields from the created and retrieved static page objects are equal
        Assert.assertEquals(staticPage.getTitle(), fromDb.getTitle());
        Assert.assertEquals(staticPage.getContent(), fromDb.getContent());
        
    }
    
    @Test
    public void testList() {
        
        //Create and add static page. Check list size = 1
        StaticPage sp1 = new StaticPage();
        sp1.setTitle("Classes");
        sp1.setContent("Here are the available courses we offer: Spinning and Yoga");
        
        dao.create(sp1);
        
        Assert.assertEquals(1, dao.list().size());
        
        //Create and add second static page. Check list size = 2
        StaticPage sp2 = new StaticPage();
        sp2.setTitle("Trainers");
        sp2.setContent("We only have one trainer: Pat Toner");
        
        dao.create(sp2);
        
        Assert.assertEquals(2, dao.list().size());
        
        
    }
    
    @Test
    public void testUpdate() {
        
        //Create and add a static page
        StaticPage sp1 = new StaticPage();
        sp1.setTitle("Classes");
        sp1.setContent("Here are the available courses we offer: Spinning and Yoga");
        
        //create
        dao.create(sp1);
        
        //Create an updated static page with the same id as the first static page
        StaticPage sp2 = new StaticPage();
        sp2.setStaticPageId(sp1.getStaticPageId());
        sp2.setTitle("Trainers");
        sp2.setContent("We only have one trainer: Pat Toner");
        
        //update
        dao.update(sp2);
        
        //Retrieve the static page object from db and check to see if fields are equal
        StaticPage fromDb = dao.get(sp1.getStaticPageId());
        
        Assert.assertEquals(sp2.getTitle(), fromDb.getTitle());
        Assert.assertEquals(sp2.getContent(), fromDb.getContent());
        
        //Also check if the list size is 1
        Assert.assertEquals(1, dao.list().size());
        
    }
    
    @Test
    public void testDelete() {
        
        //Create a static page and add to database
        StaticPage staticPage = new StaticPage();
        staticPage.setTitle("Classes");
        staticPage.setContent("Here are the available courses we offer: Spinning and Yoga");
        
        dao.create(staticPage);
        
        //Delete the staticPage
        dao.delete(staticPage.getStaticPageId());
        
        //Check to see if list is empty
        Assert.assertTrue(dao.list().isEmpty());
        
    }
    
}
