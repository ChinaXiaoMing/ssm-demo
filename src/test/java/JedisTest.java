public class JedisTest implements Runnable{
    private int number = 20;

    public static void main(String[] args) throws InterruptedException {
        JedisTest jedisTest = new JedisTest();
        Thread thread1 = new Thread(jedisTest);
        Thread thread2 = new Thread(jedisTest);
        Thread thread3 = new Thread(jedisTest);
        thread1.start();
        thread2.start();
        thread3.start();
    }


    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    if (number > 0) {
                        System.out.println(Thread.currentThread().getName() + ":剩余票数" + number);
                        number--;
                        System.out.println(Thread.currentThread().getName() + ":卖出一张，剩余票数" + number);
                        Thread.sleep(1000);
                    } else {
                        System.out.println(Thread.currentThread().getName() + ":余票不足，停止售票");
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
