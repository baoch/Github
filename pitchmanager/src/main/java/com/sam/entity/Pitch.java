package com.sam.entity;




/**
 * Created by vieth on 5/20/2017.
 */
public class Pitch {
    private  int pitchId;
    private String pitchName;
    private int pitchTypeId;
    private float pitchWidth;
    private float pitchLength;
    boolean status;

    public Pitch() {
    }

    public Pitch(int pitchId, String pitchName, int pitchTypeId, float pitchWidth, float pitchLength, boolean status) {
        this.pitchId = pitchId;
        this.pitchName = pitchName;
        this.pitchTypeId = pitchTypeId;
        this.pitchWidth = pitchWidth;
        this.pitchLength = pitchLength;
        this.status = status;
    }

    public Pitch(String pitchName, int pitchTypeId, float pitchWidth, float pitchLength, boolean status) {
        this.pitchName = pitchName;
        this.pitchTypeId = pitchTypeId;
        this.pitchWidth = pitchWidth;
        this.pitchLength = pitchLength;
        this.status = status;
    }

    public int getPitchId() {
        return pitchId;
    }

    public void setPitchId(int pitchId) {
        this.pitchId = pitchId;
    }

    public String getPitchName() {
        return pitchName;
    }

    public void setPitchName(String pitchName) {
        this.pitchName = pitchName;
    }

    public float getPitchWidth() {
        return pitchWidth;
    }

    public void setPitchWidth(float pitchWidth) {
        this.pitchWidth = pitchWidth;
    }

    public float getPitchLength() {
        return pitchLength;
    }

    public void setPitchLength(float pitchLength) {
        this.pitchLength = pitchLength;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPitchTypeId() {
        return pitchTypeId;
    }

    public void setPitchTypeId(int pitchTypeId) {
        this.pitchTypeId = pitchTypeId;
    }
}
