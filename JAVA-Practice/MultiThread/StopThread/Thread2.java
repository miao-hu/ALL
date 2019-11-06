/*
true             // 只有一开始是 true，后边都是 false，因为标志位被清(置false)
false
false
false
false
false
false
false
false
false

 */
public class Thread2 {
    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(Thread.interrupted());
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
