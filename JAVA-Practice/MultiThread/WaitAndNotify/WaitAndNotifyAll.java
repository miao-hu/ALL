/*
注意：唤醒线程不能过早，如果当前还没有线程在等待中时（进入等待集），
过早的唤醒线程，这个时候就会出现先唤醒，再等待的效果了。
这样 就没有必要在去运行wait方法了。
 */
class MyThread1 implements Runnable {
    private boolean flag;
    private Object obj;

    public MyThread1(boolean flag, Object obj) {
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
                System.out.println("notifyAll()方法开始.. " + Thread.currentThread().getName());
                obj.notifyAll();
                System.out.println("notifyAll()方法结束.. " + Thread.currentThread().getName());
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

public class WaitAndNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread1 waitThread1 = new MyThread1(true, object);
        MyThread1 waitThread2= new MyThread1(true, object);
        MyThread1 waitThread3 = new MyThread1(true, object);
        MyThread1 notifyThread = new MyThread1(false, object);
        Thread thread1 = new Thread(waitThread1, "wait线程1");
        Thread thread2 = new Thread(waitThread1, "wait线程2");
        Thread thread3 = new Thread(waitThread1, "wait线程3");
        Thread thread4 = new Thread(notifyThread, "notify线程4");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        System.out.println("main方法结束!!");
    }
}

