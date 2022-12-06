package joinTimeOut;

import java.util.Date;

public class ExThread extends Thread{
    @Override
    public void run() {
        System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + " - start");
        super.run();
        for(int i=0; i<1000; i++)
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + " - finish");
    }
}
