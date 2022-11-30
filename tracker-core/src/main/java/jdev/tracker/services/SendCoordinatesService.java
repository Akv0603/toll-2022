package jdev.tracker.services;


import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SendCoordinatesService {

    private RestTemplate restTemplate;

    public void sendCoordinates(PointDTO point){
        String url = "http://localhost:8080/coordsDao";
        restTemplate = new RestTemplate();
        //отправляем координаты POSt запросом
        String coords = restTemplate.postForObject(url, point, String.class);
    }

}
