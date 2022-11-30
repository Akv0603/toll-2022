package server.controllers;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.dao.Coords;
import server.repo.CoordsRepository;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import server.dao.Users;
import server.repo.UsersRepository;

@RestController
public class CoordsControllers {
    private static final Logger log = LoggerFactory.getLogger(CoordsControllers.class);
    private Coords dataBase;
    @Autowired
    private CoordsRepository coordsRepository;

// Хранение данных о пользователях
    @Autowired
    private UsersRepository usersRepository;
    private Users users = new Users();

    public void addUsers() {
        if (users != null) {
            List<Users> records = (List<Users>) usersRepository.findAll();
            if (records.size() == 0) { // если таблица пуста, заполняем так.

                users.setFirstName("John");
                users.setLastName("Connor");
                users.setService(1);
                usersRepository.save(users);
                Users users = new Users();
                users.setFirstName("Sarah");
                users.setLastName("Connor");
                users.setService(2);
                usersRepository.save(users);
                Users users1 = new Users();
                users.setFirstName("Terminator");
                users.setLastName("Two");
                users.setService(555);
                usersRepository.save(users1);
            }
        }
    }

    //прием координат POST запросом в виде JSON
    @PostMapping("/coords")
    public String getCoords(@RequestBody PointDTO coords) throws IOException {

        addUsers();

        FileWriter fileCoords =  new FileWriter("d:\\coords.txt", true);
        String CoordsInfo = coords.toJson();
        // вывести координаты в логе
        log.info("Координаты получены: "+ CoordsInfo);
        // И записать в файл
        fileCoords.write(CoordsInfo+"\n");
        fileCoords.close();

        //А теперь записать в базу данных
        dataBase = new Coords();
        dataBase.setLat(coords.getLat());
        dataBase.setLon(coords.getLon());
        dataBase.setAzimuth(coords.getAzimuth());
        dataBase.setInstSpeed(coords.getInstSpeed());
        dataBase.setTime(coords.getTime());
        dataBase.setDeviceTracker(coords.getDeviceTracker());
        coordsRepository.save(dataBase);
        return CoordsInfo;
    }

}
