package Lockaaa;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 a=new TestLock2();
        new Thread(a).start();
        new Thread(a).start();
        new Thread(a).start();
    }
}
class TestLock2 implements Runnable{
    static  int tick=10;
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if(tick>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tick--);
                }else {
                    break;
                }

            }finally {
                lock.unlock();
            }

        }
    }
}
