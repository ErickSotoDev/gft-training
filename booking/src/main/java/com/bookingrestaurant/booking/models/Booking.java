package com.bookingrestaurant.booking.models;

import java.time.LocalDateTime;

public class Booking {
    private String customerName;
    private int tableSize;
    private LocalDateTime dateTime;
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getTableSize() {
        return tableSize;
    }
    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
