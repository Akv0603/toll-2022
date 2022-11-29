package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.Coords;
import dao.repo.CoordsRepository;

/**
 * Created by User on 029 29.11.22.
 */
@Service
public class CoordsUpdateService {
    private Coords coords = new Coords();
    @Autowired
    private CoordsRepository coordsRepository;

    @Transactional
    public void updateDBCoords(PointDTO pointDTO) {
        coords.setInstSpeed(pointDTO.getInstSpeed());
    }
}