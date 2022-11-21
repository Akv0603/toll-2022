package jdev.tracker.services;

import jdev.dto.PointDTO;
import jdev.tracker.GPS;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by User on 021 21.11.22.
 */
public class StorageServiceTest extends TestCase {
    private PointDTO coords = new PointDTO();
    private GPS gps = new GPS();
    private static BlockingDeque<PointDTO> queue = new LinkedBlockingDeque<>();
// тесты для StorageService о размеру блокирующей очереди
    @Test
    public void testReadGPSCoordinates() throws InterruptedException{
        for(int i = 0; i < 20; i++){
            coords = gps.setCoordinates();
            queue.put(coords);
        }
        assertEquals(20, queue.size());
        coords = null;
        if(queue.size() != 0){
            coords = queue.remove();
        }
        assertEquals(19, queue.size());
    }

}