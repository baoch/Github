package com.sam.entity;

import java.sql.Date;

/**
 * Created by vieth on 5/24/2017.
 */
public class Bill {
    private int billId;
    private int customerId;
    private boolean isFullyPaid;
    private float currentlyPaid;
    private float currentlyDebt;
    private Date lastPayoutDate;
    private float totalPrice;

    public Bill(int billId, int customerId, boolean isFullyPaid, float currentlyPaid, float currentlyDebt, Date lastPayoutDate, float totalPrice) {
        this.billId = billId;
        this.customerId = customerId;
        this.isFullyPaid = isFullyPaid;
        this.currentlyPaid = currentlyPaid;
        this.currentlyDebt = currentlyDebt;
        this.lastPayoutDate = lastPayoutDate;
        this.totalPrice = totalPrice;
    }

    public Bill(int customerId, boolean isFullyPaid, float currentlyPaid, float currentlyDebt, Date lastPayoutDate, float totalPrice) {
        this.customerId = customerId;
        this.isFullyPaid = isFullyPaid;
        this.currentlyPaid = currentlyPaid;
        this.currentlyDebt = currentlyDebt;
        this.lastPayoutDate = lastPayoutDate;
        this.totalPrice = totalPrice;
    }

    public Bill() {
        totalPrice = 0;
        currentlyDebt = 0;
        currentlyPaid = 0;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isFullyPaid() {
        return isFullyPaid;
    }

    public void setFullyPaid(boolean fullyPaid) {
        isFullyPaid = fullyPaid;
    }

    public float getCurrentlyPaid() {
        return currentlyPaid;
    }

    public void setCurrentlyPaid(float currentlyPaid) {
        this.currentlyPaid = currentlyPaid;
    }

    public float getCurrentlyDebt() {
        return currentlyDebt;
    }

    public void setCurrentlyDebt(float currentlyDebt) {
        this.currentlyDebt = currentlyDebt;
    }

    public Date getLastPayoutDate() {
        return lastPayoutDate;
    }

    public void setLastPayoutDate(Date lastPayoutDate) {
        this.lastPayoutDate = lastPayoutDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
