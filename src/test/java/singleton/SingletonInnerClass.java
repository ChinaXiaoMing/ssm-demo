package singleton;

/**
 * 静态内部类加载
 */
public class SingletonInnerClass {
    private static class InnerClass {
        private static SingletonInnerClass instance = new SingletonInnerClass();
    }

    private SingletonInnerClass() {

    }

    public static SingletonInnerClass getInstance() {
        return InnerClass.instance;
    }

    public static void main(String[] args) {
        SingletonInnerClass singletonInnerClass = SingletonInnerClass.getInstance();
        SingletonInnerClass singletonInnerClass1 = SingletonInnerClass.getInstance();
        System.out.println(singletonInnerClass.toString());
        System.out.println(singletonInnerClass1.toString());
    }

}
