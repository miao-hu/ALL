/*
线程调度可以发生在任一时刻
 */
public class NWaitDemo {
    private static Object o = new Object();
    private static int n = 0;

    private static class Sub extends Thread {
        Sub() {
            super("n--线程");
        }

        @Override
        public void run() {
            while (true) {
                synchronized (o) {
                    if (n == 0) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    n--;
                    System.out.println(getName() + ":" + n);
                    o.notify();  //这里这样写是因为本来就在代码块
                                 //所以不需要再来一个代码块
                }
            }
        }
    }

    private static class Add extends Thread {
        Add() {
            super("n++线程");
        }

        @Override
        public void run() {
            while (true) {
                synchronized (o) {
                    if (n == 10) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    n++;
                    System.out.println(getName() + ":" + n);
                    o.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new Add();
        Thread b = new Sub();
        a.start();
        b.start();
    }
}
