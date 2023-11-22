package org.bank.factories;

import org.bank.notification.NotificationData;

public class NotificationDataFactory {
    public NotificationData createNotificationData(String customerName) {
        return new NotificationData(customerName);
    }
}
