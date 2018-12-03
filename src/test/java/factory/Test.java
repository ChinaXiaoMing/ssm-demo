package factory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

    private void hello() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }, 2L, TimeUnit.SECONDS);
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        AbstractFactory factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createAircondition();
        factoryBMW320.createEngine();
        AbstractFactory factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createEngine();
        factoryBMW523.createAircondition();
        Test test = new Test();
        test.hello();
    }

}
