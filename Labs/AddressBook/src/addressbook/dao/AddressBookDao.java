/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AddressBookDao {

    private final String fileLocation = "addresses.txt";

    public Collection<Address> load() {
        File location = new File(fileLocation);
        Collection<Address> addresses = new LinkedList<>();
        if (location.exists()) {
            Scanner in;
            try {
                in = new Scanner(location);
                in.useDelimiter("[,\n]");
                while (in.hasNext()) {
                    Address newAddress = new Address(in.nextInt());
                    newAddress.setFirstName(in.next());
                    newAddress.setLastName(in.next());
                    newAddress.setStreetAddress(in.next());
                    newAddress.setCity(in.next());
                    newAddress.setState(in.next());
                    newAddress.setZip(in.next());
                    addresses.add(newAddress);
                }
            } catch (FileNotFoundException ex) {
                System.err.println("There was an error saving to the disk.");
            }
        }
        return addresses;
    }

    public void save(Collection<Address> addresses) {
        File location = new File(fileLocation);

        try (PrintWriter out = new PrintWriter(location)) {
            location.createNewFile();
            for (Address address : addresses) {
                out.printf("%d,%s,%s,%s,%s,%s,%s", address.getId(), address.getFirstName(), address.getLastName(), address.getStreetAddress(), address.getCity(), address.getState(), address.getZip());
                out.println();
            }
        } catch (IOException ex) {
            System.err.println("There was aan error reading from the disk.");
        }
    }
}
