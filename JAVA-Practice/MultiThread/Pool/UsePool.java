package pool;
/*
我是第一个线程
我是第一个线程
我是第一个线程
我是第一个线程
我是第一个线程
......
 */
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsePool {
    public static void main(String[] args) {
        //public interface ExecutorService extends Executor
        //Executors工具包：创建并返回一个ExecutorService设置的常用的配置设置的方法。
        ExecutorService pool= Executors.newFixedThreadPool(1);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("我是第一个线程");
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("我是第二个线程");
                }
            }
        });
    }
}
