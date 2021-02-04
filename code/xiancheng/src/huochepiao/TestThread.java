package huochepiao;

public class TestThread implements Runnable{
    private static int tickNumber=10;
    @Override
    public void run() {
     while (tickNumber>0){
         synchronized (this){
         try {
             Thread.sleep(10);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName()+"抢到了票，还剩下"+tickNumber--+"张票");
        }
     }
    }

    public static void main(String[] args) {
        TestThread ticket=new TestThread();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小张").start();

    }
}
