package setPriority;


import java.util.Date;

public class ExThreads extends Thread {

    public ExThreads(String name, int priority) {
        this.setName(name);
        this.setPriority(priority);
    }

    @Override
    public void run() {
        for (int i=0; i<20 ; i++)
            System.out.println((new Date()).toString() + " : "+ Thread.currentThread().getName() + ": START");
    }
}
