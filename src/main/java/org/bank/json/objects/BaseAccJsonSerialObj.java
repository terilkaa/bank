package org.bank.json.objects;

import org.bank.people.Owner;

public class BaseAccJsonSerialObj {
    private double balance;
    private int ownerId;
    private String accountNum;

    public double getBalance() {
        return balance;
    }
    public int getOwnerId() {
        return ownerId;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public BaseAccJsonSerialObj(int ownerId, String accountNum, double balance) {
        this.ownerId = ownerId;
        this.accountNum = accountNum;
        this.balance = balance;
    }
}
