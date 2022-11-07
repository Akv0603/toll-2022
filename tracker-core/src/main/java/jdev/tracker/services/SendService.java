package jdev.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Akv0603 14.10.22.
 */
/*Сервис отправки координат*/
@Service
public class SendService {
    private static final Logger log = LoggerFactory.getLogger(SendService.class);
    private StorageService storageService = new StorageService();
    private PointDTO point;
    private SendCoordinatesService sendCoordinatesService;
//каждую минуту считывает данные из storageService и отправляет  на сервер!
    @Scheduled(cron = "${cronSend.prop}")
    void sendGPSCoordinates() throws JsonProcessingException {
        sendCoordinatesService = new SendCoordinatesService();
        while ((point = storageService.readGPSCoordinates()) != null){
            sendCoordinatesService.sendCoordinates(point);
        }
    }
}
