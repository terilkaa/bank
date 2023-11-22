package org.bank.notification;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.bank.print.ILogger;

@Singleton
public class NotifyCustomerEventListener {
    @Inject
    ILogger iLogger;
    @Subscribe
    public void onNotifyEvent(NotifyCustomerEvent notifyCustomerEvent){
        iLogger.debug("Notification sent to user: " + notifyCustomerEvent.getNotificationData().getCustomerName());
    }
}