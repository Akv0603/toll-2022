package yeld;

import java.util.Date;

// флажок с yield(); демонстрация
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("НАЧАЛО ТЕСТА БЕЗ YELD");
        ExThread thread1 = new ExThread();
        thread1.start();

        for (int i=0; i<10; i++)
        {
            System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + " - started");
        }

        thread1.join();
        System.out.println("1.КОНЕЦ ТЕСТА БЕЗ YELD ");



        System.out.println("НАЧАЛО ТЕСТА С YELD");
        ExThread thread2 = new ExThread();
        thread2.start();

        for (int i=0; i<10; i++)
        {
            Thread.yield();
            System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + " - started");
        }

        thread2.join();
        System.out.println("КОНЕЦ ТЕСТА С YELD");
    }
}
