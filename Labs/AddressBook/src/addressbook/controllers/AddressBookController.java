/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.controllers;

import addressbook.dao.AddressBookDao;
import addressbook.dto.Address;
import addressbook.dto.AddressBook;
import addressbook.ui.ConsoleIO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    private AddressBookDao dao = new AddressBookDao();
    private ConsoleIO io = new ConsoleIO();
    private AddressBook addressBook;

    public void run() {
        addressBook = new AddressBook(dao.load());
        int userSelect = 0;
        main:
        while (userSelect != 6) {
            printMenu();
            userSelect = io.promtForIntInRange("", 1, 6);
            switch (userSelect) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    listAllAddresses();
                    break;
                case 4:
                    viewAddress();
                    break;
                case 5:
                    viewAddressCount();
                    break;
                case 6:
                    break main;
            }
        }
    }

    public void printMenu() {
        io.println("Choose an option:");
        io.println("1- Add an address");
        io.println("2- Remove an address");
        io.println("3- List all addresses");
        io.println("4- View an address");
        io.println("5- View how many addresses are available");
        io.println("6- Exit");
    }

    public void addAddress() {
        String firstName = io.promptForString("Enter the first name.");
        String lastName = io.promptForString("Enter the last name.");
        String street = io.promptForString("Enter the street address.");
        String city = io.promptForString("Enter the city.");
        String state = io.promptForString("Enter the state");
        String zip = io.promptForString("Enter the zip");
        Address address = new Address(addressBook.getNextId());
        address.setFirstName(firstName);
        address.setLastName(lastName);
        address.setStreetAddress(street);
        address.setCity(city);
        address.setZip(zip);
        address.setState(state);
        addressBook.addAddress(address);

        dao.save(addressBook.getAllAddresses());
    }

    public void removeAddress() {
        String name = io.promptForString("Enter name to get address for:");
        List<Address> addresses = addressBook.getAllAddresses().stream().filter(a -> a.getLastName().equals(name)).collect(Collectors.toList());
        for (int i = 0; i < addresses.size(); i++) {
            io.println(String.format("%d- %s %s %s", (i + 1), addresses.get(i).getFirstName(), addresses.get(i).getLastName(), addresses.get(i).getStreetAddress()));
        }
        int userSelect = io.promtForIntInRange("Delete which one? (0 to return to the menu)", 0, addresses.size()) - 1;
        if (userSelect > 0) {
            addressBook.getAllAddresses().remove(addresses.get(userSelect));
            dao.save(addressBook.getAllAddresses());
        }
    }

    private void listAllAddresses() {
        List<Address> addresses = new ArrayList<>(addressBook.getAllAddresses());
        for (int i = 0; i < addresses.size(); i++) {
            io.println(String.format("%d- %s %s %s %s, %s %s", i + 1, addresses.get(i).getFirstName(), addresses.get(i).getLastName(), addresses.get(i).getStreetAddress(), addresses.get(i).getCity(), addresses.get(i).getState(), addresses.get(i).getZip()));
        }
        io.println("");
        io.promptForString("Press enter to continue...");
    }

    private void viewAddress() {
        String name = io.promptForString("Enter a last name to get address for:");
        List<Address> addresses = addressBook.getAllAddresses().stream().filter(a -> a.getLastName().equals(name)).collect(Collectors.toList());
        int userSelect = 0;
        if (addresses.size() > 1) {
            for (int i = 0; i < addresses.size(); i++) {
                io.println(String.format("%d- %s %s %s", i + 1, addresses.get(i).getFirstName(), addresses.get(i).getLastName(), addresses.get(i).getStreetAddress()));
            }
            userSelect = io.promtForIntInRange("View which one?", 1, addresses.size()) - 1;
        }
        if (!addresses.isEmpty()) {
            Address display = addresses.get(userSelect);
            io.println(String.format("%s %s %s %s, %s %s", display.getFirstName(), display.getLastName(), display.getStreetAddress(), display.getCity(), display.getState(), display.getZip()));
            io.println("");
            io.promptForString("Press enter to continue...");
        } else {
            io.println("No addresses for that name were found.");
        }
    }

    private void viewAddressCount() {
        io.println(String.format("The address book contains %d addresses.", addressBook.size()));
        io.println("");
        io.promptForString("Press enter to continue...");
    }
}
