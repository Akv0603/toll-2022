package jdev.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Сервис отправки координат*/
@Service
public class SendService {
    private static final Logger log = LoggerFactory.getLogger(SendService.class);
    private PointDTO point;
    private SendCoordinatesService sendCoordinatesService = new SendCoordinatesService();
    private StorageService storageService = new StorageService();
    private CoordsUpdateService coordsUpdateService = new CoordsUpdateService();
    private RouteRequest routeRequest = new RouteRequest();

//каждую минуту считывает данные из storageService и отправляет  на сервер!
    @Scheduled(cron = "${cronSend.prop}")
    void sendGPSCoordinates() throws JsonProcessingException {
        while ((point = storageService.readGPSCoordinates()) != null){
            sendCoordinatesService.sendCoordinates(point);
           // coordsUpdateService.updateDBCoords(point);//апдейт координат  в БД
            routeRequest.sendRouteRequest("AKV-GPS", 4);
        }
    }
}
