package atomic;



public class Main {
    private long val = 0;

    public long getVal() {
        if (val == 0) {
            val = Long.MAX_VALUE;
        } else {
            val = 0;
        }
        return val;
    }

    public static void main(String[] args) {
        final Main main = new Main();
        Runnable r = new Runnable() {
            public void run() {
                while (true) {
                    long val = main.getVal();
                    if (val != 0 && val != Long.MAX_VALUE) {
                        System.out.println(Long.toBinaryString(val));
                    }
                }
            }
        };


        new Thread(r).start();
        new Thread(r).start();
    }
}
