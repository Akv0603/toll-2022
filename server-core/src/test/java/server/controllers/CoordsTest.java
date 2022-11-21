package server.controllers;

import jdev.dto.PointDTO;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;


public class CoordsTest extends TestCase{
    //тест для координат
    public void testCoords() throws IOException {
        PointDTO point = new PointDTO();
        point.setLat(60);
        point.setLon(120);
        point.setInstSpeed(80);
        point.setAzimuth(300);
        point.setAutoId("AKV0603");
        point.setTime(5);
        Coords coords = new Coords();
        PointDTO pointDTO = coords.getCoords(point);
        String sCoords = pointDTO.toJson();
        assertEquals("{\"lat\":60.0,\"lon\":120.0,\"azimuth\":300.0,\"autoId\":\"AKV0603\",\"time\":5,\"instSpeed\":80.0}", sCoords);
    }
}
