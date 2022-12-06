package joinTimeOut;

import java.util.Date;

//флажок с join() (time out) демонстрация

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExThread thread1 = new ExThread();
        ExThread thread2 = new ExThread();

        thread1.start();

        System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + " - ждём завершения");

        thread1.join(500);

        System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + " - дождались!!!");

        thread2.start();
    }
}
