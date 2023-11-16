package org.bank.factories;

import org.bank.account.BaseAcc;
import org.bank.account.SavingAcc;
import org.bank.json.objects.BaseAccJsonSerialObj;
import org.bank.json.objects.SavingAccJsonSerialObj;

public class SavingAccJsonSerialFactory extends BaseAccJsonSerialFactory {
    public SavingAccJsonSerialObj createSavingAcc(SavingAcc acc){
        return new SavingAccJsonSerialObj(acc.getOwner().getId(), acc.getAccountNum(), acc.getBalance());
    }
}
