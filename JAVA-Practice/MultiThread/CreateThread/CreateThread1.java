public class CreateThread1 {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            // 让该线程去做的事情
        }
    }

    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            // 让该线程去做的事情
        }
    }

    public static void main(String[] args) {
        // 创建好了 Thread 的对象，(描述)
        Thread t1=new MyThread();
        Thread t2=new Thread(new MyThread());
        Thread t3=new Thread(new MyRunnable());

        // 启动线程
        t1.start();
        t2.start();
        t3.start();

        // 常见的方法-继承 Thread (匿名类)
        Thread t4=new MyThread(){
            @Override
            public void run() {
                // 覆写 run 方法的代码
            }
        };

        // 常见的方法-继承 Thread (匿名类)
        Thread t5= new Thread() {
            @Override
            public void run() {
                // 覆写 run 方法的代码
            }
        };

        // 常见的方法-继承 Runnable (匿名类)
        Thread t6=new Thread(new MyRunnable(){
            @Override
            public void run() {
                // 覆写 run 方法的代码
            }
        });

        // 常见的方法-继承 Thread (lambda)
        Thread t7 = new Thread(() -> {
            // 覆写 run 方法的代码
        });

    }
}
