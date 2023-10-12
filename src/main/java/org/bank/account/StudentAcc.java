package org.bank.account;

import org.bank.people.Owner;

public class StudentAcc  extends BaseAcc implements InterestAcc{
    public StudentAcc(Owner owner, String accountNum, double balance){
        super(owner, accountNum, balance);
    }

}
