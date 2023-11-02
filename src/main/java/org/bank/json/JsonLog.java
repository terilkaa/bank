package org.bank.json;
import org.bank.people.Owner;

public class JsonLog implements IJsonGenerator{

    @Override
    public String generateJSONString(Owner owner) {
        return "{\"firstName\":\"" + owner.getFirstName() + "\",\"lastName\":\"" + owner.getLastName() + "\"}";
    }
}
