package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        // Wrong implementation, please change me
        int i = a1.getFirstname().compareTo(a2.getFirstname());

        if (i != 0)
            return i;

        i = a1.getLastname().compareTo(a2.getLastname());

        if (i != 0)
            return i;

        i = a1.getPhonenumber().compareTo(a2.getPhonenumber());

        if (i != 0)
            return i;

        return a1.getId() - a2.getId();
    }

}
