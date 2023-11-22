package org.bank.observer;


import java.util.ArrayList;
import java.util.List;

public class MyTopic implements ISubject {
    private List<IObserver> observers = new ArrayList<>();
    private String message = null;
    private boolean changed = false;
    private final Object MUTEX = new Object();

    public void register(IObserver observer) {
        if (observer == null) {
            throw new NullPointerException("Null Observer");
        }

        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                observers.add(observer);
                observer.setSubject(this);
            }
        }
    }

    public void unregister(IObserver observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        List<IObserver> observersLocal;

        synchronized (MUTEX) {
            if (!changed) {
                return;
            }

            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;

            for (IObserver observer : observersLocal) {
                observer.update();
            }
        }
    }

    public Object getUpdate(IObserver observer) {
        return message;
    }

    public void postMessage(String message) {
        System.out.println("Message posted to topic: " + message);
        this.message = message;
        this.changed = true;
        notifyObservers();
    }
}