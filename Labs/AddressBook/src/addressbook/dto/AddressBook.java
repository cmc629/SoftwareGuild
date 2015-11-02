/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author apprentice
 */
public class AddressBook {

    private final Map<Integer, Address> addresses = new TreeMap<>();
    private int nextId = 0;

    public AddressBook(Collection<Address> addresses) {
        if (!addresses.isEmpty()) {
            for (Address address : addresses) {
                this.addresses.put(address.getId(), address);
            }
            nextId = this.addresses.keySet().stream().mapToInt(Integer::intValue).max().getAsInt() + 1;
        }
    }

    public AddressBook() {
        this(Collections.EMPTY_SET);
    }

    public int getNextId() {
        return nextId;
    }

    public void addAddress(Address address) {
        if (addresses.containsKey(address.getId())) {
            throw new IllegalStateException(String.format("Attempted to add a duplicate value for key %d. This means someone is setting invalid ids.", address.getId()));
        }
        addresses.put(address.getId(), address);
    }

    public void removeAddress(Address address) {
        addresses.remove(address.getId());
    }

    public Collection<Address> getAllAddresses() {
        return Collections.unmodifiableCollection(addresses.values());
    }

    public int size() {
        return addresses.size();
    }

    public boolean hasAddresses() {
        return !addresses.isEmpty();
    }
}
