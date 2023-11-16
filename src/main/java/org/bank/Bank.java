package org.bank;

import com.google.inject.Inject;
import org.bank.account.*;
import org.bank.factories.BaseAccJsonSerialFactory;
import org.bank.factories.OwnerJsonSerialFactory;
import org.bank.factories.SavingAccJsonSerialFactory;
import org.bank.factories.StudentAccJsonSerialFactory;
import org.bank.file.FileService;
import org.bank.json.IJsonGenerator;
import org.bank.json.JsonGson;
import org.bank.json.JsonLoadService;
import org.bank.json.objects.BaseAccJsonSerialObj;
import org.bank.json.objects.OwnerJsonSerialObj;
import org.bank.json.objects.SavingAccJsonSerialObj;
import org.bank.json.objects.StudentAccJsonSerialObj;
import org.bank.moneyTransfer.InterestTransfer;
import org.bank.moneyTransfer.Transfer;
import org.bank.people.Owner;
import org.bank.people.OwnerService;
import org.bank.print.ILogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {
    @Inject
    Transfer transfer;
    @Inject
    ILogger iLogger;
    @Inject
    AccountService accountService;
    @Inject
    OwnerService ownerService;
    @Inject
    InterestTransfer interestTransfer;
    @Inject
    IJsonGenerator iJsonGenerator;
    @Inject
    BaseAccJsonSerialFactory baseAccJsonSerialFactory;
    @Inject
    StudentAccJsonSerialFactory studentAccJsonSerialFactory;
    @Inject
    SavingAccJsonSerialFactory savingAccJsonSerialFactory;
    @Inject
    OwnerJsonSerialFactory ownerJsonSerialFactory;
    @Inject
    FileService fileService;
    @Inject
    JsonLoadService jsonLoadService;
    public void run() throws Exception {

        List<StudentAccJsonSerialObj> studentAccJsonSerialObjs= new ArrayList<StudentAccJsonSerialObj>();
        List<SavingAccJsonSerialObj> savingAccJsonSerialObjs= new ArrayList<SavingAccJsonSerialObj>();
        List<BaseAccJsonSerialObj> baseAccJsonSerialObjs= new ArrayList<BaseAccJsonSerialObj>();
        List<OwnerJsonSerialObj> ownerJsonSerialObjs= new ArrayList<OwnerJsonSerialObj>();
        if(fileService.doesFileExist("data_json/Student.json")&& fileService.doesFileExist("data_json/Saving.json") &&fileService.doesFileExist("data_json/Base.json") && fileService.doesFileExist("data_json/Owner.json"))
        {
            jsonLoadService.loadJson(fileService.readFile("data_json/Student.json"), fileService.readFile("data_json/Saving.json"), fileService.readFile("data_json/Base.json"), fileService.readFile("data_json/Owner.json"));
        } else {
            accountService.createStoreBaseAcc(ownerService.createOwner("fiaho","fewo"), 452);
            accountService.createStoreStudentAcc(ownerService.createOwner("wi","fihwo"), 784512);
            accountService.createStoreSavingAcc(ownerService.createOwner("fisfcweaho","wfew"), 9461);
        }

        for (Map.Entry<String, BaseAcc> entrySet : accountService.getAccounts().entrySet()) {
            BaseAcc acc = entrySet.getValue();
            if (acc instanceof InterestAcc) {
                interestTransfer.InterestAdd(acc);
            }
            if(acc instanceof StudentAcc) {
                studentAccJsonSerialObjs.add(studentAccJsonSerialFactory.createStudentAcc((StudentAcc) acc));
            } else if(acc instanceof SavingAcc){
                savingAccJsonSerialObjs.add(savingAccJsonSerialFactory.createSavingAcc((SavingAcc) acc));
            } else {
                baseAccJsonSerialObjs.add(baseAccJsonSerialFactory.createBaseAcc(acc));
            }
                    }
        for (Map.Entry<Integer, Owner> entrySet : ownerService.getOwners().entrySet()) {
            Owner owner = entrySet.getValue();
            ownerJsonSerialObjs.add(ownerJsonSerialFactory.createJSONOwner(owner));
        }
        for (Map.Entry<String, BaseAcc> entrySet : accountService.getAccounts().entrySet()) {
            BaseAcc acc = entrySet.getValue();
            iLogger.balanceLog(acc);
        }

        fileService.writeFile("data_json/Student.json",iJsonGenerator.generateJSONString(studentAccJsonSerialObjs));
        fileService.writeFile("data_json/Base.json",iJsonGenerator.generateJSONString(baseAccJsonSerialObjs));
        fileService.writeFile("data_json/Saving.json",iJsonGenerator.generateJSONString(savingAccJsonSerialObjs));
        fileService.writeFile("data_json/Owner.json",iJsonGenerator.generateJSONString(ownerJsonSerialObjs));
    }
}

