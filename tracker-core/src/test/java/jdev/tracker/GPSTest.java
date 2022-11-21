package jdev.tracker;

import jdev.dto.PointDTO;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by User on 021 21.11.22.
 */
public class GPSTest extends TestCase {
    //тест что значения координат будут в нужном диапазоне
    @Test
    public void testSetGPS(){
        GPS gps = new GPS();
        PointDTO point = gps.setCoordinates();
        assertTrue((point.getLat() <= 90) && (point.getLat() > 0));//от 0 до 90 включ.
        assertTrue((point.getLon() <= 180) && (point.getLon() > 0));//от 0 до 180 включ
        assertTrue((point.getAzimuth() <= 360) && (point.getAzimuth() > 0));//от 0 до 360
        assertTrue((point.getInstSpeed() <= 140) && (point.getInstSpeed() > 0));//от 0 до 140
    }
}