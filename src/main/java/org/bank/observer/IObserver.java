package org.bank.observer;

public interface IObserver {
    public void update();
    public void setSubject(ISubject subject);
}
