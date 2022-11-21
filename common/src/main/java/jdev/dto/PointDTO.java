package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by User on 029 29.09.22.
 */
//точка расположения грузовика с полями координаты(долгота, широта). госномер и т.п..

public class PointDTO {
    private double lat;
    private double lon;
    private  double azimuth;
    private String autoId;
    private long time;
    private  double instSpeed;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public double getInstSpeed() {
        return instSpeed;
    }

    public void setInstSpeed(double instSpeed) {
        this.instSpeed = instSpeed;
    }

    public String toJson() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "PointDTO{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", azimuth=" + azimuth +
                ", instSpeed=" + instSpeed +
                ", autoId='" + autoId + '\'' +
                ", time=" + time +
                '}';
    }
}
