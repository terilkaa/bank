package org.bank.json;

import com.google.gson.Gson;
import org.bank.people.Owner;

public class JsonGson implements IJsonGenerator{

    Gson gson = new Gson();
    @Override
    public String generateJSONString(Owner owner) {
        return (String)gson.toJson(owner);
    }
}
