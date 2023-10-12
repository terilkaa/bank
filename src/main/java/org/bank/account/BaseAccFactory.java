package org.bank.account;

import org.bank.people.Owner;

public class BaseAccFactory extends AccFactory {

    public BaseAcc createBaseAcc(Owner owner, double balance){
        return new BaseAcc(owner, accountNumService.accNum(), balance);
    }
}
