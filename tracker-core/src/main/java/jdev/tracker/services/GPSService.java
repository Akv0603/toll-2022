package jdev.tracker.services;

import jdev.dto.PointDTO;
import jdev.tracker.GPS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import dao.Coords;


/*Сервис получения координат*/
@Component
public class GPSService {
    private static final Logger log = LoggerFactory.getLogger(GPSService.class);

    private PointDTO coordinates = new PointDTO();
    private GPS gps = new GPS();
    private StorageService storageService = new StorageService();
//каждую секунду собираем данные

    @Scheduled(cron = "${cron.prop}")
    void addGPSCoordinates() throws Exception{
        //получаем и записываем(отправляем) координаты в storageService(сервис хранения)
        coordinates = gps.setCoordinates();
        storageService.writeGPSCoordinates(coordinates);

        Coords coords = new Coords();
        coords.setLat(coordinates.getLat());
        coords.setLon(coordinates.getLon());
        coords.setAzimuth(coordinates.getAzimuth());
        coords.setInstSpeed(coordinates.getInstSpeed());
        coords.setTime(coordinates.getTime());
        coords.setDeviceTracker(coordinates.getDeviceTracker());
    }
}
