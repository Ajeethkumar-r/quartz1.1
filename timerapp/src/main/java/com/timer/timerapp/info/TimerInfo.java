package com.timer.timerapp.info;

public class TimerInfo {
    private int totalFireCount;
    private boolean repeatForever;
    private long repeatIntervalMs;
    private long intialOffsetMs;
    private String callbackData;
    
    

    /**
     * @return int return the totalFireCount
     */
    public int getTotalFireCount() {
        return totalFireCount;
    }

    /**
     * @param totalFireCount the totalFireCount to set
     */
    public void setTotalFireCount(int totalFireCount) {
        this.totalFireCount = totalFireCount;
    }

    /**
     * @return boolean return the repeatForever
     */
    public boolean isRepeatForever() {
        return repeatForever;
    }

    /**
     * @param repeatForever the repeatForever to set
     */
    public void setRepeatForever(boolean repeatForever) {
        this.repeatForever = repeatForever;
    }

    /**
     * @return long return the repeatIntervalMs
     */
    public long getRepeatIntervalMs() {
        return repeatIntervalMs;
    }

    /**
     * @param repeatIntervalMs the repeatIntervalMs to set
     */
    public void setRepeatIntervalMs(long repeatIntervalMs) {
        this.repeatIntervalMs = repeatIntervalMs;
    }

    /**
     * @return long return the intialOffsetMs
     */
    public long getIntialOffsetMs() {
        return intialOffsetMs;
    }

    /**
     * @param intialOffsetMs the intialOffsetMs to set
     */
    public void setIntialOffsetMs(long intialOffsetMs) {
        this.intialOffsetMs = intialOffsetMs;
    }

    /**
     * @return String return the callbackData
     */
    public String getCallbackData() {
        return callbackData;
    }

    /**
     * @param callbackData the callbackData to set
     */
    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }

}
