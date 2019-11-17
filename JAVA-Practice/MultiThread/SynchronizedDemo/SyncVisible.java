public class SyncVisible {
    public static int n  = 0;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10_0000; i++) {
                //保证了原子性
                synchronized (SyncVisible.class){
                    n++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 10_0000; i++) {
            //保证了原子性
            synchronized (SyncVisible.class){
                n--;
            }
        }
        thread.join();
        System.out.println(n);
    }
}
