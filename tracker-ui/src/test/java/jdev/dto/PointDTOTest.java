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
    private String json = "{\"lat\":20.0,\"lon\":70.0,\"deviceTracker\":\"o567gfd\",\"time\":1664431872094}";

    @Test
    public void toJson() throws Exception{
        PointDTO point = new PointDTO();
        point.setLat(20);
        point.setLon(70);
        point.setDeviceTracker(device);
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":20")); //проверяю lat
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDTO() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(json, PointDTO.class);
        //проверка autoid и time.
        assertEquals(device, dto.getDeviceTracker());
        assertEquals(1664431872094L, dto.getTime());
        System.out.println("Тест tracker-ui.decodeDTO пройден");
    }
}
