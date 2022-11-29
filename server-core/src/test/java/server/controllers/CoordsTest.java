package server.controllers;

import jdev.dto.PointDTO;
import junit.framework.TestCase;
import server.dao.Coords;

import java.io.IOException;


public class CoordsTest extends TestCase{
    //тест для координат
    public void testCoords() throws IOException {
        PointDTO point = new PointDTO();
        point.setLat(60);
        point.setLon(120);
        point.setInstSpeed(80);
        point.setAzimuth(300);
        point.setTime(5);
        Coords coords = new Coords();
        CoordsControllers coordsControllers = new CoordsControllers();
        String str = coordsControllers.getCoords(point);
        String toJSON = point.toJson();
        assertEquals("{\"lat\":60.0,\"lon\":120.0,\"azimuth\":300.0,\"deviceTracker\":null,\"time\":5,\"instSpeed\":80.0}", toJSON);
    }
}
