package factory;

public class BMW523Factory implements Factory {
    @Override
    public BMW createCar() {
        return new BMW523();
    }
}
