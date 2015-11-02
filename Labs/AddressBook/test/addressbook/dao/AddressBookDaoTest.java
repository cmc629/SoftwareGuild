/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoTest {

    AddressBookDao dao;
    String filePath = "addressestest.txt";

    public AddressBookDaoTest() {
    }

    @Before
    public void setUp() throws IOException {
        //This isn's the best way to do this but leaves our
        dao = new AddressBookDao();
        PrintWriter write = new PrintWriter(new File(filePath));
        write.append("1,Damien,Marble,401 S Main St,Akron,OH,44122");
        write.flush();
    }

    @After
    public void tearDown() throws IOException {
        Files.delete(Paths.get(filePath));
    }

    @Test
    public void testLoad() {
        Address target = new Address(1);
        target.setFirstName("Damien");
        target.setLastName("Marble");
        target.setStreetAddress("401 S Main St");
        target.setCity("Akron");
        target.setState("OH");
        target.setZip("44122");
        Collection<Address> addresses = dao.load();
        assertTrue(addresses.contains(target));
    }

    @Test
    public void testSave() {
        Address target = new Address(1);
        target.setFirstName("Damien");
        target.setLastName("Marble");
        target.setStreetAddress("401 S Main St");
        target.setCity("Akron");
        target.setState("OH");
        target.setZip("44122");
        Collection<Address> addresses = new ArrayList<>();
        addresses.add(target);
        dao.save(addresses);
        addresses = dao.load();
        assertTrue(addresses.contains(target));
    }

}
