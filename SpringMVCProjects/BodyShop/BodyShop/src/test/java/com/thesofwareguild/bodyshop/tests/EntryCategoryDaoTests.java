package com.thesofwareguild.bodyshop.tests;

import com.thesoftwareguild.bodyshop.daos.EntryCategoryDao;
import com.thesoftwareguild.bodyshop.dtos.EntryCategory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Aaron Alahverde
 */
public class EntryCategoryDaoTests {

    EntryCategoryDao ecd;
    EntryCategory ec1;
    EntryCategory ec2;
    EntryCategory ec3;
    EntryCategory ec4;
    JdbcTemplate jdbc = new JdbcTemplate();
    String SQL_CREATE_EC_TABLE;
    String SQL_DELETE_EC_TABLE;

    public EntryCategoryDaoTests() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        ecd = (EntryCategoryDao) ctx.getBean("entryCategoryDao");
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from entry_category");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addEntryCategory() {
        Assert.assertEquals(0, ecd.list().size());

        ec1 = new EntryCategory();
        ec1.setEntryCategoryName("Promotion");
        ecd.addEntryCategory(ec1);
        Assert.assertEquals(1, ecd.list().size());

        ec2 = new EntryCategory();
        ec2.setEntryCategoryName("Fitness");
        ecd.addEntryCategory(ec2);
        Assert.assertEquals(2, ecd.list().size());

        ec3 = new EntryCategory();
        ec3.setEntryCategoryName("Pat Feels");
        ecd.addEntryCategory(ec3);
        Assert.assertEquals(3, ecd.list().size());

        ec4 = new EntryCategory();
        ec4.setEntryCategoryName("Tonerlicious");
        ecd.addEntryCategory(ec4);
        Assert.assertEquals(4, ecd.list().size());
    }

    @Test
    public void list() {

        Assert.assertEquals(0, ecd.list().size());

        ec1 = new EntryCategory();
        ec1.setEntryCategoryName("Promotion");
        ecd.addEntryCategory(ec1);
        Assert.assertEquals(1, ecd.list().size());

        Assert.assertEquals("Promotion", ecd.list()
                .get(0).getEntryCategoryName());

        ec2 = new EntryCategory();
        ec2.setEntryCategoryName("Fitness");
        ecd.addEntryCategory(ec2);
        Assert.assertEquals(2, ecd.list().size());

        Assert.assertEquals("Fitness", ecd.list()
                .get(1).getEntryCategoryName());

        ec3 = new EntryCategory();
        ec3.setEntryCategoryName("Pat Feels");
        ecd.addEntryCategory(ec3);
        Assert.assertEquals(3, ecd.list().size());

        Assert.assertEquals("Pat Feels", ecd.list()
                .get(2).getEntryCategoryName());

        ec4 = new EntryCategory();
        ec4.setEntryCategoryName("Tonerlicious");
        ecd.addEntryCategory(ec4);
        Assert.assertEquals(4, ecd.list().size());

        Assert.assertEquals("Tonerlicious", ecd.list()
                .get(3).getEntryCategoryName());

    }
}
