/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop;

import com.thesoftwareguild.bodyshop.daos.UserDao;
import com.thesoftwareguild.bodyshop.dtos.User;
import java.util.List;
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
public class UserDaoTest {

    private UserDao uDao;

    User u1, u2, u3, u4;

    public UserDaoTest() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        uDao = ctx.getBean("userDao", UserDao.class);

        JdbcTemplate template = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        template.execute("DELETE FROM comment_hashtag");
        template.execute("DELETE FROM comment");
        template.execute("DELETE FROM entry_hashtag");
        template.execute("DELETE FROM hashtag");
        template.execute("DELETE FROM entry");
        template.execute("DELETE FROM entry_category");
        template.execute("DELETE FROM user");

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

        u4 = new User();
        u4.setFirstName("John");
        u4.setLastName("Harbaugh");
        u4.setGender("M");
        u4.setAge(56);
        u4.setEmail("RavensCoach@ravens.com");
        u4.setPhone("532-548-7697");
        u4.setStreetNumber(15035);
        u4.setStreetName("Flacco Rd.");
        u4.setCity("Baltimore");
        u4.setState("MD");
        u4.setZip(15433);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetUserTest() {

        User addedUser1 = uDao.addUser(u1);

        User user1FromDb = uDao.getUser(addedUser1.getUserId());

        Assert.assertEquals(addedUser1.getUserId(), user1FromDb.getUserId());
        Assert.assertEquals(addedUser1.getAge(), user1FromDb.getAge());
        Assert.assertEquals(addedUser1.getCity(), user1FromDb.getCity());
        Assert.assertEquals(addedUser1.getEmail(), user1FromDb.getEmail());

    }

    @Test
    public void deleteListUserTest() {
        User addedUser1 = uDao.addUser(u1);
        User addedUser2 = uDao.addUser(u2);
        User addedUser3 = uDao.addUser(u3);

        User user1FromDb = uDao.getUser(addedUser1.getUserId());
        User user2FromDb = uDao.getUser(addedUser2.getUserId());
        User user3FromDb = uDao.getUser(addedUser3.getUserId());

        int expectedSizeBeforeDeletion = 3;

        Assert.assertEquals(expectedSizeBeforeDeletion, uDao.listUsers().size());

        uDao.deleteUser(addedUser1.getUserId());

        int expectedSizeAfterDeletion = 2;

        Assert.assertEquals(expectedSizeAfterDeletion, uDao.listUsers().size());
    }

    @Test
    public void updateUserTest() {

        User addedUser1 = uDao.addUser(u1);

        User editedUser1 = new User();
        editedUser1.setUserId(addedUser1.getUserId());
        editedUser1.setFirstName("Magic");
        editedUser1.setLastName("Johnson");
        editedUser1.setGender("M");
        editedUser1.setAge(55);
        editedUser1.setEmail("Ervin32@lakers.com");
        editedUser1.setPhone("323-555-5504");
        editedUser1.setStreetNumber(3232);
        editedUser1.setStreetName("Los Feliz Blvd");
        editedUser1.setState(addedUser1.getState());
        editedUser1.setZip(91324);

        uDao.updateUser(editedUser1);

        User user1FromDb = uDao.getUser(addedUser1.getUserId());

        Assert.assertEquals(editedUser1.getFirstName(), user1FromDb.getFirstName());
        Assert.assertEquals(editedUser1.getCity(), user1FromDb.getCity());
        Assert.assertEquals(editedUser1.getUserId(), user1FromDb.getUserId());
        Assert.assertEquals(editedUser1.getPhone(), user1FromDb.getPhone());
        Assert.assertEquals(editedUser1.getZip(), user1FromDb.getZip());

    }

    @Test
    public void searchByLastNameTest() {

        User addedUser1 = uDao.addUser(u1);
        User addedUser2 = uDao.addUser(u2);
        User addedUser3 = uDao.addUser(u3);
        User addedUser4 = uDao.addUser(u4);

        String lastNameToSearch = "Harbaugh";

        List<User> result = uDao.searchByLastName(lastNameToSearch);
        int expectedListSize = 2;

        Assert.assertEquals(addedUser2.getLastName(), result.get(0).getLastName());
        Assert.assertEquals(expectedListSize, result.size());

    }

    @Test
    public void searchByEmailTest() {

        User addedUser1 = uDao.addUser(u1);
        User addedUser2 = uDao.addUser(u2);
        User addedUser3 = uDao.addUser(u3);
        User addedUser4 = uDao.addUser(u4);

        String emailToSearch = "RavensCoach@ravens.com";

        List<User> result = uDao.searchByEmail(emailToSearch);

        Assert.assertEquals(addedUser4.getEmail(), result.get(0).getEmail());

    }

    @Test
    public void searchByCity() {

        User addedUser1 = uDao.addUser(u1);
        User addedUser2 = uDao.addUser(u2);
        User addedUser3 = uDao.addUser(u3);
        User addedUser4 = uDao.addUser(u4);

        String cityToSearch1 = "Los Angeles";
        String cityToSearch2 = "Chicago";

        List<User> result1 = uDao.searchByCity(cityToSearch1);
        List<User> result2 = uDao.searchByCity(cityToSearch2);

        int expectedSearchSize = 0;

        Assert.assertEquals(addedUser3.getCity(), result1.get(0).getCity());
        Assert.assertEquals(expectedSearchSize, result2.size());
    }

    @Test
    public void searchByState() {

        User addedUser1 = uDao.addUser(u1);
        User addedUser2 = uDao.addUser(u2);
        User addedUser3 = uDao.addUser(u3);
        User addedUser4 = uDao.addUser(u4);

        String stateToSearch = "CA";

        List<User> result = uDao.searchByState(stateToSearch);

        Assert.assertEquals(addedUser3.getState(), result.get(0).getState());

    }

    @Test
    public void searchByZip() {

        User addedUser1 = uDao.addUser(u1);
        User addedUser2 = uDao.addUser(u2);
        User addedUser3 = uDao.addUser(u3);
        User addedUser4 = uDao.addUser(u4);

        int zipToSearch = 23213;

        List<User> result = uDao.searchByZip(zipToSearch);

        Assert.assertEquals(addedUser2.getZip(), result.get(0).getZip());

    }
}
