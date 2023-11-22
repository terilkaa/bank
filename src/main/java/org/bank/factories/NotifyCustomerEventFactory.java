package org.bank.factories;

import org.bank.notification.NotificationData;
import org.bank.notification.NotifyCustomerEvent;

public class NotifyCustomerEventFactory {
    public NotifyCustomerEvent createNotifyCustomerEvent(NotificationData notificationData){
        return new NotifyCustomerEvent(notificationData);
    }
}
