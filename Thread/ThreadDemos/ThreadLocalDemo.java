package Thread.ThreadDemos;

public class ThreadLocalDemo implements Runnable {

    ThreadLocal<Integer> local = new ThreadLocal<>();
    ThreadLocal<Integer> local_new = new ThreadLocal<>();




    public void run() {
        local.set( (int) (Math.random() * 50D) );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(local.get());

    }

    public static void main(String[] args) throws InterruptedException {

        ThreadLocalDemo tld = new ThreadLocalDemo();

        Thread t1 = new Thread(tld);
        Thread t2 = new Thread(tld);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
