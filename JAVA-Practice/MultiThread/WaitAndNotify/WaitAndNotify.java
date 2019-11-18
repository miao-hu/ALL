 /*
 从结果上来看第一个线程执行的是一个waitMethod方法，
 该方法里面有个死循环并且使用了wait方法进入等待状态
将释放锁，如果这个线程不被唤醒的话将会一直等待下去，
这个时候第二个线程执行的是notifyMethod方法，该方
法里面执行了一个唤醒线程的操作，
并且一直将notify的同步代码块执行完毕之后才会释放锁然后继续执行wait结束
打印语句。
  */
class MyThread implements Runnable {
    private boolean flag;
    private Object obj;

    public MyThread(boolean flag, Object obj) {
        super();
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod() {
        synchronized (obj) {
            try {
                while (true) {
                     System.out.println("wait()方法开始.. " + Thread.currentThread().getName());
                      obj.wait();
                     System.out.println("wait()方法结束.. " + Thread.currentThread().getName());
                      return;
               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void notifyMethod() {
        synchronized (obj) {
            try {
                System.out.println("notify()方法开始.. " + Thread.currentThread().getName());
                obj.notify();
                System.out.println("notify()方法结束.. " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread waitThread = new MyThread(true, object);
        MyThread notifyThread = new MyThread(false, object);
        Thread thread1 = new Thread(waitThread, "wait线程");
        Thread thread2 = new Thread(notifyThread, "notify线程");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        System.out.println("main方法结束!!");
    }
}

