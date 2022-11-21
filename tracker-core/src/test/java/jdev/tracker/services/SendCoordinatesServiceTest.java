package jdev.tracker.services;

import jdev.dto.PointDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Created by User on 021 21.11.22.
 */
public class SendCoordinatesServiceTest extends TestCase {

    @Autowired
    RestTemplate restTemplate;

//тест для SendCoordinatesService Сравнение результата
    @Test
    public void testSendCoordinates() throws Exception{
        String url = "http://localhost:8080/coords";
        restTemplate = new RestTemplate();
        PointDTO point = new PointDTO();
        point.setLat(60);
        point.setLon(120);
        point.setAzimuth(300);
        String sendCoordinates = restTemplate.postForObject(url, point, String.class);
        String expected = "{\"lat\":60.0,\"lon\":120.0,\"azimuth\":300.0,\"autoId\":null,\"time\":0,\"instSpeed\":0.0}";
        assertEquals(expected, sendCoordinates);

    }
}
