/*
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at Thread1$MyRunnable.run(Thread1.java:7)
	at java.lang.Thread.run(Thread.java:748)
通过异常的形式中断
false                          // 通过异常收到中断通知，并且标志位被清，置为false
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
public class Thread1 {
    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //打印异常调用栈信息
                System.out.println("通过异常的形式中断");
            }
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
