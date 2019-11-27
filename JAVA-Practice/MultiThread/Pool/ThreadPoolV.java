package pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//固定线程池，一开始是就申请好线程，假设有5个线程
public class ThreadPoolV {
    //阻塞队列，存放任务
    private BlockingQueue<Runnable> queue=new ArrayBlockingQueue<>(10);
    //创建5个线程
    private Thread[] worker=new Thread[5];

    public ThreadPoolV(){
        for(int i=0;i<5;i++){
            worker[i]=new Worker(queue);
            worker[i].start(); //线程启动
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

    public void execute(Runnable task) throws InterruptedException {
        queue.put(task);
    }

    public void stop(){
        for(int i=0;i<5;i++){
            worker[i].interrupt();//线程中断
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolV pool=new ThreadPoolV();
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

        /*
        我是第一个任务
        我是第二个任务
        我是第三个任务
        我是第四个任务
        我是第五个任务
         */
    }
}
