/*
通过共享标记来中断一个线程
 */
public class StopThread1 {
    private static class MyRunnable implements Runnable{
        private volatile boolean isQuit=false;
        @Override
        public void run() {
            while(!isQuit){
                System.out.println(Thread.currentThread().getName()+":我正在转账，别烦我");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":险些误了大事");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable=new MyRunnable();
        Thread t=new Thread(myRunnable,"李四");
        System.out.println("让李四去转账");
        t.start();
        Thread.sleep(6*1000);
        System.out.println(Thread.currentThread().getName()+"：对方是骗子，赶紧通知李四不要转账了");
        myRunnable.isQuit=true;
    }
}
