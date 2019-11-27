package pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
提前不启动线程，来个任务再启动线程，最多启动5个
阻塞队列   记录当前线程对象个数   记录所有线程对象   最多线程个数
 */
public class ThreadPoolV3 {
    private BlockingQueue<Runnable> queue=new ArrayBlockingQueue<>(10);
    private int maxThreads=5;
    private int currentThreads=0;
    private Thread[] worker=new Thread[maxThreads];

    public void execute(Runnable task) throws InterruptedException {
        if(currentThreads==maxThreads){   //线程满了，将任务放到队列
            queue.put(task);
        }else{  //线程数没有达到最大，启动一个新的线程来完成这个任务
            Worker w=new Worker(queue);
            worker[ currentThreads++]=w;
            w.start();
            queue.put(task);
        }
    }

    private static class Worker extends Thread{
        private BlockingQueue<Runnable> queue;
        public Worker(BlockingQueue<Runnable> queue){
            this.queue=queue;
        }

        @Override
        public void run() {
            while(!isInterrupted()){
                try {
                    Runnable task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolV pool = new ThreadPoolV();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是第一个任务");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是第二个任务");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是第三个任务");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是第四个任务");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是第五个任务");
            }
        });
    }
    /*
    我是第一个任务
    我是第二个任务
    我是第三个任务
    我是第四个任务
    我是第五个任务
     */
}
