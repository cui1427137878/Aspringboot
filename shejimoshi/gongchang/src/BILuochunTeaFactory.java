public class BILuochunTeaFactory implements IteaFactory {
    @Override
    public Tea createTea() {
        return new biluochun();
    }
}
