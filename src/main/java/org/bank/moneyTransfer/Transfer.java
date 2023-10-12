package org.bank.moneyTransfer;
import org.bank.validation.ValidateBalance;

import org.bank.account.BaseAcc;


public class Transfer {

    ValidateBalance validateBalance = new ValidateBalance();
    FeeCalc feeCalc = new FeeCalc();
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
