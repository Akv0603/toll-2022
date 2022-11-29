package jdev.dto;

/**
 * Created by User on 029 29.11.22.
 */
public class RequestDTO {
    private String deviceTracker;
    private int number;

    public String getDeviceTracker() {
        return deviceTracker;
    }

    public void setDeviceTracker(String deviceTracker) {
        this.deviceTracker = deviceTracker;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
