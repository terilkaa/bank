package org.bank.people;

import com.google.inject.Inject;

import java.util.LinkedList;

public class OwnerService {

    LinkedList<Owner> owners;
    @Inject
    private OwnerFactory ownerFactory;

    public OwnerService() {
        this.owners = new LinkedList<>();
    }

    public Owner createOwner(String name, String lastName) {
        Owner owner = ownerFactory.createOwner(name, lastName);
        owners.add(owner);
        return owner;
    }

    public LinkedList<Owner> getOwners() {
        return owners;
    }
}
