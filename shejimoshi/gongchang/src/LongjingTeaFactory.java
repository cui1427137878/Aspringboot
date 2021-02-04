public class LongjingTeaFactory implements IteaFactory {
    @Override
    public Tea createTea() {
        return new LongjingTea();
    }
}
