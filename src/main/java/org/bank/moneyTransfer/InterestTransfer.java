package org.bank.moneyTransfer;

import org.bank.account.BaseAcc;
import org.bank.account.InterestAcc;
import org.bank.moneyTransfer.InterestCalc;

public class InterestTransfer implements InterestAcc {
    InterestCalc interestCalc = new InterestCalc();

    public void InterestAdd(BaseAcc acc){

        double balance = interestCalc.InterCalc(acc);
        acc.setBalance(balance+ acc.getBalance());

    }

}
