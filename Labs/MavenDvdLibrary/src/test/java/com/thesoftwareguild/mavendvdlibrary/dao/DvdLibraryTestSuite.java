/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavendvdlibrary.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Christian Choi
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.thesoftwareguild.mavendvdlibrary.dao.DvdTestsSena.class, com.thesoftwareguild.mavendvdlibrary.dao.DvdLibraryTestsChristian.class, com.thesoftwareguild.mavendvdlibrary.dao.DvdLibraryTestMark.class, com.thesoftwareguild.mavendvdlibrary.dao.YanDVDLibraryTest.class, com.thesoftwareguild.mavendvdlibrary.dao.DvdTestsDamien.class})
public class DvdLibraryTestSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
