package jd.security.dao;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "coords")
public class Coords {

        @Id
        @GeneratedValue(strategy = AUTO)
        @Column(name = "ID")
        int id;

        @Column(name = "LAT")
        double lat;

        @Column(name = "LON")
        double lon;

        @Column(name = "AZIMUTH")
        double azimuth;

        @Column(name = "SPEED")
        double instSpeed;

        @Column(name = "TIME")
        long time;

        @Column(name = "DEVICE_TRACKER")
        String deviceTracker;

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

        public long getTime() {
                return time;
        }

        public void setTime(long time) {
                this.time = time;
        }

        public String getDeviceTracker() {
                return deviceTracker;
        }

        public void setDeviceTracker(String deviceTracker) {
                this.deviceTracker = deviceTracker;
        }
}
