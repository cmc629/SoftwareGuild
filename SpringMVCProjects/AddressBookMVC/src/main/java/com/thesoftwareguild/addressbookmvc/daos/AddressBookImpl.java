/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbookmvc.daos;

import com.thesoftwareguild.addressbookmvc.models.Address;
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

/**
 *
 * @author apprentice
 */
public class AddressBookImpl implements AddressBookDao {

    private List<Address> addresses = new ArrayList<>();
    private int nextId = 0;
    private String path = /*System.getProperty("user.dir") + "/*/"addresses.txt";
    private boolean testMode = false;
    
//    public AddressBookImpl(Collection<Address> addresses) {
//        if (!addresses.isEmpty()) {
//            addresses.addAll(addresses);
//            for (Address address : addresses) {
//                if (address.getId() >= nextId) {
//                    nextId = address.getId() + 1;
//                }
//            }
//        }
//        load(path);
//    }

    public AddressBookImpl() {
        //this(Collections.emptyList());
        if (!this.testMode) load(path);
    }
    
    public AddressBookImpl(boolean testMode) {
        this.testMode = testMode;
    }

    private void load(String path) {
        File location = new File(path);
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
            for (Address address : addresses) {
                if (address.getId() >= nextId) {
                    nextId = address.getId() + 1;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void save(String path) {
        File location = new File(path);

        try (PrintWriter out = new PrintWriter(location)) {
            location.createNewFile();
            for (Address address : addresses) {
                out.printf("%1$d,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s,%8$s",
                        address.getId(),
                        address.getFirstName(),
                        address.getLastName(),
                        address.getStreetNumber(),
                        address.getStreetName(),
                        address.getCity(),
                        address.getState(),
                        address.getZip());
                out.println();
            }
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(AddressBookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Address create(Address address) {
        address.setId(nextId++);
        addresses.add(address);
        if (!this.testMode) save(path);
        return address;
    }

    @Override
    public void update(Address address) {
        delete(address.getId());
        addresses.add(address);
        if (!this.testMode) save(path);
    }

    @Override
    public Address get(Integer id) {
        for (Address address : addresses) {
            if (id.equals(address.getId())) {
                return address;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Address addressToRemove = null;
        for (Address address : addresses) {
            if (id.equals(address.getId())) {
                addressToRemove = address;
            }
        }
        if (addressToRemove != null) {
            addresses.remove(addressToRemove);
        }
        if (!this.testMode) save(path);
    }

    @Override
    public List<Address> list() {
        return Collections.unmodifiableList(addresses);
    }

    @Override
    public List<Address> searchByLastName(String lastName) {
        List<Address> lastNames = new ArrayList();
        for (Address address : addresses) {
            if (lastName.toUpperCase().matches(".*" + address.getLastName().toUpperCase() + ".*")) {
                lastNames.add(address);
            }
        }
        return lastNames;
    }

    @Override
    public List<Address> searchByCity(String city) {
        List<Address> cities = new ArrayList();
        for (Address address : addresses) {
            if (city.toUpperCase().matches(".*" + address.getCity().toUpperCase() + ".*")) {
                cities.add(address);
            }
        }
        return cities;
    }

    @Override
    public List<Address> searchByState(String state) {
        List<Address> states = new ArrayList();
        for (Address address : addresses) {
            if (state.toUpperCase().matches(".*" + address.getState().toUpperCase() + ".*")) {
                states.add(address);
            }
        }
        Collections.sort(states, (a, b) -> a.getCity().compareToIgnoreCase(b.getCity()));
        return states;
    }

    @Override
    public List<Address> searchByZip(String zip) {
        List<Address> zips = new ArrayList();
        for (Address address : addresses) {
            if (zip.matches(".*" + address.getZip() + ".*")) {
                zips.add(address);
            }
        }
        return zips;
    }
}
