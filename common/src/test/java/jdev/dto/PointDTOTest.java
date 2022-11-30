package jdev.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointDTOTest {
    private final String device = "o567gfd";
    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"deviceTracker\":\"o567gfd\",\"time\":1664430255804}";

    @Test
    public void toJson() throws Exception{
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setDeviceTracker(device);
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56")); //проверяю lat
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDTO() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(expected, PointDTO.class);
        //проверка devicetracker и time.
        assertEquals(device, dto.getDeviceTracker());
        assertEquals(1664430255804L, dto.getTime());
        System.out.println("Тест common.decodeDTO пройден");
    }

}
