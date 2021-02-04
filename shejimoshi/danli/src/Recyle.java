public class Recyle {
    //必须加static，静态方法不允许调用非静态的东西
    private static Recyle recyle=new Recyle();
    private Recyle(){}

    //必须加，因为构造方法加了private，只能通过Recyle.getInstace调用，来实例化这个类。
    public static Recyle getInstance(){
        return recyle;
    }
    public void delete(String delete){
        System.out.println(delete+"已经被处理");
    }
}
