package Thread.ThreadDemos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
    public static void main(String[] args) {

        Runnable task = () -> System.out.println("Created new thread : " + Thread.currentThread().getName());

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            pool.execute(task);
        }
            pool.shutdown();

    }
}
