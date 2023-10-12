package org.bank.people;

import java.util.LinkedList;

public class OwnerService {

    private final OwnerFactory ownerFactory;
    LinkedList<Owner> owners;

    public OwnerService() {
        this.ownerFactory = new OwnerFactory();
        this.owners = new LinkedList<>();
    }

    public Owner createOwner(String name, String lastName) {
        Owner owner = this.ownerFactory.createOwner(name, lastName);
        owners.add(owner);
        return owner;
    }

    public LinkedList<Owner> getOwners() {
        return owners;
    }
}
