public class JconsoleDemo {
    private static Object object=new Object();

    private static class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object){
                try {
                    Thread.sleep(100_000_0000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread();
        t.start();
        Thread.sleep(100);
        synchronized (object){
            System.out.println("加锁成功");
        }
        /*
        名称:Thread-0
        状态: TIMED_WAITING
        总阻止数: 0, 总等待数: 1
        堆栈跟踪:
                    java.lang.Thread.sleep(Native Method)
                    JconsoleDemo$MyThread.run(JconsoleDemo.java:9)
                    - 已锁定 java.lang.Object@40ff57ad
         */
        /*
        名称: main
        状态: java.lang.Object@40ff57ad上的BLOCKED, 拥有者: Thread-0
        总阻止数: 1, 总等待数: 1
        堆栈跟踪:
                JconsoleDemo.main(JconsoleDemo.java:22)

         */
    }
}
