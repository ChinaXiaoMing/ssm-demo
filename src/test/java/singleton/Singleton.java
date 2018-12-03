package singleton;

/**
 * 饿汉模式
 */
public class Singleton {
    private static Singleton singleton = null;

    static {
        singleton = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getSingleton() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton.toString());
        System.out.println(singleton1.toString());
    }

}
