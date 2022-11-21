package jdev.tracker.services;

import jdev.dto.PointDTO;
import jdev.tracker.GPS;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by User on 021 21.11.22.
 */
public class GPSServiceTest extends TestCase {
    PointDTO coords = new PointDTO();
    GPS gps = new GPS();
    StorageService storageService = new StorageService();
//тест на запись и получение координат на примере широты, долготы и азимута для GPSService
    @Test
    public void testAddCoordinates() throws Exception{
        coords = gps.setCoordinates();
        double lat = coords.getLat();
        double lon = coords.getLon();
        double azimuth = coords.getAzimuth();
        storageService.writeGPSCoordinates(coords);
        PointDTO readCoords = storageService.readGPSCoordinates();
        assertEquals(readCoords.getLat(), lat);
        assertEquals(readCoords.getLon(), lon);
        assertEquals(readCoords.getAzimuth(), azimuth);
    }

}
