package org.bank.print;

import org.bank.account.BaseAcc;
import org.bank.account.SavingAcc;
import org.bank.account.StudentAcc;

public class ConsoleLog implements ILogger {
    public void balanceLog(BaseAcc acc) {
        System.out.println(this.getAccountPrefix(acc) + "(owner: " + acc.getOwner().getFullName() + ") balance: " + acc.getBalance());
    }
    private String getAccountPrefix(BaseAcc acc) {
        if (acc instanceof StudentAcc) {
            return "student account";
        }
        if (acc instanceof SavingAcc) {
            return "save account";
        }

        return "base account";
    }
    public void debug(String message) {
        System.out.println("DEBUG: " + message);
        System.out.println();
    }
    public void accNumLog(BaseAcc acc)
    {
       System.out.println("account number: " + acc.getAccountNum());
    }
}