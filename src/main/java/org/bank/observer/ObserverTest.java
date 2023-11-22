package org.bank.observer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bank.Bank;
import org.bank.validation.BankInjector;

public class ObserverTest {
    public static void main(String[] args) throws Exception {
        MyTopic myTopic = new MyTopic();

        MyTopicSubscriber myTopicSubscriber = new MyTopicSubscriber("wuoefh");
        MyTopicSubscriber myTopicSubscriber1 = new MyTopicSubscriber("ofeihw");
        MyTopicSubscriber myTopicSubscriber2 = new MyTopicSubscriber("woiudljk");

        myTopic.register(myTopicSubscriber);
        myTopic.register(myTopicSubscriber1);
        myTopic.register(myTopicSubscriber2);

        myTopic.postMessage("aserdzuoijpkl");

    }
}
