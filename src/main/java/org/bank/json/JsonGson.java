package org.bank.json;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.bank.people.Owner;

public class JsonGson implements IJsonGenerator{

    @Inject
    Gson gson;
    @Override
    public String generateJSONString(Owner owner) {
        return (String)gson.toJson(owner);
    }
}
