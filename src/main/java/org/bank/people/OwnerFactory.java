package org.bank.people;

import com.google.inject.Inject;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.ServiceUIFactory;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.event.PrintServiceAttributeListener;

public class OwnerFactory {
    @Inject
    OwnerIdService ownerIdService;
    public Owner createOwner(String name, String lastName)
    {
        return new Owner(name, lastName, ownerIdService.createOwnerId());
    }
    public Owner createOwner(String name, String lastName, int id)
    {
        return new Owner(name, lastName, id);
    }
}
