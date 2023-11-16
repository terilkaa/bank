package org.bank.account;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.bank.factories.BaseAccFactory;
import org.bank.factories.SavingAccFactory;
import org.bank.factories.StudentAccFactory;
import org.bank.people.Owner;
@Singleton
public class AccountService {
    @Inject
    private BaseAccFactory baseAccFactory;
    @Inject
    private SavingAccFactory savingAccFactory;
    @Inject
    private StudentAccFactory studentAccFactory;

    private Map<String, BaseAcc> accounts;

    public AccountService() {
        this.accounts = new HashMap<>();
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
