/*
true    //全部为true,因为标志位没有被清
true
true
true
true
true
true
true
true
true
 */

public class Thread3 {
    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable=new MyRunnable();
        Thread t=new Thread(myRunnable,"李四");
        t.start();
        t.interrupt();
    }
}
