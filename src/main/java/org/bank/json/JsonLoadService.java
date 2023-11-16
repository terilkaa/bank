package org.bank.json;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.bank.account.AccountService;
import org.bank.factories.BaseAccFactory;
import org.bank.factories.SavingAccFactory;
import org.bank.factories.StudentAccFactory;
import org.bank.json.objects.BaseAccJsonSerialObj;
import org.bank.json.objects.OwnerJsonSerialObj;
import org.bank.json.objects.SavingAccJsonSerialObj;
import org.bank.json.objects.StudentAccJsonSerialObj;
import org.bank.people.Owner;
import org.bank.people.OwnerFactory;
import org.bank.people.OwnerService;

import java.lang.reflect.Type;

public class JsonLoadService {
    @Inject
    Gson gson;
    @Inject
    BaseAccFactory baseAccFactory;
    @Inject
    SavingAccFactory savingAccFactory;
    @Inject
    StudentAccFactory studentAccFactory;
    @Inject
    OwnerFactory ownerFactory;
    @Inject
    OwnerService ownerService;
    @Inject
    AccountService accountService;

    public void loadJson(String studentAccObjs, String savingAccObjs, String baseAccObjs, String ownerObjs){
        Gson gson = new Gson();
        StudentAccJsonSerialObj[] studentDeserialObjs = gson.fromJson(studentAccObjs, StudentAccJsonSerialObj[].class);
        SavingAccJsonSerialObj[] savingDeserialObjs = gson.fromJson(savingAccObjs, SavingAccJsonSerialObj[].class);
        BaseAccJsonSerialObj[] baseDeserialObjs = gson.fromJson(baseAccObjs, BaseAccJsonSerialObj[].class);
        OwnerJsonSerialObj[] ownerDeserialObjs = gson.fromJson(ownerObjs, OwnerJsonSerialObj[].class);

        for (OwnerJsonSerialObj ownerDeserialObj : ownerDeserialObjs) {
            ownerService.createOwner(ownerDeserialObj.getFirstName(), ownerDeserialObj.getLastName(), ownerDeserialObj.getId());
        }
        for (int i = 0; i < savingDeserialObjs.length; i++) {
            accountService.createStoreSavingAcc(ownerService.getOwners().get(savingDeserialObjs[i].getOwnerId()), savingDeserialObjs[i].getBalance());
        }for (int i = 0; i < studentDeserialObjs.length; i++) {
            Owner owner = ownerService.getOwners().get(studentDeserialObjs[i].getOwnerId());
            accountService.createStoreStudentAcc(owner, studentDeserialObjs[i].getBalance());
        }for (int i = 0; i < baseDeserialObjs.length; i++) {
            accountService.createStoreBaseAcc(ownerService.getOwners().get(baseDeserialObjs[i].getOwnerId()), baseDeserialObjs[i].getBalance());
        }
    }
}
