package jdev.serverUi;

import jdev.dto.PointDTO;

/**
 * Created by User on 029 29.09.22.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 3; i++){
            System.out.println("Hello server-ui Main.main");
            PointDTO point = new PointDTO();
            point.setLat(60);
            System.out.println(point.toJson());
            Thread.sleep(500);
        }
    }
}
