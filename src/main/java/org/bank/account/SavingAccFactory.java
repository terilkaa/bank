package org.bank.account;

import org.bank.people.Owner;

public class SavingAccFactory extends AccFactory{
    public SavingAcc createSavingAcc(Owner owner, double balance){
        return new SavingAcc(owner, accountNumService.accNum(), balance);
    }
}
