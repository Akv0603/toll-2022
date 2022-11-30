package jd.security.services;

import jd.security.dao.Coords;
import jd.security.repo.CoordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordsService {
    @Autowired
    private CoordsRepository coordsRepository;
    public Object getCoords(){
        List<Coords> list = (List<Coords>) coordsRepository.findAll();
        return list;
    }
}
