package org.bank;

import org.bank.account.BaseAcc;
import org.bank.account.SavingAcc;
import org.bank.account.StudentAcc;
import org.bank.moneyTransfer.Transfer;
import org.bank.people.Owner;

public class Bank {
    public void run() throws Exception {

        Owner owner = new Owner("Tvoje", "Mama");
        BaseAcc baseBankAccount = new BaseAcc(owner, "9846531", 2000);
        Transfer transfer = new Transfer();
        BaseAcc studentAcc = new StudentAcc(owner,"1234567", 2000);
        BaseAcc savingAcc = new SavingAcc(owner, "1234567", 2000);

        transfer.moneyTransfer(baseBankAccount, savingAcc, 1000);
        transfer.moneyTransfer(studentAcc,savingAcc,1000);
        transfer.moneyTransfer(savingAcc,studentAcc,1000);

        System.out.println(baseBankAccount.getBalance());
        System.out.println(savingAcc.getBalance());
        System.out.println(studentAcc.getBalance());



    }
}

