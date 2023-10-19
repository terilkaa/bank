package org.bank.moneyTransfer;

import com.google.inject.Inject;
import org.bank.account.BaseAcc;
import org.bank.account.InterestAcc;
import org.bank.moneyTransfer.InterestCalc;

public class InterestTransfer implements InterestAcc {
   @Inject
   InterestCalc interestCalc;

    public void InterestAdd(BaseAcc acc){

        double balance = interestCalc.InterCalc(acc);
        acc.setBalance(balance+ acc.getBalance());

    }

}
