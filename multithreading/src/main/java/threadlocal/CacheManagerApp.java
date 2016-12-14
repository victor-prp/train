package threadlocal;

/**
 * @author victorp
 */
public class CacheManagerApp {

    public static void main(String[] args) throws InterruptedException {

        Runnable r = new Runnable() {
            public void run() {
                while (true) {
                    CacheManager.put("1",currentThreadName());
                    sleep(5);
                    if (!CacheManager.get("1").equals(currentThreadName())){
                        System.out.println("Impossible!!!!");
                    }
                }
            }
        };


        for (int j = 0; j < 100; j++) {
            new Thread(r).start();
        }
    }

    private static String currentThreadName() {
        return Thread.currentThread().getName();
    }

    private static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

