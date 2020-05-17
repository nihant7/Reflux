package Thread.ThreadDemos;

import sun.nio.ch.ThreadPool;

import java.util.HashMap;

public class ThreadWork extends Thread {
    int i = 0;
    public void run() {
        synchronized(this) {
            for(i = 0; i < 100; i++) {
                i+=1;
                notify();
            }
        }
    }


    public static void main(String[] args) {
        ThreadWork t = new ThreadWork();

        t.start();
        synchronized (t) {
            try {
                t.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total Sum : " + t.i);


    }
}
