/*
让李四去转账
李四:我正在转账，别烦我
李四:我正在转账，别烦我
李四:我正在转账，别烦我
李四:我正在转账，别烦我
李四:我正在转账，别烦我
李四:我正在转账，别烦我
java.lang.InterruptedException: sleep interrupted
main：对方是骗子，赶紧通知李四不要转账了
异常中断
	at java.lang.Thread.sleep(Native Method)
李四:险些误了大事
	at StopThread3$MyRunnable.run(StopThread3.java:9)
	at java.lang.Thread.run(Thread.java:748)

 */
public class StopThread3 {
    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName()+":我正在转账，别烦我");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("异常中断");
                    break;
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
        t.interrupt();  //中断
    }
}
