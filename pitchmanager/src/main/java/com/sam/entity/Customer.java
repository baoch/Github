package com.sam.entity;

/**
 * Created by vieth on 5/23/2017.
 */
public class Customer {

    private int customerId;
    private String fullname;
    private String phone;

    public Customer(int customerId, String fullname, String phone) {
        this.customerId = customerId;
        this.fullname = fullname;
        this.phone = phone;
    }

    public Customer() {
    }

    public Customer(String fullname, String phone) {
        this.fullname = fullname;
        this.phone = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
