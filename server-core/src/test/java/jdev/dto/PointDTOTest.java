package jdev.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by User on 029 29.09.22.
 */
public class PointDTOTest {
    private final String autoId = "o567gfd";
    private String json = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1664430255804}";

    @Test
    public void toJson() throws Exception{
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId(autoId);
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lon\":74")); //проверяю lon
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDTO() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(json, PointDTO.class);
        //проверка autoid и time.
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1664430255804L, dto.getTime());
        System.out.println("Тест server-core.decodeDTO пройден");
    }
}
