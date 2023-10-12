package org.bank.moneyTransfer;

import org.bank.account.BaseAcc;
import org.bank.account.InterestAcc;

public class InterestCalc implements InterestAcc{
    InterestPercent interestPercent = new InterestPercent();
    public double InterCalc(BaseAcc acc){
       return interestPercent.getInterestPercent(acc) * acc.getBalance();
    }
}
