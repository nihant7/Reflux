import sun.nio.ch.ThreadPool;

import java.util.concurrent.ExecutorService;

public class Matrix {

    public int fib(int n) {

        if(n <= 1) return n;

        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        System.out.println(m.fib(2));
    }
}





