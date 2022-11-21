package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Created by User on 007 07.11.22.
 */
public class SendCoordinatesService {

    @Autowired
    RestTemplate restTemplate;

    public void sendCoordinates(PointDTO point){
        String url = "http://localhost:8080/coords";
        restTemplate = new RestTemplate();
        //отправляем координаты POSt запросом
        String coords = restTemplate.postForObject(url, point, String.class);
    }

}
