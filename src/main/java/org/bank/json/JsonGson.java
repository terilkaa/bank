package org.bank.json;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.bank.account.BaseAcc;
import org.bank.people.Owner;

public class JsonGson implements IJsonGenerator{

    @Inject
    Gson gson;
    @Override
    public String generateJSONString(Object object) {
        return (String)gson.toJson(object);
    }
}
