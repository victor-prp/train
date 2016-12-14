package racecond;


public class RaceCondition implements Runnable {
    private static long counter;

    public  void  run() {
        //synchronized(RaceCondition.class)
        {
            for (int i = 0; i < 100; i++) {
                counter = counter + 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int tCount = 1000;
        Thread[] threads = new Thread[tCount];
        for (int j = 0; j < tCount; j++) {
            threads[j] = new Thread(new RaceCondition());
            threads[j].start();
        }

        for (int j = 0; j < tCount; j++) {
            threads[j].join();
        }

        System.out.println("Counter: "+counter);

    }
}