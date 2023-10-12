package org.bank.print;

import org.bank.account.BaseAcc;
import org.bank.account.SavingAcc;
import org.bank.account.StudentAcc;

public class ConsolePrint {
    public void balancePrint(BaseAcc acc){
        if(acc instanceof SavingAcc)
        {
            System.out.println("Account type: Saving Balance: " + acc.getBalance());
            return;
        }if(acc instanceof StudentAcc)
        {
            System.out.println("Account type: Student Balance: " + acc.getBalance());
            return;
        }
        if(acc instanceof BaseAcc)
        {
            System.out.println("Account type: Basic Balance: " + acc.getBalance());
        }
    }
}