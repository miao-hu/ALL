/*
    继承Thread可以不覆写run()方法
    但是实现Runnable接口必须实现run()方法

    Thread  可以使用this
    Runnable   不可以使用this
 */
public class UseThreadFields {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            Thread current=Thread.currentThread();//返回当前进程的引用
            System.out.println(current.getId());
            System.out.println(current.getName());  //得到进程的名字
            System.out.println(current.getState()); //得到进程的状态
            System.out.println(current.getPriority());  //得到进程的优先级
            System.out.println(this.isAlive());      //是否存活
            System.out.println(this.isDaemon());      //是否后台线程
            System.out.println(this.isInterrupted());  //是否被中断
        }
    }
    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            Thread current=Thread.currentThread();//返回当前进程的引用
            System.out.println(current.getId());
            System.out.println(current.getName());
            System.out.println(current.getState());
            System.out.println(current.getPriority());
            System.out.println(current.isAlive());
            System.out.println(current.isDaemon());
            System.out.println(current.isInterrupted());
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        Thread t=new Thread(new MyRunnable());
        t.start();
    }
}
