package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolA {
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(10);
        service.execute(new A());
        service.execute(new A());
        service.execute(new A());
        service.execute(new A());

    }
}
class A implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
