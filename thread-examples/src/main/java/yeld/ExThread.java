package yeld;

import java.util.Date;

public class ExThread extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10 ; i++)
            System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + " - started");
    }
}
