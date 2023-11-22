package org.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bank.notification.NotifyCustomerEvent;
import org.bank.notification.NotifyCustomerEventListener;
import org.bank.notification.NotifyNewsletterEventListener;
import org.bank.validation.BankInjector;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Injector injector = Guice.createInjector(new BankInjector());
            Bank bank = injector.getInstance(Bank.class);
            injector.getInstance(NotifyCustomerEventListener.class);
            injector.getInstance(NotifyNewsletterEventListener.class);
            bank.run();
        }
        catch(Exception e)
            {
                System.out.println("err");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

    }
}