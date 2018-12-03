package factory;

public class BMW320Factory implements Factory {
    @Override
    public BMW createCar() {
        return new BMW320();
    }
}
