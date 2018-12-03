package singleton;

public class Test {

    public static void main(String[] args) {
        SingletonDemo singletonDemo = SingletonDemo.getInstance();
        SingletonDemo singletonDemo1 = SingletonDemo.getInstance();
        System.out.println(singletonDemo.toString());
        System.out.println(singletonDemo1.toString());
    }

}
