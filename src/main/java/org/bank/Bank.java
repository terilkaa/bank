package org.bank;

import org.bank.account.BaseAcc;
import org.bank.account.SavingAcc;
import org.bank.account.StudentAcc;
import org.bank.moneyTransfer.InterestTransfer;
import org.bank.moneyTransfer.Transfer;
import org.bank.people.Owner;
import org.bank.print.ConsolePrint;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public void run() throws Exception {


        Owner owner = new Owner("Tvoje", "Mama");
        BaseAcc baseBankAccount = new BaseAcc(owner, "9846531", 2000);
        Transfer transfer = new Transfer();
        ConsolePrint consolePrint = new ConsolePrint();
        InterestTransfer interestTransfer = new InterestTransfer();
        BaseAcc studentAcc = new StudentAcc(owner, "1234567", 2000);
        BaseAcc savingAcc = new SavingAcc(owner, "1234567", 2000);

        List<BaseAcc> accounts = new ArrayList<>();
        accounts.add(baseBankAccount);
        accounts.add(savingAcc);
        accounts.add(studentAcc);

        transfer.moneyTransfer(baseBankAccount, savingAcc, 1000);
        transfer.moneyTransfer(studentAcc, savingAcc, 1000);
        transfer.moneyTransfer(savingAcc, studentAcc, 1000);

        consolePrint.balancePrint(savingAcc);
        consolePrint.balancePrint(studentAcc);
        consolePrint.balancePrint(baseBankAccount);

    }
}

