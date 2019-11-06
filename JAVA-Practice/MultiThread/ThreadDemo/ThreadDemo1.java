/*
    两个死循环可以同时开始执行，没有一个卡住另一个的情况
    没有出现   只打印  我在方法1中打印
    而不出现 我在main方法中打印  这种情况
    即run()方法中的while()循环不影响
 */
/*
    父类的方法没有抛出异常，那么子类的方法也不能抛出异常 ，但是子类的异常必须捕获
    jconsole
    每个线程都有自己独立的栈结构
 */
/*
    没有创建线程的时候   等待状态什么都不能干
    有线程的时候   等待状态还可以计算其他的
 */
public class ThreadDemo1 {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("我在方法1中打印");
                try{
                    Thread.sleep(1000);// 进程会暂停运行 1 秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        method1();
        while(true){
            System.out.println("我在main方法中打印");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void method1() {
        Thread t=new MyThread();
        t.start();
    }
}
