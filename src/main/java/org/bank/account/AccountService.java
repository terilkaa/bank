package org.bank.account;

import java.util.HashMap;
import java.util.Map;

import org.bank.people.Owner;

public class AccountService {
    private final BaseAccFactory baseAccFactory;
    private final SavingAccFactory savingAccFactory;
    private final StudentAccFactory studentAccFactory;
    private Map<String, BaseAcc> accounts;

    public AccountService() {
        this.accounts = new HashMap<>();
        this.baseAccFactory = new BaseAccFactory();
        this.savingAccFactory = new SavingAccFactory();
        this.studentAccFactory = new StudentAccFactory();
    }

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
