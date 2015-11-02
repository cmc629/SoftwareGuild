/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thesoftwareguild.mavendvdlibrary.dao.DvdLibraryTestsChristian;
import com.thesoftwareguild.mavendvdlibrary.dao.DvdLibraryTestMark;
import com.thesoftwareguild.mavendvdlibrary.dao.DvdTestsDamien;
import com.thesoftwareguild.mavendvdlibrary.dao.DvdTestsSena;
import com.thesoftwareguild.mavendvdlibrary.dao.YanDVDLibraryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author apprentice
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {DvdTestsDamien.class,
            DvdLibraryTestsChristian.class,
            DvdLibraryTestMark.class,
            DvdTestsSena.class,
        YanDVDLibraryTest.class})
public class DvdLibraryTestSuite1 {

}
