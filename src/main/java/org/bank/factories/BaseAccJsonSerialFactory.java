package org.bank.factories;

import com.google.inject.Inject;
import org.bank.account.AccountNumService;
import org.bank.account.BaseAcc;
import org.bank.json.objects.BaseAccJsonSerialObj;
import org.bank.people.Owner;

public class BaseAccJsonSerialFactory {
    public BaseAccJsonSerialObj createBaseAcc(BaseAcc acc){
        return new BaseAccJsonSerialObj(acc.getOwner().getId(), acc.getAccountNum(), acc.getBalance());
    }
}
