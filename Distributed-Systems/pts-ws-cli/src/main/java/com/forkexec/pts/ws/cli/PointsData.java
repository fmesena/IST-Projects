package com.forkexec.pts.ws.cli;

public class PointsData {
    private int value;
    private int tag;

    public PointsData(int value, int tag) {
        this.value = value;
        this.tag = tag;
    }

    public int getValue() {
        return value;
    }

    public int getTag() {
        return tag;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}