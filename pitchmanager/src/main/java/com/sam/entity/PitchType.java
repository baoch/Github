package com.sam.entity;

/**
 * Created by vieth on 5/21/2017.
 */
public class PitchType {
    private int pitchTypeId;
    private String pitchTypeName;
    private int maxPlayers;
    private int roundSlot;

    public PitchType(int pitchTypeId, String pitchTypeName, int maxPlayers, int roundSlot) {
        this.pitchTypeId = pitchTypeId;
        this.pitchTypeName = pitchTypeName;
        this.maxPlayers = maxPlayers;
        this.roundSlot = roundSlot;
    }

    public PitchType(String pitchTypeName, int maxPlayers, int roundSlot) {
        this.pitchTypeName = pitchTypeName;
        this.maxPlayers = maxPlayers;
        this.roundSlot = roundSlot;
    }

    public PitchType() {
    }

    public int getPitchTypeId() {
        return pitchTypeId;
    }

    public void setPitchTypeId(int pitchTypeId) {
        this.pitchTypeId = pitchTypeId;
    }

    public String getPitchTypeName() {
        return pitchTypeName;
    }

    public void setPitchTypeName(String pitchTypeName) {
        this.pitchTypeName = pitchTypeName;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getRoundSlot() {
        return roundSlot;
    }

    public void setRoundSlot(int roundSlot) {
        this.roundSlot = roundSlot;
    }
}
