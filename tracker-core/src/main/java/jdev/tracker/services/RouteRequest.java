package jdev.tracker.services;

import jdev.dto.RequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RouteRequest {
    private static final Logger log = LoggerFactory.getLogger(SendService.class);
    RequestDTO request = new RequestDTO();
    private RestTemplate restTemplate;
    public void sendRouteRequest(String device, int lastNumbers) {
//запрос последних точек с трекера
        request.setDeviceTracker(device);
        request.setNumber(lastNumbers);

        String url = "http://localhost:8080/points";
        restTemplate = new RestTemplate();
        //POST запрос
        String route = restTemplate.postForObject(url, request, String.class);

        log.info(route); //выводим в json
    }
}
