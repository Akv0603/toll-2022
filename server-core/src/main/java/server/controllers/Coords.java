package server.controllers;

import jdev.dto.PointDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by User on 007 07.11.22.
 */
@RestController
public class Coords {
    private static final Logger log = LoggerFactory.getLogger(Coords.class);

//прием координат POST запросом в виде JSON
    @PostMapping("/coords")
    public PointDTO getCoords(@RequestBody PointDTO coords) throws IOException {
        FileWriter fileCoords =  new FileWriter("d:\\coords.txt", true);
        String CoordsInfo = coords.toJson();
        // вывести координаты в логе
        log.info("Координаты получены: "+ CoordsInfo);
        // И записать в файл
        fileCoords.write(CoordsInfo+"\n");
        fileCoords.close();
        return coords;
    }

}
