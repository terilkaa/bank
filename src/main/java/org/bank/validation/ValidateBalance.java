package org.bank.validation;

import org.bank.account.BaseAcc;

public class ValidateBalance {

    public void notEnoughBalance(BaseAcc sourceAccount, double amount) throws Exception {
        if (sourceAccount.getBalance() < amount) {
            throw new Exception("");
        }
    }



}
