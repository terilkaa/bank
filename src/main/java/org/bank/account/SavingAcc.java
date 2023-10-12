package org.bank.account;

import org.bank.people.Owner;

public class SavingAcc extends  BaseAcc implements InterestAcc{
    public SavingAcc(Owner owner, String accountNum, double balance) {
        super(owner, accountNum, balance);
    }

}
