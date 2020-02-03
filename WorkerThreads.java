import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThreads implements Runnable {

    private final String name;

    WorkerThreads (String name) {
        this.name = name;
    }


    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Implement the iteration : " + i + " with " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {

        WorkerThreads wt1 = new WorkerThreads("t1");
        WorkerThreads wt2 = new WorkerThreads("t2");
        WorkerThreads wt3 = new WorkerThreads("t3");

        ExecutorService es = Executors.newFixedThreadPool(5);

        es.execute(wt1);
        es.execute(wt2);
        es.execute(wt3);

        es.shutdown();
    }
}
