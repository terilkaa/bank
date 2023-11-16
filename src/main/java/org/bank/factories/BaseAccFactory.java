package org.bank.factories;

import org.bank.account.BaseAcc;
import org.bank.factories.AccFactory;
import org.bank.people.Owner;

public class BaseAccFactory extends AccFactory {

    public BaseAcc createBaseAcc(Owner owner, double balance){
        return new BaseAcc(owner, accountNumService.accNum(), balance);
    }
}
