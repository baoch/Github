package com.sam.entity;

import java.sql.Time;

/**
 * Created by vieth on 5/23/2017.
 */
public class Slot {
    private int slotId;
    private Time fromTime;
    private Time toTime;

    public Slot(int slotId, Time fromTime, Time toTime) {
        this.slotId = slotId;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Slot() {
    }

    public Slot(Time fromTime, Time toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }


    public Time getFromTime() {
        return fromTime;
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public Time getToTime() {
        return toTime;
    }

    public void setToTime(Time toTime) {
        this.toTime = toTime;
    }
}
