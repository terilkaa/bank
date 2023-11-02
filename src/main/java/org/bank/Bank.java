package org.bank;

import com.google.inject.Inject;
import org.bank.account.*;
import org.bank.json.JsonGson;
import org.bank.json.JsonLog;
import org.bank.moneyTransfer.InterestTransfer;
import org.bank.moneyTransfer.Transfer;
import org.bank.people.Owner;
import org.bank.people.OwnerFactory;
import org.bank.people.OwnerService;
import org.bank.print.ConsoleLog;
import org.bank.print.ILogger;
import org.bank.print.ServiceLog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Bank {
    @Inject
    Transfer transfer;
    @Inject
    ConsoleLog consoleLog;
    @Inject
    AccountService accountService;
    @Inject
    OwnerService ownerService;
    @Inject
    InterestTransfer interestTransfer;
    @Inject
    JsonGson jsonGson;

    @Inject
    JsonLog jsonLog;
    public void run() throws Exception {

        BaseAcc baseAcc = accountService.createStoreBaseAcc(ownerService.createOwner("noejf", "fnuewo"), 2000);
        StudentAcc studentAcc = accountService.createStoreStudentAcc(ownerService.createOwner("noejf", "fnuo"), 2000);
        consoleLog.accNumLog(studentAcc);
        StudentAcc studentAcc1 = accountService.createStoreStudentAcc(ownerService.createOwner("njf", "fnuewo"), 2000);
        consoleLog.accNumLog(studentAcc1);


        for (Map.Entry<String, BaseAcc> entrySet : accountService.getAccounts().entrySet()) {
            BaseAcc acc = entrySet.getValue();

            consoleLog.balanceLog(acc);
            if (acc instanceof InterestAcc) {
                consoleLog.balanceLog(acc);
                interestTransfer.InterestAdd(acc);
                consoleLog.balanceLog(acc);
            }
        }
        consoleLog.debug(jsonLog.generateJSONString(ownerService.createOwner("ncfwo", "jfiewo")));
        consoleLog.debug(jsonLog.generateJSONString(ownerService.createOwner("jiewp","fnwo")));

        consoleLog.debug(jsonGson.generateJSONString(ownerService.createOwner("jiewp","fnwo")));
    }
}

