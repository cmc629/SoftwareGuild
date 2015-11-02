/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.controllers;


import addressbook.data.AddressBookLambdaImpl;
import addressbook.ui.ConsoleIO;
import com.thesoftwareguild.dao.AddressBookDao;
import com.thesoftwareguild.model.Address;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    private AddressBookDao dao = new AddressBookLambdaImpl();
    private ConsoleIO io = new ConsoleIO();

    public void run() {
        int userSelect = 0;
        main:
        while (userSelect != 9) {
            printMenu();
            userSelect = io.promptInt("> ", 1, 9);
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
                    viewAddressByLastName();
                    break;
                case 5:
                    viewAddressByCity();
                    break;
                case 6:
                    viewAddressByState();
                    break;
                case 7:
                    viewAddressByZip();
                    break;
                case 8:
                    viewAddressCount();
                    break;
                case 9:
                    break main;
            }
        }
    }

    public void printMenu() {
        io.println("Choose an option:");
        io.println("1- Add an address");
        io.println("2- Remove an address");
        io.println("3- List all addresses");
        io.println("4- Search Addresses by Last Name");
        io.println("5- Search Addresses by City");
        io.println("6- Search Addresses by State");
        io.println("7- Search Addresses by Zip Code");
        io.println("8- View how many addresses are available");
        io.println("9- Exit");
    }

    public void addAddress() {
        String firstName = io.promptString("Enter the first name: ");
        String lastName = io.promptString("Enter the last name: ");
        String streetNumber = io.promptString("Enter the street number: ");
        String streetName = io.promptString("Enter the street name: ");
        String city = io.promptString("Enter the city: ");
        String state = io.promptString("Enter the state: ");
        String zip = io.promptString("Enter the zip: ");
        Address address = new Address();
        address.setFirstName(firstName);
        address.setLastName(lastName);
        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setZip(zip);
        address.setState(state);
        dao.create(address);
    }

    public void removeAddress() {
        String name = io.promptString("Enter last name to get address for: ");
        List<Address> list = dao.searchByLastName(name);
        if (list.isEmpty()) {
            io.println("No matches found!");
        } else {
            io.println("Available address(es):");
            for (int i = 0; i < list.size(); i++) {
                io.print((i+1) + "- ");
                printAddress(list.get(i));
            }
            int userSelect = io.promptInt("Delete which one? (0 to return to the menu): ", 0, list.size()) - 1;
            if (userSelect > 0) {
                dao.delete(list.get(userSelect).getId());
            }
        }
    }

    private void listAllAddresses() {
        List<Address> addresses = new ArrayList<>(dao.list());
        for (int i = 0; i < addresses.size(); i++) {
            io.print((i+1) + "- ");
            printAddress(addresses.get(i));
        }
        io.println("");
        io.promptString("Press enter to continue...");
    }

//    private void viewAddress() {
//        String name = io.promptString("Enter a last name to get address for:");
//        List<Address> addresses = dao.list().stream().filter(a -> a.getLastName().equals(name)).collect(Collectors.toList());
//        int userSelect = 0;
//        if (addresses.size() > 1) {
//            for (int i = 0; i < addresses.size(); i++) {
//               io.print((i+1) + "- ");
//               printAddress(addresses.get(i));
//            }
//            userSelect = io.promptInt("View which one?", 1, addresses.size()) - 1;
//        }
//        if (!addresses.isEmpty()) {
//            Address display = addresses.get(userSelect);
//            printAddress(display);
//            io.println("");
//            io.promptString("Press enter to continue...");
//        } else {
//            io.println("No addresses for that name were found.");
//        }
//    }
    
    private void viewAddressByLastName() {
        String name = io.promptString("Enter a last name to get address for: ");
        List<Address> list = dao.searchByLastName(name);
        if (list.isEmpty()) {
            io.println("No matches found!");
        } else {
            io.println("Available address(es):");
            for (int i = 0; i < list.size(); i++) {
                io.print((i+1) + "- ");
                printAddress(list.get(i));
            }
        }
        io.println("");
    }
    
    private void viewAddressByCity() {
        String name = io.promptString("Enter a city to get address for: ");
        List<Address> list = dao.searchByCity(name);
        if (list.isEmpty()) {
            io.println("No matches found!");
        } else {
            io.println("Available address(es):");
            for (int i = 0; i < list.size(); i++) {
                io.print((i+1) + "- ");
                printAddress(list.get(i));
            }
        }
        io.println("");
    }
    
    private void viewAddressByState() {
        String name = io.promptString("Enter a state to get address for: ");
        List<Address> list = dao.searchByState(name);
        if (list.isEmpty()) {
            io.println("No matches found!");
        } else {
            io.println("Available address(es):");
            for (int i = 0; i < list.size(); i++) {
                io.print((i+1) + "- ");
                printAddress(list.get(i));
            }
        }
        io.println("");
    }
    
    private void viewAddressByZip() {
        String name = io.promptString("Enter a zip code to get address for: ");
        List<Address> list = dao.searchByZip(name);
        if (list.isEmpty()) {
            io.println("No matches found!");
        } else {
            io.println("Available address(es):");
            for (int i = 0; i < list.size(); i++) {
                io.print((i+1) + "- ");
                printAddress(list.get(i));
            }
        }
        io.println("");
    }

    private void viewAddressCount() {
        io.println(String.format("The address book contains %d addresses.", dao.list().size()));
        io.println("");
        io.promptString("Press enter to continue...");
    }
    
    private void printAddress(Address address) {
        io.println(String.format("%s %s %s %s, %s %s", address.getFirstName(), address.getLastName(), address.getStreetNumber(), address.getStreetName(), address.getCity(), address.getState(), address.getZip()));
    }
}
