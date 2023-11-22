package org.bank.observer;

public interface ISubject {
    public void register(IObserver iObserver);
    public void unregister(IObserver iObserver);
    public void notifyObservers();
    public Object getUpdate(IObserver iObserver);
}
