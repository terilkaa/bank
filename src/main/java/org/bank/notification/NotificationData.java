package org.bank.notification;

public class NotificationData {
    private String customerName;
    public NotificationData(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return customerName;
    }
}
