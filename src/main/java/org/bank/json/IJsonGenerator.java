package org.bank.json;
import org.bank.people.Owner;

public interface IJsonGenerator {
    String generateJSONString(Owner owner);
}
