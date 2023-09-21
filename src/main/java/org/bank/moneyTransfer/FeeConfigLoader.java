package org.bank.moneyTransfer;

import org.bank.account.BaseAcc;
import org.bank.account.SavingAcc;
import org.bank.account.StudentAcc;

public class FeeConfigLoader {

    private static final double THRESHOLD_FEE = 1000;
    private static final double PERCENT_FEE = 0.1;
    private static final double FIXED_FEE = 5;
    private static final double SAVING_PERCENT_FEE = 0.5;
    private static final double SAVING_FEE_THRESHOLD = 500;
    private static final double SAVING_FIXED_FEE = 50;

    FeeConfig feeConfig;

    public FeeConfig load(BaseAcc baseAcc) {

        if (baseAcc instanceof StudentAcc) {
            return new FeeConfig(0, 0, 0, true);
        }
        if (baseAcc instanceof SavingAcc) {
            return new FeeConfig(SAVING_FIXED_FEE, SAVING_PERCENT_FEE, SAVING_FEE_THRESHOLD,false);
        }
        return new FeeConfig(FIXED_FEE,PERCENT_FEE, THRESHOLD_FEE,false);
    }
}
