package org.bank.moneyTransfer;

import org.bank.account.BaseAcc;

public class FeeCalc {

FeeConfigLoader feeConfigLoader = new FeeConfigLoader();
    public double calculate(BaseAcc baseAcc, double amount)
    {
      FeeConfig feeConfig = feeConfigLoader.load(baseAcc);
      if(feeConfig.isFreeOfFee)
      {
          return 0;
      }
      if(amount>= feeConfig.threshold)
      {
          return amount* feeConfig.percent+feeConfig.fixedFee;

      }
      return feeConfig.fixedFee;
    }


}
