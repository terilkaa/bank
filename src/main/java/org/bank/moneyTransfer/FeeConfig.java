package org.bank.moneyTransfer;

import org.bank.account.BaseAcc;
import org.bank.account.StudentAcc;

public class FeeConfig {

    double fixedFee;
    double percent;
    double threshold;
    boolean isFreeOfFee;
    public FeeConfig(double fixedFee, double percent, double threshold, boolean isFreeOfFee)
    {
        this.fixedFee = fixedFee;
        this.threshold = threshold;
        this.percent = percent;
        this.isFreeOfFee = isFreeOfFee;
    }

}
