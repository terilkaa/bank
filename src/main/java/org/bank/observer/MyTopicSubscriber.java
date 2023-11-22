package org.bank.observer;

public class MyTopicSubscriber implements IObserver {
    private String name;
    private ISubject topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    public void update() {
        String message = (String) topic.getUpdate(this);

        if (message == null) {
            System.out.println(name + ": No new message");
        } else {
            System.out.println(name + ": Consuming message: " + message);
        }
    }

    public void setSubject(ISubject subject) {
        topic = subject;
    }
}