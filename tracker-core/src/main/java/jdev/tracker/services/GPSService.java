package jdev.tracker.services;

import jdev.dto.PointDTO;
import jdev.tracker.GPS;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Akv88 14.10.22.
 */
/*Сервис получения координат*/
@Service
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
    }
}
