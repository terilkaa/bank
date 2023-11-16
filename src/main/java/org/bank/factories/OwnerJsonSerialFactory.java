package org.bank.factories;

import org.bank.json.objects.OwnerJsonSerialObj;
import org.bank.people.Owner;

public class OwnerJsonSerialFactory {
    public OwnerJsonSerialObj createJSONOwner(Owner owner)
    {
        return new OwnerJsonSerialObj(owner.getFirstName(), owner.getLastName(), owner.getId());
    }
}
