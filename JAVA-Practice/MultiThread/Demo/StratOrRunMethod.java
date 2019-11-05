/*
    创建一个线程后要调用它的start()方法
    不要调用它的run()方法
     这个程序若调用run()方法   那么只打印MyThread
     若调用start()方法    Main和MyThread交替打印
 */
public class StratOrRunMethod {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("MyThread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();  //不能使用t.run()方法
        while(true){
            System.out.println("Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
