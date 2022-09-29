package jdev.tracker;

import jdev.dto.PointDTO;

/**
 * Created by User on 029 29.09.22.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i <=3; i++){
            System.out.println("tracker-core Main.main");
            PointDTO point = new PointDTO();
            point.setLat(50);
            System.out.println(point.toJson());
            Thread.sleep(500);
        }
    }
}
