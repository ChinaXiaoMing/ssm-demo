package decorator;

public class ChickenHurger extends Humburger {

    public ChickenHurger() {
        name = "鸡腿堡";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
