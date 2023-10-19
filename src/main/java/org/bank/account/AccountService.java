package org.bank.account;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import org.bank.people.Owner;

public class AccountService {
    @Inject
    private BaseAccFactory baseAccFactory;
    @Inject
    private SavingAccFactory savingAccFactory;
    @Inject
    private StudentAccFactory studentAccFactory;
    @Inject
    private Map<String, BaseAcc> accounts;

    public BaseAcc createStoreBaseAcc(Owner owner, double balance) {
        BaseAcc baseAcc = this.baseAccFactory.createBaseAcc(owner, balance);
        this.accounts.put(baseAcc.getAccountNum(), baseAcc);
        return baseAcc;
    }

    public StudentAcc createStoreStudentAcc(Owner owner, double balance) {
        StudentAcc studentAcc = studentAccFactory.createStudentAcc(owner, balance);
        this.accounts.put(studentAcc.getAccountNum(), studentAcc);
        return studentAcc;
    }

    public SavingAcc createStoreSavingAcc(Owner owner, double balance) {
        SavingAcc savingAcc = savingAccFactory.createSavingAcc(owner, balance);
        this.accounts.put(savingAcc.getAccountNum(), savingAcc);
        return savingAcc;
    }

    public Map<String, BaseAcc> getAccounts() {
        return accounts;
    }

}
