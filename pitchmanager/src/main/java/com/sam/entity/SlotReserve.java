package com.sam.entity;

import java.sql.Date;

/**
 * Created by vieth on 5/24/2017.
 */
public class SlotReserve {
    private int slotReserveId;
    private int slotId;
    private int pitchId;
    private float price;
    private Date date;
    private int billId;


    public SlotReserve() {
    }

    public SlotReserve(int slotReserveId, int slotId, int pitchId, float price, Date date, int billId) {
        this.slotReserveId = slotReserveId;
        this.slotId = slotId;
        this.pitchId = pitchId;
        this.price = price;
        this.date = date;
        this.billId = billId;
    }

    public int getslotReserveId() {
        return slotReserveId;
    }

    public void setslotReserveId(int slotReserveId) {
        this.slotReserveId = slotReserveId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getPitchId() {
        return pitchId;
    }

    public void setPitchId(int pitchId) {
        this.pitchId = pitchId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
}
