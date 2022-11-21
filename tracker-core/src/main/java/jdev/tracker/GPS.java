package jdev.tracker;

import jdev.dto.PointDTO;

import java.util.Random;

/**
 * Created by Akv0603  14.10.22.
 *создаем класс gps, эмулирующий получение координат через gps-навигатор
 * Округляю значения для удобства чтения*/
public class GPS {
    public PointDTO setCoordinates(){
        PointDTO pointDTO = new PointDTO();
        Random random = new Random();
        pointDTO.setLat(Math.ceil(random.nextDouble() * 90));//от 0 до 90 град
        pointDTO.setLon(Math.ceil(random.nextDouble() * 180));//от 0 до 180 град
        pointDTO.setAzimuth(Math.ceil(random.nextDouble() * 360));//0т 0 до 360 град
        pointDTO.setInstSpeed(Math.ceil(random.nextDouble() * 140));//максимальная скорость грузовика
        pointDTO.setAutoId("AKV0603");//один грузовик
        pointDTO.setTime(System.currentTimeMillis());
        return pointDTO;
    }
}
