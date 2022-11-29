package jdev.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 029 29.09.22.
 */
public class PointDTOTest {
    private final String device = "o567gfd";
    private String json = "{\"lat\":10.0,\"lon\":40.0,\"deviceTracker\":\"o567gfd\",\"time\":1664430255804}";

    @Test
    public void toJson() throws Exception{
        PointDTO point = new PointDTO();
        point.setLat(10);
        point.setLon(40);
        point.setDeviceTracker(device);
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":10")); //проверяю lat
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDTO() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(json, PointDTO.class);
        //проверка autoid и time.
        assertEquals(device, dto.getDeviceTracker());
        assertEquals(1664430255804L, dto.getTime());
        System.out.println("Тест tracker-core.decodeDTO пройден");
    }
}
