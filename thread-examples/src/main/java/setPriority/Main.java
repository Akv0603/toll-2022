package setPriority;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;
import static java.lang.Thread.NORM_PRIORITY;

//демонстрация работы с PRIORITY
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExThreads threads1 = new ExThreads("Min", MIN_PRIORITY);
        ExThreads threads2 = new ExThreads("Max", MAX_PRIORITY);
        ExThreads threads3 = new ExThreads("Morm", NORM_PRIORITY);

        threads1.start();
        threads2.start();
        threads3.start();
    }
}
