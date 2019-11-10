/*
NEW             //实例化是NEW阶段
=======================
RUNNABLE        //虽然此处t.start()方法已经调用  但是系统中还是main这个线程优先
RUNNABLE        //所以此时main线程占用CPU的执行权  这个时候t线程就处在就绪队列
.....           //即RUNNABLE阶段   一直打印RUNNABLE   但是main线程的时间片到了  开始执行t线程
RUNNABLE        //但是进来t线程的run()方法后  执行Thread.sleep(500)
TIMED_WAITING   //于是t线程进入TIMED_WAITING阶段   一直打印TIMED_WAITING
TIMED_WAITING   //最后直到t线程死去才从循环中退出来
.....
TIMED_WAITING
=======================
TERMINATED      //终止状态
 */
public class Demo {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t=new MyThread();
        System.out.println(t.getState());
        System.out.println("=======================");
        t.start();
        while(t.isAlive()){
            System.out.println(t.getState());
        }
        System.out.println("=======================");
        System.out.println(t.getState());
    }
}
