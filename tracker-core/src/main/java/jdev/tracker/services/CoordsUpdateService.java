package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.Coords;
import dao.repo.CoordsRepository;

@Service
public class CoordsUpdateService {
    private Coords coords = new Coords();
    @Autowired
    private CoordsRepository coordsRepository;

    // типа запись в Базу данных
    @Transactional
    public void updateDBCoords(PointDTO pointDTO) {
        coords.setLat(pointDTO.getLat());
        coords.setLon(pointDTO.getLon());
        coords.setAzimuth(pointDTO.getAzimuth());
        coords.setInstSpeed(pointDTO.getInstSpeed());
        coords.setDeviceTracker(pointDTO.getDeviceTracker());
        coordsRepository.save(coords);
    }
}