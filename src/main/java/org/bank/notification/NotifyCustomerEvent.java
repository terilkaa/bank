package org.bank.notification;

public class NotifyCustomerEvent {
    private NotificationData notificationData;
    public NotificationData getNotificationData() {
        return notificationData;
    }

    public NotifyCustomerEvent(NotificationData notificationData) {
        this.notificationData = notificationData;
    }
}
