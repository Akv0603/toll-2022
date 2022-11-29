package dao;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;
/**
 * Создаем сущность(таблицу GPS)
 */
@Entity
@Table(name = "GPS")
public class Coords {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "Lat")
    double lat;

    @Column(name = "Lon")
    double lon;

    @Column(name = "Azimuth")
    double azimuth;

    @Column(name = "Speed")
    double instSpeed;

    @Column(name = "DeviceTracker")
    String deviceTracker;

    @Column(name = "Time")
    long time;

    public String getDeviceTracker() {
        return deviceTracker;
    }

    public void setDeviceTracker(String deviceTracker) {
        this.deviceTracker = deviceTracker;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
