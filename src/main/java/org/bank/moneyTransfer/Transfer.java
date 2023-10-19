package org.bank.moneyTransfer;
import com.google.inject.Inject;
import org.bank.validation.ValidateBalance;

import org.bank.account.BaseAcc;


public class Transfer {

    @Inject
   ValidateBalance validateBalance;
    @Inject
    FeeCalc feeCalc;
    public void moneyTransfer(BaseAcc sourceAccount, BaseAcc destinationAccount, double amount) throws Exception {

        double fee = feeCalc.calculate(sourceAccount, amount);
        double feeAmount = fee + amount;
        validateBalance.notEnoughBalance(sourceAccount,feeAmount);
        sourceAccount.setBalance(sourceAccount.getBalance() - feeAmount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
    }

    public void atmTransfer(BaseAcc sourceAccount, double amount) throws Exception {

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
    }
}
