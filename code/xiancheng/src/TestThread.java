public class TestThread extends Thread{
    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"--我在看代码"+i);
        }
    }

    public static void main(String[] args) {
        //main
      TestThread a=new TestThread("我是一号");
        a.start();
        for (int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"-------"+i);
        }
    }
}
