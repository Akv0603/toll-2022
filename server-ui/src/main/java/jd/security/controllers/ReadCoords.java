package jd.security.controllers;

import jd.security.dao.Coords;
import jd.security.services.CoordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReadCoords {
    @Autowired
    CoordsService coordsService;

    @GetMapping("/table")
    public String readCoordinates(Model model){
        List<Coords> list = (List< Coords>) coordsService.getCoords();
        model.addAttribute("coords", list);
        return "table";

    }
}
