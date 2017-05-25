package com.sam.entity;

import java.sql.Date;

/**
 * Created by vieth on 5/24/2017.
 */
public class BillPayment {
    private int paymentId;
    private int billId;
    private int payoutNum;
    private int payoutValue;
    private Date payoutDate;

    public BillPayment(int paymentId, int billId, int payoutNum, int payoutValue, Date payoutDate) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.payoutNum = payoutNum;
        this.payoutValue = payoutValue;
        this.payoutDate = payoutDate;
    }

    public BillPayment() {
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPayoutNum() {
        return payoutNum;
    }

    public void setPayoutNum(int payoutNum) {
        this.payoutNum = payoutNum;
    }

    public int getPayoutValue() {
        return payoutValue;
    }

    public void setPayoutValue(int payoutValue) {
        this.payoutValue = payoutValue;
    }

    public Date getPayoutDate() {
        return payoutDate;
    }

    public void setPayoutDate(Date payoutDate) {
        this.payoutDate = payoutDate;
    }
}
