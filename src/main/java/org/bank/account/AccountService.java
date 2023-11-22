package org.bank.account;

import java.util.HashMap;
import java.util.Map;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import jdk.jfr.Event;
import org.bank.factories.*;
import org.bank.notification.NotifyCustomerEvent;
import org.bank.people.Owner;
@Singleton
public class AccountService {
    @Inject
    private BaseAccFactory baseAccFactory;
    @Inject
    private SavingAccFactory savingAccFactory;
    @Inject
    private StudentAccFactory studentAccFactory;
    @Inject
    private NotificationDataFactory notificationDataFactory;
    @Inject
    private NotifyCustomerEventFactory notifyCustomerEventFactory;
    @Inject
    private EventBus eventBus;
    private Map<String, BaseAcc> accounts;

    public AccountService() {
        this.accounts = new HashMap<>();
    }

    public BaseAcc createStoreBaseAcc(Owner owner, double balance) {
        BaseAcc baseAcc = this.baseAccFactory.createBaseAcc(owner, balance);
        this.accounts.put(baseAcc.getAccountNum(), baseAcc);
        eventBus.post(createEvent(owner.getFullName()));
        return baseAcc;
    }
    public StudentAcc createStoreStudentAcc(Owner owner, double balance) {
        StudentAcc studentAcc = studentAccFactory.createStudentAcc(owner, balance);
        this.accounts.put(studentAcc.getAccountNum(), studentAcc);
        eventBus.post(createEvent(owner.getFullName()));
        return studentAcc;
    }
    public SavingAcc createStoreSavingAcc(Owner owner, double balance) {
        SavingAcc savingAcc = savingAccFactory.createSavingAcc(owner, balance);
        this.accounts.put(savingAcc.getAccountNum(), savingAcc);
        eventBus.post(createEvent(owner.getFullName()));
        return savingAcc;
    }
    private NotifyCustomerEvent createEvent(String customerName){
        return notifyCustomerEventFactory.createNotifyCustomerEvent(notificationDataFactory.createNotificationData(customerName));
    }

    public Map<String, BaseAcc> getAccounts() {
        return accounts;
    }

}
