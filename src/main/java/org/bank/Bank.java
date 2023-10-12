package org.bank;

import org.bank.account.*;
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
    Transfer transfer = new Transfer();
    ConsoleLog consoleLog = new ConsoleLog();
    AccountService accountService = new AccountService();

    OwnerService ownerService = new OwnerService();

    public void run() throws Exception {
        Owner owner = ownerService.createOwner("nfoiw", "nfouew");

        BaseAcc baseAcc = accountService.createStoreBaseAcc(ownerService.createOwner("noejf", "fnuewo"), 45663);
        StudentAcc studentAcc = accountService.createStoreStudentAcc(ownerService.createOwner("noejf", "fnuo"), 45663);
        consoleLog.accNumLog(studentAcc);
        StudentAcc studentAcc1 = accountService.createStoreStudentAcc(ownerService.createOwner("njf", "fnuewo"), 45663);
        consoleLog.accNumLog(studentAcc1);


        for (Map.Entry<String, BaseAcc> entrySet : accountService.getAccounts().entrySet()) {
            BaseAcc acc = entrySet.getValue();

            consoleLog.balanceLog(acc);
            if (acc instanceof InterestAcc) {
                consoleLog.balanceLog(acc);
                InterestTransfer interestTransfer = new InterestTransfer();
                interestTransfer.InterestAdd(acc);
                consoleLog.balanceLog(acc);
            }
        }

    }
}

