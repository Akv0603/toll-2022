package server.controllers;

import server.dao.Coords;
import server.repo.CoordsRepository;
import com.google.gson.Gson;
import jdev.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class RouteController {

    @Autowired
    private CoordsRepository coordsRepository;

    // прием запроса от устройства-трекера
    @PostMapping("/points")
    public String getCoords(@RequestBody RequestDTO points) throws IOException {
        // Считываем с Базы данных
        List<Coords> coords  = (List<Coords>) coordsRepository.findAll();

        // отбор информации по конкретному устройству
        coords = coords.stream().filter(s -> Objects.equals(s.getDeviceTracker(), points.getDeviceTracker())).collect(Collectors.toList());
        //Сортировка по времени исользуя кампаратор и Collections.sort() от последней переданной трекером точки
        Comparator<Coords> comparator = Comparator.comparing(Coords::getTime);
        Collections.sort(coords, comparator.reversed());
        // выбираем Number- количество точек используя стрим .limit
        coords = coords.stream().limit(points.getNumber()).collect(Collectors.toList());
        String CoordsJSON = new Gson().toJson(coords ); // Конвертируем в json

        return CoordsJSON;
    }

}