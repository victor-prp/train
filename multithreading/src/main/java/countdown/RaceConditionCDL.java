package countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author victorp
 */
public class RaceConditionCDL implements Runnable {
    private static long counter;
    private static final int tCount = 100;
    private static final CountDownLatch countDownLatch = new CountDownLatch(tCount);

    public  void  run() {
        synchronized (RaceConditionCDL.class) {
            for (int i = 0; i < 100; i++) {
                counter++;
            }
        }
        countDownLatch.countDown();
    }


    public static void main(String[] args) throws InterruptedException {
        int tCount = 100;
        Thread[] threads = new Thread[tCount];
        for (int j = 0; j < tCount; j++) {
            threads[j] = new Thread(new RaceConditionCDL());
            threads[j].start();
        }

        countDownLatch.await();
        System.out.println("Counter: " + counter);

    }
}