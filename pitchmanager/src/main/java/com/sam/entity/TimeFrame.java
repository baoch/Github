package com.sam.entity;

import java.sql.Time;

/**
 * Created by vieth on 5/23/2017.
 */
public class TimeFrame {
    private int timeFrameId;
    private Time fromTime;
    private Time toTime;



    public TimeFrame(int timeFrameId, Time fromTime, Time toTime) {
        this.timeFrameId = timeFrameId;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public TimeFrame() {
    }

    public TimeFrame(Time fromTime, Time toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public int getTimeFrameId() {
        return timeFrameId;
    }

    public void setTimeFrameId(int timeFrameId) {
        this.timeFrameId = timeFrameId;
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
