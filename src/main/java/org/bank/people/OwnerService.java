package org.bank.people;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.LinkedList;
@Singleton
public class OwnerService {
    HashMap<Integer, Owner> owners;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject OwnerIdService ownerIdService;

    public OwnerService() {
        this.owners = new HashMap<>();
    }
    public Owner createOwner(String name, String lastName) {
        Owner owner = ownerFactory.createOwner(name, lastName);
        owners.put(owner.getId(), owner);
        return owner;
    }
    public Owner createOwner(String name, String lastName, int id) {
        Owner owner = ownerFactory.createOwner(name, lastName, id);
        owners.put(id, owner);
        return owner;
    }

    public HashMap<Integer, Owner> getOwners() {
        return owners;
    }
}
