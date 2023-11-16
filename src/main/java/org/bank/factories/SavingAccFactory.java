package org.bank.factories;

import org.bank.account.SavingAcc;
import org.bank.factories.AccFactory;
import org.bank.people.Owner;

public class SavingAccFactory extends AccFactory {
    public SavingAcc createSavingAcc(Owner owner, double balance){
        return new SavingAcc(owner, accountNumService.accNum(), balance);
    }
}
