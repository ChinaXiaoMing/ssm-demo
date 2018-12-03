package Prototype;

public class TestPrototype {

    public static void main(String[] args) {

        ConcretePrototype concretePrototype = new ConcretePrototype();
        for (int i = 0; i < 10; i++) {
            ConcretePrototype concretePrototype1 = (ConcretePrototype) concretePrototype.clone();
            concretePrototype1.show();
        }

    }

}
