package com.sam.entity;

import java.sql.Time;

/**
 * Created by vieth on 5/24/2017.
 */
public class TimeFrame_PitchType {
    private int pitchTypeId;
    private int timeFrameId;
    private float referencePrice;
    private String pitchTypeName;
    private Time fromTime;
    private Time toTime;


    public TimeFrame_PitchType(int pitchTypeId, int timeFrameId, float referencereferencePrice) {
        this.pitchTypeId = pitchTypeId;
        this.timeFrameId = timeFrameId;
        this.referencePrice = referencePrice;
    }

    public TimeFrame_PitchType() {
    }

    public int getPitchTypeId() {
        return pitchTypeId;
    }

    public void setPitchTypeId(int pitchTypeId) {
        this.pitchTypeId = pitchTypeId;
    }

    public int getTimeFrameId() {
        return timeFrameId;
    }

    public void setTimeFrameId(int timeFrameId) {
        this.timeFrameId = timeFrameId;
    }

    public float getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(float referencePrice) {
        this.referencePrice = referencePrice;
    }

    public String getPitchTypeName() {
        return pitchTypeName;
    }

    public void setPitchTypeName(String pitchTypeName) {
        this.pitchTypeName = pitchTypeName;
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
