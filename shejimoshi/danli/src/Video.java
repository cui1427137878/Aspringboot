public class Video {
    //单例模式,不允许你自己去创建类的实例，只能通过调用方法
    ////必须加static，静态方法不允许调用非静态的东西
    public void test2(){

    }

    public static void main(String[] args) {
        Recyle rec=Recyle.getInstance();
        rec.delete("视频文件");
    }
}
