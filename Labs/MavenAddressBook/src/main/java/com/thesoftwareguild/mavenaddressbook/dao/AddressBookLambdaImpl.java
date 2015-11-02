/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.mavenaddressbook.dao;

import com.thesoftwareguild.mavenaddressbook.dao.AddressBookDao;
import com.thesoftwareguild.mavenaddressbook.model.Address;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookLambdaImpl implements AddressBookDao {

    private final String fileLocation = "addresses.txt";
    private List<Address> addresses = new ArrayList<>();
    private int nextId = 0;
    private boolean testMode = false;

//    public AddressBookLambdaImpl(Collection<Address> list) {
//        if (!addresses.isEmpty()) {
//            addresses.addAll(addresses);
//            nextId = addresses.stream().mapToInt(Address::getId).max().orElse(-1) + 1;
//        }
//    }
    
    public AddressBookLambdaImpl() {
        if (!testMode) load();
    }

    public AddressBookLambdaImpl(boolean testMode) {
        this.testMode = testMode;

    }

    public void load() {
        File location = new File(fileLocation);
        if (location.exists()) {
            Scanner in;
            try {
                in = new Scanner(location);
                in.useDelimiter("[,\n]");
                while (in.hasNext()) {
                    Address newAddress = new Address();
                    newAddress.setId(in.nextInt());
                    newAddress.setFirstName(in.next());
                    newAddress.setLastName(in.next());
                    newAddress.setStreetNumber(in.next());
                    newAddress.setStreetName(in.next());
                    newAddress.setCity(in.next());
                    newAddress.setState(in.next());
                    newAddress.setZip(in.next());
                    addresses.add(newAddress);
                }
                
                nextId = addresses.stream().mapToInt(Address::getId).max().orElse(-1) + 1;
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddressBookDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void save() {
        File location = new File(fileLocation);

        try (PrintWriter out = new PrintWriter(location)) {
            location.createNewFile();
            for (Address address : addresses) {
                out.printf("%d,%s,%s,%s,%s,%s,%s,%s", address.getId(), address.getFirstName(), address.getLastName(), address.getStreetNumber(), address.getStreetName(), address.getCity(), address.getState(), address.getZip());
                out.println();
            }
        } catch (IOException ex) {
            Logger.getLogger(AddressBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Address create(Address address) {
        address.setId(nextId++);
        addresses.add(address);
        if (!this.testMode) {
            save();
        }
        return address;
    }

    @Override
    public void update(Address address) {
        delete(address.getId());
        addresses.add(address);
        if (!this.testMode) {
            save();
        }
    }

    @Override
    public Address get(Integer id) {
        return addresses.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(Integer id) {
        addresses = addresses.stream().filter(a -> !a.getId().equals(id)).collect(Collectors.toList());
        if (!this.testMode) {
            save();
        }
    }

    @Override
    public List<Address> list() {
        return Collections.unmodifiableList(addresses);
    }

    @Override
    public List<Address> searchByLastName(String lastName) {
        return addresses.stream().filter(a -> a.getLastName().matches(".*" + lastName + ".*")).collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByCity(String city) {
        return addresses.stream().filter(a -> a.getCity().matches(".*" + city + ".*")).collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByState(String state) {
        return addresses.stream().filter(a -> a.getState().matches(".*" + state + ".*")).sorted((a, b) -> a.getCity().compareToIgnoreCase(b.getCity())).collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByZip(String zip) {
        return addresses.stream().filter(a -> a.getZip().matches(".*" + zip + ".*")).collect(Collectors.toList());
    }
}
