package com.bookingrestaurant.booking.models;



public class Booking {
    private String customerName;
    private int tableSize;
    private String date;
    private String time;
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
