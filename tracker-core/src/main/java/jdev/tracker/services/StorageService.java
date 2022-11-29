package jdev.tracker.services;

import dao.repo.CoordsRepository;
import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Akv0603 14.10.22.
 */

/*Сервис для хранения координат gps*/
@Service
public class StorageService {
    private static final Logger log = LoggerFactory.getLogger(StorageService.class);
    private PointDTO coordinates = new PointDTO();
    private static BlockingDeque<PointDTO> queue = new LinkedBlockingDeque<>(10);

    @Autowired
    CoordsRepository coordsRepository;

    //метод записи координат в блокирующую очередь(юзаем в GPSService)
    void writeGPSCoordinates(PointDTO coordinates) throws InterruptedException{
        queue.put(coordinates);
    }
//Считываем координаты с проверкой, чтобы не выдавало одни нули
    PointDTO readGPSCoordinates(){
        coordinates = null;
        if(queue.size() != 0){
            coordinates = queue.poll();
        }
        return coordinates;
    }
}
