package org.bank.moneyTransfer;

import org.bank.account.BaseAcc;
import org.bank.account.SavingAcc;
import org.bank.account.StudentAcc;

public class InterestPercent {

    private static final double INTEREST_STUDENT = 0.01;
    private static final double INTEREST_SAVING = 0.08;

    public double getInterestPercent(BaseAcc acc)
    {
        if(acc instanceof StudentAcc)
        {
            return INTEREST_STUDENT;
        }
        if(acc instanceof SavingAcc)
        {
            return INTEREST_SAVING;
        }
        return 0;

    }
}
