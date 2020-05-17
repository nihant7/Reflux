package Thread.ThreadDemos;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class AppleWorkerThreads {

    int apples;
    int number;

    public AppleWorkerThreads(int apples) {
        this.apples = apples;
        number = 3;
    }

    public static class PickFruitTask {
        private final AppleWorkerThreads[] appleTrees;
        private final int start;
        private final int end;

        private final int threadShold = 4;

        public PickFruitTask(AppleWorkerThreads[] appleTrees, int start, int end, int threads) {
            this.appleTrees = appleTrees;
            this.start = start;
            this.end = end;
        }



    }

    public int pickApples(String workerName) {
        System.out.printf("Start picking apples from worker thread %s for apple tree %d", workerName, apples);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Started picking apples from worker thread %s for apple tree %d for number of apples", workerName, apples, number);

        return apples;
    }


    public static Callable<Void> createApplePicker(AppleWorkerThreads[] appleTrees, int start, int end, String workerName) {
        return() -> {
            for(int i = start; i < end; i++) {
                appleTrees[i].pickApples(workerName);
            }
            return null;
        };
    }


    public static void main(String[] args) {
        AppleWorkerThreads[] appleTrees = new AppleWorkerThreads[6];

        Callable<Void> applePicker1 = AppleWorkerThreads.createApplePicker(appleTrees, 0,1,"worker1");
        Callable<Void> applePicker2 = AppleWorkerThreads.createApplePicker(appleTrees, 2,3,"worker2");
        Callable<Void> applePicker3 = AppleWorkerThreads.createApplePicker(appleTrees, 4,5,"worker3");

        ForkJoinPool.commonPool().invokeAll(Arrays.asList(applePicker1,applePicker2,applePicker3));


    }
}
