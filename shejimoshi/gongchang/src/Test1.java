public class Test1 {
    public static void main(String[] args) {
        IteaFactory factory=new LongjingTeaFactory();
        Tea tea = factory.createTea();
        tea.makeTea();
    }
}
