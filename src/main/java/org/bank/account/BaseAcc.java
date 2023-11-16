package org.bank.account;

import org.bank.people.Owner;

public class BaseAcc {
    protected Owner owner;
    protected String accountNum;
    protected double balance;

    public BaseAcc(Owner owner, String accountNum, double balance)
    {
        this.owner = owner;
        this.accountNum = accountNum;
        this.balance = balance;
    }
    public String getAccountNum() {
        return accountNum;
    }
    public Owner getOwner() {
        return owner;
    }

    public void add(double value)
    {
        this.balance+=value;
    }
    public void sub(double value)
    {
        this.balance-=value;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }
}
