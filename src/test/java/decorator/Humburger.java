package decorator;

public abstract class Humburger {

    protected String name;

    public String getName() {
        return this.name;
    }

    public abstract double getPrice();

}
